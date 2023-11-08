package com.example.kr3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);



        Button b_back = findViewById(R.id.button_back);
        TextView t = findViewById(R.id.textView8);

        Intent intent = getIntent();
        int ch = intent.getIntExtra("ch_num",0);
        int ad = intent.getIntExtra("ad_num",0);
        int cost = intent.getIntExtra("cost",0);
        double c = cost* ad + cost/2*ch;

        t.setText("Число взрослых: "+ad+"\n" + "Число детей: "+ch+"\n"+ "Общая цена: "+c+"\n");

        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });


    }
}