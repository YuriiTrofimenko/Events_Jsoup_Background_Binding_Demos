package org.tyaa.twofragmentsoneactivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {

    public static final String ARG_POSITION = "current_article_pos";
    private TextView mBottomLayoutTextView;

    public BottomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);
        mBottomLayoutTextView = view.findViewById(R.id.bottomLayoutTextView);
        return view;
    }

    public void updateArticleView(int position) {

        //Toast.makeText(getActivity(), "Item Clicked " + position, Toast.LENGTH_LONG).show();
        Toast.makeText(getActivity(), mBottomLayoutTextView.toString(), Toast.LENGTH_LONG).show();
        mBottomLayoutTextView.setText(String.valueOf(position));
    }
}
