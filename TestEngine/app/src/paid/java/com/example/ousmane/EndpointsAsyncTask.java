package com.example.ousmane;

/**
 * Created by ousmane on 9/19/16.
 */
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;

import com.example.ousmane.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.List;

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, List<String>> {
    private static MyApi myApiService = null;
    private Context context;
    private List<String> result = null;
    private AsyncTaskListener mListener = null;

    public EndpointsAsyncTask(){

    }

    @Override
    protected List<String> doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-143723.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        context = params[0].first;
        try {
            result = myApiService.getJokesList().execute().getJokeList();
        } catch (IOException e) {
            e.printStackTrace();
            throw  new RuntimeException("Couldn't fetched joke");
        }
        return result;
    }

    public EndpointsAsyncTask setListener(AsyncTaskListener listener){
        this.mListener = listener;
        return this;
    }


    @Override
    protected void onPostExecute(List<String> result) {
        if (result != null){
            if(mListener != null && mListener instanceof AsyncTaskListener){
                mListener.onComplete(result);
            }else {
                mListener = (MainActivity) context;
                mListener.onComplete(result);
            }

        }
    }

    public static interface AsyncTaskListener{
        void onComplete(List<String> jokes);
    }

}
