## ListView

#### 最简单的ListView

1. 引入布局

```java
<ListView
    android:id="@+id/listView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

2. 创建适配器

> Adapter是连接后端数据和前端显示的适配器接口，是数据和UI（View）之间一个重要的纽带。在常见的View(ListView,GridView)等地方都需要用到Adapter。
> 

![]()

- 按我的理解就是我们要用adapter来告诉我们的ListView要显示什么。

- Android自带了很多Adapter类型，这里选择ArrayAdapter来做示范：

```java
ArrayAdapter<String> adapter = new ArrayAdapter<String>(
    MainActivity.this,android.R.layout.simple_list_item_1,name);
```

```java
private String[] name ={"zhang","li","wang","wei","you","shi"};
```

- 上面我们new了一个新的ArrayAdapter对象，并传给了它三个参数，第一个是`Context context`,也就是上下文，这里我们把MainActivity传进去，第二个是`int resource`,是一个资源id，也就是我们ListView要使用的每一个Item的布局文件，这里我们只显示字符串的话，就直接使用android给提供的布局`android.R.layout.simple_list_item_1`,第三个则是`T[] objects`，是一个对象数组，这里我们Array类型设置的是String，所以要传入一个字符串数组data。


3. 初始化ListView

```java
ListView listView = (ListView) findViewById(R.id.listView);
listView.setAdapter(adapter);
```


#### 自定义ListView

1. 引入布局

```java
<ListView
    android:id="@+id/listView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

2. 自定义类，用作ListView的适配类型

```java
public class Note {
    private String title;
    private String content;
    
    public Note(String title, String content){
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


```
3. 自定义Item，新建xml文件`note_item`

```java
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <LinearLayout
        android:layout_marginLeft="40dp"
        android:layout_marginRight="40dp"
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <TextView
            android:textSize="20sp"
            android:text="none"
            android:id="@+id/note_title"
            android:layout_width="match_parent"
            android:textStyle="bold"
            android:layout_height="25dp" />
        <TextView
            android:text="none"
            android:id="@+id/note_content"
            android:layout_width="match_parent"
            android:layout_height="50dp" />
    </LinearLayout>
</LinearLayout>
```

4. 自定义ArrayAdapter，新建类 NoteAdapter

```java
public class NoteAdapter extends ArrayAdapter<Note>{
    private int resourceId;
    
    public NoteAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Note> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Note note = getItem(position); //获取当前Node实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView title = view.findViewById(R.id.note_title);
        TextView content = view.findViewById(R.id.note_content);
        title.setText(note.getTitle());
        content.setText(note.getContent());
        return view;
    }
}

```

- 这里NoteAdapter继承了ArrayAdapter类，并重写了父类的一组构造函数，用于将上下文、ListView的Item的id和数据对象传进来。同时又重写了弗雷德getView()方法，在这个方法中，我们通过`getItem`方法获取到当项的实例，然后用`LayoutInflater`来为这个Item加载我们传入的布局。

- 关于`LayoutInflater`的用法可以参考  [ Android LayoutInflater原理分析](http://blog.csdn.net/guolin_blog/article/details/12921889)

5. 修改MainActivity的代码为

```java
public class MainActivity extends AppCompatActivity {

    private List<Note> noteList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Note note = new Note("123","1234");
        noteList.add(note);
        Note note1 = new Note("123","1234");
        noteList.add(note1);
        Note note2 = new Note("123","1234");
        noteList.add(note2);
        NoteAdapter adapter = new NoteAdapter(MainActivity.this,R.layout.node_item,noteList);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}

```
#### ListView的点击事件

```java
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Note note = noteList.get(i); // 获取点击的对象
            /* 此处写处理逻辑 */
        }
    });
```
