package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzru implements zzrv {
    private final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Uri f16680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16682d;

    public zzru(byte[] bArr) {
        zzsk.d(bArr);
        zzsk.a(bArr.length > 0);
        this.a = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final Uri I0() {
        return this.f16680b;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final long a(zzry zzryVar) throws IOException {
        this.f16680b = zzryVar.a;
        long j2 = zzryVar.f16686d;
        int i2 = (int) j2;
        this.f16681c = i2;
        long length = zzryVar.f16687e;
        if (length == -1) {
            length = ((long) this.a.length) - j2;
        }
        int i3 = (int) length;
        this.f16682d = i3;
        if (i3 > 0 && i2 + i3 <= this.a.length) {
            return i3;
        }
        int i4 = this.f16681c;
        long j3 = zzryVar.f16687e;
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

    @Override // com.google.android.gms.internal.ads.zzrv
    public final void close() throws IOException {
        this.f16680b = null;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.f16682d;
        if (i4 == 0) {
            return -1;
        }
        int iMin = Math.min(i3, i4);
        System.arraycopy(this.a, this.f16681c, bArr, i2, iMin);
        this.f16681c += iMin;
        this.f16682d -= iMin;
        return iMin;
    }
}
