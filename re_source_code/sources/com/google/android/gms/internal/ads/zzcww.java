package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcww implements zzdti<zzcwu> {
    private final zzdtu<zzaqm> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<ScheduledExecutorService> f15719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Context> f15720c;

    public zzcww(zzdtu<zzaqm> zzdtuVar, zzdtu<ScheduledExecutorService> zzdtuVar2, zzdtu<Context> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15719b = zzdtuVar2;
        this.f15720c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcwu(this.a.get(), this.f15719b.get(), this.f15720c.get());
    }
}
