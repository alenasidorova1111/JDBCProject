package dao;
import domain.Subscriber;
import java.sql.*;

public class SubscriberDaoImpl extends DBConnection implements SubscriberDao{

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

        closePrepStatement(ps);
        closeConnection(conn);

        return read(subscriber.getLastName());
    }

    @Override
    public ResultSet read(String lastname) throws SQLException {
        Connection conn = createConnection();
        Statement st = createStatement(conn);
        ResultSet rs = st.executeQuery("SELECT * FROM SUBSCRIBERS WHERE LASTNAME = " + lastname + ";");

        rs.close();
        closeStatement(st);
        closeConnection(conn);

        return rs;
    }

    @Override
    public ResultSet readAll() throws SQLException {
        Connection conn = createConnection();
        Statement st = createStatement(conn);
        ResultSet rs = st.executeQuery("SELECT * FROM SUBSCRIBERS;");

        rs.close();
        closeStatement(st);
        closeConnection(conn);

        return rs;
    }

    @Override
    public Subscriber getOldest() {
        return null;
    }

    @Override
    public Subscriber update(Long id) {
        return null;
    }

    @Override
    public Subscriber delete(Long id) {
        return null;
    }

}
