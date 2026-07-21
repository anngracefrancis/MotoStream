package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqf implements zzdti<zzbqe> {
    private final zzdtu<Clock> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzawj> f14684b;

    private zzbqf(zzdtu<Clock> zzdtuVar, zzdtu<zzawj> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f14684b = zzdtuVar2;
    }

    public static zzbqf a(zzdtu<Clock> zzdtuVar, zzdtu<zzawj> zzdtuVar2) {
        return new zzbqf(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbqe(this.a.get(), this.f14684b.get());
    }
}
