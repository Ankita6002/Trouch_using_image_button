package com.example.ankita.trouchimageseventeen;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton ib;
    CameraManager cm;
    private boolean cmr = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib = (ImageButton)findViewById(R.id.imageButton);
        cm = (CameraManager)getSystemService(CAMERA_SERVICE);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (cmr == false) {
                        String s1 = cm.getCameraIdList()[0];
                        cm.setTorchMode(s1, true);
                        ib.setImageResource(R.drawable.o);
                    }
                    else {
                        String s2  = cm.getCameraIdList()[0];
                        cm.setTorchMode(s2, false);
                        ib.setImageResource(R.drawable.f);
                    }
                } catch (CameraAccessException e) {
                }
            }
        });
    }
}
