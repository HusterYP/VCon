package com.example.yuanping.weconnected.login.test;

import java.util.List;

/**
 * Created by yuanping on 11/2/17.
 */

public class FriendsListBean_Test {


    /**
     * ids : [1022185710,5437851984,1256359143,6092421970,5339184086,5588861274,5261712206,3277720151,6040159096,5408596403,3194551947,3880783324,6343075940,5170570023,3088933210,5253207337,5132037638,6387510922,5194139813,1699540307,2153528647,2494935602,5375583682,2306405891,1676368781]
     * next_cursor : 50
     * previous_cursor : 25
     * total_number : 67
     */

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
