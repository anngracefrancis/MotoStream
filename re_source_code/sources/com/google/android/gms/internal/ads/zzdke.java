package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdke {
    private ECPublicKey a;

    public zzdke(ECPublicKey eCPublicKey) {
        this.a = eCPublicKey;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0139  */
    /* JADX WARN: Code duplicated, block: B:39:0x0148  */
    /* JADX WARN: Code duplicated, block: B:43:0x0179 A[LOOP:0: B:41:0x0167->B:43:0x0179, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:46:0x018c  */
    /* JADX WARN: Code duplicated, block: B:58:0x0182 A[SYNTHETIC] */
    public final zzdkf a(String str, byte[] bArr, byte[] bArr2, int i2, zzdkv zzdkvVar) throws GeneralSecurityException {
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArrC;
        Mac macB;
        byte[] bArr5;
        byte[] bArrDoFinal;
        int length;
        KeyPair keyPairB = zzdkr.b(this.a.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairB.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairB.getPrivate();
        ECPublicKey eCPublicKey2 = this.a;
        try {
            ECParameterSpec params = eCPublicKey2.getParams();
            ECParameterSpec params2 = eCPrivateKey.getParams();
            if (!params.getCurve().equals(params2.getCurve()) || !params.getGenerator().equals(params2.getGenerator()) || !params.getOrder().equals(params2.getOrder()) || params.getCofactor() != params2.getCofactor()) {
                throw new GeneralSecurityException("invalid public key spec");
            }
            byte[] bArrI = zzdkr.i(eCPrivateKey, eCPublicKey2.getW());
            EllipticCurve curve = eCPublicKey.getParams().getCurve();
            ECPoint w = eCPublicKey.getW();
            zzdkr.h(w, curve);
            int iJ = zzdkr.j(curve);
            int i3 = ot.a[zzdkvVar.ordinal()];
            int i4 = 1;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        String strValueOf = String.valueOf(zzdkvVar);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 15);
                        sb.append("invalid format:");
                        sb.append(strValueOf);
                        throw new GeneralSecurityException(sb.toString());
                    }
                    int i5 = iJ + 1;
                    bArr4 = new byte[i5];
                    byte[] byteArray = w.getAffineX().toByteArray();
                    System.arraycopy(byteArray, 0, bArr4, i5 - byteArray.length, byteArray.length);
                    bArr4[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
                } else {
                    int i6 = iJ * 2;
                    bArr3 = new byte[i6];
                    byte[] byteArray2 = w.getAffineX().toByteArray();
                    if (byteArray2.length > iJ) {
                        byteArray2 = Arrays.copyOfRange(byteArray2, byteArray2.length - iJ, byteArray2.length);
                    }
                    byte[] byteArray3 = w.getAffineY().toByteArray();
                    if (byteArray3.length > iJ) {
                        byteArray3 = Arrays.copyOfRange(byteArray3, byteArray3.length - iJ, byteArray3.length);
                    }
                    System.arraycopy(byteArray3, 0, bArr3, i6 - byteArray3.length, byteArray3.length);
                    System.arraycopy(byteArray2, 0, bArr3, iJ - byteArray2.length, byteArray2.length);
                }
                bArrC = zzdjs.c(bArr4, bArrI);
                macB = zzdkx.f15961d.b(str);
                if (i2 <= macB.getMacLength() * 255) {
                    throw new GeneralSecurityException("size too large");
                }
                if (bArr != null || bArr.length == 0) {
                    macB.init(new SecretKeySpec(new byte[macB.getMacLength()], str));
                } else {
                    macB.init(new SecretKeySpec(bArr, str));
                }
                byte[] bArrDoFinal2 = macB.doFinal(bArrC);
                bArr5 = new byte[i2];
                macB.init(new SecretKeySpec(bArrDoFinal2, str));
                bArrDoFinal = new byte[0];
                length = 0;
                while (true) {
                    macB.update(bArrDoFinal);
                    macB.update(bArr2);
                    macB.update((byte) i4);
                    bArrDoFinal = macB.doFinal();
                    if (bArrDoFinal.length + length < i2) {
                        System.arraycopy(bArrDoFinal, 0, bArr5, length, i2 - length);
                        return new zzdkf(bArr4, bArr5);
                    }
                    System.arraycopy(bArrDoFinal, 0, bArr5, length, bArrDoFinal.length);
                    length += bArrDoFinal.length;
                    i4++;
                }
            } else {
                int i7 = (iJ * 2) + 1;
                bArr3 = new byte[i7];
                byte[] byteArray4 = w.getAffineX().toByteArray();
                byte[] byteArray5 = w.getAffineY().toByteArray();
                System.arraycopy(byteArray5, 0, bArr3, i7 - byteArray5.length, byteArray5.length);
                System.arraycopy(byteArray4, 0, bArr3, (iJ + 1) - byteArray4.length, byteArray4.length);
                bArr3[0] = 4;
            }
            bArr4 = bArr3;
            bArrC = zzdjs.c(bArr4, bArrI);
            macB = zzdkx.f15961d.b(str);
            if (i2 <= macB.getMacLength() * 255) {
                throw new GeneralSecurityException("size too large");
            }
            if (bArr != null) {
                macB.init(new SecretKeySpec(new byte[macB.getMacLength()], str));
            } else {
                macB.init(new SecretKeySpec(new byte[macB.getMacLength()], str));
            }
            byte[] bArrDoFinal3 = macB.doFinal(bArrC);
            bArr5 = new byte[i2];
            macB.init(new SecretKeySpec(bArrDoFinal3, str));
            bArrDoFinal = new byte[0];
            length = 0;
            while (true) {
                macB.update(bArrDoFinal);
                macB.update(bArr2);
                macB.update((byte) i4);
                bArrDoFinal = macB.doFinal();
                if (bArrDoFinal.length + length < i2) {
                    System.arraycopy(bArrDoFinal, 0, bArr5, length, i2 - length);
                    return new zzdkf(bArr4, bArr5);
                }
                System.arraycopy(bArrDoFinal, 0, bArr5, length, bArrDoFinal.length);
                length += bArrDoFinal.length;
                i4++;
            }
        } catch (IllegalArgumentException | NullPointerException e2) {
            throw new GeneralSecurityException(e2.toString());
        }
    }
}
