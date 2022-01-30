import java.util.Scanner;

public class MobilePhoneWorkingDemo {
	static Scanner scanner = new Scanner(System.in);
	static MobilePhone mp = new MobilePhone("9995550000");
	public static void main(String[] args) {
		
		
	       boolean quit = false;
	        startPhone();
	        printActions();
	        while(!quit) {
	            System.out.println("\nEnter action: (6 to show available actions)");
	            int action = scanner.nextInt();
	            scanner.nextLine();

	            switch (action) {
	                case 0: 
	                    System.out.println("\nShutting down...");
	                    quit = true;
	                    break;

	                case 1:
	                    mp.printContacts();
	                    break;

	                case 2:
	                    addContact();
	                    break;

	                case 3:
	                    updateContact();
	                    break;

	                case 4:
	                    removeContact();
	                    break;

	                case 5:
	                    queryContact();
	                    break;

	                case 6:
	                    printActions();
	                    break;
	            }

	        }

	    }

	private static void addContact() {
		System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String newNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(newName, newNumber);
        if(mp.addNewContact(newContact)) {
        	System.out.println("Name: "+newName+" Phone Number: "+newNumber+" is successfully created");
        
        }
        }
	private static void updateContact() {
		System.out.println("Enter existing contact name to be updated: ");
        String newName = scanner.nextLine();
        Contacts oldContact = mp.queryContacts(newName);
        if(oldContact == null) {
        System.out.println("There does not exist any name such as: "+newName);
        }
        //there exists newName
		System.out.println("Enter the new contact name: ");
        String Name = scanner.nextLine();
        System.out.println("Enter the new phone number: ");
        String newNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(Name, newNumber);
        if(mp.updateExistingContact(oldContact, newContact)) {
        	System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record.");
        }
        }
	
	public static void removeContact() {
	       System.out.println("Enter existing contact name: ");
	        String name = scanner.nextLine();
	        Contacts existingContactRecord = mp.queryContacts(name);
	        if (existingContactRecord == null) {
	            System.out.println("Contact not found.");
	            return;
	        }
	        //there exists a contact name
	        
	        if(mp.removeContact(existingContactRecord)) {
	            System.out.println("Successfully deleted");
	        } else {
	            System.out.println("Error deleting contact");
	        }
	        	
	        }
	
	   private static void queryContact() {
	        System.out.println("Enter existing contact name: ");
	        String name = scanner.nextLine();
	        Contacts existingContactRecord = mp.queryContacts(name);
	        if (existingContactRecord == null) {
	            System.out.println("Contact not found.");
	            return;
	        }

	        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getNumber());
	    }
		
		
	
	
		
		
	
	   private static void startPhone() {
	        System.out.println("Starting phone...");
	    }

	    private static void printActions() {
	        System.out.println("\nAvailable actions:\npress");
	        System.out.println("0  - to shutdown\n" +
	                           "1  - to print contacts\n" +
	                           "2  - to add a new contact\n" +
	                           "3  - to update existing an existing contact\n" +
	                           "4  - to remove an existing contact\n" +
	                           "5  - query if an existing contact exists\n" +
	                           "6  - to print a list of available actions.");
	        System.out.println("Choose your action: ");
	    }



	
        
        
        
	
	
	
}

