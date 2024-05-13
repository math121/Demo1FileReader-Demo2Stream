package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/names.txt";
        FileReader fileReader = new FileReader(filePath);

        // List of given file
        System.out.println("Here is the content of the file: " + filePath.substring(filePath.lastIndexOf("/") + 1));
        System.out.println(fileReader.getList());

        // Write one line to file
        fileReader.writeLineToFile("I'm adding this line!");

        // Write multiple lines to file
        fileReader.writeManyLinesToFile(Arrays.asList("Test1", "Test2", "Test3"));
    }
}