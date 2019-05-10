package simpledb;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author gregbeauregard
 */
@DatabaseTable(tableName = "ITEM")
public class Item extends Entity {
    
    public static final String NAME = "name";
    public static final String QUANTITY = "quantity";
    public static final String VENDOR = "id_vend";
    
    @DatabaseField(columnName = NAME)
    private String name;
    
    @DatabaseField(columnName = QUANTITY)
    private Integer quantity;
    
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = VENDOR)
    private Vendor vendor;
    
    /** Not required for ORMLite */
    private Integer idVend;
    
    public Item() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    
    public Integer getIdVend() {
        return idVend;
    }
    
    public void setIdVend(Integer idVend) {
        this.idVend = idVend;
    }
    
    @Override
    public String toString() {
        //I need this to display two different versions for now
        String vendor = (getVendor() == null) ? getIdVend().toString() : "[" + getVendor() + "]";
        return String.valueOf(getId()) + "," + getName() + "," + getQuantity() + "," + vendor;
    }
}
