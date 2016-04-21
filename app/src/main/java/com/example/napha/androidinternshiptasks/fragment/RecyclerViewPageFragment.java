package com.example.napha.androidinternshiptasks.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.napha.androidinternshiptasks.model.Application;
import com.example.napha.androidinternshiptasks.R;
import com.example.napha.androidinternshiptasks.adapter.CardRecyclerViewDataAdapter;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Napha on 17.04.2016.
 */
public class RecyclerViewPageFragment extends Fragment {
    private List<Application> mApplications;

    public static RecyclerViewPageFragment newInstance(List<Application> applications) {
        if(applications == null) throw new NullPointerException("List of applications is null");
        Bundle args = new Bundle();
        for (int i = 0; i < applications.size(); i++) {
            args.putSerializable("application" + i, applications.get(i));
        }
        RecyclerViewPageFragment fragment = new RecyclerViewPageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args!= null) {
            mApplications = new ArrayList<>();
            for (String key : args.keySet()) {
                mApplications.add((Application) args.getSerializable(key));
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview_tab, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        CardRecyclerViewDataAdapter adapter =
                new CardRecyclerViewDataAdapter(mApplications, container.getContext());
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.attachToRecyclerView(recyclerView);
        return view;
    }
}
