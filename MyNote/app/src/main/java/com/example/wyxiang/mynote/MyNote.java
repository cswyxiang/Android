package com.example.wyxiang.mynote;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyxiang on 17-11-25.
 */

public class MyNote extends AppCompatActivity{

    private Button AddNote;

    private  List<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mynote);
        notes = DataSupport.findAll(Note.class);
        NoteAdapter adapter = new NoteAdapter(MyNote.this,R.layout.note_item,notes);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        AddNote = (Button) findViewById(R.id.add_note);

        AddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyNote.this, Add.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Note note = notes.get(i);
                Intent intent = new Intent(MyNote.this, Fix.class);
                intent.putExtra("title",note.getTitle());
                intent.putExtra("content",note.getContent());
                startActivity(intent);
            }
        });
    }
}
