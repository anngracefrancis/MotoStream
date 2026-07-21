package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPairGenerator;
import java.security.Provider;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdlc implements zzdky<KeyPairGenerator> {
    @Override // com.google.android.gms.internal.ads.zzdky
    public final /* synthetic */ KeyPairGenerator a(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
    }
}
