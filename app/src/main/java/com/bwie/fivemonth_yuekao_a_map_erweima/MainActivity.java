package com.bwie.fivemonth_yuekao_a_map_erweima;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager viewpager;
    private LinearLayout ll;

    List<ImageView> imageViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager = (ViewPager) findViewById(R.id.viewpager);
        ll = (LinearLayout) findViewById(R.id.ll);

        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                Fragment fragment = null;

                if (position == 0) {

                    fragment = new OneFragment();

                }else if(position == 1) {

                    fragment = new TwoFragment();

                }

                return fragment;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < imageViews.size(); i++) {

                    if (i == position){

                        imageViews.get(i).setImageResource(R.drawable.dot_focus);

                    }else{
                        imageViews.get(i).setImageResource(R.drawable.dot_normal);

                    }

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        for (int i = 0; i < 2; i++) {

            ImageView iv = new ImageView(this);

            if (i == 0) {

                iv.setImageResource(R.drawable.dot_focus);

            }else{
                iv.setImageResource(R.drawable.dot_normal);

            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(10,0,10,0);

            ll.addView(iv,params);

            imageViews.add(iv);

        }

    }
}
