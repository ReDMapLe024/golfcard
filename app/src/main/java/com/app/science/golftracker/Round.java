package com.app.science.golftracker;

/**
 * Created by phifilli on 1/26/2018.
 */

public class Round {

    private String course, date;
    private int numHoles;
    private int[] score;
    private boolean[] fairwaysHit, greensHit;

    public Round(String course, String date, int numHoles){
        this.course = course;
        this.date = date;
        this.numHoles = numHoles;
        score = new int[numHoles];
        fairwaysHit = new boolean[numHoles];
        greensHit = new boolean[numHoles];
    }

    public void update(int currentHole, int score, boolean fairwayHit, boolean greenHit){
       this.score[currentHole] = score;
       fairwaysHit[currentHole] = fairwayHit;
       greensHit[currentHole] = greenHit;
    }

    public String getCourse(){ return course; }

    public String getDate(){ return date; }

    public int getScore(){
        int totalScore = 0;
        for(int i = 0; i < numHoles; i++){
            totalScore++;
        }
        return totalScore;
    }

    public double getFairwaysHitRate(){
        int hit = 0;
        for(int i = 0; i < numHoles; i++){
            if(fairwaysHit[i])
                hit++;
        }
        return hit/numHoles;
    }

    public double getGreensHitRate(){
        int hit = 0;
        for(int i = 0; i < numHoles; i++){
            if(greensHit[i])
                hit++;
        }
        return hit/numHoles;
    }
}
