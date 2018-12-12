package pizziirreverent.priorit;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import pizziirreverent.priorit.Adapters.PrioritiesAdapter;
import pizziirreverent.priorit.Models.Priority;

public class Priorities extends Activity {

    @BindView(R.id.recyclerview_priorities)
    RecyclerView recyclerView;

    private GridLayoutManager gridLayoutManager;
    private PrioritiesAdapter adapter;

    @Override
    protected void onCreate(@androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.priorities);
        ButterKnife.bind(this);

        gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new PrioritiesAdapter(dataSet(), this);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Priority> dataSet() {
        ArrayList<Priority> data = new ArrayList<>();
        data.add(new Priority("Prioridades del día"));
        data.add(new Priority("Prioridades de la semana"));
        data.add(new Priority("Prioridades del mes"));
        data.add(new Priority("Prioridades del año"));
        return data;
    }
}
