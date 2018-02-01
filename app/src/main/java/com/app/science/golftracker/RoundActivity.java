package com.app.science.golftracker;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.SharedElementCallback;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class RoundActivity extends AppCompatActivity {

    private Round round;
    private GridView gridView;
    private RecyclerView recView;
    private List<Hole> holes;
    private boolean visible, par3Selected, par4Selected, par5Selected;
    private CarouselPicker carouselPicker;
    private LinearLayout layout;
    private TextView tv_par3, tv_par4, tv_par5;
    ViewGroup rootGroup;
    CarouselPicker.CarouselViewAdapter adapter;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        Bundle data = getIntent().getExtras();

        //Retrieve round from bundle
        round = (Round) data.getParcelable("round");

        //Retrieve list of holes from rounds.
        holes = round.getHoles();
        layout = (LinearLayout) findViewById(R.id.hole_layout);
        TextView tv_courseName = (TextView) this.findViewById(R.id.tv_course);
        tv_courseName.setText(round.getCourse());
        par3Selected = false;
        par4Selected = true;
        par5Selected = false;
        tv_par3 = (TextView) findViewById(R.id.tv_par3);
        tv_par4 = (TextView) findViewById(R.id.tv_par4);
        tv_par5 = (TextView) findViewById(R.id.tv_par5);
        tv_par3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tv_par3.setBackground(getResources().getDrawable(R.drawable.round_card_score_background));
                    tv_par3.setTextColor(Color.WHITE);
                    par3Selected = true;

                    tv_par4.setBackground(getResources().getDrawable(R.drawable.par_background_unselected));
                    tv_par4.setTextColor(Color.BLACK);
                    par4Selected = false;

                    tv_par5.setBackground(getResources().getDrawable(R.drawable.par_background_unselected));
                    tv_par5.setTextColor(Color.BLACK);
                    par5Selected = false;
            }
        });

        tv_par4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_par4.setBackground(getResources().getDrawable(R.drawable.round_card_score_background));
                tv_par4.setTextColor(Color.WHITE);
                par3Selected = true;

                tv_par3.setBackground(getResources().getDrawable(R.drawable.par_background_unselected));
                tv_par3.setTextColor(Color.BLACK);
                par4Selected = false;

                tv_par5.setBackground(getResources().getDrawable(R.drawable.par_background_unselected));
                tv_par5.setTextColor(Color.BLACK);
                par5Selected = false;
            }
        });

        tv_par5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_par5.setBackground(getResources().getDrawable(R.drawable.round_card_score_background));
                tv_par5.setTextColor(Color.WHITE);
                par3Selected = true;

                tv_par3.setBackground(getResources().getDrawable(R.drawable.par_background_unselected));
                tv_par3.setTextColor(Color.BLACK);
                par4Selected = false;

                tv_par4.setBackground(getResources().getDrawable(R.drawable.par_background_unselected));
                tv_par4.setTextColor(Color.BLACK);
                par5Selected = false;
            }
        });

        carouselPicker = (CarouselPicker) findViewById(R.id.carouselPicker);
        List<CarouselPicker.PickerItem> items = new ArrayList<>();
        items.add(new CarouselPicker.TextItem("1", 12));
        items.add(new CarouselPicker.TextItem("2", 12));
        items.add(new CarouselPicker.TextItem("3", 12));
        items.add(new CarouselPicker.TextItem("4", 12));
        items.add(new CarouselPicker.TextItem("5", 12));
        items.add(new CarouselPicker.TextItem("6", 12));
        items.add(new CarouselPicker.TextItem("7", 12));
        items.add(new CarouselPicker.TextItem("8", 12));
        items.add(new CarouselPicker.TextItem("9", 12));
        items.add(new CarouselPicker.TextItem("10", 12));
        items.add(new CarouselPicker.TextItem("11", 12));
        items.add(new CarouselPicker.TextItem("12", 12));
        items.add(new CarouselPicker.TextItem("13", 12));
        items.add(new CarouselPicker.TextItem("14", 12));
        items.add(new CarouselPicker.TextItem("15", 12));
        items.add(new CarouselPicker.TextItem("16", 12));
        items.add(new CarouselPicker.TextItem("17", 12));
        items.add(new CarouselPicker.TextItem("18", 12));

        adapter = new CarouselPicker.CarouselViewAdapter(this, items,0);

        visible = false;

        carouselPicker.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                final int i;
                i = position;
                rootGroup.animate().alpha(0f).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        rootGroup.animate().alpha(1f);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        getWindow().setAllowEnterTransitionOverlap(true);
        getWindow().setAllowReturnTransitionOverlap(false);

        rootGroup = (ViewGroup) findViewById(R.id.hole_layout);
        rootGroup.post(new Runnable() {
            @Override
            public void run() {
                rootGroup.setAlpha(0f);
            }
        });

        Slide slide = new Slide(Gravity.TOP);
        slide.excludeTarget(android.R.id.statusBarBackground, true);
        slide.excludeTarget(android.R.id.navigationBarBackground, true);
        slide.setDuration(300);
        getWindow().setEnterTransition(slide);
        getWindow().setReturnTransition(slide);

        getWindow().setSharedElementEnterTransition(new ChangeBounds().setDuration(300));
        getWindow().setSharedElementExitTransition(new ChangeBounds().setDuration(300));
        getWindow().getSharedElementEnterTransition().addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
                removeAdapter();
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                setAdapter();
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });

    }


    public void setAdapter(){
        if(!visible){
            carouselPicker.setAdapter(adapter);
            carouselPicker.animate().alpha(1f);
            rootGroup.animate().alpha(1f);
            carouselPicker.setVisibility(View.VISIBLE);
            rootGroup.setVisibility(View.VISIBLE);
            visible = true;
        }else{
            layout.setVisibility(View.GONE);
            rootGroup.setVisibility(View.GONE);
        }

    }
    public void removeAdapter(){
            System.out.println("Transition Started!");
            carouselPicker.animate().alpha(0f).setDuration(100);
            rootGroup.animate().alpha(0f).setDuration(100);
            //carouselPicker.setVisibility(View.GONE);
            System.out.println(String.valueOf(View.GONE));

    }
}
