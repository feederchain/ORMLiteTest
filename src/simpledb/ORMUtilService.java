package simpledb;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gregbeauregard
 * @param <T>
 */
public abstract class ORMUtilService<T extends Entity> {

    public int persist(Dao<T, Integer> dao, T entity) throws SQLException {
        if (entity.getId() == null) {
            return dao.create(entity);
        } else {
            return dao.update(entity);
        }
    }

    public int delete(Dao<T, Integer> dao, T entity) throws SQLException {
        return dao.delete(entity);
    }

    public T selectById(Dao<T, Integer> dao, Integer id) throws SQLException {
        return dao.queryForId(id);
    }

    public List<T> selectAll(Dao<T, Integer> dao) throws SQLException {
        return dao.queryForAll();
    }
}
