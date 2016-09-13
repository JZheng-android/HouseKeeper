package cn.feicui.com.housekeeper.DataBase;

import android.provider.BaseColumns;

/**
 * Created by Administrator on 2016/9/13.
 */
public final class PersonContract {
    public static abstract class PersonEntry implements BaseColumns{
        public static final String TABLE_NAME = "entry";
        public static final String COLUMNS_ID = "entryid";
        public static final String COLUMNS_NAME = "title";
        public static final String COLUMNS_CLASS = "subtitle";
    }
}
