package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
final class mr extends zzdbt<zzdbj, zzdig, zzdgh> {
    public mr() {
        super(zzdbj.class, zzdig.class, zzdgh.class, "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
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
        zzdig zzdigVar = (zzdig) zzdpkVar;
        zzdlx.b(zzdigVar.x(), 0);
        if (zzdigVar.B().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* bridge */ /* synthetic */ void k(zzdpk zzdpkVar) throws GeneralSecurityException {
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbj l(zzdpk zzdpkVar) throws GeneralSecurityException {
        return new zzdma(((zzdig) zzdpkVar).B().c());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk n(zzdpk zzdpkVar) throws GeneralSecurityException {
        return (zzdig) ((zzdob) zzdig.C().v(0).u(zzdmr.D(zzdlo.c(32))).p0());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk p(zzdmr zzdmrVar) throws zzdok {
        return zzdig.E(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk q(zzdmr zzdmrVar) throws zzdok {
        return zzdgh.y(zzdmrVar);
    }
}
