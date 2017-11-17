package com.example.yuanping.weconnected.login.test;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.yuanping.weconnected.R;
import com.example.yuanping.weconnected.login.Contents;
import com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.UsersAPI;
import com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.FriendshipsAPI;
import com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.models.User;
import com.google.gson.Gson;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.e;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.f;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.l;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.s;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.u;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.w;

public class Test_one extends AppCompatActivity implements View.OnClickListener {

    private Button userInfo;
    private Oauth2AccessToken mAccessToken;
    private Button friendsId;
    private RequestListener requestListener = new RequestListener() {
        @Override
        public void onComplete(String s) {
            if (!TextUtils.isEmpty(s)) {
                Log.d("@HusterYP", String.valueOf(s));
                User user = User.parse(s);
                if (null != user) {
                    Log.d("@HusterYP", String.valueOf("User Info..." + user.profile_image_url));
                    Log.d("@HusterYP", String.valueOf(user.avatar_large));
                }
            }
        }

        @Override
        public void onWeiboException(WeiboException e) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_one);
        initView();
    }

    private void initView() {
        userInfo = (Button) findViewById(R.id.user_info_test);
        userInfo.setOnClickListener(this);
        mAccessToken = AccessTokenKeeper.readAccessToken(this);
        friendsId = (Button) findViewById(R.id.friends_id_test);
        friendsId.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_info_test:
                getUserInfo();
                break;
            case R.id.friends_id_test:
                getFriendsId();
                break;
        }
    }

    public void getUserInfo() {
        UsersAPI usersAPI = new UsersAPI(Test_one.this, Contents.APP_KEY, mAccessToken);
        long uid = Long.parseLong(Contents.userUid);
        usersAPI.show(uid, requestListener);
    }

    public void getFriendsId(){
        Gson gson = new Gson();
        FriendsListBean_Test bean = null;
        new Thread(){
            @Override
            public void run() {
                super.run();
                String temp = Contents.friendsUrl_list+"uid="+Contents.userUid+"&cursor="+50+
                        "&count="+50+"&access_token="+Contents.userAccessToken;
                Log.d("@HusterYP", String.valueOf(mAccessToken));
                Log.d("@HusterYP", String.valueOf(temp));
                try {
                    URL url = new URL(temp);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder builder  = new StringBuilder();
                    String line;
                    while((line=reader.readLine())!=null){
                        builder.append(line);
                    }
                    Log.d("@HusterYP", String.valueOf(builder.toString()));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }.start();
    }

/*    public void getFriendsId() {
        RequestListener requestListener = new RequestListener() {
            @Override
            public void onComplete(String s) {
                if (null != s) {
                    Log.d("@HusterYP", String.valueOf(s));
                } else {
                    Log.d("@HusterYP", String.valueOf("info is null"));
                }
            }

            @Override
            public void onWeiboException(WeiboException e) {
                if(null!=e){
                    e.printStackTrace();
                }
            }
        };

        FriendshipsAPI friendshipsAPI = new FriendshipsAPI(this, Contents.APP_KEY, mAccessToken);
        //这个是只是返回用户关注的UID
        friendshipsAPI.friendsIds(Long.parseLong(Contents.userUid), 25, 0, requestListener);
        //这个是还可以返回用户的关注人的详细信息
//        friendshipsAPI.friends();
//        friendshipsAPI.friends(mAccessToken.getUid(), 50, 0, true, );

    }*/
}
