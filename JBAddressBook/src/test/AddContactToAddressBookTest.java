package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.Address;
import main.AddressBook;
import main.Person;

public class AddContactToAddressBookTest {

	private AddressBook book;
	private Person contact1;
	
	@Before
	public void setUp() throws Exception {
		
		book = new AddressBook();
		contact1 = new Person("Jonathan", "Barry", "jonathan@test.ie", "05860223", "0871234567",
				new Address("23", "Main St", "Dungarvan", "Waterford", "X22 PD62"));
	}

	@Test
	public void addContactTest() {
		book.addContact(contact1);
		
		Assert.assertTrue(book.getContacts().size() == 1);
		Assert.assertTrue(book.getContacts().contains(contact1));
	}

}
