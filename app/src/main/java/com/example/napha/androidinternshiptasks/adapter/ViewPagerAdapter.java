package com.example.napha.androidinternshiptasks.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.napha.androidinternshiptasks.fragment.ListViewPageFragment;
import com.example.napha.androidinternshiptasks.fragment.RecyclerViewPageFragment;
import com.example.napha.androidinternshiptasks.model.Indicator;
import com.example.napha.androidinternshiptasks.model.UserRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Napha on 17.04.2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private List<UserRequest> mUserRequests;

    public ViewPagerAdapter(FragmentManager fragmentManager, List<UserRequest> userRequests) {
        super(fragmentManager);
        this.mUserRequests = userRequests;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        List<UserRequest> userRequests = new ArrayList<>();
        switch (position){
            case 0:
                for (int i = 0; i < mUserRequests.size(); i++) {
                    UserRequest userRequest = mUserRequests.get(i);
                    if(userRequest.getIndicator().equals(Indicator.InProgress)){
                        userRequests.add(userRequest);
                    }
                }
                fragment = RecyclerViewPageFragment.newInstance(userRequests);
                break;
            case 1:
                for (int i = 0; i < mUserRequests.size(); i++) {
                    UserRequest userRequest = mUserRequests.get(i);
                    if(userRequest.getIndicator().equals(Indicator.Done)){
                        userRequests.add(userRequest);
                    }
                }
                fragment = RecyclerViewPageFragment.newInstance(userRequests);
                break;
            case 2:
                for (int i = 0; i < mUserRequests.size(); i++) {
                    UserRequest userRequest = mUserRequests.get(i);
                    if(userRequest.getIndicator().equals(Indicator.NotDone)){
                        userRequests.add(userRequest);
                    }
                }
                fragment = ListViewPageFragment.newInstance(userRequests);
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}



