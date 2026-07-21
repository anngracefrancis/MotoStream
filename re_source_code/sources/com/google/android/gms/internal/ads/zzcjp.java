package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcjp implements zzdti<zzcjm> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbh<Bundle>> f15305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcji> f15306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcjc> f15307d;

    private zzcjp(zzdtu<Context> zzdtuVar, zzdtu<zzbbh<Bundle>> zzdtuVar2, zzdtu<zzcji> zzdtuVar3, zzdtu<zzcjc> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15305b = zzdtuVar2;
        this.f15306c = zzdtuVar3;
        this.f15307d = zzdtuVar4;
    }

    public static zzcjp a(zzdtu<Context> zzdtuVar, zzdtu<zzbbh<Bundle>> zzdtuVar2, zzdtu<zzcji> zzdtuVar3, zzdtu<zzcjc> zzdtuVar4) {
        return new zzcjp(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcjm(this.a.get(), this.f15305b.get(), this.f15306c.get(), this.f15307d.get());
    }
}
