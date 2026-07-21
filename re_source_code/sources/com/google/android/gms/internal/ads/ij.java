package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
final class ij {
    private static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static MessageDigest f12770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f12771c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f12772d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static CountDownLatch f12773e = new CountDownLatch(1);

    private static zzbp.zza a(zzbp.zza.zzd zzdVar) {
        zzbp.zza.C0176zza c0176zzaK0 = zzbp.zza.k0();
        c0176zzaK0.N(zzdVar.i());
        return (zzbp.zza) ((zzdob) c0176zzaK0.p0());
    }

    private static Vector<byte[]> c(byte[] bArr, int i2) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i4, bArr.length - i4 > 255 ? i4 + 255 : bArr.length));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    private static byte[] d(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArrArray;
        int i2 = z ? 239 : 255;
        if (bArr.length > i2) {
            bArr = a(zzbp.zza.zzd.PSN_ENCODE_SIZE_FAIL).g();
        }
        if (bArr.length < i2) {
            byte[] bArr2 = new byte[i2 - bArr.length];
            new SecureRandom().nextBytes(bArr2);
            bArrArray = ByteBuffer.allocate(i2 + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArrArray = ByteBuffer.allocate(i2 + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            bArrArray = ByteBuffer.allocate(256).put(e(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[256];
        for (pl plVar : new zzcl().N2) {
            plVar.a(bArrArray, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzdmh(str.getBytes("UTF-8")).a(bArr3);
        }
        return bArr3;
    }

    public static byte[] e(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] bArrDigest;
        synchronized (f12771c) {
            MessageDigest messageDigestG = g();
            if (messageDigestG == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            messageDigestG.reset();
            messageDigestG.update(bArr);
            bArrDigest = f12770b.digest();
        }
        return bArrDigest;
    }

    static void f() {
        synchronized (f12772d) {
            if (!a) {
                a = true;
                new Thread(new ek()).start();
            }
        }
    }

    private static MessageDigest g() {
        boolean zAwait;
        MessageDigest messageDigest;
        f();
        try {
            zAwait = f12773e.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            zAwait = false;
        }
        if (zAwait && (messageDigest = f12770b) != null) {
            return messageDigest;
        }
        return null;
    }

    static String h(zzbp.zza zzaVar, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArrD;
        byte[] bArrG = zzaVar.g();
        if (((Boolean) zzyt.e().c(zzacu.t2)).booleanValue()) {
            Vector<byte[]> vectorC = c(bArrG, 255);
            if (vectorC == null || vectorC.size() == 0) {
                bArrD = d(a(zzbp.zza.zzd.PSN_ENCODE_SIZE_FAIL).g(), str, true);
            } else {
                zzbp.zzg.zza zzaVarB = zzbp.zzg.B();
                Iterator<byte[]> it = vectorC.iterator();
                while (it.hasNext()) {
                    zzaVarB.v(zzdmr.D(d(it.next(), str, false)));
                }
                zzaVarB.w(zzdmr.D(e(bArrG)));
                bArrD = ((zzbp.zzg) ((zzdob) zzaVarB.p0())).g();
            }
        } else {
            if (qy.a == null) {
                throw new GeneralSecurityException();
            }
            bArrD = ((zzbp.zzg) ((zzdob) zzbp.zzg.B().v(zzdmr.D(qy.a.a(bArrG, str != null ? str.getBytes() : new byte[0]))).u(zzbw.TINK_HYBRID).p0())).g();
        }
        return zzcg.a(bArrD, true);
    }
}
