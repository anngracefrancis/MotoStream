package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@zzard
final class v9 implements zzrv {
    private final zzrv a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f13447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzrv f13448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f13449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Uri f13450e;

    v9(zzrv zzrvVar, int i2, zzrv zzrvVar2) {
        this.a = zzrvVar;
        this.f13447b = i2;
        this.f13448c = zzrvVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final Uri I0() {
        return this.f13450e;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final long a(zzry zzryVar) throws IOException {
        zzry zzryVar2;
        this.f13450e = zzryVar.a;
        long j2 = zzryVar.f16686d;
        long j3 = this.f13447b;
        zzry zzryVar3 = null;
        if (j2 >= j3) {
            zzryVar2 = null;
        } else {
            long j4 = zzryVar.f16687e;
            zzryVar2 = new zzry(zzryVar.a, j2, j4 != -1 ? Math.min(j4, j3 - j2) : j3 - j2, null);
        }
        long j5 = zzryVar.f16687e;
        if (j5 == -1 || zzryVar.f16686d + j5 > this.f13447b) {
            long jMax = Math.max(this.f13447b, zzryVar.f16686d);
            long j6 = zzryVar.f16687e;
            zzryVar3 = new zzry(zzryVar.a, jMax, j6 != -1 ? Math.min(j6, (zzryVar.f16686d + j6) - this.f13447b) : -1L, null);
        }
        long jA = zzryVar2 != null ? this.a.a(zzryVar2) : 0L;
        long jA2 = zzryVar3 != null ? this.f13448c.a(zzryVar3) : 0L;
        this.f13449d = zzryVar.f16686d;
        if (jA == -1 || jA2 == -1) {
            return -1L;
        }
        return jA + jA2;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final void close() throws IOException {
        this.a.close();
        this.f13448c.close();
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        long j2 = this.f13449d;
        long j3 = this.f13447b;
        if (j2 < j3) {
            i4 = this.a.read(bArr, i2, (int) Math.min(i3, j3 - j2));
            this.f13449d += (long) i4;
        } else {
            i4 = 0;
        }
        if (this.f13449d < this.f13447b) {
            return i4;
        }
        int i5 = this.f13448c.read(bArr, i2 + i4, i3 - i4);
        int i6 = i4 + i5;
        this.f13449d += (long) i5;
        return i6;
    }
}
