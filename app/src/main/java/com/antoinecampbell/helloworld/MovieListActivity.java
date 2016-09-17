package com.antoinecampbell.helloworld;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie movie = (Movie) adapterView.getAdapter().getItem(i);
                Snackbar.make(adapterView, movie.getTitle(), Snackbar.LENGTH_SHORT).show();
            }
        });
        MovieListAdapter adapter = new MovieListAdapter(this, loadMovies());
        listView.setAdapter(adapter);
    }


    public List<Movie> loadMovies() {
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            movies.add(new Movie("Star Trek", 2009));
            movies.add(new Movie("Star Wars", 1976));
        }

        return movies;
    }

}
