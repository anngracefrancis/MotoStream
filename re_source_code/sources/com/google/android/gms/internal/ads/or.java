package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
final class or extends zzdbt<zzdbq, zzdfx, zzdgh> {
    public or() {
        super(zzdbq.class, zzdfx.class, zzdgh.class, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final int H0() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final zzdgr.zzb i() {
        return zzdgr.zzb.ASYMMETRIC_PUBLIC;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void j(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdfx zzdfxVar = (zzdfx) zzdpkVar;
        zzdlx.b(zzdfxVar.x(), 0);
        sr.d(zzdfxVar.E());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* bridge */ /* synthetic */ void k(zzdpk zzdpkVar) throws GeneralSecurityException {
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdbq l(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdfx zzdfxVar = (zzdfx) zzdpkVar;
        zzdft zzdftVarE = zzdfxVar.E();
        zzdfz zzdfzVarX = zzdftVarE.x();
        return new zzdkc(zzdkr.d(sr.a(zzdfzVarX.y()), zzdfxVar.C().c(), zzdfxVar.D().c()), zzdfzVarX.z().c(), sr.c(zzdfzVarX.x()), sr.b(zzdftVarE.z()), new ur(zzdftVarE.y().x()));
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdpk n(zzdpk zzdpkVar) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk p(zzdmr zzdmrVar) throws zzdok {
        return zzdfx.M(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk q(zzdmr zzdmrVar) throws zzdok {
        return zzdgh.y(zzdmrVar);
    }
}
