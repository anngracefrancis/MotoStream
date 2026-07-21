package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
final class ir extends zzdbt<zzdbj, zzdet, zzdev> {
    public ir() {
        super(zzdbj.class, zzdet.class, zzdev.class, "type.googleapis.com/google.crypto.tink.AesGcmKey");
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
        zzdet zzdetVar = (zzdet) zzdpkVar;
        zzdlx.b(zzdetVar.x(), 0);
        zzdlx.a(zzdetVar.C().size());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void k(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdlx.a(((zzdev) zzdpkVar).x());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdbj l(zzdpk zzdpkVar) throws GeneralSecurityException {
        return new zzdjm(((zzdet) zzdpkVar).C().c());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk n(zzdpk zzdpkVar) throws GeneralSecurityException {
        return (zzdet) ((zzdob) zzdet.D().u(zzdmr.D(zzdlo.c(((zzdev) zzdpkVar).x()))).v(0).p0());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk p(zzdmr zzdmrVar) throws zzdok {
        return zzdet.B(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk q(zzdmr zzdmrVar) throws zzdok {
        return zzdev.y(zzdmrVar);
    }
}
