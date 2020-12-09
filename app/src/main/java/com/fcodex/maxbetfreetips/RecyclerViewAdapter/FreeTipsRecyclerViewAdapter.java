package com.fcodex.maxbetfreetips.RecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fcodex.maxbetfreetips.Modal.Modal;
import com.fcodex.maxbetfreetips.R;

import java.util.List;

public class FreeTipsRecyclerViewAdapter extends RecyclerView.Adapter<FreeTips> {

    private Context context;
    private List<Modal> freeTipsModalListAdapter;
    private View view;

    public FreeTipsRecyclerViewAdapter(Context context, List<Modal> freeTipsModalListAdapter) {
        this.context = context;
        this.freeTipsModalListAdapter = freeTipsModalListAdapter;
    }

    @NonNull
    @Override
    public FreeTips onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_free_tips_view, parent, false);

        return new FreeTips(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FreeTips holder, int position) {

        holder.leagueNameFreeTipsTextView.setText(freeTipsModalListAdapter.get(position).getFreeTipsLeagueName());
        holder.leagueTimeFreeTipsTextView.setText(freeTipsModalListAdapter.get(position).getFreeTipsLeagueTime());
        holder.team1FreeTipsTextView.setText(freeTipsModalListAdapter.get(position).getFreeTipsTeam1());
        holder.team1GoalFreeTipsTextView.setText(freeTipsModalListAdapter.get(position).getFreeTipsTeam1Goal());
        holder.team2GoalFreeTipsTextView.setText(freeTipsModalListAdapter.get(position).getFreeTipsTeam2Goal());
        holder.team2FreeTipsTextView.setText(freeTipsModalListAdapter.get(position).getFreeTipsTeam2());
        holder.predictionFreeTipsTextView.setText(freeTipsModalListAdapter.get(position).getFreeTipsPrediction());
        holder.oddsFreeTipsTextView.setText(freeTipsModalListAdapter.get(position).getFreeTipsOdds());
        holder.percentageFreeTipsTextView.setText(freeTipsModalListAdapter.get(position).getFreeTipsPercentage());
        holder.winLossFreeTipsTextView.setText(freeTipsModalListAdapter.get(position).getFreeTipsWinLoss());

        if (freeTipsModalListAdapter.get(position).getFreeTipsWinLoss().equals("none")) {
            holder.imageViewFreeTips.setVisibility(View.GONE);
            holder.winLossFreeTipsTextView.setVisibility(View.VISIBLE);
        } else if (freeTipsModalListAdapter.get(position).getFreeTipsWinLoss().equals("lose")) {
            holder.imageViewFreeTips.setVisibility(View.VISIBLE);
            holder.imageViewFreeTips.setImageResource(R.drawable.loss);
            holder.winLossFreeTipsTextView.setVisibility(View.GONE);
        }else if (freeTipsModalListAdapter.get(position).getFreeTipsWinLoss().equals("win")) {
            holder.imageViewFreeTips.setVisibility(View.VISIBLE);
            holder.imageViewFreeTips.setImageResource(R.drawable.win);
            holder.winLossFreeTipsTextView.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return freeTipsModalListAdapter.size();
    }
}

class FreeTips extends RecyclerView.ViewHolder {

    TextView leagueNameFreeTipsTextView;
    TextView leagueTimeFreeTipsTextView;
    TextView team1FreeTipsTextView;
    TextView team1GoalFreeTipsTextView;
    TextView team2GoalFreeTipsTextView;
    TextView team2FreeTipsTextView;
    TextView predictionFreeTipsTextView;
    TextView oddsFreeTipsTextView;
    TextView percentageFreeTipsTextView;
    ImageView imageViewFreeTips;
    TextView winLossFreeTipsTextView;

    public FreeTips(@NonNull View itemView) {
        super(itemView);

        leagueNameFreeTipsTextView = itemView.findViewById(R.id.leagueNameFreeTipsTextView);
        leagueTimeFreeTipsTextView = itemView.findViewById(R.id.leagueTimeFreeTipsTextView);
        team1FreeTipsTextView = itemView.findViewById(R.id.team1FreeTipsTextView);
        team1GoalFreeTipsTextView = itemView.findViewById(R.id.team1GoalFreeTipsTextView);
        team2GoalFreeTipsTextView = itemView.findViewById(R.id.team2GoalFreeTipsTextView);
        team2FreeTipsTextView = itemView.findViewById(R.id.team2FreeTipsTextView);
        predictionFreeTipsTextView = itemView.findViewById(R.id.predictionFreeTipsTextView);
        oddsFreeTipsTextView = itemView.findViewById(R.id.oddsFreeTipsTextView);
        percentageFreeTipsTextView = itemView.findViewById(R.id.percentageFreeTipsTextView);
        imageViewFreeTips = itemView.findViewById(R.id.imageViewFreeTips);
        winLossFreeTipsTextView = itemView.findViewById(R.id.winLossFreeTipsTextView);

    }
}