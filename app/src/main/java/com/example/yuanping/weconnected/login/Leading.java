package com.example.yuanping.weconnected.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yuanping.weconnected.R;
import com.example.yuanping.weconnected.login.test.Test_one;
import com.example.yuanping.weconnected.login.test.Test_two;
import com.example.yuanping.weconnected.login.user.RelationShip;
import com.example.yuanping.weconnected.login.user.UserInfo;

import java.util.Timer;
import java.util.TimerTask;

import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.w;

public class Leading extends AppCompatActivity {

    private Timer timer = new Timer();
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            Intent intent = new Intent(Leading.this,LogIn.class);
//            Intent intent = new Intent(Leading.this,Test_two.class);
//            Intent intent  = new Intent(Leading.this, RelationShip.class);
            startActivity(intent);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leading);
        timer.schedule(timerTask,0*1000);//2s
    }
}
