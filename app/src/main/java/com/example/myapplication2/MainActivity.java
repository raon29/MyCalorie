package com.example.myapplication2;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    BroadcastReceiver myReceiver = new Broadcast();
    ArrayList<String> arraylist = new ArrayList<String>();
    Total total = new Total();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        total.add(intent.getIntExtra("scal", 0));
        total.add(intent.getIntExtra("pcal", 0));
        total.add(intent.getIntExtra("bacal", 0));
        total.sub(intent.getIntExtra("ecal", 0));

        TextView tv = (TextView)findViewById(R.id.carlorie);
        tv.setText("총 칼로리 "+total.getTotal_calorie());
        //ActionBar actionBar = getSupportActionBar();

        if(total.getTotal_calorie()>2500){
            ImageButton  ib = (ImageButton)findViewById(R.id.imageButton);
            ib.setImageResource(R.drawable.b);
        }

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(myReceiver, intentFilter);
        ImageButton myState = (ImageButton)findViewById(R.id.imageButton);
        myState.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, mystate.class);
                intent.putExtra("totalcal",total.getTotal_calorie());
                startActivity(intent);
            }
        });

        Button exercise = (Button) findViewById(R.id.button2);
        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, sport.class);
                startActivity(intent1);
            }
        });

        Button cal = (Button) findViewById(R.id.button3);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, selectfood.class);
                startActivity(intent2);
            }
        });
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Toast.makeText(this, arraylist.get(arg2), Toast.LENGTH_LONG).show();
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