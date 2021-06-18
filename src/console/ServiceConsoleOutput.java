package console;

import domain.Service;
import service.ServiceService;

import java.sql.SQLException;
import java.util.Set;
import java.util.stream.Collectors;

public class ServiceConsoleOutput {
    ServiceService servService = new ServiceService();

    public void outputCreatedService(String serviceData) throws SQLException {
        Service service = servService.create(serviceData);
        System.out.println("Successfully created: " + service.toString());
    }

    public void outputService(String name) throws SQLException {
        Service service = servService.read(name);
        System.out.println(service.toString());
    }

    public void outputAllServices() throws SQLException {
        Set<Service> set = servService.readAll();
        String setString = set.stream().map(Service::toString).collect(Collectors.joining("\n"));
        System.out.println(setString);
    }

    public void outputUpdatedService(String serviceData) throws SQLException {
        Service service = servService.update(serviceData);
        System.out.println("Successfully updated: " + service.toString());
    }

    public void outputServiceWasDeleted(Integer id) throws SQLException {
        Integer row = servService.delete(id);

        if (row == 1) {
            System.out.println("Service was successfully deleted");
        } else {
            System.out.println("Service can not be deleted, try again");
        }
    }

}
