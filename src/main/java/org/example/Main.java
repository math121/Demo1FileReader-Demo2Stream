package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void fileReaderProgram() {
        String filePath = "src/main/resources/names.txt";
        try {
            FileReader fileReader = new FileReader(filePath);
            // List of given file
            System.out.println("Here is the content of the file: " + filePath.substring(filePath.lastIndexOf("/") + 1));
            System.out.println(fileReader.getList());

            // Write one line to file
            fileReader.writeLineToFile("I'm adding this line!");

            // Write multiple lines to file
            fileReader.writeManyLinesToFile(Arrays.asList("Test1", "Test2", "Test3"));
        } catch (IOException e) {
            System.out.println("Invalid file path");
        }
    }
    public static void main(String[] args) {
        fileReaderProgram();


    }
}