package com.example.pr2_gurdzhii;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //     if (savedInstanceState == null) {
        //       getSupportFragmentManager().beginTransaction()
        //             .add(R.id.fragment_container_view, ContentFragment.class, null)
        //           .commit();

        TextView text2 = (TextView) findViewById(R.id.wc2);
        text2.setText("Похоже, что у вас пока нету читательского билета!");
        TextView text3 = (TextView) findViewById(R.id.wc3);
        text3.setText("Нажмите клавишу 'Начать', чтобы перейти на этап регистрации билета.");



        TextView text1 = (TextView) findViewById(R.id.wc1);
        String str = getResources().getString(R.string.wc1);
        text1.setText(str);

        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_background));

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent in = new Intent();
                in.putExtra("message", "Вы успешно сформировали читательский билет");
                setResult(RESULT_OK, in);
                finish();
            }
        });

    }
    public void buttonDeclare(View view){
        Log.i(TAG,"Button has been pressed again");
    }

    ActivityResultLauncher<Intent> StartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == MainActivity2.RESULT_OK){
                        Intent intent = result.getData();
                        String str = intent.getStringExtra("message");
                        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
                    }
                }
            });

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null) return;
        String str = data.getStringExtra("message");
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
        TextView text1 = (TextView) findViewById(R.id.wc1);
        text1.setText(str);
        TextView text2 = (TextView) findViewById(R.id.wc2);
        text2.setText("Нажмите клавишу 'Начать'");
        TextView text3 = (TextView) findViewById(R.id.wc3);
        text3.setText("");
    }
    public void onProfileClick(View view){
        Intent in = new Intent(this, MainActivity2.class);
        in.putExtra("message", "Введите необходимые данные:");
        startActivity(in);
    }
}