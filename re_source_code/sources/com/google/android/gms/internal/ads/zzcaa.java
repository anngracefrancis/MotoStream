package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcaa implements zzdti<zzbzt> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcdn> f14953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzccj> f14954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbmy> f14955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzbzb> f14956e;

    public zzcaa(zzdtu<Context> zzdtuVar, zzdtu<zzcdn> zzdtuVar2, zzdtu<zzccj> zzdtuVar3, zzdtu<zzbmy> zzdtuVar4, zzdtu<zzbzb> zzdtuVar5) {
        this.a = zzdtuVar;
        this.f14953b = zzdtuVar2;
        this.f14954c = zzdtuVar3;
        this.f14955d = zzdtuVar4;
        this.f14956e = zzdtuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbzt(this.a.get(), this.f14953b.get(), this.f14954c.get(), this.f14955d.get(), this.f14956e.get());
    }
}
