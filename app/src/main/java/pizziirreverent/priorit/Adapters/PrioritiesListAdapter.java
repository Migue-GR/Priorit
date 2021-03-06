package pizziirreverent.priorit.Adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pizziirreverent.priorit.R;
import pizziirreverent.priorit.ROOM.Entities.DailyPrioritiesEntity;

public class PrioritiesListAdapter extends RecyclerView.Adapter<PrioritiesListAdapter.PrioritiesListViewHolder>{

    class PrioritiesListViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtv_daily_priority;

        private PrioritiesListViewHolder(View itemView) {
            super(itemView);
            txtv_daily_priority = itemView.findViewById(R.id.txtv_description_list_priority);
        }
    }

    private final LayoutInflater mInflater;
    private List<DailyPrioritiesEntity> dailyPriority; // Cached copy of words

    public PrioritiesListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public PrioritiesListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.list_priority_row, parent, false);
        return new PrioritiesListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PrioritiesListViewHolder holder, int position) {
        if (dailyPriority != null) {
            DailyPrioritiesEntity current = dailyPriority.get(position);
            holder.txtv_daily_priority.setText(current.getPriorityDesc());
        } else {
            // Covers the case of data not being ready yet.
            holder.txtv_daily_priority.setText("No Word");
        }
    }

    public void setDailyPriorities(List<DailyPrioritiesEntity> dailyPriorityEntities){
        dailyPriority = dailyPriorityEntities;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // dailyPriority has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (dailyPriority != null)
            return dailyPriority.size();
        else return 0;
    }
}
