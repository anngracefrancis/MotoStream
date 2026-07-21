package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
final class rr implements zzdbq {
    private final zzdca<zzdbq> a;

    public rr(zzdca<zzdbq> zzdcaVar) {
        this.a = zzdcaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbq
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzdjs.c(this.a.e().c(), this.a.e().a().a(bArr, bArr2));
    }
}
