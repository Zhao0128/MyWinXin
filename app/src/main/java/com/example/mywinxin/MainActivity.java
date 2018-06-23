package com.example.mywinxin;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.app.FragmentManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {
    Context context;
    private RadioGroup radioGroup;
    private FrameLayout wx_content;
    private MessFragment fg1, fg2, fg3, fg4;
    private FragmentManager fManager;
    private RadioButton wx_mess;
    private List<android.support.v4.app.Fragment> frags;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frags = new ArrayList<android.support.v4.app.Fragment>();
        frags.add(new MessFragment());
        frags.add(new ContactsFragment());
        frags.add(new DiscoverFragment());
        frags.add(new SettingFragment());

        viewPager = findViewById(R.id.main_viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), frags);
        viewPager.setAdapter(adapter);

        //设置监听器
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        wx_mess = findViewById(R.id.wx_message);
        radioGroup = findViewById(R.id.radio);
        fManager = getFragmentManager();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //        FragmentTransaction fragmentTransaction = fManager.beginTransaction();
//        hideAllFragment(fragmentTransaction);
                int i = -1;
                switch (checkedId) {
                    case R.id.wx_message:
                        i = 0;
                        break;
                    case R.id.wx_person:
                        i = 1;
                        break;
                    case R.id.wx_discover:
                        i = 2;
                        break;
                    case R.id.wx_my:
                        i = 3;
                        break;
                }
                //设置当前Fragment
                viewPager.setCurrentItem(i);
            }
        });
        wx_mess.setChecked(true);  //模拟一次点击，既进去后选择第一项
    }

//    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
//        if (fg1 != null) fragmentTransaction.hide(fg1);
//        if (fg2 != null) fragmentTransaction.hide(fg2);
//        if (fg3 != null) fragmentTransaction.hide(fg3);
//        if (fg4 != null) fragmentTransaction.hide(fg4);
//    }


}