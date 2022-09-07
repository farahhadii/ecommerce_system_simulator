/*
 *  class customer defines a registered customer. It keeps track of the customer's name and address. Also, keeps track
 *  of items inside the customer's cart.  
 *  A unique id is generated when a new customer is created. 
 */
public class Customer implements Comparable {


	private String id;  
	private String name;
	private String shippingAddress;
	private Cart cart;
	
	public Customer(String id)
	{
		this.id = id;
		this.name = "";
		this.shippingAddress = "";
	}
	
	public Customer(String id, String name, String address)
	{
		this.id = id;
		this.name = name;
		this.shippingAddress = address;
		cart = new Cart(); // every customer has a cart 
	}
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getShippingAddress()
	{
		return shippingAddress;
	}
	
	public void setShippingAddress(String shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int compareTo(Object other) {

		Customer other1 = (Customer) other;
        return this.name.compareTo(other1.name);
	}
	
	public void print()
	{
		System.out.printf("\nName: %-20s ID: %3s Address: %-35s", name, id, shippingAddress);
	}
	
	public boolean equals(Object other)
	{
		Customer otherC = (Customer) other;
		return this.id.equals(otherC.id);
	}
	
}
