package com.example.yuanping.weconnected.login.bean;

/**
 * Created by yuanping on 11/5/17.
 */

public class RelationShipBean {

    /**
     * source : {"followed_by":true,"following":true,"id":5539916070,"notifications_enabled":false,"screen_name":"HusterYP"}
     * target : {"followed_by":true,"following":true,"id":5194139813,"notifications_enabled":false,"screen_name":"听荷紫文"}
     */

    private SourceBean source;
    private TargetBean target;

    public SourceBean getSource() {
        return source;
    }

    public void setSource(SourceBean source) {
        this.source = source;
    }

    public TargetBean getTarget() {
        return target;
    }

    public void setTarget(TargetBean target) {
        this.target = target;
    }

    public static class SourceBean {
        /**
         * followed_by : true
         * following : true
         * id : 5539916070
         * notifications_enabled : false
         * screen_name : HusterYP
         */

        private boolean followed_by;
        private boolean following;
        private long id;
        private boolean notifications_enabled;
        private String screen_name;

        public boolean isFollowed_by() {
            return followed_by;
        }

        public void setFollowed_by(boolean followed_by) {
            this.followed_by = followed_by;
        }

        public boolean isFollowing() {
            return following;
        }

        public void setFollowing(boolean following) {
            this.following = following;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public boolean isNotifications_enabled() {
            return notifications_enabled;
        }

        public void setNotifications_enabled(boolean notifications_enabled) {
            this.notifications_enabled = notifications_enabled;
        }

        public String getScreen_name() {
            return screen_name;
        }

        public void setScreen_name(String screen_name) {
            this.screen_name = screen_name;
        }
    }

    public static class TargetBean {
        /**
         * followed_by : true
         * following : true
         * id : 5194139813
         * notifications_enabled : false
         * screen_name : 听荷紫文
         */

        private boolean followed_by;
        private boolean following;
        private long id;
        private boolean notifications_enabled;
        private String screen_name;

        public boolean isFollowed_by() {
            return followed_by;
        }

        public void setFollowed_by(boolean followed_by) {
            this.followed_by = followed_by;
        }

        public boolean isFollowing() {
            return following;
        }

        public void setFollowing(boolean following) {
            this.following = following;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public boolean isNotifications_enabled() {
            return notifications_enabled;
        }

        public void setNotifications_enabled(boolean notifications_enabled) {
            this.notifications_enabled = notifications_enabled;
        }

        public String getScreen_name() {
            return screen_name;
        }

        public void setScreen_name(String screen_name) {
            this.screen_name = screen_name;
        }
    }
}
