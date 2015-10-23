package com.tatbigy.androidretrofit.model;

/**
 * Created by Ahmed on 10/4/15.
 * 04
 * Android Retrofit
 */
public class Results {

    /**
     * message : Required field(s) is missing
     */
    public Results() {

    }

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
