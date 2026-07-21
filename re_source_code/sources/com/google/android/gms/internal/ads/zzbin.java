package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbin {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14472c;

    private zzbin(int i2, int i3, int i4) {
        this.a = i2;
        this.f14472c = i3;
        this.f14471b = i4;
    }

    public static zzbin b() {
        return new zzbin(0, 0, 0);
    }

    public static zzbin c() {
        return new zzbin(4, 0, 0);
    }

    public static zzbin d() {
        return new zzbin(5, 0, 0);
    }

    public static zzbin i(zzyd zzydVar) {
        if (zzydVar.f16990i) {
            return new zzbin(3, 0, 0);
        }
        if (zzydVar.n) {
            return new zzbin(2, 0, 0);
        }
        return zzydVar.m ? b() : j(zzydVar.f16992k, zzydVar.f16989h);
    }

    public static zzbin j(int i2, int i3) {
        return new zzbin(1, i2, i3);
    }

    public final boolean a() {
        return this.a == 2;
    }

    public final boolean e() {
        return this.a == 3;
    }

    public final boolean f() {
        return this.a == 0;
    }

    public final boolean g() {
        return this.a == 4;
    }

    public final boolean h() {
        return this.a == 5;
    }
}
