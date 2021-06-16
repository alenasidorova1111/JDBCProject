package dao;
import com.lab.dao.CrudDao;
import domain.Subscriber;

public interface SubscriberDao extends CrudDao<Subscriber> {

    Subscriber getOldest();

}
