package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzclu implements zzdti<zzclq> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbws> f15376b;

    public zzclu(zzdtu<Context> zzdtuVar, zzdtu<zzbws> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15376b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzclq(this.a.get(), this.f15376b.get());
    }
}
