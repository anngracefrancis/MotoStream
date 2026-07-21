package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public class zzmy {
    private int a;

    public void a() {
        this.a = 0;
    }

    public final void b(int i2) {
        this.a = i2;
    }

    public final void c(int i2) {
        this.a |= Integer.MIN_VALUE;
    }

    protected final boolean d(int i2) {
        return (this.a & i2) == i2;
    }

    public final boolean e() {
        return d(Integer.MIN_VALUE);
    }

    public final boolean f() {
        return d(4);
    }

    public final boolean g() {
        return d(1);
    }
}
