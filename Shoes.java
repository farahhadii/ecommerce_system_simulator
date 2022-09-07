import java.util.*;
import java.util.Scanner;
public class Shoes extends Product 
{
  
  // Stock related information: where I am storing the stock available for Shoes 
  private List<ArrayList<Integer>> shoeStock;
  
  public Shoes(String name, String id, double price, List<ArrayList<Integer>> shoeStock)
  {
    super(name, id, price, 100000, Product.Category.CLOTHING);
    this.shoeStock = shoeStock;

    // Make use of the constructor in the super class Product. Initialize additional Shoes instance variables. 
     // Set category to CLOTHING  
  }
    
  // Check if a valid format  
  public boolean validOptions(String productOptions)
  {
    Scanner in = new Scanner(productOptions);

    int sizeOfShoe = Integer.parseInt(in.next());
      
    String colorOfShoe = in.next();

    if(sizeOfShoe > 5 && sizeOfShoe < 11 && (colorOfShoe.equals("Black") || colorOfShoe.equals("Brown")))
    {
      return true;    
    }
    return false; 
  }
  
  // Override getStockCount() in super class (Product).
  public int getStockCount(String productOptions)
  {
    // Use the productOptions to check for (and return) the number of stock for "Black" shoeSizes and "Brown" shoeSizes.
    // Use the nested ArrayList shoeStock

    Scanner in = new Scanner(productOptions);

    int sizeOfShoe = Integer.parseInt(in.next());
      
    String colorOfShoe = in.next();
    
    if(colorOfShoe.equals("Brown"))
    {
      if(sizeOfShoe == 6)
      {
        return shoeStock.get(0).get(0);
      }
      else if (sizeOfShoe == 7)
      {
        return shoeStock.get(0).get(1);
      }
      else if(sizeOfShoe == 8)
      {
        return shoeStock.get(0).get(2);
      }
      else if (sizeOfShoe == 9)
      {
        return shoeStock.get(0).get(3);
      }
      else if(sizeOfShoe == 10)
      {
        return shoeStock.get(0).get(4);
      }
    }
    if(colorOfShoe.equals("Black"))
      {
       if(sizeOfShoe == 6)
       {
        return shoeStock.get(1).get(0);
       }
       else if (sizeOfShoe == 7)
       {
         return shoeStock.get(1).get(1);
       }
       else if(sizeOfShoe == 8)
       {
         return shoeStock.get(1).get(2);
       }
       else if (sizeOfShoe == 9)
       {
         return shoeStock.get(1).get(3);
       }
       else if(sizeOfShoe == 10)
       {
         return shoeStock.get(1).get(4);
       }
      } 
    return 0; 
  }
  
  
  public void setStockCount(int stockCount, String productOptions)
  {
     String options[] = productOptions.split(" ");
     int sizeOfShoe = Integer.valueOf(options[0]);
     String colorOfShoe = options[1];
     
     if(colorOfShoe.equals("Brown"))
     {
       if(sizeOfShoe == 6)
       {
        stockCount = shoeStock.get(0).get(0);
       }
       else if (sizeOfShoe == 7)
       {
         stockCount = shoeStock.get(0).get(0);
       }
       else if(sizeOfShoe == 8)
       {
         stockCount = shoeStock.get(0).get(0);
       }
       else if (sizeOfShoe== 9)
       {
         stockCount = shoeStock.get(0).get(0);
       }
       else if(sizeOfShoe == 10)
       {
         stockCount = shoeStock.get(0).get(0);
       }
      }
     if(colorOfShoe.equals("Black"))
       {
        if(sizeOfShoe == 6)
        {
         stockCount = shoeStock.get(0).get(0);
        }
        else if (sizeOfShoe == 7)
        {
        stockCount = shoeStock.get(0).get(0);
        }
        else if(sizeOfShoe == 8)
        {
         stockCount = shoeStock.get(0).get(0);
        }
        else if (sizeOfShoe == 9)
        {
          stockCount = shoeStock.get(0).get(0);
        }
        else if(sizeOfShoe == 10)
        {
         stockCount = shoeStock.get(0).get(0);
        }
       }
}
  
    /* When a Shoe is ordered, reduce the stock count for the shoe size and Color 
   */
  public void reduceStockCount(String productOptions)
  {
     String options[] = productOptions.split(" ");
     String colorOfShoe = options[1];
     int sizeOfShoe = Integer.valueOf(options[0]);

     if(colorOfShoe.equals("Brown"))
     {
       if(sizeOfShoe == 6) {
        shoeStock.get(0).set(0, shoeStock.get(0).get(0) - 1);  
       }
       else if (sizeOfShoe == 7)
       {
        shoeStock.get(0).set(1, shoeStock.get(0).get(1) - 1);
       }
       else if(sizeOfShoe == 8)
       {
        shoeStock.get(0).set(2, shoeStock.get(0).get(2) - 1);
       }
       else if (sizeOfShoe == 9)
       {
        shoeStock.get(0).set(3, shoeStock.get(0).get(3) - 1);
       }
       else if(sizeOfShoe == 10)
       {
        shoeStock.get(0).set(4, shoeStock.get(0).get(4) - 1);
       }
      }
     if(colorOfShoe.equals("Black")) {

        if(sizeOfShoe == 6)
        {
          shoeStock.get(1).set(0, shoeStock.get(1).get(0) - 1);
        }
        else if (sizeOfShoe == 7)
        {
          shoeStock.get(1).set(1, shoeStock.get(1).get(1) - 1);
        }
        else if(sizeOfShoe == 8)
        {
          shoeStock.get(1).set(2, shoeStock.get(1).get(2) - 1);
        }
        else if (sizeOfShoe == 9)
        {
          shoeStock.get(1).set(3, shoeStock.get(1).get(3) - 1);
        }
        else if(sizeOfShoe == 10)
        {
          shoeStock.get(1).set(4, shoeStock.get(1).get(4) - 1);
        }
       }
}
    
  /*
   * Print product information in super class and add the ShoeStock nested ArrayList; 
   */
  public void print()
  {
    super.print(); 
    System.out.print(" Shoe Stock: " + shoeStock);
  }
}




