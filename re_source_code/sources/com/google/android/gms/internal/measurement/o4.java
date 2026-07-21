package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class o4 {
    o4() {
    }

    abstract int a(int i2, byte[] bArr, int i3, int i4);

    abstract int b(CharSequence charSequence, byte[] bArr, int i2, int i3);

    final boolean c(byte[] bArr, int i2, int i3) {
        return a(0, bArr, i2, i3) == 0;
    }

    abstract String d(byte[] bArr, int i2, int i3) throws zzfo;
}
