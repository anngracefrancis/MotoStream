package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcrk implements zzcva<Object> {
    private final zzbbh<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f15567b;

    public zzcrk(zzbbh<String> zzbbhVar, Executor executor) {
        this.a = zzbbhVar;
        this.f15567b = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<Object> b() {
        return zzbar.c(this.a, pn.a, this.f15567b);
    }
}
