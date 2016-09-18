package com.example.housekeeper.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.housekeeper.entity.TelClassInfo;
import com.example.housekeeper.entity.TelNumberInfo;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/18.
 */
public class DBRead {
    /**
     * 通讯大全 File
     */
    public static File telFile;
    static {
        String dbFileDir = "data/data/com.example.housekeeper";//等价于context.getfiledir()
        File fileDir = new File(dbFileDir);
        fileDir.mkdirs();//文件目录的创建
        telFile = new File(dbFileDir,"commonnum.db");
        LogUtil.debug("DBRead","telFiel dir path"+dbFileDir);
    }
    /**
     * 检测是否存在通讯大全 DB文件
     */
    public static boolean isExistsTelDBFile(){
        return !telFile.exists()||telFile.length() <= 0;
    }
    /**
     * 读取telFile这个数据库文件中的 classlist这个表内的数据
     *
     * @throws Exception
     */
    public static ArrayList<TelClassInfo> readTelDBClassList(){
        ArrayList<TelClassInfo> telClassInfos = new ArrayList<TelClassInfo>();
        // 打开 DB文件
        SQLiteDatabase db = null;
        // 执行查询的 SQL语句 select * from classlist
        Cursor cursor = null;
        //打开telFile数据库
        try {
            db = SQLiteDatabase.openOrCreateDatabase(telFile,null);
            cursor = db.rawQuery("select * from classlist",null);
            LogUtil.debug("DBRead", "read teldb classlist size: "
                    + cursor.getCount());
            while (cursor.moveToNext())
            {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                //idx为 classlist表中电话的 ID，根据 idx值进行指定页面的跳转
                int idx = cursor.getInt(cursor.getColumnIndex("idx"));
                TelClassInfo telClassInfo = new TelClassInfo(name,idx);
                telClassInfos.add(telClassInfo);
            }
        }
        catch (Exception e){
            LogUtil.debug("DBRead", "read teldb classlist failed");
        }
        finally {
            try {
                //关闭游标
                cursor.close();
                //关闭数据库，释放资源
                db.close();
            } catch (Exception e2) {
                throw e2;
            }
        }
        return telClassInfos;
    }


    public static ArrayList<TelNumberInfo> readTelNumberInfo(int idx) {
        ArrayList<TelNumberInfo> telNumberInfos = new ArrayList<>();
        //idx为classlist表中电话的 ID，根据 idx值进行指定页面的跳转
        String sql = "select * from table" + idx;
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            // 打开 DB文件
            db = SQLiteDatabase
                    .openOrCreateDatabase(telFile, null);
            // 执行查询的 SQL语句 select * from table +idx
            cursor = db.rawQuery(sql, null);
            LogUtil.debug("DBRead", "read teldb number table size: "
                    + cursor.getCount());
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor
                            .getString(cursor
                                    .getColumnIndex("name"));
                    String number = cursor
                            .getString(cursor
                                    .getColumnIndex("number"));
                    TelNumberInfo numberInfo = new TelNumberInfo(
                            name, number);
                    telNumberInfos.add(numberInfo);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            LogUtil.debug("DBRead", "read teldb classlist failed");
        } finally {
            try {
                //关闭游标
                cursor.close();
                //关闭数据库，释放资源
                db.close();
            } catch (Exception e2) {
                throw e2;
            }
        }
        return telNumberInfos;
    }
}
