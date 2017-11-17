package com.example.yuanping.weconnected.login.bean;

import java.util.List;

/**
 * Created by yuanping on 11/1/17.
 */

public class FriendsUidsList {

    private int next_cursor;
    private int previous_cursor;
    private int total_number;
    private List<Long> ids;

    public int getNext_cursor() {
        return next_cursor;
    }

    public void setNext_cursor(int next_cursor) {
        this.next_cursor = next_cursor;
    }

    public int getPrevious_cursor() {
        return previous_cursor;
    }

    public void setPrevious_cursor(int previous_cursor) {
        this.previous_cursor = previous_cursor;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
