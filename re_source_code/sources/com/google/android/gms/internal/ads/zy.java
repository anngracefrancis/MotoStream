package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
final class zy {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f13723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f13724c;

    zy() {
    }

    private static long d(long j2) {
        return (SystemClock.elapsedRealtime() * 1000) - j2;
    }

    public final void a() {
        if (this.a) {
            return;
        }
        this.a = true;
        this.f13724c = d(this.f13723b);
    }

    public final void b() {
        if (this.a) {
            this.f13723b = d(this.f13724c);
            this.a = false;
        }
    }

    public final void c(long j2) {
        this.f13723b = j2;
        this.f13724c = d(j2);
    }

    public final long e() {
        return this.a ? d(this.f13724c) : this.f13723b;
    }
}
