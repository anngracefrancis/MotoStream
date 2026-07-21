package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(14)
public class zzaxo {
    private zzaxo() {
    }

    public static boolean l(zzbgz zzbgzVar) {
        if (zzbgzVar == null) {
            return false;
        }
        zzbgzVar.onPause();
        return true;
    }

    public static boolean p(zzbgz zzbgzVar) {
        if (zzbgzVar == null) {
            return false;
        }
        zzbgzVar.onResume();
        return true;
    }

    public static zzaxo q(int i2) {
        if (i2 >= 28) {
            return new zzaxy();
        }
        if (i2 >= 26) {
            return new zzaxx();
        }
        if (i2 >= 24) {
            return new zzaxw();
        }
        if (i2 >= 21) {
            return new zzaxv();
        }
        if (i2 >= 19) {
            return new zzaxu();
        }
        if (i2 >= 18) {
            return new zzaxs();
        }
        if (i2 >= 17) {
            return new zzaxr();
        }
        return i2 >= 16 ? new zzaxt() : new zzaxo();
    }

    public static boolean u() {
        int iMyUid = Process.myUid();
        return iMyUid == 0 || iMyUid == 1000;
    }

    public String a(Context context) {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public boolean b(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public void c(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public int d(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "wifi_on", 0);
    }

    public Drawable e(Context context, Bitmap bitmap, boolean z, float f2) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public WebResourceResponse f(String str, String str2, int i2, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, inputStream);
    }

    public zzbha g(zzbgz zzbgzVar, zzwj zzwjVar, boolean z) {
        return new zzbhz(zzbgzVar, zzwjVar, z);
    }

    public zzwx h(Context context, TelephonyManager telephonyManager) {
        return zzwx.ENUM_UNKNOWN;
    }

    public void i(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean j(Activity activity, Configuration configuration) {
        return false;
    }

    public boolean k(final Context context, final WebSettings webSettings) {
        return ((Boolean) zzazl.a(context, new Callable(context, webSettings) { // from class: com.google.android.gms.internal.ads.j5

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final Context f12811f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final WebSettings f12812g;

            {
                this.f12811f = context;
                this.f12812g = webSettings;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Context context2 = this.f12811f;
                WebSettings webSettings2 = this.f12812g;
                if (context2.getCacheDir() != null) {
                    webSettings2.setAppCachePath(context2.getCacheDir().getAbsolutePath());
                    webSettings2.setAppCacheMaxSize(0L);
                    webSettings2.setAppCacheEnabled(true);
                }
                webSettings2.setDatabasePath(context2.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                webSettings2.setDatabaseEnabled(true);
                webSettings2.setDomStorageEnabled(true);
                webSettings2.setDisplayZoomControls(false);
                webSettings2.setBuiltInZoomControls(true);
                webSettings2.setSupportZoom(true);
                webSettings2.setAllowContentAccess(false);
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    public void m(Context context) {
    }

    public CookieManager n(Context context) {
        if (u()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzbad.c("Failed to obtain CookieManager.", th);
            zzk.zzlk().e(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public int o(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "airplane_mode_on", 0);
    }

    public void r(Activity activity) {
    }

    public int s() {
        return 5;
    }

    public ViewGroup.LayoutParams t() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public int v() {
        return 1;
    }
}
