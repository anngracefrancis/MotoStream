package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzczh {
    private final E a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<zzbbh<?>> f15796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzczf f15797c;

    private zzczh(zzczf zzczfVar, E e2, List<zzbbh<?>> list) {
        this.f15797c = zzczfVar;
        this.a = e2;
        this.f15796b = list;
    }

    public final <O> zzczl<O> a(Callable<O> callable) {
        zzbbc zzbbcVarN = zzbar.n(this.f15796b);
        zzbbh zzbbhVarA = zzbbcVarN.a(eq.f12542f, zzbbm.f14331b);
        zzczf zzczfVar = this.f15797c;
        return new zzczl<>(zzczfVar, this.a, zzbbhVarA, this.f15796b, zzbbcVarN.a(callable, zzczfVar.f15793b));
    }
}
