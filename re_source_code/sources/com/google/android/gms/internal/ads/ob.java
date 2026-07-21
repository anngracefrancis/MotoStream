package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cm.aptoide.pt.BuildConfig;
import cm.aptoide.pt.install.installer.RootCommandOnSubscribe;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@zzard
final class ob extends zzbjb implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzajq, zzbgz {
    private zzbhq A;
    private boolean B;
    private boolean C;
    private zzadx D;
    private zzadv E;
    private int F;
    private int G;
    private zzadg H;
    private zzadg I;
    private zzadg J;
    private zzadh K;
    private WeakReference<View.OnClickListener> L;
    private com.google.android.gms.ads.internal.overlay.zzd M;
    private zzazs N;
    private final AtomicReference<IObjectWrapper> O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private Map<String, zzbft> T;
    private final WindowManager U;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbim f13095i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzbio f13096j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzdh f13097k;
    private final zzbai l;
    private final zzj m;
    private final com.google.android.gms.ads.internal.zza n;
    private final DisplayMetrics o;
    private final zzwj p;
    private com.google.android.gms.ads.internal.overlay.zzd q;
    private zzbin r;
    private String s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private boolean x;
    private boolean y;
    private String z;

    @VisibleForTesting
    protected ob(zzbim zzbimVar, zzbio zzbioVar, zzbin zzbinVar, String str, boolean z, boolean z2, zzdh zzdhVar, zzbai zzbaiVar, zzadi zzadiVar, zzj zzjVar, com.google.android.gms.ads.internal.zza zzaVar, zzwj zzwjVar) {
        super(zzbimVar, zzbioVar);
        this.x = true;
        this.y = false;
        this.z = HttpUrl.FRAGMENT_ENCODE_SET;
        this.O = new AtomicReference<>();
        this.P = -1;
        this.Q = -1;
        this.R = -1;
        this.S = -1;
        this.f13095i = zzbimVar;
        this.f13096j = zzbioVar;
        this.r = zzbinVar;
        this.s = str;
        this.u = z;
        this.w = -1;
        this.f13097k = zzdhVar;
        this.l = zzbaiVar;
        this.m = zzjVar;
        this.n = zzaVar;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.U = windowManager;
        zzk.zzlg();
        this.o = zzaxi.b(windowManager);
        this.p = zzwjVar;
        this.N = new zzazs(zzbimVar.b(), this, this, null);
        zzk.zzlg().k(zzbimVar, zzbaiVar.f14326f, getSettings());
        setDownloadListener(this);
        G0();
        if (PlatformVersion.d()) {
            addJavascriptInterface(zzbht.a(this), "googleAdsJsInterface");
        }
        K0();
        zzadh zzadhVar = new zzadh(new zzadi(true, "make_wv", this.s));
        this.K = zzadhVar;
        zzadhVar.c().b(zzadiVar);
        zzadg zzadgVarB = zzadb.b(this.K.c());
        this.I = zzadgVarB;
        this.K.a("native:view_create", zzadgVarB);
        this.J = null;
        this.H = null;
        zzk.zzli().m(zzbimVar);
    }

    static final /* synthetic */ void D0(boolean z, int i2, zzxn zzxnVar) {
        zzwt.zzv.zza zzaVarB = zzwt.zzv.B();
        if (zzaVarB.v() != z) {
            zzaVarB.w(z);
        }
        zzaVarB.u(i2);
        zzxnVar.n = (zzwt.zzv) ((zzdob) zzaVarB.p0());
    }

    private final boolean E0() {
        int i2;
        int iK;
        if (!this.f13096j.m() && !this.f13096j.E()) {
            return false;
        }
        zzyt.a();
        DisplayMetrics displayMetrics = this.o;
        int iK2 = zzazt.k(displayMetrics, displayMetrics.widthPixels);
        zzyt.a();
        DisplayMetrics displayMetrics2 = this.o;
        int iK3 = zzazt.k(displayMetrics2, displayMetrics2.heightPixels);
        Activity activityB = this.f13095i.b();
        if (activityB == null || activityB.getWindow() == null) {
            i2 = iK2;
            iK = iK3;
        } else {
            zzk.zzlg();
            int[] iArrP = zzaxi.P(activityB);
            zzyt.a();
            int iK4 = zzazt.k(this.o, iArrP[0]);
            zzyt.a();
            iK = zzazt.k(this.o, iArrP[1]);
            i2 = iK4;
        }
        int i3 = this.Q;
        if (i3 == iK2 && this.P == iK3 && this.R == i2 && this.S == iK) {
            return false;
        }
        boolean z = (i3 == iK2 && this.P == iK3) ? false : true;
        this.Q = iK2;
        this.P = iK3;
        this.R = i2;
        this.S = iK;
        new zzaqb(this).c(iK2, iK3, i2, iK, this.o.density, this.U.getDefaultDisplay().getRotation());
        return z;
    }

    private final void F0() {
        zzadb.a(this.K.c(), this.I, "aeh2");
    }

    private final synchronized void G0() {
        if (!this.u && !this.r.e()) {
            if (Build.VERSION.SDK_INT < 18) {
                zzbad.e("Disabling hardware acceleration on an AdView.");
                H0();
                return;
            } else {
                zzbad.e("Enabling hardware acceleration on an AdView.");
                I0();
                return;
            }
        }
        zzbad.e("Enabling hardware acceleration on an overlay.");
        I0();
    }

    private final synchronized void H0() {
        if (!this.v) {
            zzk.zzli();
            setLayerType(1, null);
        }
        this.v = true;
    }

    private final synchronized void I0() {
        if (this.v) {
            zzk.zzli();
            setLayerType(0, null);
        }
        this.v = false;
    }

    private final synchronized void J0() {
        Map<String, zzbft> map = this.T;
        if (map != null) {
            Iterator<zzbft> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        }
        this.T = null;
    }

    private final void K0() {
        zzadi zzadiVarC;
        zzadh zzadhVar = this.K;
        if (zzadhVar == null || (zzadiVarC = zzadhVar.c()) == null || zzk.zzlk().l() == null) {
            return;
        }
        zzk.zzlk().l().d(zzadiVarC);
    }

    private final void L0(boolean z) {
        HashMap map = new HashMap();
        map.put("isVisible", z ? "1" : "0");
        zzajr.b(this, "onAdVisibilityChanged", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void A(zzbin zzbinVar) {
        this.r = zzbinVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void B(boolean z, int i2) {
        this.f13096j.N(z, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void C() {
        this.N.e();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void D(zzadv zzadvVar) {
        this.E = zzadvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized boolean E() {
        return this.t;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void G(String str, String str2, String str3) {
        if (((Boolean) zzyt.e().c(zzacu.R0)).booleanValue()) {
            str2 = zzbid.b(str2, zzbid.a());
        }
        super.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void H(IObjectWrapper iObjectWrapper) {
        this.O.set(iObjectWrapper);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void I() {
        if (this.J == null) {
            zzadg zzadgVarB = zzadb.b(this.K.c());
            this.J = zzadgVarB;
            this.K.a("native:view_load", zzadgVarB);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void J() {
        F0();
        HashMap map = new HashMap(1);
        map.put("version", this.l.f14326f);
        zzajr.b(this, "onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void K(boolean z) {
        this.x = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void L(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.f13096j.x(zzcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final synchronized void M() {
        zzadv zzadvVar = this.E;
        if (zzadvVar != null) {
            zzadvVar.p5();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void N() {
        com.google.android.gms.ads.internal.overlay.zzd zzdVarK0 = k0();
        if (zzdVarK0 != null) {
            zzdVarK0.zztm();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void O() {
        HashMap map = new HashMap(3);
        map.put("app_muted", String.valueOf(zzk.zzll().e()));
        map.put("app_volume", String.valueOf(zzk.zzll().d()));
        map.put("device_volume", String.valueOf(zzaya.c(getContext())));
        zzajr.b(this, "volume", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final zzadg P() {
        return this.I;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized zzadx Q() {
        return this.D;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void R(boolean z, long j2) {
        HashMap map = new HashMap(2);
        map.put(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION, z ? "1" : "0");
        map.put("duration", Long.toString(j2));
        zzajr.b(this, "onCacheAccessComplete", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void S(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzd zzdVar;
        int i2 = this.F + (z ? 1 : -1);
        this.F = i2;
        if (i2 <= 0 && (zzdVar = this.q) != null) {
            zzdVar.zztn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int U() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final synchronized zzbft V(String str) {
        Map<String, zzbft> map = this.T;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void W(Context context) {
        this.f13095i.setBaseContext(context);
        this.N.c(this.f13095i.b());
    }

    @Override // com.google.android.gms.internal.ads.zzajq
    public final void X(String str, String str2) {
        zzajr.a(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void Y(String str, JSONObject jSONObject) {
        zzajr.c(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final IObjectWrapper Z() {
        return this.O.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbhx
    public final Activity a() {
        return this.f13095i.b();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void a0(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.M = zzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbig
    public final zzbai b() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void b0(int i2) {
        if (i2 == 0) {
            zzadb.a(this.K.c(), this.I, "aebb2");
        }
        F0();
        if (this.K.c() != null) {
            this.K.c().d("close_type", String.valueOf(i2));
        }
        HashMap map = new HashMap(2);
        map.put("closetype", String.valueOf(i2));
        map.put("version", this.l.f14326f);
        zzajr.b(this, "onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final com.google.android.gms.ads.internal.zza c() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void c0() {
        if (this.H == null) {
            zzadb.a(this.K.c(), this.I, "aes2");
            zzadg zzadgVarB = zzadb.b(this.K.c());
            this.H = zzadgVarB;
            this.K.a("native:view_show", zzadgVarB);
        }
        HashMap map = new HashMap(1);
        map.put("version", this.l.f14326f);
        zzajr.b(this, "onshow", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbif
    public final zzdh d() {
        return this.f13097k;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final Context d0() {
        return this.f13095i.a();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final synchronized void e(zzbhq zzbhqVar) {
        if (this.A != null) {
            zzbad.g("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.A = zzbhqVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void e0() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void f(String str, zzaho<? super zzbgz> zzahoVar) {
        zzbio zzbioVar = this.f13096j;
        if (zzbioVar != null) {
            zzbioVar.B(str, zzahoVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int f0() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final synchronized void g(String str, zzbft zzbftVar) {
        if (this.T == null) {
            this.T = new HashMap();
        }
        this.T.put(str, zzbftVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void g0(boolean z, int i2, String str) {
        this.f13096j.C(z, i2, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbih
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final synchronized zzbhq h() {
        return this.A;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void h0(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.q = zzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void i(String str, zzaho<? super zzbgz> zzahoVar) {
        zzbio zzbioVar = this.f13096j;
        if (zzbioVar != null) {
            zzbioVar.M(str, zzahoVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final zzbcw i0() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzaji
    public final void j(String str, JSONObject jSONObject) {
        zzajr.d(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void j0(boolean z) {
        boolean z2 = z != this.u;
        this.u = z;
        G0();
        if (z2) {
            new zzaqb(this).g(z ? "expanded" : BuildConfig.APTOIDE_THEME);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjb, com.google.android.gms.internal.ads.rb, com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzakg
    public final synchronized void k(String str) {
        if (l()) {
            zzbad.i("The webview is destroyed. Ignoring action.");
        } else {
            super.k(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized com.google.android.gms.ads.internal.overlay.zzd k0() {
        return this.q;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void l0() {
        zzawz.m("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbhy
    public final synchronized boolean m() {
        return this.u;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void m0(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzd zzdVar = this.q;
        if (zzdVar != null) {
            zzdVar.zza(this.f13096j.m(), z);
        } else {
            this.t = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final zzadh n() {
        return this.K;
    }

    @Override // com.google.android.gms.internal.ads.zzbjb, com.google.android.gms.internal.ads.zzbgz
    public final void n0() {
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbie
    public final synchronized zzbin o() {
        return this.r;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!l()) {
            this.N.a();
        }
        boolean z = this.B;
        zzbio zzbioVar = this.f13096j;
        if (zzbioVar != null && zzbioVar.E()) {
            if (!this.C) {
                this.f13096j.F();
                this.f13096j.G();
                this.C = true;
            }
            E0();
            z = true;
        }
        L0(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        zzbio zzbioVar;
        synchronized (this) {
            if (!l()) {
                this.N.b();
            }
            super.onDetachedFromWindow();
            if (this.C && (zzbioVar = this.f13096j) != null && zzbioVar.E() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.f13096j.F();
                this.f13096j.G();
                this.C = false;
            }
        }
        L0(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzk.zzlg();
            zzaxi.i(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzbad.e(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjb, android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zE0 = E0();
        com.google.android.gms.ads.internal.overlay.zzd zzdVarK0 = k0();
        if (zzdVarK0 == null || !zE0) {
            return;
        }
        zzdVarK0.zztk();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected final synchronized void onMeasure(int i2, int i3) {
        if (l()) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (!isInEditMode() && !this.u && !this.r.f()) {
            if (this.r.h()) {
                super.onMeasure(i2, i3);
                return;
            }
            if (this.r.g()) {
                if (((Boolean) zzyt.e().c(zzacu.R2)).booleanValue()) {
                    super.onMeasure(i2, i3);
                    return;
                }
                zzbhq zzbhqVarH = h();
                float fT = zzbhqVarH != null ? zzbhqVarH.T() : 0.0f;
                if (fT == 0.0f) {
                    super.onMeasure(i2, i3);
                    return;
                }
                int size = View.MeasureSpec.getSize(i2);
                int size2 = View.MeasureSpec.getSize(i3);
                int i4 = (int) (size2 * fT);
                int i5 = (int) (size / fT);
                if (size2 == 0 && i5 != 0) {
                    i4 = (int) (i5 * fT);
                    size2 = i5;
                } else if (size == 0 && i4 != 0) {
                    i5 = (int) (i4 / fT);
                    size = i4;
                }
                setMeasuredDimension(Math.min(i4, size), Math.min(i5, size2));
                return;
            }
            if (this.r.a()) {
                if (!((Boolean) zzyt.e().c(zzacu.U2)).booleanValue() && PlatformVersion.d()) {
                    f("/contentHeight", new qb(this));
                    k("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
                    int size3 = View.MeasureSpec.getSize(i2);
                    int i6 = this.G;
                    setMeasuredDimension(size3, i6 != -1 ? (int) (i6 * this.o.density) : View.MeasureSpec.getSize(i3));
                    return;
                }
                super.onMeasure(i2, i3);
                return;
            }
            if (this.r.e()) {
                DisplayMetrics displayMetrics = this.o;
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
                return;
            }
            int mode = View.MeasureSpec.getMode(i2);
            int size4 = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size5 = View.MeasureSpec.getSize(i3);
            int i7 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size4 : Integer.MAX_VALUE;
            int i8 = (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) ? size5 : Integer.MAX_VALUE;
            zzbin zzbinVar = this.r;
            boolean z = true;
            boolean z2 = zzbinVar.f14472c > i7 || zzbinVar.f14471b > i8;
            if (((Boolean) zzyt.e().c(zzacu.n4)).booleanValue()) {
                zzbin zzbinVar2 = this.r;
                float f2 = zzbinVar2.f14472c;
                float f3 = this.o.density;
                if (f2 / f3 > i7 / f3 || zzbinVar2.f14471b / f3 > i8 / f3) {
                    z = false;
                }
                if (z2) {
                    z2 = z;
                }
            }
            if (!z2) {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                zzbin zzbinVar3 = this.r;
                setMeasuredDimension(zzbinVar3.f14472c, zzbinVar3.f14471b);
                return;
            }
            zzbin zzbinVar4 = this.r;
            float f4 = zzbinVar4.f14472c;
            float f5 = this.o.density;
            int i9 = (int) (zzbinVar4.f14471b / f5);
            StringBuilder sb = new StringBuilder(103);
            sb.append("Not enough space to show ad. Needs ");
            sb.append((int) (f4 / f5));
            sb.append("x");
            sb.append(i9);
            sb.append(" dp, but only has ");
            sb.append((int) (size4 / f5));
            sb.append("x");
            sb.append((int) (size5 / f5));
            sb.append(" dp.");
            zzbad.i(sb.toString());
            if (getVisibility() != 8) {
                setVisibility(4);
            }
            setMeasuredDimension(0, 0);
            return;
        }
        super.onMeasure(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzbjb, android.webkit.WebView, com.google.android.gms.internal.ads.zzbgz
    public final void onPause() {
        try {
            super.onPause();
        } catch (Exception e2) {
            zzbad.c("Could not pause webview.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjb, android.webkit.WebView, com.google.android.gms.internal.ads.zzbgz
    public final void onResume() {
        try {
            super.onResume();
        } catch (Exception e2) {
            zzbad.c("Could not resume webview.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjb, android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f13096j.E()) {
            synchronized (this) {
                zzadx zzadxVar = this.D;
                if (zzadxVar != null) {
                    zzadxVar.b(motionEvent);
                }
            }
        } else {
            zzdh zzdhVar = this.f13097k;
            if (zzdhVar != null) {
                zzdhVar.c(motionEvent);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final /* synthetic */ zzbii p() {
        return this.f13096j;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean p0() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final synchronized String r() {
        return this.z;
    }

    @Override // com.google.android.gms.internal.ads.zzue
    public final void r0(zzud zzudVar) {
        boolean z;
        synchronized (this) {
            z = zzudVar.m;
            this.B = z;
        }
        L0(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized boolean s() {
        return this.F > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized com.google.android.gms.ads.internal.overlay.zzd s0() {
        return this.M;
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbgz
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.L = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void setRequestedOrientation(int i2) {
        this.w = i2;
        com.google.android.gms.ads.internal.overlay.zzd zzdVar = this.q;
        if (zzdVar != null) {
            zzdVar.setRequestedOrientation(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjb, android.webkit.WebView
    public final void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception e2) {
            zzbad.c("Could not stop loading webview.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void t(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        zzbio zzbioVar = this.f13096j;
        if (zzbioVar != null) {
            zzbioVar.A(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized boolean t0() {
        return this.x;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized String v() {
        return this.s;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void v0(boolean z) {
        this.f13096j.K(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean w(final boolean z, final int i2) {
        destroy();
        this.p.a(new zzwk(z, i2) { // from class: com.google.android.gms.internal.ads.pb
            private final boolean a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f13160b;

            {
                this.a = z;
                this.f13160b = i2;
            }

            @Override // com.google.android.gms.internal.ads.zzwk
            public final void a(zzxn zzxnVar) {
                ob.D0(this.a, this.f13160b, zzxnVar);
            }
        });
        this.p.b(zzwl.zza.zzb.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void w0(boolean z, int i2, String str, String str2) {
        this.f13096j.D(z, i2, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void x(boolean z) {
        this.f13096j.L(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final synchronized void x0(zzadx zzadxVar) {
        this.D = zzadxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void y(String str, Map map) {
        zzajr.b(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final WebViewClient z() {
        return this.f13096j;
    }

    @Override // com.google.android.gms.internal.ads.zzbjb
    protected final synchronized void z0(boolean z) {
        if (!z) {
            K0();
            this.N.f();
            com.google.android.gms.ads.internal.overlay.zzd zzdVar = this.q;
            if (zzdVar != null) {
                zzdVar.close();
                this.q.onDestroy();
                this.q = null;
            }
        }
        this.O.set(null);
        this.f13096j.u();
        zzk.zzmc();
        zzbfs.g(this);
        J0();
    }

    @Override // com.google.android.gms.ads.internal.zzj
    public final synchronized void zzlc() {
        this.y = true;
        zzj zzjVar = this.m;
        if (zzjVar != null) {
            zzjVar.zzlc();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzj
    public final synchronized void zzld() {
        this.y = false;
        zzj zzjVar = this.m;
        if (zzjVar != null) {
            zzjVar.zzld();
        }
    }
}
