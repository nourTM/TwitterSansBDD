package com.example.mytwitter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TweetAdapter extends RecyclerView.Adapter<TweetViewHolder> {

    List<String> tweets;

    public TweetAdapter(List<String> tweets) {
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirm = new AlertDialog.Builder(v.getContext());
                confirm.setTitle("Delete Tweet");
                confirm.setIcon(android.R.drawable.ic_menu_delete);
                confirm.setMessage("Are you sure to delete the selected tweet ?");
                confirm.setPositiveButton(android.R.string.yes,
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int idBtn) {
                                tweets.remove(position);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position,tweets.size());
                            }
                        });
                confirm.setNegativeButton(android.R.string.no, null);
                confirm.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

}