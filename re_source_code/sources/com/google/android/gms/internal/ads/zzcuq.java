package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcuq implements zzdti<zzcul> {
    private final zzdtu<zzbbl> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<ScheduledExecutorService> f15641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<String> f15642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcpf> f15643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<Context> f15644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<zzcxv> f15645f;

    private zzcuq(zzdtu<zzbbl> zzdtuVar, zzdtu<ScheduledExecutorService> zzdtuVar2, zzdtu<String> zzdtuVar3, zzdtu<zzcpf> zzdtuVar4, zzdtu<Context> zzdtuVar5, zzdtu<zzcxv> zzdtuVar6) {
        this.a = zzdtuVar;
        this.f15641b = zzdtuVar2;
        this.f15642c = zzdtuVar3;
        this.f15643d = zzdtuVar4;
        this.f15644e = zzdtuVar5;
        this.f15645f = zzdtuVar6;
    }

    public static zzcuq a(zzdtu<zzbbl> zzdtuVar, zzdtu<ScheduledExecutorService> zzdtuVar2, zzdtu<String> zzdtuVar3, zzdtu<zzcpf> zzdtuVar4, zzdtu<Context> zzdtuVar5, zzdtu<zzcxv> zzdtuVar6) {
        return new zzcuq(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcul(this.a.get(), this.f15641b.get(), this.f15642c.get(), this.f15643d.get(), this.f15644e.get(), this.f15645f.get());
    }
}
