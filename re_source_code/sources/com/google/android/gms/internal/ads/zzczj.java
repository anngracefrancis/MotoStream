package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzczj {
    private final E a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzczf f15798b;

    private zzczj(zzczf zzczfVar, E e2) {
        this.f15798b = zzczfVar;
        this.a = e2;
    }

    private final <O> zzczl<O> b(Callable<O> callable, zzbbl zzbblVar) {
        return new zzczl<>(this.f15798b, this.a, zzczf.a, Collections.emptyList(), zzbblVar.submit(callable));
    }

    public final zzczl<?> a(final zzczd zzczdVar, zzbbl zzbblVar) {
        return b(new Callable(zzczdVar) { // from class: com.google.android.gms.internal.ads.fq

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzczd f12605f;

            {
                this.f12605f = zzczdVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.f12605f.run();
                return null;
            }
        }, zzbblVar);
    }

    public final <O> zzczl<O> c(zzbbh<O> zzbbhVar) {
        return new zzczl<>(this.f15798b, this.a, zzczf.a, Collections.emptyList(), zzbbhVar);
    }

    public final <O> zzczl<O> d(Callable<O> callable) {
        return b(callable, this.f15798b.f15793b);
    }
}
