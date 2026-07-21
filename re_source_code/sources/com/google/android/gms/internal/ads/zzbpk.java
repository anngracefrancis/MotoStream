package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbpk {
    private final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ScheduledExecutorService f14666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbbh<zzbph> f14667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f14668d = true;

    public zzbpk(Executor executor, ScheduledExecutorService scheduledExecutorService, zzbbh<zzbph> zzbbhVar) {
        this.a = executor;
        this.f14666b = scheduledExecutorService;
        this.f14667c = zzbbhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(List<? extends zzbbh<? extends zzbpc>> list, final zzban<zzbpc> zzbanVar) {
        if (list == null || list.isEmpty()) {
            this.a.execute(new Runnable(zzbanVar) { // from class: com.google.android.gms.internal.ads.hd

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzban f12713f;

                {
                    this.f12713f = zzbanVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12713f.a(new zzcgm(3));
                }
            });
            return;
        }
        zzbbh zzbbhVarO = zzbar.o(null);
        for (final zzbbh<? extends zzbpc> zzbbhVar : list) {
            zzbbhVarO = zzbar.c(zzbar.e(zzbbhVarO, Throwable.class, new zzbal(zzbanVar) { // from class: com.google.android.gms.internal.ads.id
                private final zzban a;

                {
                    this.a = zzbanVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbal
                public final zzbbh zzf(Object obj) {
                    this.a.a((Throwable) obj);
                    return zzbar.o(null);
                }
            }, this.a), new zzbal(this, zzbanVar, zzbbhVar) { // from class: com.google.android.gms.internal.ads.jd
                private final zzbpk a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final zzban f12824b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private final zzbbh f12825c;

                {
                    this.a = this;
                    this.f12824b = zzbanVar;
                    this.f12825c = zzbbhVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbal
                public final zzbbh zzf(Object obj) {
                    return this.a.b(this.f12824b, this.f12825c, (zzbpc) obj);
                }
            }, this.a);
        }
        zzbar.f(zzbbhVarO, new ld(this, zzbanVar), this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        this.f14668d = false;
    }

    public final boolean a() {
        return this.f14668d;
    }

    final /* synthetic */ zzbbh b(zzban zzbanVar, zzbbh zzbbhVar, zzbpc zzbpcVar) throws Exception {
        if (zzbpcVar != null) {
            zzbanVar.b(zzbpcVar);
        }
        return zzbar.b(zzbbhVar, ((Long) zzyt.e().c(zzacu.e2)).longValue(), TimeUnit.MILLISECONDS, this.f14666b);
    }

    public final void c(zzban<zzbpc> zzbanVar) {
        zzbar.f(this.f14667c, new kd(this, zzbanVar), this.a);
    }
}
