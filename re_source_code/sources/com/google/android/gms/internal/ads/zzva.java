package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public abstract class zzva {
    private static MessageDigest a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Object f16841b = new Object();

    abstract byte[] a(String str);

    protected final MessageDigest b() {
        synchronized (this.f16841b) {
            MessageDigest messageDigest = a;
            if (messageDigest != null) {
                return messageDigest;
            }
            for (int i2 = 0; i2 < 2; i2++) {
                try {
                    a = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return a;
        }
    }
}
