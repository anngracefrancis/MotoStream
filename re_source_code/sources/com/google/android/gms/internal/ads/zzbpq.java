package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbpq implements zzdti<zzbpk> {
    private final zzdtu<Executor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<ScheduledExecutorService> f14669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbbh<zzbph>> f14670c;

    public zzbpq(zzdtu<Executor> zzdtuVar, zzdtu<ScheduledExecutorService> zzdtuVar2, zzdtu<zzbbh<zzbph>> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f14669b = zzdtuVar2;
        this.f14670c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbpk(this.a.get(), this.f14669b.get(), this.f14670c.get());
    }
}
