package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdld implements zzdky<Mac> {
    @Override // com.google.android.gms.internal.ads.zzdky
    public final /* synthetic */ Mac a(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
    }
}
