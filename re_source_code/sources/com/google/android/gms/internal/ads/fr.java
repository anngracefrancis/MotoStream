package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
final class fr extends zzdbt<zzdbj, zzddr, zzddt> {
    public fr() throws GeneralSecurityException {
        super(zzdbj.class, zzddr.class, zzddt.class, "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzdcf.j(new gr());
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
        zzdlx.b(((zzddr) zzdpkVar).x(), 0);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void k(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdlx.a(((zzddt) zzdpkVar).x().x());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbj l(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzddr zzddrVar = (zzddr) zzdpkVar;
        return new zzdkw((zzdlk) zzdcf.h("type.googleapis.com/google.crypto.tink.AesCtrKey", zzddrVar.E(), zzdlk.class), (zzdby) zzdcf.h("type.googleapis.com/google.crypto.tink.HmacKey", zzddrVar.F(), zzdby.class), zzddrVar.F().D().y());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdpk n(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzddt zzddtVar = (zzddt) zzdpkVar;
        zzdeb zzdebVar = (zzdeb) zzdcf.e("type.googleapis.com/google.crypto.tink.AesCtrKey", zzddtVar.x());
        return (zzddr) ((zzdob) zzddr.G().u(zzdebVar).v((zzdgl) zzdcf.e("type.googleapis.com/google.crypto.tink.HmacKey", zzddtVar.y())).w(0).p0());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk p(zzdmr zzdmrVar) throws zzdok {
        return zzddr.I(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk q(zzdmr zzdmrVar) throws zzdok {
        return zzddt.A(zzdmrVar);
    }
}
