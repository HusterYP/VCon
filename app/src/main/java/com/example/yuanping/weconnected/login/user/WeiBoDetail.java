package com.example.yuanping.weconnected.login.user;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.yuanping.weconnected.R;
import com.example.yuanping.weconnected.login.Contents;
import com.example.yuanping.weconnected.login.adapter.WeiboListAdapter;
import com.example.yuanping.weconnected.login.bean.WeiboDetailBean;
import com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.models.User;
import com.example.yuanping.weconnected.login.utils.JsonParse;
import com.itheima.roundedimageview.RoundedImageView;
import com.lzy.ninegrid.NineGridView;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.t;

public class WeiBoDetail extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private CollapsingToolbarLayout imageToolbarWeiboDetail;
    private RoundedImageView userImageWeiboDetail;
    private TextView friendsWeiboDetail;
    private TextView followersWeiboDetail;
    private TextView descriptionWeiboDetail;
    private TextView locationWeiboDetail;
    private SwipeRefreshLayout refreshWeiboDetail;
    private RecyclerView recyclerWeiboDetail;
    private Oauth2AccessToken mAccessToken;
    private String url = null;
    //是否是第一次进入，如果是就不显示 “刷新成功”
    private boolean isFirstIn;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Bitmap bitmap = (Bitmap) msg.obj;
                    if (null != bitmap) {
                        userImageWeiboDetail.setImageBitmap(bitmap);
                    }
                    break;
                case 1:
                    String json = (String) msg.obj;
                    setRecycler(json);
                    refreshWeiboDetail.setRefreshing(false);
                    if (!isFirstIn) {
                        Toast.makeText(WeiBoDetail.this, String.valueOf("刷新成功！"), Toast.LENGTH_SHORT).show();
                    }
                    isFirstIn = false;
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wei_bo_detail);
        init();
    }

    private void init() {
        imageToolbarWeiboDetail = (CollapsingToolbarLayout) findViewById(R.id.image_toolbar_weibo_detail);
        userImageWeiboDetail = (RoundedImageView) findViewById(R.id.user_image_weibo_detail);
        friendsWeiboDetail = (TextView) findViewById(R.id.friends_weibo_detail);
        followersWeiboDetail = (TextView) findViewById(R.id.followers_weibo_detail);
        descriptionWeiboDetail = (TextView) findViewById(R.id.description_weibo_detail);
        locationWeiboDetail = (TextView) findViewById(R.id.location_weibo_detail);
        refreshWeiboDetail = (SwipeRefreshLayout) findViewById(R.id.refresh_weibo_detail);
        recyclerWeiboDetail = (RecyclerView) findViewById(R.id.recycler_weibo_detail);
        mAccessToken = AccessTokenKeeper.readAccessToken(this);
        isFirstIn = true;

        url = Contents.homeTimeLineList + "since_id=" + Contents.HOMETIMELINE_START
                + "&count=" + Contents.HOMETIMELIE_COUNT + "&access_token=" + Contents.userAccessToken;

        refreshWeiboDetail.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light,
                android.R.color.holo_orange_light, android.R.color.holo_green_light);
        refreshWeiboDetail.setOnRefreshListener(this);



        //首先通过前一个Activity传过来的数据，设置用户基本信息
        setUserInfo();
        getWeiboList();
        //NineGrid加载图片
        NineGridView.setImageLoader(new GlideImageLoader());
    }

    private void setUserInfo() {
        Intent intent = getIntent();
        final User user = (User) intent.getSerializableExtra("user");
        if (null != user) {
            locationWeiboDetail.setText(user.location);
            friendsWeiboDetail.setText(user.friends_count + "关注");
            followersWeiboDetail.setText(user.followers_count + "粉丝");
            descriptionWeiboDetail.setText(user.description);
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    URL url = null;
                    try {
                        url = new URL(user.profile_image_url);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        InputStream in = connection.getInputStream();
                        Bitmap bitmap = BitmapFactory.decodeStream(in);
                        Message msg = new Message();
                        msg.obj = bitmap;
                        msg.what = 0;
                        handler.sendMessage(msg);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }.start();
        }
    }

    //设置微博信息列表
    public void setRecycler(String json) {
        WeiboDetailBean weiboDetailBean = JsonParse.parseWeiboList(json);
        WeiboListAdapter adapter = new WeiboListAdapter(weiboDetailBean, this);
        recyclerWeiboDetail.setLayoutManager(new LinearLayoutManager(this));
        recyclerWeiboDetail.setAdapter(adapter);
        adapter.setOnItemClickListener(new WeiboListAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, WeiboDetailBean.StatusesBean statusesBean,int flag) {
                Intent intent = new Intent(WeiBoDetail.this, WeiboInfoDetail.class);
//                intent.putExtra("love", statusesBean.getAttitudes_count());
                intent.putExtra("send", statusesBean.getReposts_count());
                intent.putExtra("comment",statusesBean.getComments_count());
                intent.putExtra("mid",statusesBean.getMid());
                intent.putExtra("flag",flag);//这个是传递到下一个Activity的标志位，标志是原创微博还是转发微博
                startActivity(intent);
            }
        });
    }

    private void getWeiboList() {
        refreshWeiboDetail.setRefreshing(true);

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
                //注意咯，不是toString 哈，而是string
                String temp = response.body().string();
                msg.obj = temp;
                msg.what = 1;
                handler.sendMessage(msg);
            }
        };
        call.enqueue(callback);
    }

    //刷新事件
    @Override
    public void onRefresh() {
        //再次获取最新数据
        getWeiboList();
    }

    //图片加载
    private class GlideImageLoader implements NineGridView.ImageLoader {
        @Override
        public void onDisplayImage(Context context, ImageView imageView, String url) {
            Glide.with(context).load(url)
                    .placeholder(R.drawable.user)
                    .error(R.drawable.user)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
        }

        @Override
        public Bitmap getCacheImage(String url) {
            return null;
        }
    }

}
