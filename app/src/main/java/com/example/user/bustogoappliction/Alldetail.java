package com.example.user.bustogoappliction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Alldetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alldetail);


        ImageView detailpicView = (ImageView) findViewById(R.id.imagedetail);
        TextView detailnameView = (TextView) findViewById(R.id.namedetail);
        TextView detailDetailView = (TextView) findViewById(R.id.detail);

        detailDetailView.setText(getIntent().getStringExtra("detail"));
        detailnameView.setText(getIntent().getStringExtra("name"));
        String imag = getIntent().getStringExtra("pic");
        Picasso.with(Alldetail.this).load(imag).into(detailpicView);







    }




}
