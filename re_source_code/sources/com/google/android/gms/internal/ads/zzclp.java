package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzclp implements zzdti<zzcln> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbai> f15373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbws> f15374c;

    public zzclp(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzbws> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15373b = zzdtuVar2;
        this.f15374c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcln(this.a.get(), this.f15373b.get(), this.f15374c.get());
    }
}
