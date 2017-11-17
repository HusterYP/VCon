package com.example.yuanping.weconnected.login.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yuanping.weconnected.R;

import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;

public class SearchUser extends AppCompatActivity {

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        searchView = (SearchView) findViewById(R.id.search_view);

        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                Intent intent = new Intent(SearchUser.this,RelationShip.class);
                intent.putExtra("result",string);
                SearchUser.this.setResult(1,intent);
                finish();
            }
        });

        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                Intent intent = new Intent(SearchUser.this,RelationShip.class);
                intent.putExtra("result","0");
                SearchUser.this.setResult(1,intent);
                finish();
            }
        });
    }
}
