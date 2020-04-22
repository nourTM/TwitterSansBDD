package com.example.mytwitter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Dialog dialog;
    RecyclerView   recyView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<String> tweets = new ArrayList<>();
        tweets.add("Noor");
        tweets.add("Mami");
        recyView = (RecyclerView) findViewById(R.id.list);
        recyView.setLayoutManager(new LinearLayoutManager(this));
        recyView.setAdapter(new TweetAdapter(tweets));

        dialog =  new Dialog(this);
        dialog.setContentView(R.layout.dialogue);
        dialog.setTitle("Tweet");
        Button btnValider = (Button)
                dialog.findViewById(R.id.dialog_btn_valider);

        final TextView textDialogue = dialog.findViewById(R.id.dialog_libelle);
        btnValider.setOnClickListener(new
                                              View.OnClickListener() {
                                                  @Override public void onClick(View v) {
                                                      String tweet = textDialogue.getText().toString();
                                                      tweets.add(tweet);
                                                      dialog.cancel();
                                                  }
                                              });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        dialog.show();
        return super.onOptionsItemSelected(item);
    }
}
