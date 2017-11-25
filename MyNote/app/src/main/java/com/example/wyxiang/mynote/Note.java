package com.example.wyxiang.mynote;

import org.litepal.crud.DataSupport;

/**
 * Created by wyxiang on 17-11-25.
 */

public class Note extends DataSupport{
    private String title;
    private String content;

    public Note(String title,String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
