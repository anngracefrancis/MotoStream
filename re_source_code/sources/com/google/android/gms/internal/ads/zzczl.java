package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class zzczl<O> {
    private final E a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbbh<?> f15800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<zzbbh<?>> f15801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbbh<O> f15802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zzczf f15803f;

    private zzczl(zzczf zzczfVar, E e2, String str, zzbbh<?> zzbbhVar, List<zzbbh<?>> list, zzbbh<O> zzbbhVar2) {
        this.f15803f = zzczfVar;
        this.a = e2;
        this.f15799b = str;
        this.f15800c = zzbbhVar;
        this.f15801d = list;
        this.f15802e = zzbbhVar2;
    }

    private final <O2> zzczl<O2> c(zzbal<O, O2> zzbalVar, Executor executor) {
        return new zzczl<>(this.f15803f, this.a, this.f15799b, this.f15800c, this.f15801d, zzbar.c(this.f15802e, zzbalVar, executor));
    }

    public final zzczl<O> a(long j2, TimeUnit timeUnit) {
        zzczf zzczfVar = this.f15803f;
        return new zzczl<>(zzczfVar, this.a, this.f15799b, this.f15800c, this.f15801d, zzbar.b(this.f15802e, j2, timeUnit, zzczfVar.f15794c));
    }

    public final <O2> zzczl<O2> b(zzbal<O, O2> zzbalVar) {
        return c(zzbalVar, this.f15803f.f15793b);
    }

    public final <T extends Throwable> zzczl<O> d(Class<T> cls, zzbal<T, O> zzbalVar) {
        zzczf zzczfVar = this.f15803f;
        return new zzczl<>(zzczfVar, this.a, this.f15799b, this.f15800c, this.f15801d, zzbar.e(this.f15802e, cls, zzbalVar, zzczfVar.f15793b));
    }

    public final <T extends Throwable> zzczl<O> e(Class<T> cls, final zzczc<T, O> zzczcVar) {
        return d(cls, new zzbal(zzczcVar) { // from class: com.google.android.gms.internal.ads.iq
            private final zzczc a;

            {
                this.a = zzczcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return zzbar.o(this.a.a((Throwable) obj));
            }
        });
    }

    public final zzcze<E, O> f() {
        E e2 = this.a;
        String strH = this.f15799b;
        if (strH == null) {
            strH = this.f15803f.h(e2);
        }
        final zzcze<E, O> zzczeVar = new zzcze<>(e2, strH, this.f15802e);
        this.f15803f.f15795d.M(zzczeVar);
        zzbbh<?> zzbbhVar = this.f15800c;
        Runnable runnable = new Runnable(this, zzczeVar) { // from class: com.google.android.gms.internal.ads.jq

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzczl f12838f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzcze f12839g;

            {
                this.f12838f = this;
                this.f12839g = zzczeVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzczl zzczlVar = this.f12838f;
                zzczlVar.f15803f.f15795d.L(this.f12839g);
            }
        };
        Executor executor = zzbbm.f14331b;
        zzbbhVar.k(runnable, executor);
        zzbar.f(zzczeVar, new kq(this, zzczeVar), executor);
        return zzczeVar;
    }

    public final <O2> zzczl<O2> g(final zzbbh<O2> zzbbhVar) {
        return c(new zzbal(zzbbhVar) { // from class: com.google.android.gms.internal.ads.hq
            private final zzbbh a;

            {
                this.a = zzbbhVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a;
            }
        }, zzbbm.f14331b);
    }

    public final <O2> zzczl<O2> h(final zzczc<O, O2> zzczcVar) {
        return b(new zzbal(zzczcVar) { // from class: com.google.android.gms.internal.ads.gq
            private final zzczc a;

            {
                this.a = zzczcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return zzbar.o(this.a.a(obj));
            }
        });
    }

    public final zzczl<O> i(String str) {
        return new zzczl<>(this.f15803f, this.a, str, this.f15800c, this.f15801d, this.f15802e);
    }

    public final zzczl<O> j(E e2) {
        return this.f15803f.c(e2, f());
    }
}
