package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbzi extends zzaes implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcab {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WeakReference<View> f14908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, WeakReference<View>> f14909g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<String, WeakReference<View>> f14910h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, WeakReference<View>> f14911i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzbyn f14912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzua f14913k;

    public zzbzi(View view, HashMap<String, View> map, HashMap<String, View> map2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzk.zzmd();
        zzbbz.a(view, this);
        zzk.zzmd();
        zzbbz.b(view, this);
        this.f14908f = new WeakReference<>(view);
        for (Map.Entry<String, View> entry : map.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            if (value != null) {
                this.f14909g.put(key, new WeakReference<>(value));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key)) {
                    value.setOnTouchListener(this);
                    value.setClickable(true);
                    value.setOnClickListener(this);
                }
            }
        }
        this.f14911i.putAll(this.f14909g);
        for (Map.Entry<String, View> entry2 : map2.entrySet()) {
            View value2 = entry2.getValue();
            if (value2 != null) {
                this.f14910h.put(entry2.getKey(), new WeakReference<>(value2));
                value2.setOnTouchListener(this);
                value2.setClickable(false);
            }
        }
        this.f14911i.putAll(this.f14910h);
        this.f14913k = new zzua(view.getContext(), view);
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized String A5() {
        return NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final FrameLayout E0() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final zzua E3() {
        return this.f14913k;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized void H(String str, View view, boolean z) {
        try {
            if (view == null) {
                this.f14911i.remove(str);
                this.f14909g.remove(str);
                this.f14910h.remove(str);
                return;
            }
            this.f14911i.put(str, new WeakReference<>(view));
            if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
                this.f14909g.put(str, new WeakReference<>(view));
                view.setClickable(true);
                view.setOnClickListener(this);
                view.setOnTouchListener(this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized Map<String, WeakReference<View>> S4() {
        return this.f14910h;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final synchronized void V(IObjectWrapper iObjectWrapper) {
        Object objK0 = ObjectWrapper.k0(iObjectWrapper);
        if (!(objK0 instanceof zzbyn)) {
            zzbad.i("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        zzbyn zzbynVar = this.f14912j;
        if (zzbynVar != null) {
            zzbynVar.v(this);
        }
        if (!((zzbyn) objK0).q()) {
            zzbad.g("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
            return;
        }
        zzbyn zzbynVar2 = (zzbyn) objK0;
        this.f14912j = zzbynVar2;
        zzbynVar2.o(this);
        this.f14912j.E(k0());
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized Map<String, WeakReference<View>> V3() {
        return this.f14909g;
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized View Y4(String str) {
        WeakReference<View> weakReference = this.f14911i.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final View k0() {
        return this.f14908f.get();
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        zzbyn zzbynVar = this.f14912j;
        if (zzbynVar != null) {
            zzbynVar.k(view, k0(), y4(), V3(), true);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        zzbyn zzbynVar = this.f14912j;
        if (zzbynVar != null) {
            zzbynVar.u(k0(), y4(), V3(), zzbyn.D(k0()));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        zzbyn zzbynVar = this.f14912j;
        if (zzbynVar != null) {
            zzbynVar.u(k0(), y4(), V3(), zzbyn.D(k0()));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzbyn zzbynVar = this.f14912j;
        if (zzbynVar != null) {
            zzbynVar.j(view, motionEvent, k0());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final synchronized void x0(IObjectWrapper iObjectWrapper) {
        if (this.f14912j != null) {
            Object objK0 = ObjectWrapper.k0(iObjectWrapper);
            if (!(objK0 instanceof View)) {
                zzbad.i("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.f14912j.i((View) objK0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final synchronized Map<String, WeakReference<View>> y4() {
        return this.f14911i;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final synchronized void z5() {
        zzbyn zzbynVar = this.f14912j;
        if (zzbynVar != null) {
            zzbynVar.v(this);
            this.f14912j = null;
        }
    }
}
