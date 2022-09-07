/* A book is a product that has additional information - e.g. title, author.
 	 A book also comes in different formats ("Paperback", "Hardcover", "EBook")
 	 The format is specified as a specific "stock type" in get/set/reduce stockCount methods.
*/
public class Book extends Product implements Comparable
{
  private String author;
  private String title;
  private int year;
  
  // Stock related information NOTE: inherited stockCount variable is used for EBooks
  int paperbackStock;
  int hardcoverStock;

  
  public Book(String name, String id, double price, int paperbackStock, int hardcoverStock, String title, String author, int year)
  {
     super(name, id, price, 100000, Product.Category.BOOKS);
     this.paperbackStock = paperbackStock;
     this.hardcoverStock = hardcoverStock;
     this.title = title;
     this.author = author;  
     this.year = year; 
  }
  
  public Book(String name, double price, int paperbackStock2, int hardcoverStock2, String title2, String author2,
      int year2) {
  }

  public int getYear() {
    return year;
  }

  public String getAuthor() {
    return author;
  }

  // Check if a valid format  
  public boolean validOptions(String productOptions)
  {
  	// check productOptions for "Paperback" or "Hardcover" or "EBook"
    if (productOptions.equals("Paperback") || productOptions.equals("Hardcover") || productOptions.equals("EBook")) {   
          return true;
    }
    return false;  
  }
  // Override getStockCount() in super class.
@Override
  public int getStockCount(String productOptions)
	{
  	if (productOptions.equals("Paperback")) {
        return paperbackStock;
    }
    else if (productOptions.equals("Hardcover")) {
         return hardcoverStock; 

    } else  {
        return super.getStockCount("EBook");
    }  
	} 
  public void setStockCount(int stockCount, String productOptions)
	{
     if (productOptions.equals("Paperback")) {
         this.paperbackStock = stockCount;

     } else if (productOptions.equals("Hardcover")) {
         this.hardcoverStock = stockCount;

     } else if (productOptions.equals("EBook")) {
       super.setStockCount(getStockCount(productOptions),"EBook"); // getting the inherinted stockCount variable and 
       // setting it to EBook
          
     }
    }
  /*
   * When a book is ordered, the stock count is reduced for the specific stock type
   */
  public void reduceStockCount(String productOptions)
	{

     if (productOptions.equals("Paperback")) {
          paperbackStock--;

     } else if (productOptions.equals("Hardcover")) {
          hardcoverStock--;

     } else {
        setStockCount(getStockCount(productOptions),"EBook"); //get the inherited stockcount variable from the 
        // super class and decrement it.  
          
     }
	}
  /*
   * Print product information in super class 
   */
  public void print()
  {
    super.print();
    System.out.print(" " + "Book Title: " + title + " ");
    System.out.print("Author: " + author + " year: " + year);
  }
  @Override
  public int compareTo(Object o) {

    Book other = (Book) o;
      if (this.getYear() > other.getYear()) {
        return 1;
      }
      else if (this.getYear() < other.getYear()) {
           return -1;
      }
      else {
        return 0;
      }
}

}

