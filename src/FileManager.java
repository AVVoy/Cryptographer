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
        } catch (FileNotFoundException e) {
            ConsoleHelper.writeMessage("Упс... что-то пошло не так. нет такого файла");
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Упс... что-то пошло не так. не могу прочитать файл");
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
            ConsoleHelper.writeMessage("Упс... что-то пошло не так. не могу записать файл");
        }
    }
}
