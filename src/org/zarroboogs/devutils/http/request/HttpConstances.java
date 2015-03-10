package org.zarroboogs.devutils.http.request;

public class HttpConstances {
	public static final String USER_AGENT = "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";
	public static final String CONTENT_TYPE_URLENCODED = "application/x-www-form-urlencoded";
	// Upload File
	public static final String CONTENT_TYPE_OCTET_STREAM = "binary/octet-stream";
	
	public static enum Encode {
		UTF_8("UTF-8"), GBK("GBK");

		private String value;

		public String getValue() {
			return value;
		}

		Encode(String name) {
			this.value = name;
		}

	}
}
