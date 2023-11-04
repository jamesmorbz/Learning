from django.shortcuts import render
from django.http import JsonResponse, HttpResponse
from .models import Element
from django.views.decorators.csrf import csrf_exempt
from django.core.handlers.wsgi import WSGIRequest
import json


def test_api_view(request):
    return JsonResponse({"message": "Good response!"})


@csrf_exempt
def elements(request: WSGIRequest):
    if request.method == "GET":
        products = Element.objects.all()
        data = [
            {
                "id": product.pk,
                "name": product.name,
                "description": product.description,
                "price": product.price,
                "is_available": product.is_available,
            }
            for product in products
        ]
        return JsonResponse(data, safe=False)

    elif request.method == "POST":
        data = json.loads(request.body)
        name = data.get("name")
        description = data.get("description")
        price = data.get("price")
        is_available = data.get("available")

        print(
            f"got data going to create a new product {name} {description} {price} {is_available}"
        )
        if (
            name is not None
            and description is not None
            and price is not None
            and is_available is not None
        ):
            product = Element.objects.create(
                name=name,
                description=description,
                price=price,
                is_available=is_available,
            )
            return JsonResponse({"message": "Element created successfully."})
        else:
            return JsonResponse(
                {
                    "message": "Incomplete data. Please provide name, description, price, and is_available."
                },
                status=400,
            )


@csrf_exempt
def update_element(request: WSGIRequest, pk):
    if request.method == "PUT":
        try:
            product = Element.objects.get(pk=pk)
        except Element.DoesNotExist:
            return JsonResponse(status=404)

        name = request.data.get("name")
        description = request.data.get("description")
        price = request.data.get("price")
        is_available = request.data.get("is_available")

        if name and description and price and is_available:
            product.name = name
            product.description = description
            product.price = price
            product.is_available = is_available
            product.save()
            return JsonResponse({"message": "Element updated successfully."})
        else:
            return JsonResponse(
                {
                    "message": "Incomplete data. Please provide name, description, price, and is_available."
                },
                status=400,
            )

    elif request.method == "DELETE":
        try:
            product = Element.objects.get(pk=pk)
        except Element.DoesNotExist:
            return JsonResponse(status=404)

        product.delete()
        return JsonResponse({"message": "Element deleted successfully."})
