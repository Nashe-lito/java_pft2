package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String nickName;
    private final String title;
    private final String mobile;
    private final String work;
    private final String email;
    private final String phone2;
    private String group;


    public ContactData(String firstName, String lastName, String nickName, String title,
                       String mobile, String work, String email, String phone2, String group) {
        this.id = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.title = title;
        this.mobile= mobile;
        this.work = work;
        this.email= email;
        this.phone2 = phone2;
        this.group = group;
    }


    public ContactData(int id, String firstName, String lastName, String nickName, String title,
                       String mobile, String work, String email, String phone2, String group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.title = title;
        this.mobile= mobile;
        this.work = work;
        this.email= email;
        this.phone2 = phone2;
        this.group = group;
    }

    public int getId() {
        return id;
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

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
