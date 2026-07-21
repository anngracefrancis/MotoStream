package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public final class zzth extends zzpe {
    private static final int[] V = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private long A0;
    private int B0;
    private final Context W;
    private final zztl X;
    private final zzto Y;
    private final long Z;
    private final int a0;
    private final boolean b0;
    private final long[] c0;
    private zzlh[] d0;
    private zztj e0;
    private Surface f0;
    private Surface g0;
    private int h0;
    private boolean i0;
    private long j0;
    private long k0;
    private int l0;
    private int m0;
    private int n0;
    private float o0;
    private int p0;
    private int q0;
    private int r0;
    private float s0;
    private int t0;
    private int u0;
    private int v0;
    private float w0;
    private boolean x0;
    private int y0;
    t30 z0;

    public zzth(Context context, zzpg zzpgVar, long j2, Handler handler, zztn zztnVar, int i2) {
        this(context, zzpgVar, 0L, null, false, handler, zztnVar, -1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    private static int a0(String str, int i2, int i3) {
        int iJ;
        if (i2 == -1 || i3 == -1) {
            return -1;
        }
        str.hashCode();
        int i4 = 4;
        switch (str) {
            case "video/3gpp":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                iJ = i2 * i3;
                i4 = 2;
                return (iJ * 3) / (i4 * 2);
            case "video/hevc":
            case "video/x-vnd.on2.vp9":
                iJ = i2 * i3;
                return (iJ * 3) / (i4 * 2);
            case "video/avc":
                if ("BRAVIA 4K 2015".equals(zzsy.f16742d)) {
                    return -1;
                }
                iJ = ((zzsy.j(i2, 16) * zzsy.j(i3, 16)) << 4) << 4;
                i4 = 2;
                return (iJ * 3) / (i4 * 2);
            default:
                return -1;
        }
    }

    private final void b0(MediaCodec mediaCodec, int i2, long j2) {
        zzsx.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        zzsx.b();
        this.U.f16498e++;
    }

    @TargetApi(21)
    private final void c0(MediaCodec mediaCodec, int i2, long j2, long j3) {
        f0();
        zzsx.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, j3);
        zzsx.b();
        this.U.f16497d++;
        this.m0 = 0;
        l0();
    }

    private static boolean d0(boolean z, zzlh zzlhVar, zzlh zzlhVar2) {
        if (!zzlhVar.f16427k.equals(zzlhVar2.f16427k) || i0(zzlhVar) != i0(zzlhVar2)) {
            return false;
        }
        if (z) {
            return true;
        }
        return zzlhVar.o == zzlhVar2.o && zzlhVar.p == zzlhVar2.p;
    }

    private final void e0(MediaCodec mediaCodec, int i2, long j2) {
        f0();
        zzsx.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, true);
        zzsx.b();
        this.U.f16497d++;
        this.m0 = 0;
        l0();
    }

    private final void f0() {
        int i2 = this.t0;
        int i3 = this.p0;
        if (i2 == i3 && this.u0 == this.q0 && this.v0 == this.r0 && this.w0 == this.s0) {
            return;
        }
        this.Y.b(i3, this.q0, this.r0, this.s0);
        this.t0 = this.p0;
        this.u0 = this.q0;
        this.v0 = this.r0;
        this.w0 = this.s0;
    }

    private static boolean g0(long j2) {
        return j2 < -30000;
    }

    private static int h0(zzlh zzlhVar) {
        int i2 = zzlhVar.l;
        return i2 != -1 ? i2 : a0(zzlhVar.f16427k, zzlhVar.o, zzlhVar.p);
    }

    private static int i0(zzlh zzlhVar) {
        int i2 = zzlhVar.r;
        if (i2 == -1) {
            return 0;
        }
        return i2;
    }

    private final void j0() {
        this.j0 = this.Z > 0 ? SystemClock.elapsedRealtime() + this.Z : -9223372036854775807L;
    }

    private final void k0() {
        MediaCodec mediaCodecW;
        this.i0 = false;
        if (zzsy.a < 23 || !this.x0 || (mediaCodecW = W()) == null) {
            return;
        }
        this.z0 = new t30(this, mediaCodecW);
    }

    private final void m0() {
        this.t0 = -1;
        this.u0 = -1;
        this.w0 = -1.0f;
        this.v0 = -1;
    }

    private final void n0() {
        if (this.t0 == -1 && this.u0 == -1) {
            return;
        }
        this.Y.b(this.p0, this.q0, this.r0, this.s0);
    }

    private final void o0() {
        if (this.l0 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.Y.h(this.l0, jElapsedRealtime - this.k0);
            this.l0 = 0;
            this.k0 = jElapsedRealtime;
        }
    }

    private final boolean p0(boolean z) {
        if (zzsy.a < 23 || this.x0) {
            return false;
        }
        return !z || zztd.b(this.W);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void A(zzlh zzlhVar) throws zzku {
        super.A(zzlhVar);
        this.Y.d(zzlhVar);
        float f2 = zzlhVar.s;
        if (f2 == -1.0f) {
            f2 = 1.0f;
        }
        this.o0 = f2;
        this.n0 = i0(zzlhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzlo
    public final boolean B() {
        Surface surface;
        if (super.B() && (this.i0 || (((surface = this.g0) != null && this.f0 == surface) || W() == null))) {
            this.j0 = -9223372036854775807L;
            return true;
        }
        if (this.j0 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.j0) {
            return true;
        }
        this.j0 = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void R(String str, long j2, long j3) {
        this.Y.f(str, j2, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void U() {
        Surface surface;
        try {
            super.U();
            surface = this.g0;
            if (surface != null) {
                if (this.f0 == surface) {
                    this.f0 = null;
                }
            }
        } finally {
            if (this.g0 != null) {
                Surface surface2 = this.f0;
                surface = this.g0;
                if (surface2 == surface) {
                    this.f0 = null;
                }
                surface.release();
                this.g0 = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzks, com.google.android.gms.internal.ads.zzkx
    public final void f(int i2, Object obj) throws zzku {
        if (i2 != 1) {
            if (i2 != 4) {
                super.f(i2, obj);
                return;
            }
            this.h0 = ((Integer) obj).intValue();
            MediaCodec mediaCodecW = W();
            if (mediaCodecW != null) {
                mediaCodecW.setVideoScalingMode(this.h0);
                return;
            }
            return;
        }
        Surface surfaceA = (Surface) obj;
        if (surfaceA == null) {
            Surface surface = this.g0;
            if (surface != null) {
                surfaceA = surface;
            } else {
                zzpd zzpdVarX = X();
                if (zzpdVarX != null && p0(zzpdVarX.f16571d)) {
                    surfaceA = zztd.a(this.W, zzpdVarX.f16571d);
                    this.g0 = surfaceA;
                }
            }
        }
        if (this.f0 == surfaceA) {
            if (surfaceA == null || surfaceA == this.g0) {
                return;
            }
            n0();
            if (this.i0) {
                this.Y.c(this.f0);
                return;
            }
            return;
        }
        this.f0 = surfaceA;
        int state = getState();
        if (state == 1 || state == 2) {
            MediaCodec mediaCodecW2 = W();
            if (zzsy.a < 23 || mediaCodecW2 == null || surfaceA == null) {
                U();
                T();
            } else {
                mediaCodecW2.setOutputSurface(surfaceA);
            }
        }
        if (surfaceA == null || surfaceA == this.g0) {
            m0();
            k0();
            return;
        }
        n0();
        k0();
        if (state == 2) {
            j0();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    protected final void h() {
        super.h();
        this.l0 = 0;
        this.k0 = SystemClock.elapsedRealtime();
        this.j0 = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    protected final void i() {
        o0();
        super.i();
    }

    @Override // com.google.android.gms.internal.ads.zzks
    protected final void k(zzlh[] zzlhVarArr, long j2) throws zzku {
        this.d0 = zzlhVarArr;
        if (this.A0 == -9223372036854775807L) {
            this.A0 = j2;
        } else {
            int i2 = this.B0;
            long[] jArr = this.c0;
            if (i2 == jArr.length) {
                long j3 = jArr[i2 - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j3);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.B0 = i2 + 1;
            }
            this.c0[this.B0 - 1] = j2;
        }
        super.k(zzlhVarArr, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    protected final void l(long j2, boolean z) throws zzku {
        super.l(j2, z);
        k0();
        this.m0 = 0;
        int i2 = this.B0;
        if (i2 != 0) {
            this.A0 = this.c0[i2 - 1];
            this.B0 = 0;
        }
        if (z) {
            j0();
        } else {
            this.j0 = -9223372036854775807L;
        }
    }

    final void l0() {
        if (this.i0) {
            return;
        }
        this.i0 = true;
        this.Y.c(this.f0);
    }

    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    protected final void n() {
        this.p0 = -1;
        this.q0 = -1;
        this.s0 = -1.0f;
        this.o0 = -1.0f;
        this.A0 = -9223372036854775807L;
        this.B0 = 0;
        m0();
        k0();
        this.X.a();
        this.z0 = null;
        this.x0 = false;
        try {
            super.n();
        } finally {
            this.U.a();
            this.Y.g(this.U);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    protected final void o(boolean z) throws zzku {
        super.o(z);
        int i2 = p().f16434b;
        this.y0 = i2;
        this.x0 = i2 != 0;
        this.Y.e(this.U);
        this.X.b();
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void r(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        this.p0 = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        int integer = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        this.q0 = integer;
        float f2 = this.o0;
        this.s0 = f2;
        if (zzsy.a >= 21) {
            int i2 = this.n0;
            if (i2 == 90 || i2 == 270) {
                int i3 = this.p0;
                this.p0 = integer;
                this.q0 = i3;
                this.s0 = 1.0f / f2;
            }
        } else {
            this.r0 = this.n0;
        }
        mediaCodec.setVideoScalingMode(this.h0);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final int s(zzpg zzpgVar, zzlh zzlhVar) throws zzpk {
        boolean z;
        int i2;
        int i3;
        String str = zzlhVar.f16427k;
        if (!zzsp.c(str)) {
            return 0;
        }
        zzne zzneVar = zzlhVar.n;
        if (zzneVar != null) {
            z = false;
            for (int i4 = 0; i4 < zzneVar.f16507h; i4++) {
                z |= zzneVar.a(i4).f16512j;
            }
        } else {
            z = false;
        }
        zzpd zzpdVarB = zzpgVar.b(str, z);
        if (zzpdVarB == null) {
            return 1;
        }
        boolean zD = zzpdVarB.d(zzlhVar.f16424h);
        if (zD && (i2 = zzlhVar.o) > 0 && (i3 = zzlhVar.p) > 0) {
            if (zzsy.a >= 21) {
                zD = zzpdVarB.b(i2, i3, zzlhVar.q);
            } else {
                boolean z2 = i2 * i3 <= zzpi.g();
                if (!z2) {
                    int i5 = zzlhVar.o;
                    int i6 = zzlhVar.p;
                    String str2 = zzsy.f16743e;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i5);
                    sb.append("x");
                    sb.append(i6);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
                zD = z2;
            }
        }
        return (zD ? 3 : 2) | (zzpdVarB.f16569b ? 8 : 4) | (zzpdVarB.f16570c ? 16 : 0);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void u(zznd zzndVar) {
        if (zzsy.a >= 23 || !this.x0) {
            return;
        }
        l0();
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void v(zzpd zzpdVar, MediaCodec mediaCodec, zzlh zzlhVar, MediaCrypto mediaCrypto) throws zzpk {
        zztj zztjVar;
        String str;
        Point point;
        zzlh[] zzlhVarArr = this.d0;
        int iMax = zzlhVar.o;
        int iMax2 = zzlhVar.p;
        int iH0 = h0(zzlhVar);
        if (zzlhVarArr.length == 1) {
            zztjVar = new zztj(iMax, iMax2, iH0);
        } else {
            boolean z = false;
            for (zzlh zzlhVar2 : zzlhVarArr) {
                if (d0(zzpdVar.f16569b, zzlhVar, zzlhVar2)) {
                    int i2 = zzlhVar2.o;
                    z |= i2 == -1 || zzlhVar2.p == -1;
                    iMax = Math.max(iMax, i2);
                    iMax2 = Math.max(iMax2, zzlhVar2.p);
                    iH0 = Math.max(iH0, h0(zzlhVar2));
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(iMax);
                sb.append("x");
                sb.append(iMax2);
                String str2 = "MediaCodecVideoRenderer";
                Log.w("MediaCodecVideoRenderer", sb.toString());
                int i3 = zzlhVar.p;
                int i4 = zzlhVar.o;
                boolean z2 = i3 > i4;
                int i5 = z2 ? i3 : i4;
                if (z2) {
                    i3 = i4;
                }
                float f2 = i3 / i5;
                int[] iArr = V;
                int length = iArr.length;
                int i6 = 0;
                while (true) {
                    if (i6 < length) {
                        int i7 = length;
                        int i8 = iArr[i6];
                        int[] iArr2 = iArr;
                        int i9 = (int) (i8 * f2);
                        if (i8 > i5 && i9 > i3) {
                            int i10 = i3;
                            float f3 = f2;
                            if (zzsy.a >= 21) {
                                int i11 = z2 ? i9 : i8;
                                if (!z2) {
                                    i8 = i9;
                                }
                                point = zzpdVar.i(i11, i8);
                                str = str2;
                                if (zzpdVar.b(point.x, point.y, zzlhVar.q)) {
                                    break;
                                }
                                i6++;
                                length = i7;
                                iArr = iArr2;
                                i3 = i10;
                                f2 = f3;
                                str2 = str;
                            } else {
                                str = str2;
                                int iJ = zzsy.j(i8, 16) << 4;
                                int iJ2 = zzsy.j(i9, 16) << 4;
                                if (iJ * iJ2 <= zzpi.g()) {
                                    int i12 = z2 ? iJ2 : iJ;
                                    if (!z2) {
                                        iJ = iJ2;
                                    }
                                    point = new Point(i12, iJ);
                                    break;
                                }
                                i6++;
                                length = i7;
                                iArr = iArr2;
                                i3 = i10;
                                f2 = f3;
                                str2 = str;
                            }
                        }
                    }
                    str = str2;
                    point = null;
                    break;
                }
                if (point != null) {
                    iMax = Math.max(iMax, point.x);
                    iMax2 = Math.max(iMax2, point.y);
                    iH0 = Math.max(iH0, a0(zzlhVar.f16427k, iMax, iMax2));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(iMax);
                    sb2.append("x");
                    sb2.append(iMax2);
                    Log.w(str, sb2.toString());
                }
            }
            zztjVar = new zztj(iMax, iMax2, iH0);
        }
        this.e0 = zztjVar;
        boolean z3 = this.b0;
        int i13 = this.y0;
        MediaFormat mediaFormatM = zzlhVar.m();
        mediaFormatM.setInteger("max-width", zztjVar.a);
        mediaFormatM.setInteger("max-height", zztjVar.f16763b);
        int i14 = zztjVar.f16764c;
        if (i14 != -1) {
            mediaFormatM.setInteger("max-input-size", i14);
        }
        if (z3) {
            mediaFormatM.setInteger("auto-frc", 0);
        }
        if (i13 != 0) {
            mediaFormatM.setFeatureEnabled("tunneled-playback", true);
            mediaFormatM.setInteger("audio-session-id", i13);
        }
        if (this.f0 == null) {
            zzsk.e(p0(zzpdVar.f16571d));
            if (this.g0 == null) {
                this.g0 = zztd.a(this.W, zzpdVar.f16571d);
            }
            this.f0 = this.g0;
        }
        mediaCodec.configure(mediaFormatM, this.f0, (MediaCrypto) null, 0);
        if (zzsy.a < 23 || !this.x0) {
            return;
        }
        this.z0 = new t30(this, mediaCodec);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final boolean x(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z) {
        while (true) {
            int i4 = this.B0;
            if (i4 == 0) {
                break;
            }
            long[] jArr = this.c0;
            if (j4 < jArr[0]) {
                break;
            }
            this.A0 = jArr[0];
            int i5 = i4 - 1;
            this.B0 = i5;
            System.arraycopy(jArr, 1, jArr, 0, i5);
        }
        long j5 = j4 - this.A0;
        if (z) {
            b0(mediaCodec, i2, j5);
            return true;
        }
        long j6 = j4 - j2;
        if (this.f0 == this.g0) {
            if (!g0(j6)) {
                return false;
            }
            b0(mediaCodec, i2, j5);
            return true;
        }
        if (!this.i0) {
            if (zzsy.a >= 21) {
                c0(mediaCodec, i2, j5, System.nanoTime());
            } else {
                e0(mediaCodec, i2, j5);
            }
            return true;
        }
        if (getState() != 2) {
            return false;
        }
        long jElapsedRealtime = j6 - ((SystemClock.elapsedRealtime() * 1000) - j3);
        long jNanoTime = System.nanoTime();
        long jC = this.X.c(j4, (jElapsedRealtime * 1000) + jNanoTime);
        long j7 = (jC - jNanoTime) / 1000;
        if (!g0(j7)) {
            if (zzsy.a >= 21) {
                if (j7 < 50000) {
                    c0(mediaCodec, i2, j5, jC);
                    return true;
                }
            } else if (j7 < 30000) {
                if (j7 > 11000) {
                    try {
                        Thread.sleep((j7 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                e0(mediaCodec, i2, j5);
                return true;
            }
            return false;
        }
        zzsx.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        zzsx.b();
        zznc zzncVar = this.U;
        zzncVar.f16499f++;
        this.l0++;
        int i6 = this.m0 + 1;
        this.m0 = i6;
        zzncVar.f16500g = Math.max(i6, zzncVar.f16500g);
        if (this.l0 == this.a0) {
            o0();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final boolean y(MediaCodec mediaCodec, boolean z, zzlh zzlhVar, zzlh zzlhVar2) {
        if (!d0(z, zzlhVar, zzlhVar2)) {
            return false;
        }
        int i2 = zzlhVar2.o;
        zztj zztjVar = this.e0;
        return i2 <= zztjVar.a && zzlhVar2.p <= zztjVar.f16763b && zzlhVar2.l <= zztjVar.f16764c;
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final boolean z(zzpd zzpdVar) {
        return this.f0 != null || p0(zzpdVar.f16571d);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzth(Context context, zzpg zzpgVar, long j2, zznj<Object> zznjVar, boolean z, Handler handler, zztn zztnVar, int i2) {
        super(2, zzpgVar, null, false);
        boolean z2 = false;
        this.Z = 0L;
        this.a0 = -1;
        this.W = context.getApplicationContext();
        this.X = new zztl(context);
        this.Y = new zzto(handler, zztnVar);
        if (zzsy.a <= 22 && "foster".equals(zzsy.f16740b) && "NVIDIA".equals(zzsy.f16741c)) {
            z2 = true;
        }
        this.b0 = z2;
        this.c0 = new long[10];
        this.A0 = -9223372036854775807L;
        this.j0 = -9223372036854775807L;
        this.p0 = -1;
        this.q0 = -1;
        this.s0 = -1.0f;
        this.o0 = -1.0f;
        this.h0 = 1;
        m0();
    }
}
