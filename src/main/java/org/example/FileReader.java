package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileReader {
    private List<String> list;
    private Path path;

    public FileReader(String filePath) throws IOException {
        path = Paths.get(filePath);
        list = Files.readAllLines(path);
    }

    public void writeLineToFile(String line) throws IOException {
        Files.writeString(path, System.lineSeparator() + line + System.lineSeparator(), StandardOpenOption.APPEND);
        list.add(line);
    }

    public void writeManyLinesToFile(List<String> lines) throws IOException {
        Files.write(path, lines, StandardOpenOption.APPEND);
        list.addAll(lines);
    }

    public List<String> getList() {
        return list;
    }
}
