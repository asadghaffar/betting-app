package com.fcodex.maxbetfreetips.RecyclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fcodex.maxbetfreetips.Modal.Modal;
import com.fcodex.maxbetfreetips.R;

import java.util.List;

public class VipTipsRecyclerViewAdapter extends RecyclerView.Adapter<VipsTips> {

    private Context context;
    private List<Modal> vipTipsModalListAdapter;
    private View view;

    public VipTipsRecyclerViewAdapter(Context context, List<Modal> vipTipsModalListAdapter) {
        this.context = context;
        this.vipTipsModalListAdapter = vipTipsModalListAdapter;
    }

    @NonNull
    @Override
    public VipsTips onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_vip_tips_view, parent, false);

        return new VipsTips(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VipsTips holder, int position) {

        holder.vipDateTextView.setText(vipTipsModalListAdapter.get(position).getVipDate());
        holder.vipTitleSocialAccount.setText(vipTipsModalListAdapter.get(position).getVipTitle());
        holder.vipSocialLink.setText(vipTipsModalListAdapter.get(position).getVipLink());
        holder.vipShortDescription.setText(vipTipsModalListAdapter.get(position).getVipDescription());

        Log.d("imageShow_", vipTipsModalListAdapter.get(position).getVipImage());
        Glide.with(context).load(vipTipsModalListAdapter.get(position)
                .getVipImage())
                .centerCrop()
                .placeholder(R.drawable.loading)
                .error(R.drawable.ic_error)
                .into(holder.vipImageView);

        holder.vipSocialLink.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(vipTipsModalListAdapter.get(position).getVipLink()));
            context.startActivity(i);
        });

    }

    @Override
    public int getItemCount() {
        return vipTipsModalListAdapter.size();
    }
}

class VipsTips extends RecyclerView.ViewHolder {

    public TextView vipDateTextView;
    public TextView vipTitleSocialAccount;
    public TextView vipSocialLink;
    public TextView vipShortDescription;
    public ImageView vipImageView;

    public VipsTips(@NonNull View itemView) {
        super(itemView);

        vipDateTextView = itemView.findViewById(R.id.vipDateTextView);
        vipTitleSocialAccount = itemView.findViewById(R.id.vipTitleSocialAccount);
        vipSocialLink = itemView.findViewById(R.id.vipSocialLink);
        vipShortDescription = itemView.findViewById(R.id.vipShortDescription);
        vipImageView = itemView.findViewById(R.id.vipImageView);

    }
}
