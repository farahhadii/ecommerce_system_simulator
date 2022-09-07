import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

// Simulation of a Simple E-Commerce System (like Amazon)

public class ECommerceUserInterface
{
	public static void main(String[] args)
	{
		// Create the system
		ECommerceSystem amazon = new ECommerceSystem(); //created an object reference variable for the Ecommerce class

		Scanner scanner = new Scanner(System.in); // created a scanner object to read input from the user 
		System.out.print(">");

		// Process keyboard actions
		while (scanner.hasNextLine())
		{
			String action = scanner.nextLine();
	
			if (action == null || action.equals("")) 
			{
				System.out.print("\n>");
				continue;
			}
			else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
				return;

			else if (action.equalsIgnoreCase("PRODS"))	// List all products for sale
			{
				amazon.printAllProducts(); 
			}
			else if (action.equalsIgnoreCase("BOOKS"))	// List all books for sale
			{
				amazon.printAllBooks(); 
			}
			else if (action.equalsIgnoreCase("CUSTS")) 	// List all registered customers
			{
				amazon.printCustomers();	
			}
			else if (action.equalsIgnoreCase("ORDERS")) // List all current product orders
			{
				amazon.printAllOrders();	
			}
			else if (action.equalsIgnoreCase("SHIPPED"))	// List all orders that have been shipped
			{
				amazon.printAllShippedOrders();	
			}
			else if (action.equalsIgnoreCase("NEWCUST"))	// Create a new registered customer
			{
				boolean ok = true;
				String name = "";
				String address = "";

				System.out.print("Name: ");
				if (scanner.hasNextLine())
					name = scanner.nextLine();
				
				System.out.print("\nAddress: ");
				if (scanner.hasNextLine())
					address = scanner.nextLine();
				
				while(ok) {
				  try {
				    amazon.createCustomer(name, address);
				    ok = false;
				  }
			     catch(InvalidCustomerNameException e ) {
				    System.out.println(e.getMessage());
                    System.out.print("\nName: ");
				    if (scanner.hasNextLine())
					   name = scanner.nextLine(); 
			     }
                 catch(InvalidCustomerAddressException e) {
				   System.out.println(e.getMessage());
				   System.out.print("\nAddress: ");
				   if (scanner.hasNextLine())
					  address = scanner.nextLine();
			     }
		       }
	        }
			else if (action.equalsIgnoreCase("SHIP"))	// ship an order to a customer
			{     
				    boolean ok = true; 
					String orderNumber = "";

					System.out.print("Order Number: ");
					 if (scanner.hasNextLine())
					    orderNumber = scanner.nextLine();
					
					while(ok) {
					  try {
					    amazon.shipOrder(orderNumber);
					    ok = false;
					  }
					  catch(InvalidOrderNumberException e) {
						System.out.println(e.getMessage());
                        System.out.print("\nOrder Number: ");
						if (scanner.hasNextLine())
					        orderNumber = scanner.nextLine();
					  }
			        }
		    }

			else if (action.equalsIgnoreCase("CUSTORDERS")) // List all the current orders and shipped orders for this customer id
			{       
				    boolean ok = true;
					String customerId = "";

				    System.out.print("CustomerId: ");
					if (scanner.hasNextLine()) 
					customerId = scanner.nextLine();
                
				while(ok) {
			        try {
						amazon.printOrderHistory(customerId);
						ok = false;
					}
					catch(CustomerIdNotFoundException e) {
						System.out.println(e.getMessage());
						System.out.print("\nCustomerId: ");
					     if (scanner.hasNextLine()) 
					       customerId = scanner.nextLine();
					}    
				} 
           }
			else if (action.equalsIgnoreCase("ORDER")) // order a product for a certain customer
			{   
				boolean ok = true;
				String productId = "";
				String customerId = "";

				System.out.print("Product Id: ");
				if (scanner.hasNextLine())
			         productId = scanner.nextLine();

				System.out.print("\nCustomer Id: ");
				if (scanner.hasNextLine())
			         customerId = scanner.nextLine();

             while(ok) {
			    try {
                 String results = amazon.orderProduct(productId, customerId, "");
			     System.out.println("Order #" + results);
				 ok = false;
				}

				catch(ProductIdNotFoundException e) {
					System.out.println(e.getMessage());
					System.out.print("\nProduct Id: ");
				    if (scanner.hasNextLine())
			           productId = scanner.nextLine();
				}
				catch (CustomerIdNotFoundException e) {
					System.out.println(e.getMessage());
					System.out.print("\nCustomer Id: ");
				    if (scanner.hasNextLine())
			          customerId = scanner.nextLine();
				}
				catch(InvalidProductOptionsException e) {
					System.out.println(e.getMessage());
					System.out.print("\nProduct Id: ");
				    if (scanner.hasNextLine())
			           productId = scanner.nextLine();
				}
				catch(ProductOutOfStockException e) {
					System.out.println(e.getMessage());
				}
			 }
		    }
			else if (action.equalsIgnoreCase("ORDERBOOK")) // order a book for a customer, provide a format (Paperback, Hardcover or EBook)
			{
				boolean ok = true;
				String productId = "";
				String customerId = "";
				String options = "";

				System.out.print("Product Id: ");
				if (scanner.hasNextLine())
				    productId = scanner.nextLine();

				System.out.print("\nCustomer Id: ");
				if (scanner.hasNextLine())
				   customerId = scanner.nextLine();
				
				System.out.print("\nFormat [Paperback Hardcover EBook]: ");
				if (scanner.hasNextLine())
				    options = scanner.nextLine();

             while(ok) {
				try {
					String results = amazon.orderProduct(productId, customerId, options);
                    System.out.println("Order #"+ results);	
					ok = false;
				}

				catch(ProductIdNotFoundException e) {
					System.out.println(e.getMessage());
					System.out.print("\nProduct Id: ");
					if (scanner.hasNextLine())
						productId = scanner.nextLine();
				}
				catch (CustomerIdNotFoundException e) {
					System.out.println(e.getMessage());
					System.out.print("\nCustomer Id: ");
					if (scanner.hasNextLine())
					  customerId = scanner.nextLine();
				}
				catch(InvalidProductOptionsException e) {
					System.out.println(e.getMessage());
					System.out.print("\nFormat [Paperback Hardcover EBook]: ");
				    if (scanner.hasNextLine())
				       options = scanner.nextLine();
				}
				catch(ProductOutOfStockException e) {
					System.out.println(e.getMessage());
				}
			 }
				
			}
			else if (action.equalsIgnoreCase("ORDERSHOES")) // order shoes for a customer, provide size and color 
			{
				boolean ok = true;
				String productId = "";
				String customerId = "";
				String options = "";
				
				System.out.print("Product Id: ");
				if (scanner.hasNextLine())
				    productId = scanner.nextLine();

				System.out.print("\nCustomer Id: ");
				if (scanner.hasNextLine())
				  customerId = scanner.nextLine();
				
				System.out.print("\nSize: \"6\" \"7\" \"8\" \"9\" \"10\": ");
                if (scanner.hasNextLine())
				    options = scanner.nextLine()+ " ";
				
				System.out.print("\nColor: \"Black\" \"Brown\": ");
                if (scanner.hasNextLine())
				    options += scanner.nextLine();
			
             while(ok) {

				try{
				String results = amazon.orderProduct(productId, customerId, options);
                System.out.println("Order #" + results);
				ok = false;
				}
				catch(ProductIdNotFoundException e) {
					System.out.println(e.getMessage());
					System.out.print("\nProduct Id: ");
					if (scanner.hasNextLine())
						productId = scanner.nextLine();
				}
				catch (CustomerIdNotFoundException e) {
					System.out.println(e.getMessage());
					System.out.print("\nCustomer Id: ");
					if (scanner.hasNextLine())
					  customerId = scanner.nextLine();
				}
				catch(InvalidProductOptionsException e) {
					System.out.println(e.getMessage());
					System.out.print("\nSize: \"6\" \"7\" \"8\" \"9\" \"10\": ");
					// get shoe size and store in options	
					if (scanner.hasNextLine())
						options = scanner.nextLine()+ " ";
					
					System.out.print("\nColor: \"Black\" \"Brown\": ");
					// get shoe color and append to options
					if (scanner.hasNextLine())
						options += scanner.nextLine();
				}
				catch(ProductOutOfStockException e) {
					System.out.println(e.getMessage());
				}
			 }
			}
			
			else if (action.equalsIgnoreCase("CANCEL")) // Cancel an existing order
			{   
				boolean ok = true;
				String orderNumber = "";

				System.out.print("Order Number: ");
				if (scanner.hasNextLine())
                  orderNumber = scanner.nextLine();

			  while(ok) {
				try {
				amazon.cancelOrder(orderNumber);
				ok = false;
				}
				catch (InvalidOrderNumberException e) {
					 System.out.println(e.getMessage());
					 System.out.print("\nOrder Number: ");
				     if (scanner.hasNextLine())
                        orderNumber = scanner.nextLine();
				}
			  } 	 
			}
			else if (action.equalsIgnoreCase("PRINTBYPRICE")) // sort products by price
			{
				amazon.printByPrice();
			}
			else if (action.equalsIgnoreCase("PRINTBYNAME")) // sort products by name (alphabetic)
			{
				amazon.printByName();
			}
			else if (action.equalsIgnoreCase("SORTCUSTS")) // sort products by name (alphabetic)
			{
				amazon.sortCustomersByName();
			}
			else if (action.equalsIgnoreCase("BOOKSBYAUTHOR")) {
                  
				String author = "";
				System.out.print("Author's name: ");

				author = scanner.nextLine();
			    amazon.BooksByAuthor(author);
			}

			else if(action.equalsIgnoreCase("ADDTOCART")) {
                
				boolean ok = true;
				String productid = ""; 
				String customerID = ""; 
				String productOptions = "";
                
				System.out.print("ProductId: ");
				if(scanner.hasNextLine()){
					productid = scanner.nextLine();
				}
                
				System.out.print("\nCustomerId: ");
				if(scanner.hasNextLine()){
					customerID = scanner.nextLine();
				}

				System.out.print("\nProductOptions: ");
				if(scanner.hasNextLine()){
					productOptions = scanner.nextLine();
				}
			  while(ok) {
				try {
				amazon.addToCart(customerID, productid, productOptions);
				ok = false;
				}
				catch(ProductIdNotFoundException e) {
					System.out.println(e.getMessage());
					System.out.print("\nProduct Id: ");
					if (scanner.hasNextLine())
						productid = scanner.nextLine();
				}
				catch (CustomerIdNotFoundException e) {
					System.out.println(e.getMessage());
					System.out.print("\nCustomer Id: ");
					if (scanner.hasNextLine())
					  customerID = scanner.nextLine();
				}
				catch(InvalidProductOptionsException e) {
					System.out.println(e.getMessage());
					System.out.print("\nProductOptions: ");
				    if (scanner.hasNextLine())
				       productOptions = scanner.nextLine();
				}
				catch(ProductOutOfStockException e) {
					System.out.println(e.getMessage());
				}
			  }
			} 
			else if(action.equalsIgnoreCase("REMCARTITEM")) {
                 
				boolean ok = true;
				String customerId = "";
				String productId = "";

				System.out.print("CustomerId: ");
				if(scanner.hasNextLine()){
					customerId = scanner.nextLine();
				}

				System.out.print("\nProductId: ");
				if(scanner.hasNextLine()){
					productId = scanner.nextLine();
				}
             while(ok) {
				 try {
					amazon.remCartItem(customerId, productId);
					ok = false;
				 }
				 catch(ProductIdNotFoundException e) {
					System.out.println(e.getMessage());
					System.out.print("\nProduct Id: ");
					if (scanner.hasNextLine())
						productId = scanner.nextLine();
				}
				catch (CustomerIdNotFoundException e) {
					System.out.println(e.getMessage());
					System.out.print("\nCustomer Id: ");
					if (scanner.hasNextLine())
					  customerId = scanner.nextLine();
				}
			 }   
			}
			else if(action.equalsIgnoreCase("PRINTCART")) {
               
				boolean ok = true;
				String customerId = "";

				System.out.print("CustomerId: ");
				if(scanner.hasNextLine()){
					customerId = scanner.nextLine();
				}
              while(ok) {  
				try {
				amazon.printCart(customerId);
				ok = false;
				}
				catch(CustomerIdNotFoundException e) {
					System.out.println(e.getMessage());
                    System.out.print("\nCustomerId: ");
				    if(scanner.hasNextLine()){
					  customerId = scanner.nextLine();
				   }
				}
			  } 
			}
			else if(action.equalsIgnoreCase("ORDERITEMS")) {
                 
				boolean ok = true;
				String customerId = "";

				System.out.print("CustomerId: ");
				if(scanner.hasNextLine()) {
					customerId = scanner.nextLine();
				}
              while(ok) {
				try {
				amazon.orderItems(customerId);
				ok = false;
				}
				catch(CustomerIdNotFoundException e) {
					System.out.println(e.getMessage());
					System.out.print("\nCustomerId: ");
                    if(scanner.hasNextLine()) {
					 customerId = scanner.nextLine();
					}
				}
			 }	
			}
			else if(action.equalsIgnoreCase("STATS")) {
				 amazon.productOrderStatistics();
			}

         System.out.print("\n>");	
        }
    }
}




