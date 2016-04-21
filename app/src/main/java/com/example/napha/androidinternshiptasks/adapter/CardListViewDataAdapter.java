package com.example.napha.androidinternshiptasks.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.napha.androidinternshiptasks.R;
import com.example.napha.androidinternshiptasks.model.SingleCardItem;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Napha on 20.04.2016.
 */
public class CardListViewDataAdapter extends BaseAdapter {
    private List<SingleCardItem> mItemsList;
    private Context mContext;

    public CardListViewDataAdapter(List<SingleCardItem> mItemsList, Context mContext) {
        this.mItemsList = mItemsList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mItemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card, parent, false);
        }

        final SingleCardItem singleCardItem = mItemsList.get(position);
        Picasso.with(mContext)
                .load("file:///android_asset/hand.png")
                .into((ImageView) view.findViewById(R.id.imageViewLike));
        Picasso.with(mContext)
                .load("file:///android_asset/"+singleCardItem.getImage())
                .into((ImageView) view.findViewById(R.id.itemImage));
        ((TextView) view.findViewById(R.id.textViewCount)).setText(singleCardItem.getLikesCount().toString());
        ((TextView) view.findViewById(R.id.itemTitle)).setText(singleCardItem.getTitleText());
        ((TextView) view.findViewById(R.id.itemStreet)).setText(singleCardItem.getStreet());
        ((TextView) view.findViewById(R.id.itemDateBeginning)).setText(new SimpleDateFormat(
                "MMM dd, yyyy",
                new Locale("uk","UA")).format(singleCardItem.getBeginningDate()));
        ((TextView) view.findViewById(R.id.itemDate)).setText(getDifferenceBetweenTwoDates(
                singleCardItem.getBeginningDate(),
                singleCardItem.getEndDate())
                + " "
                + mContext.getResources().getString(R.string.days));
        return view;
    }

    private long getDifferenceBetweenTwoDates(Date begin, Date end){
        long difference = begin.getTime() - end.getTime();
        // seconds
        long seconds = difference / 1000;
        // minutes
        long minutes = seconds / 60;
        // hours
        long hours = minutes / 60;
        // days
        long days = hours / 24;
        return days;
    }
}
