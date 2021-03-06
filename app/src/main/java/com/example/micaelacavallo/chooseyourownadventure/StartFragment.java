package com.example.micaelacavallo.chooseyourownadventure;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {
    Button mStartTravel;
    RoomFragment mRoomFragment;
    AlleyFragment mAlleyFragment;

    public StartFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
       public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareStartButton();

    }

    private void prepareStartButton() {
        mStartTravel = (Button)getView().findViewById(R.id.button_start_traveling);
        mStartTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomRoom = new Random();
                int randomNumber = randomRoom.nextInt(2);
                if (randomNumber == 1) {
                    insertRoomFragment();
                }
                else
                {
                    insertAlleyFragment();
                }
            }
        });
    }

    private void insertAlleyFragment() {
        mAlleyFragment = new AlleyFragment();
        getFragmentManager().beginTransaction().
                replace(R.id.container, mAlleyFragment).
                addToBackStack(null).
                commit();

    }

    private void insertRoomFragment() {
        mRoomFragment = new RoomFragment();
        getFragmentManager().beginTransaction().
                replace(R.id.container, mRoomFragment).
                addToBackStack(null).
                commit();
    }




}
