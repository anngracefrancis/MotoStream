package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzclm implements zzdti<zzcle> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbai> f15366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxv> f15367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<Executor> f15368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzbws> f15369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<zzcdn> f15370f;

    public zzclm(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<Executor> zzdtuVar4, zzdtu<zzbws> zzdtuVar5, zzdtu<zzcdn> zzdtuVar6) {
        this.a = zzdtuVar;
        this.f15366b = zzdtuVar2;
        this.f15367c = zzdtuVar3;
        this.f15368d = zzdtuVar4;
        this.f15369e = zzdtuVar5;
        this.f15370f = zzdtuVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcle(this.a.get(), this.f15366b.get(), this.f15367c.get(), this.f15368d.get(), this.f15369e.get(), this.f15370f.get());
    }
}
