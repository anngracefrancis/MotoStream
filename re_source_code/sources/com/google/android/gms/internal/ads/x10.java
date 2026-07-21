package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class x10 {
    private static final long[] a = {128, 64, 32, 16, 8, 4, 2, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f13541b = new byte[8];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13543d;

    public static long c(byte[] bArr, int i2, boolean z) {
        long j2 = ((long) bArr[0]) & 255;
        if (z) {
            j2 &= a[i2 - 1] ^ (-1);
        }
        for (int i3 = 1; i3 < i2; i3++) {
            j2 = (j2 << 8) | (((long) bArr[i3]) & 255);
        }
        return j2;
    }

    public static int d(int i2) {
        int i3 = 0;
        while (true) {
            long[] jArr = a;
            if (i3 >= jArr.length) {
                return -1;
            }
            if ((jArr[i3] & ((long) i2)) != 0) {
                return i3 + 1;
            }
            i3++;
        }
    }

    public final void a() {
        this.f13542c = 0;
        this.f13543d = 0;
    }

    public final long b(zzno zznoVar, boolean z, boolean z2, int i2) throws InterruptedException, IOException {
        if (this.f13542c == 0) {
            if (!zznoVar.b(this.f13541b, 0, 1, z)) {
                return -1L;
            }
            int iD = d(this.f13541b[0] & 255);
            this.f13543d = iD;
            if (iD == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f13542c = 1;
        }
        int i3 = this.f13543d;
        if (i3 > i2) {
            this.f13542c = 0;
            return -2L;
        }
        if (i3 != 1) {
            zznoVar.readFully(this.f13541b, 1, i3 - 1);
        }
        this.f13542c = 0;
        return c(this.f13541b, this.f13543d, z2);
    }

    public final int e() {
        return this.f13543d;
    }
}
