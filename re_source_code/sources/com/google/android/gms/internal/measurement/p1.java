package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class p1 implements r1 {
    private p1() {
    }

    @Override // com.google.android.gms.internal.measurement.r1
    public final byte[] a(byte[] bArr, int i2, int i3) {
        return Arrays.copyOfRange(bArr, i2, i3 + i2);
    }

    /* synthetic */ p1(o1 o1Var) {
        this();
    }
}
