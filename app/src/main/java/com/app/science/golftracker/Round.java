package com.app.science.golftracker;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by phifilli on 1/26/2018.
 */

public class Round implements Parcelable {

    private String course, date;
    private int numHoles;
    private int[] score;
    private boolean[] fairwaysHit, greensHit;

    public Round(Parcel in){

        score = in.createIntArray();
        fairwaysHit = in.createBooleanArray();
        greensHit = in.createBooleanArray();
        course = in.readString();
        date = in.readString();
        numHoles = in.readInt();

    }
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
            totalScore+= score[i];
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(score);
        parcel.writeBooleanArray(fairwaysHit);
        parcel.writeBooleanArray(greensHit);
        parcel.writeString(course);
        parcel.writeString(date);
        parcel.writeInt(numHoles);
    }

    public static final Parcelable.Creator<Round> CREATOR = new Parcelable.Creator<Round>() {
        public Round createFromParcel(Parcel in) {
            return new Round(in);
        }

        public Round[] newArray(int size) {
            return new Round[size];
        }
    };
}
