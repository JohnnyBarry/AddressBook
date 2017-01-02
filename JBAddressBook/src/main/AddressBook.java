
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Address Book class stores a list of people and has methods that allow the
 * list to be updated, edited and sorted
 * 
 * @author Jonathan.Barry
 * @version 1.0
 *
 */
public class AddressBook {

	private List<Person> contacts;

	public AddressBook() {
		this.contacts = new ArrayList<Person>();
	}

	/**
	 * This adds a contact to the contacts list and returns a boolean to
	 * show if the operation is successful.
	 * @param Person
	 * @return boolean
	 */
	public boolean addContact(Person p) {
		return this.contacts.add(p);
	}

	/**
	 * This removes a contact from the contacts list and returns a boolean to
	 * show if the operation is successful.
	 * 
	 * @param Person
	 * @return boolean
	 */
	public boolean removeContact(Person p) {
		return this.contacts.remove(p);
	}

	/**
	 * Finds contacts in the address book based that match the first and second
	 * names entered.
	 * 
	 * @param firstName
	 * @param lastName
	 * @return Person
	 */
	public Person findContact(String firstName, String lastName) {
		for (Person person : contacts) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				return person;
			}
		}
		return null;
	}
	
	/**
	 * Lists all contacts by name
	 */
	public void listContactsByName(){
		System.out.println("\n************* All Contacts ******************\n");		
		
		for (Person person : contacts) {
			System.out.println(person.getFirstName()+" "+person.getLastName());
		}
		System.out.println("\n**********************************************\n");
	}
	
	/**
	 * Sorts the contacts list by first name
	 */
	public void sortByFirstName(){
		Collections.sort(contacts, Person.COMPARE_BY_FIRST_NAME);
	}
	
	/**
	 * Sorts the contacts list by last name
	 */
	public void sortByLastName(){
		Collections.sort(contacts, Person.COMPARE_BY_LAST_NAME);
	}
	
	/**
	 * Reverses the List of contacts.
	 */
	public void reverseList(){
		Collections.reverse(contacts);
	}

	public List<Person> getContacts() {
		return contacts;
	}

	public void setContacts(List<Person> contacts) {
		this.contacts = contacts;
	}

}
