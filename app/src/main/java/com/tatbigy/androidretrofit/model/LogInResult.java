package com.tatbigy.androidretrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ahmed on 10/12/15.
 * 00
 * Android Retrofit
 */
public class LogInResult implements Parcelable {

    /**
     * code : 0
     * message : LogIn successfull
     * name : ahmed
     * id_user : null
     * phone : null
     * email : ahmed.s.alotibi@gmail.com
     */

    private int code;
    private String message;
    private String name;
    private String id_user;
    private String email;

    protected LogInResult(Parcel in) {
        code = in.readInt();
        message = in.readString();
        name = in.readString();
        email = in.readString();
    }

    public static final Creator<LogInResult> CREATOR = new Creator<LogInResult>() {
        @Override
        public LogInResult createFromParcel(Parcel in) {
            return new LogInResult(in);
        }

        @Override
        public LogInResult[] newArray(int size) {
            return new LogInResult[size];
        }
    };

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getId_user() {
        return id_user;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(code);
        parcel.writeString(message);
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(id_user);

    }
}
