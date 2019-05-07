package simpledb;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author gregbeauregard
 */
public class ItemUtilService {

    private static final Connection CONNECTION = ConnectionFactory.getConnection();
    
    private static final String SELECT = "SELECT * FROM ITEM WHERE id=";
    private static final String SELECT_ALL = "SELECT * FROM ITEM";
    private static final String INSERT = "INSERT INTO ITEM VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE ITEM SET name=?, quantity=?, id_vend=? WHERE id=?";
    private static final String DELETE = "DELETE FROM ITEM WHERE id=?";

    private static Item extractItemFromResultSet(ResultSet rs) throws SQLException {
        Item item = new Item();
        item.setId(rs.getInt("id"));
        item.setName(rs.getString("name"));
        item.setQuantity(rs.getInt("quantity"));
        item.setIdVend(rs.getInt("id_vend"));
        return item;
    }

    public static Item getItem(int id) {
        try {
            Statement stmt = CONNECTION.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT + id);
            if (rs.next()) {
                return extractItemFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Set<Item> getAllItems() {
        try {
            Statement stmt = CONNECTION.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            Set items = new HashSet();
            while (rs.next()) {
                Item user = extractItemFromResultSet(rs);
                items.add(user);
            }
            return items;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static boolean insertItem(Item item) {
        try {
            PreparedStatement ps = CONNECTION.prepareStatement(INSERT);
            ps.setInt(1, item.getId());
            ps.setString(2, item.getName());
            ps.setInt(3, item.getQuantity());
            ps.setInt(4, item.getIdVend());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean updateItem(Item item) {
        try {
            PreparedStatement ps = CONNECTION.prepareStatement(UPDATE);
            ps.setString(1, item.getName());
            ps.setInt(2, item.getQuantity());
            ps.setInt(3, item.getIdVend());
            ps.setInt(4, item.getId());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean deleteItem(Item item) {
        try {
            PreparedStatement ps = CONNECTION.prepareStatement(DELETE);
            ps.setInt(1, item.getId());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
