package com.google.android.gms.internal.ads;

import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class zzsq {
    public static final byte[] a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float[] f16717b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f16718c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int[] f16719d = new int[10];

    /* JADX WARN: Code duplicated, block: B:64:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:67:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:69:0x010e  */
    /* JADX WARN: Code duplicated, block: B:70:0x0111  */
    /* JADX WARN: Code duplicated, block: B:72:0x0116  */
    /* JADX WARN: Code duplicated, block: B:73:0x0118  */
    /* JADX WARN: Code duplicated, block: B:75:0x011b  */
    /* JADX WARN: Code duplicated, block: B:93:0x0178  */
    public static zzsr a(byte[] bArr, int i2, int i3) {
        int iE;
        boolean z;
        int iE2;
        boolean z2;
        boolean zD;
        int i4;
        int i5;
        float f2;
        int i6;
        int i7;
        zzsu zzsuVar = new zzsu(bArr, i2, i3);
        zzsuVar.b(8);
        int iA = zzsuVar.a(8);
        zzsuVar.b(16);
        int iE3 = zzsuVar.e();
        int i8 = 1;
        if (iA == 100 || iA == 110 || iA == 122 || iA == 244 || iA == 44 || iA == 83 || iA == 86 || iA == 118 || iA == 128 || iA == 138) {
            iE = zzsuVar.e();
            boolean zD2 = iE == 3 ? zzsuVar.d() : false;
            zzsuVar.e();
            zzsuVar.e();
            zzsuVar.b(1);
            if (zzsuVar.d()) {
                int i9 = iE != 3 ? 8 : 12;
                int i10 = 0;
                while (i10 < i9) {
                    if (zzsuVar.d()) {
                        int i11 = i10 < 6 ? 16 : 64;
                        int iF = 8;
                        int i12 = 8;
                        for (int i13 = 0; i13 < i11; i13++) {
                            if (iF != 0) {
                                iF = ((zzsuVar.f() + i12) + 256) % 256;
                            }
                            if (iF != 0) {
                                i12 = iF;
                            }
                        }
                    }
                    i10++;
                }
            }
            z = zD2;
        } else {
            iE = 1;
            z = false;
        }
        int iE4 = zzsuVar.e() + 4;
        int iE5 = zzsuVar.e();
        if (iE5 != 0) {
            if (iE5 == 1) {
                boolean zD3 = zzsuVar.d();
                zzsuVar.f();
                zzsuVar.f();
                long jE = zzsuVar.e();
                for (int i14 = 0; i14 < jE; i14++) {
                    zzsuVar.e();
                }
                z2 = zD3;
                iE2 = 0;
            } else {
                iE2 = 0;
            }
            zzsuVar.e();
            zzsuVar.b(1);
            int iE6 = zzsuVar.e() + 1;
            int iE7 = zzsuVar.e() + 1;
            zD = zzsuVar.d();
            int i15 = (2 - (zD ? 1 : 0)) * iE7;
            if (!zD) {
                zzsuVar.b(1);
            }
            zzsuVar.b(1);
            i4 = iE6 << 4;
            i5 = i15 << 4;
            if (zzsuVar.d()) {
                int iE8 = zzsuVar.e();
                int iE9 = zzsuVar.e();
                int iE10 = zzsuVar.e();
                int iE11 = zzsuVar.e();
                if (iE == 0) {
                    i7 = 2 - (zD ? 1 : 0);
                } else {
                    if (iE == 3) {
                        i6 = 1;
                    } else {
                        i6 = 2;
                    }
                    i7 = (2 - (zD ? 1 : 0)) * (iE == 1 ? 2 : 1);
                    i8 = i6;
                }
                i4 -= (iE8 + iE9) * i8;
                i5 -= (iE10 + iE11) * i7;
            }
            int i16 = i4;
            int i17 = i5;
            float f3 = 1.0f;
            if (zzsuVar.d() || !zzsuVar.d()) {
                f2 = 1.0f;
            } else {
                int iA2 = zzsuVar.a(8);
                if (iA2 == 255) {
                    int iA3 = zzsuVar.a(16);
                    int iA4 = zzsuVar.a(16);
                    if (iA3 != 0 && iA4 != 0) {
                        f3 = iA3 / iA4;
                    }
                    f2 = f3;
                } else {
                    float[] fArr = f16717b;
                    if (iA2 < fArr.length) {
                        f2 = fArr[iA2];
                    } else {
                        StringBuilder sb = new StringBuilder(46);
                        sb.append("Unexpected aspect_ratio_idc value: ");
                        sb.append(iA2);
                        Log.w("NalUnitUtil", sb.toString());
                        f2 = 1.0f;
                    }
                }
            }
            return new zzsr(iE3, i16, i17, f2, z, zD, iE4, iE5, iE2, z2);
        }
        iE2 = zzsuVar.e() + 4;
        z2 = false;
        zzsuVar.e();
        zzsuVar.b(1);
        int iE12 = zzsuVar.e() + 1;
        int iE13 = zzsuVar.e() + 1;
        zD = zzsuVar.d();
        int i18 = (2 - (zD ? 1 : 0)) * iE13;
        if (!zD) {
            zzsuVar.b(1);
        }
        zzsuVar.b(1);
        i4 = iE12 << 4;
        i5 = i18 << 4;
        if (zzsuVar.d()) {
            int iE14 = zzsuVar.e();
            int iE15 = zzsuVar.e();
            int iE16 = zzsuVar.e();
            int iE17 = zzsuVar.e();
            if (iE == 0) {
                i7 = 2 - (zD ? 1 : 0);
            } else {
                if (iE == 3) {
                    i6 = 1;
                } else {
                    i6 = 2;
                }
                i7 = (2 - (zD ? 1 : 0)) * (iE == 1 ? 2 : 1);
                i8 = i6;
            }
            i4 -= (iE14 + iE15) * i8;
            i5 -= (iE16 + iE17) * i7;
        }
        int i19 = i4;
        int i110 = i5;
        float f4 = 1.0f;
        if (zzsuVar.d()) {
            f2 = 1.0f;
        } else {
            f2 = 1.0f;
        }
        return new zzsr(iE3, i19, i110, f2, z, zD, iE4, iE5, iE2, z2);
    }

    public static void b(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (i4 >= iPosition) {
                byteBuffer.clear();
                return;
            }
            int i5 = byteBuffer.get(i2) & 255;
            if (i3 == 3) {
                if (i5 == 1 && (byteBuffer.get(i4) & 31) == 7) {
                    ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                    byteBufferDuplicate.position(i2 - 3);
                    byteBufferDuplicate.limit(iPosition);
                    byteBuffer.position(0);
                    byteBuffer.put(byteBufferDuplicate);
                    return;
                }
            } else if (i5 == 0) {
                i3++;
            }
            if (i5 != 0) {
                i3 = 0;
            }
            i2 = i4;
        }
    }
}
