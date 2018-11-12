package pizziirreverent.priorit;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import pizziirreverent.priorit.Adapters.PrioritiesListAdapter;
import pizziirreverent.priorit.ROOM.Entities.DailyPriorities;
import pizziirreverent.priorit.ViewModels.DailyViewModel;

public class MainActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private DailyViewModel dailyViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final PrioritiesListAdapter adapter = new PrioritiesListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        dailyViewModel = ViewModelProviders.of(this).get(DailyViewModel.class);

        dailyViewModel.getAllDailyPriorities().observe(this, new Observer<List<DailyPriorities>>() {
            @Override
            public void onChanged(@Nullable final List<DailyPriorities> words) {
                // Update the cached copy of the words in the adapter.
                adapter.setDailyPriorities(words);
            }
        });


    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            DailyPriorities dailyPriorities = new DailyPriorities(data.getStringExtra(NewDailyPriority.EXTRA_REPLY));
            dailyViewModel.insert(dailyPriorities);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "vacio, no guardado",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void weas(View view) {
        Intent intent = new Intent(MainActivity.this, NewDailyPriority.class);
        startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
//        startActivity(intent);
    }
}
