package pizziirreverent.priorit.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import pizziirreverent.priorit.ROOM.DAOs.DaoDaily;
import pizziirreverent.priorit.ROOM.Database.Priorities;
import pizziirreverent.priorit.ROOM.Entities.DailyPriorities;

public class PrioritiesRepository {
    private DaoDaily daoDaily;
    private LiveData<List<DailyPriorities>> allDailyPriorities;

    public PrioritiesRepository(Application application) {
        Priorities db = Priorities.getDatabase(application);
        daoDaily = db.daoDaily();
        allDailyPriorities = daoDaily.getAllDailyPriorities();
    }

    public LiveData<List<DailyPriorities>> getAllDailyPriorities(){
        return allDailyPriorities;
    }

    public void insertOnlySinglePriority (DailyPriorities dailyPriority) {
        new insertAsyncTask(daoDaily).execute(dailyPriority);
    }

    private static class insertAsyncTask extends AsyncTask<DailyPriorities, Void, Void> {

        private DaoDaily mAsyncTaskDao;

        insertAsyncTask(DaoDaily dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(DailyPriorities... dailyPriorities) {
            mAsyncTaskDao.insertOnlySinglePriority(dailyPriorities[0]);
            return null;
        }
    }
}
