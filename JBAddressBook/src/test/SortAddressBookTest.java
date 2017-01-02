package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.Address;
import main.AddressBook;
import main.Person;

public class SortAddressBookTest {

	private AddressBook book;
	private Person contact1;
	private Person contact2;
	private Person contact3;
	
	@Before
	public void setUp() throws Exception {
		
		book = new AddressBook();
		
		contact1 = new Person("Mary", "Daly", "mary@test.ie", "05860223", "0851231223",
				new Address("433", "Left St", "Mahon", "Cork", "X13 PF32"));
		contact2 = new Person("Mike", "Cody", "mike@test.ie", "05860244", "0871234444",
				new Address("44", "Top St", "Dungarvan", "Waterford", "X33 PD52"));
		contact3 = new Person("Jonathan", "Barry", "jonathan@test.ie", "05860223", "0871234567",
				new Address("23", "Main St", "Dungarvan", "Waterford", "X22 PD62"));
		
		book.addContact(contact1);
		book.addContact(contact2);
		book.addContact(contact3);
	}

	@Test
	public void sortByFirstNameTest() {
		book.sortByFirstName();
		
		Assert.assertTrue("Contact 3 is now at the first index", book.getContacts().get(0).equals(contact3));
		Assert.assertTrue("Contact 1 is now at the second index", book.getContacts().get(1).equals(contact1));
		Assert.assertTrue("Contact 2 is now at the Third index", book.getContacts().get(2).equals(contact2));
	}
	
	@Test
	public void sortByLastNameTest() {
		book.sortByLastName();
		
		Assert.assertTrue("Contact 3 is now at the first index", book.getContacts().get(0).equals(contact3));
		Assert.assertTrue("Contact 2 is now at the second index", book.getContacts().get(1).equals(contact2));
		Assert.assertTrue("Contact 1 is now at the Third index", book.getContacts().get(2).equals(contact1));
	}

}
