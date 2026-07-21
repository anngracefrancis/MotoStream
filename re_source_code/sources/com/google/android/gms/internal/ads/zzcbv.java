package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcbv implements zzdti<zzcbi> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcxv> f15021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Executor> f15022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcdn> f15023d;

    public zzcbv(zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<Executor> zzdtuVar3, zzdtu<zzcdn> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15021b = zzdtuVar2;
        this.f15022c = zzdtuVar3;
        this.f15023d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcbi(this.a.get(), this.f15021b.get(), this.f15022c.get(), this.f15023d.get());
    }
}
