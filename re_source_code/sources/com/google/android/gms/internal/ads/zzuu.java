package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.root.execution.Command;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(14)
public final class zzuu extends Thread {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f16821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f16823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f16824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzup f16825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f16826k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final int q;
    private final int r;
    private final String s;
    private final boolean t;
    private final boolean u;
    private final boolean v;

    public zzuu() {
        this(new zzup());
    }

    @VisibleForTesting
    private final r40 b(View view, zzuo zzuoVar) {
        boolean z;
        if (view == null) {
            return new r40(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new r40(this, 0, 0);
            }
            zzuoVar.d(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
            return new r40(this, 1, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzbgz)) {
            WebView webView = (WebView) view;
            if (PlatformVersion.f()) {
                zzuoVar.n();
                webView.post(new p40(this, zzuoVar, webView, globalVisibleRect));
                z = true;
            } else {
                z = false;
            }
            return z ? new r40(this, 0, 1) : new r40(this, 0, 0);
        }
        if (!(view instanceof ViewGroup)) {
            return new r40(this, 0, 0);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            r40 r40VarB = b(viewGroup.getChildAt(i4), zzuoVar);
            i2 += r40VarB.a;
            i3 += r40VarB.f13260b;
        }
        return new r40(this, i2, i3);
    }

    @VisibleForTesting
    private static boolean f() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            Context contextB = zzk.zzlj().b();
            if (contextB == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) contextB.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) contextB.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return false;
                    }
                    PowerManager powerManager = (PowerManager) contextB.getSystemService("power");
                    return powerManager == null ? false : powerManager.isScreenOn();
                }
            }
            return false;
        } catch (Throwable th) {
            zzk.zzlk().e(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final void h() {
        synchronized (this.f16824i) {
            this.f16822g = true;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(true);
            zzbad.e(sb.toString());
        }
    }

    public final void a() {
        synchronized (this.f16824i) {
            this.f16822g = false;
            this.f16824i.notifyAll();
            zzbad.e("ContentFetchThread: wakeup");
        }
    }

    @VisibleForTesting
    final void c(zzuo zzuoVar, WebView webView, String str, boolean z) {
        zzuoVar.m();
        try {
            if (!TextUtils.isEmpty(str)) {
                String strOptString = new JSONObject(str).optString(Command.CommandHandler.TEXT);
                if (this.t || TextUtils.isEmpty(webView.getTitle())) {
                    zzuoVar.c(strOptString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(strOptString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(strOptString);
                    zzuoVar.c(sb.toString(), z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzuoVar.h()) {
                this.f16825j.b(zzuoVar);
            }
        } catch (JSONException unused) {
            zzbad.e("Json string may be malformed.");
        } catch (Throwable th) {
            zzbad.b("Failed to get webview content.", th);
            zzk.zzlk().e(th, "ContentFetchTask.processWebViewContent");
        }
    }

    @VisibleForTesting
    final void d(View view) {
        try {
            zzuo zzuoVar = new zzuo(this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.u);
            Context contextB = zzk.zzlj().b();
            if (contextB != null && !TextUtils.isEmpty(this.s)) {
                String str = (String) view.getTag(contextB.getResources().getIdentifier((String) zzyt.e().c(zzacu.q0), DeepLinkIntentReceiver.DeepLinksKeys.ID, contextB.getPackageName()));
                if (str != null && str.equals(this.s)) {
                    return;
                }
            }
            r40 r40VarB = b(view, zzuoVar);
            zzuoVar.p();
            if (r40VarB.a == 0 && r40VarB.f13260b == 0) {
                return;
            }
            if (r40VarB.f13260b == 0 && zzuoVar.q() == 0) {
                return;
            }
            if (r40VarB.f13260b == 0 && this.f16825j.a(zzuoVar)) {
                return;
            }
            this.f16825j.c(zzuoVar);
        } catch (Exception e2) {
            zzbad.c("Exception in fetchContentOnUIThread", e2);
            zzk.zzlk().e(e2, "ContentFetchTask.fetchContent");
        }
    }

    public final void e() {
        synchronized (this.f16824i) {
            if (this.f16821f) {
                zzbad.e("Content hash thread already started, quiting...");
            } else {
                this.f16821f = true;
                start();
            }
        }
    }

    public final zzuo g() {
        return this.f16825j.d(this.v);
    }

    public final boolean i() {
        return this.f16822g;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0091 */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r4 = this;
        L0:
            boolean r0 = f()     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
            if (r0 == 0) goto L55
            com.google.android.gms.internal.ads.zzuq r0 = com.google.android.gms.ads.internal.zzk.zzlj()     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
            android.app.Activity r0 = r0.a()     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
            if (r0 != 0) goto L19
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.internal.ads.zzbad.e(r0)     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
            r4.h()     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
            goto L5d
        L19:
            r1 = 0
            android.view.Window r2 = r0.getWindow()     // Catch: java.lang.Exception -> L3b
            if (r2 == 0) goto L4a
            android.view.Window r2 = r0.getWindow()     // Catch: java.lang.Exception -> L3b
            android.view.View r2 = r2.getDecorView()     // Catch: java.lang.Exception -> L3b
            if (r2 == 0) goto L4a
            android.view.Window r0 = r0.getWindow()     // Catch: java.lang.Exception -> L3b
            android.view.View r0 = r0.getDecorView()     // Catch: java.lang.Exception -> L3b
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r2)     // Catch: java.lang.Exception -> L3b
            r1 = r0
            goto L4a
        L3b:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzawm r2 = com.google.android.gms.ads.internal.zzk.zzlk()     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.e(r0, r3)     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
            java.lang.String r0 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.internal.ads.zzbad.e(r0)     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
        L4a:
            if (r1 == 0) goto L5d
            com.google.android.gms.internal.ads.o40 r0 = new com.google.android.gms.internal.ads.o40     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
            r0.<init>(r4, r1)     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
            r1.post(r0)     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
            goto L5d
        L55:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.internal.ads.zzbad.e(r0)     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
            r4.h()     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
        L5d:
            int r0 = r4.f16826k     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
            java.lang.Thread.sleep(r0)     // Catch: java.lang.Exception -> L66 java.lang.InterruptedException -> L76
            goto L7c
        L66:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzbad.c(r1, r0)
            com.google.android.gms.internal.ads.zzawm r1 = com.google.android.gms.ads.internal.zzk.zzlk()
            java.lang.String r2 = "ContentFetchTask.run"
            r1.e(r0, r2)
            goto L7c
        L76:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzbad.c(r1, r0)
        L7c:
            java.lang.Object r0 = r4.f16824i
            monitor-enter(r0)
        L7f:
            boolean r1 = r4.f16822g     // Catch: java.lang.Throwable -> L91
            if (r1 == 0) goto L8e
            java.lang.String r1 = "ContentFetchTask: waiting"
            com.google.android.gms.internal.ads.zzbad.e(r1)     // Catch: java.lang.InterruptedException -> L7f java.lang.Throwable -> L91
            java.lang.Object r1 = r4.f16824i     // Catch: java.lang.InterruptedException -> L7f java.lang.Throwable -> L91
            r1.wait()     // Catch: java.lang.InterruptedException -> L7f java.lang.Throwable -> L91
            goto L7f
        L8e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L91
            goto L0
        L91:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L91
            goto L95
        L94:
            throw r1
        L95:
            goto L94
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuu.run():void");
    }

    @VisibleForTesting
    private zzuu(zzup zzupVar) {
        this.f16821f = false;
        this.f16822g = false;
        this.f16823h = false;
        this.f16825j = zzupVar;
        this.f16824i = new Object();
        this.l = ((Integer) zzyt.e().c(zzacu.i0)).intValue();
        this.m = ((Integer) zzyt.e().c(zzacu.j0)).intValue();
        this.n = ((Integer) zzyt.e().c(zzacu.k0)).intValue();
        this.o = ((Integer) zzyt.e().c(zzacu.l0)).intValue();
        this.p = ((Integer) zzyt.e().c(zzacu.n0)).intValue();
        this.q = ((Integer) zzyt.e().c(zzacu.o0)).intValue();
        this.r = ((Integer) zzyt.e().c(zzacu.p0)).intValue();
        this.f16826k = ((Integer) zzyt.e().c(zzacu.m0)).intValue();
        this.s = (String) zzyt.e().c(zzacu.r0);
        this.t = ((Boolean) zzyt.e().c(zzacu.s0)).booleanValue();
        this.u = ((Boolean) zzyt.e().c(zzacu.w0)).booleanValue();
        this.v = ((Boolean) zzyt.e().c(zzacu.x0)).booleanValue();
        setName("ContentFetchTask");
    }
}
