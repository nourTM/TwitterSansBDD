package com.example.mytwitter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mytwitter.beans.Tweet;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TweetViewHolder extends RecyclerView.ViewHolder {
    TextView tweet;
    ImageView image;
    TextView name;

    public TweetViewHolder(@NonNull View itemView) {
        super(itemView);
        findViews(itemView);
    }

    private void findViews(View view) {
        tweet = view.findViewById(R.id.tweet);
        image = view.findViewById(R.id.image);
        name = view.findViewById(R.id.name);
    }

    public void setItem(final Tweet tweet) {
            this.tweet.setText(tweet.getTweet());
            this.image.setImageResource(tweet.getImage());
            this.name.setText(tweet.getName());
    }
}
