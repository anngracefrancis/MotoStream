package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcpj implements zzdti<zzcpf> {
    private final zzdtu<zzclc> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f15493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Context> f15494c;

    public zzcpj(zzdtu<zzclc> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<Context> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15493b = zzdtuVar2;
        this.f15494c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcpf(this.a.get(), this.f15493b.get(), this.f15494c.get());
    }
}
