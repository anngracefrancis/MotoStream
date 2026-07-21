package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
final class ek implements Runnable {
    private ek() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            MessageDigest unused = ij.f12770b = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused2) {
        } finally {
            ij.f12773e.countDown();
        }
    }
}
