package simpledb;

import com.j256.ormlite.support.ConnectionSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gregbeauregard
 */
public class ORMLite implements DatabaseWork {
    
    private ItemORMUtilService itemUtilService;
    private VendorORMUtilService vendorUtilService;
    

    @Override
    public void doWork() {
        try {
            ConnectionSource connectionSource = ConnectionFactory.getConnectionSource();
            itemUtilService = new ItemORMUtilService(connectionSource);
            vendorUtilService = new VendorORMUtilService(connectionSource);
            

            Item item = itemUtilService.selectById(1);

            System.out.println(item);

            Item newItem = new Item();
            newItem.setName("Toothpaste");
            newItem.setQuantity(40);
            newItem.setVendor(item.getVendor());

            System.out.println(newItem);

            itemUtilService.persist(newItem);

            List<Item> list = itemUtilService.selectAll();

            System.out.println(list);

            newItem.setQuantity(50);

            Vendor vendor = vendorUtilService.selectById(20);

            newItem.setVendor(vendor);

            itemUtilService.persist(newItem);

            list = itemUtilService.selectAll();

            System.out.println(list);

            List<Item> items = itemUtilService.selectItemsByVendor(newItem.getVendor());

            System.out.println(items);

            itemUtilService.delete(newItem);
        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }
    }

}
