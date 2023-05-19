package com.example.pr2_gurdzhii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.wc1);
        text.setText("11111111111");

        ImageView image = (ImageView) findViewById(R.id.Image1);
        image.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_background));

        //        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Log.i(TAG,"Button has been pressed");
//            }
//        });

    }
    public void buttonDeclare(View view){
        Log.i(TAG,"Button has been pressed again");
    }
    }
}