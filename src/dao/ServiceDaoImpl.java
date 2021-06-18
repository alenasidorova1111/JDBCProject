package dao;

import domain.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServiceDaoImpl implements CrudDao<Service> {
    public static final String USER = "admin";
    public static final String PASS = "admin";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    private final Connection conn;

    public ServiceDaoImpl() throws SQLException {
        this.conn = DriverManager.getConnection(URL, USER, PASS);
        this.conn.setAutoCommit(true);
    }

    @Override
    public ResultSet create(Service service) throws SQLException {
        String query = "INSERT INTO SERVICE (NAME, COST) VALUES (?, ?)";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, service.getName());
        ps.setDouble(2, service.getCost());
        ps.executeUpdate();

        return this.read(service.getName());
    }

    @Override
    public ResultSet read(String name) throws SQLException {
        Statement st = conn.createStatement();

        return st.executeQuery("SELECT * FROM SERVICE WHERE NAME = '" + name + "'");
    }

    @Override
    public ResultSet readAll() throws SQLException {
        Statement st = conn.createStatement();

        return st.executeQuery("SELECT * FROM SERVICE;");
    }

    @Override
    public ResultSet update(Service service) throws SQLException {
        String query = "UPDATE SERVICE SET NAME = ?, COST = ? WHERE ID = ?";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, service.getName());
        ps.setDouble(2, service.getCost());
        ps.setInt(3, service.getId());
        ps.executeUpdate();

        return this.read(service.getName());
    }

    @Override
    public Integer delete(Integer id) throws SQLException {
        String query = "DELETE FROM SERVICE WHERE ID = ?";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);

        return ps.executeUpdate();
    }

}
