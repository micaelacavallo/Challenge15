package com.example.micaelacavallo.chooseyourownadventure;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class RoomFragment extends Fragment {

    Button mButtonDoor1, mButtonDoor2;
    public RoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.room_fragment, container, false);
    }

    private class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            float floatNumber = new Random().nextFloat();
            String message;
            Intent intent = new Intent(getActivity(), FinalActivity.class);
            if (floatNumber < 0.2) {
                message = "You've reached the gold!";
                intent.putExtra(Intent.EXTRA_TEXT, message);
            } else {
                if (floatNumber > 0.7) {
                    message = "You've falled into the fit of despair";
                    intent.putExtra(Intent.EXTRA_TEXT, message);
                } else {
                        intent = new Intent(getActivity(), AlleyActivity.class);
                    }
                }
            startActivity(intent);
        }
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
}
