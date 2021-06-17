package dao;

import domain.Subscriber;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SubscriberDao extends CrudDao<Subscriber> {

    ResultSet getOldest() throws SQLException;

}
