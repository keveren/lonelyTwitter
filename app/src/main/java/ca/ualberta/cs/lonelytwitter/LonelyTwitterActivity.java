package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.io.File;
import java.util.Date;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet tweet = new importantTweet();
				tweet.setMessage(text);

				tweetList.add(tweet);
				adapter.notifyDataSetChanged();
				saveInFile();

				//saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();
			}
		});
		}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets = loadFromFile();
		loadFromFile();
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				//R.layout.list_item, tweets);
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {


		//ArrayList<String> tweets = new ArrayList<String>();
		try {

			//FileInputStream fis = openFileInput(FILENAME);
			//BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			//String line = in.readLine();
			//while (line != null) {
			//	tweets.add(line);
			//	line = in.readLine();
			//}
			FileReader in = new FileReader(new File(getFilesDir(),FILENAME));
			Gson gson = new Gson();
			Type type = new TypeToken<ArrayList<importantTweet>> (){}.getType();

			tweetList = gson.fromJson(in, type);



			//gson.fromJson(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return tweets.toArray(new String[tweets.size()]);



	}

	//private void saveInFile(String text, Date date) {
	private void saveInFile (){
		try {
			//FileOutputStream fos = openFileOutput(FILENAME,
				//	Context.MODE_APPEND);
			//fos.write(new String(date.toString() + " | " + text)
			//		.getBytes());
			//fos.close();
			FileWriter out = new FileWriter(new File (getFilesDir(), FILENAME));

			Gson gson = new Gson();

			gson.toJson(tweetList, out);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}