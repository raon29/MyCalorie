package com.example.myapplication2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 이수연 on 2015-11-29.
 */
public class mystate extends AppCompatActivity {

    int totalCal = 0;
    final int remainCal = 0;
    final int standardCal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        totalCal = intent.getIntExtra("totalcal",0);
        setContentView(R.layout.activity_mystate);
        TextView tv = (TextView)findViewById(R.id.tcal);
        tv.setText("오늘의 총 칼로리 " + totalCal);

        TextView tv2 = (TextView)findViewById(R.id.tcal);
        tv2.setText("남은 칼로리 "+ (3000-totalCal));

        Button food = (Button) findViewById(R.id.button4);
        food.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(mystate.this, recommand.class);
            startActivity(intent1);
            }
        });
    }
}
