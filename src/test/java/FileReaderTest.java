import org.example.FileReader;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {

    @Test
    public void shouldHave2ItemsInListAfterReadingFile() throws IOException {
        FileReader fileReader = new FileReader("src/test/resources/test.txt");

        assertEquals(2, fileReader.getList().size());
        assertIterableEquals(Arrays.asList("One item", "Two Item"), fileReader.getList());
    }

    @Test
    public void shouldThrowForInvalidFilePath() throws IOException {
        var thrownException = assertThrows(IOException.class, () -> new FileReader("src/test/resources/invalid.txt"));
        assertEquals(NoSuchFileException.class, thrownException.getClass());
    }

    @Test
    public void shouldWriteOneLineToFile() throws IOException {
        FileReader fileReader = new FileReader("src/test/resources/writeToFile.txt");
        fileReader.writeLineToFile("Test add new line");

        List<String> list = fileReader.getList();
        assertEquals(3, fileReader.getList().size());
        assertEquals("Test add new line", list.get(list.size() - 1));

    }
}
