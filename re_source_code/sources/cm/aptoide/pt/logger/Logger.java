package cm.aptoide.pt.logger;

import android.util.Log;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class Logger {
    private static boolean DBG;
    private static Logger instance;

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public static void setDBG(boolean z) {
        DBG = z;
    }

    public void d(Object obj, String str) {
        d(obj.getClass().getSimpleName(), str);
    }

    public void e(Object obj, String str) {
        e(obj.getClass().getName(), str);
    }

    public void i(Object obj, String str) {
        i(obj.getClass().getSimpleName(), str);
    }

    public void v(String str, String str2) {
        if (!DBG || str2 == null) {
            return;
        }
        Log.v(str, str2);
    }

    public void w(String str, String str2) {
        if (str2 != null) {
            Log.w(str, str2);
        }
    }

    public void w(String str, String str2, Throwable th) {
        if (str2 != null) {
            Log.w(str, str2, th);
        }
    }

    public void v(String str, String str2, Throwable th) {
        if (!DBG || str2 == null) {
            return;
        }
        Log.v(str, str2, th);
    }

    public void d(String str, String str2) {
        if (!DBG || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    public void e(String str, String str2) {
        if (str2 != null) {
            Log.e(str, str2);
        }
    }

    public void i(String str, String str2) {
        if (!DBG || str2 == null) {
            return;
        }
        Log.i(str, str2);
    }

    public void e(Object obj, Throwable th) {
        e(obj.getClass().getName(), th);
    }

    public void d(String str, String str2, Throwable th) {
        if (!DBG || str2 == null) {
            return;
        }
        Log.d(str, str2, th);
    }

    public void i(Class cls, String str) {
        i(cls.getSimpleName(), str);
    }

    public void e(String str, Throwable th) {
        Log.e(str, HttpUrl.FRAGMENT_ENCODE_SET, th);
    }

    public void e(String str, String str2, Throwable th) {
        if (str2 != null) {
            Log.e(str, str2, th);
        }
    }
}
