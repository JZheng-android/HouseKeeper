package com.example.housekeeper.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/9/18.
 */
public class MyAssetsManager {
    private static final String TAG = "MyAssetsManager";
    /**
     * 返回的file是数据库文件存放的位置
     * @param context
     * @return path 如果不为null,拷贝成功，否则失败
     */
    public String copyDBToGB(Context context){
        //assets不能直接被编译，需通过AssetsManager来管理
        AssetManager assetManager = context.getAssets();
        String path = "db/commonnum.db";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //通过path地址获得io流,read
            InputStream inputStream = assetManager.open(path);
            //将数据库文件保存到内置存储 file目录下
            File filesDir = context.getFilesDir();
            //write                              文件名
            File file = new File(filesDir,"commonnum.db");
            //write到fileOutputStream
            FileOutputStream outputStream = context.openFileOutput(file.getName(),Context.MODE_PRIVATE);
            bis = new BufferedInputStream(inputStream);
            bos = new BufferedOutputStream(outputStream);
            byte[] buf = new byte[1024];
            int eof = 0;
            if ((eof = bis.read(buf))!=-1){
                bos.write(buf,0,eof);
                bos.flush();
            }
            return file.getName();

        } catch (IOException e) {
            Log.d(TAG,path+"路径错误！");
        }
        finally {
            try {
                bis.close();
            } catch (IOException e) {
                Log.d(TAG,"关流失败！");
            }
            try {
                bos.close();
            } catch (IOException e) {
                Log.d(TAG,"关流失败！");
            }
        }

    return null;

    }
}
