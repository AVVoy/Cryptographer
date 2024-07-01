import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    public boolean isValidKey(int key, char[] alphabet) {
        if ((key > 0  && key< alphabet.length) ||
                (key > -alphabet.length && key < 0)) {
            return true;
        }
        return false;
    }

    public boolean isFileExists(String filePath) {
        return Files.exists(Path.of(filePath));
    }
}
