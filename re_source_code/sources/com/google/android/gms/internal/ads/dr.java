package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
final class dr implements zzdbk<zzdbj> {
    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdcc<zzdbj> a() {
        return new zzdck();
    }

    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdbs<zzdbj> b(String str, String str2, int i2) throws GeneralSecurityException {
        zzdbs<zzdbj> mrVar;
        String lowerCase = str2.toLowerCase();
        lowerCase.hashCode();
        if (!lowerCase.equals("aead")) {
            throw new GeneralSecurityException(String.format("No support for primitive '%s'.", str2));
        }
        str.hashCode();
        switch (str) {
            case "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key":
                mrVar = new mr();
                break;
            case "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key":
                mrVar = new jr();
                break;
            case "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey":
                mrVar = new fr();
                break;
            case "type.googleapis.com/google.crypto.tink.KmsAeadKey":
                mrVar = new kr();
                break;
            case "type.googleapis.com/google.crypto.tink.AesEaxKey":
                mrVar = new hr();
                break;
            case "type.googleapis.com/google.crypto.tink.AesGcmKey":
                mrVar = new ir();
                break;
            case "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey":
                mrVar = new lr();
                break;
            default:
                throw new GeneralSecurityException(String.format("No support for primitive 'Aead' with key type '%s'.", str));
        }
        if (mrVar.H0() >= i2) {
            return mrVar;
        }
        throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", str, Integer.valueOf(i2)));
    }
}
