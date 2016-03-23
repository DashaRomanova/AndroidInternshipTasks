package com.example.napha.androidinternshiptasks;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<SingleItemModel> mPictures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPictures = new ArrayList<>();
        mPictures.add(new SingleItemModel("pic2.jpg"));
        mPictures.add(new SingleItemModel("pic3.jpg"));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, mPictures);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void onClick(View v){
        //showToast(v.getClass().getSimpleName());
        switch (v.getClass().getSimpleName()) {
            case  "AppCompatTextView": showToast("TextView"); break;
            case  "AppCompatImageView": showToast("ImageView"); break;
        }
    }

    private void showToast(String txt){
        Toast.makeText(this,txt, Toast.LENGTH_LONG).show();
    }

}
