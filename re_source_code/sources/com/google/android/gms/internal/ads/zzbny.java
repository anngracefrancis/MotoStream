package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbny implements zzdti<zzbuz<zzue>> {
    private final zzbnk a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzboz> f14605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Executor> f14606c;

    public zzbny(zzbnk zzbnkVar, zzdtu<zzboz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzbnkVar;
        this.f14605b = zzdtuVar;
        this.f14606c = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.f14605b.get(), this.f14606c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
