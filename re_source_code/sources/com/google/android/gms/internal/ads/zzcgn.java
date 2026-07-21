package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcgn {
    private final zzbbl a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbbl f15209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzchv f15210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdte<zzcig> f15211d;

    public zzcgn(zzbbl zzbblVar, zzbbl zzbblVar2, zzchv zzchvVar, zzdte<zzcig> zzdteVar) {
        this.a = zzbblVar;
        this.f15209b = zzbblVar2;
        this.f15210c = zzchvVar;
        this.f15211d = zzdteVar;
    }

    final /* synthetic */ zzbbh a(zzarx zzarxVar, zzcie zzcieVar) throws Exception {
        return this.f15211d.get().j7(zzarxVar);
    }

    public final zzbbh<InputStream> b(final zzarx zzarxVar) {
        final zzbbh<InputStream> zzbbhVarE;
        String str = zzarxVar.f14107i;
        zzk.zzlg();
        if (zzaxi.V(str)) {
            zzbbhVarE = zzbar.l(new zzcie(0));
        } else {
            zzbbhVarE = ((Boolean) zzyt.e().c(zzacu.v4)).booleanValue() ? zzbar.e(this.a.submit(new Callable(this, zzarxVar) { // from class: com.google.android.gms.internal.ads.si

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzcgn f13325f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private final zzarx f13326g;

                {
                    this.f13325f = this;
                    this.f13326g = zzarxVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f13325f.c(this.f13326g);
                }
            }), ExecutionException.class, ti.a, this.f15209b) : this.f15210c.b(zzarxVar);
        }
        zzbbh<InputStream> zzbbhVarE2 = zzbar.e(zzbbhVarE, zzcie.class, new zzbal(this, zzarxVar) { // from class: com.google.android.gms.internal.ads.ui
            private final zzcgn a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final zzarx f13398b;

            {
                this.a = this;
                this.f13398b = zzarxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.a(this.f13398b, (zzcie) obj);
            }
        }, this.f15209b);
        if (!((Boolean) zzyt.e().c(zzacu.v4)).booleanValue()) {
            zzbbhVarE2.k(new Runnable(zzbbhVarE) { // from class: com.google.android.gms.internal.ads.vi

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzbbh f13457f;

                {
                    this.f13457f = zzbbhVarE;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f13457f.cancel(true);
                }
            }, zzbbm.f14331b);
        }
        return zzbbhVarE2;
    }

    final /* synthetic */ InputStream c(zzarx zzarxVar) throws Exception {
        return this.f15210c.b(zzarxVar).get(((Integer) zzyt.e().c(zzacu.u4)).intValue(), TimeUnit.SECONDS);
    }
}
