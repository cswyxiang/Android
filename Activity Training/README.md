

#### Activity

##### 什么是活动

##### 布局

##### 新建Add no activity项目  自己动手创建活动

##### Activity继承于AppCompatActivity(推荐，这是向前兼容新特性版的activity)或者Activity

##### layout 控件的添加，需要的话介绍一下控件 (id、宽、高、布局)
 
##### setContentView 设置布局

##### Activity注册（AndroidManifest.xml）

	<intent-filter>
		        <action android:name="android.intent.action.MAIN" />

		        <category android:name="android.intent.category.LAUNCHER" />
	</intent-filter>


##### activity的生命周期 


![](/home/wyxiang/Documents/impress.js-master/img/lifecycle.png) 


- 启动Activity：系统会先调用onCreate方法，然后调用onStart方法，最后调用onResume，Activity进入运行状态。
- 当前Activity被其他Activity覆盖其上或被锁屏：系统会调用onPause方法，暂停当前Activity的执行。
- 当前Activity由被覆盖状态回到前台或解锁屏：系统会调用onResume方法，再次进入运行状态。
- 当前Activity转到新的Activity界面或按Home键回到主屏，自身退居后台：系统会先调用onPause方法，然后调用onStop方法，进入停滞状态。
- 用户后退回到此Activity：系统会先调用onRestart方法，然后调用onStart方法，最后调用onResume方法，再次进入运行状态。
- 当前Activity处于被覆盖状态或者后台不可见状态，即第2步和第4步，系统内存不足，杀死当前Activity，而后用户退回当前Activity：再次调用onCreate方法、onStart方法、onResume方法，进入运行状态。
- 用户退出当前Activity：系统先调用onPause方法，然后调用onStop方法，最后调用onDestory方法，结束当前Activity。

##### ALT + ENTER导包，类似于C语言的include

##### 编写程序，验证上述活动的生命历程


#### Intent的用法

##### 创建第二个活动和布局并注册

##### 创建button按钮

##### findViewbyId的用法

	btn = (Button) findViewById(R.id.btn);

##### OnClickListener监听

	btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainactivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

##### intent跳转


	Intent intent = new Intent(Mainactivity.this,SecondActivity.class);
	startActivity(intent);

##### finish 结束活动进程

##### Intent传输数据

第一个活动

	Intent intent = new Intent(Mainactivity.this,SecondActivity.class);
	String data = "nihao";
	intent.putExtra("key",data);
	startActivity(intent);


第二个活动

	Intent intent = getIntent();
	String data = intent.getStringExtra("key");
	Log.d("key",data);
	
	
key 和 value



