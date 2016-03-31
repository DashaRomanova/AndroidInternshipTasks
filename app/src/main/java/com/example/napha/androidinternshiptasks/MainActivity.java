package com.example.napha.androidinternshiptasks;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> pictures = new ArrayList<>(Arrays.asList("pic2.jpg", "pic3.jpg"));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, pictures);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClick(View v){
        switch (v.getClass().getSimpleName()) {
            case  "AppCompatTextView": showToast("TextView"); break;
            case  "AppCompatImageView": showToast("ImageView"); break;
        }
    }

    private void showToast(String txt){
        Toast.makeText(this,txt, Toast.LENGTH_LONG).show();
    }

}
