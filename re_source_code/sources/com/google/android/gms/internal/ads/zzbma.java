package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbma implements zzdti<zzblz> {
    private final zzdtu<Context> a;

    private zzbma(zzdtu<Context> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbma a(zzdtu<Context> zzdtuVar) {
        return new zzbma(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzblz(this.a.get());
    }
}
