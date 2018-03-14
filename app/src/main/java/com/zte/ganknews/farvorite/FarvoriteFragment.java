package com.zte.ganknews.farvorite;

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

public class FarvoriteFragment extends Fragment{

    public FarvoriteFragment(){

    }

    public static FarvoriteFragment newInstance() {
        return new FarvoriteFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.framgent_favorites,container,false);

        return view;
    }
}
