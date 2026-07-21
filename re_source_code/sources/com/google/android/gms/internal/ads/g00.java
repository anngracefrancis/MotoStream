package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class g00 {
    private static final int[] a = {128, 64, 32, 16, 8, 4, 2, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f12609b = new byte[8];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12611d;

    public final void a() {
        this.f12610c = 0;
        this.f12611d = 0;
    }

    public final long b(zzie zzieVar, boolean z, boolean z2) throws InterruptedException, IOException {
        if (this.f12610c == 0) {
            if (!zzieVar.b(this.f12609b, 0, 1, z)) {
                return -1L;
            }
            int i2 = this.f12609b[0] & 255;
            this.f12611d = -1;
            int i3 = 0;
            while (true) {
                int[] iArr = a;
                if (i3 >= iArr.length) {
                    break;
                }
                if ((iArr[i3] & i2) != 0) {
                    this.f12611d = i3 + 1;
                    break;
                }
                i3++;
            }
            if (this.f12611d == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f12610c = 1;
        }
        zzieVar.readFully(this.f12609b, 1, this.f12611d - 1);
        if (z2) {
            byte[] bArr = this.f12609b;
            bArr[0] = (byte) (bArr[0] & (a[this.f12611d - 1] ^ (-1)));
        }
        long j2 = 0;
        for (int i4 = 0; i4 < this.f12611d; i4++) {
            j2 = (j2 << 8) | ((long) (this.f12609b[i4] & 255));
        }
        this.f12610c = 0;
        return j2;
    }

    public final int c() {
        return this.f12611d;
    }
}
