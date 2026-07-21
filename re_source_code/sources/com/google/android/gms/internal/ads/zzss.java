package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzss {
    private byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16731d;

    public zzss() {
    }

    public final int a(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z = false;
        if (i2 == 0) {
            return 0;
        }
        int i7 = i2 / 8;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = this.f16730c;
            if (i10 != 0) {
                byte[] bArr = this.a;
                int i11 = this.f16729b;
                i6 = ((bArr[i11 + 1] & 255) >>> (8 - i10)) | ((bArr[i11] & 255) << i10);
            } else {
                i6 = this.a[this.f16729b];
            }
            i2 -= 8;
            i8 |= (255 & i6) << i2;
            this.f16729b++;
        }
        if (i2 > 0) {
            int i12 = this.f16730c + i2;
            byte b2 = (byte) (255 >> (8 - i2));
            if (i12 > 8) {
                byte[] bArr2 = this.a;
                int i13 = this.f16729b;
                i5 = (b2 & (((255 & bArr2[i13 + 1]) >> (16 - i12)) | ((bArr2[i13] & 255) << (i12 - 8)))) | i8;
                this.f16729b = i13 + 1;
            } else {
                byte[] bArr3 = this.a;
                int i14 = this.f16729b;
                i5 = (b2 & ((255 & bArr3[i14]) >> (8 - i12))) | i8;
                if (i12 == 8) {
                    this.f16729b = i14 + 1;
                }
            }
            i8 = i5;
            this.f16730c = i12 % 8;
        }
        int i15 = this.f16729b;
        if (i15 >= 0 && (i3 = this.f16730c) >= 0 && i3 < 8 && (i15 < (i4 = this.f16731d) || (i15 == i4 && i3 == 0))) {
            z = true;
        }
        zzsk.e(z);
        return i8;
    }

    public zzss(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zzss(byte[] bArr, int i2) {
        this.a = bArr;
        this.f16731d = i2;
    }
}
