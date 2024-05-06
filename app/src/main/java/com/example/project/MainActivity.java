package com.example.project;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {
    private Adapter adapter;
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a23alera";
    private final ArrayList<HockeyTeam> hockeyTeams = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Adapter(this, hockeyTeams, new Adapter.OnClickListener() {
            @Override
            public void onClick(HockeyTeam team) {
                Toast.makeText(MainActivity.this, "Clicked on " + team.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
        getJson();
    }

    private void getJson() {
        new JsonTask(this).execute(JSON_URL);
    }

    private ArrayList<HockeyTeam> parseJson(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("ID");
                String name = jsonObject.getString("name");
                String type = jsonObject.getString("type");
                String location = jsonObject.getString("location");
                int size = jsonObject.getInt("size");
                int cost = jsonObject.getInt("cost");
                String auxData = jsonObject.getString("auxdata");
                String company = jsonObject.optString("company", "");

                HockeyTeam team = new HockeyTeam(id, name, type, location, size, cost, "", auxData, company);
                hockeyTeams.add(team);
            }
            return hockeyTeams;
        } catch (JSONException e) {
            Toast.makeText(this, "Error parsing JSON", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void onPostExecute(String json) {
        hockeyTeams.clear();
        hockeyTeams.addAll(parseJson(json));
        adapter.notifyDataSetChanged();
        Log.d("MainActivity", "Data updated, " + hockeyTeams.size() + " items");
    }
}
