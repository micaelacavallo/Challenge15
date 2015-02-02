package com.example.micaelacavallo.chooseyourownadventure;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by micaela.cavallo on 02/02/2015.
 */
public class AppSettingsActivity extends Activity {
    public static class AppSettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getFragmentManager().beginTransaction().replace(R.id.settings, new AppSettingsFragment()).commit();

    }
}
