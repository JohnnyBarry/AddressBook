package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.Address;
import main.AddressBook;
import main.Person;

public class FindContactInAddressBookTest {

	private AddressBook book;
	private Person contact1;
	private Person contact2;
	
	@Before
	public void setUp() throws Exception {
		
		book = new AddressBook();
		contact1 = new Person("Jonathan", "Barry", "jonathan@test.ie", "05860223", "0871234567",
				new Address("23", "Main St", "Dungarvan", "Waterford", "X22 PD62"));
		contact2 = new Person("Mike", "Cody", "mike@test.ie", "05860244", "0871234444",
				new Address("44", "Top St", "Dungarvan", "Waterford", "X33 PD52"));
		book.addContact(contact1);
		book.addContact(contact2);
	}

	@Test
	public void findContactTest() {
		
		Person foundPerson = book.findContact("Jonathan", "Barry");
		assertTrue(foundPerson.equals(contact1));
		
	}

}
