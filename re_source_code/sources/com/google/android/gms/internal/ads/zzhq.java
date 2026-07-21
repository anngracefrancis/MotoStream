package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.ConditionVariable;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public final class zzhq {
    private boolean A;
    private int B;
    private final ConditionVariable a = new ConditionVariable(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f16285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final nz f16286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AudioTrack f16287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f16290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f16291h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f16292i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f16293j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f16294k;
    private int l;
    private long m;
    private long n;
    private boolean o;
    private long p;
    private Method q;
    private long r;
    private int s;
    private long t;
    private long u;
    private long v;
    private float w;
    private byte[] x;
    private int y;
    private int z;

    public zzhq() {
        mz mzVar = null;
        if (zzkq.a >= 18) {
            try {
                this.q = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzkq.a >= 19) {
            this.f16286c = new oz();
        } else {
            this.f16286c = new nz(mzVar);
        }
        this.f16285b = new long[10];
        this.w = 1.0f;
        this.s = 0;
    }

    private final long i(long j2) {
        if (!this.A) {
            return j2 / ((long) this.f16291h);
        }
        int i2 = this.B;
        if (i2 == 0) {
            return 0L;
        }
        return ((j2 << 3) * ((long) this.f16288e)) / ((long) (i2 * 1000));
    }

    private final long j(long j2) {
        return (j2 * 1000000) / ((long) this.f16288e);
    }

    private final long k(long j2) {
        return (j2 * ((long) this.f16288e)) / 1000000;
    }

    private final void o() {
        this.m = 0L;
        this.l = 0;
        this.f16294k = 0;
        this.n = 0L;
        this.o = false;
        this.p = 0L;
    }

    public final boolean a() {
        return this.f16287d != null;
    }

    public final void b() {
        if (a()) {
            o();
            this.f16287d.pause();
        }
    }

    public final void c() {
        if (a()) {
            this.u = System.nanoTime() / 1000;
            this.f16287d.play();
        }
    }

    public final void d() {
        if (a()) {
            this.r = 0L;
            this.z = 0;
            this.t = 0L;
            this.v = 0L;
            o();
            if (this.f16287d.getPlayState() == 3) {
                this.f16287d.pause();
            }
            AudioTrack audioTrack = this.f16287d;
            this.f16287d = null;
            this.f16286c.a(null, false);
            this.a.close();
            new mz(this, audioTrack).start();
        }
    }

    public final void e(float f2) {
        this.w = f2;
        if (a()) {
            if (zzkq.a >= 21) {
                this.f16287d.setVolume(f2);
            } else {
                this.f16287d.setStereoVolume(f2, f2);
            }
        }
    }

    public final int f(ByteBuffer byteBuffer, int i2, int i3, long j2) throws zzhv {
        int i4;
        if (i3 == 0) {
            return 2;
        }
        int i5 = zzkq.a;
        int iWrite = 0;
        if (i5 <= 22 && this.A) {
            if (this.f16287d.getPlayState() == 2) {
                return 0;
            }
            if (this.f16287d.getPlayState() == 1 && this.f16286c.c() != 0) {
                return 0;
            }
        }
        if (this.z != 0) {
            i4 = 0;
        } else {
            if (this.A && this.B == 0) {
                this.B = zzkg.a(i3, this.f16288e);
            }
            long j3 = j2 - j(i(i3));
            long j4 = this.t;
            if (j4 == 0) {
                this.t = Math.max(0L, j3);
                this.s = 1;
            } else {
                long j5 = j4 + j(i(this.r));
                if (this.s == 1 && Math.abs(j5 - j3) > 200000) {
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Discontinuity detected [expected ");
                    sb.append(j5);
                    sb.append(", got ");
                    sb.append(j3);
                    sb.append("]");
                    Log.e("AudioTrack", sb.toString());
                    this.s = 2;
                }
                if (this.s == 2) {
                    this.t += j3 - j5;
                    this.s = 1;
                    i4 = 1;
                }
            }
            i4 = 0;
        }
        if (this.z == 0) {
            this.z = i3;
            byteBuffer.position(i2);
            if (i5 < 21) {
                byte[] bArr = this.x;
                if (bArr == null || bArr.length < i3) {
                    this.x = new byte[i3];
                }
                byteBuffer.get(this.x, 0, i3);
                this.y = 0;
            }
        }
        if (i5 < 21) {
            int iC = this.f16293j - ((int) (this.r - (this.f16286c.c() * ((long) this.f16291h))));
            if (iC > 0) {
                iWrite = this.f16287d.write(this.x, this.y, Math.min(this.z, iC));
                if (iWrite >= 0) {
                    this.y += iWrite;
                }
            }
        } else {
            iWrite = this.f16287d.write(byteBuffer, this.z, 1);
        }
        if (iWrite < 0) {
            throw new zzhv(iWrite);
        }
        int i6 = this.z - iWrite;
        this.z = i6;
        this.r += (long) iWrite;
        return i6 == 0 ? i4 | 2 : i4;
    }

    public final void h(MediaFormat mediaFormat, int i2) {
        int i3;
        int i4;
        int integer = mediaFormat.getInteger("channel-count");
        if (integer == 1) {
            i3 = 4;
        } else if (integer == 2) {
            i3 = 12;
        } else if (integer == 6) {
            i3 = 252;
        } else {
            if (integer != 8) {
                StringBuilder sb = new StringBuilder(38);
                sb.append("Unsupported channel count: ");
                sb.append(integer);
                throw new IllegalArgumentException(sb.toString());
            }
            i3 = 1020;
        }
        int integer2 = mediaFormat.getInteger("sample-rate");
        String string = mediaFormat.getString("mime");
        if ("audio/ac3".equals(string)) {
            i4 = 5;
        } else if ("audio/eac3".equals(string)) {
            i4 = 6;
        } else {
            i4 = zzkl.b(string) ? 2 : 0;
        }
        boolean z = i4 == 5 || i4 == 6;
        if (a() && this.f16288e == integer2 && this.f16289f == i3 && !this.A && !z) {
            return;
        }
        d();
        this.f16290g = i4;
        this.f16288e = integer2;
        this.f16289f = i3;
        this.A = z;
        this.B = 0;
        this.f16291h = integer * 2;
        int minBufferSize = AudioTrack.getMinBufferSize(integer2, i3, i4);
        this.f16292i = minBufferSize;
        zzkh.d(minBufferSize != -2);
        int i5 = this.f16292i << 2;
        int iK = ((int) k(250000L)) * this.f16291h;
        int iMax = (int) Math.max(this.f16292i, k(750000L) * ((long) this.f16291h));
        if (i5 < iK) {
            i5 = iK;
        } else if (i5 > iMax) {
            i5 = iMax;
        }
        this.f16293j = i5;
    }

    public final void l() {
        if (this.s == 1) {
            this.s = 2;
        }
    }

    public final boolean m() {
        if (a()) {
            return i(this.r) > this.f16286c.c() || this.f16286c.b();
        }
        return false;
    }

    public final boolean n() {
        return this.r > ((long) ((this.f16292i * 3) / 2));
    }

    public final long p(boolean z) {
        long jD;
        long j2;
        if (!(a() && this.t != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.f16287d.getPlayState() == 3) {
            long jD2 = this.f16286c.d();
            if (jD2 != 0) {
                long jNanoTime = System.nanoTime() / 1000;
                if (jNanoTime - this.n >= 30000) {
                    long[] jArr = this.f16285b;
                    int i2 = this.f16294k;
                    jArr[i2] = jD2 - jNanoTime;
                    this.f16294k = (i2 + 1) % 10;
                    int i3 = this.l;
                    if (i3 < 10) {
                        this.l = i3 + 1;
                    }
                    this.n = jNanoTime;
                    this.m = 0L;
                    int i4 = 0;
                    while (true) {
                        int i5 = this.l;
                        if (i4 >= i5) {
                            break;
                        }
                        this.m += this.f16285b[i4] / ((long) i5);
                        i4++;
                    }
                }
                if (!this.A && jNanoTime - this.p >= 500000) {
                    boolean zE = this.f16286c.e();
                    this.o = zE;
                    if (zE) {
                        long jF = this.f16286c.f() / 1000;
                        long jG = this.f16286c.g();
                        if (jF < this.u) {
                            this.o = false;
                        } else if (Math.abs(jF - jNanoTime) > 5000000) {
                            this.o = false;
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(jG);
                            sb.append(", ");
                            sb.append(jF);
                            sb.append(", ");
                            sb.append(jNanoTime);
                            sb.append(", ");
                            sb.append(jD2);
                            Log.w("AudioTrack", sb.toString());
                        } else if (Math.abs(j(jG) - jD2) > 5000000) {
                            this.o = false;
                            StringBuilder sb2 = new StringBuilder(138);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(jG);
                            sb2.append(", ");
                            sb2.append(jF);
                            sb2.append(", ");
                            sb2.append(jNanoTime);
                            sb2.append(", ");
                            sb2.append(jD2);
                            Log.w("AudioTrack", sb2.toString());
                        }
                    }
                    Method method = this.q;
                    if (method != null) {
                        try {
                            long jIntValue = (((long) ((Integer) method.invoke(this.f16287d, null)).intValue()) * 1000) - j(i(this.f16293j));
                            this.v = jIntValue;
                            long jMax = Math.max(jIntValue, 0L);
                            this.v = jMax;
                            if (jMax > 5000000) {
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(jMax);
                                Log.w("AudioTrack", sb3.toString());
                                this.v = 0L;
                            }
                        } catch (Exception unused) {
                            this.q = null;
                        }
                    }
                    this.p = jNanoTime;
                }
            }
        }
        long jNanoTime2 = System.nanoTime() / 1000;
        if (this.o) {
            return j(this.f16286c.g() + k(jNanoTime2 - (this.f16286c.f() / 1000))) + this.t;
        }
        if (this.l == 0) {
            jD = this.f16286c.d();
            j2 = this.t;
        } else {
            jD = jNanoTime2 + this.m;
            j2 = this.t;
        }
        long j3 = jD + j2;
        return !z ? j3 - this.v : j3;
    }

    public final int q(int i2) throws zzhu {
        this.a.block();
        if (i2 == 0) {
            this.f16287d = new AudioTrack(3, this.f16288e, this.f16289f, this.f16290g, this.f16293j, 1);
        } else {
            this.f16287d = new AudioTrack(3, this.f16288e, this.f16289f, this.f16290g, this.f16293j, 1, i2);
        }
        int state = this.f16287d.getState();
        if (state == 1) {
            int audioSessionId = this.f16287d.getAudioSessionId();
            this.f16286c.a(this.f16287d, this.A);
            e(this.w);
            return audioSessionId;
        }
        try {
            this.f16287d.release();
        } catch (Exception unused) {
        } finally {
            this.f16287d = null;
        }
        throw new zzhu(state, this.f16288e, this.f16289f, this.f16293j);
    }
}
