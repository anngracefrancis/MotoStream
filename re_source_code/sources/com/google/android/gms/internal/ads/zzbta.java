package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbta implements zzdti<zzbsv> {
    private final zzdtu<Set<zzbuz<com.google.android.gms.ads.internal.overlay.zzo>>> a;

    private zzbta(zzdtu<Set<zzbuz<com.google.android.gms.ads.internal.overlay.zzo>>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbta a(zzdtu<Set<zzbuz<com.google.android.gms.ads.internal.overlay.zzo>>> zzdtuVar) {
        return new zzbta(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbsv(this.a.get());
    }
}
