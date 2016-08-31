package com.chant.androidviewscrollerlab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.chant.androidviewscrollerlab.case1.Case1Activity;
import com.chant.androidviewscrollerlab.case2.Case2Activity;
import com.chant.androidviewscrollerlab.case3.Case3Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = new ListView(this);
        setContentView(listView);

        final List<Class<?>> classList = new ArrayList<Class<?>>();
        List<Map<String, String>> listAdapterData = new ArrayList<Map<String, String>>();

        {
            classList.add(Case1Activity.class);
            Map<String, String> listItemMap = new HashMap<String, String>();
            listItemMap.put("TITLE", "Case1 View的滚动（瞬时滚动）");
            listAdapterData.add(listItemMap);
        }
        {
            classList.add(Case2Activity.class);
            Map<String, String> listItemMap = new HashMap<String, String>();
            listItemMap.put("TITLE", "Case2 View的滚动（动画滚动）");
            listAdapterData.add(listItemMap);
        }
        {
            classList.add(Case3Activity.class);
            Map<String, String> listItemMap = new HashMap<String, String>();
            listItemMap.put("TITLE", "Case3 View的滚动（touch事件控制滚动）");
            listAdapterData.add(listItemMap);
        }

        listView.setAdapter(new SimpleAdapter(this, listAdapterData,
                android.R.layout.simple_list_item_1,
                new String[]{"TITLE"},
                new int[]{android.R.id.text1}));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, classList.get(position));
                startActivity(intent);
            }
        });
    }
}
