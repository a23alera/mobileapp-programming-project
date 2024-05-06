package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<HockeyTeam> teams;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(Context context, List<HockeyTeam> teams) {
        this.layoutInflater = LayoutInflater.from(context);
        this.teams = teams;
        this.context = context;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.itemlayout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final HockeyTeam team = teams.get(position);
        holder.tvName.setText(team.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TeamActivity.class);
                intent.putExtra("Name", team.getName());
                intent.putExtra("Location", team.getLocation());
                intent.putExtra("Cost", team.getCost());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
