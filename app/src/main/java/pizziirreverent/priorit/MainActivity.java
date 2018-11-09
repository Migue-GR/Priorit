package pizziirreverent.priorit;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import pizziirreverent.priorit.ROOM.Database.Priorities;
import pizziirreverent.priorit.ROOM.Entities.DailyPriorities;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        final Animation animation = new AnimationUtils().loadAnimation(this, R.anim.scale_item_menu_left);
//        final Animation animation1 = new AnimationUtils().loadAnimation(this, R.anim.scale_item_menu_right);

        final String PRIORITIES = "Priorities";
        final Priorities priorities;
        priorities = Room.databaseBuilder(getApplicationContext(),
                Priorities.class, PRIORITIES)
                .fallbackToDestructiveMigration()
                .build();


        new Thread(new Runnable() {
            @Override
            public void run() {
//                DailyPriorities dailyPriorities =new DailyPriorities();
//                dailyPriorities.setPriorityId("1");
//                dailyPriorities.setPriorityDesc("Will be better");
//                priorities.daoDaily().insertOnlySinglePrioritie(dailyPriorities);
//                priorities.daoAccess() . insertOnlySingleMovie (movie);
//                dailyPriorities.getPriorityId();
                try{
                    String awa = String.valueOf(priorities.daoDaily().fetchOneMoviesbyMovieId(1));
                    Log.i("Prioridades",""+awa);
                }catch(Exception e){
                    Log.e("ERROR","" + e.getMessage());
                }
//                priorities.daoDaily().insertOnlySinglePrioritie(dailyPriorities);
            }
        }) .start();
    }
}
