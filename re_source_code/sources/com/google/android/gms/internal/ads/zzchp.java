package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class zzchp implements zzdti<zzchl> {
    private final zzdtu<zzbtg> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcxv> f15245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcgn> f15246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbbl> f15247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<ScheduledExecutorService> f15248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<zzcji> f15249f;

    private zzchp(zzdtu<zzbtg> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<zzcgn> zzdtuVar3, zzdtu<zzbbl> zzdtuVar4, zzdtu<ScheduledExecutorService> zzdtuVar5, zzdtu<zzcji> zzdtuVar6) {
        this.a = zzdtuVar;
        this.f15245b = zzdtuVar2;
        this.f15246c = zzdtuVar3;
        this.f15247d = zzdtuVar4;
        this.f15248e = zzdtuVar5;
        this.f15249f = zzdtuVar6;
    }

    public static zzchp a(zzdtu<zzbtg> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<zzcgn> zzdtuVar3, zzdtu<zzbbl> zzdtuVar4, zzdtu<ScheduledExecutorService> zzdtuVar5, zzdtu<zzcji> zzdtuVar6) {
        return new zzchp(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzchl(this.a.get(), this.f15245b.get(), this.f15246c.get(), this.f15247d.get(), this.f15248e.get(), this.f15249f.get());
    }
}
