package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdkc implements zzdbq {
    private static final byte[] a = new byte[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdke f15943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f15945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdkv f15946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdka f15947f;

    public zzdkc(ECPublicKey eCPublicKey, byte[] bArr, String str, zzdkv zzdkvVar, zzdka zzdkaVar) throws GeneralSecurityException {
        zzdkr.g(eCPublicKey);
        this.f15943b = new zzdke(eCPublicKey);
        this.f15945d = bArr;
        this.f15944c = str;
        this.f15946e = zzdkvVar;
        this.f15947f = zzdkaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbq
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzdkf zzdkfVarA = this.f15943b.a(this.f15944c, this.f15945d, bArr2, this.f15947f.b(), this.f15946e);
        byte[] bArrA = this.f15947f.a(zzdkfVarA.b()).a(bArr, a);
        byte[] bArrA2 = zzdkfVarA.a();
        return ByteBuffer.allocate(bArrA2.length + bArrA.length).put(bArrA2).put(bArrA).array();
    }
}
