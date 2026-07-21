package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzhj {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f16269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f16271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f16272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f16273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f16274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<byte[]> f16275i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f16276j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f16277k;
    private int l;
    private MediaFormat m;

    @TargetApi(16)
    private zzhj(MediaFormat mediaFormat) {
        this.m = mediaFormat;
        this.a = mediaFormat.getString("mime");
        this.f16268b = a(mediaFormat, "max-input-size");
        this.f16270d = a(mediaFormat, "width");
        this.f16271e = a(mediaFormat, "height");
        this.f16273g = a(mediaFormat, "channel-count");
        this.f16274h = a(mediaFormat, "sample-rate");
        this.f16272f = mediaFormat.containsKey("com.google.android.videos.pixelWidthHeightRatio") ? mediaFormat.getFloat("com.google.android.videos.pixelWidthHeightRatio") : -1.0f;
        this.f16275i = new ArrayList();
        int i2 = 0;
        while (true) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i2);
            if (!mediaFormat.containsKey(sb.toString())) {
                break;
            }
            StringBuilder sb2 = new StringBuilder(15);
            sb2.append("csd-");
            sb2.append(i2);
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(sb2.toString());
            byte[] bArr = new byte[byteBuffer.limit()];
            byteBuffer.get(bArr);
            this.f16275i.add(bArr);
            byteBuffer.flip();
            i2++;
        }
        this.f16269c = mediaFormat.containsKey("durationUs") ? mediaFormat.getLong("durationUs") : -1L;
        this.f16276j = -1;
        this.f16277k = -1;
    }

    @TargetApi(16)
    private static final int a(MediaFormat mediaFormat, String str) {
        if (mediaFormat.containsKey(str)) {
            return mediaFormat.getInteger(str);
        }
        return -1;
    }

    @TargetApi(16)
    public static zzhj b(MediaFormat mediaFormat) {
        return new zzhj(mediaFormat);
    }

    public static zzhj c(String str, int i2, int i3, int i4, List<byte[]> list) {
        return g(str, -1, -1L, i3, i4, list);
    }

    public static zzhj d(String str, int i2, long j2, int i3, int i4, float f2, List<byte[]> list) {
        return new zzhj(str, -1, j2, i3, i4, f2, -1, -1, list);
    }

    public static zzhj e(String str, int i2, long j2, int i3, int i4, List<byte[]> list) {
        return d(str, -1, j2, i3, i4, 1.0f, list);
    }

    @TargetApi(16)
    private static final void f(MediaFormat mediaFormat, String str, int i2) {
        if (i2 != -1) {
            mediaFormat.setInteger(str, i2);
        }
    }

    public static zzhj g(String str, int i2, long j2, int i3, int i4, List<byte[]> list) {
        return new zzhj(str, i2, j2, -1, -1, -1.0f, i3, i4, list);
    }

    public static zzhj h() {
        return new zzhj("application/ttml+xml", -1, -1L, -1, -1, -1.0f, -1, -1, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzhj.class == obj.getClass()) {
            zzhj zzhjVar = (zzhj) obj;
            if (this.f16268b == zzhjVar.f16268b && this.f16270d == zzhjVar.f16270d && this.f16271e == zzhjVar.f16271e && this.f16272f == zzhjVar.f16272f && this.f16276j == zzhjVar.f16276j && this.f16277k == zzhjVar.f16277k && this.f16273g == zzhjVar.f16273g && this.f16274h == zzhjVar.f16274h && zzkq.d(this.a, zzhjVar.a) && this.f16275i.size() == zzhjVar.f16275i.size()) {
                for (int i2 = 0; i2 < this.f16275i.size(); i2++) {
                    if (!Arrays.equals(this.f16275i.get(i2), zzhjVar.f16275i.get(i2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.l == 0) {
            String str = this.a;
            int iHashCode = (((((((((((((((((((str == null ? 0 : str.hashCode()) + 527) * 31) + this.f16268b) * 31) + this.f16270d) * 31) + this.f16271e) * 31) + Float.floatToRawIntBits(this.f16272f)) * 31) + ((int) this.f16269c)) * 31) + this.f16276j) * 31) + this.f16277k) * 31) + this.f16273g) * 31) + this.f16274h;
            for (int i2 = 0; i2 < this.f16275i.size(); i2++) {
                iHashCode = (iHashCode * 31) + Arrays.hashCode(this.f16275i.get(i2));
            }
            this.l = iHashCode;
        }
        return this.l;
    }

    @TargetApi(16)
    public final MediaFormat i() {
        if (this.m == null) {
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", this.a);
            f(mediaFormat, "max-input-size", this.f16268b);
            f(mediaFormat, "width", this.f16270d);
            f(mediaFormat, "height", this.f16271e);
            f(mediaFormat, "channel-count", this.f16273g);
            f(mediaFormat, "sample-rate", this.f16274h);
            float f2 = this.f16272f;
            if (f2 != -1.0f) {
                mediaFormat.setFloat("com.google.android.videos.pixelWidthHeightRatio", f2);
            }
            for (int i2 = 0; i2 < this.f16275i.size(); i2++) {
                StringBuilder sb = new StringBuilder(15);
                sb.append("csd-");
                sb.append(i2);
                mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(this.f16275i.get(i2)));
            }
            long j2 = this.f16269c;
            if (j2 != -1) {
                mediaFormat.setLong("durationUs", j2);
            }
            f(mediaFormat, "max-width", this.f16276j);
            f(mediaFormat, "max-height", this.f16277k);
            this.m = mediaFormat;
        }
        return this.m;
    }

    public final String toString() {
        String str = this.a;
        int i2 = this.f16268b;
        int i3 = this.f16270d;
        int i4 = this.f16271e;
        float f2 = this.f16272f;
        int i5 = this.f16273g;
        int i6 = this.f16274h;
        long j2 = this.f16269c;
        int i7 = this.f16276j;
        int i8 = this.f16277k;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 143);
        sb.append("MediaFormat(");
        sb.append(str);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(i4);
        sb.append(", ");
        sb.append(f2);
        sb.append(", ");
        sb.append(i5);
        sb.append(", ");
        sb.append(i6);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(i7);
        sb.append(", ");
        sb.append(i8);
        sb.append(")");
        return sb.toString();
    }

    private zzhj(String str, int i2, long j2, int i3, int i4, float f2, int i5, int i6, List<byte[]> list) {
        this.a = str;
        this.f16268b = i2;
        this.f16269c = j2;
        this.f16270d = i3;
        this.f16271e = i4;
        this.f16272f = f2;
        this.f16273g = i5;
        this.f16274h = i6;
        this.f16275i = list == null ? Collections.emptyList() : list;
        this.f16276j = -1;
        this.f16277k = -1;
    }
}
