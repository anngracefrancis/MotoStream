package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.KeyAgreement;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdla implements zzdky<KeyAgreement> {
    @Override // com.google.android.gms.internal.ads.zzdky
    public final /* synthetic */ KeyAgreement a(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
    }
}
