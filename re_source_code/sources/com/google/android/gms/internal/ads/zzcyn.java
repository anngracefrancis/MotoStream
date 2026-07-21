package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcyn implements zzdti<zzcyk> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbai> f15782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzawm> f15783c;

    public zzcyn(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzawm> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15782b = zzdtuVar2;
        this.f15783c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcyk(this.a.get(), this.f15782b.get(), this.f15783c.get());
    }
}
