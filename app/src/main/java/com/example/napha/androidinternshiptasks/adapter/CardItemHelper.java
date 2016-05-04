package com.example.napha.androidinternshiptasks.adapter;

import com.example.napha.androidinternshiptasks.model.SingleCardItem;
import com.example.napha.androidinternshiptasks.model.UserRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Napha on 29.04.2016.
 */
public class CardItemHelper {
    public static List<SingleCardItem> createCardItems(List<UserRequest> userRequests){
        List<SingleCardItem> cardItems = new ArrayList<>();
        for (UserRequest request:userRequests) {
            cardItems.add(createCardItem((request)));
        }
        return cardItems;
    }

    public static SingleCardItem createCardItem(UserRequest userRequest){
        String likeImage = "hand.png";
        return new SingleCardItem(
                userRequest.getTitleImage(),
                likeImage,
                userRequest.getLikesCount(),
                userRequest.getTitle(),
                userRequest.getStreet(),
                userRequest.getDateOfRegistration(),
                userRequest.getDateOfResolution());
    }

    public static long getDifferenceBetweenTwoDates(Date begin, Date end){
        long difference = begin.getTime() - end.getTime();
        // seconds
        long seconds = difference / 1000;
        // minutes
        long minutes = seconds / 60;
        // hours
        long hours = minutes / 60;
        // days
        long days = hours / 24;
        return days;
    }
}
