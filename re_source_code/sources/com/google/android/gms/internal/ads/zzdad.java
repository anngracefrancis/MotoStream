package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdad implements zzdti<zzalr> {
    private final zzdac a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f15822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbai> f15823c;

    public zzdad(zzdac zzdacVar, zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2) {
        this.a = zzdacVar;
        this.f15822b = zzdtuVar;
        this.f15823c = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzalr) zzdto.b(new zzalk().b(this.f15822b.get(), this.f15823c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
