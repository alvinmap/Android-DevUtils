
package org.zarroboogs.devutils.http;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;

public abstract class TranslucentStatusBarActivity extends Activity {

    public abstract int getStatusBarColor();
    
    public abstract int getStatusBarColorBlack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            // R.color.actionbar_dark
            tintManager.setStatusBarTintResource(getStatusBarColor());

            int height = getNavigationBarHeight(this.getApplicationContext(), Configuration.ORIENTATION_PORTRAIT);

            boolean hasMenuKey = ViewConfiguration.get(this).hasPermanentMenuKey();
            boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);

            if (!(isMeiZu() || isHuaWei())) {
                if (!hasMenuKey && !hasBackKey) {
                    // Do whatever you need to do, this device has a navigation bar
                    tintManager.setNavigationBarTintEnabled(true);
                    tintManager.setNavigationBarTintResource(getStatusBarColorBlack());
                } else {
                    tintManager.setNavigationBarTintEnabled(false);
                }
            }
        }

    }

    public static boolean isMeiZu() {
        return "Meizu".equalsIgnoreCase(android.os.Build.MANUFACTURER);
    }

    public static boolean isHuaWei() {
        return "HUAWEI".equalsIgnoreCase(android.os.Build.MANUFACTURER);
    }

    private int getNavigationBarHeight(Context context, int orientation) {
        Resources resources = context.getResources();

        int id = resources.getIdentifier(
                orientation == Configuration.ORIENTATION_PORTRAIT ? "navigation_bar_height"
                        : "navigation_bar_height_landscape",
                "dimen", "android");
        if (id > 0) {
            return resources.getDimensionPixelSize(id);
        }
        return 0;
    }

    @TargetApi(19)
    public void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}
