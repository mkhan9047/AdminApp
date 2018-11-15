package com.teammanagement.adminapp.View.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //*make the statusbar transparent if version is above kitkat*//*

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);// SDK21
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }

        /*type casting*/
        initViews();

        /*pager builder*/
        splashPagerBuilder();

        /*text click listener*/
        textsClickListener();
    }

    private void initViews() {

        linePageIndicator = findViewById(R.id.indicator_pager);
        splashPager = findViewById(R.id.splash_pager);

        skip = findViewById(R.id.txt_skip);
        next = findViewById(R.id.txt_next);

    }

    private void textsClickListener() {
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, AuthActivity.class);
                // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                SplashActivity.this.overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
                finish();

            }
        });

        splashPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == splashPager.getChildCount()) {
                    count = count + 1;
                } else {
                    count = 0;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                splashPager.setCurrentItem(splashPager.getCurrentItem() + 1, true);

                if (splashPager.getCurrentItem() == splashPager.getChildCount()) {

                    count++;

                    if (count == 1) {
                        Intent intent = new Intent(SplashActivity.this, AuthActivity.class);
                       // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        SplashActivity.this.overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
                        finish();

                    } else if (count == 3) {
                        Intent intent = new Intent(SplashActivity.this, AuthActivity.class);
                       // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        SplashActivity.this.overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
                        finish();
                    }

                }


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
