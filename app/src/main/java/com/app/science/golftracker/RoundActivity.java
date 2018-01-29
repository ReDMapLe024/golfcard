package com.app.science.golftracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RoundActivity extends AppCompatActivity {

    private Round round;
    private int currentScore;
    private int[] scores;
    private boolean[] fairwaysHit;
    private boolean[] greensHit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        Bundle data = getIntent().getExtras();
        Round round = (Round) data.getParcelable("round");
        TextView tv_courseName = (TextView) this.findViewById(R.id.tv_course);
        tv_courseName.setText(round.getCourse());
        System.out.println(round.getCourse());
    }

    public void populateHoles(){

    }
}
