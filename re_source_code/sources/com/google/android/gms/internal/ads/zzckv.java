package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class zzckv implements zzcjv<zzbnf> {
    private final zzboc a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzckb f15338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbbl f15339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbrm f15340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ScheduledExecutorService f15341e;

    public zzckv(zzboc zzbocVar, zzckb zzckbVar, zzbrm zzbrmVar, ScheduledExecutorService scheduledExecutorService, zzbbl zzbblVar) {
        this.a = zzbocVar;
        this.f15338b = zzckbVar;
        this.f15340d = zzbrmVar;
        this.f15341e = scheduledExecutorService;
        this.f15339c = zzbblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<zzbnf> a(final zzcxu zzcxuVar, final zzcxm zzcxmVar) {
        return this.f15339c.submit(new Callable(this, zzcxuVar, zzcxmVar) { // from class: com.google.android.gms.internal.ads.rk

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzckv f13278f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzcxu f13279g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final zzcxm f13280h;

            {
                this.f13278f = this;
                this.f13279g = zzcxuVar;
                this.f13280h = zzcxmVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f13278f.d(this.f13279g, this.f13280h);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean b(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return zzcxuVar.a.a.a() != null && this.f15338b.b(zzcxuVar, zzcxmVar);
    }

    final /* synthetic */ zzbnf d(final zzcxu zzcxuVar, final zzcxm zzcxmVar) throws Exception {
        return this.a.b(new zzbpr(zzcxuVar, zzcxmVar, null), new zzbop(zzcxuVar.a.a.a(), new Runnable(this, zzcxuVar, zzcxmVar) { // from class: com.google.android.gms.internal.ads.sk

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzckv f13327f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzcxu f13328g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final zzcxm f13329h;

            {
                this.f13327f = this;
                this.f13328g = zzcxuVar;
                this.f13329h = zzcxmVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13327f.e(this.f13328g, this.f13329h);
            }
        })).a();
    }

    final /* synthetic */ void e(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        zzbar.f(zzbar.b(this.f15338b.a(zzcxuVar, zzcxmVar), zzcxmVar.I, TimeUnit.SECONDS, this.f15341e), new tk(this), this.f15339c);
    }
}
