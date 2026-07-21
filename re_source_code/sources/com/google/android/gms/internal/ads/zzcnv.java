package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcnv implements zzdti<zzcnl> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbai> f15447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxv> f15448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<Executor> f15449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzcdf> f15450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<zzcdn> f15451f;

    public zzcnv(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<Executor> zzdtuVar4, zzdtu<zzcdf> zzdtuVar5, zzdtu<zzcdn> zzdtuVar6) {
        this.a = zzdtuVar;
        this.f15447b = zzdtuVar2;
        this.f15448c = zzdtuVar3;
        this.f15449d = zzdtuVar4;
        this.f15450e = zzdtuVar5;
        this.f15451f = zzdtuVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcnl(this.a.get(), this.f15447b.get(), this.f15448c.get(), this.f15449d.get(), this.f15450e.get(), this.f15451f.get());
    }
}
