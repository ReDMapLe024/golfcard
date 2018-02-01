package com.app.science.golftracker;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phifilli on 1/26/2018.
 */

public class Round implements Parcelable {

    private String course, date;
    private int numHoles;
    private List<Hole> holes;
    private int[] score;
    private boolean[] fairwaysHit, greensHit;

    public Round(Parcel in){
        List<Hole> temp =  new ArrayList<Hole>();
        in.readList(temp, Hole.class.getClassLoader());
        holes = temp;
        course = in.readString();
        date = in.readString();
        numHoles = in.readInt();

    }
    public Round(String course, String date, int numHoles){
        this.course = course;
        this.date = date;
        this.numHoles = numHoles;
        holes = new ArrayList<Hole>(numHoles);
    }

    public void update(int currentHole, int score, boolean fairwayHit, boolean greenHit){
        holes.add(new Hole(score, fairwayHit, greenHit));
    }

    public String getCourse(){ return course; }

    public String getDate(){ return date; }

    public int getScore(){
        int totalScore = 0;
        for(int i = 0; i < holes.size()-1; i++){
            totalScore+= holes.get(i).getScore();
        }
        return totalScore;
    }

    public double getFairwaysHitRate(){
        int hit = 0;
        for(int i = 0; i < holes.size(); i++){
            if(holes.get(i).isFairwayHit())
                hit++;
        }
        return hit/numHoles;
    }

    public double getGreensHitRate(){
        int hit = 0;
        for(int i = 0; i < holes.size(); i++){
            if(holes.get(i).isGreenHit())
                hit++;
        }
        return hit/numHoles;
    }

    public List<Hole> getHoles(){ return holes; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(holes);
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
