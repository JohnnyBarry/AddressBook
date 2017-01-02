package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.AddressBook;

public class CreateAddressBookTest {

	
	@Test
	public void createAddressBookTest() {
		AddressBook book = new AddressBook();
		assertNotNull(book);
		assertTrue(book.getContacts().size() == 0);
		assertTrue(book.getClass().getName().equals("main.AddressBook"));
	}

}
