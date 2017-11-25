package com.example.wyxiang.mynote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPassword;

    private Button btnLoad;
    private Button btnReg;

    private String name;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.et_name);
        etPassword = (EditText) findViewById(R.id.et_password);

        btnLoad = (Button) findViewById(R.id.load);
        btnReg = (Button) findViewById(R.id.register);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = etName.getText().toString();
                password = etPassword.getText().toString();

                if (name.equals("")){
                    Toast.makeText(MainActivity.this,"账号不能为空",Toast.LENGTH_SHORT).show();
                }else if (password.equals("")){
                    Toast.makeText(MainActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    List<User> users = DataSupport.findAll(User.class);
                    for (User myuser : users){
                        if (name.equals(myuser.getName())){
                            if (password.equals(myuser.getPassword())){
                                /* 登陆成功 */
                                //Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this,MyNote.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(MainActivity.this,"密码错误",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    Toast.makeText(MainActivity.this,"账号错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
