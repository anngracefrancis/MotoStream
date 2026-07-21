package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzazj {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f14299b = Long.MIN_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f14300c = new Object();

    public zzazj(long j2) {
        this.a = j2;
    }

    public final boolean a() {
        synchronized (this.f14300c) {
            long jB = zzk.zzln().b();
            if (this.f14299b + this.a > jB) {
                return false;
            }
            this.f14299b = jB;
            return true;
        }
    }

    public final void b(long j2) {
        synchronized (this.f14300c) {
            this.a = j2;
        }
    }
}
