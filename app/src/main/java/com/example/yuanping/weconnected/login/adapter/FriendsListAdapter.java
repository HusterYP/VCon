package com.example.yuanping.weconnected.login.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuanping.weconnected.R;
import com.example.yuanping.weconnected.login.Contents;
import com.example.yuanping.weconnected.login.bean.FriendsList;
import com.example.yuanping.weconnected.login.utils.JsonParse;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.yuanping.weconnected.login.Contents.COUNT;
import static com.example.yuanping.weconnected.login.Contents.GET_FOLLOWERS_LIST;
import static com.example.yuanping.weconnected.login.Contents.GET_FRIENDS_LIST;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.c;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.l;

/**
 * Created by yuanping on 11/1/17.
 */

public class FriendsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private FriendsList friendsList;
    private List<FriendsList.UsersBean> data;
    private Context mContext;

    private Oauth2AccessToken mAccessToken;
    private int flag;


    private int normalType = 0; //正常的item
    private int footType = 1; //添加底部“加载更多...”

    private boolean hasMore = true; //是否有更多的数据
    private boolean hideFoot = false;//是否隐藏了底部的提示
    private String[] temp = {null};

    //获取主线程handler
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            String info = (String) msg.obj;
            friendsList = JsonParse.parseUserInfo(info);

            Log.d("@HusterYP", String.valueOf("Handler cursor..." + friendsList.getNext_cursor()));

            data.addAll(friendsList.getUsers());
            notifyDataSetChanged();
        }
    };


    public FriendsListAdapter(FriendsList friendsList, Context mContext, boolean hasMore, int flag) {
        this.friendsList = friendsList;
        this.mContext = mContext;
        this.hasMore = hasMore;
        this.flag = flag;
        if (null != friendsList) {
            this.data = friendsList.getUsers();
        }
        mAccessToken = AccessTokenKeeper.readAccessToken(mContext);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == normalType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_user_info, null, false);
            view.setOnClickListener(this);
            return new NormalHolder(view);
        } else {
            //加载栏目不需要设置点击事件
            View view = LayoutInflater.from(mContext).inflate(R.layout.footview_user_info, null, false);
            return new FootHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof NormalHolder) {
            holder.itemView.setTag(R.id.relation_tag_target_id,data.get(position).getName());

            ((NormalHolder) (holder)).name.setText((data.get(position)).getName());
            ((NormalHolder) (holder)).description.setText((data.get(position)).getDescription());
            Glide.with(mContext)
                    .load(data.get(position).getProfile_image_url())
                    .placeholder(R.drawable.user)//图片加载出来前，显示的图片
                    .error(R.drawable.user)//图片加载失败后，显示的图片
                    .into(((NormalHolder) (holder)).bitmap);
        } else {
            if (friendsList.getNext_cursor() == 0) {
                ((FootHolder) holder).footText.setVisibility(View.VISIBLE);
                ((FootHolder) holder).footText.setText("木有啦...");
                hasMore = false;
            } else {
                loadMore();
            }
        }

    }

    @Override
    public int getItemCount() {
        return data.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return footType;
        } else {
            return normalType;
        }
    }

    class NormalHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView description;
        private ImageView bitmap;

        public NormalHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name_user_info);
            description = itemView.findViewById(R.id.item_description_user_info);
            bitmap = itemView.findViewById(R.id.item_image_user_info);
        }
    }

    class FootHolder extends RecyclerView.ViewHolder {

        private TextView footText;

        public FootHolder(View itemView) {
            super(itemView);
            footText = itemView.findViewById(R.id.foot_view_user_info);
        }
    }

    public void loadMore() {
        int cursor = friendsList.getNext_cursor();


        final String friendsList = Contents.friendsUrl_list + "uid=" + mAccessToken.getUid() + "&cursor=" +
                cursor + "&count=" + COUNT + "&access_token=" + Contents.userAccessToken;

        Log.d("@HusterYP", String.valueOf(friendsList));

        final String followersList = Contents.followersUrl_list + "uid=" + mAccessToken.getUid() + "&cursor=" +
                cursor + "&count=" + COUNT + "&access_token=" + Contents.userAccessToken;
        Request request = null;
        if (GET_FRIENDS_LIST == flag) {
            request = new Request.Builder().url(friendsList).build();
        } else if (GET_FOLLOWERS_LIST == flag) {
            request = new Request.Builder().url(followersList).build();
        } else {
//            return null;
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
                temp[0] = response.body().string();
                Message msg = new Message();
                msg.obj = temp[0];
                mHandler.sendMessage(msg);
            }
        };
        call.enqueue(callback);
    }

    //设置Item的点击监听事件
    public static interface OnItemClickListener{
        void onItemClick(View view,String targetId);
    }

    private OnItemClickListener onItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onClick(View v) {
        if(null!=onItemClickListener){
            onItemClickListener.onItemClick(v,(String)v.getTag(R.id.relation_tag_target_id));
        }
    }
}
