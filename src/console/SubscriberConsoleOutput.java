package console;

import domain.Subscriber;
import service.SubscriberService;

import java.sql.SQLException;
import java.util.Set;
import java.util.stream.Collectors;

public class SubscriberConsoleOutput {
    SubscriberService subService = new SubscriberService();

    public void outputCreatedSubscriber(String subscribersData) throws SQLException {
        Subscriber subscriber = subService.create(subscribersData);
        System.out.println("Successfully created: " + subscriber.toString());
    }

    public void outputSubscriber(String lastname) throws SQLException {
        Subscriber subscriber = subService.read(lastname);
        System.out.println(subscriber.toString());
    }

    public void outputAllSubscribers() throws SQLException {
        Set<Subscriber> set = subService.readAll();
        String setString = set.stream().map(Subscriber::toString).collect(Collectors.joining("\n"));

        System.out.println(setString);
    }

    public void outputUpdatedSubscriber(String subscribersData) throws SQLException {
        Subscriber subscriber = subService.update(subscribersData);
        System.out.println("Successfully updated: " + subscriber.toString());
    }

    public void outputSubscriberWasDeleted(Integer id) throws SQLException {
        Integer row = subService.delete(id);

        if (row == 1) {
            System.out.println("Subscriber was successfully deleted");
        } else {
            System.out.println("Subscriber can not be deleted, try again");
        }

    }

    public void outputOldestSubscriber() throws SQLException {
        Subscriber subscriber = subService.getOldest();
        System.out.println(subscriber.toString());
    }

}
