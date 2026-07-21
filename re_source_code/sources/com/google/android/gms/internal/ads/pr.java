package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
final class pr implements zzdbk<zzdbp> {
    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdcc<zzdbp> a() {
        return new zzdde();
    }

    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdbs<zzdbp> b(String str, String str2, int i2) throws GeneralSecurityException {
        String lowerCase = str2.toLowerCase();
        lowerCase.hashCode();
        if (!lowerCase.equals("hybriddecrypt")) {
            throw new GeneralSecurityException(String.format("No support for primitive '%s'.", str2));
        }
        str.hashCode();
        if (!str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", str));
        }
        nr nrVar = new nr();
        if (i2 <= 0) {
            return nrVar;
        }
        throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", str, Integer.valueOf(i2)));
    }
}
