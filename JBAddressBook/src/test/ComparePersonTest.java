package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Address;
import main.Person;

public class ComparePersonTest {

	@Test
	public void compareFirstNameExpectEqualTest() {
		Address address = new Address("2", "Main St", "Ballyduff", "Waterford", "X22 PD62");
		Person p1 = new Person("John", "Barry", "john@test.ie", "05812345", "0871234567", address);
		Person p2 = new Person("John", "Barry", "john@test.ie", "05812345", "0871234567", address);
		int result = Person.COMPARE_BY_FIRST_NAME.compare(p1, p2);
		assertTrue(result == 0);
	}
	
	@Test 
	public void compareFirstNameExpectGreaterThanTest() {
		Address address = new Address("2", "Main St", "Ballyduff", "Waterford", "X22 PD62");
		Person p1 = new Person("John", "Barry", "john@test.ie", "05812345", "0871234567", address);
		Person p2 = new Person("Alan", "Barry", "john@test.ie", "05812345", "0871234567", address);
		int result = Person.COMPARE_BY_FIRST_NAME.compare(p1, p2);
		assertTrue("Expected to be greater than", result >= 1);
	}
	
	@Test 
	public void compareFirstNameExpectLessThanTest() {
		Address address = new Address("2", "Main St", "Ballyduff", "Waterford", "X22 PD62");
		Person p1 = new Person("John", "Barry", "john@test.ie", "05812345", "0871234567", address);
		Person p2 = new Person("Alan", "Barry", "john@test.ie", "05812345", "0871234567", address);
		int result = Person.COMPARE_BY_FIRST_NAME.compare(p2, p1);
		assertTrue("Expected to be greater than", result <= 1);
	}
	
	@Test
	public void compareLastNameExpectEqualTest() {
		Address address = new Address("2", "Main St", "Ballyduff", "Waterford", "X22 PD62");
		Person p1 = new Person("John", "Barry", "john@test.ie", "05812345", "0871234567", address);
		Person p2 = new Person("John", "Barry", "john@test.ie", "05812345", "0871234567", address);
		int result = Person.COMPARE_BY_LAST_NAME.compare(p1, p2);
		assertTrue(result == 0);
	}

	@Test 
	public void compareLastNameExpectGreaterThanTest() {
		Address address = new Address("2", "Main St", "Ballyduff", "Waterford", "X22 PD62");
		Person p1 = new Person("John", "Barry", "john@test.ie", "05812345", "0871234567", address);
		Person p2 = new Person("John", "Ahern", "john@test.ie", "05812345", "0871234567", address);
		int result = Person.COMPARE_BY_LAST_NAME.compare(p1, p2);
		assertTrue("Expected to be greater than", result >= 1);
	}
	
	@Test 
	public void compareLastNameExpectLessThanTest() {
		Address address = new Address("2", "Main St", "Ballyduff", "Waterford", "X22 PD62");
		Person p1 = new Person("John", "Barry", "john@test.ie", "05812345", "0871234567", address);
		Person p2 = new Person("John", "Ahern", "john@test.ie", "05812345", "0871234567", address);
		int result = Person.COMPARE_BY_LAST_NAME.compare(p2, p1);
		assertTrue("Expected to be greater than", result <= 1);
	}
	
}
