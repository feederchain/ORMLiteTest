package simpledb;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author gregbeauregard
 */
@DatabaseTable(tableName = "VENDOR")
public class Vendor extends Entity {
    
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    
    @DatabaseField(columnName = NAME)
    private String name;
    
    @DatabaseField(columnName = PHONE)
    private Integer phone;
    
    public Vendor() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    
    public String toString() {
        return getId() + "," + getName() + "," + getPhone();
    }
}
