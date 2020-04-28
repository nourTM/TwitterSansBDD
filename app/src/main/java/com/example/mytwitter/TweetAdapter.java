package com.example.mytwitter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytwitter.beans.Tweet;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TweetAdapter extends RecyclerView.Adapter<TweetViewHolder> {

    MainActivity mainActivity;
    List<Tweet> tweets;

    public TweetAdapter(List<Tweet> tweets, MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.tweets = tweets;
    }


    @NonNull
    @Override
    public TweetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new TweetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TweetViewHolder holder, final int position) {
        holder.setItem(tweets.get(position));
        // delete listener
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder confirm = new AlertDialog.Builder(v.getContext());
                confirm.setTitle("Delete Tweet");
                confirm.setIcon(android.R.drawable.ic_menu_delete);
                confirm.setMessage("Are you sure to delete the selected tweet ?");
                confirm.setPositiveButton(android.R.string.yes,
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int idBtn) {
                                if (mainActivity.tweet == tweets.get(position)){
                                    tweets.remove(position);
                                    if (tweets.size() != 0) mainActivity.tweet = tweets.get(0);
                                    else mainActivity.tweet = null;
                                    mainActivity.putElement();
                                }else{
                                    tweets.remove(position);
                                }
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position,tweets.size());
                            }
                        });
                confirm.setNegativeButton(android.R.string.no, null);
                confirm.show();
                return false;
            }
        });
        // details listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int displaymode = mainActivity.getResources().getConfiguration().orientation;

                if (displaymode == Configuration.ORIENTATION_PORTRAIT) {
                    Intent intent = new Intent(mainActivity,DetailsActivity.class);
                    intent.putExtra("pet",tweets.get(position));
                    mainActivity.startActivity(intent);
                }else{
                    mainActivity.tweet = tweets.get(position);
                    mainActivity.putElement();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

}