package pizziirreverent.priorit.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import pizziirreverent.priorit.ROOM.Entities.DailyPriorities;
import pizziirreverent.priorit.Repository.PrioritiesRepository;

public class DailyViewModel extends AndroidViewModel{

    private PrioritiesRepository repository;
    private LiveData<List<DailyPriorities>> allDailyPriorities;

    public DailyViewModel(@NonNull Application application){
        super(application);
        repository = new PrioritiesRepository(application);
        allDailyPriorities = repository.getAllDailyPriorities();
    }

    public LiveData<List<DailyPriorities>> getAllDailyPriorities(){
        return allDailyPriorities;
    }

    public void insert(DailyPriorities dailyPriority){
        repository.insertOnlySinglePriority(dailyPriority);
    }
}
