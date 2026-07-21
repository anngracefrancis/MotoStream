package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxb implements zzdti<zzbxa> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbgz> f14795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxm> f14796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbai> f14797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<Integer> f14798e;

    private zzbxb(zzdtu<Context> zzdtuVar, zzdtu<zzbgz> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzbai> zzdtuVar4, zzdtu<Integer> zzdtuVar5) {
        this.a = zzdtuVar;
        this.f14795b = zzdtuVar2;
        this.f14796c = zzdtuVar3;
        this.f14797d = zzdtuVar4;
        this.f14798e = zzdtuVar5;
    }

    public static zzbxb a(zzdtu<Context> zzdtuVar, zzdtu<zzbgz> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzbai> zzdtuVar4, zzdtu<Integer> zzdtuVar5) {
        return new zzbxb(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbxa(this.a.get(), this.f14795b.get(), this.f14796c.get(), this.f14797d.get(), this.f14798e.get().intValue());
    }
}
