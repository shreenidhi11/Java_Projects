import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Booking {

	List<Seats> seat = new ArrayList<Seats>();
	private String name;
	
	//List<Seats> classType = new ArrayList<>();
	
	
	
	public Booking(String name, int totalRows, int rowSeats) {
		super();
		
		this.name = name;
		
		//Initialise all the seats
		
		int lastRow ='A' + totalRows;
		for(char rows ='A'; rows <= lastRow ; rows++) {
			for( int seatNumber =1 ; seatNumber<=rowSeats; seatNumber++) {
				double price = 100.00;
				String ticketType= "Economy";
				//checking for Business class seats
				if(rows >= 'A' && rows <='D') {
					price = 200;
					ticketType = "Business";
					//checking for Window Seats booking
					if(seatNumber == 1 || seatNumber == 6) {
						price = 275.00;
						seat.add(new Seats(rows+String.format("%02d", seatNumber), price, ticketType ));
					}
					else 
					{
					seat.add(new Seats(rows+String.format("%02d", seatNumber), price, ticketType));
				}
				}
				//checking for Economy class seats
				else {
						price = 120;
						
							//checking for Window Seats booking
						if(seatNumber == 1 || seatNumber == 6) {
							price = 175.00;
							seat.add(new Seats(rows+String.format("%02d", seatNumber), price, ticketType));
						}
						else 
						{
						seat.add(new Seats(rows+String.format("%02d", seatNumber), price, ticketType));
					}
					}
				}
			}
		}

	public List<Seats> getSeat() {
		return seat;
	}

	public void setSeat(List<Seats> seat) {
		this.seat = seat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public boolean bookingSeat(String seatName) {
		Seats foundSeat = findSeatName(seatName);
		if(foundSeat != null) {
			
			return foundSeat.toReserveSeat(seatName);
			
		}
		
		
		return false;
	}
	
	
	public boolean cancelSeat(String seatName) {
		Seats foundSeat = findSeatName(seatName);
		if(foundSeat != null) {
			
			return foundSeat.toCancelReservation(seatName);
			
		}
		
		return false;
	}
	
	
	
	public Seats findSeatName(String seatName) {
		for(Seats s: seat) {
			if(s.getSeatNumber().equals(seatName)) 
			{
			return s;
			}
		}
		
		return null;
	}
	
	
	public List<Seats> getSeatType(String seatType){

		List<Seats> classType = new ArrayList<>();
		for(Seats s : seat) {
			if(s.getType().equalsIgnoreCase(seatType)) {
			classType.add(s);
		}
		
		}
		return classType;
		
	}
	
	public List<Seats> getAvailableSeats(){
		List<Seats> availableSeats = new ArrayList<>();
		for(Seats s : seat) {
			if(!s.isReserver()) {
			availableSeats.add(s);
			}
		}
		
		return availableSeats;
	}
	
	
	
	
	
		
		
	}
	
	
	

