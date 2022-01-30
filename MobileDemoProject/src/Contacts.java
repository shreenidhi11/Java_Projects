
public class Contacts {

	String name;
	String number;
	public Contacts(String name, String number) {
		//super();
		this.name = name;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public static Contacts createContact(String name, String number) {
		return new Contacts(name,number);
	}
}
