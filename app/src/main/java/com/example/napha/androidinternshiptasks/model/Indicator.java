package com.example.napha.androidinternshiptasks.model;

import com.example.napha.androidinternshiptasks.R;

import xdroid.enumformat.EnumString;

/**
 * Created by Napha on 17.04.2016.
 */
public enum Indicator {
    @EnumString(R.string.tab_item_progress)
    InProgress,

    @EnumString(R.string.tab_item_done)
    Done,

    @EnumString(R.string.tab_item_notDone)
    NotDone
}
