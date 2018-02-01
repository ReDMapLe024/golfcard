package com.app.science.golftracker;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.transition.AutoTransition;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.Visibility;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private RoundsFragment roundsFragment;
    private StatsFragment statsFragment;
    private CoursesFragment coursesFragment;
    private PlayersFragment playersFragment;
    private View mView;
    private FragmentManager fm;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_rounds:
                    FragmentTransaction transactionRounds = fm.beginTransaction();
                    transactionRounds.replace(R.id.fragment_container, roundsFragment);
                    transactionRounds.commit();
                    return true;
                case R.id.navigation_stats:
                    FragmentTransaction transactionStats = fm.beginTransaction();
                    transactionStats.replace(R.id.fragment_container, statsFragment);
                    transactionStats.commit();
                    return true;
                case R.id.navigation_courses:
                    FragmentTransaction transactionCourses = fm.beginTransaction();
                    transactionCourses.replace(R.id.fragment_container, coursesFragment);
                    transactionCourses.commit();
                    return true;
                case R.id.navigation_players:
                    FragmentTransaction transactionPlayers = fm.beginTransaction();
                    transactionPlayers.replace(R.id.fragment_container, playersFragment);
                    transactionPlayers.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mView = findViewById(R.id.fragment_container);
        roundsFragment = new RoundsFragment();
        statsFragment = new StatsFragment();
        coursesFragment = new CoursesFragment();
        playersFragment = new PlayersFragment();

        fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_container, roundsFragment);
        transaction.commit();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getWindow().setAllowEnterTransitionOverlap(false);
        getWindow().setAllowReturnTransitionOverlap(false);

        Fade fade = new Fade();
        fade.setDuration(550);
        final Explode explode = new Explode();
        explode.setMode(Visibility.MODE_OUT);
        explode.setDuration(250);
        explode.excludeTarget(android.R.id.statusBarBackground, true);
        roundsFragment.setExitTransition(explode);
        Slide slide = new Slide(Gravity.BOTTOM);
        slide.setDuration(350);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);
        getWindow().setReenterTransition(fade);
        getWindow().setExitTransition(fade);
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}