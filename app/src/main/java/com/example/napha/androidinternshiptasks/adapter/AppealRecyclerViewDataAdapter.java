package com.example.napha.androidinternshiptasks.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.napha.androidinternshiptasks.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Napha on 20.04.2016.
 */
public class AppealRecyclerViewDataAdapter extends RecyclerView.Adapter<AppealRecyclerViewDataAdapter.RecyclerViewHolder> {
    private List<String> mItemsList;
    private Context mContext;

    public AppealRecyclerViewDataAdapter(Context context, List<String> itemsList) {
        this.mItemsList = itemsList;
        this.mContext = context; //[Comment] Unnecessary "this"
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_image, viewGroup, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final String src = mItemsList.get(position); //[Comment] Why final?
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
            this.mItemImage = (ImageView) view.findViewById(R.id.itemImage); //[Comment] Unnecessary "this"
        }
    }
}
