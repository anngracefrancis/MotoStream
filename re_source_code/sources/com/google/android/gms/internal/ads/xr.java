package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
final class xr implements zzdbk<zzdby> {
    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdcc<zzdby> a() {
        return new zzddp();
    }

    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdbs<zzdby> b(String str, String str2, int i2) throws GeneralSecurityException {
        String lowerCase = str2.toLowerCase();
        lowerCase.hashCode();
        if (!lowerCase.equals("mac")) {
            throw new GeneralSecurityException(String.format("No support for primitive '%s'.", str2));
        }
        str.hashCode();
        if (!str.equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new GeneralSecurityException(String.format("No support for primitive 'Mac' with key type '%s'.", str));
        }
        vr vrVar = new vr();
        if (i2 <= 0) {
            return vrVar;
        }
        throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", str, Integer.valueOf(i2)));
    }
}
