package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbob implements zzdti<zzcva<zzcrd>> {
    private final zzdtu<zzcre> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<ScheduledExecutorService> f14608b;

    public zzbob(zzdtu<zzcre> zzdtuVar, zzdtu<ScheduledExecutorService> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f14608b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcva) zzdto.b(new zzctz(this.a.get(), 0L, this.f14608b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
