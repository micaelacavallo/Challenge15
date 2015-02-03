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

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlleyFragment extends Fragment {

    Button mButtonLeft, mButtonRight, mButtonContinue;
    RoomFragment mRoomFragment;
    LooseFragment mLooseFragment;
    WinFragment mWinFragment;
    public static String DIFFICULTY_LEVELS = "difficulty_levels";

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

    public String difficultyLevel ()
    {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String level = sharedPreferences.getString(DIFFICULTY_LEVELS, "");
        return level;
    }

    private class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String level = difficultyLevel();
            float intNumber = new Random().nextInt(50);
            switch (level){
                case "Easy":
                    if (intNumber < 21) {
                        insertWinFragment();
                    } else {
                        if (intNumber > 39) {
                            insertLooseFragment();
                        } else {
                            insertRoomFragment();
                        }
                    }
                    break;
                case "Medium":
                    if (intNumber < 16) {
                        insertWinFragment();
                    } else {
                        if (intNumber > 34) {
                            insertLooseFragment();
                        } else {
                            insertRoomFragment();
                        }
                    }
                    break;
                case "Hard":
                    if (intNumber < 11) {
                        insertWinFragment();
                    } else {
                        if (intNumber > 29) {
                            insertLooseFragment();
                        } else {
                            insertRoomFragment();
                        }
                    }
                    break;
            }
        }
    }

    private void insertRoomFragment() {
        mRoomFragment = new RoomFragment();
        getFragmentManager().beginTransaction().
                replace(R.id.container, mRoomFragment).
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
