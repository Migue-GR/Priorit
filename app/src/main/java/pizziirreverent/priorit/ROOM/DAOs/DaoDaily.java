package pizziirreverent.priorit.ROOM.DAOs;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import pizziirreverent.priorit.ROOM.Entities.DailyPriorities;

@Dao
public interface DaoDaily {
    @Insert
    void insertOnlySinglePrioritie (DailyPriorities dailyPrioritie);

    @Insert
    void insertMultiplePriorities (List<DailyPriorities> dailyPriorities);

    @Query("SELECT * FROM DailyPriorities WHERE priorityId = :priorityId")
    String fetchOneMoviesbyMovieId (int priorityId);

    @Update
    void updatePriorit (DailyPriorities dailyPrioritie);

    @Delete
    void deletePriorit (DailyPriorities dailyPrioritie);
}
