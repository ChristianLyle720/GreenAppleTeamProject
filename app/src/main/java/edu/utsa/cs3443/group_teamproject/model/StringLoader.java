package edu.utsa.cs3443.group_teamproject.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Green Apple Inc.
 * This is a class which assists in reading from files by definining a file reading implementation which can be used by all classes
 */
public class StringLoader {
/**
* Static method to read from a file by using an InputStream and returning the contents of the file as an ArrayList of String arrays
* Each String array in the ArrayList corresponds to a line in the file
* @param inStream InputStream object for the file to be read from
* @return ArrayList of String arrays containing contents of the read file
*/
    public static ArrayList<String[]> loadData(InputStream inStream){
        ArrayList<String[]> list = new ArrayList<String[]>();
        String read;
        Scanner scan = new Scanner(inStream);
        while(scan.hasNext()){
            read = scan.nextLine();
            String[] lineParts = read.split(",");
            list.add(lineParts);
        }
        return list;
    }
}
