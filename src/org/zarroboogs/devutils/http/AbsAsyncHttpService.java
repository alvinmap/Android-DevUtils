package org.zarroboogs.devutils.http;

import java.io.UnsupportedEncodingException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public abstract class AbsAsyncHttpService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}


    private AsyncHttpClient mAsyncHttpClient = new AsyncHttpClient();

    public abstract void onPostSuccess(String response);

    public abstract void onPostFailed(String requestUrl , String error);

    public abstract void onGetSuccess(String response);

    public abstract void onGetFailed(String requestUrl, String error);

    public abstract void onRequestStart();
    
    private String encode = "UTF-8";
    
    public void setEnCode(String encode){
    	this.encode = "gb2312";
    }

    public void asyncHttpGet(final String url) {
        mAsyncHttpClient.get(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                try {
					onGetSuccess(new String(arg2, encode));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onGetFailed(url,arg3.getMessage() + "  CODE:" + arg0);
            }
        });
    }

    public void asyncHttpGet(final String url, RequestParams params) {
        mAsyncHttpClient.get(url, params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                try {
					onGetSuccess(new String(arg2, encode));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onGetFailed(url, arg3.getMessage() + "  CODE:" + arg0);
            }
        });
    }

    public void asyncHttpGet(final String url, Header[] headers, RequestParams params) {
        mAsyncHttpClient.get(getApplicationContext(), url, headers, params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                try {
					onGetSuccess(new String(arg2, encode));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onGetFailed(url,arg3.getMessage() + "  CODE:" + arg0);
            }
        });
    }

    public void asyncHttpPost(final String url) {
        mAsyncHttpClient.post(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                try {
					onPostSuccess(new String(arg2, encode));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onPostFailed(url, arg3.getMessage() + "  CODE:" + arg0);
            }
        });
    }

    public void asyncHttpPost(final String url, RequestParams params) {
        mAsyncHttpClient.post(url, params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                try {
					onPostSuccess(new String(arg2, encode));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onPostFailed(url, arg3.getMessage() + "  CODE:" + arg0);
            }
        });
    }

    public void asyncHttpPost(final String url, HttpEntity entity, String contentType) {
        mAsyncHttpClient.post(getApplicationContext(), url, entity, contentType, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                try {
					onPostSuccess(new String(arg2, encode));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onPostFailed(url, arg3.getMessage() + "  CODE:" + arg0);
            }
        });
    }

    public void asyncHttpPost(final String url, Header[] headers, HttpEntity entity, String contentType) {
        mAsyncHttpClient.post(getApplicationContext(), url, headers, entity, contentType, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                try {
					onPostSuccess(new String(arg2, encode));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onPostFailed(url, arg3.getMessage() + "  CODE:" + arg0);
            }
        });
    }

    public void asyncHttpPost(final String url, Header[] headers, RequestParams params, String contentType) {
        mAsyncHttpClient.post(getApplicationContext(), url, headers, params, contentType, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                try {
					onPostSuccess(new String(arg2, encode));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onPostFailed(url,arg3.getMessage() + "  CODE:" + arg0);
            }
        });
    }

    public void asyncHttpPost(final String url, HttpEntity entity, String contentType, RequestParams params) {
        mAsyncHttpClient.post(getApplicationContext(), url, entity, contentType, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                try {
					onPostSuccess(new String(arg2, encode));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onPostFailed(url, arg3.getMessage() + "  CODE:" + arg0);
            }
        });
    }


}
