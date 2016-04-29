package com.example.napha.androidinternshiptasks.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.napha.androidinternshiptasks.R;
import com.example.napha.androidinternshiptasks.adapter.ViewPagerAdapter;
import com.example.napha.androidinternshiptasks.model.UserRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Napha on 19.04.2016.
 */
public class AppealsPagerFragment extends Fragment {
    private List<UserRequest> mUserRequests;

    public static AppealsPagerFragment newInstance(List<UserRequest> userRequests) {
        return PagerFragmentCreator.initInstance(userRequests, new AppealsPagerFragment());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args!= null) {
            mUserRequests = new ArrayList<>();
            for (String key : args.keySet()) {
                mUserRequests.add((UserRequest) args.getSerializable(key));
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.appeals_activity, container, false);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_item_progress).toUpperCase()));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_item_done).toUpperCase()));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_item_notDone).toUpperCase()));

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), mUserRequests);

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
}
