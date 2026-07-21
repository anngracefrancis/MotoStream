package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

/* JADX INFO: loaded from: classes2.dex */
final class nr extends zzdbt<zzdbp, zzdfv, zzdfr> implements zzdbs<zzdbp> {
    public nr() {
        super(zzdbp.class, zzdfv.class, zzdfr.class, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final int H0() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final zzdgr.zzb i() {
        return zzdgr.zzb.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void j(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdfv zzdfvVar = (zzdfv) zzdpkVar;
        zzdlx.b(zzdfvVar.x(), 0);
        sr.d(zzdfvVar.E().E());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void k(zzdpk zzdpkVar) throws GeneralSecurityException {
        sr.d(((zzdfr) zzdpkVar).x());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbp l(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdfv zzdfvVar = (zzdfv) zzdpkVar;
        zzdft zzdftVarE = zzdfvVar.E().E();
        zzdfz zzdfzVarX = zzdftVarE.x();
        return new zzdkb(zzdkr.c(sr.a(zzdfzVarX.y()), zzdfvVar.D().c()), zzdfzVarX.z().c(), sr.c(zzdfzVarX.x()), sr.b(zzdftVarE.z()), new ur(zzdftVarE.y().x()));
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdpk n(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdfr zzdfrVar = (zzdfr) zzdpkVar;
        KeyPair keyPairB = zzdkr.b(zzdkr.e(sr.a(zzdfrVar.x().x().y())));
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairB.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairB.getPrivate();
        ECPoint w = eCPublicKey.getW();
        return (zzdfv) ((zzdob) zzdfv.F().w(0).u((zzdfx) ((zzdob) zzdfx.F().A(0).w(zzdfrVar.x()).u(zzdmr.D(w.getAffineX().toByteArray())).v(zzdmr.D(w.getAffineY().toByteArray())).p0())).v(zzdmr.D(eCPrivateKey.getS().toByteArray())).p0());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk p(zzdmr zzdmrVar) throws zzdok {
        return zzdfv.H(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk q(zzdmr zzdmrVar) throws zzdok {
        return zzdfr.z(zzdmrVar);
    }
}
