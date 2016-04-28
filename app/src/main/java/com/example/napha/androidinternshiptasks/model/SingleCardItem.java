package com.example.napha.androidinternshiptasks.model;

import java.util.Date;

/**
 * Created by Napha on 15.04.2016.
 */
public class SingleCardItem {
    private String mImage;
    private Integer mLikesCount;
    private String mTitleText;
    private String mStreet;
    private Date mBeginningDate;
    private Date mEndDate;

    public SingleCardItem() {
    }

    public SingleCardItem(String mImage, int mLikesCount, String mTitleText, String mStreet, Date mBeginningDate, Date mEndDate) {
        this.mImage = mImage;
        this.mTitleText = mTitleText;
        this.mStreet = mStreet;
        this.mBeginningDate = mBeginningDate;
        this.mEndDate = mEndDate;
        this.mLikesCount = mLikesCount;
    }

    public String getImage() {
        return mImage;
    }

    public String getTitleText() {
        return mTitleText;
    }

    public Integer getLikesCount() {
        return mLikesCount;
    }

    public void increaseLikesCount() {
        mLikesCount++;
    } //[Comment] unused


    public String getStreet() {
        return mStreet;
    }

    public Date getBeginningDate() {
        return mBeginningDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }
}
