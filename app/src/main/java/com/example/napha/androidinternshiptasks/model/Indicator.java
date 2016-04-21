package com.example.napha.androidinternshiptasks.model;

/**
 * Created by Napha on 17.04.2016.
 */
public enum Indicator {
    InProgress ("В роботі"),
    Done ("Виконано"),
    NotDone ("Очікує");

    private final String name;

    private Indicator(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
