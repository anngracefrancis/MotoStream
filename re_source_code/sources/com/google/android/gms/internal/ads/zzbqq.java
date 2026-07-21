package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqq {
    public static <T> zzbbh<T> a(zzczt zzcztVar, zzbbh<zzcxu> zzbbhVar, zzblq zzblqVar, zzcmx<T> zzcmxVar) {
        if (((Boolean) zzyt.e().c(zzacu.t4)).booleanValue()) {
            return zzcztVar.c(zzczs.RENDERER, zzbbhVar).b(zzblqVar).b(zzcmxVar).f();
        }
        return zzcztVar.c(zzczs.RENDERER, zzbbhVar).b(zzblqVar).b(zzcmxVar).a(((Integer) zzyt.e().c(zzacu.u4)).intValue(), TimeUnit.SECONDS).f();
    }
}
