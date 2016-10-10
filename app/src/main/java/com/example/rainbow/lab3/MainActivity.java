package com.example.rainbow.lab3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String[][] alldata = new String[][]{
            {"姓名","手机号","类型","归属地","背景颜色"},
            {"Aaron","17715523654","手机","江苏苏州电信","BB4C3B"},
            {"Elvis","18825653224","手机","广东揭阳移动","c48d30"},
            {"David","15052116654","手机","江苏无锡移动","4469b0"},
            {"Edwin","18854211875","手机","山东青岛移动","20A17B"},
            {"Frank","13955188541","手机","安徽合肥移动","BB4C3B"},
            {"Joshua","13621574410","手机","江苏苏州移动","c48d30"},
            {"Ivan","15684122771","手机","山东烟台联通","4469b0"},
            {"Mark","17765213579","手机","广东珠海电信","20A17B"},
            {"Joseph","13315466578","手机","河北石家庄电信","BB4C3B"},
            {"Phoebe","17895466428","手机","山东东营移动","c48d30"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_name);
/*
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i1=1; i1<11; i1++) {
            Map<String, Object> temp = new LinkedHashMap<>();
            for(int j = 0; j < 5; j++)
                temp.put(alldata[0][j], alldata[i1][j]);
            data.add(temp);
        }
*/
        //data1:首字母、姓名
        List<Map<String, Object>> data1 = new ArrayList<>();
        for (int i2 = 1; i2 < 11; i2++) {
            Map<String, Object> temp = new LinkedHashMap<>();
            temp.put("首字母", alldata[i2][0].substring(0,1));
            temp.put("姓名", alldata[i2][0]);
            data1.add(temp);
        }
        ListView listview = (ListView)findViewById(R.id.contact_list);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data1, R.layout.abbr_full,
                new String[]{"首字母","姓名"}, new int[]{R.id.name_abbr, R.id.name_full});
        listview.setAdapter(simpleAdapter);

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        final Button full_name = (Button)findViewById(R.id.name_full);
        full_name.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                alertDialog.setTitle("删除联系人").setMessage("确定删除联系人"+full_name.getText()).setPositiveButton("确定",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                //删除该联系人
                            }
                        }).setNegativeButton("取消",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                //不删除联系人
                            }
                        }).create().show();
                return false;
            }
        });



    }





}
