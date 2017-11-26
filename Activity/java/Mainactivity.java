package com.example.wyxiang.empty;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by wyxiang on 17-10-13.
 */

public class Mainactivity extends AppCompatActivity{

    private Button btn;
    private String TAG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TAG = "test";

        Log.d("test","onCreate");

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainactivity.this,SecondActivity.class);
                String data = "nihao";
                intent.putExtra("key",data);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart: ");
        Log.d("test","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("test","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("test","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("test","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("test","onDestroy");
    }
}
