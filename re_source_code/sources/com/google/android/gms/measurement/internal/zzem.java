package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class zzem<V> {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e3<V> f18085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final V f18086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final V f18087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f18088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile V f18089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile V f18090h;

    private zzem(String str, V v, V v2, e3<V> e3Var) {
        this.f18088f = new Object();
        this.f18089g = null;
        this.f18090h = null;
        this.f18084b = str;
        this.f18086d = v;
        this.f18087e = v2;
        this.f18085c = e3Var;
    }

    public final V a(V v) {
        synchronized (this.f18088f) {
        }
        if (v != null) {
            return v;
        }
        if (zzap.a == null) {
            return this.f18086d;
        }
        synchronized (a) {
            if (zzw.a()) {
                return this.f18090h == null ? this.f18086d : this.f18090h;
            }
            if (zzw.a()) {
                throw new IllegalStateException("Tried to refresh flag cache on main thread or on package side.");
            }
            zzw zzwVar = zzap.a;
            try {
                for (zzem zzemVar : zzap.f18071b) {
                    synchronized (a) {
                        if (zzw.a()) {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                        try {
                            e3<V> e3Var = zzemVar.f18085c;
                            zzemVar.f18090h = e3Var != null ? e3Var.a() : null;
                        } catch (IllegalStateException unused) {
                            zzemVar.f18090h = null;
                        }
                        throw th;
                    }
                }
            } catch (SecurityException e2) {
                zzap.f(e2);
            }
            e3<V> e3Var2 = this.f18085c;
            if (e3Var2 == null) {
                zzw zzwVar2 = zzap.a;
                return this.f18086d;
            }
            try {
                return e3Var2.a();
            } catch (IllegalStateException unused2) {
                zzw zzwVar3 = zzap.a;
                return this.f18086d;
            } catch (SecurityException e3) {
                zzap.f(e3);
                zzw zzwVar4 = zzap.a;
                return this.f18086d;
            }
        }
    }

    public final String b() {
        return this.f18084b;
    }
}
