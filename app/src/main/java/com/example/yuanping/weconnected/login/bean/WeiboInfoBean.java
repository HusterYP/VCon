package com.example.yuanping.weconnected.login.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static android.R.attr.type;

/**
 * Created by yuanping on 11/4/17.
 */

public class WeiboInfoBean {

    private boolean hasvisible;
    private long previous_cursor;
    private long next_cursor;
    private long total_number;
    private long since_id;
    private long max_id;
    private StatusBean status;
    private List<CommentsBean> comments;
    private List<?> marks;

    public boolean isHasvisible() {
        return hasvisible;
    }

    public void setHasvisible(boolean hasvisible) {
        this.hasvisible = hasvisible;
    }

    public long getPrevious_cursor() {
        return previous_cursor;
    }

    public void setPrevious_cursor(long previous_cursor) {
        this.previous_cursor = previous_cursor;
    }

    public long getNext_cursor() {
        return next_cursor;
    }

    public void setNext_cursor(long next_cursor) {
        this.next_cursor = next_cursor;
    }

    public long getTotal_number() {
        return total_number;
    }

    public void setTotal_number(long total_number) {
        this.total_number = total_number;
    }

    public long getSince_id() {
        return since_id;
    }

    public void setSince_id(long since_id) {
        this.since_id = since_id;
    }

    public long getMax_id() {
        return max_id;
    }

    public void setMax_id(long max_id) {
        this.max_id = max_id;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public List<?> getMarks() {
        return marks;
    }

    public void setMarks(List<?> marks) {
        this.marks = marks;
    }

    public static class StatusBean {

        private String created_at;
        private long id;
        private String mid;
        private String idstr;
        private String text;
        private long source_allowclick;
        private long source_type;
        private String source;
        private boolean favorited;
        private boolean truncated;
        private String in_reply_to_status_id;
        private String in_reply_to_user_id;
        private String in_reply_to_screen_name;
        private Object geo;
        private boolean is_paid;
        private long mblog_vip_type;
        private UserBean user;
        private RetweetedStatusBean retweeted_status;
        private long reposts_count;
        private long comments_count;
        private long attitudes_count;
        private long pending_approval_count;
        private boolean isLongText;
        private long mlevel;
        private VisibleBeanX visible;
        private long biz_feature;
        private long hasActionTypeCard;
        private long userType;
        private long more_info_type;
        private long positive_recom_flag;
        private String gif_ids;
        private long is_show_bulletin;
        private CommentManageInfoBeanX comment_manage_info;
        private List<?> pic_urls;
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

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public RetweetedStatusBean getRetweeted_status() {
            return retweeted_status;
        }

        public void setRetweeted_status(RetweetedStatusBean retweeted_status) {
            this.retweeted_status = retweeted_status;
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

        public VisibleBeanX getVisible() {
            return visible;
        }

        public void setVisible(VisibleBeanX visible) {
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

        public CommentManageInfoBeanX getComment_manage_info() {
            return comment_manage_info;
        }

        public void setComment_manage_info(CommentManageInfoBeanX comment_manage_info) {
            this.comment_manage_info = comment_manage_info;
        }

        public List<?> getPic_urls() {
            return pic_urls;
        }

        public void setPic_urls(List<?> pic_urls) {
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

        public static class UserBean {
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
            private String cover_image_phone;
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
            private long ptype;
            private boolean allow_all_comment;
            private String avatar_large;
            private String avatar_hd;
            private String verified_reason;
            private String verified_trade;
            private String verified_reason_url;
            private String verified_source;
            private String verified_source_url;
            private long verified_state;
            private long verified_level;
            private long verified_type_ext;
            private boolean has_service_tel;
            private String verified_reason_modified;
            private String verified_contact_name;
            private String verified_contact_email;
            private String verified_contact_mobile;
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

            public String getCover_image_phone() {
                return cover_image_phone;
            }

            public void setCover_image_phone(String cover_image_phone) {
                this.cover_image_phone = cover_image_phone;
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

            public long getVerified_state() {
                return verified_state;
            }

            public void setVerified_state(long verified_state) {
                this.verified_state = verified_state;
            }

            public long getVerified_level() {
                return verified_level;
            }

            public void setVerified_level(long verified_level) {
                this.verified_level = verified_level;
            }

            public long getVerified_type_ext() {
                return verified_type_ext;
            }

            public void setVerified_type_ext(long verified_type_ext) {
                this.verified_type_ext = verified_type_ext;
            }

            public boolean isHas_service_tel() {
                return has_service_tel;
            }

            public void setHas_service_tel(boolean has_service_tel) {
                this.has_service_tel = has_service_tel;
            }

            public String getVerified_reason_modified() {
                return verified_reason_modified;
            }

            public void setVerified_reason_modified(String verified_reason_modified) {
                this.verified_reason_modified = verified_reason_modified;
            }

            public String getVerified_contact_name() {
                return verified_contact_name;
            }

            public void setVerified_contact_name(String verified_contact_name) {
                this.verified_contact_name = verified_contact_name;
            }

            public String getVerified_contact_email() {
                return verified_contact_email;
            }

            public void setVerified_contact_email(String verified_contact_email) {
                this.verified_contact_email = verified_contact_email;
            }

            public String getVerified_contact_mobile() {
                return verified_contact_mobile;
            }

            public void setVerified_contact_mobile(String verified_contact_mobile) {
                this.verified_contact_mobile = verified_contact_mobile;
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

            public void setMbtype(long  mbtype) {
                this.mbtype = mbtype;
            }

            public long getMbrank() {
                return mbrank;
            }

            public void setMbrank (long mbrank) {
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
        }

        public static class RetweetedStatusBean {
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
            private UserBeanX user;
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

            public UserBeanX getUser() {
                return user;
            }

            public void setUser(UserBeanX user) {
                this.user = user;
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

            public static class UserBeanX {
                /**
                 * id : 2219227283
                 * idstr : 2219227283
                 * class : 1
                 * screen_name : 咱们去旅游
                 * name : 咱们去旅游
                 * province : 44
                 * city : 1
                 * location : 广东 广州
                 * description : 牵起手，一起去旅游，看最温暖的风景，让你走进如画的世界，感受大自然带来的快乐 | 合作QQ：800066203
                 * url : http://www.qugg365.com/
                 * profile_image_url : http://tva3.sinaimg.cn/crop.0.0.180.180.50/8446b893jw1e8qgp5bmzyj2050050aa8.jpg
                 * profile_url : u/2219227283
                 * domain :
                 * weihao :
                 * gender : m
                 * followers_count : 1840692
                 * friends_count : 44
                 * pagefriends_count : 0
                 * statuses_count : 9622
                 * favourites_count : 2
                 * created_at : Wed Jul 06 00:49:12 +0800 2011
                 * following : false
                 * allow_all_act_msg : true
                 * geo_enabled : true
                 * verified : true
                 * verified_type : 0
                 * remark :
                 * insecurity : {"sexual_content":false}
                 * ptype : 0
                 * allow_all_comment : true
                 * avatar_large : http://tva3.sinaimg.cn/crop.0.0.180.180.180/8446b893jw1e8qgp5bmzyj2050050aa8.jpg
                 * avatar_hd : http://tva3.sinaimg.cn/crop.0.0.180.180.1024/8446b893jw1e8qgp5bmzyj2050050aa8.jpg
                 * verified_reason : 知名旅游博主
                 * verified_trade :
                 * verified_reason_url :
                 * verified_source :
                 * verified_source_url :
                 * verified_state : 0
                 * verified_level : 3
                 * verified_type_ext : 1
                 * has_service_tel : false
                 * verified_reason_modified :
                 * verified_contact_name :
                 * verified_contact_email :
                 * verified_contact_mobile :
                 * follow_me : false
                 * like : false
                 * like_me : false
                 * online_status : 0
                 * bi_followers_count : 2
                 * lang : zh-cn
                 * star : 0
                 * mbtype : 12
                 * mbrank : 6
                 * block_word : 0
                 * block_app : 1
                 * credit_score : 80
                 * user_ability : 776
                 * urank : 39
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
                private InsecurityBeanX insecurity;
                private long ptype;
                private boolean allow_all_comment;
                private String avatar_large;
                private String avatar_hd;
                private String verified_reason;
                private String verified_trade;
                private String verified_reason_url;
                private String verified_source;
                private String verified_source_url;
                private long verified_state;
                private long verified_level;
                private long verified_type_ext;
                private boolean has_service_tel;
                private String verified_reason_modified;
                private String verified_contact_name;
                private String verified_contact_email;
                private String verified_contact_mobile;
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

                public InsecurityBeanX getInsecurity() {
                    return insecurity;
                }

                public void setInsecurity(InsecurityBeanX insecurity) {
                    this.insecurity = insecurity;
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

                public long getVerified_state() {
                    return verified_state;
                }

                public void setVerified_state(long verified_state) {
                    this.verified_state = verified_state;
                }

                public long getVerified_level() {
                    return verified_level;
                }

                public void setVerified_level(long verified_level) {
                    this.verified_level = verified_level;
                }

                public long getVerified_type_ext() {
                    return verified_type_ext;
                }

                public void setVerified_type_ext(long verified_type_ext) {
                    this.verified_type_ext = verified_type_ext;
                }

                public boolean isHas_service_tel() {
                    return has_service_tel;
                }

                public void setHas_service_tel(boolean has_service_tel) {
                    this.has_service_tel = has_service_tel;
                }

                public String getVerified_reason_modified() {
                    return verified_reason_modified;
                }

                public void setVerified_reason_modified(String verified_reason_modified) {
                    this.verified_reason_modified = verified_reason_modified;
                }

                public String getVerified_contact_name() {
                    return verified_contact_name;
                }

                public void setVerified_contact_name(String verified_contact_name) {
                    this.verified_contact_name = verified_contact_name;
                }

                public String getVerified_contact_email() {
                    return verified_contact_email;
                }

                public void setVerified_contact_email(String verified_contact_email) {
                    this.verified_contact_email = verified_contact_email;
                }

                public String getVerified_contact_mobile() {
                    return verified_contact_mobile;
                }

                public void setVerified_contact_mobile(String verified_contact_mobile) {
                    this.verified_contact_mobile = verified_contact_mobile;
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

                public static class InsecurityBeanX {
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

                private String thumbnail_pic;

                public String getThumbnail_pic() {
                    return thumbnail_pic;
                }

                public void setThumbnail_pic(String thumbnail_pic) {
                    this.thumbnail_pic = thumbnail_pic;
                }
            }
        }

        public static class VisibleBeanX {
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

        public static class CommentManageInfoBeanX {
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
    }

    public static class CommentsBean {

        private String created_at;
        private long id;
        private long rootid;
        private long floor_number;
        private String text;
        private long disable_reply;
        private long source_allowclick;
        private long source_type;
        private String source;
        private UserBeanXX user;
        private String mid;
        private String idstr;
        private StatusBeanX status;

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

        public long getRootid() {
            return rootid;
        }

        public void setRootid(long rootid) {
            this.rootid = rootid;
        }

        public long getFloor_number() {
            return floor_number;
        }

        public void setFloor_number(long floor_number) {
            this.floor_number = floor_number;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public long getDisable_reply() {
            return disable_reply;
        }

        public void setDisable_reply(long disable_reply) {
            this.disable_reply = disable_reply;
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

        public UserBeanXX getUser() {
            return user;
        }

        public void setUser(UserBeanXX user) {
            this.user = user;
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

        public StatusBeanX getStatus() {
            return status;
        }

        public void setStatus(StatusBeanX status) {
            this.status = status;
        }

        public static class UserBeanXX {

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
            private String cover_image_phone;
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
            private InsecurityBeanXX insecurity;
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
            private long level;
            private long type;
            private long ulevel;
            private BadgeBean badge;
            private String badge_top;
            private long has_ability_tag;
            private ExtendBean extend;
            private long credit_score;
            private long user_ability;
            private String cardid;
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

            public String getCover_image_phone() {
                return cover_image_phone;
            }

            public void setCover_image_phone(String cover_image_phone) {
                this.cover_image_phone = cover_image_phone;
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

            public InsecurityBeanXX getInsecurity() {
                return insecurity;
            }

            public void setInsecurity(InsecurityBeanXX insecurity) {
                this.insecurity = insecurity;
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

            public long getLevel() {
                return level;
            }

            public void setLevel(long level) {
                this.level = level;
            }

            public long getType() {
                return type;
            }

            public void setType(long type) {
                this.type = type;
            }

            public long getUlevel() {
                return ulevel;
            }

            public void setUlevel(long ulevel) {
                this.ulevel = ulevel;
            }

            public BadgeBean getBadge() {
                return badge;
            }

            public void setBadge(BadgeBean badge) {
                this.badge = badge;
            }

            public String getBadge_top() {
                return badge_top;
            }

            public void setBadge_top(String badge_top) {
                this.badge_top = badge_top;
            }

            public long getHas_ability_tag() {
                return has_ability_tag;
            }

            public void setHas_ability_tag(long has_ability_tag) {
                this.has_ability_tag = has_ability_tag;
            }

            public ExtendBean getExtend() {
                return extend;
            }

            public void setExtend(ExtendBean extend) {
                this.extend = extend;
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

            public String getCardid() {
                return cardid;
            }

            public void setCardid(String cardid) {
                this.cardid = cardid;
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

            public static class InsecurityBeanXX {
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

            public static class BadgeBean {
                private long uc_domain;
                private long enterprise;
                private long anniversary;
                private long taobao;
                private long gongyi;
                private long gongyi_level;
                private long bind_taobao;
                private long dailv;
                private long zongyiji;
                private long vip_activity1;
                private long unread_pool;
                private long daiyan;
                private long ali_1688;
                private long vip_activity2;
                private long fools_day_2016;
                private long uefa_euro_2016;
                private long unread_pool_ext;
                private long self_media;
                private long olympic_2016;
                private long dzwbqlx_2016;
                private long discount_2016;
                private long follow_whitelist_video;
                private long league_badge;
                private long suishoupai_2017;
                private long lol_msi_2017;
                private long super_star_2017;
                private long video_attention;
                private long travel_2017;
                private long lol_gm_2017;
                private long cz_wed_2017;
                private long inspector;

                public long getUc_domain() {
                    return uc_domain;
                }

                public void setUc_domain(long uc_domain) {
                    this.uc_domain = uc_domain;
                }

                public long getEnterprise() {
                    return enterprise;
                }

                public void setEnterprise(long enterprise) {
                    this.enterprise = enterprise;
                }

                public long getAnniversary() {
                    return anniversary;
                }

                public void setAnniversary(long  anniversary) {
                    this.anniversary = anniversary;
                }

                public long getTaobao() {
                    return taobao;
                }

                public void setTaobao(long taobao) {
                    this.taobao = taobao;
                }

                public long getGongyi() {
                    return gongyi;
                }

                public void setGongyi(long gongyi) {
                    this.gongyi = gongyi;
                }

                public long getGongyi_level() {
                    return gongyi_level;
                }

                public void setGongyi_level(long gongyi_level) {
                    this.gongyi_level = gongyi_level;
                }

                public long getBind_taobao() {
                    return bind_taobao;
                }

                public void setBind_taobao(long bind_taobao) {
                    this.bind_taobao = bind_taobao;
                }

                public long getDailv() {
                    return dailv;
                }

                public void setDailv(long dailv) {
                    this.dailv = dailv;
                }

                public long getZongyiji() {
                    return zongyiji;
                }

                public void setZongyiji(long zongyiji) {
                    this.zongyiji = zongyiji;
                }

                public long getVip_activity1() {
                    return vip_activity1;
                }

                public void setVip_activity1(long vip_activity1) {
                    this.vip_activity1 = vip_activity1;
                }

                public long getUnread_pool() {
                    return unread_pool;
                }

                public void setUnread_pool(long unread_pool) {
                    this.unread_pool = unread_pool;
                }

                public long getDaiyan() {
                    return daiyan;
                }

                public void setDaiyan(long daiyan) {
                    this.daiyan = daiyan;
                }

                public long getAli_1688() {
                    return ali_1688;
                }

                public void setAli_1688(long  ali_1688) {
                    this.ali_1688 = ali_1688;
                }

                public long getVip_activity2() {
                    return vip_activity2;
                }

                public void setVip_activity2(long  vip_activity2) {
                    this.vip_activity2 = vip_activity2;
                }

                public long getFools_day_2016() {
                    return fools_day_2016;
                }

                public void setFools_day_2016(long fools_day_2016) {
                    this.fools_day_2016 = fools_day_2016;
                }

                public long getUefa_euro_2016() {
                    return uefa_euro_2016;
                }

                public void setUefa_euro_2016(long uefa_euro_2016) {
                    this.uefa_euro_2016 = uefa_euro_2016;
                }

                public long getUnread_pool_ext() {
                    return unread_pool_ext;
                }

                public void setUnread_pool_ext(long unread_pool_ext) {
                    this.unread_pool_ext = unread_pool_ext;
                }

                public long getSelf_media() {
                    return self_media;
                }

                public void setSelf_media(long self_media) {
                    this.self_media = self_media;
                }

                public long getOlympic_2016() {
                    return olympic_2016;
                }

                public void setOlympic_2016(long olympic_2016) {
                    this.olympic_2016 = olympic_2016;
                }

                public long getDzwbqlx_2016() {
                    return dzwbqlx_2016;
                }

                public void setDzwbqlx_2016(long dzwbqlx_2016) {
                    this.dzwbqlx_2016 = dzwbqlx_2016;
                }

                public long getDiscount_2016() {
                    return discount_2016;
                }

                public void setDiscount_2016(long discount_2016) {
                    this.discount_2016 = discount_2016;
                }

                public long getFollow_whitelist_video() {
                    return follow_whitelist_video;
                }

                public void setFollow_whitelist_video(long follow_whitelist_video) {
                    this.follow_whitelist_video = follow_whitelist_video;
                }

                public long getLeague_badge() {
                    return league_badge;
                }

                public void setLeague_badge(long league_badge) {
                    this.league_badge = league_badge;
                }

                public long getSuishoupai_2017() {
                    return suishoupai_2017;
                }

                public void setSuishoupai_2017(long suishoupai_2017) {
                    this.suishoupai_2017 = suishoupai_2017;
                }

                public long getLol_msi_2017() {
                    return lol_msi_2017;
                }

                public void setLol_msi_2017(long lol_msi_2017) {
                    this.lol_msi_2017 = lol_msi_2017;
                }

                public long getSuper_star_2017() {
                    return super_star_2017;
                }

                public void setSuper_star_2017(long super_star_2017) {
                    this.super_star_2017 = super_star_2017;
                }

                public long getVideo_attention() {
                    return video_attention;
                }

                public void setVideo_attention(long video_attention) {
                    this.video_attention = video_attention;
                }

                public long getTravel_2017() {
                    return travel_2017;
                }

                public void setTravel_2017(long travel_2017) {
                    this.travel_2017 = travel_2017;
                }

                public long getLol_gm_2017() {
                    return lol_gm_2017;
                }

                public void setLol_gm_2017(long lol_gm_2017) {
                    this.lol_gm_2017 = lol_gm_2017;
                }

                public long getCz_wed_2017() {
                    return cz_wed_2017;
                }

                public void setCz_wed_2017(long cz_wed_2017) {
                    this.cz_wed_2017 = cz_wed_2017;
                }

                public long getInspector() {
                    return inspector;
                }

                public void setInspector(long inspector) {
                    this.inspector = inspector;
                }
            }

            public static class ExtendBean {
                /**
                 * privacy : {"mobile":1}
                 * mbprivilege : 0000000000000000000000000000000000000000000000000000000000000000
                 */

                private PrivacyBean privacy;
                private String mbprivilege;

                public PrivacyBean getPrivacy() {
                    return privacy;
                }

                public void setPrivacy(PrivacyBean privacy) {
                    this.privacy = privacy;
                }

                public String getMbprivilege() {
                    return mbprivilege;
                }

                public void setMbprivilege(String mbprivilege) {
                    this.mbprivilege = mbprivilege;
                }

                public static class PrivacyBean {
                    /**
                     * mobile : 1
                     */

                    private long mobile;

                    public long getMobile() {
                        return mobile;
                    }

                    public void setMobile(long mobile) {
                        this.mobile = mobile;
                    }
                }
            }
        }

        public static class StatusBeanX {

            private String created_at;
            private long id;
            private String mid;
            private String idstr;
            private String text;
            private long source_allowclick;
            private long source_type;
            private String source;
            private long appid;
            private boolean favorited;
            private boolean truncated;
            private String in_reply_to_status_id;
            private String in_reply_to_user_id;
            private String in_reply_to_screen_name;
            private Object geo;
            private boolean is_paid;
            private long mblog_vip_type;
            private UserBeanXXX user;
            private RetweetedStatusBeanX retweeted_status;
            private long reposts_count;
            private long comments_count;
            private long attitudes_count;
            private long pending_approval_count;
            private boolean isLongText;
            private long mlevel;
            private VisibleBeanXXX visible;
            private long biz_feature;
            private long hasActionTypeCard;
            private long userType;
            private long more_info_type;
            private long positive_recom_flag;
            private String gif_ids;
            private long is_show_bulletin;
            private CommentManageInfoBeanXXX comment_manage_info;
            private List<?> pic_ids;
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

            public long getAppid() {
                return appid;
            }

            public void setAppid(long appid) {
                this.appid = appid;
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

            public UserBeanXXX getUser() {
                return user;
            }

            public void setUser(UserBeanXXX user) {
                this.user = user;
            }

            public RetweetedStatusBeanX getRetweeted_status() {
                return retweeted_status;
            }

            public void setRetweeted_status(RetweetedStatusBeanX retweeted_status) {
                this.retweeted_status = retweeted_status;
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

            public VisibleBeanXXX getVisible() {
                return visible;
            }

            public void setVisible(VisibleBeanXXX visible) {
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

            public void setUserTypel(long userType) {
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

            public CommentManageInfoBeanXXX getComment_manage_info() {
                return comment_manage_info;
            }

            public void setComment_manage_info(CommentManageInfoBeanXXX comment_manage_info) {
                this.comment_manage_info = comment_manage_info;
            }

            public List<?> getPic_ids() {
                return pic_ids;
            }

            public void setPic_ids(List<?> pic_ids) {
                this.pic_ids = pic_ids;
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

            public static class UserBeanXXX {

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
                private String cover_image_phone;
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
                private InsecurityBeanXXX insecurity;
                private long ptype;
                private boolean allow_all_comment;
                private String avatar_large;
                private String avatar_hd;
                private String verified_reason;
                private String verified_trade;
                private String verified_reason_url;
                private String verified_source;
                private String verified_source_url;
                private long verified_state;
                private long verified_level;
                private long verified_type_ext;
                private boolean has_service_tel;
                private String verified_reason_modified;
                private String verified_contact_name;
                private String verified_contact_email;
                private String verified_contact_mobile;
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
                private long level;
                private long type;
                private long ulevel;
                private BadgeBeanX badge;
                private String badge_top;
                private long has_ability_tag;
                private ExtendBeanX extend;
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

                public String getCover_image_phone() {
                    return cover_image_phone;
                }

                public void setCover_image_phone(String cover_image_phone) {
                    this.cover_image_phone = cover_image_phone;
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

                public InsecurityBeanXXX getInsecurity() {
                    return insecurity;
                }

                public void setInsecurity(InsecurityBeanXXX insecurity) {
                    this.insecurity = insecurity;
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

                public long getVerified_state() {
                    return verified_state;
                }

                public void setVerified_state(long verified_state) {
                    this.verified_state = verified_state;
                }

                public long getVerified_level() {
                    return verified_level;
                }

                public void setVerified_level(long verified_level) {
                    this.verified_level = verified_level;
                }

                public long getVerified_type_ext() {
                    return verified_type_ext;
                }

                public void setVerified_type_ext(long verified_type_ext) {
                    this.verified_type_ext = verified_type_ext;
                }

                public boolean isHas_service_tel() {
                    return has_service_tel;
                }

                public void setHas_service_tel(boolean has_service_tel) {
                    this.has_service_tel = has_service_tel;
                }

                public String getVerified_reason_modified() {
                    return verified_reason_modified;
                }

                public void setVerified_reason_modified(String verified_reason_modified) {
                    this.verified_reason_modified = verified_reason_modified;
                }

                public String getVerified_contact_name() {
                    return verified_contact_name;
                }

                public void setVerified_contact_name(String verified_contact_name) {
                    this.verified_contact_name = verified_contact_name;
                }

                public String getVerified_contact_email() {
                    return verified_contact_email;
                }

                public void setVerified_contact_email(String verified_contact_email) {
                    this.verified_contact_email = verified_contact_email;
                }

                public String getVerified_contact_mobile() {
                    return verified_contact_mobile;
                }

                public void setVerified_contact_mobile(String verified_contact_mobile) {
                    this.verified_contact_mobile = verified_contact_mobile;
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

                public long getLevel() {
                    return level;
                }

                public void setLevel(long level) {
                    this.level = level;
                }

                public long getType() {
                    return type;
                }

                public void setType(long type) {
                    this.type = type;
                }

                public long getUlevel() {
                    return ulevel;
                }

                public void setUlevel(long ulevel) {
                    this.ulevel = ulevel;
                }

                public BadgeBeanX getBadge() {
                    return badge;
                }

                public void setBadge(BadgeBeanX badge) {
                    this.badge = badge;
                }

                public String getBadge_top() {
                    return badge_top;
                }

                public void setBadge_top(String badge_top) {
                    this.badge_top = badge_top;
                }

                public long getHas_ability_tag() {
                    return has_ability_tag;
                }

                public void setHas_ability_tag(long has_ability_tag) {
                    this.has_ability_tag = has_ability_tag;
                }

                public ExtendBeanX getExtend() {
                    return extend;
                }

                public void setExtend(ExtendBeanX extend) {
                    this.extend = extend;
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

                public static class InsecurityBeanXXX {
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

                public static class BadgeBeanX {


                    private long uc_domain;
                    private long enterprise;
                    private long anniversary;
                    private long taobao;
                    private long gongyi;
                    private long gongyi_level;
                    private long bind_taobao;
                    private long dailv;
                    private long zongyiji;
                    private long vip_activity1;
                    private long unread_pool;
                    private long daiyan;
                    private long ali_1688;
                    private long vip_activity2;
                    private long fools_day_2016;
                    private long uefa_euro_2016;
                    private long unread_pool_ext;
                    private long self_media;
                    private long olympic_2016;
                    private long dzwbqlx_2016;
                    private long discount_2016;
                    private long follow_whitelist_video;
                    private long league_badge;
                    private long suishoupai_2017;
                    private long lol_msi_2017;
                    private long super_star_2017;
                    private long video_attention;
                    private long travel_2017;
                    private long lol_gm_2017;
                    private long cz_wed_2017;
                    private long inspector;

                    public long getUc_domain() {
                        return uc_domain;
                    }

                    public void setUc_domain(long uc_domain) {
                        this.uc_domain = uc_domain;
                    }

                    public long getEnterprise() {
                        return enterprise;
                    }

                    public void setEnterprise(long enterprise) {
                        this.enterprise = enterprise;
                    }

                    public long getAnniversary() {
                        return anniversary;
                    }

                    public void setAnniversary(long anniversary) {
                        this.anniversary = anniversary;
                    }

                    public long getTaobao() {
                        return taobao;
                    }

                    public void setTaobao(long taobao) {
                        this.taobao = taobao;
                    }

                    public long getGongyi() {
                        return gongyi;
                    }

                    public void setGongyi(long gongyi) {
                        this.gongyi = gongyi;
                    }

                    public long getGongyi_level() {
                        return gongyi_level;
                    }

                    public void setGongyi_level(long gongyi_level) {
                        this.gongyi_level = gongyi_level;
                    }

                    public long getBind_taobao() {
                        return bind_taobao;
                    }

                    public void setBind_taobao(long bind_taobao) {
                        this.bind_taobao = bind_taobao;
                    }

                    public long getDailv() {
                        return dailv;
                    }

                    public void setDailv(long  dailv) {
                        this.dailv = dailv;
                    }

                    public long getZongyiji() {
                        return zongyiji;
                    }

                    public void setZongyiji(long  zongyiji) {
                        this.zongyiji = zongyiji;
                    }

                    public long getVip_activity1() {
                        return vip_activity1;
                    }

                    public void setVip_activity1(long vip_activity1) {
                        this.vip_activity1 = vip_activity1;
                    }

                    public long getUnread_pool() {
                        return unread_pool;
                    }

                    public void setUnread_pool(long unread_pool) {
                        this.unread_pool = unread_pool;
                    }

                    public long getDaiyan() {
                        return daiyan;
                    }

                    public void setDaiyan(long daiyan) {
                        this.daiyan = daiyan;
                    }

                    public long getAli_1688() {
                        return ali_1688;
                    }

                    public void setAli_1688(long ali_1688) {
                        this.ali_1688 = ali_1688;
                    }

                    public long getVip_activity2() {
                        return vip_activity2;
                    }

                    public void setVip_activity2(long vip_activity2) {
                        this.vip_activity2 = vip_activity2;
                    }

                    public long getFools_day_2016() {
                        return fools_day_2016;
                    }

                    public void setFools_day_2016(long fools_day_2016) {
                        this.fools_day_2016 = fools_day_2016;
                    }

                    public long getUefa_euro_2016() {
                        return uefa_euro_2016;
                    }

                    public void setUefa_euro_2016(long uefa_euro_2016) {
                        this.uefa_euro_2016 = uefa_euro_2016;
                    }

                    public long getUnread_pool_ext() {
                        return unread_pool_ext;
                    }

                    public void setUnread_pool_ext(long unread_pool_ext) {
                        this.unread_pool_ext = unread_pool_ext;
                    }

                    public long getSelf_media() {
                        return self_media;
                    }

                    public void setSelf_media(long self_media) {
                        this.self_media = self_media;
                    }

                    public long getOlympic_2016() {
                        return olympic_2016;
                    }

                    public void setOlympic_2016(long olympic_2016) {
                        this.olympic_2016 = olympic_2016;
                    }

                    public long getDzwbqlx_2016() {
                        return dzwbqlx_2016;
                    }

                    public void setDzwbqlx_2016(long dzwbqlx_2016) {
                        this.dzwbqlx_2016 = dzwbqlx_2016;
                    }

                    public long getDiscount_2016() {
                        return discount_2016;
                    }

                    public void setDiscount_2016(long discount_2016) {
                        this.discount_2016 = discount_2016;
                    }

                    public long getFollow_whitelist_video() {
                        return follow_whitelist_video;
                    }

                    public void setFollow_whitelist_video(long follow_whitelist_video) {
                        this.follow_whitelist_video = follow_whitelist_video;
                    }

                    public long getLeague_badge() {
                        return league_badge;
                    }

                    public void setLeague_badge(long league_badge) {
                        this.league_badge = league_badge;
                    }

                    public long getSuishoupai_2017() {
                        return suishoupai_2017;
                    }

                    public void setSuishoupai_2017(long suishoupai_2017) {
                        this.suishoupai_2017 = suishoupai_2017;
                    }

                    public long getLol_msi_2017() {
                        return lol_msi_2017;
                    }

                    public void setLol_msi_2017(long lol_msi_2017) {
                        this.lol_msi_2017 = lol_msi_2017;
                    }

                    public long getSuper_star_2017() {
                        return super_star_2017;
                    }

                    public void setSuper_star_2017(long super_star_2017) {
                        this.super_star_2017 = super_star_2017;
                    }

                    public long getVideo_attention() {
                        return video_attention;
                    }

                    public void setVideo_attention(long video_attention) {
                        this.video_attention = video_attention;
                    }

                    public long getTravel_2017() {
                        return travel_2017;
                    }

                    public void setTravel_2017(long travel_2017) {
                        this.travel_2017 = travel_2017;
                    }

                    public long getLol_gm_2017() {
                        return lol_gm_2017;
                    }

                    public void setLol_gm_2017(long lol_gm_2017) {
                        this.lol_gm_2017 = lol_gm_2017;
                    }

                    public long getCz_wed_2017() {
                        return cz_wed_2017;
                    }

                    public void setCz_wed_2017(long cz_wed_2017) {
                        this.cz_wed_2017 = cz_wed_2017;
                    }

                    public long getInspector() {
                        return inspector;
                    }

                    public void setInspector(long inspector) {
                        this.inspector = inspector;
                    }
                }

                public static class ExtendBeanX {
                    /**
                     * privacy : {"mobile":0}
                     * mbprivilege : 0000000000000000000000000000000000000000000000000000000004c00208
                     */

                    private PrivacyBeanX privacy;
                    private String mbprivilege;

                    public PrivacyBeanX getPrivacy() {
                        return privacy;
                    }

                    public void setPrivacy(PrivacyBeanX privacy) {
                        this.privacy = privacy;
                    }

                    public String getMbprivilege() {
                        return mbprivilege;
                    }

                    public void setMbprivilege(String mbprivilege) {
                        this.mbprivilege = mbprivilege;
                    }

                    public static class PrivacyBeanX {
                        /**
                         * mobile : 0
                         */

                        private long mobile;

                        public long getMobile() {
                            return mobile;
                        }

                        public void setMobile(long mobile) {
                            this.mobile = mobile;
                        }
                    }
                }
            }

            public static class RetweetedStatusBeanX {

                private String created_at;
                private long id;
                private String mid;
                private String idstr;
                private String text;
                private long textLength;
                private long source_allowclick;
                private long source_type;
                private String source;
                private long appid;
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
                private UserBeanXXXX user;
                private long reposts_count;
                private long comments_count;
                private long attitudes_count;
                private long pending_approval_count;
                private boolean isLongText;
                private long mlevel;
                private VisibleBeanXX visible;
                private long biz_feature;
                private long hasActionTypeCard;
                private long userType;
                private long more_info_type;
                private long positive_recom_flag;
                private String gif_ids;
                private long is_show_bulletin;
                private CommentManageInfoBeanXX comment_manage_info;
                private List<String> pic_ids;
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

                public long getAppid() {
                    return appid;
                }

                public void setAppid(long appid) {
                    this.appid = appid;
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

                public UserBeanXXXX getUser() {
                    return user;
                }

                public void setUser(UserBeanXXXX user) {
                    this.user = user;
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

                public VisibleBeanXX getVisible() {
                    return visible;
                }

                public void setVisible(VisibleBeanXX visible) {
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

                public void setMore_info_type(long  more_info_type) {
                    this.more_info_type = more_info_type;
                }

                public long getPositive_recom_flag() {
                    return positive_recom_flag;
                }

                public void setPositive_recom_flag(long  positive_recom_flag) {
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

                public void setIs_show_bulletin(long  is_show_bulletin) {
                    this.is_show_bulletin = is_show_bulletin;
                }

                public CommentManageInfoBeanXX getComment_manage_info() {
                    return comment_manage_info;
                }

                public void setComment_manage_info(CommentManageInfoBeanXX comment_manage_info) {
                    this.comment_manage_info = comment_manage_info;
                }

                public List<String> getPic_ids() {
                    return pic_ids;
                }

                public void setPic_ids(List<String> pic_ids) {
                    this.pic_ids = pic_ids;
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

                public static class UserBeanXXXX {

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
                    private InsecurityBeanXXXX insecurity;
                    private long ptype;
                    private boolean allow_all_comment;
                    private String avatar_large;
                    private String avatar_hd;
                    private String verified_reason;
                    private String verified_trade;
                    private String verified_reason_url;
                    private String verified_source;
                    private String verified_source_url;
                    private long verified_state;
                    private long verified_level;
                    private long verified_type_ext;
                    private boolean has_service_tel;
                    private String verified_reason_modified;
                    private String verified_contact_name;
                    private String verified_contact_email;
                    private String verified_contact_mobile;
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
                    private long level;
                    private long type;
                    private long ulevel;
                    private BadgeBeanXX badge;
                    private String badge_top;
                    private long has_ability_tag;
                    private ExtendBeanXX extend;
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

                    public InsecurityBeanXXXX getInsecurity() {
                        return insecurity;
                    }

                    public void setInsecurity(InsecurityBeanXXXX insecurity) {
                        this.insecurity = insecurity;
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

                    public long getVerified_state() {
                        return verified_state;
                    }

                    public void setVerified_state(long verified_state) {
                        this.verified_state = verified_state;
                    }

                    public long getVerified_level() {
                        return verified_level;
                    }

                    public void setVerified_level(long verified_level) {
                        this.verified_level = verified_level;
                    }

                    public long getVerified_type_ext() {
                        return verified_type_ext;
                    }

                    public void setVerified_type_ext(long verified_type_ext) {
                        this.verified_type_ext = verified_type_ext;
                    }

                    public boolean isHas_service_tel() {
                        return has_service_tel;
                    }

                    public void setHas_service_tel(boolean has_service_tel) {
                        this.has_service_tel = has_service_tel;
                    }

                    public String getVerified_reason_modified() {
                        return verified_reason_modified;
                    }

                    public void setVerified_reason_modified(String verified_reason_modified) {
                        this.verified_reason_modified = verified_reason_modified;
                    }

                    public String getVerified_contact_name() {
                        return verified_contact_name;
                    }

                    public void setVerified_contact_name(String verified_contact_name) {
                        this.verified_contact_name = verified_contact_name;
                    }

                    public String getVerified_contact_email() {
                        return verified_contact_email;
                    }

                    public void setVerified_contact_email(String verified_contact_email) {
                        this.verified_contact_email = verified_contact_email;
                    }

                    public String getVerified_contact_mobile() {
                        return verified_contact_mobile;
                    }

                    public void setVerified_contact_mobile(String verified_contact_mobile) {
                        this.verified_contact_mobile = verified_contact_mobile;
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

                    public long getLevel() {
                        return level;
                    }

                    public void setLevel(long level) {
                        this.level = level;
                    }

                    public long getType() {
                        return type;
                    }

                    public void setType(long type) {
                        this.type = type;
                    }

                    public long getUlevel() {
                        return ulevel;
                    }

                    public void setUlevel(long ulevel) {
                        this.ulevel = ulevel;
                    }

                    public BadgeBeanXX getBadge() {
                        return badge;
                    }

                    public void setBadge(BadgeBeanXX badge) {
                        this.badge = badge;
                    }

                    public String getBadge_top() {
                        return badge_top;
                    }

                    public void setBadge_top(String badge_top) {
                        this.badge_top = badge_top;
                    }

                    public long getHas_ability_tag() {
                        return has_ability_tag;
                    }

                    public void setHas_ability_tag(long has_ability_tag) {
                        this.has_ability_tag = has_ability_tag;
                    }

                    public ExtendBeanXX getExtend() {
                        return extend;
                    }

                    public void setExtend(ExtendBeanXX extend) {
                        this.extend = extend;
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

                    public static class InsecurityBeanXXXX {
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

                    public static class BadgeBeanXX {

                        private long uc_domain;
                        private long enterprise;
                        private long anniversary;
                        private long taobao;
                        private long gongyi;
                        private long gongyi_level;
                        private long bind_taobao;
                        private long dailv;
                        private long zongyiji;
                        private long vip_activity1;
                        private long unread_pool;
                        private long daiyan;
                        private long ali_1688;
                        private long vip_activity2;
                        private long fools_day_2016;
                        private long uefa_euro_2016;
                        private long unread_pool_ext;
                        private long self_media;
                        private long olympic_2016;
                        private long dzwbqlx_2016;
                        private long discount_2016;
                        private long follow_whitelist_video;
                        private long league_badge;
                        private long suishoupai_2017;
                        private long lol_msi_2017;
                        private long super_star_2017;
                        private long video_attention;
                        private long travel_2017;
                        private long lol_gm_2017;
                        private long cz_wed_2017;
                        private long inspector;

                        public long getUc_domain() {
                            return uc_domain;
                        }

                        public void setUc_domain(long uc_domain) {
                            this.uc_domain = uc_domain;
                        }

                        public long getEnterprise() {
                            return enterprise;
                        }

                        public void setEnterprise(long enterprise) {
                            this.enterprise = enterprise;
                        }

                        public long getAnniversary() {
                            return anniversary;
                        }

                        public void setAnniversary(long anniversary) {
                            this.anniversary = anniversary;
                        }

                        public long getTaobao() {
                            return taobao;
                        }

                        public void setTaobao(long taobao) {
                            this.taobao = taobao;
                        }

                        public long getGongyi() {
                            return gongyi;
                        }

                        public void setGongyi(long gongyi) {
                            this.gongyi = gongyi;
                        }

                        public long getGongyi_level() {
                            return gongyi_level;
                        }

                        public void setGongyi_level(long gongyi_level) {
                            this.gongyi_level = gongyi_level;
                        }

                        public long getBind_taobao() {
                            return bind_taobao;
                        }

                        public void setBind_taobao(long bind_taobao) {
                            this.bind_taobao = bind_taobao;
                        }

                        public long getDailv() {
                            return dailv;
                        }

                        public void setDailv(long dailv) {
                            this.dailv = dailv;
                        }

                        public long getZongyiji() {
                            return zongyiji;
                        }

                        public void setZongyiji(long zongyiji) {
                            this.zongyiji = zongyiji;
                        }

                        public long getVip_activity1() {
                            return vip_activity1;
                        }

                        public void setVip_activity1(long vip_activity1) {
                            this.vip_activity1 = vip_activity1;
                        }

                        public long getUnread_pool() {
                            return unread_pool;
                        }

                        public void setUnread_pool(long unread_pool) {
                            this.unread_pool = unread_pool;
                        }

                        public long getDaiyan() {
                            return daiyan;
                        }

                        public void setDaiyan(long daiyan) {
                            this.daiyan = daiyan;
                        }

                        public long getAli_1688() {
                            return ali_1688;
                        }

                        public void setAli_1688(long ali_1688) {
                            this.ali_1688 = ali_1688;
                        }

                        public long getVip_activity2() {
                            return vip_activity2;
                        }

                        public void setVip_activity2(long vip_activity2) {
                            this.vip_activity2 = vip_activity2;
                        }

                        public long getFools_day_2016() {
                            return fools_day_2016;
                        }

                        public void setFools_day_2016(long fools_day_2016) {
                            this.fools_day_2016 = fools_day_2016;
                        }

                        public long getUefa_euro_2016() {
                            return uefa_euro_2016;
                        }

                        public void setUefa_euro_2016(long uefa_euro_2016) {
                            this.uefa_euro_2016 = uefa_euro_2016;
                        }

                        public long getUnread_pool_ext() {
                            return unread_pool_ext;
                        }

                        public void setUnread_pool_ext(long unread_pool_ext) {
                            this.unread_pool_ext = unread_pool_ext;
                        }

                        public long getSelf_media() {
                            return self_media;
                        }

                        public void setSelf_media(long self_media) {
                            this.self_media = self_media;
                        }

                        public long getOlympic_2016() {
                            return olympic_2016;
                        }

                        public void setOlympic_2016(long olympic_2016) {
                            this.olympic_2016 = olympic_2016;
                        }

                        public long getDzwbqlx_2016() {
                            return dzwbqlx_2016;
                        }

                        public void setDzwbqlx_2016(long dzwbqlx_2016) {
                            this.dzwbqlx_2016 = dzwbqlx_2016;
                        }

                        public long getDiscount_2016() {
                            return discount_2016;
                        }

                        public void setDiscount_2016(long discount_2016) {
                            this.discount_2016 = discount_2016;
                        }

                        public long getFollow_whitelist_video() {
                            return follow_whitelist_video;
                        }

                        public void setFollow_whitelist_video(long follow_whitelist_video) {
                            this.follow_whitelist_video = follow_whitelist_video;
                        }

                        public long getLeague_badge() {
                            return league_badge;
                        }

                        public void setLeague_badge(long league_badge) {
                            this.league_badge = league_badge;
                        }

                        public long getSuishoupai_2017() {
                            return suishoupai_2017;
                        }

                        public void setSuishoupai_2017(long suishoupai_2017) {
                            this.suishoupai_2017 = suishoupai_2017;
                        }

                        public long getLol_msi_2017() {
                            return lol_msi_2017;
                        }

                        public void setLol_msi_2017(long lol_msi_2017) {
                            this.lol_msi_2017 = lol_msi_2017;
                        }

                        public long getSuper_star_2017() {
                            return super_star_2017;
                        }

                        public void setSuper_star_2017(long super_star_2017) {
                            this.super_star_2017 = super_star_2017;
                        }

                        public long getVideo_attention() {
                            return video_attention;
                        }

                        public void setVideo_attention(long video_attention) {
                            this.video_attention = video_attention;
                        }

                        public long getTravel_2017() {
                            return travel_2017;
                        }

                        public void setTravel_2017(long travel_2017) {
                            this.travel_2017 = travel_2017;
                        }

                        public long getLol_gm_2017() {
                            return lol_gm_2017;
                        }

                        public void setLol_gm_2017(long lol_gm_2017) {
                            this.lol_gm_2017 = lol_gm_2017;
                        }

                        public long getCz_wed_2017() {
                            return cz_wed_2017;
                        }

                        public void setCz_wed_2017(long cz_wed_2017) {
                            this.cz_wed_2017 = cz_wed_2017;
                        }

                        public long getInspector() {
                            return inspector;
                        }

                        public void setInspector(long inspector) {
                            this.inspector = inspector;
                        }
                    }

                    public static class ExtendBeanXX {

                        private PrivacyBeanXX privacy;
                        private String mbprivilege;

                        public PrivacyBeanXX getPrivacy() {
                            return privacy;
                        }

                        public void setPrivacy(PrivacyBeanXX privacy) {
                            this.privacy = privacy;
                        }

                        public String getMbprivilege() {
                            return mbprivilege;
                        }

                        public void setMbprivilege(String mbprivilege) {
                            this.mbprivilege = mbprivilege;
                        }

                        public static class PrivacyBeanXX {
                            /**
                             * mobile : 0
                             */

                            private long mobile;

                            public long getMobile() {
                                return mobile;
                            }

                            public void setMobile(long mobile) {
                                this.mobile = mobile;
                            }
                        }
                    }
                }

                public static class VisibleBeanXX {
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

                public static class CommentManageInfoBeanXX {
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
            }

            public static class VisibleBeanXXX {
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

            public static class CommentManageInfoBeanXXX {
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
        }
    }
}
