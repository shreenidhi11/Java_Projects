import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Airplane {
	static Booking book = new Booking("SpiceJet",8,6);

	
	public static void main(String[] args) {
	//	Scanner sc = new Scanner(System.in);	
	//Displaying the seats first before any booking
	

	//Booking a seat from available seats
	int option =4;
	while(option<=5) {
		Scanner sc = new Scanner(System.in);	
		System.out.println("1. Print Seats\n2. Print Seats as per class type\n3. Book a seat\n4. Cancel a seat\n5. Available Seats\n");
		option = sc.nextInt();
		sc.nextLine();
		switch(option) {
		case 1:
			printSeats(book.getSeat());
			break;
		case 2:
			System.out.println("Please enter the class type ");
			String classType = sc.nextLine();
			List<Seats> economySeats = displaySeatsType(classType);
			printSeats(economySeats);
			break;
		case 3:
			bookSeat();
			break;
		case 4: 
			cancelSeat();
			break;
		case 5:
			List<Seats> availableSeats = book.getAvailableSeats();
			printSeats(availableSeats);
			break;
			
		}
	}
	
	
	}
	
	
	
	

	
	
	
	public static boolean bookSeat() {
		Scanner sc = new Scanner(System.in);
		// sc.nextLine();
		System.out.println("Please enter the seatNumber ");
		String seatNumber = sc.nextLine();
		if(book.bookingSeat(seatNumber)) {
			//System.out.println(seatNumber + " is booked");
		//	sc.close();
			return true;
			
		}
		//sc.close();
		return false;
	}
	
	public static boolean cancelSeat() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the seatNumber ");
		String seatNumber = sc.nextLine();
		if(book.cancelSeat(seatNumber)) {
			//System.out.println(seatNumber + " is booked");
		}
		
		return false;
	}
	
	
	public static List<Seats> displaySeatsType(String classType){

		
		List<Seats> getSeatsType  = book.getSeatType(classType);
		
		
		
		return getSeatsType;
	}
	
	
	
	
	
	public static void printSeats(List<Seats> DisplaySeats) {
		
		for(Seats displaySeats :  DisplaySeats) {
			if(displaySeats.isReserver()) {
			System.out.print(displaySeats.getSeatNumber() + " ->Price " + displaySeats.getPrice()+ "->" + displaySeats.getType()+"-> "+"Booked"+"| ");
		}
			else {
				
				System.out.print(displaySeats.getSeatNumber() + " ->Price " + displaySeats.getPrice()+ "->" + displaySeats.getType()+"-> "+" Not Booked"+"| ");
			}
		}
		
		System.out.println();
	}

}
