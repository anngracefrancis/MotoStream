package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class qf implements zzaho<Object> {
    private WeakReference<zzbxx> a;

    private qf(zzbxx zzbxxVar) {
        this.a = new WeakReference<>(zzbxxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void a(Object obj, Map<String, String> map) {
        zzbxx zzbxxVar = this.a.get();
        if (zzbxxVar != null && "_ac".equals(map.get("eventName"))) {
            zzbxxVar.f14831h.onAdClicked();
        }
    }
}
