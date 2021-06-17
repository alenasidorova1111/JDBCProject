package service;

import dao.SubscriberDaoImpl;
import domain.Subscriber;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class SubscriberService {

    public Subscriber create(String subscribersData) throws SQLException {

        String[] separatedData = subscribersData.split(" ");

        Subscriber entry = new Subscriber(0, separatedData[0], separatedData[1], separatedData[2],
                Integer.valueOf(separatedData[3]), separatedData[4]);

        SubscriberDaoImpl sb = new SubscriberDaoImpl();

        ResultSet rs = sb.create(entry);

        rs.first();

        return new Subscriber(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
                rs.getString("CITY"), rs.getInt("AGE"), rs.getString("SEX"));

    }

    public Subscriber read(String lastname) throws SQLException {

        SubscriberDaoImpl sb = new SubscriberDaoImpl();
        ResultSet rs = sb.read(lastname);
        rs.first();
        Subscriber tmp = new Subscriber(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
                rs.getString("CITY"), rs.getInt("AGE"), rs.getString("SEX"));

        rs.close();

        return tmp;

    }

    public Set<Subscriber> readAll() throws SQLException {

        SubscriberDaoImpl sb = new SubscriberDaoImpl();
        ResultSet rs = sb.readAll();

        Set<Subscriber> setOfSubscribers = new HashSet<>();

        while (rs.next()) {

            Subscriber tmp = new Subscriber(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
                    rs.getString("CITY"), rs.getInt("AGE"), rs.getString("SEX"));

            setOfSubscribers.add(tmp);
        }
        return setOfSubscribers;

    }

    public Subscriber update(String subscribersData) throws SQLException {

        String[] separatedData = subscribersData.split(" ");

        Subscriber entry = new Subscriber(Integer.valueOf(separatedData[0]), separatedData[1], separatedData[2], separatedData[3],
                Integer.valueOf(separatedData[4]), separatedData[5]);

        SubscriberDaoImpl sb = new SubscriberDaoImpl();

        ResultSet rs = sb.update(entry);

        rs.first();

        return new Subscriber(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
                rs.getString("CITY"), rs.getInt("AGE"), rs.getString("SEX"));

    }

    public Integer delete(Integer id) throws SQLException {

        SubscriberDaoImpl sb = new SubscriberDaoImpl();

        return sb.delete(id);

    }

    public Subscriber getOldest() throws SQLException {

        SubscriberDaoImpl sb = new SubscriberDaoImpl();
        ResultSet rs = sb.getOldest();
        rs.first();
        Subscriber tmp = new Subscriber(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
                rs.getString("CITY"), rs.getInt("AGE"), rs.getString("SEX"));

        rs.close();

        return tmp;

    }
}
