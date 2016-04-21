package com.example.napha.androidinternshiptasks.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.napha.androidinternshiptasks.model.Application;
import com.example.napha.androidinternshiptasks.R;
import com.example.napha.androidinternshiptasks.activity.AppealActivity;
import com.example.napha.androidinternshiptasks.model.SingleCardItem;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Napha on 15.04.2016.
 */
public class CardRecyclerViewDataAdapter extends RecyclerView.Adapter<CardRecyclerViewDataAdapter.ItemHolder>{

    private List<Application> mItemsList;
    private Context mContext;

    public CardRecyclerViewDataAdapter(List<Application> mItemsList, Context mContext) {
        this.mItemsList = mItemsList;
        this.mContext = mContext;
    }

    private SingleCardItem createCardItem(Application application){
        return new SingleCardItem(
                application.getTitleImage(),
                application.getLikesCount(),
                application.getTitle(),
                application.getStreet(),
                application.getDateOfRegistration(),
                application.getDateOfResolution());
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.mPositionInList = position;
        final SingleCardItem singleCardItem = createCardItem(mItemsList.get(position));
        Picasso.with(mContext)
                .load("file:///android_asset/hand.png")
                .into(holder.mItemLikeImage);
        Picasso.with(mContext)
                .load("file:///android_asset/"+singleCardItem.getImage())
                .into(holder.mItemImage);
        holder.mItemLikeCount.setText(singleCardItem.getLikesCount().toString());
        holder.mItemTitle.setText(singleCardItem.getTitleText());
        holder.mItemStreet.setText(singleCardItem.getStreet());
        holder.mItemDateBeginning.setText(new SimpleDateFormat("MMM dd, yyyy", new Locale("uk","UA")).format(singleCardItem.getBeginningDate()));
        holder.mItemDate.setText(getDifferenceBetweenTwoDates(
                singleCardItem.getBeginningDate(),
                singleCardItem.getEndDate())
                + " "
                + mContext.getResources().getString(R.string.days));
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

    @Override
    public int getItemCount() {
        return (null != mItemsList ? mItemsList.size() : 0);
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        protected int mPositionInList;
        protected TextView mItemTitle;
        protected TextView mItemStreet;
        protected TextView mItemDateBeginning;
        protected TextView mItemDate;
        protected ImageView mItemImage;
        protected ImageView mItemLikeImage;
        protected TextView mItemLikeCount;

        public ItemHolder(View view) {
            super(view);

            this.mItemImage = (ImageView) view.findViewById(R.id.itemImage);
            this.mItemLikeImage = (ImageView) view.findViewById(R.id.imageViewLike);
            this.mItemLikeCount = (TextView) view.findViewById(R.id.textViewCount);
            this.mItemTitle = (TextView) view.findViewById(R.id.itemTitle);
            this.mItemStreet = (TextView) view.findViewById(R.id.itemStreet);
            this.mItemDateBeginning = (TextView) view.findViewById(R.id.itemDateBeginning);
            this.mItemDate = (TextView) view.findViewById(R.id.itemDate);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, AppealActivity.class);
                    intent.putExtra("application", mItemsList.get(mPositionInList));
                    context.startActivity(intent);
                }
            });
        }
    }
}
