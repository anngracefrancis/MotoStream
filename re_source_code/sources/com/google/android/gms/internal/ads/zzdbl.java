package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdbl {
    public static zzdgy a(String str, String str2, String str3, int i2, boolean z) {
        zzdgy.zza zzaVarW = zzdgy.F().w(str2);
        String strValueOf = String.valueOf(str3);
        return (zzdgy) ((zzdob) zzaVarW.A(strValueOf.length() != 0 ? "type.googleapis.com/google.crypto.tink.".concat(strValueOf) : new String("type.googleapis.com/google.crypto.tink.")).v(0).u(true).B(str).p0());
    }

    public static void b(zzdho zzdhoVar) throws GeneralSecurityException {
        for (zzdgy zzdgyVar : zzdhoVar.A()) {
            if (zzdgyVar.A().isEmpty()) {
                throw new GeneralSecurityException("Missing type_url.");
            }
            if (zzdgyVar.B().isEmpty()) {
                throw new GeneralSecurityException("Missing primitive_name.");
            }
            if (zzdgyVar.E().isEmpty()) {
                throw new GeneralSecurityException("Missing catalogue_name.");
            }
            zzdbk<?> zzdbkVarO = zzdcf.o(zzdgyVar.E());
            zzdcf.l(zzdbkVarO.a());
            zzdcf.k(zzdbkVarO.b(zzdgyVar.A(), zzdgyVar.B(), zzdgyVar.C()), zzdgyVar.D());
        }
    }
}
