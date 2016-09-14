package cn.feicui.com.housekeeper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import cn.feicui.com.housekeeper.DataBase.MySQLiteOpenHelper;
import cn.feicui.com.housekeeper.DataBase.PersonContract;
import cn.feicui.com.housekeeper.entity.People;

public class SQLiteDatabaseActivity extends AppCompatActivity {
    private static final String TAG = "SQLiteDatabaseActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_data_base);
        final EditText et_id = (EditText) findViewById(R.id.et_id);
        final EditText et_name = (EditText) findViewById(R.id.et_name);
        final EditText et_class = (EditText) findViewById(R.id.et_class);
        MyApplication myApplication = (MyApplication) getApplication();
        final SQLiteDatabase database =myApplication.mySQLiteOpenHelper.getWritableDatabase();
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            //保存数据
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                //将PersonContract.PersonEntry.COLUMNS_ID与et_id中的值相对应。
                contentValues.put(PersonContract.PersonEntry.COLUMNS_ID,et_id.getText().toString());
                contentValues.put(PersonContract.PersonEntry.COLUMNS_NAME,et_name.getText().toString());
                contentValues.put(PersonContract.PersonEntry.COLUMNS_CLASS,et_class.getText().toString());
                //表的名字
                long insert = database.insert(PersonContract.PersonEntry.TABLE_NAME, null, contentValues);
                Log.d(TAG, "insert"+insert);
            }
        });
        findViewById(R.id.read).setOnClickListener(new View.OnClickListener() {
            //读取数据
            @Override
            public void onClick(View v) {
                String selection = PersonContract.PersonEntry.COLUMNS_ID+"LIKE?";
                String[] selectionArg = new String[]{et_id.getText().toString()};
                Cursor cursor = database.query(
                        PersonContract.PersonEntry.TABLE_NAME,
                        new String[]{
                                PersonContract.PersonEntry.COLUMNS_ID,
                                PersonContract.PersonEntry.COLUMNS_NAME,
                                PersonContract.PersonEntry.COLUMNS_CLASS
                        },
                        selection,
                        selectionArg,
                        null,
                        null,
                        null
                );
                int count = cursor.getCount();
                Log.d(TAG,"count:"+count);
                while (cursor.moveToNext()){
                    People poople = new People();
                    String id = cursor.getString(cursor.getColumnIndex(PersonContract.PersonEntry.COLUMNS_ID));
                    String name = cursor.getString(cursor.getColumnIndex(PersonContract.PersonEntry.COLUMNS_NAME));
                    String clazz = cursor.getString(cursor.getColumnIndex(PersonContract.PersonEntry.COLUMNS_CLASS));
                    et_name.setText(name);
                    et_id.setText(id);
                    et_class.setText(clazz);
                    poople.name = name;
                    poople.clazz = clazz;
                    poople.id = id;
                }
            }
        });
        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = database.delete(
                        PersonContract.PersonEntry.TABLE_NAME,
                        null,//不给，删除所有数据
                        null
                );
                Log.d(TAG, "delete "+i);
            }
        });
        findViewById(R.id.updata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selection = PersonContract.PersonEntry.COLUMNS_ID + " LIKE ?";
                String[] selectionArg = new String[]{et_id.getText().toString()};
                ContentValues values = new ContentValues();
                values.put(PersonContract.PersonEntry.COLUMNS_NAME,"110");
                database.update(
                        PersonContract.PersonEntry.TABLE_NAME,
                        values,
                        selection,
                        selectionArg
                );
            }
        });
    }
}
