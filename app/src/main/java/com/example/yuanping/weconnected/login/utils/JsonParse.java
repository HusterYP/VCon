package com.example.yuanping.weconnected.login.utils;

import android.util.Log;

import com.example.yuanping.weconnected.login.adapter.WeiboInfoCommentAndSendAdapter;
import com.example.yuanping.weconnected.login.bean.FriendsList;
import com.example.yuanping.weconnected.login.bean.RelationShipBean;
import com.example.yuanping.weconnected.login.bean.RepostBeanWeiboInfo;
import com.example.yuanping.weconnected.login.bean.TargetUserBean;
import com.example.yuanping.weconnected.login.bean.WeiboDetailBean;
import com.example.yuanping.weconnected.login.bean.WeiboInfoBean;
import com.example.yuanping.weconnected.login.bean.WeiboInfoDetailBean;
import com.example.yuanping.weconnected.login.user.RelationShip;
import com.google.gson.Gson;

import static com.example.yuanping.weconnected.login.com.sina.weibo.sdk.openapi.legacy.CommonAPI.CAPITAL.j;

/**
 * Created by yuanping on 11/2/17.
 */

public class JsonParse {
    //可以写成一个泛型咯，一点也不优雅
    //各种json数据的解析
    public static FriendsList parseUserInfo(String json) {
        FriendsList friendsList = null;
        Gson gson = new Gson();
        if (null != json) {
            friendsList = gson.fromJson(json, FriendsList.class);
        }
        return friendsList == null ? null : friendsList;
    }

    public static WeiboDetailBean parseWeiboList(String json) {
        WeiboDetailBean friendsList = null;
        Gson gson = new Gson();
        if (null != json) {
            friendsList = gson.fromJson(json, WeiboDetailBean.class);
        }
        return friendsList == null ? null : friendsList;
    }

    public static WeiboInfoBean parseWeiboInfo(String json) {
        WeiboInfoBean weiboInfoDetailBean = null;
        Gson gson = new Gson();
        if(null!=json){
            weiboInfoDetailBean = gson.fromJson(json,WeiboInfoBean.class);
        }
        return weiboInfoDetailBean == null?null:weiboInfoDetailBean;
    }

    public static RepostBeanWeiboInfo parseRepost(String json){
        RepostBeanWeiboInfo temp = null;
        if(null!=json) {
            Gson gson = new Gson();
            temp = gson.fromJson(json, RepostBeanWeiboInfo.class);
        }
        return temp == null ? null:temp;
    }

    public static RelationShipBean parseRelationShip(String json){
        RelationShipBean relationShipBean = null;
        Gson gson = new Gson();
        if(null!=json){
            relationShipBean = gson.fromJson(json, RelationShipBean.class);
        }
        return relationShipBean == null?null:relationShipBean;
    }

    public static TargetUserBean parseTargetUserBean(String json){
        TargetUserBean relationShipBean = null;
        Gson gson = new Gson();
        if(null!=json){
            relationShipBean = gson.fromJson(json, TargetUserBean.class);
        }
        return relationShipBean == null?null:relationShipBean;
    }
}
