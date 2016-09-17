package com.antoinecampbell.helloworld;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MovieListAdapter extends BaseAdapter {

    private List<Movie> movies;
    private Context context;

    public MovieListAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_movie, viewGroup, false);
        }

        TextView title = (TextView) view.findViewById(R.id.title_textview);
        TextView year = (TextView) view.findViewById(R.id.year_textview);
        Movie movie = movies.get(i);

        title.setText(movie.getTitle());
        year.setText(movie.getYear() + "");

        return view;

    }
}
