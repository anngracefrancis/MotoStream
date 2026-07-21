package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class MurmurHash3 {
    private MurmurHash3() {
    }

    @KeepForSdk
    public static int a(byte[] bArr, int i2, int i3, int i4) {
        int i5 = (i3 & (-4)) + i2;
        while (i2 < i5) {
            int i6 = ((bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | (bArr[i2 + 3] << 24)) * (-862048943);
            int i7 = i4 ^ (((i6 << 15) | (i6 >>> 17)) * 461845907);
            i4 = (((i7 >>> 19) | (i7 << 13)) * 5) - 430675100;
            i2 += 4;
        }
        int i8 = i3 & 3;
        int i9 = 0;
        if (i8 == 1) {
            int i10 = ((bArr[i5] & 255) | i9) * (-862048943);
            i4 ^= ((i10 >>> 17) | (i10 << 15)) * 461845907;
        } else {
            if (i8 != 2) {
                i9 = i8 == 3 ? (bArr[i5 + 2] & 255) << 16 : 0;
            }
            i9 |= (bArr[i5 + 1] & 255) << 8;
            int i11 = ((bArr[i5] & 255) | i9) * (-862048943);
            i4 ^= ((i11 >>> 17) | (i11 << 15)) * 461845907;
        }
        int i12 = i4 ^ i3;
        int i13 = (i12 ^ (i12 >>> 16)) * (-2048144789);
        int i14 = (i13 ^ (i13 >>> 13)) * (-1028477387);
        return i14 ^ (i14 >>> 16);
    }
}
