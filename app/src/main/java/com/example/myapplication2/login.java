package com.example.myapplication2;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 이수연 on 2015-11-29.
 */

public class login extends AppCompatActivity {
    EditText nameText;
    EditText ageText;
    Spinner maleText;
    EditText weightText;
    Button login;
    ArrayList<String> arraylist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nameText = (EditText) findViewById(R.id.editText1);
        ageText = (EditText) findViewById(R.id.editText2);
        maleText = (Spinner) findViewById(R.id.spinner1);
        weightText = (EditText) findViewById(R.id.editText4);
        login = (Button) findViewById(R.id.button1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(login.this, MainActivity.class);
                intent1.putExtra("name", nameText.getText().toString());
                intent1.putExtra("age", ageText.getText().toString());
                intent1.putExtra("male", maleText.getSelectedItem().toString());
                intent1.putExtra("weight", weightText.getText().toString());
                startActivity(intent1);
            }
        });

        arraylist.add("남성");
        arraylist.add("여성");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraylist);
        Spinner sp3 = (Spinner) findViewById(R.id.spinner1);
        sp3.setAdapter(adapter);
        //sp3.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Toast.makeText(this, arraylist.get(arg2), Toast.LENGTH_LONG).show();
    }


    public void onNothingSelected(AdapterView<?> arg0) {

    }


}
