package pizziirreverent.priorit;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pizziirreverent.priorit.Adapters.PrioritiesListAdapter;
import pizziirreverent.priorit.ROOM.Entities.DailyPrioritiesEntity;
import pizziirreverent.priorit.ViewModels.DailyViewModel;

public class MainActivity extends AppCompatActivity {
    /*
     * UI OBJECTS
     */
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.floatingActionButton1)
    FloatingActionButton floatingActionButton;

    /*
     * FINAL VARS
     */
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private static final String TAG = "MainActivity";

    /*
     * ACTIVITY VARS/OBJECTS
     */
    private DailyViewModel dailyViewModel;
    private PrioritiesListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /*
         * Set the adapter for Recyclerview
         */
        adapter = new PrioritiesListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*
         * Hide the FAB when scroll the RecyclerView
         */
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && floatingActionButton.getVisibility() == View.VISIBLE) {
                    floatingActionButton.hide();
                } else if (dy < 0 && floatingActionButton.getVisibility() != View.VISIBLE) {
                    floatingActionButton.show();
                }
            }
        });

        /*
         * Set the ViewModel for this activity
         */
        dailyViewModel = ViewModelProviders.of(this).get(DailyViewModel.class);

        /*
         * Subscribe the "getAllDailyPriorities()" method to "List<DailyPrioritiesEntity>"
         */
        dailyViewModel.getAllDailyPriorities().observe(this, new Observer<List<DailyPrioritiesEntity>>() {
            @Override
            public void onChanged(@Nullable final List<DailyPrioritiesEntity> words) {
                /*
                 * Update the Recyclerview when the List of Daily PrioritDatabase change
                 */
                adapter.setDailyPriorities(words);
            }
        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /*
         * If the last activity was the NewDailyPriority, we insert the priority on the database
         * Else we shows a Toast
         */
        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            DailyPrioritiesEntity dailyPriority = new DailyPrioritiesEntity();
            dailyPriority.setPriorityDesc(data.getStringExtra(NewDailyPriority.EXTRA_REPLY));
            dailyViewModel.insertDailyPriority(dailyPriority);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.EmptyPriority,
                    Toast.LENGTH_LONG).show();
        }
    }

    /*
     * Go to the NewDailyPriority activity
     */
    public void newDailyPriority(View view) {
        Intent intent = new Intent(MainActivity.this, NewDailyPriority.class);
        startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
    }
}
