package com.example.mytwitter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
import android.widget.Toast;

import com.example.mytwitter.beans.Tweet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public Tweet tweet;
    DetailsFragment dfrag = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        dfrag = (DetailsFragment) manager.findFragmentById(R.id.dfrag);
    }

    public void putElement(){
        if (dfrag != null) {
            dfrag.setElements();
        }
    }

}