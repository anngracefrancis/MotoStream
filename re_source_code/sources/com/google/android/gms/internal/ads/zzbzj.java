package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbzj extends zzaen implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcab {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f14914f = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f14915g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private FrameLayout f14917i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private FrameLayout f14918j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzbbl f14919k;
    private View l;
    private zzbyn m;
    private zzua n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, WeakReference<View>> f14916h = new HashMap();
    private boolean o = false;

    public zzbzj(FrameLayout frameLayout, FrameLayout frameLayout2) {
        String str;
        this.f14917i = frameLayout;
        this.f14918j = frameLayout2;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = NativeAppInstallAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.f14915g = str;
        zzk.zzmd();
        zzbbz.a(frameLayout, this);
        zzk.zzmd();
        zzbbz.b(frameLayout, this);
        this.f14919k = zzbbm.f14332c;
        this.n = new zzua(this.f14917i.getContext(), this.f14917i);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    private final synchronized void i7() {
        this.f14919k.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.yf

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbzj f13640f;

            {
                this.f13640f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13640f.j7();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized String A5() {
        return this.f14915g;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final FrameLayout E0() {
        return this.f14918j;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final zzua E3() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized void H(String str, View view, boolean z) {
        if (this.o) {
            return;
        }
        if (view == null) {
            this.f14916h.remove(str);
            return;
        }
        this.f14916h.put(str, new WeakReference<>(view));
        if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
            view.setOnTouchListener(this);
            view.setClickable(true);
            view.setOnClickListener(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized Map<String, WeakReference<View>> S4() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final synchronized void V(IObjectWrapper iObjectWrapper) {
        if (this.o) {
            return;
        }
        Object objK0 = ObjectWrapper.k0(iObjectWrapper);
        if (!(objK0 instanceof zzbyn)) {
            zzbad.i("Not an instance of native engine. This is most likely a transient error");
            return;
        }
        zzbyn zzbynVar = this.m;
        if (zzbynVar != null) {
            zzbynVar.v(this);
        }
        i7();
        zzbyn zzbynVar2 = (zzbyn) objK0;
        this.m = zzbynVar2;
        zzbynVar2.o(this);
        this.m.E(this.f14917i);
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized Map<String, WeakReference<View>> V3() {
        return this.f14916h;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final synchronized void X0(IObjectWrapper iObjectWrapper, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized View Y4(String str) {
        if (this.o) {
            return null;
        }
        WeakReference<View> weakReference = this.f14916h.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final synchronized void d5(String str, IObjectWrapper iObjectWrapper) {
        H(str, (View) ObjectWrapper.k0(iObjectWrapper), true);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final synchronized void destroy() {
        if (this.o) {
            return;
        }
        zzbyn zzbynVar = this.m;
        if (zzbynVar != null) {
            zzbynVar.v(this);
            this.m = null;
        }
        this.f14916h.clear();
        this.f14917i.removeAllViews();
        this.f14918j.removeAllViews();
        this.f14916h = null;
        this.f14917i = null;
        this.f14918j = null;
        this.l = null;
        this.n = null;
        this.o = true;
    }

    final /* synthetic */ void j7() {
        if (this.l == null) {
            View view = new View(this.f14917i.getContext());
            this.l = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.f14917i != this.l.getParent()) {
            this.f14917i.addView(this.l);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final /* synthetic */ View k0() {
        return this.f14917i;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final synchronized IObjectWrapper n4(String str) {
        return ObjectWrapper.E0(Y4(str));
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        zzbyn zzbynVar = this.m;
        if (zzbynVar != null) {
            zzbynVar.g();
            this.m.k(view, this.f14917i, y4(), V3(), false);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        zzbyn zzbynVar = this.m;
        if (zzbynVar != null) {
            zzbynVar.u(this.f14917i, y4(), V3(), zzbyn.D(this.f14917i));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        zzbyn zzbynVar = this.m;
        if (zzbynVar != null) {
            zzbynVar.u(this.f14917i, y4(), V3(), zzbyn.D(this.f14917i));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzbyn zzbynVar = this.m;
        if (zzbynVar != null) {
            zzbynVar.j(view, motionEvent, this.f14917i);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final synchronized void x0(IObjectWrapper iObjectWrapper) {
        this.m.i((View) ObjectWrapper.k0(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized Map<String, WeakReference<View>> y4() {
        return this.f14916h;
    }
}
