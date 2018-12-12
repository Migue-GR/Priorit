package pizziirreverent.priorit.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import pizziirreverent.priorit.MainActivity;
import pizziirreverent.priorit.Models.Priority;
import pizziirreverent.priorit.R;

public class PrioritiesAdapter extends RecyclerView.Adapter<PrioritiesAdapter.PrioritiesViewHolder>{

    private ArrayList<Priority> data;
    private Activity activity;

    public PrioritiesAdapter(ArrayList<Priority> data, Activity activity) {
        this.data     = data;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PrioritiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PrioritiesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false));
    }

    @Override
    public void onBindViewHolder(PrioritiesViewHolder holder, int position) {
        Priority priority = data.get(position);
        holder.priorityTitle.setText(priority.getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PrioritiesViewHolder extends RecyclerView.ViewHolder{
        TextView priorityTitle;
        CardView cardView;

        PrioritiesViewHolder(View itemView) {
            super(itemView);
            priorityTitle = itemView.findViewById(R.id.textView3);
            cardView      = itemView.findViewById(R.id.cardView);
        }
    }
}
