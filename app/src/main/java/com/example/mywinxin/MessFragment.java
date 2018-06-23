package com.example.mywinxin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class MessFragment extends android.support.v4.app.Fragment {

    private ListView mainLv;

    private MessFragAdapter adapter;
    String[] Name = {"老邓头", "鸡毛", "小何", "曾金琳", "群聊"};

    String[] Speak = {"哈哈哈哈哈哈哈", "Hello!", "666", "[图片]", "嗯嗯"};

    int[] Image = {R.drawable.deng, R.drawable.chen, R.drawable.he, R.drawable.zeng, R.drawable.qunliao};

    String[] Time = {"上午9:40", "下午17:20", "上午12:00", "下午16:50", "上午6:10"};

    private List<HashMap<String, Object>> list;

    public MessFragment() {
        System.out.println("MainFragment Create!");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.framelayout, null);


        //填充数据
        setData();

        adapter = new MessFragAdapter(list, getActivity());
        mainLv = (ListView) view.findViewById(R.id.frag_main_lv);
        mainLv.setAdapter(adapter);
        return view;
    }

    public void setData() {
        list = new ArrayList<>();
        HashMap<String, Object> map = null;
        for (int i = 0; i < 5; i++) {
            map = new HashMap<>();
            map.put("image", Image[i]);
            map.put("name", Name[i]);
            map.put("time", Time[i]);
            map.put("message", Speak[i]);
            list.add(map);
        }
    }

}