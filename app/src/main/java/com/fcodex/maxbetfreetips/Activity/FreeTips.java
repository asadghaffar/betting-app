package com.fcodex.maxbetfreetips.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.fcodex.maxbetfreetips.API.API;
import com.fcodex.maxbetfreetips.Modal.Modal;
import com.fcodex.maxbetfreetips.Modal.ModalByDate;
import com.fcodex.maxbetfreetips.R;
import com.fcodex.maxbetfreetips.RecyclerViewAdapter.NewFreeTipsRecyclerViewAdapterByDate;
import com.fcodex.maxbetfreetips.Singlation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FreeTips extends AppCompatActivity {
    private ImageView noDataFound;
    private ImageView customFreeBackImage;
    private StringRequest stringRequestBuilder;
    private ShimmerRecyclerView freeTipsShimmerRecyclerView;
    private final List<ModalByDate> modalByDates = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_tips);

        Objects.requireNonNull(getSupportActionBar()).hide();
        id();
        jsonResponse();
        onClick();

    }

    private void id() {
        freeTipsShimmerRecyclerView = findViewById(R.id.freeTipsShimmerRecyclerView);
        noDataFound = findViewById(R.id.noDataFound);
        customFreeBackImage = findViewById(R.id.customFreeBackImage);
    }

    private void onClick() {
        customFreeBackImage.setOnClickListener(v -> onBackPressed());
    }

    private void jsonResponse() {
        stringRequestBuilder = new StringRequest(Request.Method.GET, API.FREE_TIPS_API, response -> {
            try {
                Log.d("free_tips_response__", response);
                JSONObject jsonObject = new JSONObject(response);
                // Fetching Status
                String status = jsonObject.getString("status");
                Log.d("free_tips_data_status", String.valueOf(status));
                if (status.equalsIgnoreCase("success")) {
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int j = 0; j < jsonArray.length(); j++) {
                        JSONArray jsonArray1 = jsonArray.getJSONArray(j);
                        ModalByDate modaldate = new ModalByDate();
                        if (jsonArray1.length() > 0) {
                            modaldate.setDateString(jsonArray1.getJSONObject(0).getString("date"));
                        } else
                            continue;
                        Log.d("freetips_array_abc", String.valueOf(jsonArray));
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            if (!(jsonArray.length() == 0)) {

                                JSONObject jsonFetchFreeTips = jsonArray1.getJSONObject(i);
                                // Getting Response
                                Log.d("free_tips_data_response", response);

                                int freeTipsId = jsonFetchFreeTips.getInt("id");
                                String freeTipsDate = jsonFetchFreeTips.getString("date");
                                String freeTipsLeagueName = jsonFetchFreeTips.getString("league_name");
                                String freeTipsLeagueTime = jsonFetchFreeTips.getString("match_start_time");
                                String freeTipsTeam1 = jsonFetchFreeTips.getString("team1");
                                String freeTipsTeam2 = jsonFetchFreeTips.getString("team2");
                                String freeTipsTeam1Goals = jsonFetchFreeTips.getString("team1_goals");
                                String freeTipsTeam2Goals = jsonFetchFreeTips.getString("team2_goals");
                                String freeTipsPrediction = jsonFetchFreeTips.getString("prediction");
                                String freeTipsOdds = jsonFetchFreeTips.getString("odds");
                                String freeTipsWinningPercentage = jsonFetchFreeTips.getString("winning_percent");
                                String freeTipsWinLoss = jsonFetchFreeTips.getString("winloss");

                                Modal freeTipsModal = new Modal();
                                freeTipsModal.setFreeTipsId(freeTipsId);
                                freeTipsModal.setFreeTipsDate(freeTipsDate);
                                freeTipsModal.setFreeTipsLeagueName(freeTipsLeagueName);
                                freeTipsModal.setFreeTipsLeagueTime(freeTipsLeagueTime);
                                freeTipsModal.setFreeTipsTeam1(freeTipsTeam1);
                                freeTipsModal.setFreeTipsTeam2(freeTipsTeam2);
                                freeTipsModal.setFreeTipsTeam1Goal(freeTipsTeam1Goals);
                                freeTipsModal.setFreeTipsTeam2Goal(freeTipsTeam2Goals);
                                freeTipsModal.setFreeTipsPrediction(freeTipsPrediction);
                                freeTipsModal.setFreeTipsOdds(freeTipsOdds);
                                freeTipsModal.setFreeTipsPercentage(freeTipsWinningPercentage);
                                freeTipsModal.setFreeTipsWinLoss(freeTipsWinLoss);
                                if (modaldate.getModalsList() == null)
                                    modaldate.setModalsList(new ArrayList<>());
                                modaldate.getModalsList().add(freeTipsModal);
                            } else {
                                noDataFound.setVisibility(View.VISIBLE);
                                freeTipsShimmerRecyclerView.setVisibility(View.GONE);
                            }
                        }
                        modalByDates.add(modaldate);

                    }

                    setUpRecyclerView(modalByDates);
                }
            } catch (JSONException e) {
                Log.d("free_tips_akhbdka", e.getLocalizedMessage());
                e.printStackTrace();
            }

        }, error -> {
            Intent intent = new Intent(FreeTips.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(FreeTips.this, "Server error data.", Toast.LENGTH_LONG).show();
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

    public void setUpRecyclerView(List<ModalByDate> freeTipsFetchDataModal) {
        NewFreeTipsRecyclerViewAdapterByDate newFreeTipsRecyclerViewAdapterByDate = new NewFreeTipsRecyclerViewAdapterByDate(FreeTips.this, freeTipsFetchDataModal);
        freeTipsShimmerRecyclerView.setLayoutManager(new LinearLayoutManager(FreeTips.this));
        freeTipsShimmerRecyclerView.setAdapter(newFreeTipsRecyclerViewAdapterByDate);
    }
}