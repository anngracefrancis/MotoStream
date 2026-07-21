package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdlj {
    private final byte[] a;

    private zzdlj(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        this.a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i3);
    }

    public static zzdlj b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new zzdlj(bArr, 0, bArr.length);
    }

    public final byte[] a() {
        byte[] bArr = this.a;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
