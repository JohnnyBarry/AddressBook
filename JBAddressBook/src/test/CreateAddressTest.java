package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Address;

public class CreateAddressTest {

	@Test
	public void test() {
		Address testAddr = new Address("44", "Main st", "Ballyduff", "Waterford", "X22 PD62");
		assertTrue("The Address obj was created.", testAddr.getHouseName().equals("44")
				&& testAddr.getStreet().equals("Main st") && testAddr.getTown().equals("Ballyduff")
				&& testAddr.getCounty().equals("Waterford") && testAddr.getEircode().equals("X22 PD62"));
	}

}
