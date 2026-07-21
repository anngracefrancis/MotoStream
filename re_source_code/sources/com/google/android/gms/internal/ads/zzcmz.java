package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcmz<AdT> implements zzdti<zzcmx<AdT>> {
    private final zzdtu<zzczt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcmu> f15421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbrm> f15422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzdae> f15423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzbpe<AdT>> f15424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<Executor> f15425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzdtu<ScheduledExecutorService> f15426g;

    private zzcmz(zzdtu<zzczt> zzdtuVar, zzdtu<zzcmu> zzdtuVar2, zzdtu<zzbrm> zzdtuVar3, zzdtu<zzdae> zzdtuVar4, zzdtu<zzbpe<AdT>> zzdtuVar5, zzdtu<Executor> zzdtuVar6, zzdtu<ScheduledExecutorService> zzdtuVar7) {
        this.a = zzdtuVar;
        this.f15421b = zzdtuVar2;
        this.f15422c = zzdtuVar3;
        this.f15423d = zzdtuVar4;
        this.f15424e = zzdtuVar5;
        this.f15425f = zzdtuVar6;
        this.f15426g = zzdtuVar7;
    }

    public static <AdT> zzcmz<AdT> a(zzdtu<zzczt> zzdtuVar, zzdtu<zzcmu> zzdtuVar2, zzdtu<zzbrm> zzdtuVar3, zzdtu<zzdae> zzdtuVar4, zzdtu<zzbpe<AdT>> zzdtuVar5, zzdtu<Executor> zzdtuVar6, zzdtu<ScheduledExecutorService> zzdtuVar7) {
        return new zzcmz<>(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6, zzdtuVar7);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcmx(this.a.get(), this.f15421b.get(), this.f15422c.get(), this.f15423d.get(), this.f15424e.get(), this.f15425f.get(), this.f15426g.get());
    }
}
