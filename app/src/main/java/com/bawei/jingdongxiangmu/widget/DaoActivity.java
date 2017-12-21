package com.bawei.jingdongxiangmu.widget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import com.bawei.jingdongxiangmu.MainActivity;
import com.bawei.jingdongxiangmu.R;

import java.util.Timer;
import java.util.TimerTask;

public class DaoActivity extends AppCompatActivity {
    private RelativeLayout ye;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dao);
        ye =(RelativeLayout)findViewById(R.id.ye);
        View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as a general rule, you should design your app to hide the status bar whenever you hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(DaoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        },3000);
    }
}
