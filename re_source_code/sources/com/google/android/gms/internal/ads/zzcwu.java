package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwu implements zzcva<zzcwt> {
    private zzaqm a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ScheduledExecutorService f15717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f15718c;

    public zzcwu(zzaqm zzaqmVar, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.a = zzaqmVar;
        this.f15717b = scheduledExecutorService;
        this.f15718c = context;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcwt> b() {
        return zzbar.d(zzbar.b(this.a.a(this.f15718c), ((Long) zzyt.e().c(zzacu.n3)).longValue(), TimeUnit.MILLISECONDS, this.f15717b), rp.a, zzaxg.a);
    }
}
