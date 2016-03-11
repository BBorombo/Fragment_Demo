package com.borombo.demo.fragment_demo.Dynamic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.borombo.demo.fragment_demo.R;

/**
 * Created by phantom on 11/03/16.
 */
public class DynamicActivity extends FragmentActivity{

    private static final String KEY_FRAGMENT = "fragment_save";
    private String currentFragment;

    private final DynamicFragment1 dynamicFragment1 = new DynamicFragment1();
    private final DynamicFragment2 dynamicFragment2 = new DynamicFragment2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        if (savedInstanceState != null)
            currentFragment = savedInstanceState.getString(KEY_FRAGMENT);
        else
            currentFragment = getIntent().getStringExtra(KEY_FRAGMENT);

        if (currentFragment != null){
            if (dynamicFragment1.TAG.equals(currentFragment))
                showFragment(this.dynamicFragment1);
            else if (dynamicFragment2.TAG.equals(currentFragment))
                showFragment(this.dynamicFragment2);
        }else{
            showFragment(this.dynamicFragment1);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void showFragment(final Fragment fragment){
        if (fragment == null){
            return ;
        }
        final FragmentManager fm = getSupportFragmentManager();
        final FragmentTransaction ft = fm.beginTransaction();

        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        ft.replace(R.id.frameLayoutDynamic, fragment);

        ft.addToBackStack(null);

        ft.commit();
    }

    public void goToFragment1(View v){
        showFragment(this.dynamicFragment1);
    }

    public void goToFragment2(View v){
        showFragment(this.dynamicFragment2);
    }
}
