package com.example.user.bustogoappliction;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DemocracyMonument extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_democracy_monument);
    }
    public void button72 (View view) {
        Intent intent = new Intent(DemocracyMonument.this,Road.class);
        startActivity(intent);
    }
    public  void button73 (View view){
        //String lat = "13.751876";
        //String lng = "100.501231";
        //String GiantSwing = "Giant Swing";

        //Uri location= Uri.parse("https://map.google.com/maps?z=10&q=loc:"+lat+","+lng+"("+GiantSwing+")");
        //Uri location = Uri.parse("google.navigation:q=เสาชิงช้า"); //ต้องลองใช้กับโทรศัพท์ถึงจะเหมือนสุด
        Uri location = Uri.parse("http://maps.google.co.in/maps?q=" + "อนุสาวรีย์ ประชาธิปไตย");  // พิมพ์ชื่อสถานที่จะไปก็ไปได้เลย
        Intent mapIntent =new Intent(Intent.ACTION_VIEW,location);
        //mapIntent.setPackage("com.google.android.apps.maps"); //ไม่สามารถใช้กับจินนี่โมชันได้
        startActivity(mapIntent);

    }//call Map
}