import console.SubscriberConsoleOutput;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        SubscriberConsoleOutput sc = new SubscriberConsoleOutput();

        System.out.println("""
                Welcome to Phone Data Base! Please enter the number of command you need:\s
                1 - to insert new subscriber to DB
                2 - to get subscriber's info
                3 - to get all subscribers
                4 - to update subscribers info
                5 - to delete subscriber
                6 - to get oldest subscriber
                7 - to finish work
                Enter command:\040\040\040""");

        Scanner scanner = new Scanner(System.in);

        int readCommand;

        try {
            readCommand = scanner.nextInt();
            if (readCommand < 1 | readCommand > 7) {
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            throw new InputMismatchException("Please enter available integer number without any other symbols");
        }

        while (readCommand != 7) {
            Scanner sca = new Scanner(System.in);

            switch (readCommand) {
                case 1 -> {
                    System.out.println("Please enter subscriber's firstname, lastname, city, age and sex," +
                            "using whitespaces:   ");
                    String subscribersData = sca.nextLine();
                    sc.outputCreatedSubscriber(subscribersData);
                    System.out.println("Enter new command:   ");
                    readCommand = scanner.nextInt();
                }
                case 2 -> {
                    System.out.println("Please enter subscriber's lastname:   ");
                    String lastName = sca.nextLine();
                    sc.outputSubscriber(lastName);
                    System.out.println("Enter new command:   ");
                    readCommand = scanner.nextInt();
                }
                case 3 -> {
                    sc.outputAllSubscribers();
                    System.out.println("Enter new command:   ");
                    readCommand = scanner.nextInt();
                }
                case 4 -> {
                    System.out.println("Please enter subscriber's id, new: firstname, lastname, city, age and sex," +
                            "using whitespaces:   ");
                    String subscribersData = sca.nextLine();
                    sc.outputUpdatedSubscriber(subscribersData);
                    System.out.println("Enter new command:   ");
                    readCommand = scanner.nextInt();
                }
                case 5 -> {
                    System.out.println("Please enter subscriber's id:   ");
                    Integer id = sca.nextInt();
                    sc.outputSubscriberWasDeleted(id);
                    System.out.println("Enter new command:   ");
                    readCommand = scanner.nextInt();
                }
                case 6 -> {
                    sc.outputOldestSubscriber();
                    System.out.println("Enter new command:   ");
                    readCommand = scanner.nextInt();
                }
            }
        }

        System.out.println("See you soon!");
    }
}
