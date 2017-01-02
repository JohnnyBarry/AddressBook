/**
 * 
 */
package main;

import java.util.Comparator;

/**
 * The Person class holds information peoples personnel information e.g. name
 * address etc.
 * 
 * @author Jonathan.Barry
 * @version 1.0
 *
 */

public class Person {

	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private String homeTelNo = "";
	private String mobileTelNo = "";
	private Address address;

	public Person() {

	}

	public Person(String firstName, String lastName, String email, String homeTelNo, String mobileTelNo,
			Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.homeTelNo = homeTelNo;
		this.mobileTelNo = mobileTelNo;
		this.address = address;
	}

	public String toString() {
		return "\nFirstName: \t\t" + this.firstName + "\nLastName: \t\t" + this.lastName + "\nEmail: \t\t\t"
				+ this.email + "\nHome No: \t\t" + this.homeTelNo + "\nMobile No: \t\t" + this.mobileTelNo
				+ this.address.toString();
	}

	
	/**
	 * Compares person objects by first name.
	 */
	public static Comparator<Person> COMPARE_BY_FIRST_NAME = new Comparator<Person>() {
		public int compare(Person one, Person other) {
			return one.firstName.compareTo(other.firstName);
		}
	};
	
	/**
	 * Compares person objects by last name.
	 */
	public static Comparator<Person> COMPARE_BY_LAST_NAME = new Comparator<Person>() {
		public int compare(Person one, Person other) {
			return one.lastName.compareTo(other.lastName);
		}
	};

	/**
	 * method to updated the person's first name
	 * 
	 * @param newFirstName
	 *            The updated first name
	 */
	public void updateFirstName(String newFirstName) {
		System.out.println("The existing first name is: " + this.getFirstName());
		this.setFirstName(newFirstName);
		System.out.println("The contact's first name is now: " + this.getFirstName());
	}

	/**
	 * method to updated the person's last name
	 * 
	 * @param newLastName
	 *            The updated last name
	 */
	public void updateLastName(String newLastName) {
		System.out.println("The existing last name is: " + this.getLastName());
		this.setLastName(newLastName);
		System.out.println("The contact's last name is now: " + this.getLastName());
	}

	/**
	 * method to update the person's email
	 * 
	 * @param newEmail
	 *            The updated email address.
	 */
	public void updateEmail(String newEmail) {
		System.out.println("The existing email address is: " + this.getEmail());
		this.setEmail(newEmail);
		System.out.println("The contact's email address is now: " + this.getEmail());
	}

	/**
	 * method to update the person's home phone number
	 * 
	 * @param newHomePhoneNum
	 *            The updated number
	 */
	public void updateHomePhoneNum(String newHomePhoneNum) {
		System.out.println("The existing home telephone number is: " + this.getHomeTelNo());
		this.setHomeTelNo(newHomePhoneNum);
		System.out.println("The contact's home telephone number is now: " + this.getHomeTelNo());
	}

	/**
	 * method to update the person's mobile phone number
	 * 
	 * @param newMobileNo
	 *            The updated mobile phone number
	 */
	public void updateMobilePhoneNum(String newMobileNo) {
		System.out.println("The existing mobile telephone number is: " + this.getMobileTelNo());
		this.setMobileTelNo(newMobileNo);
		System.out.println("The contact's mobile telephone number is now: " + this.getMobileTelNo());
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomeTelNo() {
		return homeTelNo;
	}

	public void setHomeTelNo(String homeTelNo) {
		this.homeTelNo = homeTelNo;
	}

	public String getMobileTelNo() {
		return mobileTelNo;
	}

	public void setMobileTelNo(String mobileTelNo) {
		this.mobileTelNo = mobileTelNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
