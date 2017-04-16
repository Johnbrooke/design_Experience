package com.example.administrator.mydemo_kaiyuanceshi;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/12 0012.
 */
public class TabActivity extends FragmentActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    List<String> mTitle = new ArrayList<String>();
    List<Fragment> mFragment = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design_tablayout);
        init();

        MyAdapter adapter =new MyAdapter(getSupportFragmentManager(),mTitle,mFragment);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabsFromPagerAdapter(adapter);
    }

    private void init() {
        tabLayout = (TabLayout) findViewById(R.id.tiTitle);
        viewPager = (ViewPager) findViewById(R.id.vp_item);
        mTitle.add("One");
        mTitle.add("Two");
        mTitle.add("Three");

        mFragment.add(new TabOne());
        mFragment.add(new TabTwo());
        mFragment.add(new TabThree());

    }

}
