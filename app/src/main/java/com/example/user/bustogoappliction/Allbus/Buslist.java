package com.example.user.bustogoappliction.Allbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.bustogoappliction.Alldetail;
import com.example.user.bustogoappliction.DBbustogo.BusTABLE;
import com.example.user.bustogoappliction.MyAdapter.MyAdapterBus;
import com.example.user.bustogoappliction.R;

public class Buslist extends AppCompatActivity {

    private BusTABLE objBusTABLE;
    private ListView Buslist;
    private String[] id_bus,detail_bus,pic_bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buslist);

        ListBus();
        ConnectDBBus();
        Buslistview();
    }
    private void Buslistview(){
        final String[] idbus = objBusTABLE.readDBbusTable(0);
        final String[] detailbus = objBusTABLE.readDBbusTable(1);
        final String[] picbus = objBusTABLE.readDBbusTable(2);

        MyAdapterBus objMyAdapterBus = new MyAdapterBus(Buslist.this,idbus,detailbus,picbus);
        Buslist.setAdapter(objMyAdapterBus);
        Buslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                id_bus = idbus;
                detail_bus = detailbus;
                pic_bus = picbus;

                Intent intent =new Intent(Buslist.this, Alldetail.class);
                intent.putExtra("id_bus", idbus[position]);
                intent.putExtra("deail_bus", detailbus[position]);
                intent.putExtra("pic_bus", picbus[position]);
                startActivity(intent);

            }
        });
    }

    private void ConnectDBBus(){
        objBusTABLE = new BusTABLE(this);
    }

    private void ListBus(){
        Buslist=(ListView)findViewById(R.id.lv_bus);
    }

}
