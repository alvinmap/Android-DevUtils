
package org.zarroboogs.devutils.http;

import android.os.Bundle;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.support.v7.app.ActionBarActivity;
import android.view.WindowManager;

public abstract class TranslucentStatusBarActivity extends ActionBarActivity {

    public abstract int getStatusBarColor();
    
    public abstract int getStatusBarColorBlack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        super.onCreate(savedInstanceState);

    }
}
