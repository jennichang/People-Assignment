package com.theironyard.charlotte;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // Method to save json file
    public static void saveData(HashMap<String, ArrayList<Person>> map) throws IOException {
        JsonSerializer s = new JsonSerializer();
        String json = s.include("*").serialize(map); // does s.include("*") mean include all parameters of hashmap?

        File f = new File("people.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

    // Method to read from People.txt file
    public static HashMap<String, ArrayList<Person>> readFile() throws FileNotFoundException {
        HashMap<String, ArrayList<Person>> readFromFile = new HashMap<>();

        // read all people from text
        File f = new File("People.txt");
        Scanner fileScanner = new Scanner(f); // scanner that reads from files
        fileScanner.nextLine(); // added this so it does not read the first line of the text file, which is a header
        while (fileScanner.hasNext()) { // while there is a next token on filescanner to read
            String line = fileScanner.nextLine(); //current line is the next line
            String[] columns = line.split(","); // since our different fields are deliminated by comma
            // make array list (of 6 strings) by that split
            Person personObject = new Person(Integer.valueOf(columns[0]), columns[1], columns[2], columns[3],
                    columns[4], columns[5]); // id didn't work at first because of the header line, added nextLine() so
            // scanner doesn't read first line.

            //country in as hashmap key with empty arraylist as value
            readFromFile.putIfAbsent(columns[4], new ArrayList<>()); //if the country is not already in the hashmap,
            // add it and as its value, put an empty arraylist.

            readFromFile.get(columns[4]).add((personObject)); //not too sure how add knows
            // to add based on country though?  oh, because it's a loop, it's only working with one person per loop
        }
        return readFromFile;
    }

    // Method to sort arraylists in hashmap

    public static void sortMap(HashMap<String, ArrayList<Person>> inputMap) {
        for (String key : inputMap.keySet()) { // for each key in all keys of my map
            Collections.sort(inputMap.get(key)); //sort the values (arraylists) at that key
            System.out.println("Key: " + key + "; People: " + inputMap.get(key)); // print hashmap
        }
    }

    public static void main(String[] args) throws IOException {

        // Read txt file
        HashMap<String, ArrayList<Person>> map = readFile();

        // Loop and sort
        sortMap(map);

        // save hashmap
        Main.saveData(map);


    }


}








