package pizziirreverent.priorit.ROOM.Database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import pizziirreverent.priorit.ROOM.DAOs.DaoDaily;
import pizziirreverent.priorit.ROOM.Entities.DailyPrioritiesEntity;

/*
 * We specified the entities for the database and the version
 */
@Database(entities = {DailyPrioritiesEntity.class}, version = 1, exportSchema = false)
public abstract class PrioritDatabase extends RoomDatabase{
    /*
     * We reference the DAO
     */
    public abstract DaoDaily daoDaily();

    /*
     * We make a singleton to get a instance from a DataBase
     */
    private static volatile PrioritDatabase INSTANCE;

    public static PrioritDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PrioritDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PrioritDatabase.class, "PrioritDatabase")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}