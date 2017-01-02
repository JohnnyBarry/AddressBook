package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Address;

public class UpdateAddressTests {
	

	@Test
	public void updateHouseName() {
		Address testAddr = new Address("44", "Main st", "Ballyduff", "Waterford", "X22 PD62");
		testAddr.updateHouseName("22");
		assertTrue("The house name is now 22", testAddr.getHouseName().equals("22"));
	}
	
	@Test
	public void updateStreet() {
		Address testAddr = new Address("44", "Main st", "Ballyduff", "Waterford", "X22 PD62");
		testAddr.updateStreetName("Left st");
		assertTrue("The street is now 'Left st'", testAddr.getStreet().equals("Left st"));
	}
	
	@Test
	public void updateTown() {
		Address testAddr = new Address("44", "Main st", "Ballyduff", "Waterford", "X22 PD62");
		testAddr.updateTownName("Fermoy");
		assertTrue("The town is now 'Fermoy'", testAddr.getTown().equals("Fermoy"));
	}
	
	@Test
	public void updateCounty() {
		Address testAddr = new Address("44", "Main st", "Ballyduff", "Waterford", "X22 PD62");
		testAddr.updateCountyName("Cork");
		assertTrue("The county is now 'Cork'", testAddr.getCounty().equals("Cork"));
	}
	
	@Test
	public void updateEircode() {
		Address testAddr = new Address("44", "Main st", "Ballyduff", "Waterford", "X22 PD62");
		testAddr.updateEircodeName("X22 PD66");
		assertTrue("The ericode is now 'X22 PD62'", testAddr.getEircode().equals("X22 PD66"));
	}

}
