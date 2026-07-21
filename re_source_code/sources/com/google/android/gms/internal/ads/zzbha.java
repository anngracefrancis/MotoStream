package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cm.aptoide.pt.dataprovider.BuildConfig;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.HttpUrl;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@zzard
public class zzbha extends WebViewClient implements zzbii {
    private static final String[] a = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f14448b = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private View.OnAttachStateChangeListener A;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected zzbgz f14449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzwj f14450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap<String, List<zzaho<? super zzbgz>>> f14451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f14452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzxr f14453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.google.android.gms.ads.internal.overlay.zzo f14454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzbij f14455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzbik f14456j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzagv f14457k;
    private zzagx l;
    private zzbil m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private com.google.android.gms.ads.internal.overlay.zzu r;
    private final zzaqa s;
    private com.google.android.gms.ads.internal.zzb t;
    private zzapr u;
    protected zzavb v;
    private boolean w;
    private boolean x;
    private int y;
    private boolean z;

    public zzbha(zzbgz zzbgzVar, zzwj zzwjVar, boolean z) {
        this(zzbgzVar, zzwjVar, z, new zzaqa(zzbgzVar, zzbgzVar.d0(), new zzacf(zzbgzVar.getContext())), null);
    }

    private final void B() {
        if (this.A == null) {
            return;
        }
        this.f14449c.getView().removeOnAttachStateChangeListener(this.A);
    }

    private final void C() {
        zzbij zzbijVar = this.f14455i;
        if (zzbijVar != null && ((this.w && this.y <= 0) || this.x)) {
            zzbijVar.zzae(!this.x);
            this.f14455i = null;
        }
        this.f14449c.I();
    }

    private static WebResourceResponse D() {
        if (((Boolean) zzyt.e().c(zzacu.T0)).booleanValue()) {
            return new WebResourceResponse(HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse J(String str, Map<String, String> map) throws IOException {
        URL url = new URL(str);
        int i2 = 0;
        while (true) {
            i2++;
            if (i2 > 20) {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Too many redirects (20)");
                throw new IOException(sb.toString());
            }
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            uRLConnectionOpenConnection.setConnectTimeout(10000);
            uRLConnectionOpenConnection.setReadTimeout(10000);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                uRLConnectionOpenConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                throw new IOException("Invalid protocol.");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            zzk.zzlg().m(this.f14449c.getContext(), this.f14449c.b().f14326f, false, httpURLConnection);
            zzazx zzazxVar = new zzazx();
            zzazxVar.i(httpURLConnection, null);
            int responseCode = httpURLConnection.getResponseCode();
            zzazxVar.h(httpURLConnection, responseCode);
            if (responseCode < 300 || responseCode >= 400) {
                zzk.zzlg();
                return zzaxi.M(httpURLConnection);
            }
            String headerField = httpURLConnection.getHeaderField("Location");
            if (headerField == null) {
                throw new IOException("Missing Location header in redirect");
            }
            URL url2 = new URL(url, headerField);
            String protocol = url2.getProtocol();
            if (protocol == null) {
                zzbad.i("Protocol is null");
                return D();
            }
            if (!protocol.equals("http") && !protocol.equals(BuildConfig.APTOIDE_WEB_SERVICES_SCHEME)) {
                zzbad.i(protocol.length() != 0 ? "Unsupported scheme: ".concat(protocol) : new String("Unsupported scheme: "));
                return D();
            }
            zzbad.e(headerField.length() != 0 ? "Redirecting to ".concat(headerField) : new String("Redirecting to "));
            httpURLConnection.disconnect();
            url = url2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0037  */
    private final void K(Context context, String str, String str2, String str3) {
        String host;
        if (((Boolean) zzyt.e().c(zzacu.V1)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            if (TextUtils.isEmpty(str3)) {
                host = HttpUrl.FRAGMENT_ENCODE_SET;
            } else {
                Uri uri = Uri.parse(str3);
                if (uri.getHost() != null) {
                    host = uri.getHost();
                } else {
                    host = HttpUrl.FRAGMENT_ENCODE_SET;
                }
            }
            bundle.putString("host", host);
            zzk.zzlg().l(context, this.f14449c.b().f14326f, "gmob-apps", bundle, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(View view, zzavb zzavbVar, int i2) {
        if (!zzavbVar.g() || i2 <= 0) {
            return;
        }
        zzavbVar.f(view);
        if (zzavbVar.g()) {
            zzaxi.a.postDelayed(new ua(this, view, zzavbVar, i2), 100L);
        }
    }

    private final void r(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzc zzcVar;
        zzapr zzaprVar = this.u;
        boolean zK = zzaprVar != null ? zzaprVar.k() : false;
        zzk.zzlf();
        com.google.android.gms.ads.internal.overlay.zzm.zza(this.f14449c.getContext(), adOverlayInfoParcel, !zK);
        zzavb zzavbVar = this.v;
        if (zzavbVar != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && (zzcVar = adOverlayInfoParcel.zzdkl) != null) {
                str = zzcVar.url;
            }
            zzavbVar.b(str);
        }
    }

    public final ViewTreeObserver.OnScrollChangedListener A() {
        synchronized (this.f14452f) {
        }
        return null;
    }

    public final void E(boolean z) {
        this.n = z;
    }

    public final void F(boolean z) {
        this.z = z;
    }

    public final void G(String str, zzaho<? super zzbgz> zzahoVar) {
        synchronized (this.f14452f) {
            List<zzaho<? super zzbgz>> list = this.f14451e.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzahoVar);
        }
    }

    public final void H(boolean z, int i2) {
        zzxr zzxrVar = (!this.f14449c.m() || this.f14449c.o().e()) ? this.f14453g : null;
        com.google.android.gms.ads.internal.overlay.zzo zzoVar = this.f14454h;
        com.google.android.gms.ads.internal.overlay.zzu zzuVar = this.r;
        zzbgz zzbgzVar = this.f14449c;
        r(new AdOverlayInfoParcel(zzxrVar, zzoVar, zzuVar, zzbgzVar, z, i2, zzbgzVar.b()));
    }

    protected final WebResourceResponse I(String str, Map<String, String> map) {
        zzvs zzvsVarD;
        try {
            String strC = zzavx.c(str, this.f14449c.getContext(), this.z);
            if (!strC.equals(str)) {
                return J(strC, map);
            }
            zzvv zzvvVarY = zzvv.y(str);
            if (zzvvVarY != null && (zzvsVarD = zzk.zzlm().d(zzvvVarY)) != null && zzvsVarD.y()) {
                return new WebResourceResponse(HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, zzvsVarD.z());
            }
            if (!zzazx.a()) {
                return null;
            }
            if (((Boolean) zzyt.e().c(zzacu.J1)).booleanValue()) {
                return J(str, map);
            }
            return null;
        } catch (Exception | NoClassDefFoundError e2) {
            zzk.zzlk().e(e2, "AdWebViewClient.interceptRequest");
            return D();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void a(Uri uri) {
        String path = uri.getPath();
        List<zzaho<? super zzbgz>> list = this.f14451e.get(path);
        if (list == null) {
            String strValueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
            sb.append("No GMSG handler found for GMSG: ");
            sb.append(strValueOf);
            zzawz.m(sb.toString());
            return;
        }
        zzk.zzlg();
        Map<String, String> mapX = zzaxi.X(uri);
        if (zzbad.a(2)) {
            String strValueOf2 = String.valueOf(path);
            zzawz.m(strValueOf2.length() != 0 ? "Received GMSG: ".concat(strValueOf2) : new String("Received GMSG: "));
            for (String str : mapX.keySet()) {
                String str2 = mapX.get(str);
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length());
                sb2.append("  ");
                sb2.append(str);
                sb2.append(": ");
                sb2.append(str2);
                zzawz.m(sb2.toString());
            }
        }
        Iterator<zzaho<? super zzbgz>> it = list.iterator();
        while (it.hasNext()) {
            it.next().a(this.f14449c, mapX);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void b(boolean z) {
        synchronized (this.f14452f) {
            this.p = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void c(zzxr zzxrVar, zzagv zzagvVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar, zzagx zzagxVar, com.google.android.gms.ads.internal.overlay.zzu zzuVar, boolean z, zzahp zzahpVar, com.google.android.gms.ads.internal.zzb zzbVar, zzaqc zzaqcVar, zzavb zzavbVar) {
        if (zzbVar == null) {
            zzbVar = new com.google.android.gms.ads.internal.zzb(this.f14449c.getContext(), zzavbVar, null);
        }
        this.u = new zzapr(this.f14449c, zzaqcVar);
        this.v = zzavbVar;
        if (((Boolean) zzyt.e().c(zzacu.c1)).booleanValue()) {
            v("/adMetadata", new zzagu(zzagvVar));
        }
        v("/appEvent", new zzagw(zzagxVar));
        v("/backButton", zzagz.f13896j);
        v("/refresh", zzagz.f13897k);
        v("/canOpenURLs", zzagz.a);
        v("/canOpenIntents", zzagz.f13888b);
        v("/click", zzagz.f13889c);
        v("/close", zzagz.f13890d);
        v("/customClose", zzagz.f13891e);
        v("/instrument", zzagz.n);
        v("/delayPageLoaded", zzagz.p);
        v("/delayPageClosed", zzagz.q);
        v("/getLocationInfo", zzagz.r);
        v("/httpTrack", zzagz.f13892f);
        v("/log", zzagz.f13893g);
        v("/mraid", new zzahr(zzbVar, this.u, zzaqcVar));
        v("/mraidLoaded", this.s);
        v("/open", new zzahs(zzbVar, this.u));
        v("/precache", new zzbgc());
        v("/touch", zzagz.f13895i);
        v("/video", zzagz.l);
        v("/videoMeta", zzagz.m);
        if (zzk.zzme().D(this.f14449c.getContext())) {
            v("/logScionEvent", new zzahq(this.f14449c.getContext()));
        }
        this.f14453g = zzxrVar;
        this.f14454h = zzoVar;
        this.f14457k = zzagvVar;
        this.l = zzagxVar;
        this.r = zzuVar;
        this.t = zzbVar;
        this.n = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void d() {
        synchronized (this.f14452f) {
            this.n = false;
            this.o = true;
            zzbbm.a.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.ta

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzbha f13350f;

                {
                    this.f13350f = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbha zzbhaVar = this.f13350f;
                    zzbhaVar.f14449c.C();
                    com.google.android.gms.ads.internal.overlay.zzd zzdVarK0 = zzbhaVar.f14449c.k0();
                    if (zzdVarK0 != null) {
                        zzdVarK0.zzth();
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void e() {
        zzavb zzavbVar = this.v;
        if (zzavbVar != null) {
            WebView webView = this.f14449c.getWebView();
            if (androidx.core.view.u.N(webView)) {
                q(webView, zzavbVar, 10);
                return;
            }
            B();
            this.A = new va(this, zzavbVar);
            this.f14449c.getView().addOnAttachStateChangeListener(this.A);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void f() {
        synchronized (this.f14452f) {
            this.q = true;
        }
        this.y++;
        C();
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void g(int i2, int i3) {
        zzapr zzaprVar = this.u;
        if (zzaprVar != null) {
            zzaprVar.j(i2, i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void h() {
        this.y--;
        C();
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void i(zzbij zzbijVar) {
        this.f14455i = zzbijVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void j(zzbik zzbikVar) {
        this.f14456j = zzbikVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void k() {
        this.x = true;
        C();
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void l(int i2, int i3, boolean z) {
        this.s.h(i2, i3);
        zzapr zzaprVar = this.u;
        if (zzaprVar != null) {
            zzaprVar.h(i2, i3, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final boolean m() {
        boolean z;
        synchronized (this.f14452f) {
            z = this.o;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final zzavb n() {
        return this.v;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final com.google.android.gms.ads.internal.zzb o() {
        return this.t;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        String strValueOf = String.valueOf(str);
        zzawz.m(strValueOf.length() != 0 ? "Loading resource: ".concat(strValueOf) : new String("Loading resource: "));
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            a(uri);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.f14452f) {
            if (this.f14449c.l()) {
                zzawz.m("Blank page loaded, 1...");
                this.f14449c.n0();
                return;
            }
            this.w = true;
            zzbik zzbikVar = this.f14456j;
            if (zzbikVar != null) {
                zzbikVar.a();
                this.f14456j = null;
            }
            C();
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000d  */
    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        String strValueOf;
        if (i2 < 0) {
            int i3 = (-i2) - 1;
            String[] strArr = a;
            if (i3 < strArr.length) {
                strValueOf = strArr[i3];
            } else {
                strValueOf = String.valueOf(i2);
            }
        } else {
            strValueOf = String.valueOf(i2);
        }
        K(this.f14449c.getContext(), "http_err", strValueOf, str2);
        super.onReceivedError(webView, i2, str, str2);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0010  */
    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String strValueOf;
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            if (primaryError >= 0) {
                String[] strArr = f14448b;
                if (primaryError < strArr.length) {
                    strValueOf = strArr[primaryError];
                } else {
                    strValueOf = String.valueOf(primaryError);
                }
            } else {
                strValueOf = String.valueOf(primaryError);
            }
            Context context = this.f14449c.getContext();
            zzk.zzli();
            K(context, "ssl_err", strValueOf, sslError.getUrl());
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.f14449c.w(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public final void p() {
        zzavb zzavbVar = this.v;
        if (zzavbVar != null) {
            zzavbVar.c();
            this.v = null;
        }
        B();
        synchronized (this.f14452f) {
            this.f14451e.clear();
            this.f14453g = null;
            this.f14454h = null;
            this.f14455i = null;
            this.f14456j = null;
            this.f14457k = null;
            this.l = null;
            this.n = false;
            this.o = false;
            this.p = false;
            this.q = false;
            this.r = null;
            this.m = null;
            zzapr zzaprVar = this.u;
            if (zzaprVar != null) {
                zzaprVar.l(true);
                this.u = null;
            }
        }
    }

    public final void s(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        boolean zM = this.f14449c.m();
        r(new AdOverlayInfoParcel(zzcVar, (!zM || this.f14449c.o().e()) ? this.f14453g : null, zM ? null : this.f14454h, this.r, this.f14449c.b()));
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return I(str, Collections.emptyMap());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
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
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) throws zzdi {
        String strValueOf = String.valueOf(str);
        zzawz.m(strValueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(strValueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uriA = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uriA.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriA.getHost())) {
            a(uriA);
        } else {
            if (this.n && webView == this.f14449c.getWebView()) {
                String scheme = uriA.getScheme();
                if ("http".equalsIgnoreCase(scheme) || BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equalsIgnoreCase(scheme)) {
                    zzxr zzxrVar = this.f14453g;
                    if (zzxrVar != null) {
                        zzxrVar.onAdClicked();
                        zzavb zzavbVar = this.v;
                        if (zzavbVar != null) {
                            zzavbVar.b(str);
                        }
                        this.f14453g = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (this.f14449c.getWebView().willNotDraw()) {
                String strValueOf2 = String.valueOf(str);
                zzbad.i(strValueOf2.length() != 0 ? "AdWebView unable to handle URL: ".concat(strValueOf2) : new String("AdWebView unable to handle URL: "));
            } else {
                try {
                    zzdh zzdhVarD = this.f14449c.d();
                    if (zzdhVarD != null && zzdhVarD.e(uriA)) {
                        uriA = zzdhVarD.a(uriA, this.f14449c.getContext(), this.f14449c.getView(), this.f14449c.a());
                    }
                } catch (zzdi unused) {
                    String strValueOf3 = String.valueOf(str);
                    zzbad.i(strValueOf3.length() != 0 ? "Unable to append parameter to URL: ".concat(strValueOf3) : new String("Unable to append parameter to URL: "));
                }
                com.google.android.gms.ads.internal.zzb zzbVar = this.t;
                if (zzbVar == null || zzbVar.zzkx()) {
                    s(new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uriA.toString(), null, null, null, null, null));
                } else {
                    this.t.zzbk(str);
                }
            }
        }
        return true;
    }

    public final void u(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        synchronized (this.f14452f) {
            List<zzaho<? super zzbgz>> list = this.f14451e.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (zzaho<? super zzbgz> zzahoVar : list) {
                if (predicate.a(zzahoVar)) {
                    arrayList.add(zzahoVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void v(String str, zzaho<? super zzbgz> zzahoVar) {
        synchronized (this.f14452f) {
            List<zzaho<? super zzbgz>> copyOnWriteArrayList = this.f14451e.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.f14451e.put(str, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(zzahoVar);
        }
    }

    public final void w(boolean z, int i2, String str) {
        boolean zM = this.f14449c.m();
        zzxr zzxrVar = (!zM || this.f14449c.o().e()) ? this.f14453g : null;
        wa waVar = zM ? null : new wa(this.f14449c, this.f14454h);
        zzagv zzagvVar = this.f14457k;
        zzagx zzagxVar = this.l;
        com.google.android.gms.ads.internal.overlay.zzu zzuVar = this.r;
        zzbgz zzbgzVar = this.f14449c;
        r(new AdOverlayInfoParcel(zzxrVar, waVar, zzagvVar, zzagxVar, zzuVar, zzbgzVar, z, i2, str, zzbgzVar.b()));
    }

    public final void x(boolean z, int i2, String str, String str2) {
        boolean zM = this.f14449c.m();
        zzxr zzxrVar = (!zM || this.f14449c.o().e()) ? this.f14453g : null;
        wa waVar = zM ? null : new wa(this.f14449c, this.f14454h);
        zzagv zzagvVar = this.f14457k;
        zzagx zzagxVar = this.l;
        com.google.android.gms.ads.internal.overlay.zzu zzuVar = this.r;
        zzbgz zzbgzVar = this.f14449c;
        r(new AdOverlayInfoParcel(zzxrVar, waVar, zzagvVar, zzagxVar, zzuVar, zzbgzVar, z, i2, str, str2, zzbgzVar.b()));
    }

    public final boolean y() {
        boolean z;
        synchronized (this.f14452f) {
            z = this.p;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener z() {
        synchronized (this.f14452f) {
        }
        return null;
    }

    @VisibleForTesting
    private zzbha(zzbgz zzbgzVar, zzwj zzwjVar, boolean z, zzaqa zzaqaVar, zzapr zzaprVar) {
        this.f14451e = new HashMap<>();
        this.f14452f = new Object();
        this.n = false;
        this.f14450d = zzwjVar;
        this.f14449c = zzbgzVar;
        this.o = z;
        this.s = zzaqaVar;
        this.u = null;
    }
}
