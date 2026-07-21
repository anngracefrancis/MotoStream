package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.RecyclerView;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zznm implements zzno {
    private static final byte[] a = new byte[RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzrv f16518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f16519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f16520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f16521e = new byte[65536];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f16523g;

    public zznm(zzrv zzrvVar, long j2, long j3) {
        this.f16518b = zzrvVar;
        this.f16520d = j2;
        this.f16519c = j3;
    }

    private final int h(byte[] bArr, int i2, int i3, int i4, boolean z) throws InterruptedException, IOException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int i5 = this.f16518b.read(bArr, i2 + i4, i3 - i4);
        if (i5 != -1) {
            return i4 + i5;
        }
        if (i4 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private final int i(int i2) {
        int iMin = Math.min(this.f16523g, i2);
        j(iMin);
        return iMin;
    }

    private final void j(int i2) {
        int i3 = this.f16523g - i2;
        this.f16523g = i3;
        this.f16522f = 0;
        byte[] bArr = this.f16521e;
        byte[] bArr2 = i3 < bArr.length - 524288 ? new byte[65536 + i3] : bArr;
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        this.f16521e = bArr2;
    }

    private final void k(int i2) {
        if (i2 != -1) {
            this.f16520d += (long) i2;
        }
    }

    private final int l(byte[] bArr, int i2, int i3) {
        int i4 = this.f16523g;
        if (i4 == 0) {
            return 0;
        }
        int iMin = Math.min(i4, i3);
        System.arraycopy(this.f16521e, 0, bArr, i2, iMin);
        j(iMin);
        return iMin;
    }

    private final boolean m(int i2, boolean z) throws InterruptedException, IOException {
        int i3 = this.f16522f + i2;
        byte[] bArr = this.f16521e;
        if (i3 > bArr.length) {
            this.f16521e = Arrays.copyOf(this.f16521e, zzsy.q(bArr.length << 1, 65536 + i3, i3 + 524288));
        }
        int iMin = Math.min(this.f16523g - this.f16522f, i2);
        while (iMin < i2) {
            iMin = h(this.f16521e, this.f16522f, i2, iMin, false);
            if (iMin == -1) {
                return false;
            }
        }
        int i4 = this.f16522f + i2;
        this.f16522f = i4;
        this.f16523g = Math.max(this.f16523g, i4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final void a(int i2) throws InterruptedException, IOException {
        int i3 = i(i2);
        while (i3 < i2 && i3 != -1) {
            byte[] bArr = a;
            i3 = h(bArr, -i3, Math.min(i2, bArr.length + i3), i3, false);
        }
        k(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final boolean b(byte[] bArr, int i2, int i3, boolean z) throws InterruptedException, IOException {
        int iL = l(bArr, i2, i3);
        while (iL < i3 && iL != -1) {
            iL = h(bArr, i2, i3, iL, z);
        }
        k(iL);
        return iL != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final void c() {
        this.f16522f = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final void d(byte[] bArr, int i2, int i3) throws InterruptedException, IOException {
        if (m(i3, false)) {
            System.arraycopy(this.f16521e, this.f16522f - i3, bArr, i2, i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final int e(int i2) throws InterruptedException, IOException {
        int i3 = i(i2);
        if (i3 == 0) {
            byte[] bArr = a;
            i3 = h(bArr, 0, Math.min(i2, bArr.length), 0, true);
        }
        k(i3);
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final long f() {
        return this.f16519c;
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final void g(int i2) throws InterruptedException, IOException {
        m(i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final long getPosition() {
        return this.f16520d;
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final int read(byte[] bArr, int i2, int i3) throws InterruptedException, IOException {
        int iL = l(bArr, i2, i3);
        if (iL == 0) {
            iL = h(bArr, i2, i3, 0, true);
        }
        k(iL);
        return iL;
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final void readFully(byte[] bArr, int i2, int i3) throws InterruptedException, IOException {
        b(bArr, i2, i3, false);
    }
}
