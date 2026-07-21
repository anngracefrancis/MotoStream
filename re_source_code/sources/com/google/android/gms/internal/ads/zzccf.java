package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzccf implements zzdti<zzccd> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbyt> f15050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbzl> f15051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbyn> f15052d;

    private zzccf(zzdtu<Context> zzdtuVar, zzdtu<zzbyt> zzdtuVar2, zzdtu<zzbzl> zzdtuVar3, zzdtu<zzbyn> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15050b = zzdtuVar2;
        this.f15051c = zzdtuVar3;
        this.f15052d = zzdtuVar4;
    }

    public static zzccf a(zzdtu<Context> zzdtuVar, zzdtu<zzbyt> zzdtuVar2, zzdtu<zzbzl> zzdtuVar3, zzdtu<zzbyn> zzdtuVar4) {
        return new zzccf(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzccd(this.a.get(), this.f15050b.get(), this.f15051c.get(), this.f15052d.get());
    }
}
