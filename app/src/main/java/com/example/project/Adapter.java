package com.example.project;

import android.content.Context;
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
    private OnClickListener onClickListener;

    public Adapter(Context context, List<HockeyTeam> teams, OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.teams = teams;
        this.onClickListener = onClickListener;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.itemlayout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HockeyTeam team = teams.get(position);
        holder.tvName.setText(team.getName());
        holder.tvLocation.setText("Plats: " + team.getLocation());
        holder.tvSize.setText("Storlek: " + team.getSize());
        holder.tvCost.setText("Kostnad: " + String.format("%,d SEK", team.getCost()));
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName, tvLocation, tvSize, tvCost;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvName = itemView.findViewById(R.id.tvName);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvSize = itemView.findViewById(R.id.tvSize);
            tvCost = itemView.findViewById(R.id.tvCost);
        }

        @Override
        public void onClick(View view) {
            if (onClickListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    onClickListener.onClick(teams.get(position));
                }
            }
        }
    }

    public interface OnClickListener {
        void onClick(HockeyTeam team);
    }
}
