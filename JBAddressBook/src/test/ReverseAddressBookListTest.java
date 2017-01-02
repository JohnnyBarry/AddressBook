package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.Address;
import main.AddressBook;
import main.Person;

public class ReverseAddressBookListTest {

	AddressBook book;
	Person contact1;
	Person contact2;
	
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
	public void addContactTest() {
		book.reverseList();
		
		Assert.assertTrue("Contact 2 is now at the first index", book.getContacts().get(0).equals(contact2));
		Assert.assertTrue("Contact 1 is now at the second index", book.getContacts().get(1).equals(contact1));
	}

}
