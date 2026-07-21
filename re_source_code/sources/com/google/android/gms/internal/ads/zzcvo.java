package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcvo implements zzcva<zzcvn> {
    private final zzawi a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f15686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Executor f15687d;

    public zzcvo(zzawi zzawiVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.a = zzawiVar;
        this.f15685b = context;
        this.f15686c = scheduledExecutorService;
        this.f15687d = executor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ void a(zzbbh zzbbhVar, zzbbr zzbbrVar) {
        String strM;
        try {
            AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) zzbbhVar.get();
            if (info == null || !TextUtils.isEmpty(info.getId())) {
                strM = null;
            } else {
                zzyt.a();
                strM = zzazt.m(this.f15685b);
            }
            zzbbrVar.a(new zzcvn(info, this.f15685b, strM));
        } catch (InterruptedException | CancellationException | ExecutionException unused) {
            zzyt.a();
            zzbbrVar.a(new zzcvn(null, this.f15685b, zzazt.m(this.f15685b)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcvn> b() {
        if (!((Boolean) zzyt.e().c(zzacu.g1)).booleanValue()) {
            return zzbar.l(new Exception("Did not ad Ad ID into query param."));
        }
        final zzbbr zzbbrVar = new zzbbr();
        final zzbbh<AdvertisingIdClient.Info> zzbbhVarA = this.a.a(this.f15685b);
        zzbbhVarA.k(new Runnable(this, zzbbhVarA, zzbbrVar) { // from class: com.google.android.gms.internal.ads.fp

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcvo f12602f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzbbh f12603g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final zzbbr f12604h;

            {
                this.f12602f = this;
                this.f12603g = zzbbhVarA;
                this.f12604h = zzbbrVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12602f.a(this.f12603g, this.f12604h);
            }
        }, this.f15687d);
        this.f15686c.schedule(new Runnable(zzbbhVarA) { // from class: com.google.android.gms.internal.ads.gp

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbbh f12657f;

            {
                this.f12657f = zzbbhVarA;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12657f.cancel(true);
            }
        }, ((Long) zzyt.e().c(zzacu.h1)).longValue(), TimeUnit.MILLISECONDS);
        return zzbbrVar;
    }
}
