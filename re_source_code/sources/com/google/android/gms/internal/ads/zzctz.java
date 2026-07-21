package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcuz;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class zzctz<S extends zzcuz> implements zzcva<S> {
    private final zzcva<S> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f15628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f15629c;

    public zzctz(zzcva<S> zzcvaVar, long j2, ScheduledExecutorService scheduledExecutorService) {
        this.a = zzcvaVar;
        this.f15628b = j2;
        this.f15629c = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<S> b() {
        zzbbh<S> zzbbhVarB = this.a.b();
        long j2 = this.f15628b;
        if (j2 > 0) {
            zzbbhVarB = zzbar.b(zzbbhVarB, j2, TimeUnit.MILLISECONDS, this.f15629c);
        }
        return zzbar.e(zzbbhVarB, Throwable.class, qo.a, zzbbm.f14331b);
    }
}
