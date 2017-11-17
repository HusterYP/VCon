package com.example.yuanping.weconnected.login.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yuanping on 11/5/17.
 */

public class TargetUserBean {
    /**
     * id : 5194139813
     * idstr : 5194139813
     * class : 1
     * screen_name : 听荷紫文
     * name : 听荷紫文
     * province : 43
     * city : 1
     * location : 湖南 长沙
     * description : 笑容沉下来，瞳孔便放大。死寂一般。这算看得开吧？
     * url :
     * profile_image_url : http://tva1.sinaimg.cn/crop.0.0.200.200.50/005Fw52Bjw1ehshxg88jxj305k05kglj.jpg
     * profile_url : u/5194139813
     * domain :
     * weihao :
     * gender : f
     * followers_count : 804
     * friends_count : 1857
     * pagefriends_count : 0
     * statuses_count : 3189
     * favourites_count : 0
     * created_at : Thu Jun 26 18:16:59 +0800 2014
     * following : true
     * allow_all_act_msg : false
     * geo_enabled : true
     * verified : false
     * verified_type : -1
     * remark :
     * insecurity : {"sexual_content":false}
     * status : {"created_at":"Sat Jun 10 17:02:34 +0800 2017","id":4117136739618359,"mid":"4117136739618359","idstr":"4117136739618359","text":"▽☻ΩΩΩΩΩΩ 小.鲜肉被美.女厕所强吻强摸强...誓死不从惨遭暴打[神马][哈哈][赞][爱你][耶]","textLength":90,"source_allowclick":0,"source_type":1,"source":"<a href=\"http://app.weibo.com/t/feed/6vtZb0\" rel=\"nofollow\">微博 weibo.com<\/a>","favorited":false,"truncated":false,"in_reply_to_status_id":"","in_reply_to_user_id":"","in_reply_to_screen_name":"","pic_urls":[{"thumbnail_pic":"http://wx4.sinaimg.cn/thumbnail/005Rr6Tcgy1fcgre7knsrj30cu19642x.jpg"}],"thumbnail_pic":"http://wx4.sinaimg.cn/thumbnail/005Rr6Tcgy1fcgre7knsrj30cu19642x.jpg","bmiddle_pic":"http://wx4.sinaimg.cn/bmiddle/005Rr6Tcgy1fcgre7knsrj30cu19642x.jpg","original_pic":"http://wx4.sinaimg.cn/large/005Rr6Tcgy1fcgre7knsrj30cu19642x.jpg","geo":null,"is_paid":false,"mblog_vip_type":0,"reposts_count":0,"comments_count":0,"attitudes_count":0,"pending_approval_count":0,"isLongText":false,"mlevel":0,"visible":{"type":0,"list_id":0},"biz_feature":0,"hasActionTypeCard":0,"darwin_tags":[],"hot_weibo_tags":[],"text_tag_tips":[],"userType":0,"more_info_type":0,"positive_recom_flag":0,"gif_ids":"","is_show_bulletin":2,"comment_manage_info":{"comment_permission_type":-1,"approval_comment_type":0}}
     * ptype : 0
     * allow_all_comment : true
     * avatar_large : http://tva1.sinaimg.cn/crop.0.0.200.200.180/005Fw52Bjw1ehshxg88jxj305k05kglj.jpg
     * avatar_hd : http://tva1.sinaimg.cn/crop.0.0.200.200.1024/005Fw52Bjw1ehshxg88jxj305k05kglj.jpg
     * verified_reason :
     * verified_trade :
     * verified_reason_url :
     * verified_source :
     * verified_source_url :
     * follow_me : true
     * like : false
     * like_me : false
     * online_status : 0
     * bi_followers_count : 736
     * lang : zh-cn
     * star : 0
     * mbtype : 0
     * mbrank : 0
     * block_word : 0
     * block_app : 0
     * credit_score : 80
     * user_ability : 0
     * urank : 25
     * story_read_state : -1
     * vclub_member : 0
     */

    private long id;
    private String idstr;
    @SerializedName("class")
    private long classX;
    private String screen_name;
    private String name;
    private String province;
    private String city;
    private String location;
    private String description;
    private String url;
    private String profile_image_url;
    private String profile_url;
    private String domain;
    private String weihao;
    private String gender;
    private long followers_count;
    private long friends_count;
    private long pagefriends_count;
    private long statuses_count;
    private long favourites_count;
    private String created_at;
    private boolean following;
    private boolean allow_all_act_msg;
    private boolean geo_enabled;
    private boolean verified;
    private long verified_type;
    private String remark;
    private InsecurityBean insecurity;
    private StatusBean status;
    private long ptype;
    private boolean allow_all_comment;
    private String avatar_large;
    private String avatar_hd;
    private String verified_reason;
    private String verified_trade;
    private String verified_reason_url;
    private String verified_source;
    private String verified_source_url;
    private boolean follow_me;
    private boolean like;
    private boolean like_me;
    private long online_status;
    private long bi_followers_count;
    private String lang;
    private long star;
    private long mbtype;
    private long mbrank;
    private long block_word;
    private long block_app;
    private long credit_score;
    private long user_ability;
    private long urank;
    private long story_read_state;
    private long vclub_member;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public long getClassX() {
        return classX;
    }

    public void setClassX(long classX) {
        this.classX = classX;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getWeihao() {
        return weihao;
    }

    public void setWeihao(String weihao) {
        this.weihao = weihao;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(long followers_count) {
        this.followers_count = followers_count;
    }

    public long getFriends_count() {
        return friends_count;
    }

    public void setFriends_count(long friends_count) {
        this.friends_count = friends_count;
    }

    public long getPagefriends_count() {
        return pagefriends_count;
    }

    public void setPagefriends_count(long pagefriends_count) {
        this.pagefriends_count = pagefriends_count;
    }

    public long getStatuses_count() {
        return statuses_count;
    }

    public void setStatuses_count(long statuses_count) {
        this.statuses_count = statuses_count;
    }

    public long getFavourites_count() {
        return favourites_count;
    }

    public void setFavourites_count(long favourites_count) {
        this.favourites_count = favourites_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public boolean isAllow_all_act_msg() {
        return allow_all_act_msg;
    }

    public void setAllow_all_act_msg(boolean allow_all_act_msg) {
        this.allow_all_act_msg = allow_all_act_msg;
    }

    public boolean isGeo_enabled() {
        return geo_enabled;
    }

    public void setGeo_enabled(boolean geo_enabled) {
        this.geo_enabled = geo_enabled;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public long getVerified_type() {
        return verified_type;
    }

    public void setVerified_type(long verified_type) {
        this.verified_type = verified_type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public InsecurityBean getInsecurity() {
        return insecurity;
    }

    public void setInsecurity(InsecurityBean insecurity) {
        this.insecurity = insecurity;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public long getPtype() {
        return ptype;
    }

    public void setPtype(long ptype) {
        this.ptype = ptype;
    }

    public boolean isAllow_all_comment() {
        return allow_all_comment;
    }

    public void setAllow_all_comment(boolean allow_all_comment) {
        this.allow_all_comment = allow_all_comment;
    }

    public String getAvatar_large() {
        return avatar_large;
    }

    public void setAvatar_large(String avatar_large) {
        this.avatar_large = avatar_large;
    }

    public String getAvatar_hd() {
        return avatar_hd;
    }

    public void setAvatar_hd(String avatar_hd) {
        this.avatar_hd = avatar_hd;
    }

    public String getVerified_reason() {
        return verified_reason;
    }

    public void setVerified_reason(String verified_reason) {
        this.verified_reason = verified_reason;
    }

    public String getVerified_trade() {
        return verified_trade;
    }

    public void setVerified_trade(String verified_trade) {
        this.verified_trade = verified_trade;
    }

    public String getVerified_reason_url() {
        return verified_reason_url;
    }

    public void setVerified_reason_url(String verified_reason_url) {
        this.verified_reason_url = verified_reason_url;
    }

    public String getVerified_source() {
        return verified_source;
    }

    public void setVerified_source(String verified_source) {
        this.verified_source = verified_source;
    }

    public String getVerified_source_url() {
        return verified_source_url;
    }

    public void setVerified_source_url(String verified_source_url) {
        this.verified_source_url = verified_source_url;
    }

    public boolean isFollow_me() {
        return follow_me;
    }

    public void setFollow_me(boolean follow_me) {
        this.follow_me = follow_me;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public boolean isLike_me() {
        return like_me;
    }

    public void setLike_me(boolean like_me) {
        this.like_me = like_me;
    }

    public long getOnline_status() {
        return online_status;
    }

    public void setOnline_status(long online_status) {
        this.online_status = online_status;
    }

    public long getBi_followers_count() {
        return bi_followers_count;
    }

    public void setBi_followers_count(long bi_followers_count) {
        this.bi_followers_count = bi_followers_count;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public long getStar() {
        return star;
    }

    public void setStar(long star) {
        this.star = star;
    }

    public long getMbtype() {
        return mbtype;
    }

    public void setMbtype(long mbtype) {
        this.mbtype = mbtype;
    }

    public long getMbrank() {
        return mbrank;
    }

    public void setMbrank(long mbrank) {
        this.mbrank = mbrank;
    }

    public long getBlock_word() {
        return block_word;
    }

    public void setBlock_word(long block_word) {
        this.block_word = block_word;
    }

    public long getBlock_app() {
        return block_app;
    }

    public void setBlock_app(long block_app) {
        this.block_app = block_app;
    }

    public long getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(long credit_score) {
        this.credit_score = credit_score;
    }

    public long getUser_ability() {
        return user_ability;
    }

    public void setUser_ability(long user_ability) {
        this.user_ability = user_ability;
    }

    public long getUrank() {
        return urank;
    }

    public void setUrank(long urank) {
        this.urank = urank;
    }

    public long getStory_read_state() {
        return story_read_state;
    }

    public void setStory_read_state(long story_read_state) {
        this.story_read_state = story_read_state;
    }

    public long getVclub_member() {
        return vclub_member;
    }

    public void setVclub_member(long vclub_member) {
        this.vclub_member = vclub_member;
    }

    public static class InsecurityBean {
        /**
         * sexual_content : false
         */

        private boolean sexual_content;

        public boolean isSexual_content() {
            return sexual_content;
        }

        public void setSexual_content(boolean sexual_content) {
            this.sexual_content = sexual_content;
        }
    }

    public static class StatusBean {
        /**
         * created_at : Sat Jun 10 17:02:34 +0800 2017
         * id : 4117136739618359
         * mid : 4117136739618359
         * idstr : 4117136739618359
         * text : ▽☻ΩΩΩΩΩΩ 小.鲜肉被美.女厕所强吻强摸强...誓死不从惨遭暴打[神马][哈哈][赞][爱你][耶]
         * textLength : 90
         * source_allowclick : 0
         * source_type : 1
         * source : <a href="http://app.weibo.com/t/feed/6vtZb0" rel="nofollow">微博 weibo.com</a>
         * favorited : false
         * truncated : false
         * in_reply_to_status_id :
         * in_reply_to_user_id :
         * in_reply_to_screen_name :
         * pic_urls : [{"thumbnail_pic":"http://wx4.sinaimg.cn/thumbnail/005Rr6Tcgy1fcgre7knsrj30cu19642x.jpg"}]
         * thumbnail_pic : http://wx4.sinaimg.cn/thumbnail/005Rr6Tcgy1fcgre7knsrj30cu19642x.jpg
         * bmiddle_pic : http://wx4.sinaimg.cn/bmiddle/005Rr6Tcgy1fcgre7knsrj30cu19642x.jpg
         * original_pic : http://wx4.sinaimg.cn/large/005Rr6Tcgy1fcgre7knsrj30cu19642x.jpg
         * geo : null
         * is_paid : false
         * mblog_vip_type : 0
         * reposts_count : 0
         * comments_count : 0
         * attitudes_count : 0
         * pending_approval_count : 0
         * isLongText : false
         * mlevel : 0
         * visible : {"type":0,"list_id":0}
         * biz_feature : 0
         * hasActionTypeCard : 0
         * darwin_tags : []
         * hot_weibo_tags : []
         * text_tag_tips : []
         * userType : 0
         * more_info_type : 0
         * positive_recom_flag : 0
         * gif_ids :
         * is_show_bulletin : 2
         * comment_manage_info : {"comment_permission_type":-1,"approval_comment_type":0}
         */

        private String created_at;
        private long id;
        private String mid;
        private String idstr;
        private String text;
        private long textLength;
        private long source_allowclick;
        private long source_type;
        private String source;
        private boolean favorited;
        private boolean truncated;
        private String in_reply_to_status_id;
        private String in_reply_to_user_id;
        private String in_reply_to_screen_name;
        private String thumbnail_pic;
        private String bmiddle_pic;
        private String original_pic;
        private Object geo;
        private boolean is_paid;
        private long mblog_vip_type;
        private long reposts_count;
        private long comments_count;
        private long attitudes_count;
        private long pending_approval_count;
        private boolean isLongText;
        private long mlevel;
        private VisibleBean visible;
        private long biz_feature;
        private long hasActionTypeCard;
        private long userType;
        private long more_info_type;
        private long positive_recom_flag;
        private String gif_ids;
        private long is_show_bulletin;
        private CommentManageInfoBean comment_manage_info;
        private List<PicUrlsBean> pic_urls;
        private List<?> darwin_tags;
        private List<?> hot_weibo_tags;
        private List<?> text_tag_tips;

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getIdstr() {
            return idstr;
        }

        public void setIdstr(String idstr) {
            this.idstr = idstr;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public long getTextLength() {
            return textLength;
        }

        public void setTextLength(long textLength) {
            this.textLength = textLength;
        }

        public long getSource_allowclick() {
            return source_allowclick;
        }

        public void setSource_allowclick(long source_allowclick) {
            this.source_allowclick = source_allowclick;
        }

        public long getSource_type() {
            return source_type;
        }

        public void setSource_type(long source_type) {
            this.source_type = source_type;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public boolean isFavorited() {
            return favorited;
        }

        public void setFavorited(boolean favorited) {
            this.favorited = favorited;
        }

        public boolean isTruncated() {
            return truncated;
        }

        public void setTruncated(boolean truncated) {
            this.truncated = truncated;
        }

        public String getIn_reply_to_status_id() {
            return in_reply_to_status_id;
        }

        public void setIn_reply_to_status_id(String in_reply_to_status_id) {
            this.in_reply_to_status_id = in_reply_to_status_id;
        }

        public String getIn_reply_to_user_id() {
            return in_reply_to_user_id;
        }

        public void setIn_reply_to_user_id(String in_reply_to_user_id) {
            this.in_reply_to_user_id = in_reply_to_user_id;
        }

        public String getIn_reply_to_screen_name() {
            return in_reply_to_screen_name;
        }

        public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
            this.in_reply_to_screen_name = in_reply_to_screen_name;
        }

        public String getThumbnail_pic() {
            return thumbnail_pic;
        }

        public void setThumbnail_pic(String thumbnail_pic) {
            this.thumbnail_pic = thumbnail_pic;
        }

        public String getBmiddle_pic() {
            return bmiddle_pic;
        }

        public void setBmiddle_pic(String bmiddle_pic) {
            this.bmiddle_pic = bmiddle_pic;
        }

        public String getOriginal_pic() {
            return original_pic;
        }

        public void setOriginal_pic(String original_pic) {
            this.original_pic = original_pic;
        }

        public Object getGeo() {
            return geo;
        }

        public void setGeo(Object geo) {
            this.geo = geo;
        }

        public boolean isIs_paid() {
            return is_paid;
        }

        public void setIs_paid(boolean is_paid) {
            this.is_paid = is_paid;
        }

        public long getMblog_vip_type() {
            return mblog_vip_type;
        }

        public void setMblog_vip_type(long mblog_vip_type) {
            this.mblog_vip_type = mblog_vip_type;
        }

        public long getReposts_count() {
            return reposts_count;
        }

        public void setReposts_count(long reposts_count) {
            this.reposts_count = reposts_count;
        }

        public long getComments_count() {
            return comments_count;
        }

        public void setComments_count(long comments_count) {
            this.comments_count = comments_count;
        }

        public long getAttitudes_count() {
            return attitudes_count;
        }

        public void setAttitudes_count(long attitudes_count) {
            this.attitudes_count = attitudes_count;
        }

        public long getPending_approval_count() {
            return pending_approval_count;
        }

        public void setPending_approval_count(long pending_approval_count) {
            this.pending_approval_count = pending_approval_count;
        }

        public boolean isIsLongText() {
            return isLongText;
        }

        public void setIsLongText(boolean isLongText) {
            this.isLongText = isLongText;
        }

        public long getMlevel() {
            return mlevel;
        }

        public void setMlevel(long mlevel) {
            this.mlevel = mlevel;
        }

        public VisibleBean getVisible() {
            return visible;
        }

        public void setVisible(VisibleBean visible) {
            this.visible = visible;
        }

        public long getBiz_feature() {
            return biz_feature;
        }

        public void setBiz_feature(long biz_feature) {
            this.biz_feature = biz_feature;
        }

        public long getHasActionTypeCard() {
            return hasActionTypeCard;
        }

        public void setHasActionTypeCard(long hasActionTypeCard) {
            this.hasActionTypeCard = hasActionTypeCard;
        }

        public long getUserType() {
            return userType;
        }

        public void setUserType(long userType) {
            this.userType = userType;
        }

        public long getMore_info_type() {
            return more_info_type;
        }

        public void setMore_info_type(long more_info_type) {
            this.more_info_type = more_info_type;
        }

        public long getPositive_recom_flag() {
            return positive_recom_flag;
        }

        public void setPositive_recom_flag(long positive_recom_flag) {
            this.positive_recom_flag = positive_recom_flag;
        }

        public String getGif_ids() {
            return gif_ids;
        }

        public void setGif_ids(String gif_ids) {
            this.gif_ids = gif_ids;
        }

        public long getIs_show_bulletin() {
            return is_show_bulletin;
        }

        public void setIs_show_bulletin(long is_show_bulletin) {
            this.is_show_bulletin = is_show_bulletin;
        }

        public CommentManageInfoBean getComment_manage_info() {
            return comment_manage_info;
        }

        public void setComment_manage_info(CommentManageInfoBean comment_manage_info) {
            this.comment_manage_info = comment_manage_info;
        }

        public List<PicUrlsBean> getPic_urls() {
            return pic_urls;
        }

        public void setPic_urls(List<PicUrlsBean> pic_urls) {
            this.pic_urls = pic_urls;
        }

        public List<?> getDarwin_tags() {
            return darwin_tags;
        }

        public void setDarwin_tags(List<?> darwin_tags) {
            this.darwin_tags = darwin_tags;
        }

        public List<?> getHot_weibo_tags() {
            return hot_weibo_tags;
        }

        public void setHot_weibo_tags(List<?> hot_weibo_tags) {
            this.hot_weibo_tags = hot_weibo_tags;
        }

        public List<?> getText_tag_tips() {
            return text_tag_tips;
        }

        public void setText_tag_tips(List<?> text_tag_tips) {
            this.text_tag_tips = text_tag_tips;
        }

        public static class VisibleBean {
            /**
             * type : 0
             * list_id : 0
             */

            private long type;
            private long list_id;

            public long getType() {
                return type;
            }

            public void setType(long type) {
                this.type = type;
            }

            public long getList_id() {
                return list_id;
            }

            public void setList_id(long list_id) {
                this.list_id = list_id;
            }
        }

        public static class CommentManageInfoBean {
            /**
             * comment_permission_type : -1
             * approval_comment_type : 0
             */

            private long comment_permission_type;
            private long approval_comment_type;

            public long getComment_permission_type() {
                return comment_permission_type;
            }

            public void setComment_permission_type(long comment_permission_type) {
                this.comment_permission_type = comment_permission_type;
            }

            public long getApproval_comment_type() {
                return approval_comment_type;
            }

            public void setApproval_comment_type(long approval_comment_type) {
                this.approval_comment_type = approval_comment_type;
            }
        }

        public static class PicUrlsBean {
            /**
             * thumbnail_pic : http://wx4.sinaimg.cn/thumbnail/005Rr6Tcgy1fcgre7knsrj30cu19642x.jpg
             */

            private String thumbnail_pic;

            public String getThumbnail_pic() {
                return thumbnail_pic;
            }

            public void setThumbnail_pic(String thumbnail_pic) {
                this.thumbnail_pic = thumbnail_pic;
            }
        }
    }
}
