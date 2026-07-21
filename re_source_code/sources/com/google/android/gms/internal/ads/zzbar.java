package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbar {
    public static <V> zzbbc<V> a(zzbbh<? extends V>... zzbbhVarArr) {
        return n(Arrays.asList(zzbbhVarArr));
    }

    public static <V> zzbbh<V> b(zzbbh<V> zzbbhVar, long j2, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        final zzbbr zzbbrVar = new zzbbr();
        h(zzbbrVar, zzbbhVar);
        final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new Runnable(zzbbrVar) { // from class: com.google.android.gms.internal.ads.t6

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbbr f13347f;

            {
                this.f13347f = zzbbrVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13347f.c(new TimeoutException());
            }
        }, j2, timeUnit);
        g(zzbbhVar, zzbbrVar);
        zzbbrVar.k(new Runnable(scheduledFutureSchedule) { // from class: com.google.android.gms.internal.ads.u6

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final Future f13388f;

            {
                this.f13388f = scheduledFutureSchedule;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Future future = this.f13388f;
                if (future.isDone()) {
                    return;
                }
                future.cancel(true);
            }
        }, zzbbm.f14331b);
        return zzbbrVar;
    }

    public static <A, B> zzbbh<B> c(final zzbbh<A> zzbbhVar, final zzbal<? super A, ? extends B> zzbalVar, Executor executor) {
        final zzbbr zzbbrVar = new zzbbr();
        zzbbhVar.k(new Runnable(zzbbrVar, zzbalVar, zzbbhVar) { // from class: com.google.android.gms.internal.ads.q6

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbbr f13220f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzbal f13221g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final zzbbh f13222h;

            {
                this.f13220f = zzbbrVar;
                this.f13221g = zzbalVar;
                this.f13222h = zzbbhVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbar.i(this.f13220f, this.f13221g, this.f13222h);
            }
        }, executor);
        h(zzbbrVar, zzbbhVar);
        return zzbbrVar;
    }

    public static <A, B> zzbbh<B> d(final zzbbh<A> zzbbhVar, final zzbam<A, B> zzbamVar, Executor executor) {
        final zzbbr zzbbrVar = new zzbbr();
        zzbbhVar.k(new Runnable(zzbbrVar, zzbamVar, zzbbhVar) { // from class: com.google.android.gms.internal.ads.p6

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbbr f13151f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzbam f13152g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final zzbbh f13153h;

            {
                this.f13151f = zzbbrVar;
                this.f13152g = zzbamVar;
                this.f13153h = zzbbhVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbbr zzbbrVar2 = this.f13151f;
                try {
                    zzbbrVar2.a(this.f13152g.a(this.f13153h.get()));
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    zzbbrVar2.c(e2);
                } catch (CancellationException unused) {
                    zzbbrVar2.cancel(true);
                } catch (ExecutionException e3) {
                    e = e3;
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        e = cause;
                    }
                    zzbbrVar2.c(e);
                } catch (Exception e4) {
                    zzbbrVar2.c(e4);
                }
            }
        }, executor);
        h(zzbbrVar, zzbbhVar);
        return zzbbrVar;
    }

    public static <V, X extends Throwable> zzbbh<V> e(final zzbbh<? extends V> zzbbhVar, final Class<X> cls, final zzbal<? super X, ? extends V> zzbalVar, final Executor executor) {
        final zzbbr zzbbrVar = new zzbbr();
        h(zzbbrVar, zzbbhVar);
        zzbbhVar.k(new Runnable(zzbbrVar, zzbbhVar, cls, zzbalVar, executor) { // from class: com.google.android.gms.internal.ads.v6

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbbr f13440f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzbbh f13441g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final Class f13442h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private final zzbal f13443i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private final Executor f13444j;

            {
                this.f13440f = zzbbrVar;
                this.f13441g = zzbbhVar;
                this.f13442h = cls;
                this.f13443i = zzbalVar;
                this.f13444j = executor;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbar.j(this.f13440f, this.f13441g, this.f13442h, this.f13443i, this.f13444j);
            }
        }, zzbbm.f14331b);
        return zzbbrVar;
    }

    public static <V> void f(final zzbbh<V> zzbbhVar, final zzban<? super V> zzbanVar, Executor executor) {
        zzbbhVar.k(new Runnable(zzbanVar, zzbbhVar) { // from class: com.google.android.gms.internal.ads.o6

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzban f13088f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzbbh f13089g;

            {
                this.f13088f = zzbanVar;
                this.f13089g = zzbbhVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzban zzbanVar2 = this.f13088f;
                try {
                    zzbanVar2.b(this.f13089g.get());
                } catch (InterruptedException e2) {
                    e = e2;
                    Thread.currentThread().interrupt();
                    zzbanVar2.a(e);
                } catch (ExecutionException e3) {
                    e = e3.getCause();
                    zzbanVar2.a(e);
                } catch (Exception e4) {
                    e = e4;
                    zzbanVar2.a(e);
                }
            }
        }, executor);
    }

    private static <V> void g(final zzbbh<? extends V> zzbbhVar, final zzbbr<V> zzbbrVar) {
        h(zzbbrVar, zzbbhVar);
        zzbbhVar.k(new Runnable(zzbbrVar, zzbbhVar) { // from class: com.google.android.gms.internal.ads.w6

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbbr f13497f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzbbh f13498g;

            {
                this.f13497f = zzbbrVar;
                this.f13498g = zzbbhVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbbr zzbbrVar2 = this.f13497f;
                try {
                    zzbbrVar2.a(this.f13498g.get());
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    zzbbrVar2.c(e2);
                } catch (ExecutionException e3) {
                    zzbbrVar2.c(e3.getCause());
                } catch (Exception e4) {
                    zzbbrVar2.c(e4);
                }
            }
        }, zzbbm.f14331b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <A, B> void h(final zzbbh<A> zzbbhVar, final Future<B> future) {
        zzbbhVar.k(new Runnable(zzbbhVar, future) { // from class: com.google.android.gms.internal.ads.x6

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbbh f13561f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final Future f13562g;

            {
                this.f13561f = zzbbhVar;
                this.f13562g = future;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbbh zzbbhVar2 = this.f13561f;
                Future future2 = this.f13562g;
                if (zzbbhVar2.isCancelled()) {
                    future2.cancel(true);
                }
            }
        }, zzbbm.f14331b);
    }

    static final /* synthetic */ void i(zzbbr zzbbrVar, zzbal zzbalVar, zzbbh zzbbhVar) {
        if (zzbbrVar.isCancelled()) {
            return;
        }
        try {
            g(zzbalVar.zzf(zzbbhVar.get()), zzbbrVar);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            zzbbrVar.c(e2);
        } catch (CancellationException unused) {
            zzbbrVar.cancel(true);
        } catch (ExecutionException e3) {
            zzbbrVar.c(e3.getCause());
        } catch (Exception e4) {
            zzbbrVar.c(e4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001e  */
    /* JADX WARN: Code duplicated, block: B:14:0x002a  */
    static final /* synthetic */ void j(zzbbr zzbbrVar, zzbbh zzbbhVar, Class cls, zzbal zzbalVar, Executor executor) {
        try {
            zzbbrVar.a(zzbbhVar.get());
        } catch (InterruptedException e2) {
            e = e2;
            Thread.currentThread().interrupt();
            if (cls.isInstance(e)) {
                g(c(o(e), zzbalVar, executor), zzbbrVar);
            } else {
                zzbbrVar.c(e);
            }
        } catch (ExecutionException e3) {
            e = e3.getCause();
            if (cls.isInstance(e)) {
                g(c(o(e), zzbalVar, executor), zzbbrVar);
            } else {
                zzbbrVar.c(e);
            }
        } catch (Exception e4) {
            e = e4;
            if (cls.isInstance(e)) {
                g(c(o(e), zzbalVar, executor), zzbbrVar);
            } else {
                zzbbrVar.c(e);
            }
        }
    }

    public static <T> a7<T> l(Throwable th) {
        return new a7<>(th);
    }

    public static <V> zzbbh<List<V>> m(final Iterable<? extends zzbbh<? extends V>> iterable) {
        final zzbbr zzbbrVar = new zzbbr();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzbbh<? extends V> zzbbhVar : iterable) {
            atomicInteger.incrementAndGet();
            h(zzbbrVar, zzbbhVar);
        }
        final Runnable runnable = new Runnable(iterable, zzbbrVar) { // from class: com.google.android.gms.internal.ads.r6

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final Iterable f13262f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzbbr f13263g;

            {
                this.f13262f = iterable;
                this.f13263g = zzbbrVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterable iterable2 = this.f13262f;
                zzbbr zzbbrVar2 = this.f13263g;
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable2.iterator();
                while (it.hasNext()) {
                    try {
                        arrayList.add(((zzbbh) it.next()).get());
                    } catch (InterruptedException e2) {
                        e = e2;
                        zzbbrVar2.c(e);
                    } catch (ExecutionException e3) {
                        zzbbrVar2.c(e3.getCause());
                    } catch (Exception e4) {
                        e = e4;
                        zzbbrVar2.c(e);
                    }
                }
                zzbbrVar2.a(arrayList);
            }
        };
        for (final zzbbh<? extends V> zzbbhVar2 : iterable) {
            zzbbhVar2.k(new Runnable(zzbbhVar2, atomicInteger, runnable, zzbbrVar) { // from class: com.google.android.gms.internal.ads.s6

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzbbh f13312f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private final AtomicInteger f13313g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                private final Runnable f13314h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                private final zzbbr f13315i;

                {
                    this.f13312f = zzbbhVar2;
                    this.f13313g = atomicInteger;
                    this.f13314h = runnable;
                    this.f13315i = zzbbrVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbbh zzbbhVar3 = this.f13312f;
                    AtomicInteger atomicInteger2 = this.f13313g;
                    Runnable runnable2 = this.f13314h;
                    zzbbr zzbbrVar2 = this.f13315i;
                    try {
                        zzbbhVar3.get();
                        if (atomicInteger2.decrementAndGet() == 0) {
                            runnable2.run();
                        }
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        zzbbrVar2.c(e2);
                    } catch (ExecutionException e3) {
                        zzbbrVar2.c(e3.getCause());
                    } catch (Exception e4) {
                        zzbbrVar2.c(e4);
                    }
                }
            }, zzbbm.f14331b);
        }
        return zzbbrVar;
    }

    public static <V> zzbbc<V> n(Iterable<? extends zzbbh<? extends V>> iterable) {
        return new zzbbc<>(iterable);
    }

    public static <T> b7<T> o(T t) {
        return new b7<>(t);
    }
}
