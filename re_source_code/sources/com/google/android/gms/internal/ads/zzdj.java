package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdj {
    private static Cipher a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f15926b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f15927c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SecureRandom f15928d = null;

    public zzdj(SecureRandom secureRandom) {
    }

    private static Cipher a() throws NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher;
        synchronized (f15927c) {
            if (a == null) {
                a = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = a;
        }
        return cipher;
    }

    public final byte[] b(byte[] bArr, String str) throws zzdk {
        byte[] bArrDoFinal;
        if (bArr.length != 16) {
            throw new zzdk(this);
        }
        try {
            byte[] bArrB = zzcg.b(str, false);
            if (bArrB.length <= 16) {
                throw new zzdk(this);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrB.length);
            byteBufferAllocate.put(bArrB);
            byteBufferAllocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArrB.length - 16];
            byteBufferAllocate.get(bArr2);
            byteBufferAllocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (f15926b) {
                a().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                bArrDoFinal = a().doFinal(bArr3);
            }
            return bArrDoFinal;
        } catch (IllegalArgumentException e2) {
            throw new zzdk(this, e2);
        } catch (InvalidAlgorithmParameterException e3) {
            throw new zzdk(this, e3);
        } catch (InvalidKeyException e4) {
            throw new zzdk(this, e4);
        } catch (NoSuchAlgorithmException e5) {
            throw new zzdk(this, e5);
        } catch (BadPaddingException e6) {
            throw new zzdk(this, e6);
        } catch (IllegalBlockSizeException e7) {
            throw new zzdk(this, e7);
        } catch (NoSuchPaddingException e8) {
            throw new zzdk(this, e8);
        }
    }

    public final byte[] c(String str) throws zzdk {
        try {
            byte[] bArrB = zzcg.b(str, false);
            if (bArrB.length != 32) {
                throw new zzdk(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(bArrB, 4, 16).get(bArr);
            for (int i2 = 0; i2 < 16; i2++) {
                bArr[i2] = (byte) (bArr[i2] ^ 68);
            }
            return bArr;
        } catch (IllegalArgumentException e2) {
            throw new zzdk(this, e2);
        }
    }

    public final String d(byte[] bArr, byte[] bArr2) throws zzdk {
        byte[] bArrDoFinal;
        byte[] iv;
        if (bArr.length != 16) {
            throw new zzdk(this);
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (f15926b) {
                a().init(1, secretKeySpec, (SecureRandom) null);
                bArrDoFinal = a().doFinal(bArr2);
                iv = a().getIV();
            }
            int length = bArrDoFinal.length + iv.length;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
            byteBufferAllocate.put(iv).put(bArrDoFinal);
            byteBufferAllocate.flip();
            byte[] bArr3 = new byte[length];
            byteBufferAllocate.get(bArr3);
            return zzcg.a(bArr3, false);
        } catch (InvalidKeyException e2) {
            throw new zzdk(this, e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new zzdk(this, e3);
        } catch (BadPaddingException e4) {
            throw new zzdk(this, e4);
        } catch (IllegalBlockSizeException e5) {
            throw new zzdk(this, e5);
        } catch (NoSuchPaddingException e6) {
            throw new zzdk(this, e6);
        }
    }
}
