package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcrn implements zzdti<zzcrk> {
    private final zzdtu<zzbbh<String>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f15568b;

    private zzcrn(zzdtu<zzbbh<String>> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15568b = zzdtuVar2;
    }

    public static zzcrn a(zzdtu<zzbbh<String>> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcrn(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcrk(this.a.get(), this.f15568b.get());
    }
}
