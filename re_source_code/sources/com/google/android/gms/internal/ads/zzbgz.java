package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@zzard
public interface zzbgz extends zzj, zzaji, zzakg, zzbdf, zzbhx, zzbhy, zzbic, zzbif, zzbig, zzbih, zzue {
    void A(zzbin zzbinVar);

    void C();

    void D(zzadv zzadvVar);

    boolean E();

    void G(String str, String str2, String str3);

    void H(IObjectWrapper iObjectWrapper);

    void I();

    void J();

    void K(boolean z);

    void O();

    zzadx Q();

    void S(boolean z);

    void W(Context context);

    IObjectWrapper Z();

    Activity a();

    void a0(com.google.android.gms.ads.internal.overlay.zzd zzdVar);

    zzbai b();

    void b0(int i2);

    com.google.android.gms.ads.internal.zza c();

    void c0();

    zzdh d();

    Context d0();

    void destroy();

    void e(zzbhq zzbhqVar);

    void e0();

    void f(String str, zzaho<? super zzbgz> zzahoVar);

    void g(String str, zzbft zzbftVar);

    @Override // com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbhx
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    View getView();

    WebView getWebView();

    int getWidth();

    zzbhq h();

    void h0(com.google.android.gms.ads.internal.overlay.zzd zzdVar);

    void i(String str, zzaho<? super zzbgz> zzahoVar);

    void j0(boolean z);

    com.google.android.gms.ads.internal.overlay.zzd k0();

    boolean l();

    void l0();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    boolean m();

    void m0(boolean z);

    void measure(int i2, int i3);

    zzadh n();

    void n0();

    zzbin o();

    void onPause();

    void onResume();

    zzbii p();

    boolean p0();

    boolean s();

    com.google.android.gms.ads.internal.overlay.zzd s0();

    @Override // com.google.android.gms.internal.ads.zzbdf
    void setBackgroundColor(int i2);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i2);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void t(String str, Predicate<zzaho<? super zzbgz>> predicate);

    boolean t0();

    String v();

    boolean w(boolean z, int i2);

    void x(boolean z);

    void x0(zzadx zzadxVar);

    WebViewClient z();
}
