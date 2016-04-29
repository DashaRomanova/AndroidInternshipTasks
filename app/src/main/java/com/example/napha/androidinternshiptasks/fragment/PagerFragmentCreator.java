package com.example.napha.androidinternshiptasks.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.napha.androidinternshiptasks.model.UserRequest;

import java.util.List;

/**
 * Created by Napha on 29.04.2016.
 */
public class PagerFragmentCreator {
    public static <T extends Fragment> T initInstance(List<UserRequest> userRequests, T fragment) {
        if(userRequests == null) throw new NullPointerException("List of claims is null");
        Bundle args = new Bundle();
        for (int i = 0; i < userRequests.size(); i++) {
            args.putSerializable("application" + i, userRequests.get(i));
        }

        fragment.setArguments(args);
        return fragment;
    }
}
