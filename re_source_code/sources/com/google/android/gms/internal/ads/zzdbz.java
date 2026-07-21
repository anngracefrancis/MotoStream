package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class zzdbz {
    private static void a(zzdha zzdhaVar) throws GeneralSecurityException {
        for (zzdha.zzb zzbVar : zzdhaVar.y()) {
            if (zzbVar.z().D() == zzdgr.zzb.UNKNOWN_KEYMATERIAL || zzbVar.z().D() == zzdgr.zzb.SYMMETRIC || zzbVar.z().D() == zzdgr.zzb.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException("keyset contains secret key material");
            }
        }
    }

    @Deprecated
    public static final zzdbu b(byte[] bArr) throws GeneralSecurityException {
        try {
            zzdha zzdhaVarB = zzdha.B(bArr);
            a(zzdhaVarB);
            return zzdbu.a(zzdhaVarB);
        } catch (zzdok unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
