import java.util.ArrayList;

public class Cart {

ArrayList<CartItem> items = new ArrayList<CartItem>();

public void addItem(Product p, String options) { 
    CartItem item = new CartItem(p,options); // creating an cartItem object 
    items.add(item);
}
public void removeItem(String productId) {

    CartItem c = null; 
    for (CartItem item : items) {
          if(item.getProduct().getId().equals(productId)) {
              c = item;
          }
    }
    items.remove(c);
}

public ArrayList<CartItem> getItems() {
      return items;
}

public void printCartItems() {
    for(CartItem i: items) {
         i.printC();
    }

}
}
