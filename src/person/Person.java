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

    public MyContactList getMyContactList() {
        return myContactList;
    }

    public void setMyContactList(MyContactList myContactList) {
        this.myContactList = myContactList;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
