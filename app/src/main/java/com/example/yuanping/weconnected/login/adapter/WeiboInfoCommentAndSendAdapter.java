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
import com.example.yuanping.weconnected.login.bean.RepostBeanWeiboInfo;
import com.example.yuanping.weconnected.login.bean.WeiboInfoBean;
import com.example.yuanping.weconnected.login.utils.JsonParse;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.R.attr.data;
import static com.example.yuanping.weconnected.R.id.temp;
import static com.example.yuanping.weconnected.login.Contents.GET_FOLLOWERS_LIST;
import static com.example.yuanping.weconnected.login.Contents.GET_FRIENDS_LIST;

/**
 * Created by yuanping on 11/4/17.
 */

public class WeiboInfoCommentAndSendAdapter extends RecyclerView.Adapter
        <WeiboInfoCommentAndSendAdapter.MyViewHolder> {

    private List<WeiboInfoBean.CommentsBean> commentsBeen;
    private List<RepostBeanWeiboInfo.RepostsBean> repostBean;
    private Context mContext;
    private int flag = 0;  //标志评论列表还是转发列表;0为评论列表，1为转发列表
    private static int page = 1;//加载更多时，自增的页数,默认显示一页
    private String mid;

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            String temp = (String) msg.obj;
            switch (flag){
                case 0:
                    WeiboInfoBean weiboInfoDetailBean = JsonParse.parseWeiboInfo(temp);
                    if(null!=weiboInfoDetailBean && weiboInfoDetailBean.getComments()!=null){
                        commentsBeen.addAll(weiboInfoDetailBean.getComments());
                        notifyDataSetChanged();
                    }
                    break;
                case 1:
                    RepostBeanWeiboInfo repostBeanWeiboInfo = JsonParse.parseRepost(temp);
                    if(null!=repostBeanWeiboInfo&&repostBeanWeiboInfo.getReposts()!=null){
                        repostBean.addAll(repostBeanWeiboInfo.getReposts());
                        notifyDataSetChanged();
                    }
                    break;
            }
            notifyDataSetChanged();
        }
    };


    public WeiboInfoCommentAndSendAdapter(List<WeiboInfoBean.CommentsBean> commentsBeen,
                                          List<RepostBeanWeiboInfo.RepostsBean> repostBean,
                                          Context mContext, int flag, String mid) {
        this.commentsBeen = commentsBeen;
        this.repostBean = repostBean;
        this.mContext = mContext;
        this.flag = flag;
        this.mid = mid;
    }
    //注意咯，不能这样写构造函数，因为泛型会类型擦除，之后两个构造函数都是一样的咯
//    public  WeiboInfoCommentAndSendAdapter(List<RepostBeanWeiboInfo>repostBean,Context mContext,int flag){}

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_weibo_info_comment_and_send, null, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //如果到达最后一条
        if (position >= getItemCount() - 1) {
            loadMore();
        }
        if (0 == flag && null != commentsBeen) {
            holder.userName.setText(commentsBeen.get(position).getUser().getName());
            holder.description.setText(commentsBeen.get(position).getText());
            holder.time.setText(commentsBeen.get(position).getCreated_at());
            Glide.with(mContext)
                    .load(commentsBeen.get(position).getUser().getProfile_image_url())
                    .placeholder(R.drawable.user)//图片加载出来前，显示的图片
                    .error(R.drawable.user)//图片加载失败后，显示的图片
                    .into(holder.userImage);
        } else if (1 == flag && null != repostBean) {
            holder.userName.setText(repostBean.get(position).getUser().getName());
            holder.description.setText(repostBean.get(position).getText());
            holder.time.setText(repostBean.get(position).getCreated_at());

            Glide.with(mContext)
                    .load(repostBean.get(position).getUser().getProfile_image_url())
                    .placeholder(R.drawable.user)//图片加载出来前，显示的图片
                    .error(R.drawable.user)//图片加载失败后，显示的图片
                    .into(holder.userImage);
        }
    }

    public void loadMore() {
        page++;
        final String commentUrl =Contents.comments_list + "id=" + mid + "&count=" +"&page="+page+
                Contents.COMMENTS_COUNT + "&access_token=" + Contents.userAccessToken;
        final String repostUrl =Contents.repost_list + "id=" + mid + "&count=" +"&page="+page+
                Contents.COMMENTS_COUNT + "&access_token=" + Contents.userAccessToken;
        Request request = null;
        if (0 == flag) {
            request = new Request.Builder().url(commentUrl).build();
        } else if (1 == flag) {
            request = new Request.Builder().url(repostUrl).build();
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
                String temp= response.body().string();
                Message msg = new Message();
                msg.obj = temp;
                mHandler.sendMessage(msg);
            }
        };
        call.enqueue(callback);
    }

    @Override
    public int getItemCount() {
        return flag == 0 ? commentsBeen.size() : repostBean.size();
    }

    //只需要同一个ViewHolder即可，因为二者布局一样
    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView userImage;
        private TextView userName;
        private TextView time;
        private TextView description;

        public MyViewHolder(View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.item_image_weibo_info_comment);
            userName = itemView.findViewById(R.id.item_name_weibo_info_comment);
            time = itemView.findViewById(R.id.item_time_weibo_info_comment);
            description = itemView.findViewById(R.id.item_description_weibo_info_comment);
        }
    }
}
