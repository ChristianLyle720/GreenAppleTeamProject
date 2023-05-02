package edu.utsa.cs3443.group_teamproject.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

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
