package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzeg {
    int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f17372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    z1 f17374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f17375e;

    private zzeg() {
        this.f17372b = 100;
        this.f17373c = Integer.MAX_VALUE;
        this.f17375e = false;
    }

    public static long b(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    static zzeg c(byte[] bArr, int i2, int i3, boolean z) {
        x1 x1Var = new x1(bArr, 0, i3, false);
        try {
            x1Var.h(i3);
            return x1Var;
        } catch (zzfo e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int k(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public abstract boolean A() throws IOException;

    public abstract int B();

    public abstract int a() throws IOException;

    public abstract void d(int i2) throws zzfo;

    public abstract double e() throws IOException;

    public abstract boolean f(int i2) throws IOException;

    public abstract float g() throws IOException;

    public abstract int h(int i2) throws zzfo;

    public abstract long i() throws IOException;

    public abstract void j(int i2);

    public abstract long l() throws IOException;

    public abstract int m() throws IOException;

    public abstract long n() throws IOException;

    public abstract int o() throws IOException;

    public abstract boolean p() throws IOException;

    public abstract String q() throws IOException;

    public abstract String r() throws IOException;

    public abstract zzdu s() throws IOException;

    public abstract int t() throws IOException;

    public abstract int u() throws IOException;

    public abstract int v() throws IOException;

    public abstract long w() throws IOException;

    public abstract int x() throws IOException;

    public abstract long y() throws IOException;

    abstract long z() throws IOException;
}
