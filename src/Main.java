import console.SubscriberConsoleOutput;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        SubscriberConsoleOutput sc = new SubscriberConsoleOutput();
        Scanner scanner = new Scanner(System.in);

        int readCommand = scanner.nextInt();
        ////Scanner scanner = new Scanner(System.in);
        //
        //try {
        //    readCommand = scanner.nextInt();
        //    if (readCommand<1 | readCommand>6) {
        //        throw new InputMismatchException("Only these commands are available at this moment: 1, 2, 3, 4, 5, 6");
        //    }
        //} catch (Exception e) {
        //    throw new InputMismatchException("Please enter integer number without any other symbols");
        //}

        while (readCommand != 6) {

            try {
                readCommand = scanner.nextInt();
                if (readCommand < 1 | readCommand > 6) {
                    throw new InputMismatchException("Only these commands are available at this moment: 1, 2, 3, 4, 5, 6");
                }
            } catch (Exception e) {
                throw new InputMismatchException("Please enter integer number without any other symbols");
            }

            System.out.println("Welcome to Phone Data Base! \n" +
                    "Please enter the number of command you need: \n" +
                    "1 - to get subscriber's info\n" +
                    "2 - to get all subscribers\n" +
                    "3 - to update subscribers info\n" +
                    "4 = to insert new subscriber to DB\n" +
                    "5 - to delete subscriber\n" +
                    "6 - to finish work");

            //Integer choise = scanner.nextInt();

            //boolean runDefault = false;

            switch (readCommand) {
                case 1: {
                    System.out.println("Please enter subscriber's lastname:\n");
                    String lastName = scanner.nextLine();
                    sc.outputSubscriber(lastName);
                    break;
                }
                case 2: {
                    sc.outputAllSubscribers();
                    break;
                }

            }


        }
    }
}
