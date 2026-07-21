package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdcj {

    @Deprecated
    public static final zzdho a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    private static final zzdho f15870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzdho f15871c;

    static {
        zzdho zzdhoVar = (zzdho) ((zzdob) zzdho.B().j(zzddo.a).u(zzdbl.a("TinkAead", "Aead", "AesCtrHmacAeadKey", 0, true)).u(zzdbl.a("TinkAead", "Aead", "AesEaxKey", 0, true)).u(zzdbl.a("TinkAead", "Aead", "AesGcmKey", 0, true)).u(zzdbl.a("TinkAead", "Aead", "ChaCha20Poly1305Key", 0, true)).u(zzdbl.a("TinkAead", "Aead", "KmsAeadKey", 0, true)).u(zzdbl.a("TinkAead", "Aead", "KmsEnvelopeAeadKey", 0, true)).v("TINK_AEAD_1_0_0").p0());
        a = zzdhoVar;
        f15870b = (zzdho) ((zzdob) zzdho.B().j(zzdhoVar).v("TINK_AEAD_1_1_0").p0());
        f15871c = (zzdho) ((zzdob) zzdho.B().j(zzddo.f15883c).u(zzdbl.a("TinkAead", "Aead", "AesCtrHmacAeadKey", 0, true)).u(zzdbl.a("TinkAead", "Aead", "AesEaxKey", 0, true)).u(zzdbl.a("TinkAead", "Aead", "AesGcmKey", 0, true)).u(zzdbl.a("TinkAead", "Aead", "ChaCha20Poly1305Key", 0, true)).u(zzdbl.a("TinkAead", "Aead", "KmsAeadKey", 0, true)).u(zzdbl.a("TinkAead", "Aead", "KmsEnvelopeAeadKey", 0, true)).u(zzdbl.a("TinkAead", "Aead", "XChaCha20Poly1305Key", 0, true)).v("TINK_AEAD").p0());
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() throws GeneralSecurityException {
        zzddo.a();
        zzdcf.m("TinkAead", new dr());
        zzdbl.b(f15871c);
    }
}
