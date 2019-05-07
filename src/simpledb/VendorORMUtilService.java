package simpledb;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gregbeauregard
 */
public class VendorORMUtilService extends ORMUtilService<Vendor> {

    private final Dao<Vendor, Integer> vendorDao;

    public VendorORMUtilService(ConnectionSource connectionSource) throws SQLException {
        vendorDao = DaoManager.createDao(connectionSource, Vendor.class);
    }

    public int persist(Vendor entity) throws SQLException {
        return super.persist(vendorDao, entity);
    }
    
    public int delete(Vendor entity) throws SQLException {
        return super.delete(vendorDao, entity);
    }
    
    public Vendor selectById(Integer id) throws SQLException {
        return super.selectById(vendorDao, id);
    }
    
    public List<Vendor> selectAll() throws SQLException {
        return super.selectAll(vendorDao);
    }
}
