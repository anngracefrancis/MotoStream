package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import cm.aptoide.pt.dataprovider.BuildConfig;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@zzard
public final class zzbio extends zzbiz implements zzbii {
    private View.OnAttachStateChangeListener A;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected zzbgz f14473d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzxr f14476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.google.android.gms.ads.internal.overlay.zzo f14477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzbij f14478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzbik f14479j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzagv f14480k;
    private zzagx l;
    private zzbil m;
    private volatile boolean o;
    private boolean p;
    private boolean q;
    private com.google.android.gms.ads.internal.overlay.zzu r;
    private zzaqa s;
    private com.google.android.gms.ads.internal.zzb t;
    private zzapr u;
    private zzavb v;
    private boolean w;
    private boolean x;
    private int y;
    private boolean z;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f14475f = new Object();
    private boolean n = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzaju<zzbgz> f14474e = new zzaju<>();

    private final void H() {
        if (this.A == null) {
            return;
        }
        this.f14473d.getView().removeOnAttachStateChangeListener(this.A);
    }

    private final void I() {
        zzbij zzbijVar = this.f14478i;
        if (zzbijVar != null && ((this.w && this.y <= 0) || this.x)) {
            zzbijVar.zzae(!this.x);
            this.f14478i = null;
        }
        this.f14473d.I();
    }

    private static WebResourceResponse J() {
        if (((Boolean) zzyt.e().c(zzacu.T0)).booleanValue()) {
            return new WebResourceResponse(HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse O(zzbja zzbjaVar) throws IOException {
        URL url = new URL(zzbjaVar.a);
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
            for (Map.Entry<String, String> entry : zzbjaVar.f14485d.entrySet()) {
                uRLConnectionOpenConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                throw new IOException("Invalid protocol.");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            zzk.zzlg().m(this.f14473d.getContext(), this.f14473d.b().f14326f, false, httpURLConnection);
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
                return J();
            }
            if (!protocol.equals("http") && !protocol.equals(BuildConfig.APTOIDE_WEB_SERVICES_SCHEME)) {
                zzbad.i(protocol.length() != 0 ? "Unsupported scheme: ".concat(protocol) : new String("Unsupported scheme: "));
                return J();
            }
            zzbad.e(headerField.length() != 0 ? "Redirecting to ".concat(headerField) : new String("Redirecting to "));
            httpURLConnection.disconnect();
            url = url2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(View view, zzavb zzavbVar, int i2) {
        if (!zzavbVar.g() || i2 <= 0) {
            return;
        }
        zzavbVar.f(view);
        if (zzavbVar.g()) {
            zzaxi.a.postDelayed(new kb(this, view, zzavbVar, i2), 100L);
        }
    }

    private final void w(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzc zzcVar;
        zzapr zzaprVar = this.u;
        boolean zK = zzaprVar != null ? zzaprVar.k() : false;
        zzk.zzlf();
        com.google.android.gms.ads.internal.overlay.zzm.zza(this.f14473d.getContext(), adOverlayInfoParcel, !zK);
        zzavb zzavbVar = this.v;
        if (zzavbVar != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && (zzcVar = adOverlayInfoParcel.zzdkl) != null) {
                str = zzcVar.url;
            }
            zzavbVar.b(str);
        }
    }

    public final void A(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        this.f14474e.t(str, predicate);
    }

    public final void B(String str, zzaho<? super zzbgz> zzahoVar) {
        this.f14474e.f(str, zzahoVar);
    }

    public final void C(boolean z, int i2, String str) {
        boolean zM = this.f14473d.m();
        zzxr zzxrVar = (!zM || this.f14473d.o().e()) ? this.f14476g : null;
        mb mbVar = zM ? null : new mb(this.f14473d, this.f14477h);
        zzagv zzagvVar = this.f14480k;
        zzagx zzagxVar = this.l;
        com.google.android.gms.ads.internal.overlay.zzu zzuVar = this.r;
        zzbgz zzbgzVar = this.f14473d;
        w(new AdOverlayInfoParcel(zzxrVar, mbVar, zzagvVar, zzagxVar, zzuVar, zzbgzVar, z, i2, str, zzbgzVar.b()));
    }

    public final void D(boolean z, int i2, String str, String str2) {
        boolean zM = this.f14473d.m();
        zzxr zzxrVar = (!zM || this.f14473d.o().e()) ? this.f14476g : null;
        mb mbVar = zM ? null : new mb(this.f14473d, this.f14477h);
        zzagv zzagvVar = this.f14480k;
        zzagx zzagxVar = this.l;
        com.google.android.gms.ads.internal.overlay.zzu zzuVar = this.r;
        zzbgz zzbgzVar = this.f14473d;
        w(new AdOverlayInfoParcel(zzxrVar, mbVar, zzagvVar, zzagxVar, zzuVar, zzbgzVar, z, i2, str, str2, zzbgzVar.b()));
    }

    public final boolean E() {
        boolean z;
        synchronized (this.f14475f) {
            z = this.p;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener F() {
        synchronized (this.f14475f) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener G() {
        synchronized (this.f14475f) {
        }
        return null;
    }

    public final void K(boolean z) {
        this.n = z;
    }

    public final void L(boolean z) {
        this.z = z;
    }

    public final void M(String str, zzaho<? super zzbgz> zzahoVar) {
        this.f14474e.i(str, zzahoVar);
    }

    public final void N(boolean z, int i2) {
        zzxr zzxrVar = (!this.f14473d.m() || this.f14473d.o().e()) ? this.f14476g : null;
        com.google.android.gms.ads.internal.overlay.zzo zzoVar = this.f14477h;
        com.google.android.gms.ads.internal.overlay.zzu zzuVar = this.r;
        zzbgz zzbgzVar = this.f14473d;
        w(new AdOverlayInfoParcel(zzxrVar, zzoVar, zzuVar, zzbgzVar, z, i2, zzbgzVar.b()));
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void a(Uri uri) {
        this.f14474e.y0(uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void b(boolean z) {
        synchronized (this.f14475f) {
            this.p = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void c(zzxr zzxrVar, zzagv zzagvVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar, zzagx zzagxVar, com.google.android.gms.ads.internal.overlay.zzu zzuVar, boolean z, zzahp zzahpVar, com.google.android.gms.ads.internal.zzb zzbVar, zzaqc zzaqcVar, zzavb zzavbVar) {
        if (zzbVar == null) {
            zzbVar = new com.google.android.gms.ads.internal.zzb(this.f14473d.getContext(), zzavbVar, null);
        }
        this.u = new zzapr(this.f14473d, zzaqcVar);
        this.v = zzavbVar;
        if (((Boolean) zzyt.e().c(zzacu.c1)).booleanValue()) {
            B("/adMetadata", new zzagu(zzagvVar));
        }
        B("/appEvent", new zzagw(zzagxVar));
        B("/backButton", zzagz.f13896j);
        B("/refresh", zzagz.f13897k);
        B("/canOpenURLs", zzagz.a);
        B("/canOpenIntents", zzagz.f13888b);
        B("/click", zzagz.f13889c);
        B("/close", zzagz.f13890d);
        B("/customClose", zzagz.f13891e);
        B("/instrument", zzagz.n);
        B("/delayPageLoaded", zzagz.p);
        B("/delayPageClosed", zzagz.q);
        B("/getLocationInfo", zzagz.r);
        B("/httpTrack", zzagz.f13892f);
        B("/log", zzagz.f13893g);
        B("/mraid", new zzahr(zzbVar, this.u, zzaqcVar));
        B("/mraidLoaded", this.s);
        B("/open", new zzahs(zzbVar, this.u));
        B("/precache", new zzbgc());
        B("/touch", zzagz.f13895i);
        B("/video", zzagz.l);
        B("/videoMeta", zzagz.m);
        if (zzk.zzme().D(this.f14473d.getContext())) {
            B("/logScionEvent", new zzahq(this.f14473d.getContext()));
        }
        this.f14476g = zzxrVar;
        this.f14477h = zzoVar;
        this.f14480k = zzagvVar;
        this.l = zzagxVar;
        this.r = zzuVar;
        this.t = zzbVar;
        this.n = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void d() {
        synchronized (this.f14475f) {
            this.n = false;
            this.o = true;
            zzbbm.a.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.jb

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzbio f12816f;

                {
                    this.f12816f = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbio zzbioVar = this.f12816f;
                    zzbioVar.f14473d.C();
                    com.google.android.gms.ads.internal.overlay.zzd zzdVarK0 = zzbioVar.f14473d.k0();
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
            WebView webView = this.f14473d.getWebView();
            if (androidx.core.view.u.N(webView)) {
                v(webView, zzavbVar, 10);
                return;
            }
            H();
            this.A = new lb(this, zzavbVar);
            this.f14473d.getView().addOnAttachStateChangeListener(this.A);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void f() {
        synchronized (this.f14475f) {
            this.q = true;
        }
        this.y++;
        I();
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
        I();
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void i(zzbij zzbijVar) {
        this.f14478i = zzbijVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void j(zzbik zzbikVar) {
        this.f14479j = zzbikVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final void k() {
        this.x = true;
        I();
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
        return this.o;
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
    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.f14473d.w(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    @Override // com.google.android.gms.internal.ads.zzbiz
    public final void p(zzbja zzbjaVar) {
        this.w = true;
        zzbik zzbikVar = this.f14479j;
        if (zzbikVar != null) {
            zzbikVar.a();
            this.f14479j = null;
        }
        I();
    }

    @Override // com.google.android.gms.internal.ads.zzbiz
    public final void r(zzbja zzbjaVar) {
        this.f14474e.w0(zzbjaVar.f14483b);
    }

    @Override // com.google.android.gms.internal.ads.zzbiz
    public final boolean s(zzbja zzbjaVar) {
        String strValueOf = String.valueOf(zzbjaVar.a);
        zzawz.m(strValueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(strValueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uriA = zzbjaVar.f14483b;
        if (this.f14474e.w0(uriA)) {
            return true;
        }
        if (this.n) {
            String scheme = uriA.getScheme();
            if ("http".equalsIgnoreCase(scheme) || BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equalsIgnoreCase(scheme)) {
                zzxr zzxrVar = this.f14476g;
                if (zzxrVar != null) {
                    zzxrVar.onAdClicked();
                    zzavb zzavbVar = this.v;
                    if (zzavbVar != null) {
                        zzavbVar.b(zzbjaVar.a);
                    }
                    this.f14476g = null;
                }
                return false;
            }
        }
        if (this.f14473d.getWebView().willNotDraw()) {
            String strValueOf2 = String.valueOf(zzbjaVar.a);
            zzbad.i(strValueOf2.length() != 0 ? "AdWebView unable to handle URL: ".concat(strValueOf2) : new String("AdWebView unable to handle URL: "));
        } else {
            try {
                zzdh zzdhVarD = this.f14473d.d();
                if (zzdhVarD != null && zzdhVarD.e(uriA)) {
                    uriA = zzdhVarD.a(uriA, this.f14473d.getContext(), this.f14473d.getView(), this.f14473d.a());
                }
            } catch (zzdi unused) {
                String strValueOf3 = String.valueOf(zzbjaVar.a);
                zzbad.i(strValueOf3.length() != 0 ? "Unable to append parameter to URL: ".concat(strValueOf3) : new String("Unable to append parameter to URL: "));
            }
            com.google.android.gms.ads.internal.zzb zzbVar = this.t;
            if (zzbVar == null || zzbVar.zzkx()) {
                x(new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uriA.toString(), null, null, null, null, null));
            } else {
                this.t.zzbk(zzbjaVar.a);
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbiz
    public final WebResourceResponse t(zzbja zzbjaVar) {
        String str;
        WebResourceResponse webResourceResponseL;
        zzvs zzvsVarD;
        zzavb zzavbVar = this.v;
        if (zzavbVar != null) {
            zzavbVar.a(zzbjaVar.a, zzbjaVar.f14485d, 1);
        }
        if ("mraid.js".equalsIgnoreCase(new File(zzbjaVar.a).getName())) {
            d();
            if (this.f14473d.o().e()) {
                str = (String) zzyt.e().c(zzacu.b0);
            } else {
                str = this.f14473d.m() ? (String) zzyt.e().c(zzacu.a0) : (String) zzyt.e().c(zzacu.Z);
            }
            zzk.zzlg();
            webResourceResponseL = zzaxi.L(this.f14473d.getContext(), this.f14473d.b().f14326f, str);
        } else {
            webResourceResponseL = null;
        }
        if (webResourceResponseL != null) {
            return webResourceResponseL;
        }
        try {
            if (!zzavx.c(zzbjaVar.a, this.f14473d.getContext(), this.z).equals(zzbjaVar.a)) {
                return O(zzbjaVar);
            }
            zzvv zzvvVarY = zzvv.y(zzbjaVar.a);
            if (zzvvVarY != null && (zzvsVarD = zzk.zzlm().d(zzvvVarY)) != null && zzvsVarD.y()) {
                return new WebResourceResponse(HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, zzvsVarD.z());
            }
            if (zzazx.a()) {
                if (((Boolean) zzyt.e().c(zzacu.J1)).booleanValue()) {
                    return O(zzbjaVar);
                }
            }
            return null;
        } catch (Exception | NoClassDefFoundError e2) {
            zzk.zzlk().e(e2, "AdWebViewClient.interceptRequest");
            return J();
        }
    }

    public final void u() {
        zzavb zzavbVar = this.v;
        if (zzavbVar != null) {
            zzavbVar.c();
            this.v = null;
        }
        H();
        this.f14474e.B();
        this.f14474e.r0(null);
        synchronized (this.f14475f) {
            this.f14476g = null;
            this.f14477h = null;
            this.f14478i = null;
            this.f14479j = null;
            this.f14480k = null;
            this.l = null;
            this.r = null;
            this.m = null;
            zzapr zzaprVar = this.u;
            if (zzaprVar != null) {
                zzaprVar.l(true);
                this.u = null;
            }
        }
    }

    public final void x(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        boolean zM = this.f14473d.m();
        w(new AdOverlayInfoParcel(zzcVar, (!zM || this.f14473d.o().e()) ? this.f14476g : null, zM ? null : this.f14477h, this.r, this.f14473d.b()));
    }

    final void y(zzbgz zzbgzVar, boolean z) {
        zzaqa zzaqaVar = new zzaqa(zzbgzVar, zzbgzVar.d0(), new zzacf(zzbgzVar.getContext()));
        this.f14473d = zzbgzVar;
        this.o = z;
        this.s = zzaqaVar;
        this.u = null;
        this.f14474e.r0(zzbgzVar);
    }
}
