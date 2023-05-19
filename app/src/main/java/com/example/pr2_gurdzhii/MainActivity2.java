package com.example.pr2_gurdzhii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Random r = new Random();
        int randomNumber = (int)(Math.random()*100000);
        String str1 = String.valueOf(randomNumber);
        TextView ticket = (TextView) findViewById(R.id.ticket);
        ticket.setText(String.valueOf(randomNumber));

        String str;
        Bundle arguments = getIntent().getExtras();
        str = arguments.get("message").toString();

        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("message", str1);
                setResult(RESULT_OK, intent);
                finish();
            }
        });




    }
}