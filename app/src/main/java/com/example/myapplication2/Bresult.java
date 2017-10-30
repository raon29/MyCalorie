package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by PSH on 2015-11-29.
 */
public class Bresult extends AppCompatActivity {
    String name;
    int cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bresult);
        Intent intent = getIntent();
        check(intent);
    }

    public void check(Intent intent){
        TextView tv = (TextView)findViewById(R.id.b_name);
        TextView tv2 = (TextView)findViewById(R.id.cal);
        if(intent.getStringExtra("barcode").equals("8801062641260")){
            name = "빼빼로 초코 쿠키";
            cal = 165;
        }
        else if(intent.getStringExtra("barcode").equals("8801062333257")){
            name = "레몬 목캔디";
            cal = 30;
        }
        else{
            name = "등록되어있지 않은 바코드 입니다.";
        }
        tv.setText(name);
        tv2.setText(""+cal);
    }

    public void onclick(View view) {
        Toast.makeText(this, name, Toast.LENGTH_LONG).show();
        Intent parintent = new Intent(this,MainActivity.class);
        parintent.putExtra("bcal",cal);
        startActivity(parintent);
        finish();
    }
}
