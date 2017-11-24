package com.example.wyxiang.storage;

import org.litepal.crud.DataSupport;

/**
 * Created by wyxiang on 17-11-2.
 */

public class User extends DataSupport{
    private String name;
    private String pwd;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
