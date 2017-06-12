package com.example.user.bustogoappliction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class NumberBus extends AppCompatActivity {

    //Explicit
    ListView listView;
    private int [] ints = new int[] {R.drawable.one,R.drawable.two,
            R.drawable.tree,R.drawable.four,R.drawable.six,
            R.drawable.seven,R.drawable.sevens,R.drawable.egg,R.
            drawable.ninge,R.drawable.onetwo,
            R.drawable.onefive,R.drawable.twoone,R.drawable.twofive,R.drawable.treezeo,R.
            drawable.treetwo,R.drawable.treess,
            R.drawable.treefive,R.drawable.treeseve,R.drawable.fourzon,
            R.drawable.fourtwo,R.drawable.fourtree,R.
            drawable.fourss,R.drawable.fourseven,R.drawable.fouregg,R.drawable.fournine
            ,R.drawable.fivetree,R.drawable.fivesix,R.drawable.fivenine,R.drawable.sixzon,R.drawable.sixfour
            ,R.drawable.sixfive,R.drawable.sixegg,R.drawable.svenzno,
            R.drawable.sevetre,R.drawable.sevtres,R.drawable.sevennine,R.drawable.eggzeo,
            R.drawable.eggtwo,R.drawable.eggfive,R.drawable.nineone,
            R.drawable.oneonezon,R.drawable.onetwotree,R.drawable.onetwofour
            ,R.drawable.onetwoseven,R.drawable.onesevone,R.drawable.oneeggtre,R.drawable.twozontree
            ,R.drawable.fivezontre,R.drawable.fivezones,R.drawable.fivezonegg,R.drawable.fzonnine,R.drawable.fiveoneo
            ,R.drawable.fivonsiz,R.drawable.fivtwfo,R.drawable.fivtwni,R.drawable.fivfotwo,R.drawable.fivesix};

    private String[]titlesStrings,detailStrings,shorStrings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_bus);
        //inital view
        listView = (ListView) findViewById(R.id.livBus);
        //Get volue
        titlesStrings = getResources().getStringArray(R.array.title);
        detailStrings = getResources().getStringArray(R.array.detail);
        //SubString detailString ตัดข้อความให้สั้นตามที่ต้องการ
        shorStrings = new String[detailStrings.length]; //จำลองพื้นที่
        for (int i = 0; i < detailStrings.length;i++){
            shorStrings [i] = detailStrings [i] .substring(0,29)+"...";

        } //end for
        //create ListView
        Myadpter myadpter = new Myadpter(NumberBus.this,ints,titlesStrings,shorStrings);
        listView.setAdapter(myadpter);

        //active when click Live View ลิ้งค์ไปหน้า detail เมื่อเลือก item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NumberBus.this,detail.class);
                intent.putExtra("Title",titlesStrings[position]);
                intent.putExtra("Detail",detailStrings[position]);
                intent.putExtra("Image",ints[position]);
                startActivity(intent);
            }
        });

    }//main Method onCreate

    public void button2 (View view) {
        Intent intent = new Intent(NumberBus.this,Mainmenu.class);
        startActivity(intent);
    }

}
