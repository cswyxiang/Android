package com.example.wyxiang.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Note> noteList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Note note = new Note("123","1234");
        noteList.add(note);
        Note note1 = new Note("123","1234");
        noteList.add(note1);
        Note note2 = new Note("123","1234");
        noteList.add(note2);
        NoteAdapter adapter = new NoteAdapter(MainActivity.this,R.layout.node_item,noteList);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Note note = noteList.get(i); // 获取点击的对象
                /* 此处写处理逻辑 */
            }
        });
    }
}
