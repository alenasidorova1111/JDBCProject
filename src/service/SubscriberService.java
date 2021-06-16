package service;

import dao.DBConnection;
import dao.SubscriberDaoImpl;
import domain.Subscriber;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class SubscriberService  {

    //TeacherDao teacherDao = new TeacherDaoImpl();

    public Subscriber read(String lastname) throws SQLException {

        SubscriberDaoImpl sb = new SubscriberDaoImpl();
        ResultSet rs = sb.read(lastname);

      return new Subscriber(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
              rs.getString("CITY"), rs.getInt("AGE"), rs.getString("SEX"));

    }

    public Set<Subscriber> readAll() throws SQLException {

        SubscriberDaoImpl sb = new SubscriberDaoImpl();
        ResultSet rs = sb.readAll();

        Set<Subscriber> setOfSubscribers = new HashSet<Subscriber>();

        while(rs.next()){

            Subscriber tmp = new Subscriber(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
                    rs.getString("CITY"), rs.getInt("AGE"), rs.getString("SEX"));

            setOfSubscribers.add(tmp);
        }
        return setOfSubscribers;

    }
}
