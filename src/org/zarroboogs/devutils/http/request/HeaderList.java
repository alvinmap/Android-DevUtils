package org.zarroboogs.devutils.http.request;

import java.util.ArrayList;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class HeaderList extends ArrayList<BasicHeader> {
	private static final long serialVersionUID = 9116802460410721239L;
	
	public boolean addHeader(String name, String value) {
		ThrowExceptionIfKeyExist(name);
		return this.add(new BasicHeader(name, value));
	}

	public boolean addHost(String host) {
		return addHeader("Host", host);
	}

	public boolean addReferer(String referer) {
		return addHeader("Referer", referer);
	}

	public boolean addOrigin(String origin) {
		return addHeader("Origin", origin);
	}

	public boolean addAccept(String accept) {

		return addHeader("Accept", accept);
	}

	public boolean addUserAgent(String userAgent) {
		return addHeader("User-Agent", userAgent);
	}

	public boolean addAcceptEncoding(String acceptEncoding) {
		return addHeader("Accept-Encoding", acceptEncoding);
	}

	public boolean addAcceptLanguage(String acceptLanguage) {
		return addHeader("Accept-Language", acceptLanguage);
	}

	public Header[] build() {
		return this.toArray(new Header[this.size()]);
	}

	private void ThrowExceptionIfKeyExist(String key) {
		for (BasicHeader nv : this) {
			if (nv.getName().trim().equalsIgnoreCase(key.trim())) {
				throw new RuntimeException("You Have Already Add Key: " + key + " , don't add again");
			}
		}
	}
}
