package com.example.napha.androidinternshiptasks.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.napha.androidinternshiptasks.R;
import com.example.napha.androidinternshiptasks.adapter.CardRecyclerViewDataAdapter;
import com.example.napha.androidinternshiptasks.model.UserRequest;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Napha on 17.04.2016.
 */
public class RecyclerViewPageFragment extends Fragment {
    private List<UserRequest> mUserRequests;

    public static RecyclerViewPageFragment newInstance(List<UserRequest> userRequests) {
        return PagerFragmentCreator.initInstance(userRequests, new RecyclerViewPageFragment());
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
        View view = inflater.inflate(R.layout.recyclerview_tab, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        CardRecyclerViewDataAdapter adapter =
                new CardRecyclerViewDataAdapter(mUserRequests, container.getContext());
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.attachToRecyclerView(recyclerView);
        return view;
    }
}
