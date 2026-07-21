package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcqy implements zzdti<zzbbh<zzcrc>> {
    private final zzdtu<zzczt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcqz> f15554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbbh<zzarx>> f15555c;

    public zzcqy(zzdtu<zzczt> zzdtuVar, zzdtu<zzcqz> zzdtuVar2, zzdtu<zzbbh<zzarx>> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15554b = zzdtuVar2;
        this.f15555c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbbh) zzdto.b(this.a.get().c(zzczs.GENERATE_SIGNALS, this.f15555c.get()).b(this.f15554b.get()).a(((Integer) zzyt.e().c(zzacu.u4)).intValue(), TimeUnit.SECONDS).f(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
