# ecommerce_system_simulator

This Ecommerce System Simulator sells numerous types of products to registered customers. Customers can order a product of their choice and the system will help ship it to them. In addition, registered users, active orders, and shipped orders are all tracked by the system.

This system allows you to order products, such as shoes, books, clothing, furniture, computers etc. Products can then be shipped once ordered and can even be cancelled. I also added a Cart feature where each customer possesses their own cart, where they can add products, remove products from their cart and then order all products in their cart.

The ECommerceUserInterface is the class with the main() method and is the user interaction part.

Some of the commands or actions are: 

PRODs: Gives you access to the list of products available to customers. 

CUSTS: Lists all the registered customers. 

BOOKS : Lists all books. 

ORDERS: Lists all product orders. 

SHIPPED: Lists all orders that have been shipped. 

NEWCUSTS: Creates a new registered customer, must provide a name and address. 

SHIP: Ships an order to the customer, must provide the orderNumber. 

CUSTORDERS: Lists shipped and current orders, must provide a customerId. 

ORDERS: Orders a product for a particular customer, must provide a productId and customerId. 

ORDERBOOK: Orders a book for a customer, must provide a productId, customerId, and format (Paperback, Hardcover or EBook).  

ORDERSHOES: Orders shoes for a customer, must provide a productId, customerId, and options (Size: 6,7,8,9,10 & Color: Black or Brown). 

CANCEL: Cancels an existing orders, must provide an orderNumber. 

PRINTBYPRICE: Sorts products by price. 

PRINTNAME: Sorts products by name. 

SORTCUSTS: Sorts customers by name.

BOOKSBYAUTHOR: Lists all books by a certain author, must provide author's name. 

ADDTOCART: Adds a product to the customer's cart, must provide a productId, customerId, and productOptions. 
Note: ProductOptions is only valid when ordering a book or shoes. If you are not ordering a book/shoes then you can leave the productOption blank.

PRINTCART: Prints all the products in a customer's cart, must provide a customerId. 

REMCARTITEM: Removes a product from a customer's cart, must provide a customerId and productId. 

ORDERIITEMS: Orders each product inside the customer's cart, must provide a customerId. 

STATS: Keeps track of the number of times a product was ordered. 


