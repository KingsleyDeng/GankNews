package com.zte.ganknews.ui;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zte.ganknews.R;
import com.zte.ganknews.farvorite.FarvoriteFragment;
import com.zte.ganknews.info.InfoFragment;
import com.zte.ganknews.timeline.TimelineFragment;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_BOTTOM_NAVIGATION_VIEW_SELECTED_ID = "KEY_BOTTOM_NAVIGATION_VIEW_SELECTED_ID";
    public static final String ACTION_FAVORITES = "com.zte.ganknews.favorites";

    private BottomNavigationView mBottonNavigationView;

    private TimelineFragment mTimelineFragment;
    private FarvoriteFragment mFarvoriteFragment;
    private InfoFragment mInfoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initFragments(savedInstanceState);


        if (savedInstanceState != null) {
            int id = savedInstanceState.getInt(KEY_BOTTOM_NAVIGATION_VIEW_SELECTED_ID, R.id.nav_timeline);
            switch (id) {
                case R.id.nav_timeline:
                    showFragment(mTimelineFragment);
                    break;
                case R.id.nav_favorites:
                    showFragment(mFarvoriteFragment);
                    break;
                case R.id.nav_info:
                    showFragment(mInfoFragment);
                    break;
            }
        } else {
            if (getIntent().getAction().equals(ACTION_FAVORITES)) {
                showFragment(mFarvoriteFragment);
                mBottonNavigationView.setSelectedItemId(R.id.nav_favorites);
            } else {
                showFragment(mTimelineFragment);
            }
        }

        mBottonNavigationView.setOnNavigationItemSelectedListener((menuItem -> {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            switch (menuItem.getItemId()) {
                case R.id.nav_timeline:
                    showFragment(mTimelineFragment);
                    break;

                case R.id.nav_favorites:
                    showFragment(mFarvoriteFragment);
                    break;

                case R.id.nav_info:
                    showFragment(mInfoFragment);
                    break;

                default:
                    break;

            }
            ft.commit();
            return true;
        }));

    }

    private void initViews() {
        mBottonNavigationView = findViewById(R.id.bottom_nav);
    }

    private void initFragments(Bundle savedInstanceState) {

        FragmentManager fm = getSupportFragmentManager();

        if (savedInstanceState == null) {
            mTimelineFragment = TimelineFragment.newInstance();
            mInfoFragment = InfoFragment.newInstance();
            mFarvoriteFragment = FarvoriteFragment.newInstance();
        } else {
            mTimelineFragment = (TimelineFragment) fm.getFragment(savedInstanceState, TimelineFragment.class.getSimpleName());
            mFarvoriteFragment = (FarvoriteFragment) fm.getFragment(savedInstanceState, FarvoriteFragment.class.getSimpleName());
            mInfoFragment = (InfoFragment) fm.getFragment(savedInstanceState, InfoFragment.class.getSimpleName());
        }

        if (!mTimelineFragment.isAdded()) {
            fm.beginTransaction()
                    .add(R.id.container, mTimelineFragment, TimelineFragment.class.getSimpleName())
                    .commit();
        }

        if (!mFarvoriteFragment.isAdded()) {
            fm.beginTransaction()
                    .add(R.id.container, mFarvoriteFragment, FarvoriteFragment.class.getSimpleName())
                    .commit();

        }

        if (!mInfoFragment.isAdded()) {
            fm.beginTransaction()
                    .add(R.id.container, mInfoFragment, InfoFragment.class.getSimpleName())
                    .commit();
        }
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        if (fragment instanceof TimelineFragment) {
            fm.beginTransaction()
                    .show(mTimelineFragment)
                    .hide(mInfoFragment)
                    .hide(mFarvoriteFragment)
                    .commit();

        } else if (fragment instanceof InfoFragment) {
            fm.beginTransaction()
                    .show(mInfoFragment)
                    .hide(mTimelineFragment)
                    .hide(mFarvoriteFragment)
                    .commit();
        } else if (fragment instanceof FarvoriteFragment) {
            fm.beginTransaction()
                    .show(mFarvoriteFragment)
                    .hide(mTimelineFragment)
                    .hide(mInfoFragment)
                    .commit();
        }
    }


}
