package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 이수연 on 2015-11-29.
 */
public class selectfood extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int select;
    ArrayList<String> arraylist = new ArrayList<String>();
    ArrayList<String> arraylist2 = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectfood);

        Button OK = (Button) findViewById(R.id.OK);
        OK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(selectfood.this, MainActivity.class);
                intent1.putExtra("scal",select);
                startActivity(intent1);
                finish();
            }
        });

        Button barcodeAdd = (Button) findViewById(R.id.barcodeButton);
        barcodeAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent("com.google.zxing.client.android.SCAN");
                intent2.putExtra("SCAN_MODE", "ALL");
                startActivityForResult(intent2, 0);
            }
        });

        arraylist.add("면류");
        arraylist.add("곡류");
        arraylist.add("가공식품");
        arraylist.add("음료");
        arraylist.add("과일");
        arraylist.add("유제품");

        arraylist2.add("라면");
        arraylist2.add("냉면");
        arraylist2.add("국수");
        arraylist2.add("우동");
        arraylist2.add("짜장면");
        arraylist2.add("짬뽕");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraylist);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraylist2);

        Spinner sp1 = (Spinner)findViewById(R.id.spinner);
        Spinner sp2 = (Spinner)findViewById(R.id.spinner5);

        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(this);

        sp2.setAdapter(adapter2);
        sp2.setOnItemSelectedListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        TextView tv = (TextView) findViewById(R.id.textView);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                //tv.setText(contents +"\n" +format);
                //showDialog(R.string.result_succeeded, "Format: " + format + "\nContents: " + contents);
                Intent bintent = new Intent(this, Bresult.class);
                bintent.putExtra("barcode",contents);
                startActivity(bintent);
                finish();
            } else if (resultCode == RESULT_CANCELED) {
                //showDialog(R.string.result_failed, getString(R.string.result_failed_why));
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        select = 300+position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
