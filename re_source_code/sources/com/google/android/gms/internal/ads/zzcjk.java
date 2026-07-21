package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcjk implements zzczz {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzcji f15298f;

    zzcjk(zzcji zzcjiVar) {
        this.f15298f = zzcjiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void b(zzczs zzczsVar, String str, Throwable th) {
        if (((Boolean) zzyt.e().c(zzacu.a5)).booleanValue() && zzczs.RENDERER == zzczsVar && this.f15298f.c() != 0) {
            this.f15298f.g(zzk.zzln().b() - this.f15298f.c());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void c(zzczs zzczsVar, String str) {
        if (((Boolean) zzyt.e().c(zzacu.a5)).booleanValue() && zzczs.RENDERER == zzczsVar && this.f15298f.c() != 0) {
            this.f15298f.g(zzk.zzln().b() - this.f15298f.c());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void d(zzczs zzczsVar, String str) {
        if (((Boolean) zzyt.e().c(zzacu.a5)).booleanValue() && zzczs.RENDERER == zzczsVar) {
            this.f15298f.h(zzk.zzln().b());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void e(zzczs zzczsVar, String str) {
    }
}
