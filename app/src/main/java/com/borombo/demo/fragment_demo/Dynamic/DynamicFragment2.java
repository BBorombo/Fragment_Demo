package com.borombo.demo.fragment_demo.Dynamic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.borombo.demo.fragment_demo.R;

/**
 * Created by phantom on 11/03/16.
 */
public class DynamicFragment2 extends Fragment{

    public static final String TAG = "DynamicFragment2";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dynamic_2, container, false);
    }

}
