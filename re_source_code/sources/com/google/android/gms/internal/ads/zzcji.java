package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcji {
    private int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f15291b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f15292c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f15293d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f15294e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f15295f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f15296g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f15297h = new Object();

    public final int a() {
        int i2;
        synchronized (this.f15294e) {
            i2 = this.a;
        }
        return i2;
    }

    public final long b() {
        long j2;
        synchronized (this.f15295f) {
            j2 = this.f15291b;
        }
        return j2;
    }

    public final synchronized long c() {
        long j2;
        synchronized (this.f15296g) {
            j2 = this.f15292c;
        }
        return j2;
    }

    public final synchronized long d() {
        long j2;
        synchronized (this.f15297h) {
            j2 = this.f15293d;
        }
        return j2;
    }

    public final void e(int i2) {
        synchronized (this.f15294e) {
            this.a = i2;
        }
    }

    public final void f(long j2) {
        synchronized (this.f15295f) {
            this.f15291b = j2;
        }
    }

    public final synchronized void g(long j2) {
        synchronized (this.f15297h) {
            this.f15293d = j2;
        }
    }

    public final synchronized void h(long j2) {
        synchronized (this.f15296g) {
            this.f15292c = j2;
        }
    }
}
