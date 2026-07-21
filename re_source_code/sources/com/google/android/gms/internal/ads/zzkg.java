package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdRequest;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class zzkg {
    private static final int[] a = {48000, 44100, 32000};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f16389b = {2, 1, 2, 3, 3, 4, 4, 5};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f16390c = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, AdRequest.MAX_CONTENT_URL_LENGTH, 576, 640};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f16391d = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int a(int i2, int i3) {
        return (((i2 << 3) * i3) + 768000) / 1536000;
    }

    public static zzhj b(zzkm zzkmVar) {
        int i2 = a[(zzkmVar.e() & 192) >> 6];
        int iE = zzkmVar.e();
        int i3 = f16389b[(iE & 56) >> 3];
        if ((iE & 4) != 0) {
            i3++;
        }
        return zzhj.g("audio/ac3", -1, -1L, i3, i2, Collections.emptyList());
    }

    public static zzhj c(zzkm zzkmVar) {
        zzkmVar.h(2);
        int i2 = a[(zzkmVar.e() & 192) >> 6];
        int iE = zzkmVar.e();
        int i3 = f16389b[(iE & 14) >> 1];
        if ((iE & 1) != 0) {
            i3++;
        }
        return zzhj.c("audio/eac3", -1, i3, i2, Collections.emptyList());
    }
}
