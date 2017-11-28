package org.tyaa.twofragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.tyaa.twofragments.entity.NewsItem;
import org.tyaa.twofragments.events.IOnUpdatedListener;
import org.tyaa.twofragments.events.NewsChangedEvent;
import org.tyaa.twofragments.global.Globals;

import java.util.Optional;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment { //implements IOnUpdatedListener {


    public BottomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MainActivity)getActivity()).updateNotifier.addListener((sender, event) -> {

          Optional<NewsItem> selectedNewsItem=
                Globals.newsList
                    .stream()
                    .filter(item -> item.id == event.selectedItemId)
                    .findFirst();
            Toast.makeText(
                    getActivity()
                    , selectedNewsItem.get().title
                    , Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom, container, false);
    }

    /*@Override
    public void onUpdated() {

        Toast.makeText(getActivity(), "onUpdated", Toast.LENGTH_SHORT).show();
    }*/
}
