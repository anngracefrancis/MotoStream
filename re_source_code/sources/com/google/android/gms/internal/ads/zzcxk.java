package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcxk {
    private final Clock a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f15721b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f15722c = wp.a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile long f15723d = 0;

    public zzcxk(Clock clock) {
        this.a = clock;
    }

    private final void a() {
        long jA = this.a.a();
        synchronized (this.f15721b) {
            if (this.f15722c == wp.f13519c) {
                if (this.f15723d + ((Long) zzyt.e().c(zzacu.L4)).longValue() <= jA) {
                    this.f15722c = wp.a;
                }
            }
        }
    }

    private final void e(int i2, int i3) {
        a();
        long jA = this.a.a();
        synchronized (this.f15721b) {
            if (this.f15722c != i2) {
                return;
            }
            this.f15722c = i3;
            if (this.f15722c == wp.f13519c) {
                this.f15723d = jA;
            }
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this.f15721b) {
            a();
            z = this.f15722c == wp.f13518b;
        }
        return z;
    }

    public final boolean c() {
        boolean z;
        synchronized (this.f15721b) {
            a();
            z = this.f15722c == wp.f13519c;
        }
        return z;
    }

    public final void d(boolean z) {
        if (z) {
            e(wp.a, wp.f13518b);
        } else {
            e(wp.f13518b, wp.a);
        }
    }

    public final void f() {
        e(wp.f13518b, wp.f13519c);
    }
}
