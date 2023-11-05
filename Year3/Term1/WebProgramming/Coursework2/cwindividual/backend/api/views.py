from django.shortcuts import render
from django.http import JsonResponse, HttpResponse
from .models import Element
from django.views.decorators.csrf import csrf_exempt
from django.core.handlers.wsgi import WSGIRequest
import json

def test_api_view(request):
    """
    A simple test API view that returns a JSON response.

    Args:
        request (WSGIRequest): The HTTP request object.

    Returns:
        JsonResponse: A JSON response with a message.
    """
    return JsonResponse({"message": "Good response!"})

@csrf_exempt
def elements(request: WSGIRequest):
    """
    View for retrieving a list of elements or creating a new element.

    Args:
        request (WSGIRequest): The HTTP request object.

    Returns:
        JsonResponse: A JSON response with a list of elements (GET request) or a success/error message (POST request).
    """
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
    """
    View for updating or deleting an element by its primary key (id).

    Args:
        request (WSGIRequest): The HTTP request object.
        pk (int): The primary key of the element to be updated or deleted.

    Returns:
        JsonResponse: A JSON response with a success/error message for element update (PUT) or deletion (DELETE).
    """
    if request.method == "PUT":
        try:
            product = Element.objects.get(pk=pk)
            data = json.loads(request.body)
        except Exception as e:
            return JsonResponse({"message":f"ID:{pk} Not in Database or Bad Data Sent in PUT", "data": str(request.body)}, status=404)
        data = json.loads(request.body)
        print(f"Making Edits to person id:{pk} with data {data}")
        name = data.get("name")
        description = data.get("description")
        price = data.get("price")
        available = data.get("available")

        if name and description and price and available:
            product.name = name
            product.description = description
            product.price = price
            product.is_available = available
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
