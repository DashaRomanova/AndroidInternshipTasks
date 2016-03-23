package com.example.napha.androidinternshiptasks;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Napha on 22.03.2016.
 */
public class RecyclerViewDataAdapter extends RecyclerView.Adapter<RecyclerViewDataAdapter.RecyclerViewHolder> {

    private ArrayList<SingleItemModel> mItemsList;
    private Context mContext;

    public RecyclerViewDataAdapter(Context context, ArrayList<SingleItemModel> itemsList) {
        this.mItemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sigle_image, null);
        RecyclerViewHolder irh = new RecyclerViewHolder(v);
        return irh;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final SingleItemModel item = mItemsList.get(position);
        Bitmap image = getImageFromAssets(item.getName());
        holder.mItemImage.setImageBitmap(image);
    }

    protected Bitmap getImageFromAssets(String imageName){
        AssetManager assetManager = mContext.getAssets();
        InputStream fileStream = null;
        Bitmap bitmap = null;
        try {
            fileStream = assetManager.open(imageName);
            if(fileStream != null){
                bitmap = BitmapFactory.decodeStream(fileStream);
                fileStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
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

//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(v.getContext(), "ImageView", Toast.LENGTH_SHORT).show();
//                }
//            });
        }
    }

}
