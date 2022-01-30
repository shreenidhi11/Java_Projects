import java.util.ArrayList;
//import java.util.Collections;
import java.util.Scanner;

public class MobilePhone {

	private ArrayList<Contacts> mycontacts;
	Scanner sc = new Scanner(System.in);
	String name;
	private String number;
	
	public MobilePhone(String number){
		this.number = number;
		this.mycontacts = new ArrayList<Contacts>();
	}
	
	public void printOptions() {
		System.out.println("1. Print list of contacts\n2. Add a new contact\n3. Update Existing contact\n4. Remove a contact\n5. Find a contact list");
	}
	
	public void PrintContacts() {
		for(Contacts i : mycontacts) {
		System.out.println("Name: "+i.getName()+" Phone Number: "+i.getNumber());
	}
	
	}
	public  boolean addNewContact(Contacts contact) {
		
//		System.out.println("Enter new name");
//		name = sc.nextLine();
//		
//		System.out.println("Enter number");
//		number = sc.nextLine();
//		
		if(findContact(contact.getName()) >=0) {
			System.out.println("The contact already exists");
			return false;
		}
		else {
			mycontacts.add(contact);
			return true;
		}
		
	}
	
	public boolean updateExistingContact(Contacts oldContact, Contacts newContact) {
		int found = findContact(oldContact);
		if(found == -1) {
			System.out.println("The old contact does not exist in the Contact List");
			return false;
		}
		
		this.mycontacts.set(found, newContact);
		System.out.println("Contact name succesfully updated");
		return true;
		
	}
	
	public String queryContact(Contacts contact) {
        if(findContact(contact) >=0) {
            return contact.getName();
        }
        return null;
    }
	
	public  Contacts queryContacts(String name) {
        int position = findContact(name);
        if(position >=0) {
            return this.mycontacts.get(position);
        }

        return null;
    }

	

	
	public boolean removeContact(Contacts contact) {
		int position = findContact(contact);
		if(position == -1) {
			System.out.println(contact.getName() +", was not found.");
            return false;
		}
		
		 this.mycontacts.remove(position);
	        System.out.println(contact.getName() + ", was deleted.");
	       return true;
	}
	
	public  int findContact(Contacts contact) {
		 return this.mycontacts.indexOf(contact);
	}
	
	public   int  findContact(String name) {
		for (int i = 0; i < mycontacts.size(); i++) 
		{
			Contacts contacts = mycontacts.get(i);
			if(contacts.getName().equals(name))			{
				return i;
			}
			
		}
		return -1;
		
	}
	public  int  queryContact(String name) {
		for (int i = 0; i < mycontacts.size(); i++) 
		{
			Contacts contacts = mycontacts.get(i);
			if(contacts.getName().equals(name))
			{
				return i;
			}
			
		}
		return -1;
		
	}
	
	 public void printContacts() {
	        System.out.println("Contact List");
	        for(int i=0; i<this.mycontacts.size(); i++) {
	            System.out.println((i+1) + "." +
	                        this.mycontacts.get(i).getName() + " -> " +
	                        this.mycontacts.get(i).getNumber());
	        }
	
		
		
		}
	}
	

