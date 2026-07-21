package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbzs implements zzdti<zzbzq> {
    private final zzdtu<zzccj> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Clock> f14941b;

    public zzbzs(zzdtu<zzccj> zzdtuVar, zzdtu<Clock> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f14941b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbzq(this.a.get(), this.f14941b.get());
    }
}
