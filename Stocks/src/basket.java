import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class basket {

	private final String name;
	private final Map<StockItems, Integer> list;
//	private final StockList stocks = new 
	public basket(String name) {
		super();
		this.name = name;
		this.list = new HashMap<>();
	}
	
	public int addtoBasket(StockItems item, int quantity) {
		if(item!=null && quantity >=0) {
			
			int inBasket = list.getOrDefault(item, 0);
			int addStocks = inBasket + quantity;
			list.put(item, addStocks);
			return addStocks;
		}
		return 0;
		
		
	}
	
	
	public int removeFromBasket(StockItems item, int quantity) {
		if(item!=null && quantity >=0) {
			
			int inBasket = list.getOrDefault(item, 0);
			int newQuantity = inBasket - quantity;
			if( newQuantity >= 0) {
			list.put(item, inBasket-quantity);
			return  newQuantity;
			}
			else if (newQuantity == 0) {
				list.remove(item);
				return inBasket-quantity;
				
			}
			
		}
		return 0;	
	}
	
	public String basketCost(Map<StockItems, Integer> basketItems) {
		System.out.println("Calculating the cost of your basket");
		double totalCost =0.0;
		for(Map.Entry<StockItems, Integer> b: basketItems.entrySet() ) {
			StockItems inBasket = b.getKey();
			if( inBasket != null && inBasket.getReserved() >=0) {
				double price = inBasket.getReserved() * inBasket.getPrice();
				totalCost+=price;
			}
		}
		
		
		return String.format("%.2f",totalCost);
	}
	
	
	 
	public Map<StockItems, Integer> items(){
		return Collections.unmodifiableMap(list);
	}
	

	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "\nItems in my basket\n";
		double totalCost = 0.0;
		for(Map.Entry<StockItems, Integer > item: list.entrySet()) {
//			StockItems stockItems = item.getValue();
//			double itemValue = stockItems.getPrice() * stockItems.getQuantityInStock();
			s = s+ item.getKey() + item.getValue() + " purchased\n";
			totalCost+= item.getKey().getPrice() * item.getValue();
			
		}
		return s + "Total cost is "+ totalCost;
		
	}
	
	
	
}
