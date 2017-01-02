
package main;

import java.util.Scanner;

/**
 * This is the Address Book applications main class
 * 
 * @author Jonathan.Barry
 *
 */
/**
 * @author Jonathan.Barry
 *
 */
public class AddressBookApp {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		AddressBook myContacts = new AddressBook();
		
		// Create 4 contacts that will be loaded on startup.
		Person contact1 = new Person("Jonathan", "Barry", "jonathan@test.ie", "05860223", "0871234567",
				new Address("23", "Main St", "Dungarvan", "Waterford", "X22 PD62"));
		Person contact2 = new Person("Mike", "Cody", "mike@test.ie", "05860244", "0871234444",
				new Address("44", "Top St", "Dungarvan", "Waterford", "X33 PD52"));
		Person contact3 = new Person("Mary", "Berry", "mary@test.ie", "05860223", "0851231223",
				new Address("433", "Left St", "Mahon", "Cork", "X13 PF32"));
		Person contact4 = new Person("Harry", "Daly", "harry@test.ie", "05860233", "0851235553",
				new Address("223", "Top St", "Fermoy", "Cork", "X43 PG52"));
		myContacts.addContact(contact1);
		myContacts.addContact(contact2);
		myContacts.addContact(contact3);
		myContacts.addContact(contact4);
		
		boolean runMenu = true;

		do {
			printMainMenu();
			int selection = getMenuSelection(6);

			switch (selection) {
			case 1:
				System.out.println("\n******** You wish to find a contact. ********\n ");
				searchForContact(myContacts, getFullNameInput());
				break;
			case 2:
				System.out.println("\n******** You wish to add a contact. ********\n ");
				if (addNewContact(myContacts)) {
					System.out.println("\n****New Contact has been added successfully.****\n");
				} else {
					System.out.println(
							"\n****New Contact has not been added successfully. Please select an option from the main menu to proceed.****\n");
				}
				break;
			case 3:
				System.out.println("\n******** You wish to remove a contact. ********\n ");
				if (removeContact(myContacts)) {
					System.out.println("\n****A Contact has been successfully removed.****\n");
				} else {
					System.out.println("\n****No Contact has been removed.****\n");
				}
				break;
			case 4:
				System.out.println("\n******** You wish to edit a contact. ********\n ");
				String fullName = getFullNameInput();
				Person p = getPersonFromContacts(myContacts, fullName);
				if (p != null) {
					printEditContactMenu(fullName);
					int option = getMenuSelection(11);
					editContact(fullName, option, myContacts, p);
				} else {
					System.out.println(fullName + " is not present in the address book.");
				}
				break;
			case 5:
				System.out.println("\n******** You wish to view all contacts by name. ********\n ");
				printSortMenu();
				int sortOption = getMenuSelection(5);
				sortContacts(myContacts, sortOption);
				myContacts.listContactsByName();
				break;
			case 6:
				runMenu = false;
				System.out.println("\n************Goodbye*************\n");
				break;
			}
		} while (runMenu);

	}

	/**
	 * Method gets the new contact's details from the user and add a new contact
	 * to the address book.
	 * 
	 * @param contacts
	 * @return boolean to indicate if adding the new contact was successful
	 */
	private static boolean addNewContact(AddressBook contacts) {
		Person newPerson = new Person(getFirstNameInput(), getLastNameInput(), getEmailInput(), getHomePhoneInput(),
				getMobilePhoneInput(), new Address(getHouseNameInput(), getStreetInput(), getTownInput(),
						getCountyInput(), getEircodeInput()));
		return contacts.addContact(newPerson);
	}

	/**
	 * Method gets the name of the contact to be removed, displays the contact
	 * and asks for confirmation before removing the contact.
	 * 
	 * @param contacts
	 * @return boolean to indicate if removing the contact was successful or
	 *         not.
	 */
	private static boolean removeContact(AddressBook contacts) {
		String fullName = getFullNameInput();
		Person p = getPersonFromContacts(contacts, fullName);

		if (p != null) {
			searchForContact(contacts, fullName);
			System.out.println("\nDo You wish to delete contact: " + fullName + " displayed above.");
			String answer = getConfirmationInput();
			if (answer.equals("Yes")) {
				return contacts.removeContact(p);
			} else if (answer.equals("No")) {
				System.out.println("\n" + fullName + " will not be removed from the address book.");
				return false;
			}

		} else {
			System.out.println(fullName + " is not listed in the address book.");
		}
		return false;
	}

	/**
	 * Method to handle the edit contact options.
	 * 
	 * @param contactName
	 * @param optionToEdit
	 * @param contacts
	 * @param p
	 */
	private static void editContact(String contactName, int optionToEdit, AddressBook contacts, Person p) {
		switch (optionToEdit) {
		case 1:
			System.out.println("\n******** You wish to edit "+p.getFirstName()+" "+p.getLastName()+"'s first name. ********\n ");
			System.out.println("The existing first name is: "+p.getFirstName());
			p.updateFirstName(getFirstNameInput());
			break;
		case 2:
			System.out.println("\n******** You wish to edit "+p.getFirstName()+" "+p.getLastName()+"'s last name. ********\n ");
			System.out.println("The existing last name is: "+p.getLastName());
			p.updateLastName(getLastNameInput());
			break;
		case 3:
			System.out.println("\n******** You wish to edit "+p.getFirstName()+" "+p.getLastName()+"'s email address. ********\n ");
			System.out.println("The existing email address is: "+p.getEmail());
			p.updateEmail(getEmailInput());
			break;
		case 4:
			System.out.println("\n******** You wish to edit "+p.getFirstName()+" "+p.getLastName()+"'s home telephone number. ********\n ");
			System.out.println("The existing home telephone number is: "+p.getHomeTelNo());
			p.updateHomePhoneNum(getHomePhoneInput());
			break;
		case 5:
			System.out.println("\n******** You wish to edit "+p.getFirstName()+" "+p.getLastName()+"'s mobile telephone number. ********\n ");
			System.out.println("The existing mobile telephone number is: "+p.getMobileTelNo());
			p.updateMobilePhoneNum(getMobilePhoneInput());
			break;
		case 6:
			System.out.println("\n******** You wish to edit "+p.getFirstName()+" "+p.getLastName()+"'s house name/number. ********\n ");
			System.out.println("The existing house name/number is: "+p.getAddress().getHouseName());
			p.getAddress().updateHouseName(getHouseNameInput());
			break;
		case 7:
			System.out.println("\n******** You wish to edit "+p.getFirstName()+" "+p.getLastName()+"'s street name. ********\n ");
			System.out.println("The existing street name is: "+p.getAddress().getStreet());
			p.getAddress().updateStreetName(getStreetInput());
			break;
		case 8:
			System.out.println("\n******** You wish to edit "+p.getFirstName()+" "+p.getLastName()+"'s town name. ********\n ");
			System.out.println("The existing town name is: "+p.getAddress().getTown());
			p.getAddress().updateTownName(getTownInput());
			break;
		case 9:
			System.out.println("\n******** You wish to edit "+p.getFirstName()+" "+p.getLastName()+"'s county. ********\n ");
			System.out.println("The existing county name is: "+p.getAddress().getCounty());
			p.getAddress().updateCountyName(getCountyInput());
			break;
		case 10:
			System.out.println("\n******** You wish to edit "+p.getFirstName()+" "+p.getLastName()+"'s eircode. ********\n ");
			System.out.println("The existing eircode is: "+p.getAddress().getEircode());
			p.getAddress().updateEircodeName(getEircodeInput());
			break;
		case 11:
			System.out.println("\n******** Exiting edit contact menu. ********\n ");
			break;
		}
	}

	/**
	 * method to handle the sorting options.
	 * 
	 * @param contacts
	 * @param selection
	 */
	private static void sortContacts(AddressBook contacts, int selection) {
		switch (selection) {
		case 1:
			// First Name Asc
			contacts.sortByFirstName();
			break;
		case 2:
			// First Name Desc
			contacts.sortByFirstName();
			contacts.reverseList();
			break;
		case 3:
			// Last Name Asc
			contacts.sortByLastName();
			break;
		case 4:
			// Last Name Desc
			contacts.sortByLastName();
			contacts.reverseList();
			break;
		}
	}

	/**
	 * ensures correct input format of a contact's eircode. It requires 7 chars
	 * in a format of 3 chars a space and then 4 chars. Uppercase or lowercase o
	 * is not permitted
	 * 
	 * @return String
	 */

	private static String getEircodeInput() {
		String input = getUserInput("Please enter the eircode text");
		while (!input.matches("^[a-np-zA-NP-Z0-9]{3}\\s+[a-np-zA-NP-Z0-9]{4}$")) {
			input = getUserInput("Please enter a Valid eircode for the contact.");
		}
		return input;
	}

	/**
	 * Gets the county name input from the user
	 * @return String 
	 */
	
	private static String getCountyInput() {
		return getUserInput("Please enter the county name text");
	}

	/**
	 * Gets the town name input from the user
	 * @return String 
	 */
	private static String getTownInput() {
		return getUserInput("Please enter the town/village name text");
	}

	/**
	 * Gets the street name input from the user
	 * @return String 
	 */
	private static String getStreetInput() {
		return getUserInput("Please enter the street name text");
	}

	/**
	 * Gets the house name input from the user
	 * @return String 
	 */
	private static String getHouseNameInput() {
		return getUserInput("Please enter the name/number text");
	}

	/**
	 * ensures correct input format of a contact's mobile phone number. It
	 * requires 10 digits only
	 * 
	 * @return String
	 */

	private static String getMobilePhoneInput() {
		String input = getUserInput("Please enter the mobile phone number text");
		while (!input.matches("\\d{10}")) {
			input = getUserInput("Please enter a valid mobile phone number it must be 10 digits");
		}
		return input;
	}

	/**
	 * ensures correct input format of a contact's home phone number. It
	 * requires 8 digits or more
	 * 
	 * @return String
	 */

	private static String getHomePhoneInput() {
		String input = getUserInput("Please enter the house phone number text");
		while (!input.matches("\\d{8,}")) {
			input = getUserInput("Please enter a valid house phone number it must be 8 digits or more");
		}
		return input;
	}

	/**
	 * ensures correct input format of a contact's email address.
	 * 
	 * @return String
	 */
	private static String getEmailInput() {
		String input = getUserInput("Please enter the email address text");
		while (!input.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			input = getUserInput("Please enter a valid email address for the contact");
		}
		return input;

	}

	/**
	 * ensures correct input format of a contact's first name. It requires 1
	 * word of only alphabetic characters
	 * 
	 * @return String
	 */

	private static String getFirstNameInput() {
		String input = getUserInput("Please enter the first name text");
		while (!input.matches("^[a-zA-Z]+$")) {
			input = getUserInput(
					"Please enter the contact's first name it should be 1 word (no numbers or special chars allowed)");
		}
		return input;
	}

	/**
	 * ensures correct input format of a contact's last name. It requires 1 word
	 * of only alphabetic characters
	 * 
	 * @return String
	 */
	private static String getLastNameInput() {
		String input = getUserInput("Please enter the last name text");
		while (!input.matches("^[a-zA-Z]+$")) {
			input = getUserInput(
					"Please enter the contact's last name it should be 1 word (no numbers or special chars allowed)");
		}
		return input;
	}

	/**
	 * ensures correct input format of a contact full name. It requires 2 words
	 * of only alphabetic characters
	 * 
	 * @return String
	 */
	private static String getFullNameInput() {
		String input = getUserInput("Please enter the contact's full name");
		while (!input.matches("^[a-zA-Z]+\\s+[a-zA-Z]+$")) {
			input = getUserInput("Please enter the contact's full name it should be 2 words.");
		}
		return input;
	}

	/**
	 * Asks the user for a confirmation and returns the answer. The user has to
	 * enter 'Yes' or 'No'
	 * 
	 * @return String Yes or No
	 */
	private static String getConfirmationInput() {
		String answer = "";
		do {
			answer = getUserInput("Please enter Yes or No ");

		} while (!(answer.equals("Yes") || answer.equals("No")));
		return answer;
	}

	/**
	 * searches for a person in an AddressBook obj given a full name (first and
	 * last name) and returns it.
	 * 
	 * @param contacts
	 *            AddressBook object
	 * @param fullName
	 *            contacts full name i.e. first name and last name
	 * @return person object or null if nothing is found.
	 */
	private static Person getPersonFromContacts(AddressBook contacts, String fullName) {
		String[] names = fullName.split(" ");
		String fName = names[0];
		String lName = names[1];
		return contacts.findContact(fName, lName);
	}

	/**
	 * Searches the given address book for a contact with the given first name
	 * and last name
	 * 
	 * @param myContacts
	 * @param fName
	 * @param lName
	 */
	private static void searchForContact(AddressBook myContacts, String fullName) {
		String[] names = fullName.split(" ");
		String fName = names[0];
		String lName = names[1];
		Person result = myContacts.findContact(fName, lName);
		if (result != null) {
			System.out.println("\n************* Contact Found ******************\n");
			System.out.println(result.toString());
			System.out.println("\n**********************************************\n");
		} else {
			System.out.println("No contact was found with the name " + fName + " " + lName);
		}
	}

	/**
	 * Gets user input and returns it ensuring no additional white space. The
	 * input cannot be blank.
	 * 
	 * @param msg
	 *            The message to pass to the user.
	 * @return String
	 */
	public static String getUserInput(String msg) {
		String text = "";
		do {
			System.out.println("\n" + msg + "*: \t");
			text = input.nextLine().trim();
		} while (text.equals(""));

		return text;
	}

	/**
	 * Prints out the Main application menu.
	 */
	private static void printMainMenu() {

		System.out.println("\n************* Address Book ******************\n");

		System.out.println("(1) Find a Contact. \n");
		System.out.println("(2) Add a new Contact. \n");
		System.out.println("(3) Remove a Contact. \n");
		System.out.println("(4) Edit a Contact's details \n");
		System.out.println("(5) List all contacts by name \n");
		System.out.println("(6) Quit \n");

		System.out.println("Please choose from the above menu.");

	}

	/**
	 * Prints out the menu to display the edit contact options.
	 * @param contactName
	 */
	private static void printEditContactMenu(String contactName) {

		System.out.println("\n************* Edit Contact: " + contactName + " ******************\n");

		System.out.println("(1) Edit First Name.\n");
		System.out.println("(2) Edit Last Name.\n");
		System.out.println("(3) Edit Email Address.\n");
		System.out.println("(4) Edit Home Phone Number.\n");
		System.out.println("(5) Edit Mobile Phone Number.\n");
		System.out.println("(6) Edit House Name/Number.\n");
		System.out.println("(7) Edit Street Name.\n");
		System.out.println("(8) Edit Town/Village Name.\n");
		System.out.println("(9) Edit County Name\n");
		System.out.println("(10) Edit Eircode\n");
		System.out.println("(11) Exit Menu \n");

		System.out.println("Please choose from the above menu.");

	}

	/**
	 * Prints out the menu of sort options available for the address book
	 */
	private static void printSortMenu() {

		System.out.println("\n************* Address Book Sort Choices ******************\n");

		System.out.println("(1) Sort By First Name Ascending. \n");
		System.out.println("(2) Sort By First Name Descending. \n");
		System.out.println("(3) Sort By Last Name Ascending.\n");
		System.out.println("(4) Sort By Last Name Descending. \n");
		System.out.println("(6) Exit Menu \n");

		System.out.println("Please choose from the above menu.");

	}

	
	/**
	 * Get a valid menu selection from the user. 
	 * @param menuLength The number of options on the menu.
	 * @return
	 */
	public static int getMenuSelection(int menuLength) {
		boolean correctInputType = false;
		int choice = 0;
		do {
			String selection = input.nextLine().trim();
			try {
				// convert the string selection to an integer
				choice = Integer.parseInt(selection);
				// check if it is within the range expected
				if (choice >= 1 && choice <= menuLength) {
					correctInputType = true;
				} else {
					System.out.println("Please enter an integer between 1 and " + menuLength + " inclusive");

				}

			} catch (NumberFormatException e) {
				// error output
				System.out.println("Please enter an integer between 1 and " + menuLength + " inclusive");
			}

		} while (correctInputType == false);
		return choice;
	}

}
