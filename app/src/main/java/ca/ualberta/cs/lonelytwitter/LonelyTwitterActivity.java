package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

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

import static android.content.ContentValues.TAG;


public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "jsonfile5.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);


		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
                NormalTweet newtweet = new NormalTweet(text, new Date(System.currentTimeMillis()));
                tweets.add(newtweet);
                saveInFile(tweets);
			}
		});


        loadFromFile();
        if (tweets == null) {
            Log.d(TAG, "onCreate: WHY ARE YOU NULL WTF");
        }
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		ArrayAdapter<Tweet> adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			Type ListType = new TypeToken<ArrayList<Tweet>>(){}.getType();
			tweets = gson.fromJson(in, ListType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void saveInFile(ArrayList<Tweet> tweets) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweets, out);


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	public void onDestory() {
		super.onDestroy();
	}
}