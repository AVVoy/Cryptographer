public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            ConsoleHelper.writeMessage("Выберите режим работы программы:");
            ConsoleHelper.writeMessage("1 - Шифровка файла");
            ConsoleHelper.writeMessage("2 - Дешифровка файла");
            ConsoleHelper.writeMessage("3 - Грубый взлом");
            ConsoleHelper.writeMessage("4 - Статистический взлом");
            ConsoleHelper.writeMessage("exit - выход из программы");
            String userSelection = ConsoleHelper.readMessage();
            switch (userSelection) {
                case "1": {
                    encryptFile();
                    break;
                }
                case "2": {
                    descryptFile();
                }
                case "3":
                case "4":
                    ConsoleHelper.writeMessage("Находится в разработке. Попробуйте связаться с разработчиком)");
                    break;
                case "exit":
                    exit = true;
                    break;
            }
        }
        ConsoleHelper.writeMessage("\nЦенок");
    }

    private static void descryptFile() {
        FileManager fileManager = new FileManager();
        Validator validator = new Validator();
        String notEncryptText;
        String filePath;
        while (true) {
            ConsoleHelper.writeMessage("Введите путь к файлу");
            filePath = ConsoleHelper.readMessage();
            if (validator.isFileExists(filePath)) {
                notEncryptText = fileManager.readFile(filePath);
                break;
            } else {
                ConsoleHelper.writeMessage("Не могу найти файл. проверьте путь!!!");
            }
        }
        CaesarsCipher caesar = new CaesarsCipher();
        int shift = Integer.MAX_VALUE;
        while (!validator.isValidKey(shift, CaesarsCipher.getAlphabet())) {
            ConsoleHelper.writeMessage("Введите сдвиг алфавита. Он должен быть от -" +
                    CaesarsCipher.getAlphabet().length + " до " + CaesarsCipher.getAlphabet().length);
            shift = ConsoleHelper.readInt();
        }
        ConsoleHelper.writeMessage("Введите путь к файлу, куда сохраним дешифровку");
        String encryptFilePath = ConsoleHelper.readMessage();
        fileManager.writeFile(
                caesar.
                        decrypt(notEncryptText, shift), encryptFilePath);

    }

    private static void encryptFile() {
        FileManager fileManager = new FileManager();
        Validator validator = new Validator();
        String notEncryptText;
        String filePath;
        while (true) {
            ConsoleHelper.writeMessage("Введите путь к файлу");
            filePath = ConsoleHelper.readMessage();
            if (validator.isFileExists(filePath)) {
                notEncryptText = fileManager.readFile(filePath);
                break;
            } else {
                ConsoleHelper.writeMessage("Не могу найти файл. проверьте путь!!!");
            }
        }
        CaesarsCipher caesar = new CaesarsCipher();
        int shift = Integer.MAX_VALUE;
        while (!validator.isValidKey(shift, CaesarsCipher.getAlphabet())) {
            ConsoleHelper.writeMessage("Введите сдвиг алфавита. Он должен быть от -" +
                    CaesarsCipher.getAlphabet().length + " до " + CaesarsCipher.getAlphabet().length);
            shift = ConsoleHelper.readInt();
        }
        ConsoleHelper.writeMessage("Введите путь к файлу, куда сохраним шифровку");
        String encryptFilePath = ConsoleHelper.readMessage();
        fileManager.writeFile(
                caesar.
                        encrypt(notEncryptText, shift), encryptFilePath);
    }
}