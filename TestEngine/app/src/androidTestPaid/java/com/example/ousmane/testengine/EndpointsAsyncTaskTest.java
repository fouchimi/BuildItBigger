package com.example.ousmane.testengine;

import android.content.Context;
import android.support.v4.util.Pair;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.util.Log;

import com.example.ousmane.paid.EndpointsAsyncTask;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by ousmane on 9/19/16.
 */

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest extends AndroidTestCase {
    CountDownLatch signal = null;
    List<String> mListResult = null;
    private final static String LOG_TAG = EndpointsAsyncTask.class.getSimpleName();

    @Before
    public void setUp() throws Exception {
        super.setUp();
        signal = new CountDownLatch(1);
        Log.d(LOG_TAG, "STARTING ...");
    }

    @Test
    public void testEndpointsAsyncTask() throws InterruptedException {

        EndpointsAsyncTask task = new EndpointsAsyncTask();
        task.setListener(new EndpointsAsyncTask.AsyncTaskListener() {
            @Override
            public void onComplete(List<String> result) {
                mListResult = result;
                signal.countDown();
            }
        }).execute(new Pair<Context, String>(getContext(), ""));
        signal.await();

        Assert.assertNotNull(mListResult);
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        signal.countDown();
        Log.d(LOG_TAG, "ENDING ...");
    }
}
