package com.example.rainbow.lab3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2016/10/11.
 */

public class DetailActivity extends AppCompatActivity {

    boolean flag = false; //记录星星实心or空心

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        //接收前一个Activity的数据
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("姓名", "default value");
        String phone_num = bundle.getString("手机号", "default value");
        String type = bundle.getString("类型", "default value");
        String where = bundle.getString("归属地", "default value");
        String bg_color = bundle.getString("背景颜色", "default value");

        //设置背景颜色
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.detail_Rlayout);
        relativeLayout.setBackgroundColor(Color.parseColor(bg_color));
        //设置名字
        TextView nameText = (TextView)findViewById(R.id.detail_name);
        nameText.setText(name);
        //设置电话、类型、归属地
        TextView numText = (TextView)findViewById(R.id.phone_num);
        numText.setText(phone_num);
        TextView typeText = (TextView)findViewById(R.id.type);
        typeText.setText(type);
        TextView whereText = (TextView)findViewById(R.id.where);
        whereText.setText(where);

        //operation list赋值
        final ListView operation_list = (ListView)findViewById(R.id.detail_operation_list);
        String[] operations = new String[]{"编辑联系人","分享联系人","加入黑名单","删除联系人"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.detail_operation, operations);
        operation_list.setAdapter(arrayAdapter);

        //点击左上角返回按钮跳转回MainActivity
        ImageButton back_button = (ImageButton)findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
            }
        });

        //点击切换实心空心星星
        final ImageButton star_button = (ImageButton)findViewById(R.id.detail_star);
        star_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag){
                    star_button.setBackgroundResource(R.drawable.full_star);
                    flag = true;
                }
                else{
                    star_button.setBackgroundResource(R.drawable.empty_star);
                    flag = false;
                }
            }
        });

    }




}

