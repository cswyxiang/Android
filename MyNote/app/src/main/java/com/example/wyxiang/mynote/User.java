package com.example.wyxiang.mynote;

import org.litepal.crud.DataSupport;

/**
 * Created by wyxiang on 17-11-25.
 */

public class User extends DataSupport{
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
