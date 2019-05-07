package simpledb;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author gregbeauregard
 */
public class ItemORMUtilService extends ORMUtilService<Item> {

    private final Dao<Item, Integer> itemDao;
    
    public ItemORMUtilService(ConnectionSource connectionSource) throws SQLException {
        itemDao = DaoManager.createDao(connectionSource, Item.class);
    }
    
    public int persist(Item entity) throws SQLException {
        return super.persist(itemDao, entity);
    }
    
    public int delete(Item entity) throws SQLException {
        return super.delete(itemDao, entity);
    }
    
    public Item selectById(Integer id) throws SQLException {
        return super.selectById(itemDao, id);
    }
    
    public List<Item> selectAll() throws SQLException {
        return super.selectAll(itemDao);
    }
    
    public List<Item> selectItemsByVendor(Vendor vendor) throws SQLException {
        QueryBuilder<Item, Integer> statementBuilder = itemDao.queryBuilder();
        statementBuilder.where().eq(Item.VENDOR, vendor);

        return itemDao.query(statementBuilder.prepare());
    }
}
