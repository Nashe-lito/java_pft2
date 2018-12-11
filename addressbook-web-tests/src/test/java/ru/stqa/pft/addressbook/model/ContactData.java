package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String nickName;
    private final String title;
    private final String mobile;
    private final String work;
    private final String email;
    private final String phone2;


    public ContactData(String firstName, String lastName, String nickName, String title, String mobile, String work, String email, String phone2) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.title = title;
        this.mobile= mobile;
        this.work = work;
        this.email= email;
        this.phone2 = phone2;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getTitle() {
        return title;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone2() {
        return phone2;
    }
}
