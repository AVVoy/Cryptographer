public class Main {
    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Выберите режим работы программы:");
        ConsoleHelper.writeMessage("1 - Шифровка файла");
        ConsoleHelper.writeMessage("2 - Дешифровка файла");
        ConsoleHelper.writeMessage("3 - Грубый взлом");
        ConsoleHelper.writeMessage("4 - Статистический взлом");
        int userSelection =  ConsoleHelper.readInt();
        switch (userSelection) {
            case 1:
            case 2:
            case 3:
            case 4:
                ConsoleHelper.writeMessage("Пока еще не готово");
                break;
        }

        ConsoleHelper.writeMessage("\nЦенок");
    }
}