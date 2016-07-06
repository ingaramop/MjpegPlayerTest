package com.example.root.mjpegplayertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.niqdev.mjpeg.DisplayMode;
import com.github.niqdev.mjpeg.Mjpeg;
import com.github.niqdev.mjpeg.MjpegView;

public class MainActivity extends AppCompatActivity {

    int TIMEOUT = 5; //seconds
    //@BindView(R.id.mjpegViewDefault)
    MjpegView mjpegView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Mjpeg.newInstance()
                //.credential("USERNAME", "PASSWORD")
                .open("http://192.168.0.8/videostream.cgi?user=admin&pwd=&resolution=32&rate=2", TIMEOUT)
                .subscribe(inputStream -> {
                    mjpegView.setSource(inputStream);
                    mjpegView.setDisplayMode(DisplayMode.BEST_FIT);
                    mjpegView.showFps(true);
                });
    }
}
