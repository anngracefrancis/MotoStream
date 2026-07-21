package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public final class zzhd extends zzgr {
    private final zzhi G;
    private final zzhh H;
    private final long I;
    private final int J;
    private final int K;
    private Surface L;
    private boolean M;
    private boolean N;
    private long O;
    private long P;
    private int Q;
    private int R;
    private int S;
    private float T;
    private int U;
    private int V;
    private float W;

    public zzhd(zzhn zzhnVar, int i2, long j2, Handler handler, zzhh zzhhVar, int i3) {
        this(zzhnVar, null, true, 1, 0L, null, handler, zzhhVar, -1);
    }

    private final void O(MediaCodec mediaCodec, int i2) {
        P();
        zzkp.a("renderVideoBufferImmediate");
        mediaCodec.releaseOutputBuffer(i2, true);
        zzkp.b();
        this.f16252b.f16231e++;
        this.N = true;
        Q();
    }

    private final void P() {
        Handler handler = this.f16261k;
        if (handler == null || this.H == null) {
            return;
        }
        int i2 = this.U;
        int i3 = this.R;
        if (i2 == i3 && this.V == this.S && this.W == this.T) {
            return;
        }
        int i4 = this.S;
        float f2 = this.T;
        handler.post(new jz(this, i3, i4, f2));
        this.U = i3;
        this.V = i4;
        this.W = f2;
    }

    private final void Q() {
        Handler handler = this.f16261k;
        if (handler == null || this.H == null || this.M) {
            return;
        }
        handler.post(new kz(this, this.L));
        this.M = true;
    }

    private final void R() {
        if (this.f16261k == null || this.H == null || this.Q == 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f16261k.post(new lz(this, this.Q, jElapsedRealtime - this.P));
        this.Q = 0;
        this.P = jElapsedRealtime;
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final void A(zzhj zzhjVar, MediaFormat mediaFormat) {
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        this.R = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        this.S = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final void B(zzhk zzhkVar) throws zzgd {
        super.B(zzhkVar);
        float f2 = zzhkVar.a.f16272f;
        if (f2 == -1.0f) {
            f2 = 1.0f;
        }
        this.T = f2;
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final boolean C(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i2, boolean z) {
        if (z) {
            zzkp.a("skipVideoBuffer");
            mediaCodec.releaseOutputBuffer(i2, false);
            zzkp.b();
            this.f16252b.f16232f++;
            return true;
        }
        long jElapsedRealtime = (bufferInfo.presentationTimeUs - j2) - ((SystemClock.elapsedRealtime() * 1000) - j3);
        long jNanoTime = System.nanoTime() + (jElapsedRealtime * 1000);
        if (jElapsedRealtime < -30000) {
            zzkp.a("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i2, false);
            zzkp.b();
            this.f16252b.f16233g++;
            int i3 = this.Q + 1;
            this.Q = i3;
            if (i3 == this.K) {
                R();
            }
            return true;
        }
        if (!this.N) {
            O(mediaCodec, i2);
            return true;
        }
        if (c() != 3) {
            return false;
        }
        if (zzkq.a >= 21) {
            if (jElapsedRealtime < 50000) {
                P();
                zzkp.a("releaseOutputBufferTimed");
                mediaCodec.releaseOutputBuffer(i2, jNanoTime);
                zzkp.b();
                this.f16252b.f16231e++;
                this.N = true;
                Q();
                return true;
            }
        } else if (jElapsedRealtime < 30000) {
            if (jElapsedRealtime > 11000) {
                try {
                    Thread.sleep((jElapsedRealtime - 10000) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            O(mediaCodec, i2);
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final boolean D(MediaCodec mediaCodec, boolean z, zzhj zzhjVar, zzhj zzhjVar2) {
        if (!zzhjVar2.a.equals(zzhjVar.a)) {
            return false;
        }
        if (z) {
            return true;
        }
        return zzhjVar.f16270d == zzhjVar2.f16270d && zzhjVar.f16271e == zzhjVar2.f16271e;
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final boolean E(String str) {
        return zzkl.a(str).equals("video") && super.E(str);
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final boolean I() {
        Surface surface;
        return super.I() && (surface = this.L) != null && surface.isValid();
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final boolean d() {
        if (super.d() && (this.N || !J() || M() == 2)) {
            this.O = -1L;
            return true;
        }
        if (this.O == -1) {
            return false;
        }
        if (SystemClock.elapsedRealtime() * 1000 < this.O) {
            return true;
        }
        this.O = -1L;
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final void e() {
        super.e();
        this.Q = 0;
        this.P = SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zzgf
    public final void f(int i2, Object obj) throws zzgd {
        if (i2 != 1) {
            super.f(i2, obj);
            return;
        }
        Surface surface = (Surface) obj;
        if (this.L != surface) {
            this.L = surface;
            this.M = false;
            int iC = c();
            if (iC == 2 || iC == 3) {
                K();
                H();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final void g() {
        this.O = -1L;
        R();
        super.g();
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final void i(long j2) throws zzgd {
        super.i(j2);
        this.N = false;
        this.O = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final void m(long j2, boolean z) {
        super.m(j2, z);
        this.N = false;
        if (!z || this.I <= 0) {
            return;
        }
        this.O = (SystemClock.elapsedRealtime() * 1000) + this.I;
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    public final void u() {
        this.R = -1;
        this.S = -1;
        this.T = -1.0f;
        this.U = -1;
        this.V = -1;
        this.W = -1.0f;
        super.u();
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final void y(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        mediaCodec.configure(mediaFormat, this.L, mediaCrypto, 0);
        mediaCodec.setVideoScalingMode(this.J);
    }

    private zzhd(zzhn zzhnVar, zzhz zzhzVar, boolean z, int i2, long j2, zzhi zzhiVar, Handler handler, zzhh zzhhVar, int i3) {
        super(zzhnVar, null, true, handler, zzhhVar);
        this.J = 1;
        this.I = 0L;
        this.G = null;
        this.H = zzhhVar;
        this.K = -1;
        this.O = -1L;
        this.R = -1;
        this.S = -1;
        this.T = -1.0f;
        this.U = -1;
        this.V = -1;
        this.W = -1.0f;
    }
}
