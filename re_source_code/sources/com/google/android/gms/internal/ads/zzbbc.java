package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbbc<V> {
    private final zzbbr<Void> a = new zzbbr<>();

    zzbbc(Iterable<? extends zzbbh<? extends V>> iterable) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzbbh<? extends V> zzbbhVar : iterable) {
            atomicInteger.incrementAndGet();
            zzbar.h(this.a, zzbbhVar);
        }
        if (atomicInteger.get() == 0) {
            this.a.a(null);
            return;
        }
        Iterator<? extends zzbbh<? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            it.next().k(new Runnable(this, atomicInteger) { // from class: com.google.android.gms.internal.ads.y6

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzbbc f13613f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private final AtomicInteger f13614g;

                {
                    this.f13613f = this;
                    this.f13614g = atomicInteger;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f13613f.b(this.f13614g);
                }
            }, zzbbm.f14331b);
        }
    }

    public final <C> zzbbh<C> a(final Callable<C> callable, Executor executor) {
        return zzbar.c(this.a, new zzbal(callable) { // from class: com.google.android.gms.internal.ads.z6
            private final Callable a;

            {
                this.a = callable;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return zzbar.o(this.a.call());
            }
        }, executor);
    }

    final /* synthetic */ void b(AtomicInteger atomicInteger) {
        if (atomicInteger.decrementAndGet() == 0) {
            this.a.a(null);
        }
    }
}
