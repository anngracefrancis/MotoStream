package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
final class x4 {
    private final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f13553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f13554c;

    private x4() {
        this.a = new Object();
        this.f13553b = y4.a;
        this.f13554c = 0L;
    }

    public final void a() {
        int i2;
        long jA = zzk.zzln().a();
        synchronized (this.a) {
            int i3 = this.f13553b;
            i2 = y4.f13609b;
            if (i3 == i2) {
                if (this.f13554c + ((Long) zzyt.e().c(zzacu.L4)).longValue() <= jA) {
                    this.f13553b = y4.a;
                }
            }
        }
        long jA2 = zzk.zzln().a();
        synchronized (this.a) {
            if (this.f13553b != 2) {
                return;
            }
            this.f13553b = 3;
            if (this.f13553b == i2) {
                this.f13554c = jA2;
            }
        }
    }

    /* synthetic */ x4(w4 w4Var) {
        this();
    }
}
