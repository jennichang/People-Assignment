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



    @Override
    public String toString() {
        return String.format("%s %s from %s", this.firstName, this.lastName, this.country
                );

    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        return lastName.compareTo(p.lastName);
    }


}

