package org.tyaa.twofragments;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.tyaa.twofragments.entity.NewsItem;
import org.tyaa.twofragments.events.NewsChangedEvent;

/**
 * Created by student on 09.09.2017.
 */

public class NewsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    //TextView txtname, txtphone;
    private TextView mTxtName;
    private NewsItem mNewsItem;
    LinearLayout mConvertView;
    public Activity activity;
    private View mOwnerView;

    public NewsHolder(View itemView, View _ownerView) {

        super(itemView);
        mConvertView = (LinearLayout) itemView;
        mTxtName = (TextView) mConvertView.findViewById(R.id.newsItemTextView);
        mOwnerView = _ownerView;
        itemView.setOnClickListener(this);
    }

    public void bindNewsItem(NewsItem _newsItem) {
        mNewsItem = _newsItem;
        mTxtName.setText(mNewsItem.title);
    }

    @Override
    public void onClick(View v) {

        NewsChangedEvent event =
            new NewsChangedEvent(mOwnerView);
        event.selectedItemId = mNewsItem.id;

        ((MainActivity)activity)
                .updateNotifier
                .fireAction(mOwnerView, event);
    }
}
