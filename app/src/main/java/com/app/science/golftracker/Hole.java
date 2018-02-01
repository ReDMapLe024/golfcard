package com.app.science.golftracker;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by phifilli on 1/31/2018.
 */

public class Hole implements Parcelable {

    private int score;
    private boolean fairwayHit;
    private boolean greenHit;

    public Hole (Parcel in){
        score = in.readInt();
        int temp = in.readInt();
        if(temp == 1){
            fairwayHit = true;
        }else{
            fairwayHit = false;
        }
        temp = in.readInt();
        if(temp == 1){
            greenHit = true;
        }else{
            greenHit = false;
        }
    }
    public Hole(int score, boolean fairwayHit, boolean greenHit){
        this.score = score;
        this.fairwayHit = fairwayHit;
        this.greenHit = greenHit;
    }

    public void setScore(int score){ this.score = score; }
    public void setFairwayHit(boolean fairwayHit) { this.fairwayHit = fairwayHit; }
    public void setGreenHit(boolean greenHit) { this.greenHit = greenHit; }

    public int getScore(){ return score; }
    public boolean isFairwayHit() { return fairwayHit; }
    public boolean isGreenHit() { return  greenHit; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(score);
        parcel.writeInt(fairwayHit ? 1 : 0);
        parcel.writeInt(greenHit ? 1 : 0);
    }

    public static final Parcelable.Creator<Hole> CREATOR = new Parcelable.Creator<Hole>() {
        public Hole createFromParcel(Parcel in) {
            return new Hole(in);
        }

        public Hole[] newArray(int size) {
            return new Hole[size];
        }
    };
}
