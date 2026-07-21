package com.google.android.gms.internal.ads;

import java.io.IOException;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes2.dex */
final class w10 {
    private final zzst a = new zzst(8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13488b;

    private final long b(zzno zznoVar) throws InterruptedException, IOException {
        int i2 = 0;
        zznoVar.d(this.a.a, 0, 1);
        int i3 = this.a.a[0] & 255;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int i4 = 128;
        int i5 = 0;
        while ((i3 & i4) == 0) {
            i4 >>= 1;
            i5++;
        }
        int i6 = i3 & (i4 ^ (-1));
        zznoVar.d(this.a.a, 1, i5);
        while (i2 < i5) {
            i2++;
            i6 = (this.a.a[i2] & 255) + (i6 << 8);
        }
        this.f13488b += i5 + 1;
        return i6;
    }

    public final boolean a(zzno zznoVar) throws InterruptedException, IOException {
        long jF = zznoVar.f();
        long j2 = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        if (jF != -1 && jF <= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            j2 = jF;
        }
        int i2 = (int) j2;
        zznoVar.d(this.a.a, 0, 4);
        long jQ = this.a.q();
        this.f13488b = 4;
        while (jQ != 440786851) {
            int i3 = this.f13488b + 1;
            this.f13488b = i3;
            if (i3 == i2) {
                return false;
            }
            zznoVar.d(this.a.a, 0, 1);
            jQ = ((jQ << 8) & (-256)) | ((long) (this.a.a[0] & 255));
        }
        long jB = b(zznoVar);
        long j3 = this.f13488b;
        if (jB != Long.MIN_VALUE && (jF == -1 || j3 + jB < jF)) {
            while (true) {
                int i4 = this.f13488b;
                long j4 = j3 + jB;
                if (i4 < j4) {
                    if (b(zznoVar) == Long.MIN_VALUE) {
                        return false;
                    }
                    long jB2 = b(zznoVar);
                    if (jB2 < 0 || jB2 > 2147483647L) {
                        return false;
                    }
                    if (jB2 != 0) {
                        zznoVar.g((int) jB2);
                        this.f13488b = (int) (((long) this.f13488b) + jB2);
                    }
                } else if (i4 == j4) {
                    return true;
                }
            }
        }
        return false;
    }
}
