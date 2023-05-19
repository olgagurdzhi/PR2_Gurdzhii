package com.example.pr2_gurdzhii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.wc1);
        text.setText("11111111111");

        ImageView image = (TextView) findViewById(R.id.Image1);
        image.setImageDrawable(getResources().getDrawable(R.drawable.book_svgrepo_com));
    }
}