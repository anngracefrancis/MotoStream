package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbmm implements zzdti<zzbml> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzty> f14544b;

    private zzbmm(zzdtu<Context> zzdtuVar, zzdtu<zzty> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f14544b = zzdtuVar2;
    }

    public static zzbmm a(zzdtu<Context> zzdtuVar, zzdtu<zzty> zzdtuVar2) {
        return new zzbmm(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbml(this.a.get(), this.f14544b.get());
    }
}
