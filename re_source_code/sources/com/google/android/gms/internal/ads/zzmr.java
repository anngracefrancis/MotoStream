package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.AdRequest;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class zzmr {
    private static final int[] a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f16469b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f16470c = {64, 112, 128, 192, 224, 256, 384, 448, AdRequest.MAX_CONTENT_URL_LENGTH, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, RecyclerView.l.FLAG_MOVED, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT, 6144, 7680};

    public static int a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        return ((((byteBuffer.get(iPosition + 5) & 252) >> 2) | ((byteBuffer.get(iPosition + 4) & 1) << 6)) + 1) << 5;
    }
}
