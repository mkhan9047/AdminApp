package com.teammanagement.adminapp.View.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.teammanagement.adminapp.R;
import com.teammanagement.adminapp.View.Adapters.SplashPagerAdapter;
import com.teammanagement.adminapp.View.Fragment.SplashOneFragment;
import com.teammanagement.adminapp.View.Fragment.SplashThreeFragment;
import com.teammanagement.adminapp.View.Fragment.SplashTwoFragment;
import com.viewpagerindicator.LinePageIndicator;

public class SplashActivity extends AppCompatActivity {

    ViewPager splashPager;
    LinePageIndicator linePageIndicator;
    TextView skip, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        /*type casting*/
        initViews();

        /*pager builder*/
        splashPagerBuilder();

        textsClickListener();
    }

    private void initViews() {

        linePageIndicator = findViewById(R.id.indicator_pager);
        splashPager = findViewById(R.id.splash_pager);

        skip = findViewById(R.id.txt_skip);
        next = findViewById(R.id.txt_next);

    }

    private void textsClickListener(){
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                splashPager.setCurrentItem(splashPager.getCurrentItem() + 1, true);


            }
        });
    }

    private void splashPagerBuilder() {

        SplashPagerAdapter adapter = new SplashPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SplashOneFragment());
        adapter.addFragment(new SplashTwoFragment());
        adapter.addFragment(new SplashThreeFragment());

        splashPager.setAdapter(adapter);

        linePageIndicator.setViewPager(splashPager);
    }
}
