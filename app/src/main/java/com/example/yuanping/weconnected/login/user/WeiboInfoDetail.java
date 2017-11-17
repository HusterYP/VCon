package com.example.yuanping.weconnected.login.user;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuanping.weconnected.R;
import com.example.yuanping.weconnected.login.Contents;
import com.example.yuanping.weconnected.login.adapter.WeiboInfoCommentAndSendAdapter;
import com.example.yuanping.weconnected.login.bean.RepostBeanWeiboInfo;
import com.example.yuanping.weconnected.login.bean.WeiboInfoBean;
import com.example.yuanping.weconnected.login.utils.JsonParse;
import com.google.gson.internal.LinkedTreeMap;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeiboInfoDetail extends AppCompatActivity {

    private String mid; //微博mid
    private int commentCount; //评论数量
    private int sendCount;  //转发数量
    private int flag;  //标志是转发的还是原创的，定义布局文件;0是原创微博，1是转发微博
    private CardView tempFourWeiboInfo;
    private ImageView userImageWeiboInfo;
    private TextView userNameWeiboInfo;
    private TextView timeWeiboInfo;
    private View tempWeiboInfo;
    private TextView contentWeiboInfo;
    private NineGridView nineGridWeiboInfo;
    private RelativeLayout retweetedWeiboInfo;
    private TextView originContentWeiboInfo;
    private NineGridView nineGridOriginWeiboInfo;
    private View tempTwoWeiboInfo;
    private TextView sendCountWeiboInfo;
    private TextView tempThreeWeiboInfo;
    private TextView commentCountWeiboInfo;
    private RecyclerView recyclerWeiboInfo;
    //评论
    private String commentUrl = null;
    private String repostUrl = null;
    private WeiboInfoBean weiboInfoDetailBean;
    private RepostBeanWeiboInfo repostBeanWeiboInfo;
    //评论列表
    private List<WeiboInfoBean.CommentsBean> commentsBeen;
    //转发列表
    public List<RepostBeanWeiboInfo.RepostsBean> repostsBeen;
    //获取信息标志位
    private final int isCommentsList = 0; //0表示获取到的是评论列表

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String json = (String) msg.obj;
            onTextViewListener();
            switch (msg.what) {
                case isCommentsList:
                    weiboInfoDetailBean = JsonParse.parseWeiboInfo(json);
                    commentsBeen = weiboInfoDetailBean.getComments();
                    //设置基本信息
                    setInfo(weiboInfoDetailBean);
                    //刚开始就默认显示评论列表
                    if (null != commentsBeen) {
                        commentCountWeiboInfo.setTextColor(Color.parseColor("#E5A12A"));
                        sendCountWeiboInfo.setTextColor(Color.GRAY);
                        WeiboInfoCommentAndSendAdapter adapter = new WeiboInfoCommentAndSendAdapter
                                (commentsBeen, null, WeiboInfoDetail.this, 0,mid);
                        recyclerWeiboInfo.setAdapter(adapter);
                    }
                    break;
                default:
                    repostBeanWeiboInfo = JsonParse.parseRepost(json);
                    if (null != repostBeanWeiboInfo) {
                        repostsBeen = repostBeanWeiboInfo.getReposts();
                    }
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weibo_info_detail);
        init();
        getCommentsList(commentUrl, isCommentsList);
        getRepostList();
    }

    private void init() {
        tempFourWeiboInfo = (CardView) findViewById(R.id.temp_four_weibo_info);
        userImageWeiboInfo = (ImageView) findViewById(R.id.user_image_weibo_info);
        userNameWeiboInfo = (TextView) findViewById(R.id.user_name_weibo_info);
        timeWeiboInfo = (TextView) findViewById(R.id.time_weibo_info);
        tempWeiboInfo = (View) findViewById(R.id.temp_weibo_info);
        contentWeiboInfo = (TextView) findViewById(R.id.content_weibo_info);
        nineGridWeiboInfo = (NineGridView) findViewById(R.id.nineGrid_weibo_info);
        retweetedWeiboInfo = (RelativeLayout) findViewById(R.id.relative_retweeted_weibo_info);
        originContentWeiboInfo = (TextView) findViewById(R.id.origin_content_weibo_info);
        nineGridOriginWeiboInfo = (NineGridView) findViewById(R.id.nineGrid_origin_weibo_info);
        tempTwoWeiboInfo = (View) findViewById(R.id.temp_two_weibo_info);
        sendCountWeiboInfo = (TextView) findViewById(R.id.send_count_weibo_info);
        tempThreeWeiboInfo = (TextView) findViewById(R.id.temp_three_weibo_info);
        commentCountWeiboInfo = (TextView) findViewById(R.id.comment_count_weibo_info);
        recyclerWeiboInfo = (RecyclerView) findViewById(R.id.recycler_weibo_info);
        weiboInfoDetailBean = null;

        Intent intent = getIntent();
        mid = intent.getStringExtra("mid");
        commentCount = intent.getIntExtra("comment", 0);
        sendCount = intent.getIntExtra("send", 0);
        flag = intent.getIntExtra("flag", 0);

        //如果是原创
        if (0 == flag) {
            nineGridWeiboInfo.setVisibility(View.VISIBLE);
            nineGridOriginWeiboInfo.setVisibility(View.GONE);
        } else {
            nineGridWeiboInfo.setVisibility(View.GONE);
            nineGridOriginWeiboInfo.setVisibility(View.VISIBLE);
        }
        sendCountWeiboInfo.setText(sendCount + " 转发");
        commentCountWeiboInfo.setText(commentCount + " 评论");
        //默认先加载评论列表
        commentUrl = Contents.comments_list + "id=" + mid + "&count=" +
                Contents.COMMENTS_COUNT + "&access_token=" + Contents.userAccessToken;
        repostUrl = Contents.repost_list + "id=" + mid + "&count=" +
                Contents.COMMENTS_COUNT + "&access_token=" + Contents.userAccessToken;
    }

    //获取用户的评论列表
    public void getCommentsList(String commentsListUrl, final int flag) {
        if (null == commentUrl) {
            return;
        }
        Request request = new Request.Builder().url(commentsListUrl).build();
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
                msg.what = flag;
                handler.sendMessage(msg);
            }
        };
        call.enqueue(callback);
    }

    //获取转发列表
    public void getRepostList() {
        getCommentsList(repostUrl, 1);
    }

    //基本信息设置
    public void setInfo(WeiboInfoBean info) {
        if (null != info) {
            if (info.getStatus() != null && info.getStatus().getUser() != null) {
                Glide.with(this)
                        .load(info.getStatus().getUser().getProfile_image_url())
                        .placeholder(R.drawable.user)//图片加载出来前，显示的图片
                        .error(R.drawable.user)//图片加载失败后，显示的图片
                        .into(userImageWeiboInfo);
            }
            userNameWeiboInfo.setText(info.getStatus().getUser().getName());
            timeWeiboInfo.setText(info.getStatus().getCreated_at());
            contentWeiboInfo.setText(info.getStatus().getText());

            List<String> imageUrl = null;
            //NineGridView加载图片
            ArrayList<ImageInfo> imageInfos = new ArrayList<>();

            if (0 == flag) {
                List<LinkedTreeMap> temp = (List<LinkedTreeMap>) info.getStatus().getPic_urls();
                if (null != temp) {
                    imageUrl = new ArrayList<>();
                    for (int i = 0; i < temp.size(); i++) {
                        imageUrl.add(temp.get(i).get("thumbnail_pic").toString());
                    }
                    if (imageUrl != null) {
                        for (String imageDetail : imageUrl) {
                            ImageInfo temp_info = new ImageInfo();
                            temp_info.setThumbnailUrl(imageDetail);
                            temp_info.setBigImageUrl(imageDetail);
                            imageInfos.add(temp_info);
                        }
                    }
                }
                nineGridWeiboInfo.setVisibility(View.VISIBLE);
                retweetedWeiboInfo.setVisibility(View.GONE);
                nineGridWeiboInfo.setAdapter(new NineGridViewClickAdapter(this, imageInfos));
            } else if (1 == flag) {
                List<WeiboInfoBean.StatusBean.RetweetedStatusBean.PicUrlsBean> temp = info.getStatus().getRetweeted_status().getPic_urls();
                //大哥，又没有new咯....
                imageUrl = new ArrayList<>();
                if (null != temp) {
                    for (int i = 0; i < temp.size(); i++) {
                        imageUrl.add(temp.get(i).getThumbnail_pic());
                    }
                    if (imageUrl != null) {
                        for (String imageDetail : imageUrl) {
                            ImageInfo temp_info = new ImageInfo();
                            temp_info.setThumbnailUrl(imageDetail);
                            temp_info.setBigImageUrl(imageDetail);
                            imageInfos.add(temp_info);
                        }
                    }
                }
                nineGridWeiboInfo.setVisibility(View.GONE);
                retweetedWeiboInfo.setVisibility(View.VISIBLE);
                originContentWeiboInfo.setText(info.getStatus().getRetweeted_status().getText());
                nineGridOriginWeiboInfo.setAdapter(new NineGridViewClickAdapter(this, imageInfos));
            }
            imageUrl = null;
            imageInfos = null;
        }
    }

    //设置评论和转发列表的点击事件
    public void onTextViewListener() {

        recyclerWeiboInfo.setLayoutManager(new LinearLayoutManager(this));
        sendCountWeiboInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCountWeiboInfo.setTextColor(Color.parseColor("#E5A12A"));
                commentCountWeiboInfo.setTextColor(Color.GRAY);
                WeiboInfoCommentAndSendAdapter adapter = new WeiboInfoCommentAndSendAdapter
                        (null, repostsBeen, WeiboInfoDetail.this, 1,mid);
                recyclerWeiboInfo.setAdapter(adapter);
            }
        });
        commentCountWeiboInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != commentsBeen) {
                    commentCountWeiboInfo.setTextColor(Color.parseColor("#E5A12A"));
                    sendCountWeiboInfo.setTextColor(Color.GRAY);
                    WeiboInfoCommentAndSendAdapter adapter = new WeiboInfoCommentAndSendAdapter
                            (commentsBeen, null, WeiboInfoDetail.this, 0,mid);
                    recyclerWeiboInfo.setAdapter(adapter);
                }
            }
        });
    }

}
