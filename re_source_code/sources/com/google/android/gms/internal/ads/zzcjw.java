package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcjw<DelegateT, AdapterT> implements zzcjv<AdapterT> {

    @VisibleForTesting
    private final zzcjv<DelegateT> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbam<DelegateT, AdapterT> f15311b;

    public zzcjw(zzcjv<DelegateT> zzcjvVar, zzbam<DelegateT, AdapterT> zzbamVar) {
        this.a = zzcjvVar;
        this.f15311b = zzbamVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<AdapterT> a(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return zzbar.d(this.a.a(zzcxuVar, zzcxmVar), this.f15311b, zzaxg.a);
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean b(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return this.a.b(zzcxuVar, zzcxmVar);
    }
}
