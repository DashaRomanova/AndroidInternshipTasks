package com.example.napha.androidinternshiptasks;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
//The following does not correspond to design:
//        - toolbar and status bar colors does not correspond to design
//        - background color
//        - "В роботі" indicator is too high
//
//        Task 1 requirements not fully met:
//        - For image loading use one of third party libraries (e.g. Picasso/Glide)
//
//        Java:
//        - Commented out code
//        - When inflating file do not pass null as a root (see Android Studio's warning)
//        - `irh` is a bad name for variable
//        - SingleItemModel contains only single String field. So you could use a String instead of your model.
//        - In adapter constractor parameteres you should accept more general interface List<..>, not ArrayList<..> realization
//        - mPictures can be a local variable, not a field
//        - Reference type of mPictures should be List<..>. Like that: List<..> pictures = new ArrayList<>(..)
//        - You don't have add finish into onBackPressed. it's already called by super method
//
//        XML/resources:
//        - You don't need `android:configChanges="orientation"` in manifest at least because orientation is always portrait.
//        - Vertical LinearLayout layout_height should be "wrap_content" (see Android Studio's warning)
//        - layout/activity_main.xml and layout-xlarge/activity_main.xml are identical
//        - list_single_image.xml could contain only <ImageView>. LinearLayout with only one child doesn't make sense.
//        - picture.jpg is not used
//
//        git:
//        - .idea folder can be removed from repo
//
//
//        - Code style is good
//        - It's cool that you can load images from assets, but for this task it's simpler to load them from drawable folder
//        - Otherwise looks good
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
