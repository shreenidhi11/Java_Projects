import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	
	private static StockList stocklist = new StockList();
	static basket shreeBasket = new basket("Shreenidhi");
	static basket shruBasket = new basket("shruthi");
	
	public static void main(String[] args) {
		
	Map<String, StockItems> st = stocklist.items();
	

	StockItems temp = new StockItems("bread", 0.86,100);
	stocklist.addStock(temp);
	
	StockItems temp1 = new StockItems("bread", 0.86,20);
	stocklist.addStock(temp1);
	
	addToBasket(shreeBasket,temp, 30); //adding 30 bread from the stocklist containing 127 breads
	
	temp = new StockItems("pastry", 2.10, 10);
	stocklist.addStock(temp);
	addToBasket(shreeBasket, temp, 9); //adding 9 pastry from the stocklist containing 10 pastries

	temp = new StockItems("olives", 10, 90);
	stocklist.addStock(temp);
	addToBasket(shreeBasket,temp, 2); //adding 2 olives from the stocklist containing 90 olives

//	System.out.println(checkOut(shreeBasket));
//	System.out.println(stocklist);
	
	//lets add some more items in the stocklist first. cup, saucer,bags,cakes
	
	StockItems cups = new StockItems("cup",1.00,100);
	stocklist.addStock(cups);
	
	StockItems saucer = new StockItems("saucer",2.00,200);
	stocklist.addStock(saucer);
	
	StockItems bags = new StockItems("bags",3.00,100);
	stocklist.addStock(bags);
	
	StockItems cakes = new StockItems("cakes",1.00,100);
	stocklist.addStock(cakes);
	
	
	System.out.println(stocklist);
	
	//lets create another basket and items to it
	
	addToBasket(shruBasket,cups, 10);
	addToBasket(shruBasket,saucer, 100);
	addToBasket(shruBasket,bags, 10);
	addToBasket(shruBasket,cakes, 50);
	
	System.out.println(shruBasket);
	
	//lets checkout
	
	System.out.println(checkOut(shruBasket));
	
		
	}
	
	
	public static void addToBasket(basket basket, StockItems stock, int quantity) {
		
		int result = basket.addtoBasket(stock, quantity); //to get the result 0 or the total number in the basket
		StockItems inStock = stocklist.get(stock.getName());
		if(inStock == null) {
			System.out.println("The item "+ stock.getName()+" is not present in out list of stocks ");
		}
		else {
			inStock.setReserved(quantity);
			
		}
	}
	
	public static basket checkOut(basket shreeBasket) {
		Scanner sc = new Scanner(System.in);
		int reduceQuantity= 0;
		int inBasket=0;
		for(Map.Entry<StockItems, Integer> b : shreeBasket.items().entrySet()) {
			StockItems inStock = b.getKey();
			if(inStock == null) {
				System.out.println("The item "+ inStock.getName()+" is not present in out list of stocks ");
				return null;
			}
			else {
				
				System.out.println("\n\n------------------------------------------------------------------------\n\n");
				System.out.println("You have currently "+ b.getValue()+ " quantities of "+b.getKey().getName()+ " in your basket\nDo you want reduce your quantities?");
				String answer = sc.nextLine();
				if(answer.equalsIgnoreCase("Yes")){
					reduceQuantity = sc.nextInt();
					sc.nextLine();
					reduceQuantity = shreeBasket.removeFromBasket(inStock, reduceQuantity);
				//After removing extra items need to update the parameter reserved of the respected stock
				
					inStock.setReserved(reduceQuantity);
					System.out.println("Currently there are "+ inStock.getReserved()+" reserved");
					stocklist.sellStock(inStock.getName(), reduceQuantity );
				}
				else {
				System.out.println("We dont want to reduce the items");
				inBasket = inStock.getReserved();
				System.out.println("Currently there are "+ inBasket+"reserved");
				stocklist.sellStock(inStock.getName(), inBasket);
			}
			}
		}
		
		Map<StockItems, Integer> b = shreeBasket.items();
		
		System.out.println(shreeBasket.basketCost(b));
		
		shreeBasket = null;
		return shreeBasket;	
		
	}
	
	
	
	
	public static int sellStocks(String itemName, int quantity) {
		if(itemName!=null && quantity >=0) {
			if(stocklist.sellStock(itemName, quantity) > 0) {
				return stocklist.get(itemName).getQuantityInStock();
			}
		}
		return 0;
			
	}
	

}
