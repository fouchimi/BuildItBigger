package com.example.ousmane.testengine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.JokeStore;
import com.example.androidlib.JokeActivity;

import java.util.List;

public class MainActivity extends ActionBarActivity implements EndpointsAsyncTask.AsyncTaskListener {
    private final static int COUNTER = 0;
    private final static String LOG_TAG = MainActivity.class.getSimpleName();
    SharedPreferences sharedpreferences;
    private JokeStore jokeStore = null;
    public final Context mContext = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreferences = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(getString(R.string.counter), COUNTER);
        editor.commit();
        EndpointsAsyncTask task = new EndpointsAsyncTask();
        task.execute(new Pair<Context, String>(MainActivity.this, ""));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        int defaultValue = getResources().getInteger(R.integer.default_value);
        int newCounter = prefs.getInt(getString(R.string.counter), defaultValue);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(getString(R.string.counter), ++newCounter);
        editor.commit();
        if(jokeStore != null){
            int index = (newCounter % jokeStore.getJokeStoreList().size());
            String joke = jokeStore.getJokeStoreList().get(index);
            Bundle bundle = new Bundle();
            bundle.putString(JokeActivity.JOKE_KEY, joke);
            Intent intent = new Intent(this, JokeActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }


    @Override
    public void onComplete(List<String> jokes) {
        jokeStore = new JokeStore();
        jokeStore.setJokeStoreList(jokes);
    }
}
