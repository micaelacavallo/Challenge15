package com.example.micaelacavallo.chooseyourownadventure;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class RoomFragment extends Fragment {

    Button mButtonDoor1, mButtonDoor2;
    AlleyFragment mAlleyFragment;
    LooseFragment mLooseFragment;
    WinFragment mWinFragment;

    public RoomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareButtons();

    }

    private void prepareButtons() {
        ButtonListener listener = new ButtonListener();
        mButtonDoor1 = (Button)getView().findViewById(R.id.button_door_1);
        mButtonDoor2 = (Button)getView().findViewById(R.id.button_door_2);
        mButtonDoor1.setOnClickListener(listener);
        mButtonDoor2.setOnClickListener(listener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_room, container, false);
    }

    private class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            float floatNumber = new Random().nextFloat();
            if (floatNumber < 0.2) {
                insertWinFragment();
            } else {
                if (floatNumber > 0.8) {
                    insertLooseFragment();
                } else {
                    insertAlleyFragment();
                }
            }
        }
    }

    private void insertAlleyFragment() {
        mAlleyFragment = new AlleyFragment();
        getFragmentManager().beginTransaction().
                replace(R.id.container, mAlleyFragment).
                addToBackStack(null).
                commit();
    }

    private void insertLooseFragment() {
        mLooseFragment = new LooseFragment();
        getFragmentManager().beginTransaction().
                replace(R.id.container, mLooseFragment).
                addToBackStack(null).
                commit();
    }

    private void insertWinFragment() {
        mWinFragment = new WinFragment();
        getFragmentManager().beginTransaction().
                replace(R.id.container, mWinFragment).
                addToBackStack(null).
                commit();
    }




}
