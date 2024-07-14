import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    public boolean isValidKey(int key, char[] alphabet) {
        return key > -alphabet.length && key < alphabet.length;
    }

    public boolean isFileExists(String filePath) {
        return Files.exists(Path.of(filePath));
    }
}
