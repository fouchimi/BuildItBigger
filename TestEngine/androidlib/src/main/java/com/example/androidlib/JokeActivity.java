package com.example.androidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class JokeActivity extends AppCompatActivity {
    TextView mJokeTextView;
    public final static String JOKE_KEY = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mJokeTextView = (TextView) findViewById(R.id.joke_textView);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if(b != null && b.containsKey(JOKE_KEY)){
            Toast.makeText(this, b.getString(JOKE_KEY), Toast.LENGTH_LONG).show();
            mJokeTextView.setText(b.getString(JOKE_KEY));
        }
    }

}
