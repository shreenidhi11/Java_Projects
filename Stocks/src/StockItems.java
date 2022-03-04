
public class StockItems implements Comparable<StockItems>{

	private final String name;
	private double price;
	private int quantity;
	private int reserved = 0;
	public int getReserved() {
		return reserved;
	}
	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
	public StockItems(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if(price > 0.0) {
		this.price = price;
	}
	}
	public int getQuantityInStock() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		
	}
	
	public void adjustQuantity(int quantity) {
		this.quantity = quantity + this.quantity;
	}
	public String getName() {
		return name;
	}
	@Override
	public boolean equals(Object arg0) {
		
		if( arg0 == this) {
			return true;
		}
		if(arg0 == null || arg0.getClass() != this.getClass()) {
			return false;
		}
		
		
		String arg0name = ((StockItems)arg0).getName();
		return this.getName().equals(arg0name);
		
		
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.name.hashCode() + 31;
	}
	@Override
	public int compareTo(StockItems o) {
		System.out.println("Entering StockItems.compareTo");
		if( this == o ) {
			return 0;
		}
		if( o!=null) {
			return this.name.compareTo(o.getName());
		}
		
		throw new NullPointerException();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Stock Item details\n"+"Item name: "+this.name+", Item price: "+this.price +", Quantity of Item present in stock: "+ this.quantity+ "\n";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
