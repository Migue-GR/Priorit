package pizziirreverent.priorit.ROOM.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import pizziirreverent.priorit.ROOM.Entities.DailyPrioritiesEntity;

/*
 * We define the DAO (Data Access Object) for daily priorities
 */
@Dao
public interface DaoDaily {
    @Insert
    void insertDailyPriority (DailyPrioritiesEntity dailyPriority);

    @Query("SELECT * FROM DailyPriorities ORDER BY priorityDesc ASC")
    LiveData <List<DailyPrioritiesEntity>> getAllDailyPriorities();

    @Query("DELETE FROM DailyPriorities")
    void deleteAllDailyPriorities();

    @Update
    void updatePriorit (DailyPrioritiesEntity dailyPrioritie);

    @Delete
    void deletePriorit (DailyPrioritiesEntity dailyPrioritie);
}
