package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdlo {
    private static final ThreadLocal<SecureRandom> a = new qt();

    /* JADX INFO: Access modifiers changed from: private */
    public static SecureRandom a() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] c(int i2) {
        byte[] bArr = new byte[i2];
        a.get().nextBytes(bArr);
        return bArr;
    }
}
