package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcfp {
    public static Set<zzbuz<zzbrx>> a(zzcfz zzcfzVar, Executor executor) {
        return d(zzcfzVar, executor);
    }

    public static Set<zzbuz<AppEventListener>> b(zzcfz zzcfzVar, Executor executor) {
        return d(zzcfzVar, executor);
    }

    public static Set<zzbuz<zzbsr>> c(zzcfz zzcfzVar, Executor executor) {
        return d(zzcfzVar, executor);
    }

    private static <T> Set<zzbuz<T>> d(T t, Executor executor) {
        return ((Boolean) zzyt.e().c(zzacu.N1)).booleanValue() ? Collections.singleton(new zzbuz(t, executor)) : Collections.emptySet();
    }

    public static Set<zzbuz<zzbro>> e(zzcfz zzcfzVar, Executor executor) {
        return d(zzcfzVar, executor);
    }

    public static Set<zzbuz<zzbrl>> f(zzcfz zzcfzVar, Executor executor) {
        return d(zzcfzVar, executor);
    }

    public static Set<zzbuz<zzbrw>> g(zzcfz zzcfzVar, Executor executor) {
        return d(zzcfzVar, executor);
    }

    public static Set<zzbuz<zzxr>> h(zzcfz zzcfzVar, Executor executor) {
        return d(zzcfzVar, executor);
    }

    public static Set<zzbuz<zzczz>> i(zzcfz zzcfzVar, Executor executor) {
        return d(zzcfzVar, executor);
    }

    public static Set<zzbuz<zzbtk>> j(zzcfz zzcfzVar, Executor executor) {
        return d(zzcfzVar, executor);
    }
}
