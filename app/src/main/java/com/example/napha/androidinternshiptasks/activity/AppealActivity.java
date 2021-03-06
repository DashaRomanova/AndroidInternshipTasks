package com.example.napha.androidinternshiptasks.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.napha.androidinternshiptasks.R;
import com.example.napha.androidinternshiptasks.adapter.AppealRecyclerViewDataAdapter;
import com.example.napha.androidinternshiptasks.model.UserRequest;

import java.text.SimpleDateFormat;
import java.util.Locale;

import xdroid.enumformat.EnumFormat;

public class AppealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_appeal_activity);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);

        UserRequest userRequest = (UserRequest)getIntent().getSerializableExtra("application");;
        Locale locale = new Locale("uk","UA");
        String format = "dd MMM yyyy";
        setTitle(userRequest.getId());
        ((TextView)findViewById(R.id.textViewTitle)).setText(userRequest.getTitle());
        ((TextView)findViewById(R.id.textViewIndicator)).setText(  EnumFormat.getInstance().format(userRequest.getIndicator()));
        ((TextView)findViewById(R.id.textViewCreated)).setText(new SimpleDateFormat(
                format, locale).format(userRequest.getDateOfCreation()));
        ((TextView)findViewById(R.id.textViewRegistered)).setText(new SimpleDateFormat(
                format, locale).format(userRequest.getDateOfRegistration()));
        ((TextView)findViewById(R.id.textViewSolved)).setText(new SimpleDateFormat(
                format, locale).format(userRequest.getDateOfResolution()));
        ((TextView)findViewById(R.id.textViewResponsible)).setText(userRequest.getResponsible());
        ((TextView)findViewById(R.id.textViewDescription)).setText(userRequest.getDescription());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        AppealRecyclerViewDataAdapter adapter = new AppealRecyclerViewDataAdapter(this, userRequest.getImagesName());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClick(View v){
        Toast.makeText(this,v.getClass().getSimpleName(), Toast.LENGTH_LONG).show();
    }
}
