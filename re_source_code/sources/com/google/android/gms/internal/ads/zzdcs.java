package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdcs implements zzdbj {
    private static final byte[] a = new byte[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdgw f15872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdbj f15873c;

    public zzdcs(zzdgw zzdgwVar, zzdbj zzdbjVar) {
        this.f15872b = zzdgwVar;
        this.f15873c = zzdbjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbj
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrG = zzdcf.n(this.f15872b).g();
        byte[] bArrA = this.f15873c.a(bArrG, a);
        byte[] bArrA2 = ((zzdbj) zzdcf.i(this.f15872b.x(), bArrG, zzdbj.class)).a(bArr, bArr2);
        return ByteBuffer.allocate(bArrA.length + 4 + bArrA2.length).putInt(bArrA.length).put(bArrA).put(bArrA2).array();
    }
}
