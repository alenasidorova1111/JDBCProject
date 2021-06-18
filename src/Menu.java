import console.ServiceConsoleOutput;
import console.SubscriberConsoleOutput;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    Scanner scannerInt = new Scanner(System.in);
    Scanner scannerSting = new Scanner(System.in);

    SubscriberConsoleOutput sc = new SubscriberConsoleOutput();
    ServiceConsoleOutput scs = new ServiceConsoleOutput();

    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();

        System.out.println("Welcome to Phone Data Base!");

        menu.mainMenu();

        System.out.println("See you soon!");

        menu.scannerInt.close();
        menu.scannerSting.close();
    }

    private Menu mainMenu() throws SQLException {

        int selection;

        do {
            System.out.println("""
                    ======================================================================
                    Please enter the number of command you need:\s
                    1 - to work with Subscribers data
                    2 - to work with Services data
                    3 - to finish work
                    Enter command:\040\040\040""");

            selection = scannerInt.nextInt();

            switch (selection) {
                case 1 -> {
                    return this.submenu1();
                }
                case 2 -> {
                    return this.submenu2();
                }
                case 3 -> {
                    return this;
                }
                default -> {
                    System.out.println("Wrong input. Try again!");
                    return this.mainMenu();
                }
            }
        }
        while (selection != 3);
    }

    private Menu submenu1() throws SQLException {

        int selection;

        do {
            System.out.println("""
                    ======================================================================
                    Please enter the number of command you need:\s
                    1 - insert new subscriber to DB
                    2 - get subscriber's info
                    3 - get all subscribers
                    4 - update subscribers info
                    5 - delete subscriber
                    6 - get oldest subscriber
                    7 - go back to main menu
                    Enter command:\040\040\040""");

            selection = scannerInt.nextInt();

            switch (selection) {
                case 1 -> {
                    System.out.println("Please enter subscriber's firstname, lastname, city, age and sex," +
                            "using whitespaces:   ");
                    String subscribersData = scannerSting.nextLine();
                    sc.outputCreatedSubscriber(subscribersData);
                    return this.submenu1();
                }
                case 2 -> {
                    System.out.println("Please enter subscriber's lastname:   ");
                    String lastName = scannerSting.nextLine();
                    sc.outputSubscriber(lastName);
                    return this.submenu1();
                }
                case 3 -> {
                    sc.outputAllSubscribers();
                    return this.submenu1();

                }
                case 4 -> {
                    System.out.println("Please enter subscriber's id, new: firstname, lastname, city, age and sex," +
                            "using whitespaces:   ");
                    String subscribersData = scannerSting.nextLine();
                    sc.outputUpdatedSubscriber(subscribersData);
                    return this.submenu1();

                }
                case 5 -> {
                    System.out.println("Please enter subscriber's id:   ");
                    Integer id = scannerInt.nextInt();
                    sc.outputSubscriberWasDeleted(id);
                    return this.submenu1();

                }
                case 6 -> {
                    sc.outputOldestSubscriber();
                    return this.submenu1();

                }
                case 7 -> {
                    return this.mainMenu();

                }

                default -> {
                    System.out.println("Wrong input. Try again!");
                    return this.submenu1();
                }
            }
        }
        while (selection != 7);
    }

    private Menu submenu2() throws SQLException {

        int selection;

        do {
            System.out.println("""
                    ======================================================================
                    Please enter the number of command you need:\s
                    1 - insert new service to DB
                    2 - get service's info
                    3 - get all services
                    4 - update service's info
                    5 - delete service
                    6 - go back to main menu
                    Enter command:\040\040\040""");

            selection = scannerInt.nextInt();

            switch (selection) {
                case 1 -> {
                    System.out.println("Please enter service's name and cost, using whitespaces:   ");
                    String serviceData = scannerSting.nextLine();
                    scs.outputCreatedService(serviceData);
                    return this.submenu2();
                }
                case 2 -> {
                    System.out.println("Please enter service's name:   ");
                    String name = scannerSting.nextLine();
                    scs.outputService(name);
                    return this.submenu2();
                }
                case 3 -> {
                    scs.outputAllServices();
                    return this.submenu2();

                }
                case 4 -> {
                    System.out.println("Please enter service's id and new: name and cost," +
                            "using whitespaces:   ");
                    String serviceData = scannerSting.nextLine();
                    scs.outputUpdatedService(serviceData);
                    return this.submenu2();

                }
                case 5 -> {
                    System.out.println("Please enter service's id:   ");
                    Integer id = scannerInt.nextInt();
                    scs.outputServiceWasDeleted(id);
                    return this.submenu2();

                }

                case 6 -> {
                    return this.mainMenu();

                }

                default -> {
                    System.out.println("Try again!");
                    System.out.println("Wrong input. Try again!");
                    return this.submenu2();
                }
            }
        }
        while (selection != 6);
    }

}
