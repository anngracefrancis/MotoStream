package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
final class qr implements zzdbk<zzdbq> {
    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdcc<zzdbq> a() {
        return new zzddg();
    }

    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdbs<zzdbq> b(String str, String str2, int i2) throws GeneralSecurityException {
        String lowerCase = str2.toLowerCase();
        lowerCase.hashCode();
        if (!lowerCase.equals("hybridencrypt")) {
            throw new GeneralSecurityException(String.format("No support for primitive '%s'.", str2));
        }
        str.hashCode();
        if (!str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
            throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", str));
        }
        or orVar = new or();
        if (i2 <= 0) {
            return orVar;
        }
        throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", str, Integer.valueOf(i2)));
    }
}
