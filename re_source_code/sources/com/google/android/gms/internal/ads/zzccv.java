package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzccv implements zzdti<zzccj> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f15076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzdh> f15077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbai> f15078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<com.google.android.gms.ads.internal.zza> f15079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<zzbhf> f15080f;

    public zzccv(zzdtu<Context> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<zzdh> zzdtuVar3, zzdtu<zzbai> zzdtuVar4, zzdtu<com.google.android.gms.ads.internal.zza> zzdtuVar5, zzdtu<zzbhf> zzdtuVar6) {
        this.a = zzdtuVar;
        this.f15076b = zzdtuVar2;
        this.f15077c = zzdtuVar3;
        this.f15078d = zzdtuVar4;
        this.f15079e = zzdtuVar5;
        this.f15080f = zzdtuVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzccj(this.a.get(), this.f15076b.get(), this.f15077c.get(), this.f15078d.get(), this.f15079e.get(), this.f15080f.get());
    }
}
