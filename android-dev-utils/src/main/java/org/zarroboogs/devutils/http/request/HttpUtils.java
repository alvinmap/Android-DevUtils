package org.zarroboogs.devutils.http.request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.zarroboogs.devutils.http.request.HttpConstances.Encode;

public class HttpUtils {

	public static String decodeString(String entity) {
        String result = "";
		try {
			result = URLDecoder.decode(entity, Encode.GBK.getValue());
	        result = URLDecoder.decode(result, Encode.GBK.getValue());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result;
	}
	
	public static String UnicodeToString(String str) {
        if (str == null) {
            return str;
        }
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch + "");
        }
        return str;
    }
}
