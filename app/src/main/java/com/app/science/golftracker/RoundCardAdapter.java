package com.app.science.golftracker;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
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
    CustomItemClickListener listener;
    private RoundsFragment fragment;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView course, date, score, fairways, greens;

        public MyViewHolder(View view){
            super(view);
            view.setOnClickListener(this);
            course = (TextView) view.findViewById(R.id.tv_course);
            date = (TextView) view.findViewById(R.id.tv_date);
            score = (TextView) view.findViewById(R.id.tv_score);
            fairways = (TextView) view.findViewById(R.id.tv_fairways);
            greens = (TextView) view.findViewById(R.id.tv_greens);
        }

        public int getItemPosition(){
            return getAdapterPosition();
        }
        @Override
        public void onClick(View view) {
            System.out.println(this.getAdapterPosition());
            Intent intent = new Intent(context.getApplicationContext(), RoundActivity.class);
            intent.putExtra("round", roundList.get(getAdapterPosition()));
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, view.findViewById(R.id.tv_course), "coursename");
            ((Activity) context).startActivity(intent, options.toBundle());
        }
    }

    public RoundCardAdapter(RoundsFragment parentFragment, Context context, List<Round> roundList, CustomItemClickListener listener){
        this.context = context;
        this.roundList = roundList;
        this.listener = listener;
        this.fragment = parentFragment;
    }

    //Called when new card is created.
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_round, parent, false);
        final MyViewHolder mholder = new MyViewHolder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view, mholder.getLayoutPosition());
            }
        });
        return new MyViewHolder(itemView);
    }

    //Show data for current Card
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Round round = roundList.get(position);
        holder.course.setText(round.getCourse());
        holder.date.setText(round.getDate());
        holder.score.setText("Score: " + Integer.toString(round.getScore()));
        holder.fairways.setText("FWY: " + Double.toString(round.getFairwaysHitRate()));
        holder.greens.setText("GIR: " + Double.toString(round.getGreensHitRate()));
    }

    @Override
    public int getItemCount() {
        return roundList.size();
    }


}
