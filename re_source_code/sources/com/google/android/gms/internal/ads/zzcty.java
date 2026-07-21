package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcty implements zzdti<zzctw> {
    private final zzdtu<zzbbl> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f15626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Set<String>> f15627c;

    private zzcty(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<Set<String>> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15626b = zzdtuVar2;
        this.f15627c = zzdtuVar3;
    }

    public static zzcty a(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<Set<String>> zzdtuVar3) {
        return new zzcty(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzctw(this.a.get(), this.f15626b.get(), this.f15627c.get());
    }
}
