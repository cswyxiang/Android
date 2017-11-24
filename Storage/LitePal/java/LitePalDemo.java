package com.example.wyxiang.storage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by wyxiang on 17-11-2.
 */

public class LitePalDemo extends AppCompatActivity{

    private EditText et_name;
    private EditText et_phone;
    private EditText et_pwd;

    private Button register;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litepaldemo);

        et_name = (EditText) findViewById(R.id.name);
        et_pwd = (EditText) findViewById(R.id.pwd);
        et_phone = (EditText) findViewById(R.id.phone);

        register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setName("zhangsan");
                user.setPwd("123456");
                user.setPhone("110");
                user.save();
                User user1 = new User();
                user.setName("lisi");
                user.setPwd("123456");
                user.setPhone("110");
                user.save();

                List<User> users = DataSupport.findAll(User.class);
                for(User myname:users ){
                    Log.d("name",myname.getName());
                }
            }
        });

    }
}
