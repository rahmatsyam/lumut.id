package io.github.rahmatsyam.lumutid.ui.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.github.rahmatsyam.lumutid.R;
import io.github.rahmatsyam.lumutid.data.model.ItemData;
import io.github.rahmatsyam.lumutid.ui.adapter.ItemAdapter;

public class MainActivity extends AppCompatActivity {

    String url = "https://jsonplaceholder.typicode.com/todos/";
    private List<ItemData> itemList;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    DividerItemDecoration itemDecoration;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);

        adapter = new ItemAdapter(this, itemList);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        itemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);
        getData();
    }


    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        ItemData itemData = new ItemData();
                        itemData.setTitle(jsonObject.getString("title"));
                        itemData.setUserId(jsonObject.getInt("userId"));
                        itemData.setId(jsonObject.getInt("id"));

                        itemList.add(itemData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }

                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        finish();

    }
}
