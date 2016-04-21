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

import com.example.napha.androidinternshiptasks.model.Application;
import com.example.napha.androidinternshiptasks.R;
import com.example.napha.androidinternshiptasks.adapter.AppealRecyclerViewDataAdapter;

import java.text.SimpleDateFormat;
import java.util.Locale;

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

        Application application = (Application)getIntent().getSerializableExtra("application");;
        Locale locale = new Locale("uk","UA");
        String format = "dd MMM yyyy";
        setTitle(application.getId());
        ((TextView)findViewById(R.id.textViewTitle)).setText(application.getTitle());
        ((TextView)findViewById(R.id.textViewIndicator)).setText(application.getIndicator().toString());
        ((TextView)findViewById(R.id.textViewCreated)).setText(new SimpleDateFormat(
                format, locale).format(application.getDateOfCreation()));
        ((TextView)findViewById(R.id.textViewRegistered)).setText(new SimpleDateFormat(
                format, locale).format(application.getDateOfRegistration()));
        ((TextView)findViewById(R.id.textViewSolved)).setText(new SimpleDateFormat(
                format, locale).format(application.getDateOfResolution()));
        ((TextView)findViewById(R.id.textViewResponsible)).setText(application.getResponsible());
        ((TextView)findViewById(R.id.textViewDescription)).setText(application.getDescription());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        AppealRecyclerViewDataAdapter adapter = new AppealRecyclerViewDataAdapter(this, application.getImagesName());
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
