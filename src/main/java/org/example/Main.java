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

    public static void streamJSONData() throws IOException {
        String filePath = "src/main/resources/MOCK_DATA.json";
        StreamData streamData = new StreamData(filePath);

        var femaleGender = streamData.getPeopleByGender("Female");
        var favColor = streamData.getPeopleByFavoriteColor("Blue");
        var catchPhrases = streamData.getCatchPhrases();
        var peopleThatStartWithALetter = streamData.getFirstNamesThatStartWithALetter('A');

        System.out.println("\nPeople with Female gender:\n");
        femaleGender.forEach(System.out::println);

        System.out.println("\nPeople with fav Blue color:\n");
        favColor.forEach(System.out::println);

        System.out.println("\nCatch phrases:\n");
        catchPhrases.forEach(System.out::println);

        System.out.println("\nPeople that start with letter A:\n");
        peopleThatStartWithALetter.forEach(System.out::println);


    }

    public static void main(String[] args) throws IOException {
        //fileReaderProgram();

        streamJSONData();

    }
}