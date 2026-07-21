package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcki implements zzdti<zzckb> {
    private final zzdtu<zzboc> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f15320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Executor> f15321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcdn> f15322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzcxv> f15323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<zzbam<zzcxm, zzayb>> f15324f;

    public zzcki(zzdtu<zzboc> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<Executor> zzdtuVar3, zzdtu<zzcdn> zzdtuVar4, zzdtu<zzcxv> zzdtuVar5, zzdtu<zzbam<zzcxm, zzayb>> zzdtuVar6) {
        this.a = zzdtuVar;
        this.f15320b = zzdtuVar2;
        this.f15321c = zzdtuVar3;
        this.f15322d = zzdtuVar4;
        this.f15323e = zzdtuVar5;
        this.f15324f = zzdtuVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzckb(this.a.get(), this.f15320b.get(), this.f15321c.get(), this.f15322d.get(), this.f15323e.get(), this.f15324f.get());
    }
}
