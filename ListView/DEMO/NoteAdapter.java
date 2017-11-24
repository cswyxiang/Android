package com.example.wyxiang.listviewdemo;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wyxiang on 17-11-24.
 */

public class NoteAdapter extends ArrayAdapter<Note>{
    private int resourceId;

    public NoteAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Note> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Note note = getItem(position); //获取当前Node实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView title = view.findViewById(R.id.note_title);
        TextView content = view.findViewById(R.id.note_content);
        title.setText(note.getTitle());
        content.setText(note.getContent());
        return view;
    }
}
