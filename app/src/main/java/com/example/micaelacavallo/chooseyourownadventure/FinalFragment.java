package com.example.micaelacavallo.chooseyourownadventure;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FinalFragment extends Fragment {

    TextView mText;
    public FinalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.final_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mText = (TextView)getView().findViewById(R.id.textView);
       String message = getActivity().getIntent().getStringExtra(Intent.EXTRA_TEXT);
        mText.setText(message);
    }
}
