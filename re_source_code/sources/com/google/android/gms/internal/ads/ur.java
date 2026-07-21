package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class ur implements zzdka {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzdet f13407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzddr f13408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13409e;

    ur(zzdgw zzdgwVar) throws GeneralSecurityException {
        String strX = zzdgwVar.x();
        this.a = strX;
        if (strX.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzdev zzdevVarY = zzdev.y(zzdgwVar.y());
                this.f13407c = (zzdet) zzdcf.n(zzdgwVar);
                this.f13406b = zzdevVarY.x();
                return;
            } catch (zzdok e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        }
        if (!strX.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            String strValueOf = String.valueOf(strX);
            throw new GeneralSecurityException(strValueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(strValueOf) : new String("unsupported AEAD DEM key type: "));
        }
        try {
            zzddt zzddtVarA = zzddt.A(zzdgwVar.y());
            this.f13408d = (zzddr) zzdcf.n(zzdgwVar);
            this.f13409e = zzddtVarA.x().x();
            this.f13406b = this.f13409e + zzddtVarA.y().x();
        } catch (zzdok e3) {
            throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdka
    public final zzdbj a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.f13406b) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        if (this.a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            return (zzdbj) zzdcf.h(this.a, (zzdet) ((zzdob) zzdet.D().j(this.f13407c).u(zzdmr.A(bArr, 0, this.f13406b)).p0()), zzdbj.class);
        }
        if (!this.a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new GeneralSecurityException("unknown DEM key type");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, this.f13409e);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, this.f13409e, this.f13406b);
        zzdeb zzdebVar = (zzdeb) ((zzdob) zzdeb.F().j(this.f13408d.E()).u(zzdmr.D(bArrCopyOfRange)).p0());
        return (zzdbj) zzdcf.h(this.a, (zzddr) ((zzdob) zzddr.G().w(this.f13408d.x()).u(zzdebVar).v((zzdgl) ((zzdob) zzdgl.E().j(this.f13408d.F()).u(zzdmr.D(bArrCopyOfRange2)).p0())).p0()), zzdbj.class);
    }

    @Override // com.google.android.gms.internal.ads.zzdka
    public final int b() {
        return this.f13406b;
    }
}
