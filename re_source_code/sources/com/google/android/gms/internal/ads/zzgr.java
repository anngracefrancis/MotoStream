package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public abstract class zzgr extends zzhp {
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private long F;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzga f16252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzhz f16253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f16254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzhn f16255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzhm f16256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzhk f16257g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<Long> f16258h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MediaCodec.BufferInfo f16259i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzgw f16260j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected final Handler f16261k;
    private zzhj l;
    private zzhw m;
    private MediaCodec n;
    private boolean o;
    private ByteBuffer[] p;
    private ByteBuffer[] q;
    private long r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;
    private int z;

    public zzgr(zzhn zzhnVar, zzhz zzhzVar, boolean z, Handler handler, zzgw zzgwVar) {
        zzkh.d(zzkq.a >= 16);
        this.f16255e = zzhnVar;
        this.f16253c = null;
        this.f16254d = true;
        this.f16261k = handler;
        this.f16260j = zzgwVar;
        this.f16252b = new zzga();
        this.f16256f = new zzhm(0);
        this.f16257g = new zzhk();
        this.f16258h = new ArrayList();
        this.f16259i = new MediaCodec.BufferInfo();
        this.w = 0;
        this.x = 0;
    }

    /* JADX WARN: Code duplicated, block: B:77:0x0115  */
    private final boolean G(boolean z) throws zzgd, IOException {
        int iW;
        boolean z2;
        if (this.B || this.x == 2) {
            return false;
        }
        if (this.s < 0) {
            int iDequeueInputBuffer = this.n.dequeueInputBuffer(0L);
            this.s = iDequeueInputBuffer;
            if (iDequeueInputBuffer < 0) {
                return false;
            }
            zzhm zzhmVar = this.f16256f;
            ByteBuffer byteBuffer = this.p[iDequeueInputBuffer];
            zzhmVar.f16279b = byteBuffer;
            byteBuffer.clear();
        }
        if (this.x == 1) {
            this.n.queueInputBuffer(this.s, 0, 0, 0L, 4);
            this.s = -1;
            this.x = 2;
            return false;
        }
        if (this.D) {
            iW = -3;
        } else {
            if (this.w == 1) {
                for (int i2 = 0; i2 < this.l.f16275i.size(); i2++) {
                    this.f16256f.f16279b.put(this.l.f16275i.get(i2));
                }
                this.w = 2;
            }
            iW = this.f16255e.w(this.z, this.F, this.f16257g, this.f16256f, false);
            if (z && this.A == 1 && iW == -2) {
                this.A = 2;
            }
        }
        if (iW == -2) {
            return false;
        }
        if (iW == -5) {
            L();
            return true;
        }
        if (iW == -4) {
            if (this.w == 2) {
                this.f16256f.f16279b.clear();
                this.w = 1;
            }
            B(this.f16257g);
            return true;
        }
        if (iW == -1) {
            if (this.w == 2) {
                this.f16256f.f16279b.clear();
                this.w = 1;
            }
            this.B = true;
            try {
                this.n.queueInputBuffer(this.s, 0, 0, 0L, 4);
                this.s = -1;
                return false;
            } catch (MediaCodec.CryptoException e2) {
                x(e2);
                throw new zzgd(e2);
            }
        }
        if (this.E) {
            if (!this.f16256f.b()) {
                this.f16256f.f16279b.clear();
                if (this.w == 2) {
                    this.w = 1;
                }
                return true;
            }
            this.E = false;
        }
        boolean zA = this.f16256f.a();
        if (this.u) {
            int state = this.f16253c.getState();
            if (state == 0) {
                throw new zzgd(this.f16253c.b());
            }
            if (state == 4 || (!zA && this.f16254d)) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            z2 = false;
        }
        this.D = z2;
        if (z2) {
            return false;
        }
        try {
            int iPosition = this.f16256f.f16279b.position();
            zzhm zzhmVar2 = this.f16256f;
            int i3 = iPosition - zzhmVar2.f16280c;
            long j2 = zzhmVar2.f16282e;
            if ((zzhmVar2.f16281d & 134217728) != 0) {
                this.f16258h.add(Long.valueOf(j2));
            }
            if (zA) {
                MediaCodec.CryptoInfo cryptoInfoC = this.f16256f.a.c();
                if (i3 != 0) {
                    if (cryptoInfoC.numBytesOfClearData == null) {
                        cryptoInfoC.numBytesOfClearData = new int[1];
                    }
                    int[] iArr = cryptoInfoC.numBytesOfClearData;
                    iArr[0] = iArr[0] + i3;
                }
                this.n.queueSecureInputBuffer(this.s, 0, cryptoInfoC, j2, 0);
            } else {
                this.n.queueInputBuffer(this.s, 0, iPosition, j2, 0);
            }
            this.s = -1;
            this.y = true;
            this.w = 0;
            return true;
        } catch (MediaCodec.CryptoException e3) {
            x(e3);
            throw new zzgd(e3);
        }
    }

    private final void L() throws zzgd {
        this.r = -1L;
        this.s = -1;
        this.t = -1;
        this.E = true;
        this.D = false;
        this.f16258h.clear();
        if (zzkq.a < 18 || this.x != 0) {
            K();
            H();
        } else {
            this.n.flush();
            this.y = false;
        }
        if (!this.v || this.l == null) {
            return;
        }
        this.w = 1;
    }

    private final void x(MediaCodec.CryptoException cryptoException) {
        Handler handler = this.f16261k;
        if (handler == null || this.f16260j == null) {
            return;
        }
        handler.post(new dz(this, cryptoException));
    }

    private final void z(zzgv zzgvVar) throws zzgd {
        Handler handler = this.f16261k;
        if (handler != null && this.f16260j != null) {
            handler.post(new cz(this, zzgvVar));
        }
        throw new zzgd(zzgvVar);
    }

    protected void A(zzhj zzhjVar, MediaFormat mediaFormat) {
    }

    protected void B(zzhk zzhkVar) throws zzgd {
        zzhj zzhjVar = this.l;
        zzhj zzhjVar2 = zzhkVar.a;
        this.l = zzhjVar2;
        this.m = zzhkVar.f16278b;
        MediaCodec mediaCodec = this.n;
        if (mediaCodec != null && D(mediaCodec, this.o, zzhjVar, zzhjVar2)) {
            this.v = true;
            this.w = 1;
        } else if (this.y) {
            this.x = 1;
        } else {
            K();
            H();
        }
    }

    protected abstract boolean C(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i2, boolean z) throws zzgd;

    protected boolean D(MediaCodec mediaCodec, boolean z, zzhj zzhjVar, zzhj zzhjVar2) {
        return false;
    }

    protected boolean E(String str) {
        return true;
    }

    protected zzgc F(String str, boolean z) throws zzgz {
        return zzgx.b(str, z);
    }

    protected final void H() throws zzgd {
        MediaCrypto mediaCryptoD;
        zzgc zzgcVarF;
        if (I()) {
            String str = this.l.a;
            boolean zA = false;
            zzhw zzhwVar = this.m;
            if (zzhwVar != null) {
                zzhz zzhzVar = this.f16253c;
                if (zzhzVar == null) {
                    throw new zzgd("Media requires a DrmSessionManager");
                }
                if (!this.u) {
                    zzhzVar.c(zzhwVar);
                    this.u = true;
                }
                int state = this.f16253c.getState();
                if (state == 0) {
                    throw new zzgd(this.f16253c.b());
                }
                if (state != 3 && state != 4) {
                    return;
                }
                mediaCryptoD = this.f16253c.d();
                zA = this.f16253c.a(str);
            } else {
                mediaCryptoD = null;
            }
            try {
                zzgcVarF = F(str, zA);
            } catch (zzgz e2) {
                z(new zzgv(this.l, e2, -49998));
                zzgcVarF = null;
            }
            if (zzgcVarF == null) {
                z(new zzgv(this.l, (Throwable) null, -49999));
            }
            String str2 = zzgcVarF.a;
            this.o = zzgcVarF.f16240b;
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str2);
                this.n = mediaCodecCreateByCodecName;
                y(mediaCodecCreateByCodecName, str2, this.l.i(), mediaCryptoD);
                this.n.start();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                long j2 = jElapsedRealtime2 - jElapsedRealtime;
                Handler handler = this.f16261k;
                if (handler != null && this.f16260j != null) {
                    handler.post(new ez(this, str2, jElapsedRealtime2, j2));
                }
                this.p = this.n.getInputBuffers();
                this.q = this.n.getOutputBuffers();
            } catch (Exception e3) {
                z(new zzgv(this.l, e3, str2));
            }
            this.r = c() == 3 ? SystemClock.elapsedRealtime() : -1L;
            this.s = -1;
            this.t = -1;
            this.E = true;
            this.f16252b.a++;
        }
    }

    protected boolean I() {
        return this.n == null && this.l != null;
    }

    protected final boolean J() {
        return this.n != null;
    }

    protected final void K() {
        if (this.n != null) {
            this.r = -1L;
            this.s = -1;
            this.t = -1;
            this.D = false;
            this.f16258h.clear();
            this.p = null;
            this.q = null;
            this.v = false;
            this.y = false;
            this.o = false;
            this.w = 0;
            this.x = 0;
            this.f16252b.f16228b++;
            try {
                this.n.stop();
                try {
                    this.n.release();
                } finally {
                    this.n = null;
                }
            } catch (Throwable th) {
                try {
                    this.n.release();
                    throw th;
                } finally {
                    this.n = null;
                }
            }
        }
    }

    protected final int M() {
        return this.A;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected final long b() {
        return this.f16255e.v(this.z).f16284b;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected boolean d() {
        if (this.l != null && !this.D) {
            if (this.A == 0 && this.t < 0) {
                if (SystemClock.elapsedRealtime() < this.r + 1000) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected void e() {
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected void g() {
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected void i(long j2) throws zzgd {
        this.F = j2;
        this.f16255e.t(j2);
        this.A = 0;
        this.B = false;
        this.C = false;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected final void l(long j2, long j3) throws zzgd {
        int i2;
        boolean z;
        int i3;
        try {
            if (this.f16255e.x(j2)) {
                i2 = this.A;
                if (i2 == 0) {
                    i2 = 1;
                }
            } else {
                i2 = 0;
            }
            this.A = i2;
            if (this.n != null && this.f16255e.w(this.z, this.F, this.f16257g, this.f16256f, true) == -5) {
                L();
            }
            if (this.l == null && this.f16255e.w(this.z, this.F, this.f16257g, this.f16256f, false) == -4) {
                B(this.f16257g);
            }
            if (this.n == null && I()) {
                H();
            }
            if (this.n != null) {
                do {
                    if (this.C) {
                        z = false;
                    } else {
                        if (this.t < 0) {
                            this.t = this.n.dequeueOutputBuffer(this.f16259i, 0L);
                        }
                        int i4 = this.t;
                        if (i4 == -2) {
                            A(this.l, this.n.getOutputFormat());
                            this.f16252b.f16229c++;
                        } else if (i4 == -3) {
                            this.q = this.n.getOutputBuffers();
                            this.f16252b.f16230d++;
                        } else {
                            if (i4 >= 0) {
                                MediaCodec.BufferInfo bufferInfo = this.f16259i;
                                if ((bufferInfo.flags & 4) == 0) {
                                    long j4 = bufferInfo.presentationTimeUs;
                                    int size = this.f16258h.size();
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= size) {
                                            i3 = -1;
                                            break;
                                        } else {
                                            if (this.f16258h.get(i5).longValue() == j4) {
                                                i3 = i5;
                                                break;
                                            }
                                            i5++;
                                        }
                                    }
                                    MediaCodec mediaCodec = this.n;
                                    ByteBuffer[] byteBufferArr = this.q;
                                    int i6 = this.t;
                                    if (C(j2, j3, mediaCodec, byteBufferArr[i6], this.f16259i, i6, i3 != -1)) {
                                        if (i3 != -1) {
                                            this.f16258h.remove(i3);
                                        } else {
                                            this.F = this.f16259i.presentationTimeUs;
                                        }
                                        this.t = -1;
                                    }
                                } else if (this.x == 2) {
                                    K();
                                    H();
                                } else {
                                    this.C = true;
                                }
                            }
                            z = false;
                        }
                        z = true;
                    }
                } while (z);
                if (G(true)) {
                    while (G(false)) {
                    }
                }
            }
            this.f16252b.a();
        } catch (IOException e2) {
            throw new zzgd(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected void m(long j2, boolean z) {
        this.f16255e.q(this.z, j2);
        this.A = 0;
        this.B = false;
        this.C = false;
        this.D = false;
        this.F = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected final int o(long j2) throws zzgd {
        try {
            if (!this.f16255e.u(j2)) {
                return 0;
            }
            for (int i2 = 0; i2 < this.f16255e.s(); i2++) {
                if (E(this.f16255e.v(i2).a)) {
                    this.z = i2;
                    return 1;
                }
            }
            return -1;
        } catch (IOException e2) {
            throw new zzgd(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected final long q() {
        long jR = this.f16255e.r();
        return (jR == -1 || jR == -3) ? jR : Math.max(jR, t());
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected boolean s() {
        return this.C;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected long t() {
        return this.F;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected void u() {
        this.l = null;
        this.m = null;
        try {
            K();
            try {
                if (this.u) {
                    this.f16253c.close();
                    this.u = false;
                }
            } finally {
                this.f16255e.y(this.z);
            }
        } catch (Throwable th) {
            try {
                if (this.u) {
                    this.f16253c.close();
                    this.u = false;
                }
                throw th;
            } finally {
                this.f16255e.y(this.z);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected final void v() {
        this.f16255e.c();
    }

    protected void y(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        mediaCodec.configure(mediaFormat, (Surface) null, mediaCrypto, 0);
    }
}
