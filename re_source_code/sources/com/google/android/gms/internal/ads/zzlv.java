package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdRequest;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class zzlv {
    private static final int[] a = {1, 2, 3, 6};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f16449b = {48000, 44100, 32000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f16450c = {24000, 22050, 16000};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f16451d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f16452e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, AdRequest.MAX_CONTENT_URL_LENGTH, 576, 640};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f16453f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzlh a(zzst zzstVar, String str, String str2, zzne zzneVar) {
        int i2 = f16449b[(zzstVar.g() & 192) >> 6];
        int iG = zzstVar.g();
        int i3 = f16451d[(iG & 56) >> 3];
        if ((iG & 4) != 0) {
            i3++;
        }
        return zzlh.d(str, "audio/ac3", null, -1, -1, i3, i2, null, null, 0, str2);
    }

    public static zzlh b(zzst zzstVar, String str, String str2, zzne zzneVar) {
        zzstVar.l(2);
        int i2 = f16449b[(zzstVar.g() & 192) >> 6];
        int iG = zzstVar.g();
        int i3 = f16451d[(iG & 14) >> 1];
        if ((iG & 1) != 0) {
            i3++;
        }
        return zzlh.d(str, "audio/eac3", null, -1, -1, i3, i2, null, null, 0, str2);
    }

    public static int c(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
    }

    public static int d() {
        return 1536;
    }
}
