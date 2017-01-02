/**
 * 
 */
package main;

/**
 * The Address class stores the details of an address.
 * 
 * @author Jonathan.Barry
 * @version 1.0
 */
public class Address {

	private String houseName = "";
	private String street = "";
	private String town = "";
	private String county = "";
	private String eircode = "";

	public Address() {
	}

	public Address(String houseName, String street, String town, String county, String eircode) {
		this.houseName = houseName;
		this.street = street;
		this.town = town;
		this.county = county;
		this.eircode = eircode;
	}

	public String toString() {
		return "\nHouse Name: \t\t" + this.houseName + "\nStreet: \t\t" + this.street + "\nTown: \t\t\t" + this.town
				+ "\nCounty: \t\t" + this.county + "\nEircode: \t\t" + this.eircode;
	}
	
	/**
	 * method to update the house name 
	 * @param newHouseName The updated house name
	 */
	public void updateHouseName(String newHouseName){
		System.out.println("The existing house name is: " + this.getHouseName());
		this.setHouseName(newHouseName);
		System.out.println(
				"The contact's house name is now: " + this.getHouseName());		
	}
	
	/**
	 * method to update the street name 
	 * @param newTownName The updated street name
	 */
	public void updateStreetName(String newStreetName){
		System.out.println("The existing street name is: " + this.getStreet());
		this.setStreet(newStreetName);
		System.out.println(
				"The contact's street name is now: " + this.getStreet());		
	}
	
	/**
	 * method to update the town name 
	 * @param newTownName The updated Town Name
	 */
	public void updateTownName(String newTownName){
		System.out.println("The existing town name is: " + this.getTown());
		this.setTown(newTownName);
		System.out.println(
				"The contact's town name is now: " + this.getTown());		
	}
	
	/**
	 * method to update the county name 
	 * @param newCountyName The updated county name
	 */
	public void updateCountyName(String newCountyName){
		System.out.println("The existing county name is: " + this.getCounty());
		this.setCounty(newCountyName);
		System.out.println(
				"The contact's county name is now: " + this.getCounty());		
	}
	
	/**
	 * method to update the eircode name 
	 * @param newEricodeName The updated eircode name
	 */
	public void updateEircodeName(String newEricodeName){
		System.out.println("The existing eircode is: " + this.getEircode());
		this.setEircode(newEricodeName);
		System.out.println(
				"The contact's eircode is now: " + this.getEircode());		
	}
	

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getEircode() {
		return eircode;
	}

	public void setEircode(String eircode) {
		this.eircode = eircode;
	}

}
