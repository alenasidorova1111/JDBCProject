package service;

import dao.ServiceDaoImpl;
import domain.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class ServiceService {
    public Service create(String serviceData) throws SQLException {
        ServiceDaoImpl serviceDao = new ServiceDaoImpl();

        String[] separatedData = serviceData.split(" ");
        Service entryService = new Service(0, separatedData[0], Double.valueOf(separatedData[1]));

        ResultSet rs = serviceDao.create(entryService);
        rs.next();

        Service tmp = new Service(rs.getInt("ID"), rs.getString("NAME"),
                rs.getDouble("COST"));

        closeResultSet(rs);

        return tmp;
    }

    public Service read(String name) throws SQLException {
        ServiceDaoImpl serviceDao = new ServiceDaoImpl();

        ResultSet rs = serviceDao.read(name);
        rs.next();

        Service tmp = new Service(rs.getInt("ID"), rs.getString("NAME"),
                rs.getDouble("COST"));

        closeResultSet(rs);

        return tmp;
    }

    public Set<Service> readAll() throws SQLException {
        ServiceDaoImpl serviceDao = new ServiceDaoImpl();
        Set<Service> setOfServices = new HashSet<>();

        ResultSet rs = serviceDao.readAll();
        while (rs.next()) {
            Service tmp = new Service(rs.getInt("ID"), rs.getString("NAME"),
                    rs.getDouble("COST"));
            setOfServices.add(tmp);
        }

        closeResultSet(rs);

        return setOfServices;
    }

    public Service update(String serviceData) throws SQLException {
        ServiceDaoImpl serviceDao = new ServiceDaoImpl();

        String[] separatedData = serviceData.split(" ");

        Service entryService = new Service(Integer.valueOf(separatedData[0]), separatedData[1], Double.valueOf(separatedData[2]));

        ResultSet rs = serviceDao.update(entryService);
        rs.next();

        Service tmp = new Service(rs.getInt("ID"), rs.getString("NAME"),
                rs.getDouble("COST"));

        closeResultSet(rs);

        return tmp;
    }

    public Integer delete(Integer id) throws SQLException {
        ServiceDaoImpl serviceDao = new ServiceDaoImpl();

        return serviceDao.delete(id);
    }

    public void closeResultSet(ResultSet rs) throws SQLException {
        Statement st = rs.getStatement();
        Connection conn = st.getConnection();

        rs.close();
        st.close();
        conn.close();
    }

}
