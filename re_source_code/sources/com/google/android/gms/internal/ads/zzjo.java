package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzjo implements zzjp {
    private final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16357c;

    public zzjo(byte[] bArr) {
        zzkh.c(bArr);
        zzkh.a(bArr.length > 0);
        this.a = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final long a(zzjq zzjqVar) throws IOException {
        long j2 = zzjqVar.f16359c;
        int i2 = (int) j2;
        this.f16356b = i2;
        long length = zzjqVar.f16360d;
        if (length == -1) {
            length = ((long) this.a.length) - j2;
        }
        int i3 = (int) length;
        this.f16357c = i3;
        if (i3 > 0 && i2 + i3 <= this.a.length) {
            return i3;
        }
        int i4 = this.f16356b;
        long j3 = zzjqVar.f16360d;
        int length2 = this.a.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i4);
        sb.append(", ");
        sb.append(j3);
        sb.append("], length: ");
        sb.append(length2);
        throw new IOException(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f16357c;
        if (i4 == 0) {
            return -1;
        }
        int iMin = Math.min(i3, i4);
        System.arraycopy(this.a, this.f16356b, bArr, i2, iMin);
        this.f16356b += iMin;
        this.f16357c -= iMin;
        return iMin;
    }
}
