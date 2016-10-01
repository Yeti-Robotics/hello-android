package com.antoinecampbell.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class RepoListAdapter extends BaseAdapter {

    private List<Repo> repos;
    private Context context;

    public RepoListAdapter(Context context, List<Repo> repos) {
        this.context = context;
        this.repos = repos;
    }

    @Override
    public int getCount() {
        return repos.size();
    }

    @Override
    public Object getItem(int i) {
        return repos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view  = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, viewGroup, false);
        }

        TextView textView = (TextView) view.findViewById(android.R.id.text1);
        TextView textView2 = (TextView) view.findViewById(android.R.id.text2);

        Repo repo = repos.get(i);
        textView.setText(repo.getName());
        textView2.setText(repo.getUrl());

        return view;
    }

    public void updateRepos(List<Repo> repos) {
        this.repos = repos;
        notifyDataSetChanged();
    }
}
