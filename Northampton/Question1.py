import datetime
import logging
import random
import collections

class Customer:
    def __init__(self, name: str, phone: str, email: str):
        self.name: str = name
        self.phone: str = phone
        self.email: str = email

    @property
    def name(self):
        return self._name
    
    @property
    def phone(self):
        return self._phone

    @property
    def email(self):
        return self._email

    @name.setter
    def name(self, new_name):
        self._name = new_name

    @phone.setter
    def phone(self, new_phone):
        self._phone = new_phone

    @email.setter
    def email(self, new_email):
        self._email = new_email

class Stock:
    def __init__(self, book_name: str, author: str, price: float):
        self.book_name: str = book_name
        self.author: str = author
        self.price: float = price

    @property
    def book_name(self):
        return self._book_name

    @property
    def author(self):
        return self._author

    @property
    def price(self):
        return self._price

    @book_name.setter
    def book_name(self, new_book_name):
        self._book_name = new_book_name

    @author.setter
    def author(self, new_author):
        self._author = new_author

    @price.setter
    def price(self, new_price):
        self._price = new_price

class Order:
    def __init__(self, customer: Customer, stock: Stock):
        self.customer: Customer = customer
        self.stock: Stock = stock

    @property
    def customer(self):
        return self._customer

    @property
    def stock(self):
        return self._stock

    @customer.setter
    def customer(self, new_customer):
        self._customer = new_customer

    @stock.setter
    def stock(self, new_stock):
        self._stock = new_stock

class Shipping:
    urgent_cost: float = 5.45
    basic_cost: float  = 5.45
    count_urgent: int = 0
    def __init__(self, order: Order, ship_date: datetime):
        self.order: Order = order
        self.ship_date: datetime = ship_date
        self.ship_cost: int = 0

    def set_ship_cost(self, ship_cost: float):
        self.ship_cost = ship_cost

    def calc_ship_cost(self, is_urgent: bool):
        if is_urgent:
            self.ship_cost = self.urgent_cost
            self.add_urgent_shipment()
        else:
            self.ship_cost = self.basic_cost
        return self.ship_cost

    def add_urgent_shipment(self):
        self.count_urgent += 1

    @property
    def ship_date(self):
        return self._ship_date

    @property
    def ship_cost(self):
        return self._ship_cost

    @ship_date.setter
    def ship_date(self, new_ship_date):
        self._ship_date = new_ship_date

    @ship_cost.setter
    def ship_cost(self, new_ship_cost):
        self._ship_cost = new_ship_cost

class Invoice:
    def __init__(self, invoice_nbr: str, stock: Stock, ship_order: Shipping):
        self.invoice_nbr: str = invoice_nbr
        self.stock: Stock = stock
        self.ship_order: Shipping = ship_order
        self.total_cost: int = 0

    def invoice(self):
        self.total_cost = self.stock.price + self.ship_order.ship_cost
        return self.total_cost

    @property
    def invoice_nbr(self):
        return self._invoice_nbr

    @invoice_nbr.setter
    def invoice_nbr(self, new_invoice_nbr):
        self._invoice_nbr = new_invoice_nbr

class BookStore:
    def __init__(self):
        self.invoices: list[Invoice] = []

    def get_invoices(self):
        return self.invoices

    def search_invoice(self, nbr: str):
        for invoice in self.invoices:
            if invoice.invoice_nbr == nbr:
                return invoice
        else:
            print("Invoice not found")

    def find_all_invoices(self):
        return self.invoices

    @property
    def invoices(self):
        return self._invoices

    @invoices.setter
    def invoices(self, new_invoices):
        self._invoices = new_invoices

class Test:
    def main():
        logging.info("Creating 3 Test Customer Objects")
        customer1 = Customer("Mike", "".join([str(random.randint(0, 9)) for _ in range(0, 11)]), "mike@gmail.com")
        customer2 = Customer("Alice", "".join([str(random.randint(0, 9)) for _ in range(0, 11)]), "alice@hotmail.co.uk")
        customer3 = Customer("Bob", "".join([str(random.randint(0, 9)) for _ in range(0, 11)]), "bobb@btinternet.com")

        logging.info("Creating 3 Test Stock Objects")
        stock1 = Stock("A Christmas Carol", "Charles Dickens", 2.73)
        stock2 = Stock("To Kill a Mockingbird", "Harper Lee", 8.16)
        stock3 = Stock("The Great Gatsby", "F. Scott Fitzgerald", 57.17)

        logging.info("Creating 3 Test Order Objects")
        order1 = Order(customer1, stock1)
        order2 = Order(customer2, stock2)
        order3 = Order(customer3, stock3)

        logging.info("Creating 3 Test Shipping Objects")
        shipping1 = Shipping(order1, datetime.date.today())
        shipping2 = Shipping(order2, datetime.date.today())
        shipping3 = Shipping(order3, datetime.date.today())
 
        shipping1.set_ship_cost(shipping1.calc_ship_cost(True))
        shipping2.set_ship_cost(shipping2.calc_ship_cost(False))
        shipping3.set_ship_cost(shipping3.calc_ship_cost(True))
 
        invoice1 = Invoice("INV0001", stock1, shipping1)
        invoice2 = Invoice("INV0002", stock2, shipping2)
        invoice3 = Invoice("INV0003", stock3, shipping3)

        logging.info("Creating a Bookstore")
        bookstore = BookStore()
 
        bookstore.invoices.append(invoice1)
        bookstore.invoices.append(invoice2)
        bookstore.invoices.append(invoice3)
 
        print(f"Number of urgent shipments: {shipping1.count_urgent}")
        print(f"Invoice 1 total cost: {invoice1.invoice():.2f}")
        print(f"Invoice 2 total cost: {invoice2.invoice():.2f}")
        print(f"Invoice 3 total cost: {invoice3.invoice():.2f}")
 
        assert bookstore.search_invoice("INV0004") is None
        assert shipping1.count_urgent == 1
        assert len(bookstore.invoices) == 3


if __name__ == "__main__":
    Test.main()