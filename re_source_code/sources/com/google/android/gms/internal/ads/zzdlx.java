package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdlx {
    private static final Pattern a = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s$", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+"), 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f15978b = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/%s$", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+"), 2);

    public static void a(int i2) throws InvalidAlgorithmParameterException {
        if (i2 != 16 && i2 != 32) {
            throw new InvalidAlgorithmParameterException("invalid key size; only 128-bit and 256-bit AES keys are supported");
        }
    }

    public static void b(int i2, int i3) throws GeneralSecurityException {
        if (i2 < 0 || i2 > 0) {
            throw new GeneralSecurityException(String.format("key has version %d; only keys with version in range [0..%d] are supported", Integer.valueOf(i2), 0));
        }
    }
}
