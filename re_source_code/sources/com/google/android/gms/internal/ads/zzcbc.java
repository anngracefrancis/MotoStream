package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcbc implements zzdti<zzcau> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcan> f15000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzdh> f15001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbai> f15002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<com.google.android.gms.ads.internal.zza> f15003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<zzwj> f15004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzdtu<Executor> f15005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzdtu<zzcxv> f15006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzdtu<zzcbi> f15007i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzdtu<ScheduledExecutorService> f15008j;

    public zzcbc(zzdtu<Context> zzdtuVar, zzdtu<zzcan> zzdtuVar2, zzdtu<zzdh> zzdtuVar3, zzdtu<zzbai> zzdtuVar4, zzdtu<com.google.android.gms.ads.internal.zza> zzdtuVar5, zzdtu<zzwj> zzdtuVar6, zzdtu<Executor> zzdtuVar7, zzdtu<zzcxv> zzdtuVar8, zzdtu<zzcbi> zzdtuVar9, zzdtu<ScheduledExecutorService> zzdtuVar10) {
        this.a = zzdtuVar;
        this.f15000b = zzdtuVar2;
        this.f15001c = zzdtuVar3;
        this.f15002d = zzdtuVar4;
        this.f15003e = zzdtuVar5;
        this.f15004f = zzdtuVar6;
        this.f15005g = zzdtuVar7;
        this.f15006h = zzdtuVar8;
        this.f15007i = zzdtuVar9;
        this.f15008j = zzdtuVar10;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcau(this.a.get(), this.f15000b.get(), this.f15001c.get(), this.f15002d.get(), this.f15003e.get(), this.f15004f.get(), this.f15005g.get(), this.f15006h.get(), this.f15007i.get(), this.f15008j.get());
    }
}
