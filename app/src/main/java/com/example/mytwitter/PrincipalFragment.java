package com.example.mytwitter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mytwitter.beans.Tweet;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PrincipalFragment extends Fragment {
    Dialog dialog;
    RecyclerView recyView;
    MainActivity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        final List<Tweet> tweets = new ArrayList<>();
        View v = inflater.inflate(R.layout.principalfragment,
                container,false);
        tweets.add(new Tweet("Noor"));
        activity.tweet = tweets.get(0);
        recyView = (RecyclerView)  v.findViewById(R.id.list);
        recyView.setLayoutManager(new LinearLayoutManager(activity));
        final TweetAdapter tweetAdapter = new TweetAdapter(tweets,activity);
        recyView.setAdapter(tweetAdapter);

        dialog =  new Dialog(activity);
        dialog.setContentView(R.layout.dialogue);
        dialog.setTitle("Tweet");
        Button btnValider = (Button)
                dialog.findViewById(R.id.dialog_btn_valider);

        final TextView textDialogue = dialog.findViewById(R.id.dialog_libelle);
        btnValider.setOnClickListener(new
                                              View.OnClickListener() {
                                                  @Override public void onClick(View v) {
                                                      String tweetIn = textDialogue.getText().toString();
                                                      tweets.add(new Tweet(tweetIn));
                                                      tweetAdapter.notifyItemInserted(tweets.size());
                                                      tweetAdapter.notifyItemRangeChanged(tweets.size(),tweets.size());
                                                      dialog.cancel();
                                                  }
                                              });
        return v;
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        dialog.show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;
    }
}
