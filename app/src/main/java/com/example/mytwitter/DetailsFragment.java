package com.example.mytwitter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailsFragment extends Fragment {

    DetailsActivity detailsActivity = null;
    MainActivity mainActivity = null;


    ImageView imageView;
    TextView name;
    TextView tweet;
    TextView date;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detailsfragment,
                container,false);
        imageView = v.findViewById(R.id.image);
        name = v.findViewById(R.id.name);
        tweet = v.findViewById(R.id.tweet);
        date = v.findViewById(R.id.date);
        if(detailsActivity != null){
            imageView.setImageResource(detailsActivity.tweet.getImage());
            name.setText(detailsActivity.tweet.getName());
            tweet.setText(detailsActivity.tweet.getTweet());
            date.setText(detailsActivity.tweet.getDatePub());
        }else{
            if(mainActivity.tweet != null){
                imageView.setImageResource(mainActivity.tweet.getImage());
                name.setText(mainActivity.tweet.getName());
                tweet.setText(mainActivity.tweet.getTweet());
                date.setText(mainActivity.tweet.getDatePub());
            }
        }
        return  v;
    }

    public  void setElements(){
        if(mainActivity.tweet == null ){
            imageView.setImageResource(R.drawable.ic_sentiment_very_dissatisfied_black_24dp);
            name.setText("nathing to show");
            tweet.setText("");
            date.setText("");
            Toast.makeText(mainActivity,"vide", Toast.LENGTH_LONG).show();
        }else {
            imageView.setImageResource(mainActivity.tweet.getImage());
            name.setText(mainActivity.tweet.getName());
            tweet.setText(mainActivity.tweet.getTweet());
            date.setText(mainActivity.tweet.getDatePub());
        }
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof DetailsActivity ) detailsActivity = (DetailsActivity) context;
        else mainActivity = (MainActivity) context;
    }
}
