package org.tyaa.twofragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.tyaa.twofragments.entity.NewsItem;
import org.tyaa.twofragments.global.Globals;
import java.util.ArrayList;

import org.tyaa.twofragments.events.UpdateNotifier;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {

    RecyclerView mLv;

    public TopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_top, container, false);



        ArrayList<NewsItem> newsList = GetlistContact();
        //mLv = (ListView)getActivity().findViewById(R.id.newsListView);
        mLv = (RecyclerView)rootView.findViewById(R.id.newsListView);
        mLv.setLayoutManager(new LinearLayoutManager(getActivity()));
        //Log.e("mydebug1", mLv.toString());
        //Log.e("mydebug2", getActivity().toString());
        //Log.e("mydebug3", newsList.toString());

        //Toast.makeText(getActivity(), mLv.toString(), Toast.LENGTH_LONG).show();
        //Toast.makeText(getActivity(), newsList.toString(), Toast.LENGTH_LONG).show();

        mLv.setAdapter(new ListviewContactAdapter(getActivity(), newsList, mLv));

        return rootView;
    }

    private ArrayList<NewsItem> GetlistContact(){
        ArrayList<NewsItem> newsList = Globals.newsList;

        /*NewsItem newsItem = new NewsItem();

        newsItem.title = "Topher";
        //contact.SetPhone("01213113568");
        newsList.add(newsItem);

        NewsItem newsItem2 = new NewsItem();
        newsItem2.title = "Topher2";
        //contact.SetPhone("01213113568");
        newsList.add(newsItem2);*/

        for (int i = 0; i < 50; i++){

            NewsItem newsItem = new NewsItem();
            newsItem.id = i;
            newsItem.title = "Topher" + i;
            newsList.add(newsItem);
        }

        return newsList;
    }


}
