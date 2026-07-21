package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcex implements zzczz {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<zzczs, zzcez> f15153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzwj f15154g;

    zzcex(zzwj zzwjVar, Map<zzczs, zzcez> map) {
        this.f15153f = map;
        this.f15154g = zzwjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void b(zzczs zzczsVar, String str, Throwable th) {
        if (this.f15153f.containsKey(zzczsVar)) {
            this.f15154g.b(this.f15153f.get(zzczsVar).f15156c);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void c(zzczs zzczsVar, String str) {
        if (this.f15153f.containsKey(zzczsVar)) {
            this.f15154g.b(this.f15153f.get(zzczsVar).f15155b);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void d(zzczs zzczsVar, String str) {
        if (this.f15153f.containsKey(zzczsVar)) {
            this.f15154g.b(this.f15153f.get(zzczsVar).a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void e(zzczs zzczsVar, String str) {
    }
}
