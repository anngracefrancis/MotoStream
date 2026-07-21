package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebView;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@zzard
final class ub {

    @VisibleForTesting
    private static Boolean a;

    private ub() {
    }

    @TargetApi(19)
    static void a(WebView webView, String str) {
        if (PlatformVersion.f() && b(webView)) {
            webView.evaluateJavascript(str, null);
        } else {
            String strValueOf = String.valueOf(str);
            webView.loadUrl(strValueOf.length() != 0 ? "javascript:".concat(strValueOf) : new String("javascript:"));
        }
    }

    @TargetApi(19)
    private static boolean b(WebView webView) {
        boolean zBooleanValue;
        synchronized (ub.class) {
            if (a == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    a = Boolean.TRUE;
                } catch (IllegalStateException unused) {
                    a = Boolean.FALSE;
                }
                zBooleanValue = a.booleanValue();
            } else {
                zBooleanValue = a.booleanValue();
            }
            throw th;
        }
        return zBooleanValue;
    }
}
