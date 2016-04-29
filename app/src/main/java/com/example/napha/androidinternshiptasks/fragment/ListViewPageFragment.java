package com.example.napha.androidinternshiptasks.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.napha.androidinternshiptasks.activity.AppealActivity;
import com.example.napha.androidinternshiptasks.adapter.CardItemHelper;
import com.example.napha.androidinternshiptasks.model.UserRequest;
import com.melnykov.fab.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.napha.androidinternshiptasks.R;
import com.example.napha.androidinternshiptasks.adapter.CardListViewDataAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Napha on 19.04.2016.
 */
public class ListViewPageFragment extends Fragment {
    private List<UserRequest> mUserRequests;

    public static ListViewPageFragment newInstance(List<UserRequest> userRequests) {
        return PagerFragmentCreator.initInstance(userRequests, new ListViewPageFragment());
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
        View view = inflater.inflate(R.layout.listview_tab, container, false);
        ListView listView = (ListView) view.findViewById(R.id.card_list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = view.getContext();
                Intent intent = new Intent(context, AppealActivity.class);
                intent.putExtra("application", mUserRequests.get(position));
                context.startActivity(intent);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.attachToListView(listView);
        CardListViewDataAdapter adapter =
                new CardListViewDataAdapter(CardItemHelper.createCardItems(mUserRequests), container.getContext());
        listView.setAdapter(adapter);
        return view;
    }
}
