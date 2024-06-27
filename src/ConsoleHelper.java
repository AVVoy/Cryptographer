import java.io.IOException;
import java.util.Scanner;

public class ConsoleHelper {
    public static void writeMessage(String Message) {
        System.out.println(Message);
    }

    public static int readInt(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            String s = scanner.nextLine();
            try {
                int a = Integer.parseInt(s);
                return a;
            } catch (NumberFormatException e){
                writeMessage("Это не число!!! Введите число!");
            }
        }
    }
}
