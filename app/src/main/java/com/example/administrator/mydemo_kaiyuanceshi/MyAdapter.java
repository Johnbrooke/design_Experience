package com.example.administrator.mydemo_kaiyuanceshi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/4/14 0014.
 */
public class MyAdapter  extends FragmentPagerAdapter{
    List<String> title;
    List<Fragment> views;

    public MyAdapter(FragmentManager fm,List<String> title,List<Fragment> views) {
        super(fm);
        this.title = title;
        this.views = views;
    }

    @Override
    public Fragment getItem(int position) {
        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
