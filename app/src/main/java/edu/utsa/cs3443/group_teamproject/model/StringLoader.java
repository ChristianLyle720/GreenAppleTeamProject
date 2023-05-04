package edu.utsa.cs3443.group_teamproject.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
* Static method to read from a file by using an InputStream and returning the contents of the file as an ArrayList of String arrays
* Each String array in the ArrayList corresponds to a line in the file
* @param fileName InputStream object for the file to be read from
* @return ArrayList of String arrays containing contents of the read file
*/
public class StringLoader {
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
