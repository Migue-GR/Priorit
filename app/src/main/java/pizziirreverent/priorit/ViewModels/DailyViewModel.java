package pizziirreverent.priorit.ViewModels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import java.util.List;

import pizziirreverent.priorit.ROOM.Entities.DailyPrioritiesEntity;
import pizziirreverent.priorit.Repository.PrioritiesRepository;

public class DailyViewModel extends AndroidViewModel{

    /*
     * We instanced the Repository
     */
    private PrioritiesRepository repository;

    /*
     * We instanced the LiveData list of all entities
     */
    private LiveData<List<DailyPrioritiesEntity>> allDailyPriorities;

    public DailyViewModel(@NonNull Application application){
        super(application);
        repository = new PrioritiesRepository(application);
        allDailyPriorities = repository.getAllDailyPriorities();
    }

    /*
     * We returns the list of daily priorities from LiveData
     */
    public LiveData<List<DailyPrioritiesEntity>> getAllDailyPriorities(){
        return allDailyPriorities;
    }

    /*
     * We use the repository to insert a daily priority
     */
    public void insertDailyPriority(DailyPrioritiesEntity dailyPriority){
        repository.insertDailyPriority(dailyPriority);
    }
}
