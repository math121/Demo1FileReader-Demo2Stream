package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private List<String> list;
    private Path path;

    public FileReader(String filePath) {
        path = Paths.get(filePath);

        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Invalid file/cannot find file");
        }
    }

    public void writeLineToFile(String line) {
        try {
            Files.writeString(path, line + System.lineSeparator(), StandardOpenOption.APPEND);
            list.add(line);
        } catch (IOException e) {
            System.out.println("Invalid file/cannot find file");
        }
    }

    public void writeManyLinesToFile(List<String> lines) {
        try {
            Files.write(path, lines, StandardOpenOption.APPEND);
            list.addAll(lines);
        } catch (IOException e) {
            System.out.println("Invalid file/cannot find file");
        }
    }

    public void writeToNewFile(String fileName) {

    }

    public List<String> getList() {
        return list;
    }
}
