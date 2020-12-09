package com.fcodex.maxbetfreetips.RecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fcodex.maxbetfreetips.Modal.Modal;
import com.fcodex.maxbetfreetips.Modal.ModalByDate;
import com.fcodex.maxbetfreetips.R;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class NewFreeTipsRecyclerViewAdapterByDate extends RecyclerView.Adapter<NewFreeTipsAdapterByDateFilter> {

    private Context context;
    private List<ModalByDate> freeTipsModalListAdapter;
    private View view;

    public NewFreeTipsRecyclerViewAdapterByDate(Context context, List<ModalByDate> freeTipsModalListAdapter) {
        this.context = context;
        this.freeTipsModalListAdapter = freeTipsModalListAdapter;
    }

    @NonNull
    @Override
    public NewFreeTipsAdapterByDateFilter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custsom_new_free_tips_by_date, parent, false);

        return new NewFreeTipsAdapterByDateFilter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewFreeTipsAdapterByDateFilter holder, int position) {

        holder.newDateFreeTipsButton.setClickable(false);
        holder.newDateFreeTipsButton.setEnabled(false);

        holder.newDateFreeTipsButton.setText(freeTipsModalListAdapter.get(position).getDateString());
        setUpRecyclerView(freeTipsModalListAdapter.get(position).getModalsList(), holder.newrecycler);

        holder.newDateFreeTipsButton.setOnClickListener(v -> {
            v.setClickable(false);
            v.setEnabled(false);
        });

    }

    public void setUpRecyclerView(List<Modal> freeTipsFetchDataModal, RecyclerView recyclerView) {
        FreeTipsRecyclerViewAdapter freeTipsRecyclerViewAdapter = new FreeTipsRecyclerViewAdapter(context, freeTipsFetchDataModal);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(freeTipsRecyclerViewAdapter);
    }

    @Override
    public int getItemCount() {
        return freeTipsModalListAdapter.size();
    }
}

class NewFreeTipsAdapterByDateFilter extends RecyclerView.ViewHolder {
    RecyclerView newrecycler;
    MaterialButton newDateFreeTipsButton;

    public NewFreeTipsAdapterByDateFilter(@NonNull View itemView) {
        super(itemView);

        newDateFreeTipsButton = itemView.findViewById(R.id.newDateFreeTipsButton);
        newrecycler = itemView.findViewById(R.id.newrecycler);
    }
}
