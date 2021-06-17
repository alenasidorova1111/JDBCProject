package dao;

import domain.Subscriber;

import java.sql.*;

public class SubscriberDaoImpl extends DBConnection implements SubscriberDao {

    @Override
    public ResultSet create(Subscriber subscriber) throws SQLException {
        Connection conn = createConnection();

        String query = "INSERT INTO SUBSCRIBERS (FIRSTNAME, LASTNAME, CITY, AGE, SEX) VALUES" +
                "(?, ?, ?, ?, ?)";

        PreparedStatement ps = prepareStatement(query, conn);

        ps.setString(1, subscriber.getFirstName());
        ps.setString(2, subscriber.getLastName());
        ps.setString(3, subscriber.getCity());
        ps.setLong(4, subscriber.getAge());
        ps.setString(5, subscriber.getSex());

        ps.executeUpdate();

        closeConnection(conn);
        closePrepStatement(ps);

        return this.read(subscriber.getLastName());
    }

    @Override
    public ResultSet read(String lastname) throws SQLException {
        Connection conn = createConnection();
        Statement st = createStatement(conn);

        return st.executeQuery("SELECT * FROM SUBSCRIBERS WHERE LASTNAME = '" + lastname + "'");
    }

    @Override
    public ResultSet readAll() throws SQLException {
        Connection conn = createConnection();
        Statement st = createStatement(conn);

        return st.executeQuery("SELECT * FROM SUBSCRIBERS;");
    }

    @Override
    public ResultSet update(Subscriber subscriber) throws SQLException {
        Connection conn = createConnection();

        String query = "UPDATE SUBSCRIBERS SET FIRSTNAME = ?, LASTNAME = ?, CITY = ?" +
                "AGE = ?, SEX = ? WHERE ID = ?";

        PreparedStatement ps = prepareStatement(query, conn);

        ps.setString(1, subscriber.getFirstName());
        ps.setString(2, subscriber.getLastName());
        ps.setString(3, subscriber.getCity());
        ps.setLong(4, subscriber.getAge());
        ps.setString(5, subscriber.getSex());
        ps.setInt(6, subscriber.getId());

        ps.executeUpdate();

        closeConnection(conn);
        closePrepStatement(ps);

        return this.read(subscriber.getLastName());
    }

    @Override
    public Integer delete(Integer id) throws SQLException {

        Connection conn = createConnection();

        String query = "DELETE FROM SUBSCRIBERS WHERE ID = ?";

        PreparedStatement ps = prepareStatement(query, conn);
        ps.setInt(1, id);

        Integer row = ps.executeUpdate();

        closeConnection(conn);
        closePrepStatement(ps);

        return row;
    }

    @Override
    public ResultSet getOldest() throws SQLException {
        Connection conn = createConnection();
        Statement st = createStatement(conn);

        return st.executeQuery("SELECT * FROM SUBSCRIBERS WHERE ID =(SELECT MAX(ID) FROM SUBSCRIBERS)");

    }

}
