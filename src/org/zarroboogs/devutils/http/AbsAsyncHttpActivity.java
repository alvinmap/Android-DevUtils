
package org.zarroboogs.devutils.http;

import org.apache.http.Header;
import org.apache.http.HttpEntity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;

public abstract class AbsAsyncHttpActivity extends Activity {

    private AsyncHttpClient mAsyncHttpClient = new AsyncHttpClient();

    abstract void onPostSuccess(String response);

    abstract void onPostFailed(String error);

    abstract void onGetSuccess(String response);

    abstract void onGetFailed(String error);

    abstract void onRequestStart();

    protected void asyncHttpGet(String url) {
        mAsyncHttpClient.get(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                onGetSuccess(new String(arg2));
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onGetFailed(arg3.getMessage());
            }
        });
    }

    protected void asyncHttpGet(String url, RequestParams params) {
        mAsyncHttpClient.get(url, params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                onGetSuccess(new String(arg2));
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onGetFailed(arg3.getMessage());
            }
        });
    }

    protected void asyncHttpGet(String url, Header[] headers, RequestParams params) {
        mAsyncHttpClient.get(getApplicationContext(), url, headers, params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                onGetSuccess(new String(arg2));
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onGetFailed(arg3.getMessage());
            }
        });
    }

    protected void asyncHttpPost(String url) {
        mAsyncHttpClient.post(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                onPostSuccess(new String(arg2));
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onPostFailed(arg3.getMessage());
            }
        });
    }

    protected void asyncHttpPost(String url, RequestParams params) {
        mAsyncHttpClient.post(url, params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                onPostSuccess(new String(arg2));
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onPostFailed(arg3.getMessage());
            }
        });
    }

    protected void asyncHttpPost(String url, HttpEntity entity, String contentType) {
        mAsyncHttpClient.post(getApplicationContext(), url, entity, contentType, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                onPostSuccess(new String(arg2));
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onPostFailed(arg3.getMessage());
            }
        });
    }

    protected void asyncHttpPost(String url, Header[] headers, HttpEntity entity, String contentType) {
        mAsyncHttpClient.post(getApplicationContext(), url, headers, entity, contentType, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                onPostSuccess(new String(arg2));
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onPostFailed(arg3.getMessage());
            }
        });
    }

    protected void asyncHttpPost(String url, Header[] headers, RequestParams params, String contentType) {
        mAsyncHttpClient.post(getApplicationContext(), url, headers, params, contentType, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                onPostSuccess(new String(arg2));
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onPostFailed(arg3.getMessage());
            }
        });
    }

    protected void asyncHttpPost(String url, HttpEntity entity, String contentType, RequestParams params) {
        mAsyncHttpClient.post(getApplicationContext(), url, entity, contentType, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                onPostSuccess(new String(arg2));
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onPostFailed(arg3.getMessage());
            }
        });
    }
}
