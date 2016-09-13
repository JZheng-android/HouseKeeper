package cn.feicui.com.housekeeper.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

/**
 * Created by Administrator on 2016/9/13.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = "MySQLiteOpenHelper";

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"oncreate:");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG,"oncreate:");
    }
}
