package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public class zzbiz extends WebViewClient {
    private static final String[] a = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f14481b = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzbje f14482c;

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        if (str == null) {
            return;
        }
        zzawz.m(str.length() != 0 ? "Loading resource: ".concat(str) : new String("Loading resource: "));
        r(new zzbja(str));
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        if (str == null) {
            return;
        }
        zzbja zzbjaVar = new zzbja(str);
        zzbje zzbjeVar = this.f14482c;
        if (zzbjeVar != null) {
            zzbjeVar.u(zzbjaVar);
        } else {
            p(zzbjaVar);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        if (i2 >= 0 || (-i2) - 1 >= a.length) {
            String.valueOf(i2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError == null) {
            return;
        }
        int primaryError = sslError.getPrimaryError();
        if (primaryError < 0 || primaryError >= f14481b.length) {
            String.valueOf(primaryError);
        }
        sslError.getUrl();
    }

    public void p(zzbja zzbjaVar) {
    }

    final void q(zzbje zzbjeVar) {
        this.f14482c = zzbjeVar;
    }

    public void r(zzbja zzbjaVar) {
    }

    public boolean s(zzbja zzbjaVar) {
        return false;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str == null) {
            return null;
        }
        return t(new zzbja(str));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str == null) {
            return false;
        }
        return s(new zzbja(str));
    }

    public WebResourceResponse t(zzbja zzbjaVar) {
        return null;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(24)
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return t(new zzbja(webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(24)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return false;
        }
        return s(new zzbja(webResourceRequest));
    }
}
