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
    //数据库的版本号
    public static final int DATABASE_VERSION = 2;
    //数据库名
    public static final String DATABASE_NAME = "person.db";

    private static final String TAG = "MySQLiteOpenHelper";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    public MySQLiteOpenHelper(Context context,//上下文
                              String name,//要创建数据库的名称
                              SQLiteDatabase.CursorFactory factory,//游标工厂，生产游标（cursor）
                              int version//数据库版本号
    ) {
        super(context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + PersonContract.PersonEntry.TABLE_NAME+
                " (" +
                PersonContract.PersonEntry._ID+" INTEGER PRIMARY KEY,"+//" INTEGER PRIMARY KEY,"要空一格
                PersonContract.PersonEntry.COLUMNS_ID + TEXT_TYPE + COMMA_SEP+
                PersonContract.PersonEntry.COLUMNS_NAME+TEXT_TYPE+COMMA_SEP+
                PersonContract.PersonEntry.COLUMNS_CLASS+TEXT_TYPE+"）"
        );

        Log.d(TAG,"oncreate:table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //newVersion 大于 oldVersion 当数据库版本更新的时候，回调此方法
        Log.d(TAG,"oncreate:");
    }
}
