package com.example.yuanping.weconnected.login.user;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuanping.weconnected.R;
import com.example.yuanping.weconnected.login.Contents;
import com.example.yuanping.weconnected.login.adapter.FriendsListAdapter;
import com.example.yuanping.weconnected.login.bean.FriendsList;
import com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.UsersAPI;
import com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.models.User;
import com.example.yuanping.weconnected.login.test.Test_one;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.R.attr.targetId;
import static com.example.yuanping.weconnected.R.drawable.user;
import static com.example.yuanping.weconnected.login.Contents.COUNT;
import static com.example.yuanping.weconnected.login.Contents.GET_FOLLOWERS_LIST;
import static com.example.yuanping.weconnected.login.Contents.GET_FRIENDS_LIST;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.i;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.s;
import static com.example.yuanping.weconnected.login.utils.JsonParse.parseUserInfo;
import static junit.runner.Version.id;

public class UserInfo extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private CollapsingToolbarLayout imageToolbar;
    private TextView userDescriptionUserInfo;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private RecyclerView recyclerActivityFour;
    private Oauth2AccessToken mAccessToken;
    private ImageView userImage;
    private Bitmap userBitmap;
    private SwipeRefreshLayout refreshLayout;
    private User user;


    //获取用户信息回调
    private RequestListener requestListener = new RequestListener() {
        @Override
        public void onComplete(String s) {
            if (!TextUtils.isEmpty(s)) {
                user = User.parse(s);
                if (null != user) {
                    userDescriptionUserInfo.setText(user.description);
                    (tabLayout.getTabAt(0)).setText(user.friends_count + "关注");
                    (tabLayout.getTabAt(1)).setText(user.followers_count + "粉丝");
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            try {
                                URL url = new URL(user.profile_image_url);
                                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                                InputStream in = connection.getInputStream();
                                userBitmap = BitmapFactory.decodeStream(in);
                                Message msg = new Message();
                                msg.what = 0;
                                handler.sendMessage(msg);
                            } catch (java.io.IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
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
        setContentView(R.layout.activity_user_info);
        init();
    }

    //刷新UI
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (null != userBitmap) {
                        userImage.setImageBitmap(userBitmap);
                    }
                    break;
                case GET_FRIENDS_LIST:
                    String info = (String) msg.obj;
                    FriendsList friendsList = parseUserInfo(info);
                    if (null != friendsList) {
                        setRecycler(friendsList);
                    }
                    break;
                case GET_FOLLOWERS_LIST:
                    String temp = (String) msg.obj;
                    FriendsList followersList = parseUserInfo(temp);
                    setRecycler(followersList);
                    break;
            }

        }
    };

    private void init() {
        imageToolbar = (CollapsingToolbarLayout) findViewById(R.id.image_toolbar);
        userDescriptionUserInfo = (TextView) findViewById(R.id.user_description_user_info);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        recyclerActivityFour = (RecyclerView) findViewById(R.id.recycler_activity_four);
        mAccessToken = AccessTokenKeeper.readAccessToken(this);
        userBitmap = null;
        userImage = (ImageView) findViewById(R.id.user_image_user_info);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh_user_info);

        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light,
                android.R.color.holo_orange_light, android.R.color.holo_green_light);
        refreshLayout.setOnRefreshListener(this);

        recyclerActivityFour.setLayoutManager(new LinearLayoutManager(this));

        onUserImageListener();
        getUserInfo();
        getFriendsList(GET_FRIENDS_LIST, 0);
        tabLayoutListener();
    }

    //设置用户头像和描述文字的点击事件
    private void onUserImageListener() {
        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfo.this, WeiBoDetail.class);
                if (null != user) {
                    intent.putExtra("user", user);
                }
                startActivity(intent);
            }
        });
        userDescriptionUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfo.this, WeiBoDetail.class);
                if (null != user) {
                    intent.putExtra("user", user);
                }
                startActivity(intent);
            }
        });
    }

    //获取用户信息
    public void getUserInfo() {
        UsersAPI usersAPI = new UsersAPI(UserInfo.this, Contents.APP_KEY, mAccessToken);
        long uid = Long.parseLong(Contents.userUid);
        usersAPI.show(uid, requestListener);
    }

    //获取用户的关注列表
    public void getFriendsList(final int flag, int cursor) {
        final String friendsList = Contents.friendsUrl_list + "uid=" + mAccessToken.getUid() + "&cursor=" +
                cursor + "&count=" + COUNT + "&access_token=" + Contents.userAccessToken;
        final String followersList = Contents.followersUrl_list + "uid=" + mAccessToken.getUid() + "&cursor=" +
                cursor + "&count=" + COUNT + "&access_token=" + Contents.userAccessToken;
        Request request = null;
        if (GET_FRIENDS_LIST == flag) {
            request = new Request.Builder().url(friendsList).build();
        } else if (GET_FOLLOWERS_LIST == flag) {
            request = new Request.Builder().url(followersList).build();
        } else {
            return;
        }
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Callback callback = new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message msg = new Message();
                //注意咯，不是toString 哈，而是string
                msg.obj = response.body().string();
                msg.what = flag;
                handler.sendMessage(msg);
            }
        };
        call.enqueue(callback);
    }


    //设置RecyclerView和RecyclerView的点击事件
    public void setRecycler(FriendsList friendsList) {
        FriendsListAdapter adapter = new FriendsListAdapter(friendsList, this, true, GET_FRIENDS_LIST);
        recyclerActivityFour.setAdapter(adapter);
        adapter.setOnItemClickListener(new FriendsListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, String name) {
//                Intent intent = new Intent(UserInfo.this,RelationShip.class);
                Intent intent = new Intent(UserInfo.this,RelationShipImprove.class);
                intent.putExtra("targetId",name);
                intent.putExtra("userImageUrl",user.profile_image_url);
                intent.putExtra("userDescription",user.description);
                startActivity(intent);
            }
        });
    }

    //刷新事件
    @Override
    public void onRefresh() {
        refreshLayout.setRefreshing(true);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
                Toast.makeText(UserInfo.this, String.valueOf("刷新成功！"), Toast.LENGTH_SHORT).show();
            }
        }, 1000);
    }

    //顶部导航栏的点击事件
    public void tabLayoutListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (0 == tab.getPosition()) {
                    getFriendsList(GET_FRIENDS_LIST, 0);
                } else {
                    getFriendsList(GET_FOLLOWERS_LIST, 0);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
