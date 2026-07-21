package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdkw implements zzdbj {
    private final zzdlk a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdby f15957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15958c;

    public zzdkw(zzdlk zzdlkVar, zzdby zzdbyVar, int i2) {
        this.a = zzdlkVar;
        this.f15957b = zzdbyVar;
        this.f15958c = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdbj
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrA = this.a.a(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzdjs.c(bArrA, this.f15957b.a(zzdjs.c(bArr2, bArrA, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8))));
    }
}
