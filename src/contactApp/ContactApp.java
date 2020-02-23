package contactApp;

import myContactList.MyContactList;
import myLinkedList.MyLinkedList;
import person.Person;
import validInputs.ValidInputs;

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


}
