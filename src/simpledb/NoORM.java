package simpledb;

import java.util.Set;

/**
 *
 * @author gregbeauregard
 */
public class NoORM implements DatabaseWork {

    @Override
    public void doWork() {
        Item item = ItemUtilService.getItem(1);

        System.out.println(item);

        Item newItem = new Item();
        newItem.setId(4);
        newItem.setName("Toothpaste");
        newItem.setQuantity(40);
        newItem.setIdVend(10);

        ItemUtilService.insertItem(newItem);

        Set<Item> set = ItemUtilService.getAllItems();

        System.out.println(set);

        newItem.setQuantity(50);

        ItemUtilService.updateItem(newItem);

        set = ItemUtilService.getAllItems();

        System.out.println(set);

        ItemUtilService.deleteItem(newItem);
    }
    
}
