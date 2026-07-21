package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbne implements zzdti<zzbtb> {
    private final zzdtu<ScheduledExecutorService> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Clock> f14579b;

    public zzbne(zzdtu<ScheduledExecutorService> zzdtuVar, zzdtu<Clock> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f14579b = zzdtuVar2;
    }

    public static zzbtb a(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        return (zzbtb) zzdto.b(new zzbtb(scheduledExecutorService, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return a(this.a.get(), this.f14579b.get());
    }
}
