package com.example.napha.androidinternshiptasks.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.napha.androidinternshiptasks.model.Application;
import com.example.napha.androidinternshiptasks.fragment.ListViewPageFragment;
import com.example.napha.androidinternshiptasks.fragment.RecyclerViewPageFragment;
import com.example.napha.androidinternshiptasks.model.Indicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Napha on 17.04.2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private List<Application> mApplications;

    public ViewPagerAdapter(FragmentManager fragmentManager, List<Application> applications) {
        super(fragmentManager);
        this.mApplications = applications;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        List<Application> applications = new ArrayList<>();
        switch (position){
            case 0:
                for (int i = 0; i < mApplications.size(); i++) {
                    Application application = mApplications.get(i);
                    if(application.getIndicator().equals(Indicator.InProgress)){
                        applications.add(application);
                    }
                }
                fragment = RecyclerViewPageFragment.newInstance(applications);
                break;
            case 1:
                for (int i = 0; i < mApplications.size(); i++) {
                    Application application = mApplications.get(i);
                    if(application.getIndicator().equals(Indicator.Done)){
                        applications.add(application);
                    }
                }
                fragment = RecyclerViewPageFragment.newInstance(applications);
                break;
            case 2:
                for (int i = 0; i < mApplications.size(); i++) {
                    Application application = mApplications.get(i);
                    if(application.getIndicator().equals(Indicator.NotDone)){
                        applications.add(application);
                    }
                }
                fragment = ListViewPageFragment.newInstance(applications);
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}



