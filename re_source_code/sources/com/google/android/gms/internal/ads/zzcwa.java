package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwa implements zzdti<zzcvy> {
    private final zzdtu<zzasc> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f15697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<String> f15698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbbl> f15699d;

    public zzcwa(zzdtu<zzasc> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<String> zzdtuVar3, zzdtu<zzbbl> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15697b = zzdtuVar2;
        this.f15698c = zzdtuVar3;
        this.f15699d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcvy(this.a.get(), this.f15697b.get(), this.f15698c.get(), this.f15699d.get());
    }
}
