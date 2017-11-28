package org.tyaa.twofragmentsoneactivity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.tyaa.twofragmentsoneactivity.R;

/**
 * Created by yurii on 30.09.17.
 */

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {

    private String[] mArticles;
    private LinearLayout mArticlesLayout;
    private final OnItemClickListener mListener;

    public interface OnItemClickListener {

        void onItemClick(int position);
    }
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(LinearLayout v) {
            super(v);
            mTextView = v.findViewById(R.id.articleItemTextView);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ArticlesAdapter(String[] articles, OnItemClickListener listener) {
        mArticles = articles;
        mListener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ArticlesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.articles_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder((LinearLayout) v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mArticles[position]);
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mListener.onItemClick(position);
            }
        });
    }

    public void bind(final String item, ViewHolder holder, final OnItemClickListener listener) {


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mArticles.length;
    }
}
