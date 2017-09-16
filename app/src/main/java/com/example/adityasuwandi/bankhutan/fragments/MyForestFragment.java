package com.example.adityasuwandi.bankhutan.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adityasuwandi.bankhutan.R;
import com.example.adityasuwandi.bankhutan.adapters.MainFragmentAdapter;
import com.example.adityasuwandi.bankhutan.adapters.MyForestFragmentAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyForestFragment extends Fragment {

    private TabLayout tabs;
    private MyForestFragmentAdapter adapter;
    protected ViewPager viewPager;
    private boolean first_time = true;
    private AppCompatActivity appCompatActivity;

    public MyForestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_forest, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);


        tabs = getView().findViewById(R.id.tabs_new);
        viewPager = getView().findViewById(R.id.pager_new);
        appCompatActivity = (AppCompatActivity) getView().getContext();


        adapter = new MyForestFragmentAdapter(getResources(),getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);


        if(first_time == true){
            appCompatActivity.getSupportActionBar().setTitle("New Tree");
            first_time = false;
        }

        tabs.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        int tabnumberselected = tab.getPosition();
                        switch (tabnumberselected) {
                            case 0: {
                                appCompatActivity.getSupportActionBar().setTitle("New Tree");
                                break;
                            }
                            case 1: {
                                appCompatActivity.getSupportActionBar().setTitle("In Progress");
                                break;
                            }
                            case 2: {
                                appCompatActivity.getSupportActionBar().setTitle("Harvest");
                                break;
                            }
                        }
                    }

                    //Something has changed dude!!


                });

}
}
