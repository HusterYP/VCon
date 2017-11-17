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
import com.example.yuanping.weconnected.login.bean.WeiboDetailBean;
import com.example.yuanping.weconnected.login.bean.WeiboInfoDetailBean;
import com.example.yuanping.weconnected.login.utils.JsonParse;
import com.google.gson.internal.LinkedTreeMap;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.yuanping.weconnected.R.id.temp;
import static com.example.yuanping.weconnected.login.Contents.GET_FOLLOWERS_LIST;
import static com.example.yuanping.weconnected.login.Contents.GET_FRIENDS_LIST;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.m;
import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.v;
import static java.lang.Integer.parseInt;

/**
 * Created by yuanping on 11/3/17.
 */

public class WeiboListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private WeiboDetailBean weiboDetailBean;
    private Context mContext;
    private List<WeiboDetailBean.StatusesBean> statusesBean;
    //@HusterYP 被转发内容
    private WeiboDetailBean.StatusesBean.RetweetedStatusBean retweetedStatusBean;
    private int originWeibo = 0; //原创微博
    private int retweetedWeibo = 1; //转发微博
    private int footType = 2; //最后一条获取更多数据
    //原创微博中配图
    private List<String> imageUrl = null;
    //转发微博中配图
    private List<WeiboDetailBean.StatusesBean.RetweetedStatusBean.PicUrlsBean> pic_urls = null;
    //加载更多,默认第一次加载第一页
    private static int page = 1;
    private boolean hasMore;

    //获取主线程Handler,获取更多数据
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            String json = (String) msg.obj;
            weiboDetailBean = JsonParse.parseWeiboList(json);
            List<WeiboDetailBean.StatusesBean> temp = weiboDetailBean.getStatuses();
            if (null != temp) {
                statusesBean.addAll(temp);
                notifyDataSetChanged();
                hasMore = true;
            } else {
                hasMore = false;
            }
        }
    };


    public WeiboListAdapter(WeiboDetailBean weiboDetailBean, Context mContext) {
        this.weiboDetailBean = weiboDetailBean;
        this.mContext = mContext;
        statusesBean = weiboDetailBean.getStatuses();
        //每执行一次构造函数，就应该将page置位
        page = 1;
        hasMore = true;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == originWeibo) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_one_weibo_detail, null, false);
            view.setOnClickListener(this);
            return new OriginWeiBoHolder(view);
        } else if (viewType == retweetedWeibo) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_two_weibo_detail, null, false);
            view.setOnClickListener(this);
            return new RetweetedWeiboHolder(view);
        } else {
            return new FootHolder(LayoutInflater.from(mContext).inflate(R.layout.footview_user_info, null, false));
        }
    }

    //判断微博的类型，原创还是转发
    @Override
    public int getItemViewType(int position) {
        //这里将每一个item的truncated字段用于判断点赞标志
        //但是要注意不能在这里去设置标志位false，否则会一直为false，这个应该和这几个方法的执行顺序有关
//        statusesBean.get(position).setTruncated(false);

        if (position == getItemCount() - 1) {
            return footType;
        } else {
            retweetedStatusBean = statusesBean.get(position).getRetweeted_status();
            if (null == retweetedStatusBean) {
                return originWeibo;
            } else {
                return retweetedWeibo;
            }
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        holder.itemView.setTag(R.id.tag_0, position);
        //这个是要传递回去的对象
        if (position < statusesBean.size()) {
            holder.itemView.setTag(R.id.tag_1, statusesBean.get(position));
        }
        //如果是原创微博
        if (holder instanceof OriginWeiBoHolder) {
            holder.itemView.setTag(R.id.tag_2, originWeibo);//传递标志位
            ((OriginWeiBoHolder) holder).userScreenNameItemOne.setText(statusesBean.get(position).getUser().getName());
            ((OriginWeiBoHolder) holder).sendTimeItemOne.setText(statusesBean.get(position).getCreated_at());
            ((OriginWeiBoHolder) holder).contentItemOne.setText(statusesBean.get(position).getText());
            //为什么这里不能自动将int转换为String呢？？
            ((OriginWeiBoHolder) holder).sendCountItemOne.setText(statusesBean.get(position).getReposts_count() + "");
            ((OriginWeiBoHolder) holder).commentCountItemOne.setText(statusesBean.get(position).getComments_count() + "");
            ((OriginWeiBoHolder) holder).loveCountItemOne.setText(statusesBean.get(position).getAttitudes_count() + "");
            ((OriginWeiBoHolder) holder).loveImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (!statusesBean.get(position).getFlag()) {
                        ((OriginWeiBoHolder) holder).loveImage.setBackgroundResource(R.drawable.love_ok);
                        String oldCount = (String) ((OriginWeiBoHolder) holder).loveCountItemOne.getText();
                        int newCount = Integer.parseInt(oldCount) + 1;
                        ((OriginWeiBoHolder) holder).loveCountItemOne.setText(newCount + "");
                        statusesBean.get(position).setFlag(true);
                    } else {
                        ((OriginWeiBoHolder) holder).loveImage.setBackgroundResource(R.drawable.love);
                        String oldCount = (String) ((OriginWeiBoHolder) holder).loveCountItemOne.getText();
                        ((OriginWeiBoHolder) holder).loveCountItemOne.setText(parseInt(oldCount) - 1 + "");
                        statusesBean.get(position).setFlag(false);
                    }
                }
            });

            Glide.with(mContext)
                    .load(statusesBean.get(position).getUser().getProfile_image_url())
                    .placeholder(R.drawable.user)//图片加载出来前，显示的图片
                    .error(R.drawable.user)//图片加载失败后，显示的图片
                    .into(((OriginWeiBoHolder) (holder)).userImageItemOne);

            //NineGridView加载图片
            ArrayList<ImageInfo> imageInfos = new ArrayList<>();
            //这里是Gson数据解析的一个bug，可见chrome技术博客收藏
            List<LinkedTreeMap> temp = (List<LinkedTreeMap>) statusesBean.get(position).getPic_urls();
            if (null != temp) {
                //记住初始化咯，这个不同于下面的pic_urls
                imageUrl = new ArrayList<>();
                for (int i = 0; i < temp.size(); i++) {
//                imageUrl.add(); LinkedTreeMap
                    imageUrl.add(temp.get(i).get("thumbnail_pic").toString());
//                    Log.d("@HusterYP", String.valueOf(position + "...." + temp.get(i).get("thumbnail_pic")));
                }
            }
            if (imageUrl != null) {
                for (String imageDetail : imageUrl) {

                    Log.d("@HusterYP", String.valueOf(imageDetail));

                    ImageInfo info = new ImageInfo();
                    info.setThumbnailUrl(imageDetail);
                    info.setBigImageUrl(imageDetail);
                    imageInfos.add(info);
                }
                ((OriginWeiBoHolder) holder).nineGridViewItemOne.setAdapter(new NineGridViewClickAdapter(mContext, imageInfos));
                imageUrl = null;
            }
        } else if (holder instanceof RetweetedWeiboHolder) {

            holder.itemView.setTag(R.id.tag_2, retweetedWeibo);

            //这里总是报空指针异常，是item的逻辑判断出了问题,上面的getItemViewType出错
//            Log.d("@HusterYP", String.valueOf("Null?..."+((statusesBean.get(position)).getRetweeted_status())));

            ((RetweetedWeiboHolder) holder).userScreenNameItemTwo.setText(statusesBean.get(position).getUser().getScreen_name());
            ((RetweetedWeiboHolder) holder).sendTimeItemTwo.setText(statusesBean.get(position).getCreated_at());
            ((RetweetedWeiboHolder) holder).contentItemTwo.setText(statusesBean.get(position).getText());
            ((RetweetedWeiboHolder) holder).commentCountItemTwo.setText(statusesBean.get(position).getComments_count() + "");
            ((RetweetedWeiboHolder) holder).sendCountItemTwo.setText(statusesBean.get(position).getReposts_count() + "");
            ((RetweetedWeiboHolder) holder).loveCountItemTwo.setText(statusesBean.get(position).getAttitudes_count() + "");
            ((RetweetedWeiboHolder) holder).originContentItemTwo.setText(statusesBean.get(position).getRetweeted_status().getText());

            ((RetweetedWeiboHolder) holder).loveImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!statusesBean.get(position).getFlag()) {
                        ((RetweetedWeiboHolder) holder).loveImage.setBackgroundResource(R.drawable.love_ok);
                        String oldCount = (String) ((RetweetedWeiboHolder) holder).loveCountItemTwo.getText();
                        ((RetweetedWeiboHolder) holder).loveCountItemTwo.setText(parseInt(oldCount) + 1 + "");
                        statusesBean.get(position).setFlag(true);
                    } else {
                        ((RetweetedWeiboHolder) holder).loveImage.setBackgroundResource(R.drawable.love);
                        String oldCount = (String) ((RetweetedWeiboHolder) holder).loveCountItemTwo.getText();
                        ((RetweetedWeiboHolder) holder).loveCountItemTwo.setText((parseInt(oldCount) - 1) + "");
                        statusesBean.get(position).setFlag(false);
                    }
                }
            });

            Glide.with(mContext)
                    .load(statusesBean.get(position).getUser().getProfile_image_url())
                    .placeholder(R.drawable.user)//图片加载出来前，显示的图片
                    .error(R.drawable.user)//图片加载失败后，显示的图片
                    .into(((RetweetedWeiboHolder) (holder)).userImageItemTwo);

            //NineGridView加载图片
            ArrayList<ImageInfo> imageInfos = new ArrayList<>();
            pic_urls = statusesBean.get(position).getRetweeted_status().getPic_urls();
            if (pic_urls != null) {
                for (WeiboDetailBean.StatusesBean.RetweetedStatusBean.PicUrlsBean imageDetail : pic_urls) {
                    ImageInfo info = new ImageInfo();
                    info.setThumbnailUrl(imageDetail.getThumbnail_pic());
                    info.setBigImageUrl(imageDetail.getThumbnail_pic());
                    imageInfos.add(info);
                }
                ((RetweetedWeiboHolder) holder).nineGridViewItemTwo.setAdapter(new NineGridViewClickAdapter(mContext, imageInfos));
                //置空咯
                pic_urls = null;
            }
        } else {
            holder.itemView.setTag(R.id.tag_2, -1);

            loadMore();
        }
    }

    //加载更多数据，这里是通过加载下一页数据；默认第一次加载第一页数据
    public void loadMore() {
        page++;
        final String loadMoreUrl = Contents.homeTimeLineList + "since_id=" + Contents.HOMETIMELINE_START
                + "&count=" + Contents.HOMETIMELIE_COUNT + "&page=" + page + "&access_token=" + Contents.userAccessToken;

        Request request = new Request.Builder().url(loadMoreUrl).build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Callback callback = new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Message msg = new Message();
                msg.obj = json;
                mHandler.sendMessage(msg);
            }
        };
        call.enqueue(callback);
    }

    @Override
    public int getItemCount() {
        return statusesBean.size() + 1;
    }

    @Override
    public void onClick(View v) {
        if (null != onItemClickListener) {
            onItemClickListener.OnItemClick(v, (int) v.getTag(R.id.tag_0), (WeiboDetailBean.StatusesBean) v.getTag(R.id.tag_1), (int) v.getTag(R.id.tag_2));
        }
    }

    //如果是原创微博
    class OriginWeiBoHolder extends RecyclerView.ViewHolder {
        private ImageView userImageItemOne;
        private TextView userScreenNameItemOne;
        private TextView sendTimeItemOne;
        private TextView contentItemOne;
        private NineGridView nineGridViewItemOne;
        private TextView sendCountItemOne; //转发数
        private TextView commentCountItemOne;
        private TextView loveCountItemOne;
        private ImageView loveImage;

        public OriginWeiBoHolder(View itemView) {
            super(itemView);
            userImageItemOne = itemView.findViewById(R.id.user_image_item_one);
            userScreenNameItemOne = itemView.findViewById(R.id.user_name_item_one);
            sendTimeItemOne = itemView.findViewById(R.id.time_item_one);
            contentItemOne = itemView.findViewById(R.id.content_text_item_one);
            nineGridViewItemOne = itemView.findViewById(R.id.nineGrid_item_one);
            sendCountItemOne = itemView.findViewById(R.id.send_count_item_one);
            commentCountItemOne = itemView.findViewById(R.id.comment_count_item_one);
            loveCountItemOne = itemView.findViewById(R.id.love_count_item_one);
            loveImage = itemView.findViewById(R.id.love_image_one);
        }
    }

    //如果是转发的话
    class RetweetedWeiboHolder extends RecyclerView.ViewHolder {

        private ImageView userImageItemTwo;
        private TextView userScreenNameItemTwo;
        private TextView sendTimeItemTwo;
        private TextView contentItemTwo;
        private NineGridView nineGridViewItemTwo;
        private TextView sendCountItemTwo; //转发数
        private TextView commentCountItemTwo;
        private TextView loveCountItemTwo;
        private TextView originContentItemTwo;
        private ImageView loveImage; //点赞功能

        public RetweetedWeiboHolder(View itemView) {
            super(itemView);
            userImageItemTwo = itemView.findViewById(R.id.user_image_item_two);
            userScreenNameItemTwo = itemView.findViewById(R.id.user_name_item_two);
            sendTimeItemTwo = itemView.findViewById(R.id.time_item_two);
            contentItemTwo = itemView.findViewById(R.id.content_text_item_two);
            nineGridViewItemTwo = itemView.findViewById(R.id.nineGrid_item_two);
            sendCountItemTwo = itemView.findViewById(R.id.send_count_item_two);
            commentCountItemTwo = itemView.findViewById(R.id.comment_count_item_two);
            loveCountItemTwo = itemView.findViewById(R.id.love_count_item_two);
            originContentItemTwo = itemView.findViewById(R.id.origin_content_item_two);
            loveImage = itemView.findViewById(R.id.love_image_two);

        }
    }

    //显示“加载更多...”
    class FootHolder extends RecyclerView.ViewHolder {

        private TextView footView;

        public FootHolder(View itemView) {
            super(itemView);
            footView = itemView.findViewById(R.id.foot_view_user_info);
        }
    }

    //设置Item的点击监听事件
    public static interface OnItemClickListener {
        void OnItemClick(View view, int position, WeiboDetailBean.StatusesBean statusesBean, int flag);
    }

    private OnItemClickListener onItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
