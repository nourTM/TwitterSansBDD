package com.example.mytwitter.beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.mytwitter.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Tweet  implements Parcelable {
    private String name = "your pet";
    private String tweet;
    private int image = R.drawable.ic_pets_black_24dp;
    private String datePub;

    public Tweet(String tweet) {
        this.tweet = tweet;
        Calendar rightNow = Calendar.getInstance();

        DateFormat d = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.getDefault());

        datePub = d.format(rightNow.getTime());
    }

    protected Tweet(Parcel in)  {
        name = in.readString();
        tweet = in.readString();
        image = in.readInt();
        datePub = in.readString();
    }

    public static final Creator<Tweet> CREATOR = new Creator<Tweet>() {
        @Override
        public Tweet createFromParcel(Parcel in) {
                return new Tweet(in);
        }

        @Override
        public Tweet[] newArray(int size) {
            return new Tweet[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getTweet() {
        return tweet;
    }

    public int getImage() {
        return image;
    }

    public String getDatePub() {
        return datePub;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(tweet);
        dest.writeInt(image);
        dest.writeString(datePub);
    }
}
