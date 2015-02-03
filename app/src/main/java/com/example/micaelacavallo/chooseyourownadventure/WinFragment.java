package com.example.micaelacavallo.chooseyourownadventure;

import android.app.FragmentManager;
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


public class WinFragment extends Fragment {

    Button mButton;
    StartFragment mStartFragment;
    TextView mTextViewMessage;
    public final static String USERNAME_PREFERENCE = "username_preference";

    public WinFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_win, container, false);
        displayUserInfo(rootView);
        return rootView;
    }

    private void displayUserInfo(View rootView) {
        mTextViewMessage = (TextView)rootView.findViewById(R.id.text_view_winner);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String username = sharedPreferences.getString(USERNAME_PREFERENCE, getString(R.string.default_username));
        String userInfo = String.format(getString(R.string.user_info), username);
        mTextViewMessage.setText(userInfo);
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
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentManager.beginTransaction().
                replace(R.id.container, mStartFragment).
                commit();
    }
}
