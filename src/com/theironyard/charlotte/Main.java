package com.theironyard.charlotte;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static HashMap<String, ArrayList<Person>> map = new HashMap<>();
    public static ArrayList<Person> personArrayList = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        // read all the people into memory
        File f = new File("People.txt");
        Scanner fileScanner = new Scanner(f); // scanner that reads from files
        while (fileScanner.hasNext()) { // while there is a next token on filescanner to read
            String line = fileScanner.nextLine(); //current line is the next line
            String[] columns = line.split(","); // since our different fields are deliminated by comma
            // make array list (of 6 strings) by that split
            Person personObject = new Person(Integer.valueOf(columns[0]), columns[1], columns[2], columns[3],
                    columns[4], columns[5]); // why won't int for id work?, b/c the first line were the headers

            //country in as hashmap key with empty arraylist as value
            map.putIfAbsent(columns[4], new ArrayList<>());

            map.get(columns[4]).add(personObject);

        }
    }

//        // for each hash map key, sort the array list by last name

    public static void sortLastName() {
        for (int i = 0; i < map.size(); i++) {


        }
    }
}












        //WHILE LOOP & ITERATOR
//        Iterator iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry me2 = (Map.Entry) iterator.next();
//            Collections.sort(personArrayList);
//            System.out.println("Key: " + me2.getKey() + me2.getValue());





















        //for each element in array list currently have, look at person, look at country, use country as a key in hash
        // add person to list of people at the hashmap.

        //putifabsent a new array list on specific key.
        //putifabset new array list at

        // for each read in a person, call putifabset and key would be that person's country and value
        // would be new array list (empty)
        //next line, hashmap.get(persons country), that will get me a new array list, use add method,
        // hasmap.get.person.country.add


            /*
            hashmap = data

            data.get() -- return object at key
            data.get(country) -- get will return value, that will bring back array list
            data.get(country.add(personObject)




             */


        //System.out.println(personArrayList);
        //System.out.println(map);

//            map.putIfAbsent(columns[4], personArrayList );
//
//            System.out.println(map);

//retrieve arraylist at the hashmap entry...hashmap.get(country) that gives you arraylist and you add to that

        //hashmap.get.add(newperson)  and it will add new person


