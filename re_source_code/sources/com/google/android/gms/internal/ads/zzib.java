package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.RecyclerView;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzib implements zzie {
    private static final byte[] a = new byte[RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzjp f16303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f16304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f16305d;

    public zzib(zzjp zzjpVar, long j2, long j3) {
        this.f16303b = zzjpVar;
        this.f16304c = j2;
        this.f16305d = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void a(int i2) throws InterruptedException, IOException {
        int i3 = i2;
        while (i3 > 0) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            zzjp zzjpVar = this.f16303b;
            byte[] bArr = a;
            int i4 = zzjpVar.read(bArr, 0, Math.min(bArr.length, i3));
            if (i4 == -1) {
                throw new EOFException();
            }
            i3 -= i4;
        }
        this.f16304c += (long) i2;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean b(byte[] bArr, int i2, int i3, boolean z) throws InterruptedException, IOException {
        int i4 = i3;
        while (i4 > 0) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int i5 = this.f16303b.read(bArr, i2, i4);
            if (i5 == -1) {
                if (z && i4 == i3) {
                    return false;
                }
                throw new EOFException();
            }
            i2 += i5;
            i4 -= i5;
        }
        this.f16304c += (long) i3;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final long getPosition() {
        return this.f16304c;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void readFully(byte[] bArr, int i2, int i3) throws InterruptedException, IOException {
        b(bArr, i2, i3, false);
    }
}
