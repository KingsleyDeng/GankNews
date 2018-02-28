package com.zte.ganknews.ui;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zte.ganknews.R;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottonNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        mBottonNavigationView = findViewById(R.id.bottom_nav);
    }

}
