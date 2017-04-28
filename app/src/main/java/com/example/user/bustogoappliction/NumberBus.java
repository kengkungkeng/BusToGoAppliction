package com.example.user.bustogoappliction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NumberBus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_bus);
    }
    public void button2 (View view) {
        Intent intent = new Intent(NumberBus.this,Mainmenu.class);
        startActivity(intent);
    }
}
