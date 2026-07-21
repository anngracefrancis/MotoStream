package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcbh implements zzdti<zzcbd> {
    private final zzdtu<Executor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcau> f15013b;

    public zzcbh(zzdtu<Executor> zzdtuVar, zzdtu<zzcau> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15013b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcbd(this.a.get(), this.f15013b.get());
    }
}
