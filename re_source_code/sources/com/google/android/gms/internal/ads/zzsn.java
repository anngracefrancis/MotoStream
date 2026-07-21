package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzsn {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f16716b;

    public zzsn() {
        this(32);
    }

    public final void a(long j2) {
        int i2 = this.a;
        long[] jArr = this.f16716b;
        if (i2 == jArr.length) {
            this.f16716b = Arrays.copyOf(jArr, i2 << 1);
        }
        long[] jArr2 = this.f16716b;
        int i3 = this.a;
        this.a = i3 + 1;
        jArr2[i3] = j2;
    }

    public final long b(int i2) {
        if (i2 >= 0 && i2 < this.a) {
            return this.f16716b[i2];
        }
        int i3 = this.a;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Invalid index ");
        sb.append(i2);
        sb.append(", size is ");
        sb.append(i3);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final int c() {
        return this.a;
    }

    private zzsn(int i2) {
        this.f16716b = new long[32];
    }
}
