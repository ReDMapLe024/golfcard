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
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private RoundsFragment roundsFragment;
    private StatsFragment statsFragment;
    private CoursesFragment coursesFragment;
    private PlayersFragment playersFragment;
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
    }

}