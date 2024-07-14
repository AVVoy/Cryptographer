public class Main {
    public static void main(String[] args) {

        String userSelection;
        do {
            Util.showMenu();
            userSelection = Util.readMessage();
            if (!userSelection.equals("exit")) {
                Util.getResultWorkingApp(userSelection);
            }
        } while (!userSelection.equals("exit"));
        Util.writeMessage("\n !ценоК");

    }
//D:\example\file1.txt

}