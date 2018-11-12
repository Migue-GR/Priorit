package pizziirreverent.priorit.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import pizziirreverent.priorit.ROOM.DAOs.DaoDaily;
import pizziirreverent.priorit.ROOM.Database.PrioritDatabase;
import pizziirreverent.priorit.ROOM.Entities.DailyPrioritiesEntity;

public class PrioritiesRepository {
    /*
     * We instanced the DAO
     */
    private DaoDaily daoDaily;
    /*
     * We instanced the LiveData list of all entities
     */
    private LiveData<List<DailyPrioritiesEntity>> allDailyPriorities;

    public PrioritiesRepository(Application application) {
        PrioritDatabase db = PrioritDatabase.getDatabase(application);
        daoDaily = db.daoDaily();
        allDailyPriorities = daoDaily.getAllDailyPriorities();
    }

    /*
     * We returns the list of daily priorities from LiveData
     */
    public LiveData<List<DailyPrioritiesEntity>> getAllDailyPriorities(){
        return allDailyPriorities;
    }

    /*
     * Call an AsyncTask to insert a priority on database
     */
    public void insertDailyPriority (DailyPrioritiesEntity dailyPriority) {
        new insertAsyncTask(daoDaily).execute(dailyPriority);
    }

    /*
     * AsyncTask to insert a priority
     */
    private static class insertAsyncTask extends AsyncTask<DailyPrioritiesEntity, Void, Void> {

        private DaoDaily dao;

        /*
         * We initialize the DAO
         */
        insertAsyncTask(DaoDaily dao) {
            this.dao = dao;
        }

        /*
         * We insert a daily priority on background
         */
        @Override
        protected Void doInBackground(DailyPrioritiesEntity... dailyPriorityEntities) {
            dao.insertDailyPriority(dailyPriorityEntities[0]);
            return null;
        }
    }
}
