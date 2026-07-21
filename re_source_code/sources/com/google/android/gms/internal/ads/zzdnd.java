package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdnd {
    int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f15986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    qu f15988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f15989e;

    private zzdnd() {
        this.f15986b = 100;
        this.f15987c = Integer.MAX_VALUE;
        this.f15989e = false;
    }

    public static int B(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    static zzdnd v(byte[] bArr, int i2, int i3, boolean z) {
        pu puVar = new pu(bArr, i2, i3, z);
        try {
            puVar.z(i3);
            return puVar;
        } catch (zzdok e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static long w(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public abstract void A(int i2);

    public abstract double a() throws IOException;

    public abstract float b() throws IOException;

    public abstract String c() throws IOException;

    public abstract int d() throws IOException;

    public abstract long e() throws IOException;

    public abstract long f() throws IOException;

    public abstract int g() throws IOException;

    public abstract long h() throws IOException;

    public abstract int i() throws IOException;

    public abstract boolean j() throws IOException;

    public abstract String k() throws IOException;

    public abstract zzdmr l() throws IOException;

    public abstract int m() throws IOException;

    public abstract int n() throws IOException;

    public abstract int o() throws IOException;

    public abstract long p() throws IOException;

    public abstract int q() throws IOException;

    public abstract long r() throws IOException;

    abstract long s() throws IOException;

    public abstract boolean t() throws IOException;

    public abstract int u();

    public abstract void x(int i2) throws zzdok;

    public abstract boolean y(int i2) throws IOException;

    public abstract int z(int i2) throws zzdok;
}
