package com.app.science.golftracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by phifilli on 1/26/2018.
 */

public class RoundCardAdapter extends RecyclerView.Adapter<RoundCardAdapter.MyViewHolder> {

    private Context context;
    private List<Round> roundList;
    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView course, date, score, fairways, greens;

        public MyViewHolder(View view){
            super(view);
            course = (TextView) view.findViewById(R.id.tv_course);
            date = (TextView) view.findViewById(R.id.tv_date);
            score = (TextView) view.findViewById(R.id.tv_score);
            fairways = (TextView) view.findViewById(R.id.tv_fairways);
            greens = (TextView) view.findViewById(R.id.tv_greens);
        }
    }

    public RoundCardAdapter(Context context, List<Round> roundList){
        this.context = context;
        this.roundList = roundList;
    }

    //Called when new card is created.
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_round, parent, false);
        return new MyViewHolder(itemView);
    }

    //Show data for current Card
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Round round = roundList.get(position);
        holder.course.setText(round.getCourse());
        holder.date.setText(round.getDate());
        holder.score.setText(Integer.toString(round.getScore()));
        holder.fairways.setText(Double.toString(round.getFairwaysHitRate()));
        holder.greens.setText(Double.toString(round.getGreensHitRate()));
    }

    @Override
    public int getItemCount() {
        return roundList.size();
    }


}
