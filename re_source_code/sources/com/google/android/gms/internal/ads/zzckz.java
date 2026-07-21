package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class zzckz implements zzdti<zzckv> {
    private final zzdtu<zzboc> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzckb> f15342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbrm> f15343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<ScheduledExecutorService> f15344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzbbl> f15345e;

    public zzckz(zzdtu<zzboc> zzdtuVar, zzdtu<zzckb> zzdtuVar2, zzdtu<zzbrm> zzdtuVar3, zzdtu<ScheduledExecutorService> zzdtuVar4, zzdtu<zzbbl> zzdtuVar5) {
        this.a = zzdtuVar;
        this.f15342b = zzdtuVar2;
        this.f15343c = zzdtuVar3;
        this.f15344d = zzdtuVar4;
        this.f15345e = zzdtuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzckv(this.a.get(), this.f15342b.get(), this.f15343c.get(), this.f15344d.get(), this.f15345e.get());
    }
}
