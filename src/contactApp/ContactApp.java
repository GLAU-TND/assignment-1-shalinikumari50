package contactApp;

import contactNumber.ContactNumber;
import myContactList.MyContactList;
import myLinkedList.MyLinkedList;
import node.Node;
import person.Person;
import validInputs.ValidInputs;

import java.util.regex.Pattern;

public class ContactApp {
    private static ValidInputs validInputs;

    static {
        validInputs = new ValidInputs();
    }

    private MyLinkedList<Person> personMyLinkedList;

    public ContactApp() {
        personMyLinkedList = new MyLinkedList<>();
    }

    public String enterName() {
        while (true) {
            System.out.println("Please enter the name of the Person");
            System.out.println("First Name: ");
            String firstName = validInputs.inputValidName();
            if (firstName == null) {
                return null;
            }
            System.out.println("Last Name: ");
            String lastName = validInputs.inputValidName();
            if (lastName == null) {
                return null;
            }
            if (personMyLinkedList.matchFound(firstName + " " + lastName)) {
                System.out.println("Contact with this name already exists!");
                System.out.println("To try again with a different name, enter 't' or to return to menu, enter 'q'");
                char choice = validInputs.inputValidChoice('q', 't');
                if (choice == 'q') {
                    return null;
                } else {
                    continue;
                }
            }
            return firstName + " " + lastName;
        }
    }

    public MyContactList enterContactList() {
        MyContactList myContactList = new MyContactList();
        char choice = 'y';
        int flag = 0;
        while (choice != 'n') {
            if (myContactList.addContactNumber() == -1) {
                if (flag == 0) {
                    return null;
                }
                return myContactList;
            }
            flag = 1;
            System.out.println("Would you like to add another contact number? (y/n):");
            choice = validInputs.inputValidChoice('y', 'n');
        }
        return myContactList;
    }

    public String enterEmail() {
        String emailAddress;
        System.out.println("Email Address: ");
        emailAddress = validInputs.inputValidString();
        String regex = "(?:[a-zA-Z0-9]+[._-])*[a-zA-Z0-9]+@(?:[a-zA-Z0-9]+[._-])*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}";
        boolean matches = Pattern.matches(regex, emailAddress);
        while (!matches) {
            System.out.println("Enter a valid email address or 'q' to skip email address entry");
            emailAddress = validInputs.inputValidString();
            if (emailAddress.equals("q")) {
                return null;
            }
            matches = Pattern.matches(regex, emailAddress);
        }
        return emailAddress;
    }

    public void addContact() {
        System.out.println("You have chosen to add a new contact: ");

        String nameEntry = enterName();
        if (nameEntry == null) {
            return;
        }
        String firstName = nameEntry.split(" ")[0];
        String lastName = nameEntry.split(" ")[1];
        MyContactList mycontactList = enterContactList();
        if (mycontactList == null) {
            return;
        }
        String emailEntry = "";
        System.out.println("Would you like to add email address? (y/n):");
        int choice = validInputs.inputValidChoice('y', 'n');
        if (choice == 'y') {
            emailEntry = enterEmail();
            if (emailEntry == null) {
                emailEntry = "";
            }
        }
        Person person = new Person(firstName, lastName, mycontactList, emailEntry.toLowerCase());
        personMyLinkedList.insertInAlphabeticOrder(new Node<>(person));
        System.out.println("Contact added!");
    }

    public void displayAContact(Node<Person> personNode) {
        System.out.println("-------- * -------- * -------- * --------");
        System.out.println("First Name: " + personNode.getData().getFirstName());
        System.out.println("Last Name: " + personNode.getData().getLastName());

        MyContactList myContactList = personNode.getData().getMyContactList();
        Node<ContactNumber> contactNumber = myContactList.getHead();
        if (contactNumber.getNext() == null) {
            System.out.println("Contact Number: ");
        } else {
            System.out.println("Contact Number(s): ");
        }
        while (contactNumber.getNext() != null) {
            System.out.print(contactNumber.toString() + ", ");
            contactNumber = contactNumber.getNext();
        }
        System.out.println(contactNumber.toString());
        System.out.println("Email address: " + personNode.getData().getEmailAddress());
        System.out.println("-------- * -------- * -------- * --------");
    }


}
