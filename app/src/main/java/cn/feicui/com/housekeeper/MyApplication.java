package cn.feicui.com.housekeeper;

import android.app.Application;
import android.util.Log;

import cn.feicui.com.housekeeper.DataBase.MySQLiteOpenHelper;

/**
 * Created by Administrator on 2016/9/14.
 */
public class MyApplication extends Application {
    //public方便调用
    public MySQLiteOpenHelper mySQLiteOpenHelper;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyApplication","onCreate:");
        //创建数据库，只有一次
       mySQLiteOpenHelper = new MySQLiteOpenHelper(
                this,
                MySQLiteOpenHelper.DATABASE_NAME,
                null,
                MySQLiteOpenHelper.DATABASE_VERSION
        );
    }
}
