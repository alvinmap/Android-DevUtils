package org.zarroboogs.devutils.http.request;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.zarroboogs.devutils.http.request.HttpConstances.Encode;

public class HttpEntryList extends ArrayList<NameValuePair> {
	private static final long serialVersionUID = -5823385899139108334L;

	public boolean addEntry(String name, String value) {
		return this.add(new BasicNameValuePair(name, value));
	}

	public HttpEntity build() {
		UrlEncodedFormEntity urlEncodedFormEntity = null;
		try {
			urlEncodedFormEntity = new UrlEncodedFormEntity(this, Encode.UTF_8.getValue());
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return urlEncodedFormEntity;
	}
}
