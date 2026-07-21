package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
final class kr extends zzdbt<zzdbj, zzdhe, zzdhg> {
    public kr() {
        super(zzdbj.class, zzdhe.class, zzdhg.class, "type.googleapis.com/google.crypto.tink.KmsAeadKey");
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final int H0() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final zzdgr.zzb i() {
        return zzdgr.zzb.REMOTE;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void j(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdlx.b(((zzdhe) zzdpkVar).x(), 0);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* bridge */ /* synthetic */ void k(zzdpk zzdpkVar) throws GeneralSecurityException {
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbj l(zzdpk zzdpkVar) throws GeneralSecurityException {
        String strX = ((zzdhe) zzdpkVar).C().x();
        return zzdbx.a(strX).b(strX);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdpk n(zzdpk zzdpkVar) throws GeneralSecurityException {
        return (zzdhe) ((zzdob) zzdhe.D().u((zzdhg) zzdpkVar).v(0).p0());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk p(zzdmr zzdmrVar) throws zzdok {
        return zzdhe.F(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk q(zzdmr zzdmrVar) throws zzdok {
        return zzdhg.A(zzdmrVar);
    }
}
