package console;

import domain.Subscriber;
import service.SubscriberService;

import java.sql.SQLException;
import java.util.Set;
import java.util.stream.Collectors;

public class SubscriberConsoleOutput {

    public void outputCreatedSubscriber(String subscribersData) throws SQLException {
        SubscriberService ss = new SubscriberService();
        Subscriber sb = ss.create(subscribersData);
        System.out.println("Successfully created: " + sb.toString());
    }

    public void outputSubscriber(String lastname) throws SQLException {
        SubscriberService ss = new SubscriberService();
        Subscriber sb = ss.read(lastname);
        System.out.println(sb.toString());
    }

    public void outputAllSubscribers() throws SQLException {
        SubscriberService ss = new SubscriberService();
        Set<Subscriber> set = ss.readAll();
        String setString = set.stream().map(Subscriber::toString).collect(Collectors.joining("\n"));

        System.out.println(setString);
    }

    public void outputUpdatedSubscriber(String subscribersData) throws SQLException {
        SubscriberService ss = new SubscriberService();
        Subscriber sb = ss.update(subscribersData);
        System.out.println("Successfully created: " + sb.toString());
    }

    public void outputSubscriberWasDeleted(Integer id) throws SQLException {
        SubscriberService ss = new SubscriberService();
        Integer row = ss.delete(id);
        if (row == 1) {
            System.out.println("Subscriber was successfully deleted");
        } else {
            System.out.println("Subscriber can not be deleted, try again");
        }

    }

    public void outputOldestSubscriber() throws SQLException {
        SubscriberService ss = new SubscriberService();
        Subscriber sb = ss.getOldest();
        System.out.println(sb.toString());
    }

}
