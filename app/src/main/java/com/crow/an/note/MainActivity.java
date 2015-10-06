package com.crow.an.note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.LogRecord;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.os.Handler;


import com.crow.an.R;

public class MainActivity extends AppCompatActivity
{

    private static final int SHOW_UPDATE = 1;
    public String EXPANDED = "EXPANDED";
    public NotepadAdapter adapter;
    public ArrayList<Map<String, Object>> itemList;
    public ListView listView;
    public int number;
    public Button numberButton;
    public Button topButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        this.numberButton = ((Button)findViewById(R.id.number));
        this.topButton = ((Button)findViewById(R.id.topButton));
        this.listView = ((ListView) findViewById(R.id.listview));
        // this.listView.setDivider(getResources().getDrawable(android.R.color.white));
        this.listView.setDivider(null);
        this.listView.setOnItemClickListener(new ItemClick());
        this.topButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO �Զ����ɵķ������
                Intent intent = new Intent(MainActivity.this,
                        WriteActivity.class);
                startActivity(intent);

            }
        });
        showUpdate();
    }

    @Override
    public void onResume() {
        // TODO 自动生成的方法存根
        super.onResume();
        showUpdate();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        showUpdate();
    }


    public void showUpdate() {

        this.itemList = new ArrayList<Map<String, Object>>();
        SQLiteDatabase localSqLiteDatabase = new SqliteHelper(MainActivity.this, null, null,0).getReadableDatabase();
        Iterator<Notepad> localIterator = new ChangeSqlite().query(
                localSqLiteDatabase).iterator();
        while (true) {
            if (!localIterator.hasNext()) {
                Collections.reverse(this.itemList);
                this.adapter = new NotepadAdapter(MainActivity.this, this.itemList);
                this.listView.setAdapter(this.adapter);
                if (this.itemList.size()==0) {
                    number=0;
                    this.numberButton.setText("");
                }
                return;
            }
            Notepad localNotepad = (Notepad) localIterator.next();
            HashMap<String, Object> localHashMap = new HashMap<String, Object>();
            localHashMap.put("titleItem", localNotepad.getTitle());
            localHashMap.put("dateItem", localNotepad.getdata());
            localHashMap.put("contentItem", localNotepad.getContent());
            localHashMap.put("idItem", localNotepad.getid());
            // Ĭ�ϱʼ���̯�������۵���trueΪ̯��
            localHashMap.put("EXPANDED", Boolean.valueOf(true));
            this.itemList.add(localHashMap);
            this.number = this.itemList.size();
            System.out.println("number----------number=" + number);
            this.numberButton.setText("(" + this.number + ")");
        }

    }

    class ItemClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> paramAdapterView,
                                View paramView, int paramInt, long paramLong) {
            // TODO �Զ����ɵķ������
            System.out.println("item----------click");
            Map<String, Object> localMap = MainActivity.this.itemList
                    .get(paramInt);
            if (((Boolean) localMap.get("EXPANDED")).booleanValue()) {
                localMap.put("EXPANDED", Boolean.valueOf(false));
            } else {
                localMap.put("EXPANDED", Boolean.valueOf(true));
            }
            MainActivity.this.adapter.notifyDataSetChanged();
        }

    }


   /* class mhandler extends Handler{

        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
                case SHOW_UPDATE:
                    showUpdate();
                    break;
            }
            super.handleMessage(msg);
        }
    }*/


}
