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
public class AlleyFragment extends Fragment {

    Button mButtonLeft, mButtonRight, mButtonContinue;

    public AlleyFragment() {
        // Required empty public constructor
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
                if (floatNumber > 0.8) {
                    message = "You've falled into the fit of despair";
                    intent.putExtra(Intent.EXTRA_TEXT, message);
                } else {

                    intent = new Intent(getActivity(), RoomActivity.class);
                }
            }
            startActivity(intent);
            getActivity().finish();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.alley_fragment, container, false);
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

}
