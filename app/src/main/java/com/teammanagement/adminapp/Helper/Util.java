package com.teammanagement.adminapp.Helper;

import android.content.Context;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.teammanagement.adminapp.R;

import java.lang.reflect.Field;

public class Util {
    public static double getDeviceDensity(Context context) {
        double deviceDensity;
        switch (context.getResources().getDisplayMetrics().densityDpi) {
            case DisplayMetrics.DENSITY_LOW:
                deviceDensity = 0.75 /*+ " ldpi"*/;
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                deviceDensity = 1.0 /*+ " mdpi"*/;
                break;
            case DisplayMetrics.DENSITY_HIGH:
                deviceDensity = 1.5 /*+ " hdpi"*/;
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                deviceDensity = 2.0 /*+ " xhdpi"*/;
                break;
            case DisplayMetrics.DENSITY_XXHIGH:
                deviceDensity = 3.0 /*+ " xxhdpi"*/;
                break;
            case DisplayMetrics.DENSITY_XXXHIGH:
                deviceDensity = 4.0 /*+ " xxxhdpi"*/;
                break;
            default:
                deviceDensity = 0;
        }
        return deviceDensity;
    }

    /*this method disable shifting Animation of bottom navigation bar*/
    public static void removeShiftMode(BottomNavigationView view) {

        /*get first bottom navigation menu view from bottom navigation  */
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            /*get field of bottom view from menu view */
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            /*set accessible true to Field*/
            shiftingMode.setAccessible(true);
            /*set boolean to field with menu b*/
            shiftingMode.setBoolean(menuView, false);
            /*then set accessible false to field */
            shiftingMode.setAccessible(false);
            /*for every menu view in the bottom navigation set shifting mode false and set checked the item data is checked*/
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                if (i == 2) {
                    item.setVisibility(View.INVISIBLE);
                }
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());

                /*center the menu items*/
                TextView smallText = (TextView) item.findViewById(R.id.smallLabel);
                smallText.setVisibility(View.INVISIBLE);
                //TextView largeText = (TextView) menuItemView.findViewById(R.id.largeLabel);
                ImageView icon = (ImageView) item.findViewById(R.id.icon);
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) icon.getLayoutParams();
                params.gravity = Gravity.CENTER;
                item.setShiftingMode(true);
            }
        } catch (NoSuchFieldException e) {
            Log.e("ERROR NO SUCH FIELD", "Unable to get shift mode field");
        } catch (IllegalAccessException e) {
            Log.e("ERROR ILLEGAL ALG", "Unable to change value of shift mode");
        }
    }


}
