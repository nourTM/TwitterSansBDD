package com.example.mytwitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mytwitter.beans.Tweet;

public class DetailsActivity extends AppCompatActivity {

    public Tweet tweet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        tweet = intent.getParcelableExtra("pet");
        setContentView(R.layout.activity_details);

    }
}
