package com.app.science.golftracker;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by phifilli on 1/31/2018.
 */

public class FabAdapter extends RecyclerView.Adapter<FabAdapter.MyViewHolder> {

    private Context context;
    private List<Hole> holes;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        FloatingActionButton fab;
        TextView textView;
        public MyViewHolder(View view){
            super(view);
            view.setOnClickListener(this);

        }
        @Override
        public void onClick(View view) {

        }
    }

    @Override
    public FabAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_hole, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FabAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return holes.size();
    }


    public FabAdapter(Context context, List<Hole> holes){
        this.context = context;
        this.holes = holes;
    }
}
