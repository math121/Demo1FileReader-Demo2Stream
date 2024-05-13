import org.example.FileReader;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {

    private final String ERROR_MESSAGE = "java.nio.file.NoSuchFileException: src\\test\\resources\\invalid.txt";

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
}
