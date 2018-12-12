package pizziirreverent.priorit.ROOM.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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
