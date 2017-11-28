package org.tyaa.twofragments;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.tyaa.twofragments.entity.NewsItem;

import java.util.ArrayList;

/**
 * Created by student on 02.09.2017.
 */

public class ListviewContactAdapter extends RecyclerView.Adapter<NewsHolder> {

    private static ArrayList<NewsItem> newsList;
    private View mOwnerView;
    private LayoutInflater mInflater;
    private  Activity mActivity;

    public ListviewContactAdapter(
            Activity _activity
            , ArrayList<NewsItem> _results
            , View _ownerView){

        newsList = _results;
        mInflater = LayoutInflater.from((Context)_activity);
        mActivity = _activity;
        mOwnerView = _ownerView;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View convertView = mInflater.inflate(R.layout.news_item, null);

        NewsHolder newsHolder = new NewsHolder(convertView, mOwnerView);
        newsHolder.activity = mActivity;



        return newsHolder;
    }

    @Override
    public void onBindViewHolder(NewsHolder newsHolder, int i) {

        /*Toast.makeText(mActivity, newsList.toString(), Toast.LENGTH_LONG).show();
        Toast.makeText(mActivity, String.valueOf(i), Toast.LENGTH_LONG).show();
        Toast.makeText(mActivity, newsList.get(i).toString(), Toast.LENGTH_LONG).show();*/
        newsHolder.bindNewsItem(newsList.get(i));

    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
