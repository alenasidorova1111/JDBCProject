package dao;

import java.sql.*;

public class DBConnection {

    public static final String USER = "admin";
    public static final String PASS = "admin";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static Connection conn;
    public static PreparedStatement ps;
    public static Statement st;


    public Connection createConnection() throws SQLException {
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        conn.setAutoCommit(true);
        return conn;
    }

    public Statement createStatement(Connection conn) {
        try {
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return st;
    }

    public PreparedStatement prepareStatement(String query, Connection conn) {
        try {
            ps = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return ps;
    }

    public void closePrepStatement(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeStatement(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
