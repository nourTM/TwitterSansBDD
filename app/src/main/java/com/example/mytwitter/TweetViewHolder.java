package com.example.mytwitter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TweetViewHolder extends RecyclerView.ViewHolder {
    TextView tweet;

    public TweetViewHolder(@NonNull View itemView) {
        super(itemView);
        findViews(itemView);
    }

    private void findViews(View view) {
        tweet = (TextView) view.findViewById(R.id.tweet);
    }

    public void setItem(final String tweet) {
            this.tweet.setText(tweet);
    }
}
