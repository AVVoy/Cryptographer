import java.io.*;
import java.nio.file.Path;

public class FileManager {

    public String readFile(String filePath) {
        Path pathToFile = Path.of(filePath);
        StringBuilder out = new StringBuilder();
        try(FileReader fr = new FileReader(pathToFile.toFile());
            BufferedReader bf = new BufferedReader(fr)) {
            while (bf.ready()) {
                out.append(bf.readLine());
                out.append("\n");
            }
        } catch (IOException ignored) {
            //Считаем что в метод приходит корректный путь к файлу
        }
        return out.toString();
    }

    public void writeFile(String content, String filePath) {
        Path pathToFile = Path.of(filePath);
        try(FileWriter fw = new FileWriter(pathToFile.toFile());
            BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(content);
            bw.flush();
        } catch (IOException e) {
            Util.writeMessage("Упс... Не могу записать файл");
        }
    }
}
