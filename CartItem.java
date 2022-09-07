public class CartItem {
    
Product p;
String productOptions;

public CartItem(Product p, String productOptions) {
    
    this.p = p; 
    this.productOptions = productOptions; 
}

public CartItem(Product p) {
    this.p = p;
}

public Product getProduct() {
	return p;
}

public void setProduct(Product p) {

	this.p = p;
}

public String getProductOptions() {

    return productOptions;
}

public void setProductOptions(String productOptions) {

    this.productOptions = productOptions;

}

public void printC() {   
	System.out.printf("\nId: %-5s Category: %-9s Name: %-20s Price: %7.1f productOptions: %8s", p.getId(), p.getCategory(), p.getName(), p.getPrice(), productOptions);
	
}


}
