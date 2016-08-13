package com.theironyard.charlotte;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static HashMap<String, ArrayList<Person>> map = new HashMap<>();
    
    public static void main(String[] args) throws FileNotFoundException {

        // read all the people into memory
        File f = new File("People.txt");
        Scanner fileScanner = new Scanner(f); // scanner that reads from files
        while (fileScanner.hasNext()) { // while there is a next token on filescanner to read
            String line = fileScanner.nextLine(); //current line is the next line
            String[] columns = line.split(","); // since our different fields are deliminated by comma
            // make array list (of 6 strings) by that split
            Person personObject = new Person(Integer.valueOf(columns[0]), columns[1], columns[2], columns[3],
                    columns[4], columns[5]); // why won't int for id work?, b/c the first line were the headers.
            //had to delete header from txt.  need to figure out how to fix without deleting.

            //country in as hashmap key with empty arraylist as value
            map.putIfAbsent(columns[4], new ArrayList<>()); //if the country is not already in the hashmap, add it and as
            //its value, put an empty arraylist.

            map.get(columns[4]).add((personObject)); //not too sure how add knows to add based on country though?

        }
        for(String key:map.keySet()){  // for every key in the hashamp
            Collections.sort(map.get(key)); //get the value at the key, and sort
            System.out.println("[KEY: "+key+" , People: "+map.get(key)); // print out
        } //IT WORKS. IT WORKS. IT WORKS.

    }
}






/* Note:
     for each element in array list currently have, look at person, look at country, use country as a key in hash
     add person to list of people at the hashmap.

     putifabsent a new array list on specific key.
     putifabset new array list at

     for each read in a person, call putifabset and key would be that person's country and value
     would be new array list (empty)
     next line, hashmap.get(persons country), that will get me a new array list, use add method,
     hasmap.get.person.country.add

            hashmap = data

            data.get() -- return object at key
            data.get(country) -- get will return value, that will bring back array list
            data.get(country.add(personObject)

      System.out.println(personArrayList);
      System.out.println(map);

map.putIfAbsent(columns[4], personArrayList );

*/