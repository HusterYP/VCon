package com.example.yuanping.weconnected.login.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuanping.weconnected.R;
import com.example.yuanping.weconnected.login.bean.RelationShipTempBean;
import com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.models.User;
import com.itheima.roundedimageview.RoundedImageView;

import java.util.List;

import static android.R.attr.data;

/**
 * Created by yuanping on 11/5/17.
 */

public class RelationAdapter extends RecyclerView.Adapter<RelationAdapter.MyViewHolder> {

    private RelationShipTempBean relationShipTempBean;
    private List<RelationShipTempBean.UsersBean> usersBeen;
    private Context mContext;

    public RelationAdapter(RelationShipTempBean relationShipTempBean, Context mContext) {
        this.relationShipTempBean = relationShipTempBean;
        this.mContext = mContext;
        usersBeen = relationShipTempBean.getUsers();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_user_info,null,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.description.setText(usersBeen.get(position).getDescription());
        holder.name.setText(usersBeen.get(position).getName());
        Glide.with(mContext)
                .load(usersBeen.get(position).getProfile_image_url())
                .placeholder(R.drawable.user)//图片加载出来前，显示的图片
                .error(R.drawable.user)//图片加载失败后，显示的图片
                .into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return usersBeen.size() / 2 ;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private RoundedImageView userImage;
        private TextView name;
        private TextView description;

        public MyViewHolder(View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.item_image_user_info);
            name = itemView.findViewById(R.id.item_name_user_info);
            description = itemView.findViewById(R.id.item_description_user_info);
        }
    }
}
