
package org.zarroboogs.devutils;

import android.util.Log;

public class OutLog {
    private static void d(String tag, String msg) {
        if (msg.trim().contains("\n")) {
            String[] lineStrings = msg.split("\n");
            for (String string : lineStrings) {
                Log.d(tag, string);
            }
        } else {
            Log.d(tag, msg);
        }

    }

    public static void print(String tag, String msg) {
        if (msg.length() > 3000) {
            Log.d(tag, "\r\n\r\n\r\n\r\n\r\n------------------------------------>>");
            int len = msg.length();
            int devideNumber = len / 3000;
            int j = 0;
            for (int i = 0; i < devideNumber; i++) {
                d(tag, msg.substring(j, j + 3000));
                j += 3000;
            }
            d(tag, msg.substring(j, msg.length()));
            Log.d(tag, "\r\n\r\n\r\n\r\n\r\n<<------------------------------------");
        } else {
            Log.d(tag, "\r\n\r\n\r\n\r\n\r\n<<<------------------------------------>>>");
            d(tag, msg);
        }
    }
}
