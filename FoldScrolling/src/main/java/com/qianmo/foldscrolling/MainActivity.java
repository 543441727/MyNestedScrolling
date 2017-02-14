package com.qianmo.foldscrolling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qianmo.foldscrolling.adapter.MyAdapter;
import com.qianmo.foldscrolling.view.ElemeDetailView;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    ElemeDetailView edv;
    View edv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter(MainActivity.this));

        //监听edv_content的位置改变，并改变edv_title的透明度
        edv = (ElemeDetailView) findViewById(R.id.edv);
        edv_title = findViewById(R.id.edv_title);
        edv.setListener(new ElemeDetailView.Listener() {
            @Override
            public void onContentPostionChanged(float fraction) {
                edv_title.setAlpha(1 - fraction);
            }
        });
    }


}
