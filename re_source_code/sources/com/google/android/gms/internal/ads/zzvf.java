package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzvf extends zzva {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MessageDigest f16845c;

    @Override // com.google.android.gms.internal.ads.zzva
    public final byte[] a(String str) {
        byte[] bArr;
        byte[] bArrArray;
        String[] strArrSplit = str.split(" ");
        int length = 4;
        if (strArrSplit.length == 1) {
            int iA = zzve.a(strArrSplit[0]);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocate.putInt(iA);
            bArrArray = byteBufferAllocate.array();
        } else {
            if (strArrSplit.length < 5) {
                bArr = new byte[strArrSplit.length << 1];
                for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                    int iA2 = zzve.a(strArrSplit[i2]);
                    int i3 = (iA2 >> 16) ^ (65535 & iA2);
                    byte[] bArr2 = {(byte) i3, (byte) (i3 >> 8)};
                    int i4 = i2 << 1;
                    bArr[i4] = bArr2[0];
                    bArr[i4 + 1] = bArr2[1];
                }
            } else {
                bArr = new byte[strArrSplit.length];
                for (int i5 = 0; i5 < strArrSplit.length; i5++) {
                    int iA3 = zzve.a(strArrSplit[i5]);
                    bArr[i5] = (byte) ((iA3 >> 24) ^ (((iA3 & 255) ^ ((iA3 >> 8) & 255)) ^ ((iA3 >> 16) & 255)));
                }
            }
            bArrArray = bArr;
        }
        this.f16845c = b();
        synchronized (this.f16841b) {
            MessageDigest messageDigest = this.f16845c;
            if (messageDigest == null) {
                return new byte[0];
            }
            messageDigest.reset();
            this.f16845c.update(bArrArray);
            byte[] bArrDigest = this.f16845c.digest();
            if (bArrDigest.length <= 4) {
                length = bArrDigest.length;
            }
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArrDigest, 0, bArr3, 0, length);
            return bArr3;
        }
    }
}
