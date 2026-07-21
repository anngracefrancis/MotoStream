package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcha implements zzdti<zzbbh<Bundle>> {
    private final zzdtu<zzczt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcvb<Bundle>> f15233b;

    private zzcha(zzdtu<zzczt> zzdtuVar, zzdtu<zzcvb<Bundle>> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15233b = zzdtuVar2;
    }

    public static zzcha a(zzdtu<zzczt> zzdtuVar, zzdtu<zzcvb<Bundle>> zzdtuVar2) {
        return new zzcha(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbbh) zzdto.b(this.a.get().g(zzczs.SIGNALS).c(this.f15233b.get().b(new Bundle())).f(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
