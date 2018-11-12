package pizziirreverent.priorit.ROOM.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import pizziirreverent.priorit.ROOM.Entities.DailyPriorities;

/*
 * We define the DAO (Data Access Object) for daily priorities
 */
@Dao
public interface DaoDaily {
    @Insert
    void insertOnlySinglePriority (DailyPriorities dailyPriority);

    @Insert
    void insertMultiplePriorities (List<DailyPriorities> dailyPriorities);

    /*@Query("SELECT * FROM DailyPriorities WHERE priorityId = :priorityId")
    String fetchOneMoviesbyMovieId (int priorityId);*/

    @Query("SELECT * FROM DailyPriorities ORDER BY priorityDesc ASC")
    LiveData <List<DailyPriorities>> getAllDailyPriorities();

    @Query("DELETE FROM DailyPriorities")
    void deleteAllDailyPriorities();

    @Update
    void updatePriorit (DailyPriorities dailyPrioritie);

    @Delete
    void deletePriorit (DailyPriorities dailyPrioritie);
}
