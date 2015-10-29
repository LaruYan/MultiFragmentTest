package kr.laruyan.multifragmenttest;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PreviewFragment extends Fragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    SharedPreferences preferences;
    TextView tv;

    public PreviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_preview, container, false);
        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        tv = (TextView) rootView.findViewById(R.id.text);

        refreshPreview();

        return rootView;
    }

    private void refreshPreview(){
        int fColorSwitch = Integer.parseInt(preferences.getString("foreground_color", "0"));
        int fColorText;
        switch(fColorSwitch){
            default:
            case 0:
                fColorText = 0xFF000000;
                break;
            case 1:
                fColorText = 0xFFff0000;
                break;
            case 2:
                fColorText = 0xFF00ff00;
                break;
            case 3:
                fColorText = 0xFF0000ff;
                break;
        }
        int bColorSwitch = Integer.parseInt(preferences.getString("background_color", "0"));
        int bColorText;
        switch(bColorSwitch){
            default:
            case 0:
                bColorText = 0xFFffffff;
                break;
            case 1:
                bColorText = 0xFFffff00;
                break;
            case 2:
                bColorText = 0xFF00ffff;
                break;
            case 3:
                bColorText = 0xFFff00ff;
                break;
        }

        tv.setTextColor(fColorText);
        tv.setBackgroundColor(bColorText);
    }

    @Override
    public void onResume() {
        super.onResume();
        preferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        preferences.registerOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        refreshPreview();
    }
}
