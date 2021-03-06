package com.theironyard.charlotte;


/**
 * Created by jenniferchang on 8/11/16.
 */
public class Person implements Comparable {
    int id;
    String firstName;
    String lastName;
    String email;
    String country;
    String ipAddress;

    public Person(int id, String firstName, String lastName, String email, String country, String ipAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.ipAddress = ipAddress;
    } // set fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return String.format("%s %s from %s", this.firstName, this.lastName, this.country
        );

    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        int d = getLastName().compareTo(p.getLastName()); // compare the last name
        if (d == 0) { // if last name is the same, 0 because set d to int
            d = getFirstName().compareTo(p.getFirstName());
        } // then compare the first name
        return d;
    }


}
