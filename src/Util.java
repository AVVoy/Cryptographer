import java.util.Scanner;

public class Util {
    private static final Validator validator = new Validator();
    private static final FileManager fileManager = new FileManager();

    private static final CaesarsCipher caesar = new CaesarsCipher();

    public static void showMenu() {
        writeMessage("Режимы работы программы:");
        writeMessage("1 - Шифровка файла");
        writeMessage("2 - Дешифровка файла");
        writeMessage("3 - Грубый взлом");
        writeMessage("4 - Статистический взлом");
        writeMessage("exit - выход из программы");
        writeEmptyLine();
        writeMessage("Введите номер режима работы приложения:");
    }

    public static void writeMessage(String Message) {
        System.out.println(Message);
    }

    public static void writeEmptyLine() {
        System.out.println();
    }

    public static int readInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            try {
                if (s.isEmpty()) throw new NumberFormatException();
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                writeMessage("Это не число!!! Введите число!");
            }
        }
    }

    public static String readMessage() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void getResultWorkingApp(String userSelection) {
        switch (userSelection) {
            case "1" -> encryptFile();
            case "2" -> decryptFile();
            case "3", "4" -> writeMessage("Находится в разработке. Попробуйте связаться с разработчиком)");
            default -> {
                writeMessage("Введен некорректный режим работы.\nДавайте попробуем еще раз.");
                writeEmptyLine();
            }
        }
    }

    private static void encryptFile() {

        writeMessage("Введите путь к файлу, который будем шифровать");
        String inputPathToFile = getPathToFile();

        String unencryptedTextFromInputFile = fileManager.readFile(inputPathToFile);

        int shift = getShiftAlphabet();

        writeMessage("Введите путь к файлу, куда сохраним шифровку");
        String outputPathToFile = readMessage();

        fileManager.writeFile(
                caesar.
                        encrypt(unencryptedTextFromInputFile, shift), outputPathToFile);

        writeMessage("Зашифровали содержимое файла, лежащего по пути "
                + inputPathToFile
                + " и записали в файл, лежащий по пути "
                + outputPathToFile
        );
        writeEmptyLine();

    }

    private static String getPathToFile() {
        String filePath;
        while (true) {
            filePath = readMessage();
            if (!filePath.isEmpty() && validator.isFileExists(filePath)) {
                return filePath;
            } else {
                writeMessage("Введен некорректный путь к файлу.\nПроверьте путь к файлу и попробуйте еше раз.");
                writeEmptyLine();
            }
        }
    }

    private static int getShiftAlphabet() {
        int shift = Integer.MAX_VALUE;

        while (!validator.isValidKey(shift, CaesarsCipher.getAlphabet())) {
            int lengthAlphabet = CaesarsCipher.getAlphabet().length;
            writeMessage("Введите сдвиг алфавита. Он должен быть от -" +
                    lengthAlphabet + " до " + lengthAlphabet
            );
            shift = readInt();
        }
        return shift;
    }

    private static void decryptFile() {

        writeMessage("Введите путь к файлу, который будем дешифровать");
        String inputPathToFile = getPathToFile();

        String unencryptedTextFromInputFile = fileManager.readFile(inputPathToFile);

        int shift = getShiftAlphabet();

        writeMessage("Введите путь к файлу, куда сохраним дешифровку");
        String outputPathToFile = readMessage();

        fileManager.writeFile(
                caesar.
                        decrypt(unencryptedTextFromInputFile, shift), outputPathToFile);

        writeMessage("Расшифровали содержимое файла, лежащего по пути "
                + inputPathToFile
                + " и записали в файл, лежащий по пути "
                + outputPathToFile
        );
        writeEmptyLine();


    }
}
