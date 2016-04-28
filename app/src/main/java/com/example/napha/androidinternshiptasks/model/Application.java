package com.example.napha.androidinternshiptasks.model;

import com.example.napha.androidinternshiptasks.model.Indicator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Napha on 15.04.2016.
 */
public class Application implements Serializable { //[Comment] Bad name for model
    private Indicator mIndicator;
    private String mId;
    private String mTitle;
    private String mTitleImage;
    private int mLikesCount;
    private Date mDateOfCreation;
    private Date mDateOfRegistration;
    private Date mDateOfResolution;
    private String mResponsible;
    private String mDescription;
    private String mStreet;
    private List<String> mImagesName;

    public Application(String mId,
                       Indicator mIndicator,
                       String mTitle,
                       String mTitleImage,
                       int mLikesCount,
                       Date mDateOfCreation,
                       Date mDateOfRegistration,
                       Date mDateOfResolution,
                       String mResponsible,
                       String mDescription,
                       String mStreet,
                       List<String> mImagesName) {
        this.mId = mId;
        this.mIndicator = mIndicator;
        this.mTitle = mTitle;
        this.mTitleImage = mTitleImage;
        this.mLikesCount = mLikesCount;
        this.mDateOfCreation = mDateOfCreation;
        this.mDateOfRegistration = mDateOfRegistration;
        this.mDateOfResolution = mDateOfResolution;
        this.mResponsible = mResponsible;
        this.mDescription = mDescription;
        this.mStreet = mStreet;
        this.mImagesName = mImagesName;
    }

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDateOfCreation() {
        return mDateOfCreation;
    }

    public Date getDateOfRegistration() {
        return mDateOfRegistration;
    }

    public Date getDateOfResolution() {
        return mDateOfResolution;
    }

    public String getResponsible() {
        return mResponsible;
    }

    public String getDescription() {
        return mDescription;
    }

    public List<String> getImagesName() {
        return mImagesName;
    }

    public String getStreet() {
        return mStreet;
    }

    public Indicator getIndicator() {
        return mIndicator;
    }

    public String getTitleImage() {
        return mTitleImage;
    }

    public int getLikesCount() {
        return mLikesCount;
    }

    @Override
    public String toString() {
        return "Application{" +
                "mIndicator=" + mIndicator +
                ", mId='" + mId + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mTitleImage='" + mTitleImage + '\'' +
                ", mLikesCount=" + mLikesCount +
                ", mDateOfCreation=" + mDateOfCreation +
                ", mDateOfRegistration=" + mDateOfRegistration +
                ", mDateOfResolution=" + mDateOfResolution +
                ", mResponsible='" + mResponsible + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mStreet='" + mStreet + '\'' +
                ", mImagesName=" + mImagesName +
                '}';
    }

    public static List<Application> loadTestApplications(){
        List<Application> applications = new ArrayList<>();
        String format = "yyyy.MM.dd";
        Locale locale = new Locale("ru");
        try{
            Date dateOfCreation = new SimpleDateFormat(format, locale).parse("2015.11.21");
            Date dateOfRegistration = new SimpleDateFormat(format, locale).parse("2015.11.22");
            Date dateOfResolution = new SimpleDateFormat(format, locale).parse("2015.11.27");

            applications.add(new Application(
                    "CE-12356",
                    Indicator.InProgress,
                    "Комунальне господарство",
                    "home.png",
                    5,
                    dateOfCreation,
                    dateOfRegistration,
                    dateOfResolution,
                    "Дніпропетровський МВК()",
                    "БлаБлаБла",
                    "пр.Повітрофлотський",
                    Arrays.asList("pic1.jpg", "pic2.jpg")));

            dateOfCreation = new SimpleDateFormat(format, locale).parse("2015.10.12");
            dateOfRegistration = new SimpleDateFormat(format, locale).parse("2015.10.13");
            dateOfResolution = new SimpleDateFormat(format, locale).parse("2015.10.20");
            applications.add(new Application(
                    "CE-1246545146",
                    Indicator.InProgress,
                    "Ремонт дороги",
                    "tool.png",
                    1,
                    dateOfCreation,
                    dateOfRegistration,
                    dateOfResolution,
                    "Дніпропетровський МВК()",
                    "БлаБлаБла",
                    "пр.Металургів",
                    Arrays.asList("pic3.jpg", "pic4.jpg")));

            dateOfCreation = new SimpleDateFormat(format, locale).parse("2015.10.12");
            dateOfRegistration = new SimpleDateFormat(format, locale).parse("2015.10.13");
            dateOfResolution = new SimpleDateFormat(format, locale).parse("2015.10.20");
            applications.add(new Application(
                    "CE-1246545146",
                    Indicator.InProgress,
                    "Прибирання та санітарній стан території",
                    "ic_trash.png",
                    4,
                    dateOfCreation,
                    dateOfRegistration,
                    dateOfResolution,
                    "Дніпропетровський МВК()",
                    "БлаБлаБла",
                    "вул.Івана Мазепи",
                    Arrays.asList("pic2.jpg", "pic3.jpg")));

            dateOfCreation = new SimpleDateFormat(format, locale).parse("2015.10.12");
            dateOfRegistration = new SimpleDateFormat(format, locale).parse("2015.10.13");
            dateOfResolution = new SimpleDateFormat(format, locale).parse("2015.10.20");
            applications.add(new Application(
                    "CE-1246545146",
                    Indicator.InProgress,
                    "Ремонт огородження",
                    "fence.png",
                    8,
                    dateOfCreation,
                    dateOfRegistration,
                    dateOfResolution,
                    "Дніпропетровський МВК()",
                    "БлаБлаБла",
                    "вул.Стадіонна",
                    Arrays.asList("pic7.jpg", "pic8.jpg")));

            dateOfCreation = new SimpleDateFormat(format, locale).parse("2015.10.12");
            dateOfRegistration = new SimpleDateFormat(format, locale).parse("2015.10.13");
            dateOfResolution = new SimpleDateFormat(format, locale).parse("2015.10.20");
            applications.add(new Application(
                    "CE-1246545146",
                    Indicator.Done,
                    "Ремонт дороги",
                    "tool.png",
                    6,
                    dateOfCreation,
                    dateOfRegistration,
                    dateOfResolution,
                    "Дніпропетровський МВК()",
                    "БлаБлаБла",
                    "вул. Школяренка",
                    Arrays.asList("pic3.jpg", "pic4.jpg")));
            dateOfCreation = new SimpleDateFormat(format, locale).parse("2015.10.12");
            dateOfRegistration = new SimpleDateFormat(format, locale).parse("2015.10.13");
            dateOfResolution = new SimpleDateFormat(format, locale).parse("2015.10.20");
            applications.add(new Application(
                    "CE-1246545146",
                    Indicator.Done,
                    "Ремонт огородження",
                    "fence.png",
                    0,
                    dateOfCreation,
                    dateOfRegistration,
                    dateOfResolution,
                    "Дніпропетровський МВК()",
                    "БлаБлаБла",
                    "вул. Школяренка",
                    Arrays.asList("pic7.jpg", "pic8.jpg")));
            dateOfCreation = new SimpleDateFormat(format, locale).parse("2015.10.24");
            dateOfRegistration = new SimpleDateFormat(format, locale).parse("2015.10.25");
            dateOfResolution = new SimpleDateFormat(format, locale).parse("2015.10.30");
            applications.add(new Application(
                    "CE-15484",
                    Indicator.NotDone,
                    "Будівництво магазину",
                    "home.png",
                    15,
                    dateOfCreation,
                    dateOfRegistration,
                    dateOfResolution,
                    "Дніпропетровський МВК()",
                    "БлаБлаБла",
                    "пр.Повітрофлотський",
                    Arrays.asList("pic5.jpg", "pic6.jpg")));
            dateOfCreation = new SimpleDateFormat(format, locale).parse("2015.09.24");
            dateOfRegistration = new SimpleDateFormat(format, locale).parse("2015.09.25");
            dateOfResolution = new SimpleDateFormat(format, locale).parse("2015.09.30");
            applications.add(new Application(
                    "CE-15484",
                    Indicator.NotDone,
                    "Будівництво дитячого саду",
                    "home.png",
                    11,
                    dateOfCreation,
                    dateOfRegistration,
                    dateOfResolution,
                    "Дніпропетровський МВК()",
                    "БлаБлаБла",
                    "вул.Кропивницького",
                    Arrays.asList("pic9.jpg", "pic10.jpg")));
            dateOfCreation = new SimpleDateFormat(format, locale).parse("2015.10.11");
            dateOfRegistration = new SimpleDateFormat(format, locale).parse("2015.10.11");
            dateOfResolution = new SimpleDateFormat(format, locale).parse("2015.10.13");
            applications.add(new Application(
                    "CE-15484",
                    Indicator.NotDone,
                    "Ремонт стелі",
                    "tool.png",
                    41,
                    dateOfCreation,
                    dateOfRegistration,
                    dateOfResolution,
                    "Дніпропетровський МВК()",
                    "БлаБлаБла",
                    "пр.Перемоги",
                    Arrays.asList("pic11.jpg", "pic12.jpg")));
            dateOfCreation = new SimpleDateFormat(format, locale).parse("2015.07.01");
            dateOfRegistration = new SimpleDateFormat(format, locale).parse("2015.07.04");
            dateOfResolution = new SimpleDateFormat(format, locale).parse("2015.07.10");
            applications.add(new Application(
                    "CE-12356",
                    Indicator.NotDone,
                    "Комунальне господарство",
                    "home.png",
                    5,
                    dateOfCreation,
                    dateOfRegistration,
                    dateOfResolution,
                    "Дніпропетровський МВК()",
                    "БлаБлаБла",
                    "пр.Повітрофлотський",
                    Arrays.asList("pic1.jpg", "pic2.jpg")));
            dateOfCreation = new SimpleDateFormat(format, locale).parse("2015.07.15");
            dateOfRegistration = new SimpleDateFormat(format, locale).parse("2015.07.16");
            dateOfResolution = new SimpleDateFormat(format, locale).parse("2015.07.20");
            applications.add(new Application(
                    "CE-12356",
                    Indicator.NotDone,
                    "Демонтаж інших об’єктів",
                    "arrows.png",
                    10,
                    dateOfCreation,
                    dateOfRegistration,
                    dateOfResolution,
                    "Дніпропетровський МВК()",
                    "БлаБлаБла",
                    "вул. Червоноармійська",
                    Arrays.asList("pic13.jpg", "pic14.jpg")));
            dateOfCreation = new SimpleDateFormat(format, locale).parse("2015.04.15");
            dateOfRegistration = new SimpleDateFormat(format, locale).parse("2015.04.16");
            dateOfResolution = new SimpleDateFormat(format, locale).parse("2015.04.20");
            applications.add(new Application(
                    "CE-12356",
                    Indicator.NotDone,
                    "Ремонт та обслуговування ліфтів",
                    "tool.png",
                    10,
                    dateOfCreation,
                    dateOfRegistration,
                    dateOfResolution,
                    "Дніпропетровський МВК()",
                    "БлаБлаБла",
                    "вул. Червоноармійська",
                    Arrays.asList("pic15.jpg", "pic16.jpg")));
        }catch (java.text.ParseException exp){
            System.out.println(exp.getStackTrace());
        }
        return applications;
    }
}
