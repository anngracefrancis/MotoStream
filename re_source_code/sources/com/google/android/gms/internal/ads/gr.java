package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
final class gr extends zzdbt<zzdlk, zzdeb, zzded> {
    public gr() {
        super(zzdlk.class, zzdeb.class, zzded.class, "type.googleapis.com/google.crypto.tink.AesCtrKey");
    }

    private static void r(zzdef zzdefVar) throws GeneralSecurityException {
        if (zzdefVar.x() < 12 || zzdefVar.x() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
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
        zzdeb zzdebVar = (zzdeb) zzdpkVar;
        zzdlx.b(zzdebVar.x(), 0);
        zzdlx.a(zzdebVar.D().size());
        r(zzdebVar.E());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void k(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzded zzdedVar = (zzded) zzdpkVar;
        zzdlx.a(zzdedVar.x());
        r(zzdedVar.z());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdlk l(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdeb zzdebVar = (zzdeb) zzdpkVar;
        return new zzdjj(zzdebVar.D().c(), zzdebVar.E().x());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdpk n(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzded zzdedVar = (zzded) zzdpkVar;
        return (zzdeb) ((zzdob) zzdeb.F().v(zzdedVar.z()).u(zzdmr.D(zzdlo.c(zzdedVar.x()))).w(0).p0());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk p(zzdmr zzdmrVar) throws zzdok {
        return zzdeb.C(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk q(zzdmr zzdmrVar) throws zzdok {
        return zzded.y(zzdmrVar);
    }
}
