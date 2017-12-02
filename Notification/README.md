#### Notification的基本用法

1. 首先需要一个NotificationManger来对通知进行管理,可以调用Context的getSystemService()方法获取到。getSystemService()方法接收一个字符串参数用于确实获取系统的哪个服务，这里传入Context.NOTIFICATION_SERVICE即可，代表获取一个通知服务的实例。

```java
NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
```

2. 接下来需要一个Builder构造器来创建一个Notification对象，各个版本都会对通知这部分功能做一些改变，所以我们选择一个兼容的API，这里用NotificationCompat类

```java
Notification notification = new NotificationCompat.Builder(MainActivity.this)
        .setContentTitle("This is Context Title")
        .setContentText("This is Context Text")
        .setWhen(System.currentTimeMillis())
        .setSmallIcon(R.mipmap.ic_launcher)
        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
        .build();
```
- 其中Builder需要传一个Context对象
- setContentTitle()方法用于指定通知的标题内容
- setContentText()方法用于指定通知的正文内容
- setWhen()方法用于制定通知被创建的时间
- setSmallIcon()方法用于设置通知的小图标
- setLargeIcon()方法用于设置通知的大图标
- BitmapFactory.decodeResource()方法在Activity中将资源图片转换成Bitmap对象

3. 调用NotificationManger的notify()方法即可显示通知

```java
manager.notify(1,notification);
```

- 第一个参数是id，第二个参数是Notification对象


4. 设置点击事件，使用PendingIntent，PendingIntent与Intent很相似，区别就在于PendingIntent更倾向于在某个合适的时机去执行某个动作

```java
Intent intent = new Intent(MainActivity.this,SecondActivity.class);
PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,intent,0);
```

```java
Notification notification = new NotificationCompat.Builder(MainActivity.this)
        .setContentTitle("This is Context Title")
        .setContentText("This is Context Text")
        .setWhen(System.currentTimeMillis())
        .setSmallIcon(R.mipmap.ic_launcher)
        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
        .setContentIntent(pi)
        .build();
```

- 这里首先使用Intent表达出我们想要启动NotificationActivity的意图，然后将构建好的Intent对象传入到PendingIntent.getActivity()方法里

5. 设置自动消失

```java
.setAutoCancel(true)
```


#### Notification的进阶

1. 设置通知震动

```java
<uses-permission android:name="android.permission.VIBRATE"/>
```

```java
.setVibrate(new long[]{0,1000,1000,1000})
```

- 参数是一个长整形的数组，用于设置手机静止和振动的时长，以毫秒为单位，偶数表示静止时长，奇数表示振动时长，所以上述设置是振动1s，静止1s，再振动1s

2. 设置LED灯闪烁

```java
.setLights(Color.GREEN,1000,1000)
```

- setLights()传入3个参数，第一个指定LED灯的颜色，第二个指定LED灯亮起的时长，第二个指定LED灯熄灭的时长，以毫秒为单位

#### Notification的高级功能

1. 设置长文本

```java
.setStyle(new NotificationCompat.BigTextStyle().bigText("123456789012345678923456782345678934567898765432345678765"))
```

2. 设置大图片

```java
.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher)))
```


