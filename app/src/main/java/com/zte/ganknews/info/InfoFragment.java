package com.zte.ganknews.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zte.ganknews.R;

/**
 * Created by Stephen on 2018/3/1.
 */

public class InfoFragment extends Fragment {

    public InfoFragment() {

    }

    public static InfoFragment newInstance() {
        return new InfoFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info,container,false);

        return view;
    }
}
