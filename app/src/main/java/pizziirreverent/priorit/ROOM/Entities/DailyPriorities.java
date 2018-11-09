package pizziirreverent.priorit.ROOM.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class DailyPriorities {
    @NonNull
    @PrimaryKey
    private String priorityId;
    private String priorityDesc;


    @NonNull
    public String getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(@NonNull String priorityId) {
        this.priorityId = priorityId;
    }

    public String getPriorityDesc() {
        return priorityDesc;
    }

    public void setPriorityDesc(String priorityDesc) {
        this.priorityDesc = priorityDesc;
    }
}
