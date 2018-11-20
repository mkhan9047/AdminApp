package com.teammanagement.adminapp.View.Activity;

import android.icu.text.LocaleDisplayNames;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.teammanagement.adminapp.Helper.Util;
import com.teammanagement.adminapp.R;
import com.teammanagement.adminapp.View.Fragment.ForgotPasswordFragment;
import com.teammanagement.adminapp.View.Fragment.SignInFragment;
import com.teammanagement.adminapp.View.Fragment.SignUpFragment;

public class AuthActivity extends AppCompatActivity {

    Fragment currentFragment;
    FrameLayout fragmentContainer;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);


        initView();

        fragmentTransition(new SignInFragment());

    }


    private void initView() {
        fragmentContainer = findViewById(R.id.auth_container);
    }


    public void fragmentTransition(Fragment fragment) {
        this.currentFragment = fragment;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.auth_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {

        if (currentFragment instanceof SignUpFragment || currentFragment instanceof ForgotPasswordFragment) {

            this.fragmentTransition(new SignInFragment());

        } else if (currentFragment instanceof SignInFragment) {

            count++;

            if (count == 1) {

                Toast.makeText(this, "Press again to exit!", Toast.LENGTH_SHORT).show();

            } else if (count == 2) {

                super.onBackPressed();
            }
        }

    }
}
