package com.fcodex.maxbetfreetips.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.fcodex.maxbetfreetips.Activity.FreeTips;
import com.fcodex.maxbetfreetips.Activity.MainActivity;
import com.fcodex.maxbetfreetips.Activity.VipTips;
import com.fcodex.maxbetfreetips.R;
import com.ornach.nobobutton.NoboButton;

public class HomeFragment extends Fragment {

    private View view;
    private Button freeTips;
    private Button vipTips;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        id(view);
        onClick();
        return view;

    }

    private void onClick() {
        freeTips.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), FreeTips.class);
            startActivity(intent);
        });

        vipTips.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), VipTips.class);
            startActivity(intent);
        });

    }

    private void id(View view) {
        freeTips = view.findViewById(R.id.freeTips);
        vipTips = view.findViewById(R.id.vipTips);
    }
}