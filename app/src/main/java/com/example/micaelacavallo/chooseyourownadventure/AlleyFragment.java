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
public class AlleyFragment extends Fragment {

    Button mButtonLeft, mButtonRight, mButtonContinue;
    RoomFragment mRoomFragment;
    LooseFragment mLooseFragment;
    WinFragment mWinFragment;

    public AlleyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alley, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareButtons();
    }

    private void prepareButtons() {
        ButtonListener listener = new ButtonListener();
        mButtonContinue = (Button)getView().findViewById(R.id.button_continue);
        mButtonLeft  = (Button)getView().findViewById(R.id.button_go_left);
        mButtonRight = (Button)getView().findViewById(R.id.button_go_right);
        mButtonContinue.setOnClickListener(listener);
        mButtonRight.setOnClickListener(listener);
        mButtonLeft.setOnClickListener(listener);
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
                    insertRoomFragment();
                }
            }
        }
    }

    private void insertRoomFragment() {
        mRoomFragment = new RoomFragment();
        getFragmentManager().beginTransaction().
                replace(R.id.container, mRoomFragment).
                commit();
    }

    private void insertLooseFragment() {
        mLooseFragment = new LooseFragment();
        getFragmentManager().beginTransaction().
                replace(R.id.container, mLooseFragment).
                commit();
    }

    private void insertWinFragment() {
        mWinFragment = new WinFragment();
        getFragmentManager().beginTransaction().
                replace(R.id.container, mWinFragment).
                commit();
    }

}
