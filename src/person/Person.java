package person;

import myContactList.MyContactList;

public class Person {
    private String firstName;
    private String lastName;
    private MyContactList myContactList;
    private String emailAddress;

    public Person(String firstName, String lastName, MyContactList myContactList, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.myContactList = myContactList;
        this.emailAddress = emailAddress;
    }
}
