package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcbu implements zzdti<zzcbp> {
    private final zzdtu<Executor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbmy> f15019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbva> f15020c;

    public zzcbu(zzdtu<Executor> zzdtuVar, zzdtu<zzbmy> zzdtuVar2, zzdtu<zzbva> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15019b = zzdtuVar2;
        this.f15020c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcbp(this.a.get(), this.f15019b.get(), this.f15020c.get());
    }
}
