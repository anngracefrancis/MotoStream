package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
final class lr extends zzdbt<zzdbj, zzdhi, zzdhk> {
    public lr() {
        super(zzdbj.class, zzdhi.class, zzdhk.class, "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
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
        zzdlx.b(((zzdhi) zzdpkVar).x(), 0);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* bridge */ /* synthetic */ void k(zzdpk zzdpkVar) throws GeneralSecurityException {
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbj l(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdhi zzdhiVar = (zzdhi) zzdpkVar;
        String strX = zzdhiVar.C().x();
        return new zzdcs(zzdhiVar.C().y(), zzdbx.a(strX).b(strX));
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdpk n(zzdpk zzdpkVar) throws GeneralSecurityException {
        return (zzdhi) ((zzdob) zzdhi.D().u((zzdhk) zzdpkVar).v(0).p0());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk p(zzdmr zzdmrVar) throws zzdok {
        return zzdhi.F(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk q(zzdmr zzdmrVar) throws zzdok {
        return zzdhk.B(zzdmrVar);
    }
}
