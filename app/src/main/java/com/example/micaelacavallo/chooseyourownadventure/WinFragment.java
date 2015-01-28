package com.example.micaelacavallo.chooseyourownadventure;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class WinFragment extends Fragment {

    Button mButton;
    StartFragment mStartFragment;

    public WinFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_win, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        prepareButtonPlayAgain();

    }

    private void prepareButtonPlayAgain() {
        mButton = (Button)getView().findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertStartFragment();
            }
        });
    }


    private void insertStartFragment() {
        mStartFragment  = new StartFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().
                add(R.id.container, mStartFragment).
                commit();
    }
}
