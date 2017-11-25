package com.example.wyxiang.mynote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by wyxiang on 17-11-25.
 */

public class Register extends AppCompatActivity{

    private EditText etName;
    private EditText etPassword;

    private Button sure;

    private String name;
    private String password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.et_name1);
        etPassword = (EditText) findViewById(R.id.et_password1);
        sure = (Button) findViewById(R.id.sure);
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = etName.getText().toString();
                password = etPassword.getText().toString();

                if (name.equals("")){
                    Toast.makeText(Register.this,"账号不能为空",Toast.LENGTH_SHORT).show();
                }else if (password.equals("")){
                    Toast.makeText(Register.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    User user = new User();
                    user.setName(name);
                    user.setPassword(password);
                    user.save();
                    Toast.makeText(Register.this,"注册成功",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
