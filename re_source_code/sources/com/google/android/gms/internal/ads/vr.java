package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
final class vr extends zzdbt<zzdby, zzdgl, zzdgn> {
    public vr() {
        super(zzdby.class, zzdgl.class, zzdgn.class, "type.googleapis.com/google.crypto.tink.HmacKey");
    }

    private static void r(zzdgp zzdgpVar) throws GeneralSecurityException {
        if (zzdgpVar.y() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int i2 = wr.a[zzdgpVar.x().ordinal()];
        if (i2 == 1) {
            if (zzdgpVar.y() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i2 == 2) {
            if (zzdgpVar.y() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (i2 != 3) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (zzdgpVar.y() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
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
        zzdgl zzdglVar = (zzdgl) zzdpkVar;
        zzdlx.b(zzdglVar.x(), 0);
        if (zzdglVar.C().size() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        r(zzdglVar.D());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void k(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdgn zzdgnVar = (zzdgn) zzdpkVar;
        if (zzdgnVar.x() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        r(zzdgnVar.y());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdby l(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdgl zzdglVar = (zzdgl) zzdpkVar;
        zzdgj zzdgjVarX = zzdglVar.D().x();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzdglVar.C().c(), "HMAC");
        int iY = zzdglVar.D().y();
        int i2 = wr.a[zzdgjVarX.ordinal()];
        if (i2 == 1) {
            return new zzdll("HMACSHA1", secretKeySpec, iY);
        }
        if (i2 == 2) {
            return new zzdll("HMACSHA256", secretKeySpec, iY);
        }
        if (i2 == 3) {
            return new zzdll("HMACSHA512", secretKeySpec, iY);
        }
        throw new GeneralSecurityException("unknown hash");
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdpk n(zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdgn zzdgnVar = (zzdgn) zzdpkVar;
        return (zzdgl) ((zzdob) zzdgl.E().w(0).v(zzdgnVar.y()).u(zzdmr.D(zzdlo.c(zzdgnVar.x()))).p0());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk p(zzdmr zzdmrVar) throws zzdok {
        return zzdgl.I(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdpk q(zzdmr zzdmrVar) throws zzdok {
        return zzdgn.B(zzdmrVar);
    }
}
