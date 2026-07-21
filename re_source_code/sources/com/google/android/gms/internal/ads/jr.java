package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
final class jr extends zzdbt<zzdbj, zzdfb, zzdgh> {
    public jr() {
        super(zzdbj.class, zzdfb.class, zzdgh.class, "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final int H0() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final zzdgr.zzb i() {
        return zzdgr.zzb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void j(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdfb zzdfbVar = (zzdfb) zzdpkVar;
        zzdlx.b(zzdfbVar.x(), 0);
        if (zzdfbVar.B().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* bridge */ /* synthetic */ void k(zzdpk zzdpkVar) throws GeneralSecurityException {
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbj l(zzdpk zzdpkVar) throws GeneralSecurityException {
        return new zzdjv(((zzdfb) zzdpkVar).B().c());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk n(zzdpk zzdpkVar) throws GeneralSecurityException {
        return (zzdfb) ((zzdob) zzdfb.D().v(0).u(zzdmr.D(zzdlo.c(32))).p0());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk p(zzdmr zzdmrVar) throws zzdok {
        return zzdfb.C(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk q(zzdmr zzdmrVar) throws zzdok {
        return zzdgh.y(zzdmrVar);
    }
}
