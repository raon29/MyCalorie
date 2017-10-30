package com.example.myapplication2;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2015-11-30.
 */
public class parsing_menu extends Activity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener{
    String[] option;
    String name;
    int s;
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("태급", "값 넘어옴");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsingmenu);

        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(1234);
        name = getIntent().getStringExtra("name");
        ImageView tv = (ImageView)findViewById(R.id.parsname);
//        tv.setText(name);
        Spinner sp = (Spinner)findViewById(R.id.menu_spinner);
        sp.setPrompt("고르기");


        if(name.contains("롯데리아")) {
            Log.v("태급", "롯데리아 맞음 그래서 지금 조취를 취할것이다");
            tv.setImageResource(R.drawable.lotte);
            option = getResources().getStringArray(R.array.lotte_menu);
        }
        else if(name.contains("수퍼사이")){
            Log.v("태급", "수퍼사이즈 맞음");
            tv.setImageResource(R.drawable.supersize);
            option = getResources().getStringArray(R.array.supersize_menu);
        }
        else{
            Log.v("태급", "둘다아님");

            option = getResources().getStringArray(R.array.supersize_menu);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,option);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        s = i;
    }

    public void onclick(View view) {
        Intent parintent = new Intent(this,MainActivity.class);
        parintent.putExtra("pcal",1000+s);
        startActivity(parintent);
        finish();
    }
}
