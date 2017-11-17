package com.example.yuanping.weconnected.login.user;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.yuanping.weconnected.R;
import com.example.yuanping.weconnected.login.Contents;
import com.example.yuanping.weconnected.login.adapter.FriendsListAdapter;
import com.example.yuanping.weconnected.login.adapter.RelationAdapter;
import com.example.yuanping.weconnected.login.bean.FriendsList;
import com.example.yuanping.weconnected.login.bean.RelationShipBean;
import com.example.yuanping.weconnected.login.bean.RelationShipTempBean;
import com.example.yuanping.weconnected.login.bean.TargetUserBean;
import com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.UsersAPI;
import com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.models.User;
import com.example.yuanping.weconnected.login.utils.JsonParse;
import com.google.gson.Gson;
import com.itheima.roundedimageview.RoundedImageView;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.R.attr.bitmap;
import static android.R.attr.data;
import static android.R.attr.logo;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.AccountAPI.CAPITAL.I;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.e;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.i;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.l;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.n;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.s;

public class RelationShip extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private Toolbar toolBar;
    private NavigationView navView;
    private ImageView navUserImage;  //左侧菜单栏项目
    private TextView navUserDescription;
    private RoundedImageView userImage;
    private RoundedImageView targetImage;
    private Button isEachFollowerButton;
    private RecyclerView recyclerView;

    private String targetId;  //目标UID
    private String relationUrl = null; //获取关系
    private String targetUrl = null;
    private Oauth2AccessToken mAccessToken;
    private RelationShipBean relationShipBean;
    private final int getRelationShip = 0;//获取数据标志位
    private final int getTargetInfo = 1;
    private final int getUserBitmap = 2;
    private final int getTargetBitmap = 3;
    private final int getRecycler = 4;
    private TargetUserBean targetUserBean;
    private boolean flag = false;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case getRelationShip: {
                    String json1 = (String) msg.obj;
                    if (null != json1) {
                        relationShipBean = JsonParse.parseRelationShip(json1);
                        if ((int) (Math.random() * 10) < 7) {
                            isEachFollowerButton.setText("未相互关注");
                            isEachFollowerButton.setBackgroundColor(Color.parseColor("#DFE561"));
                        } else {
                            isEachFollowerButton.setText("已相互关注");
                            isEachFollowerButton.setBackgroundColor(Color.parseColor("#E0E0E0"));
                        }
                    }
                }
                break;
                case getTargetInfo: {
                    String json2 = (String) msg.obj;
                    if (null != json2) {
                        targetUserBean = JsonParse.parseTargetUserBean(json2);

                        new Thread() {
                            @Override
                            public void run() {
                                try {
                                    URL url = new URL(targetUserBean.getProfile_image_url());
                                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                                    InputStream in = connection.getInputStream();
                                    Bitmap bitmap1 = BitmapFactory.decodeStream(in);
                                    Message msg = new Message();
                                    msg.obj = bitmap1;
                                    msg.what = getTargetBitmap;
                                    handler.sendMessage(msg);
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }.start();
                    }
                }
                break;
                case getUserBitmap: {
                    Bitmap bitmap = (Bitmap) msg.obj;
                    userImage.setImageBitmap(bitmap);
                    navUserImage.setImageBitmap(bitmap);
                }
                break;
                case getTargetBitmap: {
                    Bitmap bitmap = (Bitmap) msg.obj;
                    if (null != bitmap) {
                        targetImage.setImageBitmap(bitmap);
                    }
                }
                break;
                case getRecycler:{
                    String json = (String) msg.obj;
                    Gson gson = new Gson();
                    RelationShipTempBean relationShipTempBean = gson.fromJson(json,RelationShipTempBean.class);
                    RelationAdapter adapter = new RelationAdapter(relationShipTempBean,RelationShip.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(RelationShip.this));
                    recyclerView.setAdapter(adapter);
                }
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relation_ship);
        init();
//        test();
    }

//    private void test(){
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        List<String> data = new ArrayList<>();
//        for(int i=0;i<100;i++){
//            data.add("String..."+i);
//        }
//        RelationAdapter adapter = new RelationAdapter(data,this);
//        recyclerView.setAdapter(adapter);
//    }


    private void init() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        navView = (NavigationView) findViewById(R.id.nav_view);
//        navUserImage = (ImageView) findViewById(R.id.nav_user_image);
//        navUserDescription = (TextView) findViewById(R.id.nav_user_description);
        userImage = (RoundedImageView) findViewById(R.id.user_image_relationship);
        targetImage = (RoundedImageView) findViewById(R.id.target_image_relationship);
        isEachFollowerButton = (Button) findViewById(R.id.each_follower_button_relationship);

        View headerView = navView.getHeaderView(0);
        navUserImage = headerView.findViewById(R.id.nav_user_image);
        navUserDescription = headerView.findViewById(R.id.nav_user_description);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_relationship);

        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RelationShip.this, WeiBoDetail.class);
                startActivity(intent);
            }
        });

        targetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RelationShip.this, WeiBoDetail.class);
                startActivity(intent);
            }
        });

        navUserImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RelationShip.this, WeiBoDetail.class);
                startActivity(intent);
            }
        });

        getIntentData();


        mAccessToken = AccessTokenKeeper.readAccessToken(this);
        relationUrl = Contents.each_relationship + "source_id=" + mAccessToken.getUid()
                + "&screen_name=" + targetId + "&access_token=" + Contents.userAccessToken;
        targetUrl = Contents.userUrl + "screen_name=" + targetId + "&access_token=" + Contents.userAccessToken;

        setSupportActionBar(toolBar);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu_bar);
        }
        navMenuOnClickListener();
        getRelationShip(relationUrl);
        getTargetInfo(targetUrl);

        setRecyclerView(0);
    }

    //设置RecyclerView
    //flag=0 表示互粉；flag=1 表示同城
    public void setRecyclerView(int flag) {
        String temp_url = null;
        if (flag == 0) {
            temp_url = Contents.followersUrl_list + "uid=" + mAccessToken.getUid() +
                    "&cursor=0&count=20&access_token=2.00APvuCG06XASOe34681c9cf8pV2JD";
        }else{
            temp_url = Contents.friendsUrl_list+"uid=" + mAccessToken.getUid() +
                    "&cursor=0&count=20&access_token=2.00APvuCG06XASOe34681c9cf8pV2JD";
        }

        Request request = new Request.Builder().url(temp_url).build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message msg = new Message();
                msg.obj = response.body().string();
                msg.what = getRecycler;
                handler.sendMessage(msg);
            }
        };
        call.enqueue(callback);

    }

    //左侧菜单栏的点击事件
    private void navMenuOnClickListener() {
        navView.setCheckedItem(R.id.each_follower);//默认设置互粉选中

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.each_follower:
                        setRecyclerView(0);
                        break;
                    case R.id.same_location: {
                        setRecyclerView(1);
                    }
                    break;
                    case R.id.about:
                        break;
                    /*case R.id.search_user: {
                        Intent intent = new Intent(RelationShip.this, SearchUser.class);
                        startActivityForResult(intent, 1);
                    }
                    break;*/
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String result = data.getStringExtra("result");
        if (null != result && !result.equals("0")) {
            flag = true;
            targetId = result;
            init();
            flag = false;
        }
    }

    //获取前一个Activity传递的数据及相关设置
    private void getIntentData() {
        Intent intent = getIntent();
        if (!flag) {
            targetId = intent.getStringExtra("targetId");
        }
        final String userImageUrl = intent.getStringExtra("userImageUrl");
        String userDescription = intent.getStringExtra("userDescription");

        if (null != userDescription) {
            navUserDescription.setText(userDescription);
        }
        if (null != userImageUrl) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        URL url = new URL(userImageUrl);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        InputStream in = connection.getInputStream();
                        Bitmap bitmap = BitmapFactory.decodeStream(in);
                        Message msg = new Message();
                        msg.obj = bitmap;
                        msg.what = getUserBitmap;
                        handler.sendMessage(msg);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }.start();
            /*Glide.with(this)
                    .load(userImageUrl)
                    .placeholder(R.drawable.user)//图片加载出来前，显示的图片
                    .error(R.drawable.user)//图片加载失败后，显示的图片
                    .into(navUserImage);

            Glide.with(this)
                    .load(userImageUrl)
                    .placeholder(R.drawable.user)//图片加载出来前，显示的图片
                    .error(R.drawable.user)//图片加载失败后，显示的图片
                    .into(userImage);*/
        }
    }

    //获取两个用户的关系
    private void getRelationShip(String url) {
        if (null == url) {
            return;
        }
        Request request = new Request.Builder().url(url).build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message msg = new Message();
                msg.obj = response.body().string();
                msg.what = getRelationShip;
                handler.sendMessage(msg);
            }
        };
        call.enqueue(callback);
    }

    //获取目标的信息
    private void getTargetInfo(String url) {
        if (null == url) {
            return;
        }
        Request request = new Request.Builder().url(url).build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message msg = new Message();
                msg.obj = response.body().string();

                Log.d("@HusterYP", String.valueOf("=======" + (String) msg.obj));

                msg.what = getTargetInfo;
                handler.sendMessage(msg);
            }
        };
        call.enqueue(callback);
    }

    //设置菜单栏的点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }


}
