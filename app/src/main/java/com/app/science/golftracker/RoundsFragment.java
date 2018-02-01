package com.app.science.golftracker;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phifilli on 1/26/2018.
 */

public class RoundsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RoundCardAdapter roundCardAdapter;
    private List<Round> roundList;
    private ViewGroup mView;
    private Scene mScene;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_rounds, container, false);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.floatingbutton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RoundActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_rounds);

        roundList = new ArrayList<>();

        roundCardAdapter = new RoundCardAdapter(this, view.getContext(), roundList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

            }
        });

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(view.getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(roundCardAdapter);

        makeTestRounds();

        this.setEnterTransition(new Fade());



        return view;
    }


    public void makeTestRounds(){

        for(int i = 0; i < 10; i++){
            Round round = new Round("TestCourse", "Sep 16 2017", 18);
            for(int j = 0; j < 18; j++){
                round.update(j+1, 4, true, true);
            }
            roundList.add(round);
        }
    }
}
