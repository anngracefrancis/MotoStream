package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxv implements zzdti<zzcyb<zzccj>> {
    private final zzdtu<zzccj> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbl> f14820b;

    public zzbxv(zzdtu<zzccj> zzdtuVar, zzdtu<zzbbl> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f14820b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        final zzdtu<zzccj> zzdtuVar = this.a;
        return (zzcyb) zzdto.b(new zzcyb(new Callable(zzdtuVar) { // from class: com.google.android.gms.internal.ads.of

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzdtu f13099f;

            {
                this.f13099f = zzdtuVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzccj zzccjVar = (zzccj) this.f13099f.get();
                zzccjVar.g();
                return zzccjVar;
            }
        }, this.f14820b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
