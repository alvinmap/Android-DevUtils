
package org.zarroboogs.devutils.http;

import com.loopj.android.http.AsyncHttpClient;

import android.app.Activity;

public abstract class AbsAsyncHttpActivity extends Activity {

    private AsyncHttpClient mAsyncHttpClient = new AsyncHttpClient();

    abstract void onPostSuccess(String response);

    abstract void onPostFailed(String error);

    abstract void onGetSuccess(String response);

    abstract void onGetFailed(String error);

    abstract void onRequestStart();

    protected void asyncHttpGet() {

    }

    protected void asyncHttpPost() {

    }
}
