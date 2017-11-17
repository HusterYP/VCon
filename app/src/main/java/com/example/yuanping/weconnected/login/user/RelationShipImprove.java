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
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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

public class RelationShipImprove extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private Toolbar toolBar;
    private NavigationView navView;
    private ImageView navUserImage;  //左侧菜单栏项目
    private TextView navUserDescription;
    private RoundedImageView userImage;
    private RoundedImageView targetImage;
    private Button isEachFollowerButton;

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
    private boolean isWhich = false;  //为false表示互粉，true表示同城
    private final int fillView = 5;
    private TargetUserBean targetUserBean;
    private boolean flag = false;
    private Bitmap userBitmap;

    //中间的旋转布局
    private RelativeLayout relativeLayoutCenter;
    private RelativeLayout relativeLayoutRight;
    private RelativeLayout relativeLayoutLeft;
    private ImageView viewUserCenter;
    private ImageView viewUserRight;
    private ImageView viewUserLeft;
    private ImageView viewTargetCenter;
    private ImageView viewTargetRight;
    private ImageView viewTargetLeft;

    private TextView commonTopicCenter;
    private TextView commonTopicRight;
    private TextView commonTopicLeft;
    private TextView commonFriendsCenter;
    private TextView commonFriendsRight;
    private TextView commonFriendsLeft;
    private TextView commonFollowerCenter;
    private TextView commonFollowerRight;
    private TextView commonFollowerLeft;
    private TextView locationCenter;
    private TextView locationRight;
    private TextView locationLeft;
    private float perX = 40; //初始偏移量
    private List<Bitmap> bitmapList;
    private List<RelationShipTempBean.UsersBean> usersBeanList;
    private List<String> locationList;


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
                            isEachFollowerButton.setBackgroundColor(Color.parseColor("#EA5455"));
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
                    userBitmap = (Bitmap) msg.obj;
                    userImage.setImageBitmap(userBitmap);
                    navUserImage.setImageBitmap(userBitmap);
                }
                break;
                case getTargetBitmap: {
                    Bitmap bitmap = (Bitmap) msg.obj;
                    if (null != bitmap) {
                        targetImage.setImageBitmap(bitmap);
                    }
                }
                break;
                case getRecycler: {
                    String json = (String) msg.obj;
                    Gson gson = new Gson();
                    RelationShipTempBean relationShipTempBean = gson.fromJson(json, RelationShipTempBean.class);
                    usersBeanList = relationShipTempBean.getUsers();
                    getViewBitmap(usersBeanList);
                }
                break;
                case fillView: {
                    setOnViewTouchListener();
                }
                break;
            }
        }
    };

    private void initFill() {
        viewUserCenter.setImageBitmap(userBitmap);
        viewTargetCenter.setImageBitmap(bitmapList.get(0));
        commonTopicCenter.setText((int) (Math.random() * 20) + "共同话题");
        commonFriendsCenter.setText(((int) (Math.random() * 10) + "共同关注"));
        commonFollowerCenter.setText((int) (Math.random() * 10) + "共同粉丝");
        locationCenter.setText(locationList.get((int) (Math.random() * 10)));

       /* viewUserLeft.setImageBitmap(userBitmap);
        viewTargetLeft.setImageBitmap(bitmapList.get(1));
        commonTopicLeft.setText((int) (Math.random() * 20) + "共同话题");
        commonFriendsLeft.setText(((int) (Math.random() * 10) + "共同关注"));
        commonFollowerLeft.setText((int) (Math.random() * 10) + "共同粉丝");
        locationLeft.setText(locationList.get((int) (Math.random() * 10)));*/
    }

    //设置填充界面，flag: 0-->Center，1-->Right,2-->Left;index为下标
    private void fillView(int flag, int index) {
        switch (flag) {
            case 0:
                viewUserCenter.setImageBitmap(userBitmap);
                viewTargetCenter.setImageBitmap(bitmapList.get(index));
                commonTopicCenter.setText((int) (Math.random() * 20) + "共同话题");
                commonFriendsCenter.setText((int) (Math.random() * 10) + "共同关注");
                commonFollowerCenter.setText((int) (Math.random() * 10) + "共同粉丝");
                if (isWhich) {
                    locationCenter.setText(locationList.get(0));
                } else {
                    locationCenter.setText(locationList.get((int) (Math.random() * 10)));
                }
                break;
            case 1:
                viewUserRight.setImageBitmap(userBitmap);
                viewTargetRight.setImageBitmap(bitmapList.get(index));
                commonTopicRight.setText((int) (Math.random() * 20) + "共同话题");
                commonFriendsRight.setText((int) (Math.random() * 10) + "共同关注");
                commonFollowerRight.setText((int) (Math.random() * 10) + "共同粉丝");
                if (isWhich) {
                    locationRight.setText(locationList.get(0));
                } else {
                    locationRight.setText(locationList.get((int) (Math.random() * 10)));
                }
                break;
            case 2:
                viewUserLeft.setImageBitmap(userBitmap);
                viewTargetLeft.setImageBitmap(bitmapList.get(index));
                commonTopicLeft.setText((int) (Math.random() * 20) + "共同话题");
                commonFriendsLeft.setText((int) (Math.random() * 10) + "共同关注");
                commonFollowerLeft.setText((int) (Math.random() * 10) + "共同粉丝");
                if (isWhich) {
                    locationLeft.setText(locationList.get(0));
                } else {
                    locationLeft.setText(locationList.get((int) (Math.random() * 10)));
                }
                break;
        }
    }

    private void setOnViewTouchListener() {
        final int[] leftIndex = {1}; //因为已经初始化了两个了

        //初始化初始界面
        initFill();

        //中间转
        relativeLayoutCenter.setOnTouchListener(new View.OnTouchListener() {
            float startX = 0;
            float dx = 0;
            boolean startFill = true;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startFill = true;
                        dx = 0;
                        startX = event.getRawX();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        dx = event.getRawX() - startX;
                        relativeLayoutCenter.setRotation(dx / 10);
                        relativeLayoutLeft.setRotation(-perX + dx / 10);
                        relativeLayoutRight.setRotation(dx / 10 + perX);
                        if (startFill) {
                            if (leftIndex[0] >= bitmapList.size() - 1) {
                                leftIndex[0] = 0;
                            }
                            fillView(2, leftIndex[0]);
                            startFill = false;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        startFill = false;

                        if (dx >= 200 || dx <= -200) {
                            leftIndex[0]++;
                            if (dx > 0) {
                                relativeLayoutCenter.setRotation(perX);
                                relativeLayoutLeft.setRotation(0);
                                relativeLayoutRight.setRotation(-perX);
                            } else {
                                relativeLayoutCenter.setRotation(-perX);
                                relativeLayoutLeft.setRotation(perX);
                                relativeLayoutRight.setRotation(0);
                            }
                        } else {
                            relativeLayoutCenter.setRotation(0);
                            relativeLayoutRight.setRotation(perX);
                            relativeLayoutLeft.setRotation(-perX);
                        }
                        break;
                }
                return true;
            }
        });

        //右边转
        relativeLayoutRight.setOnTouchListener(new View.OnTouchListener() {
            float startX = 0;
            float dx = 0;
            boolean startFill = true;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startFill = true;
                        dx = 0;
                        startX = event.getRawX();

                        break;
                    case MotionEvent.ACTION_MOVE:
                        dx = event.getRawX() - startX;
                        relativeLayoutRight.setRotation(dx / 10);
                        relativeLayoutCenter.setRotation(-perX + dx / 10);
                        relativeLayoutLeft.setRotation(dx / 10 + perX);
                        if (startFill) {
                            if (leftIndex[0] >= bitmapList.size() - 1) {
                                leftIndex[0] = 0;
                            }
                            fillView(0, leftIndex[0]);
                            startFill = false;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        startFill = false;

                        if (dx >= 200 || dx <= -200) {
                            leftIndex[0]++;

                            if (dx > 0) {
                                relativeLayoutRight.setRotation(perX);
                                relativeLayoutCenter.setRotation(0);
                                relativeLayoutLeft.setRotation(-perX);
                            } else {
                                relativeLayoutRight.setRotation(-perX);
                                relativeLayoutCenter.setRotation(perX);
                                relativeLayoutLeft.setRotation(0);
                            }
                        } else {
                            relativeLayoutRight.setRotation(0);
                            relativeLayoutLeft.setRotation(perX);
                            relativeLayoutCenter.setRotation(-perX);
                        }
                        break;
                }
                return true;
            }
        });


        //左边转
        relativeLayoutLeft.setOnTouchListener(new View.OnTouchListener() {
            float startX = 0;
            float dx = 0;
            boolean startFill = true;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = 0;
                        startX = event.getRawX();
                        startFill = true;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        dx = event.getRawX() - startX;
                        relativeLayoutLeft.setRotation(dx / 10);
                        relativeLayoutRight.setRotation(-perX + dx / 10);
                        relativeLayoutCenter.setRotation(dx / 10 + perX);
                        if (startFill) {
                            if (leftIndex[0] >= bitmapList.size() - 1) {
                                leftIndex[0] = 0;
                            }
                            fillView(1, leftIndex[0]);
                            startFill = false;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        startFill = false;

                        if (dx >= 200 || dx <= -200) {
                            leftIndex[0]++;
                            if (dx > 0) {
                                relativeLayoutLeft.setRotation(perX);
                                relativeLayoutRight.setRotation(0);
                                relativeLayoutCenter.setRotation(-perX);
                            } else {
                                relativeLayoutLeft.setRotation(-perX);
                                relativeLayoutRight.setRotation(perX);
                                relativeLayoutCenter.setRotation(0);
                            }
                        } else {
                            relativeLayoutLeft.setRotation(0);
                            relativeLayoutCenter.setRotation(perX);
                            relativeLayoutRight.setRotation(-perX);
                        }
                        break;
                }
                return true;
            }
        });
    }

    //获取头像
    public void getViewBitmap(final List<RelationShipTempBean.UsersBean> usersBeanList) {
        if (null == usersBeanList) {
            return;
        }
        bitmapList = new ArrayList<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < usersBeanList.size(); i++) {
                    try {

                        final String temp = usersBeanList.get(i).getProfile_image_url();
                        URL url = new URL(temp);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        InputStream in = connection.getInputStream();
                        Bitmap bitmapTemp = BitmapFactory.decodeStream(in);
                        bitmapList.add(bitmapTemp);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                Message msg = new Message();
                msg.what = fillView;
                handler.sendMessage(msg);
            }
        }).start();
    }


    private void initCenter() {
        relativeLayoutCenter = (RelativeLayout) findViewById(R.id.view_center);
        relativeLayoutRight = (RelativeLayout) findViewById(R.id.view_right);
        relativeLayoutLeft = (RelativeLayout) findViewById(R.id.view_left);
        viewUserCenter = (ImageView) findViewById(R.id.view_user_image_center);
        viewUserRight = (ImageView) findViewById(R.id.view_user_image_right);
        viewUserLeft = (ImageView) findViewById(R.id.view_user_image_left);
        viewTargetCenter = (ImageView) findViewById(R.id.view_target_image_center);
        viewTargetRight = (ImageView) findViewById(R.id.view_target_image_right);
        viewTargetLeft = (ImageView) findViewById(R.id.view_target_image_left);
        commonTopicCenter = (TextView) findViewById(R.id.view_common_topic_count_center);
        commonTopicRight = (TextView) findViewById(R.id.view_common_topic_count_right);
        commonTopicLeft = (TextView) findViewById(R.id.view_common_topic_count_left);
        commonFriendsCenter = (TextView) findViewById(R.id.view_common_friends_center);
        commonFriendsRight = (TextView) findViewById(R.id.view_common_friends_right);
        commonFriendsLeft = (TextView) findViewById(R.id.view_common_friends_left);
        commonFollowerCenter = (TextView) findViewById(R.id.view_common_followers_center);
        commonFollowerRight = (TextView) findViewById(R.id.view_common_followers_right);
        commonFollowerLeft = (TextView) findViewById(R.id.view_common_followers_left);
        locationCenter = (TextView) findViewById(R.id.view_location_center);
        locationRight = (TextView) findViewById(R.id.view_location_right);
        locationLeft = (TextView) findViewById(R.id.view_location_left);

        float width = getWindowManager().getDefaultDisplay().getWidth();
        float height = getWindowManager().getDefaultDisplay().getHeight() + 200;
        relativeLayoutLeft.setPivotX(width / 2);
        relativeLayoutLeft.setPivotY(height);
        relativeLayoutRight.setPivotX(width / 2);
        relativeLayoutRight.setPivotY(height);
        relativeLayoutCenter.setPivotX(width / 2);
        relativeLayoutCenter.setPivotY(height);
        relativeLayoutLeft.setRotation(-perX);
        relativeLayoutRight.setRotation(perX);

        locationList = new ArrayList<>();
        locationList.add("湖北       VS    湖北");
        locationList.add("湖北       VS    北京");
        locationList.add("湖北       VS    四川");
        locationList.add("湖北       VS    湖南");
        locationList.add("湖北       VS    上海");
        locationList.add("湖北       VS    纽约");
        locationList.add("湖北       VS    深圳");
        locationList.add("湖北       VS    新疆");
        locationList.add("湖北       VS    海南");
        locationList.add("湖北       VS    杭州");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relation_ship_improve);
        init();
    }


    private void init() {

        //初始化中间旋转布局
        initCenter();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        navView = (NavigationView) findViewById(R.id.nav_view);
        userImage = (RoundedImageView) findViewById(R.id.user_image_relationship);
        targetImage = (RoundedImageView) findViewById(R.id.target_image_relationship);
        isEachFollowerButton = (Button) findViewById(R.id.each_follower_button_relationship);

        View headerView = navView.getHeaderView(0);
        navUserImage = headerView.findViewById(R.id.nav_user_image);
        navUserDescription = headerView.findViewById(R.id.nav_user_description);

        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RelationShipImprove.this, WeiBoDetail.class);
                startActivity(intent);
            }
        });

        targetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RelationShipImprove.this, WeiBoDetail.class);
                startActivity(intent);
            }
        });

        navUserImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RelationShipImprove.this, WeiBoDetail.class);
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

    //获取原RecyclerView的数据
    //flag=0 表示互粉；flag=1 表示同城
    public void setRecyclerView(int flag) {
        String temp_url = null;
        if (flag == 0) {
            temp_url = Contents.followersUrl_list + "uid=" + mAccessToken.getUid() +
                    "&cursor=0&count=20&access_token=2.00APvuCG06XASOe34681c9cf8pV2JD";
            isWhich = false;
        } else {
            temp_url = Contents.friendsUrl_list + "uid=" + mAccessToken.getUid() +
                    "&cursor=0&count=20&access_token=2.00APvuCG06XASOe34681c9cf8pV2JD";
            isWhich = true;
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
                        isWhich = false;
                        setRecyclerView(0);
                        break;
                    case R.id.same_location: {
                        setRecyclerView(1);
                    }
                    break;
                    case R.id.about:
                        Toast.makeText(getApplication(), String.valueOf("我想跟你聊天队倾力制作！"), Toast.LENGTH_SHORT).show();
                        break;
                    /*case R.id.search_user: {
//                        Intent intent = new Intent(RelationShipImprove.this, SearchUser.class);
//                        startActivityForResult(intent, 1);
                        Toast.makeText(getApplication(),String.valueOf("程序猿正在加紧完善中！！"),Toast.LENGTH_SHORT).show();
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
        Log.d("@HusterYP", String.valueOf(result + "..."));

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
