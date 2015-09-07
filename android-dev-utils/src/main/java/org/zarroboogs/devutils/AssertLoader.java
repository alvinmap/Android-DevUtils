
package org.zarroboogs.devutils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import android.content.Context;
import android.content.res.AssetManager;

public class AssertLoader {
    private Scanner scanner;
    private Context mContext;

    public AssertLoader(Context context) {
        this.mContext = context;
    }

    public String loadJs(String fileName) {
        try {
            return ReadFile(mContext, fileName);
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    protected String ReadFile(Context context, String fileName)
            throws IOException {
        final AssetManager am = context.getAssets();
        final InputStream inputStream = am.open(fileName);

        scanner = new Scanner(inputStream, "UTF-8");
        return scanner.useDelimiter("\\A").next();
    }

}
