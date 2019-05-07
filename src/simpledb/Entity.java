package simpledb;

import com.j256.ormlite.field.DatabaseField;

/**
 *
 * @author gregbeauregard
 */
public class Entity {
    
    public static final String ID = "id";
    
    @DatabaseField(columnName = ID, generatedId = true)
    private Integer id;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
