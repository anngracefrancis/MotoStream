package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcws implements zzdti<zzcwq> {
    private final zzdtu<zzamg> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<ScheduledExecutorService> f15714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Boolean> f15715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<ApplicationInfo> f15716d;

    public zzcws(zzdtu<zzamg> zzdtuVar, zzdtu<ScheduledExecutorService> zzdtuVar2, zzdtu<Boolean> zzdtuVar3, zzdtu<ApplicationInfo> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15714b = zzdtuVar2;
        this.f15715c = zzdtuVar3;
        this.f15716d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcwq(this.a.get(), this.f15714b.get(), this.f15715c.get().booleanValue(), this.f15716d.get());
    }
}
