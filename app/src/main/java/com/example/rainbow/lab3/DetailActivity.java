package com.example.rainbow.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 123 on 2016/10/11.
 */

public class DetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("姓名", "default value");
        String phone_num = bundle.getString("手机号", "default value");
        String type = bundle.getString("类型", "default value");
        String where = bundle.getString("归属地", "default value");
        String bg_color = bundle.getString("背景颜色", "default value");



    }




}

