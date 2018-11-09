package pizziirreverent.priorit.ROOM.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import pizziirreverent.priorit.ROOM.DAOs.DaoDaily;
import pizziirreverent.priorit.ROOM.Entities.DailyPriorities;

@Database(entities = {DailyPriorities.class}, version = 1, exportSchema = false)
public abstract class Priorities extends RoomDatabase{
    public abstract DaoDaily daoDaily();
}