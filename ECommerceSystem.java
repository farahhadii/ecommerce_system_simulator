import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/*
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
public class ECommerceSystem 
{

    private Map<String,Product> products = new HashMap<String, Product>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();	
    private ArrayList<ProductOrder> orders   = new ArrayList<ProductOrder>();
    private ArrayList<ProductOrder> shippedOrders   = new ArrayList<ProductOrder>();
    
    // These variables are used to generate order numbers, customer id's, product id's 
    private int orderNumber = 500;
    private int customerId = 900;
    private int productId = 700;
    
    // General variable used to store an error message when something is invalid (e.g. customer id does not exist)  
    String errMsg = null;
    
    // Random number generator
    Random random = new Random();
    
    public ECommerceSystem() // constructor method 
    {
      List<ArrayList<Integer>> a = new ArrayList<>(); // nested ArrayList for the shoe stock
      ArrayList<Integer> a1 = new ArrayList<Integer>();
      ArrayList<Integer> a2 = new ArrayList<Integer>();
      a1.add(30);
      a1.add(30);
      a1.add(30);
      a1.add(30);
      a1.add(30);
      a2.add(30);
      a2.add(30);
      a2.add(30);
      a2.add(30);
      a2.add(30);
      a.add(a1);
      a.add(a2);

      ArrayList<Product> prod;
      try {
        prod = readProductFile();
        prod.add(new Shoes("Shoes", generateProductId(),10.0,a));
        for (Product p : prod) {
          String num = p.getId();
          products.put(num, p);
        }
        

      }
      catch (IOException e) {
        System.out.println(e.getMessage());
      }
     
    	// Created some customers
    	customers.add(new Customer(generateCustomerId(),"Inigo Montoya", "1 SwordMaker Lane, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Prince Humperdinck", "The Castle, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Andy Dufresne", "Shawshank Prison, Maine"));
    	customers.add(new Customer(generateCustomerId(),"Ferris Bueller", "4160 Country Club Drive, Long Beach"));
    }

    private ArrayList<Product> readProductFile() throws IOException {
               
      Product.Category category = Product.Category.GENERAL;
      String name;
      double price;
      int stock; 
      String temp;
      String tempString;
      int paperbackStock;
      int hardcoverStock;
      String title; 
      String author; 
      int year; 

      // Reading in the "product.txt" file 
      ArrayList<Product> p = new ArrayList<>();
      File file = new File("products.txt");
      Scanner in = new Scanner(file);
  
      while(in.hasNextLine()) {

         String Line =  in.nextLine();
         if(Line.equals("GENERAL")) {
             category = Product.Category.GENERAL;

            if(!in.hasNextLine()) {
              throw new FileNotFoundException("File not Found");
             }
            name = in.nextLine();

            if(!in.hasNextLine()) {
              throw new FileNotFoundException("File not Found");
            }
            price = Double.parseDouble(in.nextLine());

            if(!in.hasNextLine()) {
              throw new FileNotFoundException("File not Found");
            }
            stock = Integer.parseInt(in.nextLine());

            if(!in.hasNextLine()) {
              throw new FileNotFoundException("File not Found");
            }
            in.nextLine(); // reading the empty line

            p.add(new Product(name,generateProductId(),price,stock,category));

          }
        else if(Line.equals("FURNITURE")) {
             category = Product.Category.FURNITURE;
             if(!in.hasNextLine()) {
                throw new FileNotFoundException("File not Found");
              }
              name = in.nextLine();

             if(!in.hasNextLine()) {
              throw new FileNotFoundException("File not Found");
             }
             price = Double.parseDouble(in.nextLine());

            if(!in.hasNextLine()) {
              throw new FileNotFoundException("File not Found");
            }
           stock = Integer.parseInt(in.nextLine());
         
           if(!in.hasNextLine()) {
            throw new FileNotFoundException("File not Found");
          }
           in.nextLine();

           p.add(new Product(name, generateProductId(),price,stock,category));
        }

        else if(Line.equals("CLOTHING")) {
          category = Product.Category.CLOTHING;
          if(!in.hasNextLine()) {
             throw new FileNotFoundException("File not Found");
          }
          name = in.nextLine();

          if(!in.hasNextLine()) {
           throw new FileNotFoundException("File not Found");
        }
         price = Double.parseDouble(in.nextLine());

         if(!in.hasNextLine()) {
           throw new FileNotFoundException("File not Found");
        }
        stock = Integer.parseInt(in.nextLine());

        if(!in.hasNextLine()) {
          throw new FileNotFoundException("File not Found");
        }
        in.nextLine();

        p.add(new Product(name, generateProductId(),price,stock,category));

     }

     else if(Line.equals("COMPUTERS")) {
      
      category = Product.Category.COMPUTERS;

      if(!in.hasNextLine()) {
         throw new FileNotFoundException("File not Found");
       }
      name = in.nextLine();

      if(!in.hasNextLine()) {
       throw new FileNotFoundException("File not Found");
      }
     price = Double.parseDouble(in.nextLine());

     if(!in.hasNextLine()) {
       throw new FileNotFoundException("File not Found");
    }
     stock = Integer.parseInt(in.nextLine());
     if(!in.hasNextLine()) {
              throw new FileNotFoundException("File not Found");
            }
     in.nextLine();

     p.add(new Product(name, generateProductId(),price,stock,category));

   }

   else if(Line.equals("BOOKS")) {
        
      category = Product.Category.BOOKS;

      if(!in.hasNextLine()) {
        throw new FileNotFoundException("File not Found");
      }
      name = in.nextLine(); 

      if(!in.hasNextLine()) {
        throw new FileNotFoundException("File not Found");
      }
      price = Double.parseDouble(in.nextLine()); 
      
      if(!in.hasNextLine()) {
        throw new FileNotFoundException("File not Found");
      }
      temp = in.nextLine(); 
      Scanner se = new Scanner(temp);
      paperbackStock = Integer.parseInt(se.next());
      hardcoverStock = Integer.parseInt(se.next());
      se.close();

      if(!in.hasNextLine()) {
        throw new FileNotFoundException("File not Found");
      }
      tempString = in.nextLine(); 

      Scanner tempScan = new Scanner(tempString);

      tempScan.useDelimiter(":"); 

      title = tempScan.next(); 
      author = tempScan.next(); 
      year = Integer.parseInt(tempScan.next());
      tempScan.close();

      p.add(new Book(name, generateProductId(),price, paperbackStock, hardcoverStock, title, author, year));

    }
  }
  return p; 
}
    private String generateOrderNumber() // this method will return the orderNumber as a String 
    {
    	return "" + orderNumber++;
    }

    private String generateCustomerId() // this method will return the customerId as a String 
    {
    	return "" + customerId++;
    }
    
    private String generateProductId()
    {
    	return "" + productId++;
    }
    
    public String getErrorMessage()
    {
    	return errMsg;
    }  

    public void printAllProducts()
    {
      for (String k: products.keySet()) {
          Product p = products.get(k); 
          p.print();
      }
      
    } 
    // Print all products that are books. See getCategory() method in class Product
    public void printAllBooks()
    {
    	for (String k: products.keySet()){
           Product p = products.get(k);
         if (p.getCategory().equals(Product.Category.BOOKS)) {
             p.print();
         }
      }
    }
    // Print all current orders
    public void printAllOrders()
    {
    	for (ProductOrder order: orders) {
       order.print();
      }
    }
    // Print all shipped orders
    public void printAllShippedOrders()
    {
    	for (ProductOrder shippedOrder: shippedOrders) {
        shippedOrder.print();
    }
  } 
    // Print all customers
    public void printCustomers()
    {
      for (Customer c: customers) {
        c.print();
      }	
    }

    // printing all books by given author in increasing order of year published
    public void BooksByAuthor(String author) {
       
    // first must check 
      Book newP = null;
      ArrayList<Book> books = new ArrayList<Book>();

      for (Product p: products.values()) {
         if(p.getName().equals("Book")) {
           newP = (Book) p; // cast the product to be of type Book 
            if (newP.getAuthor().equals(author)) {
                books.add(newP);
        }
      }
    }    
     Collections.sort(books);
     
     for(Book b: books) {
       b.print();
     }

    }
    
    public void productOrderStatistics() {

      Map<String,Integer> p = new TreeMap<String, Integer>();
      ArrayList<String> productsId = new ArrayList<String>();  // add all the ordered productId's into this arrayList
       
      for (ProductOrder o : orders) {
            productsId.add(o.getProduct().getId());   
      }

      for(String s : productsId) {
         
         if(!p.containsKey(s)) {
            p.put(s,1);
         }

         else {
            int count = p.get(s);
            p.put(s,count+1);
         }
      }
       LinkedHashMap<String, Integer> reverseP = new LinkedHashMap<>(); // used to sort values(Integer) in the map 
 
        p.entrySet()
       .stream()
       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
       .forEachOrdered(i -> reverseP.put(i.getKey(), i.getValue()));
        
        ArrayList<String> s = new ArrayList<String>();
        for(String k : reverseP.keySet()) {
          int frequency = 0;
          for(ProductOrder o: orders) {
          if(k.equals(o.getProduct().getId())) {
             if(!s.contains(o.getProduct().getId())) {
                s.add(o.getProduct().getId());
                String name = o.getProduct().getName();
                frequency = reverseP.get(k);
                System.out.printf("\nName: %12s Id: %-5s frequency: %8s", name, k, frequency);   
              }
            else {
              continue;
          }      
          }   
        } 
      }    
      }
    
    /*
     * Given a customer id, print all the current orders and shipped orders for them (if any)
     */
    public void printOrderHistory(String customerId) 
    {
      Customer cust = null; // declaring an object reference variable for the Customer 

      for (Customer c : customers) {
        if (c.getId().equals(customerId)) {
          cust = c; 
          System.out.println("Current Orders of Customer " + customerId);
          for (ProductOrder order : orders) {
            if(order.getCustomer().getId().equals(cust.getId())) {
               order.print();
            }
          }
          System.out.println("\nShipped Orders of Customer " + customerId);
          for (ProductOrder shippedOrder: shippedOrders) {
                    if(shippedOrder.getCustomer().getId().equals(cust.getId())) {
                      shippedOrder.print();
                    }       
                  }
                   
                }
              }
          if(cust == null) {
            throw new CustomerIdNotFoundException("Invalid customerId: " + customerId + " try again!");
          }          
    }
    public String orderProduct(String productId, String customerId, String productOptions)
    {
         Customer customerobj = null; // declaring an object reference variable for the customer class
         Product productojb = null;
         for (Customer c: customers) {
              if(c.getId().equals(customerId)) {
                customerobj = c;
              }
            }
            if (customerobj == null) {
               throw new CustomerIdNotFoundException("Invalid customerId: " + customerId + " try again!");
              }        

            if (products.containsKey(productId)) {
              productojb = products.get(productId); // getting the Product object 
            } 
           
           else {
              throw new ProductIdNotFoundException("Invalid productId: " + productId + " try again!");
           }

             if(productojb.validOptions(productOptions) == false) {
                throw new InvalidProductOptionsException("This Option: " + productOptions + " is Not found");
             }

         if (productojb.getStockCount(productOptions) == 0) {
                   throw new ProductOutOfStockException("Product " + productId + " has no Stock");
         }

         String num = generateOrderNumber();
         productojb.reduceStockCount(productOptions);
        
           orders.add(new ProductOrder(num,productojb,customerobj,productOptions));
           return num;
  }
  public void addToCart(String customerId, String productId, String productOptions) {

            // find customer 
             // get customer cart 
             // find product 
             // add productOptions and product to cart 
          Customer c = null;
          Cart custCart = null; 
          Product p = null; 
          for(Customer cust: customers) {
              if(cust.getId().equals(customerId)) {
                  c = cust;
                  custCart = c.getCart(); // getting the customer's cart 
              }
          }
          if(c == null) {
            throw new CustomerIdNotFoundException("Customer not found, try again");
          }

          if(products.containsKey(productId)) { // check if productId is valid 
              p = products.get(productId);
          }
        
         else if (!products.containsKey(productId)) {
              throw new ProductIdNotFoundException("Product not found, try again");
         }

         if(p.validOptions(productOptions) == false) {
          throw new InvalidProductOptionsException("This Option: " + productOptions + " is Not found");
         }
         if (p.getStockCount(productOptions) == 0) {
          throw new ProductOutOfStockException("Product " + productId + " has no Stock");
         }
         p.reduceStockCount(productOptions);

        custCart.addItem(p, productOptions); // add product and productOptions to the customer's cart

  }
   public void remCartItem(String customerId, String productId) {
       
           Customer c = null;
           Cart custCart = null;
           
           for(Customer cust: customers) {
               if(cust.getId().equals(customerId)) {
                  c = cust;
                  custCart = c.getCart(); // getting the customer's cart 
                  custCart.removeItem(productId); // remove product from customer's cart
              }
           }
          if(c == null) {
            throw new CustomerIdNotFoundException("Customer not found, try again");
          }
   }

   public void orderItems(String customerId) {

      // take the customer's cart 
      // take each product out 
      // create a product order for each product using the orderproduct in a loop 
    
       Customer c = null; 
       Cart custCart = null; 
       for(Customer cust: customers) {
           if(cust.getId().equals(customerId)) {
                c = cust;
                custCart = c.getCart();  // getting a customer's cart 
           }  
       }
       if (c == null) {
           throw new CustomerIdNotFoundException("Customer Id not found, try again!"); 
       } 
       ArrayList<CartItem> items = custCart.getItems(); // getting all the cartItems of a particular customer 
    
       for(CartItem cItem : items) {    //go through the items arrayList 
            orderProduct(cItem.getProduct().getId(), customerId, cItem.getProductOptions()); // order the product 
       }
       items.clear(); // emptying the cart of all items once orders are created 
   }

      

   public void printCart(String customerId) {

           Customer c = null;
           Cart custCart = null; 
           for(Customer cust: customers) {
              if(cust.getId().equals(customerId)) {
                 c = cust; // getting the customer's object 
                 custCart = c.getCart(); // getting the customer's cart 
                 System.out.println("Current Orders of Customer " + customerId);
                 custCart.printCartItems();
             }
            }
            if(c == null) {
              throw new CustomerIdNotFoundException("Customer not found, try again");
            }
   }
    public void createCustomer(String name, String address)
    {
       if ((name.equals(null)) || (name.equals(""))) {
                 throw new InvalidCustomerNameException("Invalid Customer Name, try again");           
       }
       if ((address.equals(null)) || (address.equals(""))) {
         throw new InvalidCustomerAddressException("Invalid Customer Address, try again"); 
       }
    	// Create a Customer object and add to array list
      Customer newcust1 = new Customer(generateCustomerId(),name,address);
      customers.add(newcust1);
    }
    
    public ProductOrder shipOrder(String orderNumber)
    {
       ProductOrder ord = null;
       for (ProductOrder order: orders) {
            if(order.getOrderNumber().equals(orderNumber)) {
             ord = order;
             shippedOrders.add(ord);
             ord.print();
             break;
            }
          }
          if (ord == null) {
              throw new InvalidOrderNumberException("Order " + orderNumber + " Not found");
          }
         orders.remove(ord);
         return ord;
    }
    /*
     * Cancel a specific order based on order number
     */
    public void cancelOrder(String orderNumber)
    {
      ProductOrder ord = null;
      for (ProductOrder order: orders) {
            if(order.getOrderNumber().equals(orderNumber)) {
                  ord = order;
            }
      }
      if(ord == null) {
         throw new InvalidOrderNumberException("Order Number " + orderNumber + " Not found. Try another number");
      }
      orders.remove(ord);
    }
  
    // Sort products by increasing price
    public void printByPrice()
    {
      ArrayList<Product> temp = new ArrayList<>();

      for (String k: products.keySet()) {
          Product p = products.get(k);
          temp.add(p);
      }
      Collections.sort(temp, new ProductPriceComparator());
      
      for(Product prods: temp) {
         prods.print();
      }
  }
    // Sort products alphabetically by product name
    public void printByName()
    {
      ArrayList<Product> tempTwo = new ArrayList<>();
      for(String k : products.keySet()) {
          Product prods = products.get(k);
          tempTwo.add(prods);
       }
        Collections.sort(tempTwo, new ProductNameComparator());

        for(Product pName : tempTwo) {
           pName.print();
        }
    }
        
    // Sort products alphabetically by product name
    public void sortCustomersByName()
    {
  	  Collections.sort(customers);
    }

    class ProductNameComparator implements Comparator<Product> {
      public int compare(Product a, Product b) {
        return a.getName().compareTo(b.getName());
      }
    }
    class ProductPriceComparator implements Comparator<Product> {

          public int compare(Product a, Product b) {
             if(a.getPrice() > b.getPrice()) {
               return 1;
             }
             else if (a.getPrice() < b.getPrice()) {
                  return -1;
             }
             else {
               return 0;
             }
    }
  }

}
class CustomerIdNotFoundException extends RuntimeException {

     public CustomerIdNotFoundException() {}

     public CustomerIdNotFoundException(String message) {
       super(message);
}
}
class ProductIdNotFoundException extends RuntimeException {

  public ProductIdNotFoundException() {}

  public ProductIdNotFoundException(String message) {
    super(message);
}
}
class InvalidProductOptionsException extends RuntimeException {

  public InvalidProductOptionsException() {}

  public InvalidProductOptionsException (String message) {
    super(message);
}
}
class ProductOutOfStockException extends RuntimeException {
     
  public ProductOutOfStockException() {}

  public ProductOutOfStockException(String message) {
    super(message);
}
}

class InvalidCustomerNameException extends RuntimeException {
     
  public InvalidCustomerNameException() {}

  public InvalidCustomerNameException(String message) {
    super(message);
}
}
class InvalidCustomerAddressException extends RuntimeException {
     
  public InvalidCustomerAddressException() {}

  public InvalidCustomerAddressException(String message) {
    super(message);
}
}
class InvalidOrderNumberException extends RuntimeException {
     
  public InvalidOrderNumberException() {}

  public InvalidOrderNumberException(String message) {
    super(message);
}
}





