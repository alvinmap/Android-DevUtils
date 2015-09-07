package org.zarroboogs.devutils.http.request;

import org.apache.http.Header;

public class HttpHeaderFactory {

	public static Header[] createBasicHeaders() {
		HeaderList headerList = new HeaderList();
		headerList.addUserAgent(HttpConstances.USER_AGENT);
		return headerList.build();
	}
	
}
