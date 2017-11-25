package com.example.wyxiang.mynote;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by wyxiang on 17-11-25.
 */

public class Add extends AppCompatActivity{
    private EditText etTitle;
    private EditText etContent;

    private String title = "";
    private String content = "";

    private Button sure;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        sure = (Button) findViewById(R.id.sure_add);


        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString();
                String content = etContent.getText().toString();
                Note note = new Note(title,content);
                note.save();
                finish();
            }
        });
    }
}
