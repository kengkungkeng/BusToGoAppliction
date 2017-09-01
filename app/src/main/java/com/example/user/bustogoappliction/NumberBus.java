package com.example.user.bustogoappliction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.bustogoappliction.DBbustogo.BusTABLE;
import com.example.user.bustogoappliction.MyAdapter.AdapterBus;

public class NumberBus extends AppCompatActivity {
    private BusTABLE objBusTABLE;
    private ListView Listbus01;
    private String[] idbus,detailbus,picbus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_bus);

        BindWidget();
        Connectdb();
        CreateListView();
    }//main Method onCreate

    private void CreateListView() {
        final String[] stridbus = objBusTABLE.readDBbusTable(0);
        final String[] strdetailbus = objBusTABLE.readDBbusTable(1);
        final String[] strpicbus = objBusTABLE.readDBbusTable(3);

        AdapterBus objAdapterBus = new AdapterBus(NumberBus.this,stridbus,strdetailbus,strpicbus);
        Listbus01.setAdapter(objAdapterBus);
        Listbus01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                idbus = stridbus;
                detailbus = strdetailbus;
                picbus = strpicbus;

                Intent intent = new Intent(NumberBus.this,detail.class);
                intent.putExtra("Numbus", stridbus[position]);
                intent.putExtra("Detailbus",strdetailbus[position]);
                intent.putExtra("Picbus",strpicbus[position]);
                startActivity(intent);

            }
        });



    }

    private void Connectdb() {
        objBusTABLE = new BusTABLE(this);
    }

    private void BindWidget() {
        Listbus01 = (ListView) findViewById(R.id.Listbus01);

    }

    public void button2 (View view) {
        Intent intent = new Intent(NumberBus.this,Mainmenu.class);
        startActivity(intent);
    }

}
