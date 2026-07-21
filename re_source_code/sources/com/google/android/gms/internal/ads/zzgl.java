package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
@Deprecated
public final class zzgl implements zzhn {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f16242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f16243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FileDescriptor f16244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f16245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f16246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MediaExtractor f16247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzho[] f16248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f16249i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f16250j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int[] f16251k;
    private boolean[] l;
    private long m;

    public zzgl(Context context, Uri uri, Map<String, String> map, int i2) {
        zzkh.d(zzkq.a >= 16);
        this.f16250j = 2;
        this.a = (Context) zzkh.c(context);
        this.f16242b = (Uri) zzkh.c(uri);
        this.f16243c = null;
        this.f16244d = null;
        this.f16245e = 0L;
        this.f16246f = 0L;
    }

    private final void a(long j2, boolean z) {
        if (!z && this.m == j2) {
            return;
        }
        this.m = j2;
        int i2 = 0;
        this.f16247g.seekTo(j2, 0);
        while (true) {
            int[] iArr = this.f16251k;
            if (i2 >= iArr.length) {
                return;
            }
            if (iArr[i2] != 0) {
                this.l[i2] = true;
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void c() {
        MediaExtractor mediaExtractor;
        zzkh.d(this.f16250j > 0);
        int i2 = this.f16250j - 1;
        this.f16250j = i2;
        if (i2 != 0 || (mediaExtractor = this.f16247g) == null) {
            return;
        }
        mediaExtractor.release();
        this.f16247g = null;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void q(int i2, long j2) {
        zzkh.d(this.f16249i);
        zzkh.d(this.f16251k[i2] == 0);
        this.f16251k[i2] = 1;
        this.f16247g.selectTrack(i2);
        a(j2, j2 != 0);
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final long r() {
        zzkh.d(this.f16249i);
        long cachedDuration = this.f16247g.getCachedDuration();
        if (cachedDuration == -1) {
            return -1L;
        }
        long sampleTime = this.f16247g.getSampleTime();
        if (sampleTime == -1) {
            return -3L;
        }
        return sampleTime + cachedDuration;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final int s() {
        zzkh.d(this.f16249i);
        return this.f16251k.length;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void t(long j2) {
        zzkh.d(this.f16249i);
        a(j2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final boolean u(long j2) throws IOException {
        if (!this.f16249i) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f16247g = mediaExtractor;
            Context context = this.a;
            if (context != null) {
                mediaExtractor.setDataSource(context, this.f16242b, (Map<String, String>) null);
            } else {
                mediaExtractor.setDataSource((FileDescriptor) null, 0L, 0L);
            }
            int[] iArr = new int[this.f16247g.getTrackCount()];
            this.f16251k = iArr;
            this.l = new boolean[iArr.length];
            this.f16248h = new zzho[iArr.length];
            for (int i2 = 0; i2 < this.f16251k.length; i2++) {
                MediaFormat trackFormat = this.f16247g.getTrackFormat(i2);
                this.f16248h[i2] = new zzho(trackFormat.getString("mime"), trackFormat.containsKey("durationUs") ? trackFormat.getLong("durationUs") : -1L);
            }
            this.f16249i = true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final zzho v(int i2) {
        zzkh.d(this.f16249i);
        return this.f16248h[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final int w(int i2, long j2, zzhk zzhkVar, zzhm zzhmVar, boolean z) {
        Map<UUID, byte[]> psshInfo;
        zzkh.d(this.f16249i);
        zzkh.d(this.f16251k[i2] != 0);
        boolean[] zArr = this.l;
        if (zArr[i2]) {
            zArr[i2] = false;
            return -5;
        }
        if (z) {
            return -2;
        }
        if (this.f16251k[i2] != 2) {
            zzhkVar.a = zzhj.b(this.f16247g.getTrackFormat(i2));
            zzhx zzhxVar = null;
            if (zzkq.a >= 18 && (psshInfo = this.f16247g.getPsshInfo()) != null && !psshInfo.isEmpty()) {
                zzhxVar = new zzhx("video/mp4");
                zzhxVar.a(psshInfo);
            }
            zzhkVar.f16278b = zzhxVar;
            this.f16251k[i2] = 2;
            return -4;
        }
        int sampleTrackIndex = this.f16247g.getSampleTrackIndex();
        if (sampleTrackIndex != i2) {
            return sampleTrackIndex < 0 ? -1 : -2;
        }
        ByteBuffer byteBuffer = zzhmVar.f16279b;
        if (byteBuffer != null) {
            int iPosition = byteBuffer.position();
            int sampleData = this.f16247g.readSampleData(zzhmVar.f16279b, iPosition);
            zzhmVar.f16280c = sampleData;
            zzhmVar.f16279b.position(iPosition + sampleData);
        } else {
            zzhmVar.f16280c = 0;
        }
        zzhmVar.f16282e = this.f16247g.getSampleTime();
        zzhmVar.f16281d = this.f16247g.getSampleFlags() & 3;
        if (zzhmVar.a()) {
            zzhmVar.a.b(this.f16247g);
        }
        this.m = -1L;
        this.f16247g.advance();
        return -3;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final boolean x(long j2) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void y(int i2) {
        zzkh.d(this.f16249i);
        zzkh.d(this.f16251k[i2] != 0);
        this.f16247g.unselectTrack(i2);
        this.l[i2] = false;
        this.f16251k[i2] = 0;
    }
}
