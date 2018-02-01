/*
 * LonelyTwitterActivity.java
 *
 * Copyright (c) 2018 CMPUT 301, Michael Steer, University of Alberta -- All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the code of
 * student Student behavior at the University of Alberta. You can find a copy of the license in
 * this project. Otherwise please contact steer@ualberta.ca
 *
 * @Author Michael Steer
 * @Date 2018-01-30
 * @Version 0.1
 */

package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import static android.content.ContentValues.TAG;


/**
 * Main Activity for the Lonely Twitter application
 */
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "jsonfile575.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    ArrayAdapter<Tweet> adapter;


    /**
     * Called when the application is first created
     * @param savedInstanceState {@code Bundle} Information passed into the state
     */
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);

		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
        loadFromFile();
        adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
                NormalTweet newtweet = new NormalTweet(text, new Date(System.currentTimeMillis()));
                tweets.add(newtweet);

                adapter.notifyDataSetChanged();
                saveInFile(tweets);
			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		        setResult(RESULT_OK);
		        tweets.clear();

		        adapter.notifyDataSetChanged();
                saveInFile(tweets);
            }
        });

        if (tweets == null) {
            Log.d(TAG, "onCreate: WHY ARE YOU NULL WTF");
        }
	}

    /**
     * Called when the Application is started
     */
	@Override
	protected void onStart() {
		super.onStart();
		oldTweetsList.setAdapter(adapter);
	}

    /**
     * Load the tweets from a JSON file
     */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			Type ListType = new TypeToken<ArrayList<Tweet>>(){}.getType();
			tweets = gson.fromJson(in, ListType);
			if (tweets == null) {
			    tweets = new ArrayList<Tweet>();
            }
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

    /**
     * Save the tweets to a JSON File
     * @param tweets {@code ArrayList<Tweet>} The Array of tweets
     */
	private void saveInFile(ArrayList<Tweet> tweets) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweets, out);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


    /**
     * Called when the Activity is destroyed
     */
	public void onDestory() {
		super.onDestroy();
	}
}