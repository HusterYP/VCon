package com.example.yuanping.weconnected.login;

/**
 * Created by yuanping on 10/28/17.
 */

public class Contents {
    public static final String APP_KEY = "2676180418";
    //默认回调页
    public static final String REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";

    public static final String SCOPE = "email,direct_messages_read,direct_messages_write,"
            + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
            + "follow_app_official_microblog," + "invitation_write";

    //标志位，获取关注列表和粉丝列表
    public static final int GET_FRIENDS_LIST = 1;
    public static final int GET_FOLLOWERS_LIST = 2;

    //每次获取的关注信息数量
    public static final int COUNT = 25;
    //每次获取微博信息列表的位置，默认获取最新
    public static final int HOMETIMELINE_START = 0;
    //每次获取微博信息列表数量
    public static final int HOMETIMELIE_COUNT = 25;
    //每次获取的评论和转发列表数量
    public static final int COMMENTS_COUNT = 50;

    public static String friendsUrl_list = "https://api.weibo.com/2/friendships/friends.json?";
    public static String followersUrl_list = "https://api.weibo.com/2/friendships/followers.json?";
    public static String homeTimeLineList = "https://api.weibo.com/2/statuses/home_timeline.json?";
    public static String comments_list = "https://api.weibo.com/2/comments/show.json?";
    //转发列表
    public static String repost_list = "https://api.weibo.com/2/statuses/repost_timeline.json?";
    //获取两用户之间的关系
    public static String each_relationship = "https://api.weibo.com/2/friendships/show.json?";
    //获取用户信息
    public static String userUrl = "https://api.weibo.com/2/users/show.json?";

    public static String userAccessToken = "2.00APvuCG06XASOe34681c9cf8pV2JD";



   /* //用户信息
    public static String userUrl = "https://api.weibo.com/2/users/show.json";
    //最新微博
    public static String weiboUrl = "https://api.weibo.com/2/statuses/home_timeline.json";
    //粉丝列表
    public static String followersUrl = "https://api.weibo.com/2/friendships/followers.json";
    //关注列表
    public static String friendsUrl = "https://api.weibo.com/2/friendships/friends.json";
    //获取当前登录用户及其所关注（授权）用户的最新微博
    public static String home_timeline = "https://api.weibo.com/2/statuses/home_timeline.json";
    //获取用户发布的微博
    public static String user_timeline = "https://api.weibo.com/2/statuses/user_timeline.json";
    //根据uid获取用户的主页
    public static String prehomaPageUrl = "https://m.weibo.cn/u/";
    //获取两个用户之间的关系
    //https://api.weibo.com/2/friendships/show.json?source_id=5539916070&target_screen_name=听荷紫文&access_token=2.00APvuCG06XASOe34681c9cf8pV2JD
    //批量获取互粉数
    public static String getFollowerUid = "https://api.weibo.com/2/friendships/followers/ids.json";*/
   //批量获取粉丝数量
   //https://api.weibo.com/2/friendships/followers/ids.json?uid=5539916070&access_token=2.00APvuCG06XASOe34681c9cf8pV2JD
    //用户关注列表
//    public static String friendsUrl_list  = "https://m.weibo.cn/p/second?containerid=1005055539916070_-_FOLLOWERS";


    //测试使用
    public static String userUid = "5539916070";
//    public static String userAccessToken = "2.00APvuCGSmyGvCe5795281ad0Z2ICY";



}
