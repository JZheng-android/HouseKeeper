package com.example.housekeeper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.housekeeper.R;
import com.example.housekeeper.entity.TelClassInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/18.
 */
public class TelNumberAdapter extends BaseAdapter {

    private final ArrayList<TelClassInfo> telClassInfos;
    private final LayoutInflater inflater;
    public TelNumberAdapter(Context context, ArrayList<TelClassInfo> telClassInfos){
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.telClassInfos = telClassInfos;
    }
    @Override
    public int getCount() {
        return telClassInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return telClassInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = inflater.inflate(R.layout.activity_tel_class,null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.itc_tv);
        tv.setText(telClassInfos.get(position).getName());
        return convertView;
    }

}
