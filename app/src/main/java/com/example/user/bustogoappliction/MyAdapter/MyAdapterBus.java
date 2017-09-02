package com.example.user.bustogoappliction.MyAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.bustogoappliction.R;
import com.squareup.picasso.Picasso;

/**
 * Created by KengKung on 1/9/2560.
 */

public class MyAdapterBus extends BaseAdapter {
    private Context objcontextbus;
    private String[] idbus,detailbus,picbus;

    public MyAdapterBus(Context context,String[] idbus,String[] detailbus,String[] picbus){
        this.objcontextbus = context;
        this.idbus = idbus;
        this.detailbus = detailbus;
        this.picbus = picbus;
    }

    @Override
    public int getCount() {
        return detailbus.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater objLayoutInflater = (LayoutInflater) objcontextbus.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = objLayoutInflater.inflate(R.layout.bus_listview,parent,false);

        TextView busnameTextView = (TextView) view.findViewById(R.id.lv_namebus);
        TextView detailTextView = (TextView) view.findViewById(R.id.lv_detailbus);
        ImageView buspicImaceView = (ImageView) view.findViewById(R.id.imlv_bus);

        Picasso.with(objcontextbus).load(picbus[position]).into(buspicImaceView);
            busnameTextView.setText(idbus[position]);
            detailTextView.setText(detailbus[position]);


        return view;
    }
}
