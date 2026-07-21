package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcvr implements zzdti<zzcvo> {
    private final zzdtu<zzawi> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f15688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<ScheduledExecutorService> f15689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<Executor> f15690d;

    public zzcvr(zzdtu<zzawi> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<ScheduledExecutorService> zzdtuVar3, zzdtu<Executor> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15688b = zzdtuVar2;
        this.f15689c = zzdtuVar3;
        this.f15690d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcvo(this.a.get(), this.f15688b.get(), this.f15689c.get(), this.f15690d.get());
    }
}
