package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcnc implements zzdti<zzcna> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f15429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcdf> f15430c;

    public zzcnc(zzdtu<Context> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<zzcdf> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15429b = zzdtuVar2;
        this.f15430c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcna(this.a.get(), this.f15429b.get(), this.f15430c.get());
    }
}
