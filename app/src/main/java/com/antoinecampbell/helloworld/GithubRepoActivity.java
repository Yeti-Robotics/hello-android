package com.antoinecampbell.helloworld;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class GithubRepoActivity extends AppCompatActivity {

    private ListView listView;
    private RepoListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_repo);


        listView = (ListView) findViewById(R.id.listview);
        adapter = new RepoListAdapter(this, Collections.<Repo>emptyList());
        listView.setAdapter(adapter);
        new AsyncTask<Void, Integer, List<Repo>>() {

            @Override
            protected List<Repo> doInBackground(Void... voids) {
                return loadRepos();
            }

            @Override
            protected void onPostExecute(List<Repo> repos) {
                adapter.updateRepos(repos);
            }
        }.execute();
    }

    private List<Repo> loadRepos() {
        Gson gson = new Gson();

        try {
            Thread.sleep(4000);
            URL url = new URL("https://api.github.com/orgs/yeti-robotics/repos");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            List<Repo> repos = gson.fromJson(new InputStreamReader(connection.getInputStream()),
                    new TypeToken<List<Repo>>(){}.getType());
            return repos;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

}
