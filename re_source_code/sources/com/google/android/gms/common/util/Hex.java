package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@ShowFirstParty
@KeepForSdk
public class Hex {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f12151b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @KeepForSdk
    public static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length + length];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = b2 & 255;
            int i4 = i2 + 1;
            char[] cArr2 = f12151b;
            cArr[i2] = cArr2[i3 >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    @KeepForSdk
    public static String b(byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (int i2 = 0; i2 < length && (!z || i2 != length - 1 || (bArr[i2] & 255) != 0); i2++) {
            char[] cArr = a;
            sb.append(cArr[(bArr[i2] & 240) >>> 4]);
            sb.append(cArr[bArr[i2] & 15]);
        }
        return sb.toString();
    }
}
