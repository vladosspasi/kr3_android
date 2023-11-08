package com.example.kr3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int flight = 0;
    int cost = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b_buy = findViewById(R.id.button_buy);

        EditText et_name = findViewById(R.id.editTextText);
        EditText et_secname = findViewById(R.id.editTextText2);
        EditText et_child = findViewById(R.id.editTextNumber2);
        EditText et_adult = findViewById(R.id.editTextNumber);
        EditText et_price = findViewById(R.id.editTextText3);

        Spinner spin = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.flights,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        et_price.setText(Integer.toString(cost));

        b_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name;
                String secname;
                int ch_num;
                int ad_num;

                try{
                    name = et_name.getText().toString();
                    secname = et_secname.getText().toString();
                    ch_num = Integer.parseInt(et_child.getText().toString());
                    ad_num = Integer.parseInt(et_adult.getText().toString());
                } catch (Exception ex){
                    Toast.makeText(v.getContext(),"Нужно заполнить все поля!", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                intent.putExtra("cost", cost);
                intent.putExtra("flight", flight);
                intent.putExtra("name", name);
                intent.putExtra("secname", secname);
                intent.putExtra("ch_num", ch_num);
                intent.putExtra("ad_num", ad_num);

                startActivity(intent);

            }
        });

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case 0:
                        et_price.setText("1000");
                        flight = 0;
                        cost = 1000;
                        break;
                    case 1:
                        et_price.setText("2000");
                        flight = 1;
                        cost = 2000;
                        break;

                    case 2:
                        et_price.setText("3000");
                        flight = 2;
                        cost = 3000;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

    }
}