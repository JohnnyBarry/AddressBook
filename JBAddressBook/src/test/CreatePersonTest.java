package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Address;
import main.Person;

public class CreatePersonTest {

	@Test
	public void createPersonTest() {
		Address address = new Address("2", "Main St", "Ballyduff", "Waterford", "X22 PD62");
		Person p = new Person("John", "Barry", "john@test.ie", "05812345", "0871234567", address);
		assertTrue("First Name is 'John'", p.getFirstName().equals("John"));
		assertTrue("Last Name is 'Barry'", p.getLastName().equals("Barry"));
		assertTrue("Email is 'john@test.ie'", p.getEmail().equals("john@test.ie"));
		assertTrue("Home phone num is '05812345'", p.getHomeTelNo().equals("05812345"));
		assertTrue("Mobile phone num is '0871234567'", p.getMobileTelNo().equals("0871234567"));
		assertTrue("Address House Name is '2'", p.getAddress().getHouseName().equals("2"));
		assertTrue("Address Street Name is 'Main St'", p.getAddress().getStreet().equals("Main St"));
		assertTrue("Address Town Name is 'Ballyduff'", p.getAddress().getTown().equals("Ballyduff"));
		assertTrue("Address County Name is 'Waterford'", p.getAddress().getCounty().equals("Waterford"));
		assertTrue("Address eircode is 'X22 PD62'", p.getAddress().getEircode().equals("X22 PD62"));
	}

}
