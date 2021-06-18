package dao;

import domain.Subscriber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SubscriberDaoImpl implements SubscriberDao {
    public static final String USER = "admin";
    public static final String PASS = "admin";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    private final Connection conn;

    public SubscriberDaoImpl() throws SQLException {
        this.conn = DriverManager.getConnection(URL, USER, PASS);
        this.conn.setAutoCommit(true);
    }

    @Override
    public ResultSet create(Subscriber subscriber) throws SQLException {
        String query = "INSERT INTO SUBSCRIBERS (FIRSTNAME, LASTNAME, CITY, AGE, SEX) VALUES" +
                "(?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, subscriber.getFirstName());
        ps.setString(2, subscriber.getLastName());
        ps.setString(3, subscriber.getCity());
        ps.setLong(4, subscriber.getAge());
        ps.setString(5, subscriber.getSex());
        ps.executeUpdate();

        return this.read(subscriber.getLastName());
    }

    @Override
    public ResultSet read(String lastname) throws SQLException {
        Statement st = conn.createStatement();

        return st.executeQuery("SELECT * FROM SUBSCRIBERS WHERE LASTNAME = '" + lastname + "'");
    }

    @Override
    public ResultSet readAll() throws SQLException {
        Statement st = conn.createStatement();

        return st.executeQuery("SELECT * FROM SUBSCRIBERS;");
    }

    @Override
    public ResultSet update(Subscriber subscriber) throws SQLException {
        String query = "UPDATE SUBSCRIBERS SET FIRSTNAME = ?, LASTNAME = ?, CITY = ?, AGE = ?, SEX = ? WHERE ID = ?";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, subscriber.getFirstName());
        ps.setString(2, subscriber.getLastName());
        ps.setString(3, subscriber.getCity());
        ps.setLong(4, subscriber.getAge());
        ps.setString(5, subscriber.getSex());
        ps.setInt(6, subscriber.getId());
        ps.executeUpdate();

        return this.read(subscriber.getLastName());
    }

    @Override
    public Integer delete(Integer id) throws SQLException {
        String query = "DELETE FROM SUBSCRIBERS WHERE ID = ?";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);

        return ps.executeUpdate();
    }

    @Override
    public ResultSet getOldest() throws SQLException {
        Statement st = conn.createStatement();

        return st.executeQuery("SELECT * FROM SUBSCRIBERS WHERE AGE =(SELECT MAX(AGE) FROM SUBSCRIBERS)");
    }

}
