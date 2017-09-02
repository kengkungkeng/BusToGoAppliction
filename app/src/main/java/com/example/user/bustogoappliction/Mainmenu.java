package com.example.user.bustogoappliction;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.user.bustogoappliction.Allbus.Buslist;
import com.example.user.bustogoappliction.Allplace.Placelist;
import com.example.user.bustogoappliction.DBbustogo.BusTABLE;
import com.example.user.bustogoappliction.DBbustogo.PlaceTABLE;

public class Mainmenu extends AppCompatActivity {
    private BusTABLE objBusTABLE;
    private PlaceTABLE objPlaceTABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        ConnectDBBus();
    }

    private void ConnectDBBus() {
        objBusTABLE = new BusTABLE(this);
        objPlaceTABLE = new PlaceTABLE(this);
    }

    public void imvd (View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.bmta.co.th/?q=th/home"));
        startActivity(intent);
    }
    public void imva (View view) {
        Intent intent = new Intent(Mainmenu.this,Buslist.class);
        startActivity(intent);
    }

    public void imvb (View view) {
        Intent intent = new Intent(Mainmenu.this,Placelist.class);
        startActivity(intent);
    }
    public void imvc (View view) {
        Intent intent = new Intent(Mainmenu.this,StartorDestination.class);
        startActivity(intent);
    }
}
