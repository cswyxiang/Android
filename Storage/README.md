
### SharedPreferences

- MainActivity.class

```java
public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button save;
    private Button read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        save = (Button) findViewById(R.id.save);
        read = (Button) findViewById(R.id.read);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("string",editText.getText().toString());
                editor.apply();
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
                String string = preferences.getString("string","no");
                editText.setText(string);
            }
        });
    }
}
```

- activity_main.xml

```java
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.wyxiang.storage.MainActivity">

    <EditText
        android:id="@+id/editText"
        android:hint="在此输入"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
    <Button
        android:id="@+id/save"
        android:text="存储"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
    <Button
        android:id="@+id/read"
        android:text="读取"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</android.support.constraint.ConstraintLayout>
```


### LitePal

- 添加依赖

    compile 'org.litepal.android:core:1.6.0'
    
- main下新建文件夹assets，在其内新建 litepal.xml文件，修改如下

```java
<?xml version="1.0" encoding="utf-8"?>
<litepal>
    <dbname value="Users" ></dbname>

    <version value="1" ></version>

    <list>
    </list>
</litepal>
```

- 配置LitePalApplication，在AndroidManifest.xml中加入如下代码

    android:name="org.litepal.LitePalApplication"
    

- 创建数据库，新建一个类，User.class

```java
public class User extends DataSupport {
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
```

- 更新litepal.xml文件

```java
<litepal>
    <dbname value="Users" ></dbname>

    <version value="1" ></version>

    <list>
    <mapping class="com.android.Storage.User"></mapping>
    </list>
</litepal>
```

**数据库创建完毕**


- 增

```java
User user = new User();
    user.setName("zhangsan");
    user.setPwd("123456");
    user.setPhone("110");
    user.save();
```

- 删

```java
DataSupport.deleteAll(User.class,"name = ?","zhangsan");
```

- 查

```java
List<User> users = DataSupport.where("name = ?","zhangsan").find(User.class);
```

- 改

```java
User user = new User();
    user.setName("lisi");
    user.setPwd("123456");
    user.setPhone("110");
    user.save();
```

此时litepal不会重新建一条数据，而是直接更新

- LitePalDemo.class

```java
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
                
            }
        });

    }
}
```

- activity_litepaldemo.class

```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <LinearLayout
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="35dp">
        <TextView
            android:textSize="20sp"
            android:text="用户名： "
            android:layout_width="wrap_content"
            android:layout_height="match_parent" />
        <EditText
            android:id="@+id/name"
            android:layout_weight="1"
            android:layout_width="0dp"
            android:layout_height="match_parent" />
    </LinearLayout>
    <LinearLayout
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="35dp">
        <TextView
            android:textSize="20sp"
            android:text="密码 ： "
            android:layout_width="wrap_content"
            android:layout_height="match_parent" />
        <EditText
            android:id="@+id/pwd"
            android:layout_weight="1"
            android:layout_width="0dp"
            android:layout_height="match_parent" />
    </LinearLayout>
    <LinearLayout
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="35dp">
        <TextView
            android:textSize="20sp"
            android:text="手机号： "
            android:layout_width="wrap_content"
            android:layout_height="match_parent" />
        <EditText
            android:id="@+id/phone"
            android:layout_weight="1"
            android:layout_width="0dp"
            android:layout_height="match_parent" />
    </LinearLayout>

    <Button
        android:id="@+id/register"
        android:text="注册"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
</LinearLayout>
```
