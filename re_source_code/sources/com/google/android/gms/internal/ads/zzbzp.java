package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbzp implements zzdti<zzbzl> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzaxb> f14928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxv> f14929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbyx> f14930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzbyt> f14931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<zzbzt> f14932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzdtu<Executor> f14933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzdtu<Executor> f14934h;

    private zzbzp(zzdtu<Context> zzdtuVar, zzdtu<zzaxb> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<zzbyx> zzdtuVar4, zzdtu<zzbyt> zzdtuVar5, zzdtu<zzbzt> zzdtuVar6, zzdtu<Executor> zzdtuVar7, zzdtu<Executor> zzdtuVar8) {
        this.a = zzdtuVar;
        this.f14928b = zzdtuVar2;
        this.f14929c = zzdtuVar3;
        this.f14930d = zzdtuVar4;
        this.f14931e = zzdtuVar5;
        this.f14932f = zzdtuVar6;
        this.f14933g = zzdtuVar7;
        this.f14934h = zzdtuVar8;
    }

    public static zzbzp a(zzdtu<Context> zzdtuVar, zzdtu<zzaxb> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<zzbyx> zzdtuVar4, zzdtu<zzbyt> zzdtuVar5, zzdtu<zzbzt> zzdtuVar6, zzdtu<Executor> zzdtuVar7, zzdtu<Executor> zzdtuVar8) {
        return new zzbzp(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6, zzdtuVar7, zzdtuVar8);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbzl(this.a.get(), this.f14928b.get(), this.f14929c.get(), this.f14930d.get(), this.f14931e.get(), this.f14932f.get(), this.f14933g.get(), this.f14934h.get());
    }
}
