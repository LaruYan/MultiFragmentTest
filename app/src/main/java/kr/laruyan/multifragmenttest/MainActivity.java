package kr.laruyan.multifragmenttest;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    PreviewFragment pv;
    AprefFragment apf;
    BprefFragment bpf;
    Button btnA;
    Button btnB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA = (Button) findViewById(R.id.buttonA);
        btnB = (Button) findViewById(R.id.buttonB);

        pv = new PreviewFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.preview, pv);
        ft.commit();

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (apf == null) {
                    apf = new AprefFragment();
                }
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.setting, apf);
                ft.commit();
                btnA.setEnabled(false);
                btnB.setEnabled(true);
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bpf == null){
                    bpf = new BprefFragment();
                }
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.setting, bpf);
                ft.commit();
                btnA.setEnabled(true);
                btnB.setEnabled(false);
            }
        });

    }

}
