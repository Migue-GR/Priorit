package pizziirreverent.priorit.ROOM.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/*
 * We create the table for daily priorities
 */
@Entity
public class DailyPriorities {
    /*
     * Every entity ned a primary key
     */
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id_priority;

    @NonNull
    private String priorityDesc;

    public DailyPriorities(@NonNull String priorityDesc) {
        this.priorityDesc = priorityDesc;
    }

    @NonNull
    public int getId_priority() {
        return id_priority;
    }

    public void setId_priority(@NonNull int id_priority) {
        this.id_priority = id_priority;
    }

    public String getPriorityDesc() {
        return priorityDesc;
    }

    public void setPriorityDesc(String priorityDesc) {
        this.priorityDesc = priorityDesc;
    }
}
