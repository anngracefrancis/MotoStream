package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbhk extends FrameLayout implements zzbgz {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbgz f14458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbcw f14459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f14460h;

    public zzbhk(zzbgz zzbgzVar) {
        super(zzbgzVar.getContext());
        this.f14460h = new AtomicBoolean();
        this.f14458f = zzbgzVar;
        this.f14459g = new zzbcw(zzbgzVar.d0(), this, this);
        addView(zzbgzVar.getView());
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void A(zzbin zzbinVar) {
        this.f14458f.A(zzbinVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void B(boolean z, int i2) {
        this.f14458f.B(z, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void C() {
        this.f14458f.C();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void D(zzadv zzadvVar) {
        this.f14458f.D(zzadvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean E() {
        return this.f14458f.E();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void G(String str, String str2, String str3) {
        this.f14458f.G(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void H(IObjectWrapper iObjectWrapper) {
        this.f14458f.H(iObjectWrapper);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void I() {
        this.f14458f.I();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void J() {
        this.f14458f.J();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void K(boolean z) {
        this.f14458f.K(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void L(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.f14458f.L(zzcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void M() {
        this.f14458f.M();
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void N() {
        this.f14458f.N();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void O() {
        this.f14458f.O();
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final zzadg P() {
        return this.f14458f.P();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final zzadx Q() {
        return this.f14458f.Q();
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void R(boolean z, long j2) {
        this.f14458f.R(z, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void S(boolean z) {
        this.f14458f.S(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int U() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final zzbft V(String str) {
        return this.f14458f.V(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void W(Context context) {
        this.f14458f.W(context);
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void Y(String str, JSONObject jSONObject) {
        this.f14458f.Y(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final IObjectWrapper Z() {
        return this.f14458f.Z();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbhx
    public final Activity a() {
        return this.f14458f.a();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void a0(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.f14458f.a0(zzdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbig
    public final zzbai b() {
        return this.f14458f.b();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void b0(int i2) {
        this.f14458f.b0(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final com.google.android.gms.ads.internal.zza c() {
        return this.f14458f.c();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void c0() {
        this.f14458f.c0();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbif
    public final zzdh d() {
        return this.f14458f.d();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final Context d0() {
        return this.f14458f.d0();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void destroy() {
        IObjectWrapper iObjectWrapperZ = Z();
        if (iObjectWrapperZ == null) {
            this.f14458f.destroy();
            return;
        }
        zzk.zzlv().f(iObjectWrapperZ);
        zzaxi.a.postDelayed(new ab(this), ((Integer) zzyt.e().c(zzacu.c4)).intValue());
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final void e(zzbhq zzbhqVar) {
        this.f14458f.e(zzbhqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void e0() {
        setBackgroundColor(0);
        this.f14458f.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void f(String str, zzaho<? super zzbgz> zzahoVar) {
        this.f14458f.f(str, zzahoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int f0() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final void g(String str, zzbft zzbftVar) {
        this.f14458f.g(str, zzbftVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void g0(boolean z, int i2, String str) {
        this.f14458f.g0(z, i2, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbih
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final WebView getWebView() {
        return this.f14458f.getWebView();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final zzbhq h() {
        return this.f14458f.h();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void h0(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.f14458f.h0(zzdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void i(String str, zzaho<? super zzbgz> zzahoVar) {
        this.f14458f.i(str, zzahoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final zzbcw i0() {
        return this.f14459g;
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void j(String str, JSONObject jSONObject) {
        this.f14458f.j(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void j0(boolean z) {
        this.f14458f.j0(z);
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void k(String str) {
        this.f14458f.k(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final com.google.android.gms.ads.internal.overlay.zzd k0() {
        return this.f14458f.k0();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean l() {
        return this.f14458f.l();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void l0() {
        TextView textView = new TextView(getContext());
        Resources resourcesB = zzk.zzlk().b();
        textView.setText(resourcesB != null ? resourcesB.getString(R.string.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        if (Build.VERSION.SDK_INT >= 16) {
            textView.setBackground(gradientDrawable);
        } else {
            textView.setBackgroundDrawable(gradientDrawable);
        }
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void loadData(String str, String str2, String str3) {
        this.f14458f.loadData(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f14458f.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void loadUrl(String str) {
        this.f14458f.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbhy
    public final boolean m() {
        return this.f14458f.m();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void m0(boolean z) {
        this.f14458f.m0(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbdf
    public final zzadh n() {
        return this.f14458f.n();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void n0() {
        this.f14459g.a();
        this.f14458f.n0();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz, com.google.android.gms.internal.ads.zzbie
    public final zzbin o() {
        return this.f14458f.o();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void onPause() {
        this.f14459g.b();
        this.f14458f.onPause();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void onResume() {
        this.f14458f.onResume();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final zzbii p() {
        return this.f14458f.p();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean p0() {
        return this.f14460h.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final String r() {
        return this.f14458f.r();
    }

    @Override // com.google.android.gms.internal.ads.zzue
    public final void r0(zzud zzudVar) {
        this.f14458f.r0(zzudVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean s() {
        return this.f14458f.s();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final com.google.android.gms.ads.internal.overlay.zzd s0() {
        return this.f14458f.s0();
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbgz
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f14458f.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbgz
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f14458f.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void setRequestedOrientation(int i2) {
        this.f14458f.setRequestedOrientation(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f14458f.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.f14458f.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void t(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        this.f14458f.t(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean t0() {
        return this.f14458f.t0();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final String v() {
        return this.f14458f.v();
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void v0(boolean z) {
        this.f14458f.v0(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean w(boolean z, int i2) {
        if (!this.f14460h.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzyt.e().c(zzacu.V0)).booleanValue()) {
            return false;
        }
        removeView(this.f14458f.getView());
        return this.f14458f.w(z, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbic
    public final void w0(boolean z, int i2, String str, String str2) {
        this.f14458f.w0(z, i2, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void x(boolean z) {
        this.f14458f.x(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void x0(zzadx zzadxVar) {
        this.f14458f.x0(zzadxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void y(String str, Map<String, ?> map) {
        this.f14458f.y(str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final WebViewClient z() {
        return this.f14458f.z();
    }

    @Override // com.google.android.gms.ads.internal.zzj
    public final void zzlc() {
        this.f14458f.zzlc();
    }

    @Override // com.google.android.gms.ads.internal.zzj
    public final void zzld() {
        this.f14458f.zzld();
    }
}
