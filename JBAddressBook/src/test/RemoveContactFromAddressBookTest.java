package test;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import main.Address;
import main.AddressBook;
import main.Person;

public class RemoveContactFromAddressBookTest {

	private AddressBook book;
	private Person contact1;
	
	@Before
	public void setUp() throws Exception {
		
		book = new AddressBook();
		contact1 = new Person("Jonathan", "Barry", "jonathan@test.ie", "05860223", "0871234567",
				new Address("23", "Main St", "Dungarvan", "Waterford", "X22 PD62"));
		book.addContact(contact1);
	}

	@Test
	public void removeContactTest() {
		
		book.removeContact(contact1);
		assertFalse(book.getContacts().contains(contact1));
	}

}
