package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcgl implements zzdti<zzcgb> {
    private final zzdtu<Executor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f15204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Executor> f15205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzclc> f15206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<ScheduledExecutorService> f15207e;

    public zzcgl(zzdtu<Executor> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<Executor> zzdtuVar3, zzdtu<zzclc> zzdtuVar4, zzdtu<ScheduledExecutorService> zzdtuVar5) {
        this.a = zzdtuVar;
        this.f15204b = zzdtuVar2;
        this.f15205c = zzdtuVar3;
        this.f15206d = zzdtuVar4;
        this.f15207e = zzdtuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcgb(this.a.get(), this.f15204b.get(), this.f15205c.get(), this.f15206d.get(), this.f15207e.get());
    }
}
