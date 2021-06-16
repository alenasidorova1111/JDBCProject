package console;

import domain.Subscriber;
import service.SubscriberService;

import java.sql.SQLException;
import java.util.Set;
import java.util.stream.Collectors;

public class SubscriberConsoleOutput {

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

}
