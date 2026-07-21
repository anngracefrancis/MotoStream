package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class zzv {
    private final AtomicInteger a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<zzr<?>> f16831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PriorityBlockingQueue<zzr<?>> f16832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PriorityBlockingQueue<zzr<?>> f16833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzb f16834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzm f16835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzab f16836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzn[] f16837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzd f16838i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<zzx> f16839j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<zzw> f16840k;

    private zzv(zzb zzbVar, zzm zzmVar, int i2, zzab zzabVar) {
        this.a = new AtomicInteger();
        this.f16831b = new HashSet();
        this.f16832c = new PriorityBlockingQueue<>();
        this.f16833d = new PriorityBlockingQueue<>();
        this.f16839j = new ArrayList();
        this.f16840k = new ArrayList();
        this.f16834e = zzbVar;
        this.f16835f = zzmVar;
        this.f16837h = new zzn[4];
        this.f16836g = zzabVar;
    }

    public final void a() {
        zzd zzdVar = this.f16838i;
        if (zzdVar != null) {
            zzdVar.b();
        }
        for (zzn zznVar : this.f16837h) {
            if (zznVar != null) {
                zznVar.b();
            }
        }
        zzd zzdVar2 = new zzd(this.f16832c, this.f16833d, this.f16834e, this.f16836g);
        this.f16838i = zzdVar2;
        zzdVar2.start();
        for (int i2 = 0; i2 < this.f16837h.length; i2++) {
            zzn zznVar2 = new zzn(this.f16833d, this.f16835f, this.f16834e, this.f16836g);
            this.f16837h[i2] = zznVar2;
            zznVar2.start();
        }
    }

    final void b(zzr<?> zzrVar, int i2) {
        synchronized (this.f16840k) {
            Iterator<zzw> it = this.f16840k.iterator();
            while (it.hasNext()) {
                it.next().a(zzrVar, i2);
            }
        }
    }

    public final <T> zzr<T> c(zzr<T> zzrVar) {
        zzrVar.x(this);
        synchronized (this.f16831b) {
            this.f16831b.add(zzrVar);
        }
        zzrVar.G(this.a.incrementAndGet());
        zzrVar.I("add-to-queue");
        b(zzrVar, 0);
        if (zzrVar.P()) {
            this.f16832c.add(zzrVar);
            return zzrVar;
        }
        this.f16833d.add(zzrVar);
        return zzrVar;
    }

    final <T> void d(zzr<T> zzrVar) {
        synchronized (this.f16831b) {
            this.f16831b.remove(zzrVar);
        }
        synchronized (this.f16839j) {
            Iterator<zzx> it = this.f16839j.iterator();
            while (it.hasNext()) {
                it.next().a(zzrVar);
            }
        }
        b(zzrVar, 5);
    }

    private zzv(zzb zzbVar, zzm zzmVar, int i2) {
        this(zzbVar, zzmVar, 4, new zzi(new Handler(Looper.getMainLooper())));
    }

    public zzv(zzb zzbVar, zzm zzmVar) {
        this(zzbVar, zzmVar, 4);
    }
}
