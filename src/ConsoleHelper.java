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
                if (s.isEmpty()) throw new NumberFormatException();
                int a = Integer.parseInt(s);
                return a;
            } catch (NumberFormatException e){
                writeMessage("Это не число!!! Введите число!");
            }
        }
    }

    public static String readMessage() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
