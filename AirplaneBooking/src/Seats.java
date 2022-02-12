
  public class Seats implements Comparable<Seats> {
	
	private String SeatNumber;
	private boolean reserved = false;
	 private double price;
	private String type = "";
	//initializing a new seat number in the memory
	
	public String getSeatNumber() {
		return SeatNumber;
	}
	public Seats(String seatNumber, double price, String type) {
		super();
		SeatNumber = seatNumber;
		this.price = price;
		this.type = type;
	}
	public boolean isReserver() {
		return reserved;
	}
	
	
	
	
    public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
    public int compareTo(Seats seat) {
        return this.SeatNumber.compareToIgnoreCase(seat.getSeatNumber());
        
    }
	
	public boolean toReserveSeat(String seatNum) {
		if(!this.reserved) {
			System.out.println("Seat Number" +seatNum+" is reserved ");
			this.reserved = true;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean toCancelReservation(String seatNum) {
		if(this.reserved) {
			System.out.println("Reservation of Seat Number" +seatNum+" is cancelled");
			this.reserved = false;
			return true;
		}
		else
		{
			System.out.println("Reservation of Seat Number" +seatNum+" cannot be canceled either because the seat is not booked previously or the seat booking has already been canceled");
			return false;	
			
		}
	}
	public double getPrice() {
		return price;
	}

	
	
	
		
		 
		
	}
	
	
	
	



