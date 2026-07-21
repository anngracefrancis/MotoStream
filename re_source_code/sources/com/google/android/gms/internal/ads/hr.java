package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
final class hr extends zzdbt<zzdbj, zzdeh, zzdej> {
    public hr() {
        super(zzdbj.class, zzdeh.class, zzdej.class, "type.googleapis.com/google.crypto.tink.AesEaxKey");
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
        zzdeh zzdehVar = (zzdeh) zzdpkVar;
        zzdlx.b(zzdehVar.x(), 0);
        zzdlx.a(zzdehVar.E().size());
        if (zzdehVar.F().x() != 12 && zzdehVar.F().x() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void k(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdej zzdejVar = (zzdej) zzdpkVar;
        zzdlx.a(zzdejVar.x());
        if (zzdejVar.z().x() != 12 && zzdejVar.z().x() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbj l(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdeh zzdehVar = (zzdeh) zzdpkVar;
        return new zzdjk(zzdehVar.E().c(), zzdehVar.F().x());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdpk n(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdej zzdejVar = (zzdej) zzdpkVar;
        return (zzdeh) ((zzdob) zzdeh.G().u(zzdmr.D(zzdlo.c(zzdejVar.x()))).v(zzdejVar.z()).w(0).p0());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk p(zzdmr zzdmrVar) throws zzdok {
        return zzdeh.D(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk q(zzdmr zzdmrVar) throws zzdok {
        return zzdej.y(zzdmrVar);
    }
}
