package pizziirreverent.priorit.ROOM.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import pizziirreverent.priorit.ROOM.DAOs.DaoDaily;
import pizziirreverent.priorit.ROOM.Entities.DailyPriorities;

@Database(entities = {DailyPriorities.class}, version = 1, exportSchema = false)
public abstract class Priorities extends RoomDatabase{
    public abstract DaoDaily daoDaily();

    private static volatile Priorities INSTANCE;

    public static Priorities getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Priorities.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Priorities.class, "Priorities")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}