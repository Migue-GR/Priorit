package pizziirreverent.priorit.ROOM.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/*
 * We create the table for daily priorities
 */
@Entity(tableName = "DailyPriorities")
public class DailyPrioritiesEntity {
    /*
     * Every entity ned a primary key
     */
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id_priority;

    /*
     * The description of the priority
     */
    @NonNull
    private String priorityDesc;

    /*
     * GETTERS AND SETTERS (id_priority)
     */
    @NonNull
    public int getId_priority() {
        return id_priority;
    }

    public void setId_priority(@NonNull int id_priority) {
        this.id_priority = id_priority;
    }

    /*
     * GETTERS AND SETTERS (priorityDesc)
     */
    public String getPriorityDesc() {
        return priorityDesc;
    }

    public void setPriorityDesc(@NonNull String priorityDesc) {
        this.priorityDesc = priorityDesc;
    }
}
