package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaer;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzyt;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zzbql = new WeakHashMap<>();
    private zzaer zzbqk;
    private WeakReference<View> zzbqm;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        Preconditions.l(view, "ContainerView must not be null");
        if ((view instanceof NativeAdView) || (view instanceof UnifiedNativeAdView)) {
            zzbad.g("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
            return;
        }
        if (zzbql.get(view) != null) {
            zzbad.g("The provided containerView is already in use with another NativeAdViewHolder.");
            return;
        }
        zzbql.put(view, this);
        this.zzbqm = new WeakReference<>(view);
        this.zzbqk = zzyt.b().b(view, zzb(map), zzb(map2));
    }

    private static HashMap<String, View> zzb(Map<String, View> map) {
        return map == null ? new HashMap<>() : new HashMap<>(map);
    }

    private final void zze(IObjectWrapper iObjectWrapper) {
        WeakReference<View> weakReference = this.zzbqm;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null) {
            zzbad.i("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zzbql.containsKey(view)) {
            zzbql.put(view, this);
        }
        zzaer zzaerVar = this.zzbqk;
        if (zzaerVar != null) {
            try {
                zzaerVar.V(iObjectWrapper);
            } catch (RemoteException e2) {
                zzbad.c("Unable to call setNativeAd on delegate", e2);
            }
        }
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzbqk.x0(ObjectWrapper.E0(view));
        } catch (RemoteException e2) {
            zzbad.c("Unable to call setClickConfirmingView on delegate", e2);
        }
    }

    public final void setNativeAd(NativeAd nativeAd) {
        zze((IObjectWrapper) nativeAd.zzkq());
    }

    public final void unregisterNativeAd() {
        zzaer zzaerVar = this.zzbqk;
        if (zzaerVar != null) {
            try {
                zzaerVar.z5();
            } catch (RemoteException e2) {
                zzbad.c("Unable to call unregisterNativeAd on delegate", e2);
            }
        }
        WeakReference<View> weakReference = this.zzbqm;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            zzbql.remove(view);
        }
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        zze((IObjectWrapper) unifiedNativeAd.zzkq());
    }
}
