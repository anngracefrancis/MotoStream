package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcfa implements zzdti<zzcex> {
    private final zzdtu<zzwj> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Map<zzczs, zzcez>> f15157b;

    private zzcfa(zzdtu<zzwj> zzdtuVar, zzdtu<Map<zzczs, zzcez>> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15157b = zzdtuVar2;
    }

    public static zzcfa a(zzdtu<zzwj> zzdtuVar, zzdtu<Map<zzczs, zzcez>> zzdtuVar2) {
        return new zzcfa(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcex(this.a.get(), this.f15157b.get());
    }
}
