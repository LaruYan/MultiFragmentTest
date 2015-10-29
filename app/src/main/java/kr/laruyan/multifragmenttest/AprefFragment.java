package kr.laruyan.multifragmenttest;


import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AprefFragment extends PreferenceFragment {


    public AprefFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_a);
    }

}
