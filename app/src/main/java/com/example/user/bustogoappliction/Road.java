package com.example.user.bustogoappliction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Road extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road);
    }
    public void button4 (View view) {
        Intent intent = new Intent(Road.this,Mainmenu.class);
        startActivity(intent);
    }
    public void imageView4 (View view) {
        Intent intent = new Intent(Road.this,GiantSwing.class);
        startActivity(intent);
    }
    public void imageView45 (View view) {
        Intent intent = new Intent(Road.this,BangkokCityPillarShrine.class);
        startActivity(intent);
    }
    public void imageView46 (View view) {
        Intent intent = new Intent(Road.this,BorompinHall.class);
        startActivity(intent);
    }
    public void imageView43 (View view) {
        Intent intent = new Intent(Road.this,RattanakosinExhibitionHall.class);
        startActivity(intent);
    }
    public void imageView42 (View view) {
        Intent intent = new Intent(Road.this,Territorialcommandingunit.class);
        startActivity(intent);
    }
    public void imageView40 (View view) {
        Intent intent = new Intent(Road.this,Ancientartillerymuseum.class);
        startActivity(intent);
    }
    public void imageView39 (View view) {
        Intent intent = new Intent(Road.this,WatTritvatthamWorawiharn.class);
        startActivity(intent);
    }
    public void imageView38 (View view) {
        Intent intent = new Intent(Road.this,ArtGallery.class);
        startActivity(intent);
    }
    public void imageView36 (View view) {
        Intent intent = new Intent(Road.this,WatTheodoraWorawihan.class);
        startActivity(intent);
    }
    public void imageView35 (View view) {
        Intent intent = new Intent(Road.this,MuseumofSiam.class);
        startActivity(intent);
    }
    public void imageView34 (View view) {
        Intent intent = new Intent(Road.this,WatSuthepVisawaram.class);
        startActivity(intent);
    }
    public void imageView33 (View view) {
        Intent intent = new Intent(Road.this,WatSamPhraya.class);
        startActivity(intent);
    }
    public void imageView32 (View view) {
        Intent intent = new Intent(Road.this,Mahasararam.class);
        startActivity(intent);
    }
    public void imageView31 (View view) {
        Intent intent = new Intent(Road.this,ThecourtBangkok.class);
        startActivity(intent);
    }
    public void imageView30 (View view) {
        Intent intent = new Intent(Road.this,WatRajatataramWorawihan.class);
        startActivity(intent);
    }
}
