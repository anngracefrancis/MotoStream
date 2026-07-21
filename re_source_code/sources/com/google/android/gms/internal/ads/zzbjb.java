package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.ValueCallback;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public class zzbjb extends rb implements zzbje {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbiz f14486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14488h;

    public zzbjb(Context context, zzbiz zzbizVar) {
        super(context);
        zzk.zzlk().o();
        this.f14486f = zzbizVar;
        super.setWebViewClient(zzbizVar);
    }

    private final synchronized void A0() {
        if (!this.f14488h) {
            this.f14488h = true;
            zzk.zzlk().p();
        }
    }

    @Override // com.google.android.gms.internal.ads.rb, android.webkit.WebView
    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    @Override // android.webkit.WebView
    public synchronized void destroy() {
        if (this.f14487g) {
            return;
        }
        this.f14487g = true;
        this.f14486f.q(this);
        z0(false);
        zzawz.m("Initiating WebView self destruct sequence in 3...");
        zzawz.m("Loading blank page in WebView, 2...");
        try {
            super.loadUrl("about:blank");
        } catch (UnsatisfiedLinkError e2) {
            zzk.zzlk().e(e2, "AdWebViewImpl.loadUrlUnsafe");
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!l()) {
            super.evaluateJavascript(str, valueCallback);
            return;
        }
        zzbad.i("#004 The webview is destroyed. Ignoring action.");
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
        }
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!l()) {
                    z0(true);
                }
                A0();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.rb, com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzakg
    public /* bridge */ /* synthetic */ void k(String str) {
        super.k(str);
    }

    public final synchronized boolean l() {
        return this.f14487g;
    }

    @Override // android.webkit.WebView
    public synchronized void loadData(String str, String str2, String str3) {
        if (l()) {
            zzbad.i("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadData(str, str2, str3);
        }
    }

    @Override // android.webkit.WebView
    public synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (l()) {
            zzbad.i("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // com.google.android.gms.internal.ads.rb, android.webkit.WebView
    public synchronized void loadUrl(String str) {
        if (l()) {
            zzbad.i("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadUrl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public synchronized void n0() {
        zzawz.m("Destroying WebView!");
        A0();
        zzbbm.a.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.tb

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbjb f13351f;

            {
                this.f13351f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13351f.y0();
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (l()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgz
    public void onPause() {
        if (l()) {
            return;
        }
        super.onPause();
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgz
    public void onResume() {
        if (l()) {
            return;
        }
        super.onResume();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !l() && super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        if (l()) {
            return;
        }
        super.stopLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzbje
    public final synchronized void u(zzbja zzbjaVar) {
        zzawz.m("Blank page loaded, 1...");
        n0();
    }

    final /* synthetic */ void y0() {
        super.destroy();
    }

    protected void z0(boolean z) {
    }
}
