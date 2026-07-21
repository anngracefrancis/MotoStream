package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class zzchl extends zzchj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f15239b = Pattern.compile("Received error HTTP response code: (.*)");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcgn f15240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbbl f15241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzcxv f15242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ScheduledExecutorService f15243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcji f15244g;

    zzchl(zzbtg zzbtgVar, zzcxv zzcxvVar, zzcgn zzcgnVar, zzbbl zzbblVar, ScheduledExecutorService scheduledExecutorService, zzcji zzcjiVar) {
        super(zzbtgVar);
        this.f15242e = zzcxvVar;
        this.f15240c = zzcgnVar;
        this.f15241d = zzbblVar;
        this.f15243f = scheduledExecutorService;
        this.f15244g = zzcjiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzchj
    public final zzbbh<zzcxu> c(zzarx zzarxVar) throws zzcgm {
        zzbbh<zzcxu> zzbbhVarC = zzbar.c(this.f15240c.b(zzarxVar), new zzbal(this) { // from class: com.google.android.gms.internal.ads.bj
            private final zzchl a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.f((InputStream) obj);
            }
        }, this.f15241d);
        if (((Boolean) zzyt.e().c(zzacu.t4)).booleanValue()) {
            zzbbhVarC = zzbar.e(zzbar.b(zzbbhVarC, ((Integer) zzyt.e().c(zzacu.u4)).intValue(), TimeUnit.SECONDS, this.f15243f), TimeoutException.class, cj.a, zzbbm.f14331b);
        }
        zzbar.f(zzbbhVarC, new dj(this), zzbbm.f14331b);
        return zzbbhVarC;
    }

    final /* synthetic */ zzbbh f(InputStream inputStream) throws Exception {
        return zzbar.o(new zzcxu(new zzcxr(this.f15242e), zzcxs.a(new InputStreamReader(inputStream))));
    }
}
