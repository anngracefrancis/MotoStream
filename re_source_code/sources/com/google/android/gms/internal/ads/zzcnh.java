package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcnh implements zzdti<zzcnd> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcdf> f15432b;

    public zzcnh(zzdtu<Context> zzdtuVar, zzdtu<zzcdf> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15432b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcnd(this.a.get(), this.f15432b.get());
    }
}
