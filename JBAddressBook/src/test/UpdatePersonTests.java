package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.Address;
import main.Person;

public class UpdatePersonTests {

	private Address address;
	private Person p;
	
	@Before
	public void setUp() throws Exception {
		address = new Address("2", "Main St", "Ballyduff", "Waterford", "X22 PD62");
		p = new Person("John", "Barry", "john@test.ie", "05812345", "0871234567", address);
	}

	@Test
	public void updateFirstNameTest() {
		p.updateFirstName("Jonathan");
		assertTrue("The First name is now 'Jonathan'", p.getFirstName().equals("Jonathan"));
	}
	
	@Test
	public void updateLastNameTest() {
		p.updateLastName("Daly");
		assertTrue("The last name is now 'Daly'", p.getLastName().equals("Daly"));
	}
	
	@Test
	public void updateEmailTest() {
		p.updateEmail("jonathan@test.ie");
		assertTrue("The email is now 'jonathan@test.ie'", p.getEmail().equals("jonathan@test.ie"));
	}
	
	@Test
	public void updateHomePhoneTest(){
		p.updateHomePhoneNum("05812344");
		assertTrue("The home phone is now '05812344'", p.getHomeTelNo().equals("05812344"));
	}
	
	@Test
	public void updateMobilePhoneTest(){
		p.updateMobilePhoneNum("0861234567");
		assertTrue("The mobile phone is now '0861234567'", p.getMobileTelNo().equals("0861234567"));
	}

}
