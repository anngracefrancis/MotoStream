package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcrb implements zzdti<zzcqz> {
    private final zzdtu<Executor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzchz> f15557b;

    public zzcrb(zzdtu<Executor> zzdtuVar, zzdtu<zzchz> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15557b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcqz(this.a.get(), this.f15557b.get());
    }
}
