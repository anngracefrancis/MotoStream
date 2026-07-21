package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@zzard
final class b9 implements zzjp {
    private final zzjp a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzjp f12326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12327d;

    b9(zzjp zzjpVar, int i2, zzjp zzjpVar2) {
        this.a = zzjpVar;
        this.f12325b = i2;
        this.f12326c = zzjpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final long a(zzjq zzjqVar) throws IOException {
        zzjq zzjqVar2;
        long j2 = zzjqVar.f16359c;
        long j3 = this.f12325b;
        zzjq zzjqVar3 = null;
        if (j2 >= j3) {
            zzjqVar2 = null;
        } else {
            long j4 = zzjqVar.f16360d;
            zzjqVar2 = new zzjq(zzjqVar.a, j2, j4 != -1 ? Math.min(j4, j3 - j2) : j3 - j2, null);
        }
        long j5 = zzjqVar.f16360d;
        if (j5 == -1 || zzjqVar.f16359c + j5 > this.f12325b) {
            long jMax = Math.max(this.f12325b, zzjqVar.f16359c);
            long j6 = zzjqVar.f16360d;
            zzjqVar3 = new zzjq(zzjqVar.a, jMax, j6 != -1 ? Math.min(j6, (zzjqVar.f16359c + j6) - this.f12325b) : -1L, null);
        }
        long jA = zzjqVar2 != null ? this.a.a(zzjqVar2) : 0L;
        long jA2 = zzjqVar3 != null ? this.f12326c.a(zzjqVar3) : 0L;
        this.f12327d = zzjqVar.f16359c;
        if (jA == -1 || jA2 == -1) {
            return -1L;
        }
        return jA + jA2;
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final void close() throws IOException {
        this.a.close();
        this.f12326c.close();
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        long j2 = this.f12327d;
        long j3 = this.f12325b;
        if (j2 < j3) {
            i4 = this.a.read(bArr, i2, (int) Math.min(i3, j3 - j2));
            this.f12327d += (long) i4;
        } else {
            i4 = 0;
        }
        if (this.f12327d < this.f12325b) {
            return i4;
        }
        int i5 = this.f12326c.read(bArr, i2 + i4, i3 - i4);
        int i6 = i4 + i5;
        this.f12327d += (long) i5;
        return i6;
    }
}
