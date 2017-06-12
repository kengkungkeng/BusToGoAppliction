package com.example.user.bustogoappliction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by USER on 12/6/2560.
 */

public class Myadpter extends BaseAdapter {
    //Explicit
    private Context context;
    private int [] ints;
    private String [] titleStrings,deailStrings;

    public Myadpter (Context context, int[] ints,String[] titleStrings,String[] deailStrings){
        this.context = context;
        this.ints = ints;
        this.titleStrings = titleStrings;
        this.deailStrings = deailStrings;
    }

    public int getCount() {
        return ints.length;
    }


    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return 0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.listview,parent,false);
        //Initial View
        ImageView imageView =(ImageView) view.findViewById(R.id.imageView3);
        TextView titleTextView = (TextView) view.findViewById(R.id.textView6);
        TextView detalTextView = (TextView) view.findViewById(R.id.textView5);
        //Show view
        imageView.setImageResource(ints[position]);
        titleTextView.setText(titleStrings[position]);
        detalTextView.setText(deailStrings[position]);


        return view;
    }
} //Main Class

