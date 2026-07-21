package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwq implements zzcva<zzcwp> {
    private zzamg a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ScheduledExecutorService f15711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ApplicationInfo f15713d;

    public zzcwq(zzamg zzamgVar, ScheduledExecutorService scheduledExecutorService, boolean z, ApplicationInfo applicationInfo) {
        this.a = zzamgVar;
        this.f15711b = scheduledExecutorService;
        this.f15712c = z;
        this.f15713d = applicationInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcwp> b() {
        if (!this.f15712c) {
            return zzbar.l(new Exception("Auto Collect Location is false."));
        }
        return zzbar.d(zzbar.b(this.a.a(this.f15713d), ((Long) zzyt.e().c(zzacu.X2)).longValue(), TimeUnit.MILLISECONDS, this.f15711b), qp.a, zzaxg.a);
    }
}
