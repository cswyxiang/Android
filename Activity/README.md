# Activity

### 什么是活动


###  布局


1. 新建Add no activity项目  自己动手创建活动

2. Activity继承于AppCompatActivity(推荐，这是向前兼容新特性版的activity)或者Activity

3.  layout 控件的添加 (id、宽、高、布局)
 
4.  setContentView 设置布局

5.  Activity注册（AndroidManifest.xml）


```java
<intent-filter>
	<action android:name="android.intent.action.MAIN" />
	<category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
```


### activity的生命周期 


![](https://github.com/cswyxiang/Android/blob/master/Activity%20Training/imgs/lifecycle.png?raw=true) 


- 启动Activity：系统会先调用onCreate方法，然后调用onStart方法，最后调用onResume，Activity进入运行状态。
- 当前Activity被其他Activity覆盖其上或被锁屏：系统会调用onPause方法，暂停当前Activity的执行。
- 当前Activity由被覆盖状态回到前台或解锁屏：系统会调用onResume方法，再次进入运行状态。
- 当前Activity转到新的Activity界面或按Home键回到主屏，自身退居后台：系统会先调用onPause方法，然后调用onStop方法，进入停滞状态。
- 用户后退回到此Activity：系统会先调用onRestart方法，然后调用onStart方法，最后调用onResume方法，再次进入运行状态。
- 当前Activity处于被覆盖状态或者后台不可见状态，即第2步和第4步，系统内存不足，杀死当前Activity，而后用户退回当前Activity：再次调用onCreate方法、onStart方法、onResume方法，进入运行状态。
- 用户退出当前Activity：系统先调用onPause方法，然后调用onStop方法，最后调用onDestory方法，结束当前Activity。

ALT + ENTER导包

编写程序，验证上述活动的生命历程


### Intent的用法

1. 创建第二个活动和布局并注册

2. 创建button按钮

3. findViewbyId的用法

	btn = (Button) findViewById(R.id.btn);

4. OnClickListener监听

```java
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Mainactivity.this,SecondActivity.class);
        startActivity(intent);
    }
});
```

5. intent跳转


```java
Intent intent = new Intent(Mainactivity.this,SecondActivity.class);
startActivity(intent);
```

- finish() 结束活动进程

6. Intent传输数据

- 第一个活动

```java
Intent intent = new Intent(Mainactivity.this,SecondActivity.class);
String data = "nihao";
intent.putExtra("key",data);
startActivity(intent);
```

- 第二个活动

```java
Intent intent = getIntent();
String data = intent.getStringExtra("key");
Log.d("key",data);
```
	
7. key 和 value


singleTask  一个活动只有一个，当启动该活动时系统优先在返回栈中检查是否存在该活动的实例，如果发现已存在则直接使用该实例，并把这个活动之上的活动统统出栈。

Toast

	Toast.makeText(FirstActivity.this,"这是一条提示",Toast.LENGTH_LONG).show();
	
	
EditText


```
<EditText
        android:maxLines="1"
        android:id="@+id/et"
        android:hint="这是一个EditText"
        android:inputType="date"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```

inputType：time、phone、numberPassword、textPassword等

maxLines 指定最大行数  、minLines

获取EditText的文本

```java
EditText et = findViewById(R.id.et);
String s = et.getText().toString();
```

ImageView


```
<ImageView
        android:id="@+id/image_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@mipmap/ic_launcher"/>


ImageView img = findViewById(R.id.image_view);
img.setImageResource(R.mipmap.ic_launcher_round);
```

ProgressBar


```
 
<ProgressBar
        android:id="@+id/progress_bar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
        
```

```
if(progressBar.getVisibility() == View.GONE){
            progressBar.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.GONE);
        }

```


gravity的用法