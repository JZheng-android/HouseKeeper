package com.example.housekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.housekeeper.adapter.TelClassAdapter;
import com.example.housekeeper.entity.TelClassInfo;
import com.example.housekeeper.util.DBRead;
import com.example.housekeeper.util.MyAssetsManager;

import java.util.ArrayList;

public class TelClassActivity extends AppCompatActivity {
    private static final String TAG = "TelClassActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel_class);
        if (!DBRead.isExistsTelDBFile()){
            MyAssetsManager myAssetsManager = new MyAssetsManager();
            String path = myAssetsManager.copyDBToGB(this);
            Log.d(TAG,"onCreate"+path);
            Toast.makeText(TelClassActivity.this, "success", Toast.LENGTH_SHORT).show();
        }
        ArrayList<TelClassInfo> telClassInfos = DBRead.readTelDBClassList();
        ListView listview = (ListView) findViewById(R.id.show_tel_class_list_view);
        TelClassAdapter adapter = new TelClassAdapter(this,telClassInfos);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    AdapterView<?> parent,//parent引用的指向是listview对象
                    View view,
                    int position,//就是条目所在的位置 从0开始
                    long id//是条目的id值，是adapter 的getItemId（position）方法设置的
            ) {
                //当条目被点击，松开的时候，触发该方法
                Toast.makeText(TelClassActivity.this, id+"=="+position, Toast.LENGTH_SHORT).show();
                //a.跳转到TelClassActivity界面，并传递idx值
            }
        });
    }
}
