package kotlin.reflect.y.internal.j0.e.a0.b;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: utfEncoding.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final byte[] a(String[] strArr) {
        m.f(strArr, "strings");
        int length = 0;
        for (String str : strArr) {
            length += str.length();
        }
        byte[] bArr = new byte[length];
        int i2 = 0;
        for (String str2 : strArr) {
            int length2 = str2.length();
            int i3 = 0;
            while (i3 < length2) {
                bArr[i2] = (byte) str2.charAt(i3);
                i3++;
                i2++;
            }
        }
        return bArr;
    }
}
