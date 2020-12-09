package com.fcodex.maxbetfreetips.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.fcodex.maxbetfreetips.API.API;
import com.fcodex.maxbetfreetips.Modal.Modal;
import com.fcodex.maxbetfreetips.R;
import com.fcodex.maxbetfreetips.RecyclerViewAdapter.VipTipsRecyclerViewAdapter;
import com.fcodex.maxbetfreetips.Singlation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class VipTips extends AppCompatActivity {

    private ImageView noDataFound;
    private ImageView customBackImage;
    private StringRequest stringRequestBuilder;
    private ShimmerRecyclerView vipTipsShimmerRecyclerView;
    private final List<Modal> vipTipsFetchDataModal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip_tips);

        Objects.requireNonNull(getSupportActionBar()).hide();
        id();
        jsonResponse();
        onClick();

    }

    private void onClick() {
        customBackImage.setOnClickListener(v -> onBackPressed());
    }

    private void id() {
        vipTipsShimmerRecyclerView = findViewById(R.id.vipTipsShimmerRecyclerView);
        noDataFound = findViewById(R.id.noDataFound);
        customBackImage = findViewById(R.id.customBackImage);
    }

    private void jsonResponse() {
        stringRequestBuilder = new StringRequest(Request.Method.GET, API.VIP_TIPS_API, response -> {
            try {
                Log.d("response__", response);
                JSONObject jsonObject = new JSONObject(response);
                // Fetching Status
                String status = jsonObject.getString("status");
                Log.d("data_status", String.valueOf(status));
                if (status.equalsIgnoreCase("success")) {
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int j = 0; j < jsonArray.length(); j++) {
                        JSONArray jsonArray1 = jsonArray.getJSONArray(j);
                        Log.d("array_abc", String.valueOf(jsonArray));
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            if (!(jsonArray.length() == 0)) {

                                JSONObject jsonFetchVipTips = jsonArray1.getJSONObject(i);
                                // Getting Response
                                Log.d("data_response", response);

                                int vipId = jsonFetchVipTips.getInt("id");
                                String vipDate = jsonFetchVipTips.getString("date");
                                String vipTitle = jsonFetchVipTips.getString("title");
                                String vipLink = jsonFetchVipTips.getString("link");
                                String vipDescription = jsonFetchVipTips.getString("description");
                                String vipImage = jsonFetchVipTips.getString("img_link");
                                Log.d("vipImage", vipImage);

                                Modal modal = new Modal();
                                modal.setVipId(vipId);
                                modal.setVipDate(vipDate);
                                modal.setVipTitle(vipTitle);
                                modal.setVipLink(vipLink);
                                modal.setVipDescription(vipDescription);
                                modal.setVipImage(vipImage);

                                vipTipsFetchDataModal.add(modal);
                            } else if (jsonArray.length() == 0){
                                noDataFound.setVisibility(View.VISIBLE);
                                vipTipsShimmerRecyclerView.setVisibility(View.GONE);
                            }
                        }

                    }

                    setUpRecyclerView(vipTipsFetchDataModal);
                }
            } catch (JSONException e) {
                Log.d("akhbdka", e.getLocalizedMessage());
                e.printStackTrace();
            }

        }, error -> {
            Intent intent = new Intent(VipTips.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(VipTips.this, "Server error data.", Toast.LENGTH_LONG).show();
        }) {

            @Override
            protected Map<String, String> getParams() {
                return new HashMap<>();
            }

        };

        // if server is not getting the response then it shows hits the API in every 5 seconds
        stringRequestBuilder.setRetryPolicy(new DefaultRetryPolicy(
                50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Singlation.getInstance(this).addToRequestQueue(stringRequestBuilder, "");
    }

    public void setUpRecyclerView(List<Modal> vipTipsFetchDataModal) {
        VipTipsRecyclerViewAdapter vipTipsRecyclerViewAdapter = new VipTipsRecyclerViewAdapter(VipTips.this, vipTipsFetchDataModal);
        vipTipsShimmerRecyclerView.setLayoutManager(new LinearLayoutManager(VipTips.this));
        vipTipsShimmerRecyclerView.setAdapter(vipTipsRecyclerViewAdapter);
    }

}