package com.example.user.bustogoappliction;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.user.bustogoappliction.DBbustogo.BusTABLE;
import com.example.user.bustogoappliction.DBbustogo.PlaceTABLE;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private PlaceTABLE objPlaceTABLE;
    private BusTABLE objBusTABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Connectdb();
        Deldb();
        SynJson();


    }

   private void Deldb() {
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("bus.db",MODE_APPEND,null);
        objSqLiteDatabase.delete("placeTABLE",null,null);
        objSqLiteDatabase.delete("busTABLE",null,null);
    }

    private void SynJson() {
        StrictMode.ThreadPolicy myPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(myPolicy);

        int intTime = 0;
        while (intTime <= 1){
            InputStream objInputStream = null;
            String strJSON= null;
            String strPlaceURL = "http://5711020660005.sci.dusit.ac.th/placeTABLE1.php";
            String strBusURL = "http://5711020660005.sci.dusit.ac.th/busTABLE1.php";
            HttpPost objHttpPost = null;

            try{
                HttpClient objHttpClient = new DefaultHttpClient();
                switch (intTime){
                    case 0:
                        objHttpPost = new HttpPost(strPlaceURL);
                        break;
                    default:
                        objHttpPost= new HttpPost(strBusURL);
                }
                HttpResponse objHttpResponse = objHttpClient.execute(objHttpPost);
                HttpEntity objHttpEntity = objHttpResponse.getEntity();
                objInputStream = objHttpEntity.getContent();

            }catch (Exception e){
                Log.d("BUS","Input ==>"+e.toString());
            }
            try{
                InputStreamReader objInputStreamReader = new InputStreamReader(objInputStream,"UTF-8");
                BufferedReader objBufferedReader = new BufferedReader(objInputStreamReader);
                StringBuilder objStringBuilder = new StringBuilder();
                String strLine= null;
                while ((strLine=objBufferedReader.readLine())!=null){
                    objStringBuilder.append(strLine);
                }
                objInputStream.close();
                strJSON = objStringBuilder.toString();
                    }catch (Exception e){
                Log.d("KengKung","strJSON"+e.toString());
            }
            try{
                JSONArray objJsonArray = new JSONArray(strJSON);
                for (int i =0;i<objJsonArray.length();i++){
                    JSONObject jsonObject = objJsonArray.getJSONObject(i);
                    switch (intTime){
                        case 0:
                            String strNP = jsonObject.getString("name_place");
                            String strPP = jsonObject.getString("pic_place");
                            String strPD = jsonObject.getString("detail_place");
                            String strPLA = jsonObject.getString("lat_place");
                            String strPLO = jsonObject.getString("long_place");
                            String strPB = jsonObject.getString("bus_place");
                            objPlaceTABLE.AddNewPlace(strNP,strPP,strPD,strPLA,strPLO,strPB);
                            break;
                        default:
                            String strBP = jsonObject.getString("pic_bus");
                            String strBD = jsonObject.getString("detail_bus");
                            objBusTABLE.AddNewBus(strBP,strBD);
                            break;
                    }
                }
            }catch (Exception e){
                Log.d("Busss","strJson"+e.toString());
            }
            intTime += 1 ;


                }
            }




    private void Connectdb() {
        objPlaceTABLE = new PlaceTABLE(this);
        objBusTABLE = new BusTABLE(this);
    }

    public void btn2 (View view) {
        Intent intent = new Intent(MainActivity.this,Mainmenu.class);
        startActivity(intent);
    }
}
