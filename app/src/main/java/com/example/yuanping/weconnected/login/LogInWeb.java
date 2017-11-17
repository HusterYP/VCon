package com.example.yuanping.weconnected.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yuanping.weconnected.R;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

public class LogInWeb extends AppCompatActivity {
    private AuthInfo mAuthInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        init();
    }
    public void init(){
        mAuthInfo = new AuthInfo(this,Contents.APP_KEY,Contents.REDIRECT_URL,Contents.SCOPE);
    }
}
