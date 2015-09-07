package org.zarroboogs.devutils.http;

import java.io.UnsupportedEncodingException;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.support.v4.app.Fragment;

public abstract class AbsAsyncGetFragment extends Fragment {

    private AsyncHttpClient mAsyncHttpClient = new AsyncHttpClient();

    private int mRequestCode = DEF_CODE;
    
    private static final int DEF_CODE = -1;
    
    public abstract void onGetSuccess(int requestCode , String response);

    public abstract void onGetFailed(int requestCode ,String requestUrl, String error);

    public abstract void onRequestStart(int requestCode );
    
    private String encode = "UTF-8";
    
    public void setEnCode(String encode){
    	this.encode = "gb2312";
    }

    public AsyncHttpClient getAsyncHttpClient(){
    	return mAsyncHttpClient;
    }
    
    public void asyncHttpGet(int reCode, final String url) {
    	this.mRequestCode = reCode;
    	
    	if (mRequestCode != DEF_CODE) {
			return;
		}
        mAsyncHttpClient.get(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                try {
					onGetSuccess(mRequestCode, new String(arg2, encode));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                mRequestCode = DEF_CODE;
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onGetFailed(mRequestCode, url,arg3.getMessage() + "  CODE:" + arg0);
                mRequestCode = DEF_CODE;
            }
        });
    }

    public void asyncHttpGet(int reCode, final String url, RequestParams params) {
    	this.mRequestCode = reCode;
    	if (mRequestCode != DEF_CODE) {
			return;
		}
        mAsyncHttpClient.get(url, params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                try {
					onGetSuccess(mRequestCode, new String(arg2, encode));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                mRequestCode = DEF_CODE;
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onGetFailed(mRequestCode, url, arg3.getMessage() + "  CODE:" + arg0);
                mRequestCode = DEF_CODE;
            }
        });
    }

    public void asyncHttpGet(int reCode, final String url, Header[] headers, RequestParams params) {
    	this.mRequestCode = reCode;
    	
    	if (mRequestCode != DEF_CODE) {
			return;
		}
        mAsyncHttpClient.get(getActivity().getApplicationContext(), url, headers, params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                try {
					onGetSuccess(mRequestCode, new String(arg2, encode));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                mRequestCode = DEF_CODE;
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                onGetFailed(mRequestCode, url,arg3.getMessage() + "  CODE:" + arg0);
                mRequestCode = DEF_CODE;
            }
        });
    }

}
