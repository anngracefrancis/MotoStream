package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
@zzard
class rb extends WebView {
    public rb(Context context) {
        super(context);
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzk.zzli().k(getContext(), settings);
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        try {
            getSettings().setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            zzbad.c("Unable to enable Javascript.", e2);
        }
        setLayerType(1, null);
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.addJavascriptInterface(obj, str);
        } else {
            zzawz.m("Ignore addJavascriptInterface due to low Android version.");
        }
    }

    public void k(String str) {
        ub.a(this, str);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e2) {
            zzk.zzlk().e(e2, "CoreWebView.loadUrl");
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }
}
