import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
	private final Map<String, StockItems> list;

	public StockList() {
		this.list = new LinkedHashMap<>();
	}
	
	public int addStock(StockItems item) {
		if(item!=null) {
		//	System.out.println("address of the passed items: "+item);
			//Now check if we already have quantities of this item
			StockItems inStock = list.getOrDefault(item.getName(), item);
		//	System.out.println("Address of the first item: "+inStock);
		//	System.out.println(item);
//			//in this new method if the item is already present in the map, it will return or 
			//if not it will return the passed argument i.e item to inStock.
			
			//if there are already stocks in the item, adjust the quantity.
			if(inStock==item) {
				list.put(item.getName(),item);
				return item.getQuantityInStock();
				
			}
			
			inStock.adjustQuantity(item.getQuantityInStock());
		}
		
		return 0;
	}
	
	public int sellStock(String item, int quantity) {
		StockItems inStock = list.getOrDefault(item,null);
		if((inStock!=null) && (inStock.getQuantityInStock() >= quantity) && (quantity >=0) ) {
			inStock.adjustQuantity(-quantity);
			return quantity; 
		}
		return 0;
		
	}
	
	// getting a single stockitem information by passing a item name
	public StockItems get(String key) {
		return list.get(key);
	}
	
	public Map<String, StockItems> items(){
		return Collections.unmodifiableMap(list);
	}
	
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "\nList of all the stock items in the stock list\n";
		double totalCost = 0.0;
		for(Map.Entry<String, StockItems> item: list.entrySet()) {
			StockItems stockItems = item.getValue();
			double itemValue = stockItems.getPrice() * stockItems.getQuantityInStock();
			s = s+ "-> "+ stockItems + "There are "+ stockItems.getQuantityInStock() +" "+ stockItems.getName()+ " in stock. With total value of ";
			s = s + String.format("%.2f",itemValue) +"\n";
			totalCost+= itemValue;
			
		}
		return s + "Total cost of all the items in the stock list  is "+ String.format("%.2f",totalCost);
		
	}
	
	
}
