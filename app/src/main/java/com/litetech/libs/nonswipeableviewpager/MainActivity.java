package com.litetech.libs.nonswipeableviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.litetech.libs.nonswipeviewpager.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int pg = 5;
    private  int st = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager pager = findViewById(R.id.pager);
        AppCompatButton next = findViewById(R.id.next);
        List<Fragment> fragments = new ArrayList<>();

        for (int i = 1; i < 6 ; i++) {
            fragments.add(BlankFragment.newInstance(String.valueOf(i)));
        }

        pager.setAdapter(new ViewPagerAdapter(fragments,getSupportFragmentManager()));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (st < pg){
                    pager.setCurrentItem(st);
                    st++;
                }
            }
        });


    }



    class ViewPagerAdapter extends FragmentStatePagerAdapter{

        private List<Fragment> fragments;


        public ViewPagerAdapter(List<Fragment> fragments,FragmentManager fm) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
