package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class sport extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ArrayList<String> arraylist = new ArrayList<String>();
    ArrayList<String> arraylist2 = new ArrayList<String>();

    int cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);

        arraylist.add("자전거");  //34 (10minute
        arraylist.add("산책");  //26
        arraylist.add("줄넘기");  //85
        arraylist.add("농구");  //80
        arraylist.add("조깅");  //94
        arraylist.add("요가");  //25
        arraylist.add("배드민턴");  //70

        arraylist2.add("10분");
        arraylist2.add("20분");
        arraylist2.add("30분");
        arraylist2.add("40분");
        arraylist2.add("50분");
        arraylist2.add("60분");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraylist);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraylist2);
        Spinner sp = (Spinner) findViewById(R.id.spinner3);
        Spinner sp2 = (Spinner) findViewById(R.id.spinner4);


        //sp.setPrompt("운동");
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);

        sp2.setAdapter(adapter2);
        sp2.setOnItemSelectedListener(this);

        Button OK2 = (Button) findViewById(R.id.button5);
        OK2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {;
                Intent intent3 = new Intent(sport.this, MainActivity.class);
                intent3.putExtra("ecal",cal);
                startActivity(intent3);
            }
        });
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        cal = 300+arg2;
        //Toast.makeText(this, arraylist.get(arg2), Toast.LENGTH_LONG).show();
        //Toast.makeText(this, arraylist2.get(arg2), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
