package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzddc {

    @Deprecated
    public static final zzdho a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final zzdho f15880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzdho f15881c;

    static {
        zzdho zzdhoVar = (zzdho) ((zzdob) zzdho.B().j(zzdcj.a).u(zzdbl.a("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).u(zzdbl.a("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).v("TINK_HYBRID_1_0_0").p0());
        a = zzdhoVar;
        f15880b = (zzdho) ((zzdob) zzdho.B().j(zzdhoVar).v("TINK_HYBRID_1_1_0").p0());
        f15881c = (zzdho) ((zzdob) zzdho.B().j(zzdcj.f15871c).u(zzdbl.a("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).u(zzdbl.a("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).v("TINK_HYBRID").p0());
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() throws GeneralSecurityException {
        zzdcj.a();
        zzdcf.m("TinkHybridEncrypt", new qr());
        zzdcf.m("TinkHybridDecrypt", new pr());
        zzdbl.b(f15881c);
    }
}
