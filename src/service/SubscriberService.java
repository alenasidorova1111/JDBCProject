package service;

import dao.SubscriberDaoImpl;
import domain.Subscriber;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class SubscriberService {
    public Subscriber create(String subscribersData) throws SQLException {
        SubscriberDaoImpl subscriberDao = new SubscriberDaoImpl();

        String[] separatedData = subscribersData.split(" ");

        Subscriber entrySubscriber = new Subscriber(0, separatedData[0], separatedData[1], separatedData[2],
                Integer.valueOf(separatedData[3]), separatedData[4]);

        ResultSet rs = subscriberDao.create(entrySubscriber);
        rs.next();

        Subscriber tmp = new Subscriber(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
                rs.getString("CITY"), rs.getInt("AGE"), rs.getString("SEX"));

        closeResultSet(rs);

        return tmp;

    }

    public Subscriber read(String lastname) throws SQLException {
        SubscriberDaoImpl subscriberDao = new SubscriberDaoImpl();

        ResultSet rs = subscriberDao.read(lastname);
        rs.next();

        Subscriber tmp = new Subscriber(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
                rs.getString("CITY"), rs.getInt("AGE"), rs.getString("SEX"));

        closeResultSet(rs);

        return tmp;
    }

    public Set<Subscriber> readAll() throws SQLException {
        SubscriberDaoImpl subscriberDao = new SubscriberDaoImpl();
        Set<Subscriber> setOfSubscribers = new HashSet<>();

        ResultSet rs = subscriberDao.readAll();
        while (rs.next()) {
            Subscriber tmp = new Subscriber(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
                    rs.getString("CITY"), rs.getInt("AGE"), rs.getString("SEX"));

            setOfSubscribers.add(tmp);
        }

        closeResultSet(rs);

        return setOfSubscribers;
    }

    public Subscriber update(String subscribersData) throws SQLException {
        SubscriberDaoImpl subscriberDao = new SubscriberDaoImpl();

        String[] separatedData = subscribersData.split(" ");

        Subscriber entrySubscriber = new Subscriber(Integer.valueOf(separatedData[0]), separatedData[1], separatedData[2], separatedData[3],
                Integer.valueOf(separatedData[4]), separatedData[5]);

        ResultSet rs = subscriberDao.update(entrySubscriber);
        rs.next();

        Subscriber tmp = new Subscriber(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
                rs.getString("CITY"), rs.getInt("AGE"), rs.getString("SEX"));

        closeResultSet(rs);

        return tmp;

    }

    public Integer delete(Integer id) throws SQLException {
        SubscriberDaoImpl subscriberDao = new SubscriberDaoImpl();

        return subscriberDao.delete(id);

    }

    public Subscriber getOldest() throws SQLException {
        SubscriberDaoImpl subscriberDao = new SubscriberDaoImpl();

        ResultSet rs = subscriberDao.getOldest();
        rs.next();

        Subscriber tmp = new Subscriber(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
                rs.getString("CITY"), rs.getInt("AGE"), rs.getString("SEX"));

        closeResultSet(rs);

        return tmp;

    }

    public void closeResultSet(ResultSet rs) throws SQLException {
        Statement st = rs.getStatement();
        Connection conn = st.getConnection();

        rs.close();
        st.close();
        conn.close();
    }

}
