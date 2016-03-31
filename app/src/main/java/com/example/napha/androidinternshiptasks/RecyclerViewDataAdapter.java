package com.example.napha.androidinternshiptasks;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Napha on 22.03.2016.
 */
public class RecyclerViewDataAdapter extends RecyclerView.Adapter<RecyclerViewDataAdapter.RecyclerViewHolder> {

    private List<String> mItemsList;
    private Context mContext;

    public RecyclerViewDataAdapter(Context context, List<String> itemsList) {
        this.mItemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sigle_image, viewGroup, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final String src = mItemsList.get(position);
        Picasso.with(mContext)
                .load("file:///android_asset/"+src)
                .into(holder.mItemImage);
    }

    @Override
    public int getItemCount() {
        return (null != mItemsList ? mItemsList.size() : 0);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        protected ImageView mItemImage;

        public RecyclerViewHolder(View view) {
            super(view);
            this.mItemImage = (ImageView) view.findViewById(R.id.itemImage);
        }
    }

}
