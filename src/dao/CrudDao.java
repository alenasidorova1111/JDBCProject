package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CrudDao<T> {

    ResultSet create(T object) throws SQLException;

    ResultSet read(String name) throws SQLException;

    ResultSet readAll() throws SQLException;

    ResultSet update(T object) throws SQLException;

    Integer delete(Integer id) throws SQLException;

}

