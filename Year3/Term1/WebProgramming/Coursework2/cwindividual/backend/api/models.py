from django.db import models

class Element(models.Model):
    """
    Represents an element in the system.

    Attributes:
        name (str): The name of the element.
        description (str): A detailed description of the element.
        price (Decimal): The price of the element.
        is_available (bool): Indicates whether the element is available for purchase.

    Methods:
        __str__(): Returns a string representation of the element, which is its name.

    """
    name = models.CharField(max_length=100)
    description = models.TextField()
    price = models.DecimalField(max_digits=10, decimal_places=2)
    is_available = models.BooleanField(default=True)

    def __str__(self):
        return self.name
