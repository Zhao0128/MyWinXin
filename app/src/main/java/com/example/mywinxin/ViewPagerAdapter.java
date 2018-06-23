package com.example.mywinxin;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * MainActivity中的ViewPager适配器
 *
 * @author xukai
 * 2015年12月5日
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> frags; //所有的Fragment

    public ViewPagerAdapter(FragmentManager supportFragmentManager, List<Fragment> frags) {
        super(supportFragmentManager);
        this.frags = frags;
    }

    @Override
    public Fragment getItem(int arg0) {
        return frags.get(arg0);
    }

    @Override
    public int getCount() {
        return frags.size();
    }

}