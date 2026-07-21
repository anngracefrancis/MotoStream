package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes2.dex */
public final class zzmh {
    private long A;
    private long B;
    private boolean C;
    private long D;
    private Method E;
    private int F;
    private long G;
    private long H;
    private int I;
    private long J;
    private long K;
    private int L;
    private int M;
    private long N;
    private long O;
    private long P;
    private float Q;
    private zzlx[] R;
    private ByteBuffer[] S;
    private ByteBuffer T;
    private ByteBuffer U;
    private byte[] V;
    private int W;
    private int X;
    private boolean Y;
    private boolean Z;
    private int a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e10 f16457b;
    private boolean b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzmx f16458c;
    private boolean c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzlx[] f16459d;
    private long d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzmn f16460e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long[] f16462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final b10 f16463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LinkedList<d10> f16464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AudioTrack f16465j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f16466k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private int q;
    private long r;
    private zzln s;
    private zzln t;
    private long u;
    private long v;
    private ByteBuffer w;
    private int x;
    private int y;
    private int z;
    private final zzlw a = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConditionVariable f16461f = new ConditionVariable(true);

    public zzmh(zzlw zzlwVar, zzlx[] zzlxVarArr, zzmn zzmnVar) {
        a10 a10Var = null;
        this.f16460e = zzmnVar;
        if (zzsy.a >= 18) {
            try {
                this.E = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzsy.a >= 19) {
            this.f16463h = new c10();
        } else {
            this.f16463h = new b10(a10Var);
        }
        e10 e10Var = new e10();
        this.f16457b = e10Var;
        zzmx zzmxVar = new zzmx();
        this.f16458c = zzmxVar;
        zzlx[] zzlxVarArr2 = new zzlx[zzlxVarArr.length + 3];
        this.f16459d = zzlxVarArr2;
        zzlxVarArr2[0] = new h10();
        zzlxVarArr2[1] = e10Var;
        System.arraycopy(zzlxVarArr, 0, zzlxVarArr2, 2, zzlxVarArr.length);
        zzlxVarArr2[zzlxVarArr.length + 2] = zzmxVar;
        this.f16462g = new long[10];
        this.Q = 1.0f;
        this.M = 0;
        this.o = 3;
        this.a0 = 0;
        this.t = zzln.a;
        this.X = -1;
        this.R = new zzlx[0];
        this.S = new ByteBuffer[0];
        this.f16464i = new LinkedList<>();
    }

    private final void C() {
        if (a()) {
            if (zzsy.a >= 21) {
                this.f16465j.setVolume(this.Q);
                return;
            }
            AudioTrack audioTrack = this.f16465j;
            float f2 = this.Q;
            audioTrack.setStereoVolume(f2, f2);
        }
    }

    private final long D() {
        return this.p ? this.K : this.J / ((long) this.I);
    }

    private final boolean E() {
        if (zzsy.a >= 23) {
            return false;
        }
        int i2 = this.n;
        return i2 == 5 || i2 == 6;
    }

    private final boolean a() {
        return this.f16465j != null;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0076  */
    /* JADX WARN: Code duplicated, block: B:46:0x00da  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e3  */
    private final boolean n(ByteBuffer byteBuffer, long j2) throws zzmp {
        int iWrite;
        int iWrite2;
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        ByteBuffer byteBuffer2 = this.U;
        if (byteBuffer2 != null) {
            zzsk.a(byteBuffer2 == byteBuffer);
        } else {
            this.U = byteBuffer;
            if (zzsy.a < 21) {
                int iRemaining = byteBuffer.remaining();
                byte[] bArr = this.V;
                if (bArr == null || bArr.length < iRemaining) {
                    this.V = new byte[iRemaining];
                }
                int iPosition = byteBuffer.position();
                byteBuffer.get(this.V, 0, iRemaining);
                byteBuffer.position(iPosition);
                this.W = 0;
            }
        }
        int iRemaining2 = byteBuffer.remaining();
        if (zzsy.a < 21) {
            int iE = this.q - ((int) (this.J - (this.f16463h.e() * ((long) this.I))));
            if (iE > 0) {
                iWrite = this.f16465j.write(this.V, this.W, Math.min(iRemaining2, iE));
                if (iWrite > 0) {
                    this.W += iWrite;
                    byteBuffer.position(byteBuffer.position() + iWrite);
                }
            } else {
                iWrite = 0;
            }
        } else if (this.b0) {
            zzsk.e(j2 != -9223372036854775807L);
            AudioTrack audioTrack = this.f16465j;
            if (this.w == null) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
                this.w = byteBufferAllocate;
                byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
                this.w.putInt(1431633921);
            }
            if (this.x == 0) {
                this.w.putInt(4, iRemaining2);
                this.w.putLong(8, j2 * 1000);
                this.w.position(0);
                this.x = iRemaining2;
            }
            int iRemaining3 = this.w.remaining();
            if (iRemaining3 <= 0) {
                iWrite2 = audioTrack.write(byteBuffer, iRemaining2, 1);
                if (iWrite2 < 0) {
                    this.x = 0;
                } else {
                    this.x -= iWrite2;
                }
                iWrite = iWrite2;
            } else {
                int iWrite3 = audioTrack.write(this.w, iRemaining3, 1);
                if (iWrite3 < 0) {
                    this.x = 0;
                    iWrite = iWrite3;
                } else if (iWrite3 < iRemaining3) {
                    iWrite = 0;
                } else {
                    iWrite2 = audioTrack.write(byteBuffer, iRemaining2, 1);
                    if (iWrite2 < 0) {
                        this.x = 0;
                    } else {
                        this.x -= iWrite2;
                    }
                    iWrite = iWrite2;
                }
            }
        } else {
            iWrite = this.f16465j.write(byteBuffer, iRemaining2, 1);
        }
        this.d0 = SystemClock.elapsedRealtime();
        if (iWrite < 0) {
            throw new zzmp(iWrite);
        }
        boolean z = this.p;
        if (!z) {
            this.J += (long) iWrite;
        }
        if (iWrite != iRemaining2) {
            return false;
        }
        if (z) {
            this.K += (long) this.L;
        }
        this.U = null;
        return true;
    }

    private static int o(String str) {
        str.hashCode();
        switch (str) {
            case "audio/vnd.dts":
                return 7;
            case "audio/ac3":
                return 5;
            case "audio/eac3":
                return 6;
            case "audio/vnd.dts.hd":
                return 8;
            default:
                return 0;
        }
    }

    private final long p(long j2) {
        return (j2 * 1000000) / ((long) this.f16466k);
    }

    private final long q(long j2) {
        return (j2 * ((long) this.f16466k)) / 1000000;
    }

    private final void s(long j2) throws zzmp {
        ByteBuffer byteBuffer;
        int length = this.R.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.S[i2 - 1];
            } else {
                byteBuffer = this.T;
                if (byteBuffer == null) {
                    byteBuffer = zzlx.a;
                }
            }
            if (i2 == length) {
                n(byteBuffer, j2);
            } else {
                zzlx zzlxVar = this.R[i2];
                zzlxVar.h(byteBuffer);
                ByteBuffer byteBufferD = zzlxVar.d();
                this.S[i2] = byteBufferD;
                if (byteBufferD.hasRemaining()) {
                    i2++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i2--;
            }
        }
    }

    private final void v() {
        this.A = 0L;
        this.z = 0;
        this.y = 0;
        this.B = 0L;
        this.C = false;
        this.D = 0L;
    }

    private final void x() {
        ArrayList arrayList = new ArrayList();
        for (zzlx zzlxVar : this.f16459d) {
            if (zzlxVar.b()) {
                arrayList.add(zzlxVar);
            } else {
                zzlxVar.flush();
            }
        }
        int size = arrayList.size();
        this.R = (zzlx[]) arrayList.toArray(new zzlx[size]);
        this.S = new ByteBuffer[size];
        for (int i2 = 0; i2 < size; i2++) {
            zzlx zzlxVar2 = this.R[i2];
            zzlxVar2.flush();
            this.S[i2] = zzlxVar2.d();
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0021  */
    /* JADX WARN: Code duplicated, block: B:15:0x0025  */
    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x0032  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0032 -> B:9:0x0012). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private final boolean z() throws com.google.android.gms.internal.ads.zzmp {
        /*
            r9 = this;
            int r0 = r9.X
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L14
            boolean r0 = r9.p
            if (r0 == 0) goto Lf
            com.google.android.gms.internal.ads.zzlx[] r0 = r9.R
            int r0 = r0.length
            goto L10
        Lf:
            r0 = 0
        L10:
            r9.X = r0
        L12:
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            int r4 = r9.X
            com.google.android.gms.internal.ads.zzlx[] r5 = r9.R
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L38
            r4 = r5[r4]
            if (r0 == 0) goto L28
            r4.c()
        L28:
            r9.s(r7)
            boolean r0 = r4.C()
            if (r0 != 0) goto L32
            return r3
        L32:
            int r0 = r9.X
            int r0 = r0 + r2
            r9.X = r0
            goto L12
        L38:
            java.nio.ByteBuffer r0 = r9.U
            if (r0 == 0) goto L44
            r9.n(r0, r7)
            java.nio.ByteBuffer r0 = r9.U
            if (r0 == 0) goto L44
            return r3
        L44:
            r9.X = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmh.z():boolean");
    }

    public final zzln A() {
        return this.t;
    }

    public final void B() {
        if (this.b0) {
            this.b0 = false;
            this.a0 = 0;
            e();
        }
    }

    public final void b() {
        this.Z = false;
        if (a()) {
            v();
            this.f16463h.a();
        }
    }

    public final void c() {
        this.Z = true;
        if (a()) {
            this.O = System.nanoTime() / 1000;
            this.f16465j.play();
        }
    }

    public final void d() {
        e();
        for (zzlx zzlxVar : this.f16459d) {
            zzlxVar.a();
        }
        this.a0 = 0;
        this.Z = false;
    }

    public final void e() {
        if (a()) {
            this.G = 0L;
            this.H = 0L;
            this.J = 0L;
            this.K = 0L;
            this.L = 0;
            zzln zzlnVar = this.s;
            if (zzlnVar != null) {
                this.t = zzlnVar;
                this.s = null;
            } else if (!this.f16464i.isEmpty()) {
                this.t = this.f16464i.getLast().a;
            }
            this.f16464i.clear();
            this.u = 0L;
            this.v = 0L;
            this.T = null;
            this.U = null;
            int i2 = 0;
            while (true) {
                zzlx[] zzlxVarArr = this.R;
                if (i2 >= zzlxVarArr.length) {
                    break;
                }
                zzlx zzlxVar = zzlxVarArr[i2];
                zzlxVar.flush();
                this.S[i2] = zzlxVar.d();
                i2++;
            }
            this.Y = false;
            this.X = -1;
            this.w = null;
            this.x = 0;
            this.M = 0;
            this.P = 0L;
            v();
            if (this.f16465j.getPlayState() == 3) {
                this.f16465j.pause();
            }
            AudioTrack audioTrack = this.f16465j;
            this.f16465j = null;
            this.f16463h.b(null, false);
            this.f16461f.close();
            new a10(this, audioTrack).start();
        }
    }

    public final void f(int i2) {
        if (this.o == i2) {
            return;
        }
        this.o = i2;
        if (this.b0) {
            return;
        }
        e();
        this.a0 = 0;
    }

    public final void g(float f2) {
        if (this.Q != f2) {
            this.Q = f2;
            C();
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00a8  */
    public final void i(String str, int i2, int i3, int i4, int i5, int[] iArr) throws zzml {
        boolean zG;
        int i6;
        int iMax;
        boolean z = !"audio/raw".equals(str);
        int iO = z ? o(str) : i4;
        if (z) {
            zG = false;
        } else {
            this.F = zzsy.r(i4, i2);
            this.f16457b.i(iArr);
            zG = false;
            for (zzlx zzlxVar : this.f16459d) {
                try {
                    zG |= zzlxVar.g(i3, i2, iO);
                    if (zzlxVar.b()) {
                        i2 = zzlxVar.e();
                        iO = zzlxVar.f();
                    }
                } catch (zzly e2) {
                    throw new zzml(e2);
                }
            }
            if (zG) {
                x();
            }
        }
        int i7 = 252;
        switch (i2) {
            case 1:
                i6 = 4;
                break;
            case 2:
                i6 = 12;
                break;
            case 3:
                i6 = 28;
                break;
            case 4:
                i6 = 204;
                break;
            case 5:
                i6 = 220;
                break;
            case 6:
                i6 = 252;
                break;
            case 7:
                i6 = 1276;
                break;
            case 8:
                i6 = zzkt.a;
                break;
            default:
                StringBuilder sb = new StringBuilder(38);
                sb.append("Unsupported channel count: ");
                sb.append(i2);
                throw new zzml(sb.toString());
        }
        int i8 = zzsy.a;
        if (i8 > 23 || !"foster".equals(zzsy.f16740b) || !"NVIDIA".equals(zzsy.f16741c)) {
            i7 = i6;
        } else if (i2 != 3 && i2 != 5) {
            if (i2 != 7) {
                i7 = i6;
            } else {
                i7 = zzkt.a;
            }
        }
        int i9 = (i8 <= 25 && "fugu".equals(zzsy.f16740b) && z && i2 == 1) ? 12 : i7;
        if (!zG && a() && this.m == iO && this.f16466k == i3 && this.l == i9) {
            return;
        }
        e();
        this.m = iO;
        this.p = z;
        this.f16466k = i3;
        this.l = i9;
        if (!z) {
            iO = 2;
        }
        this.n = iO;
        this.I = zzsy.r(2, i2);
        if (z) {
            int i10 = this.n;
            iMax = (i10 == 5 || i10 == 6) ? 20480 : 49152;
        } else {
            int minBufferSize = AudioTrack.getMinBufferSize(i3, i9, this.n);
            zzsk.e(minBufferSize != -2);
            int i11 = minBufferSize << 2;
            int iQ = this.I * ((int) q(250000L));
            iMax = (int) Math.max(minBufferSize, q(750000L) * ((long) this.I));
            if (i11 < iQ) {
                iMax = iQ;
            } else if (i11 <= iMax) {
                iMax = i11;
            }
        }
        this.q = iMax;
        this.r = z ? -9223372036854775807L : p(iMax / this.I);
        m(this.t);
    }

    public final boolean j(ByteBuffer byteBuffer, long j2) throws zzmm, zzmp {
        int i2;
        int iA;
        ByteBuffer byteBuffer2 = this.T;
        zzsk.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!a()) {
            this.f16461f.block();
            if (this.b0) {
                this.f16465j = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.l).setEncoding(this.n).setSampleRate(this.f16466k).build(), this.q, 1, this.a0);
            } else if (this.a0 == 0) {
                this.f16465j = new AudioTrack(this.o, this.f16466k, this.l, this.n, this.q, 1);
            } else {
                this.f16465j = new AudioTrack(this.o, this.f16466k, this.l, this.n, this.q, 1, this.a0);
            }
            int state = this.f16465j.getState();
            if (state != 1) {
                try {
                    this.f16465j.release();
                } catch (Exception unused) {
                } finally {
                    this.f16465j = null;
                }
                throw new zzmm(state, this.f16466k, this.l, this.q);
            }
            int audioSessionId = this.f16465j.getAudioSessionId();
            if (this.a0 != audioSessionId) {
                this.a0 = audioSessionId;
                this.f16460e.a(audioSessionId);
            }
            this.f16463h.b(this.f16465j, E());
            C();
            this.c0 = false;
            if (this.Z) {
                c();
            }
        }
        if (E()) {
            if (this.f16465j.getPlayState() == 2) {
                this.c0 = false;
                return false;
            }
            if (this.f16465j.getPlayState() == 1 && this.f16463h.e() != 0) {
                return false;
            }
        }
        boolean z = this.c0;
        boolean zU = u();
        this.c0 = zU;
        if (z && !zU && this.f16465j.getPlayState() != 1) {
            this.f16460e.b(this.q, zzkt.a(this.r), SystemClock.elapsedRealtime() - this.d0);
        }
        if (this.T == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.p && this.L == 0) {
                int i3 = this.n;
                if (i3 == 7 || i3 == 8) {
                    iA = zzmr.a(byteBuffer);
                } else if (i3 == 5) {
                    iA = zzlv.d();
                } else {
                    if (i3 != 6) {
                        StringBuilder sb = new StringBuilder(38);
                        sb.append("Unexpected audio encoding: ");
                        sb.append(i3);
                        throw new IllegalStateException(sb.toString());
                    }
                    iA = zzlv.c(byteBuffer);
                }
                this.L = iA;
            }
            if (this.s != null) {
                if (!z()) {
                    return false;
                }
                this.f16464i.add(new d10(this.s, Math.max(0L, j2), p(D()), null));
                this.s = null;
                x();
            }
            if (this.M == 0) {
                this.N = Math.max(0L, j2);
                this.M = 1;
            } else {
                long jP = this.N + p(this.p ? this.H : this.G / ((long) this.F));
                if (this.M != 1 || Math.abs(jP - j2) <= 200000) {
                    i2 = 2;
                } else {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(jP);
                    sb2.append(", got ");
                    sb2.append(j2);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    i2 = 2;
                    this.M = 2;
                }
                if (this.M == i2) {
                    this.N += j2 - jP;
                    this.M = 1;
                    this.f16460e.c();
                }
            }
            if (this.p) {
                this.H += (long) this.L;
            } else {
                this.G += (long) byteBuffer.remaining();
            }
            this.T = byteBuffer;
        }
        if (this.p) {
            n(this.T, j2);
        } else {
            s(j2);
        }
        if (this.T.hasRemaining()) {
            return false;
        }
        this.T = null;
        return true;
    }

    public final void k(int i2) {
        zzsk.e(zzsy.a >= 21);
        if (this.b0 && this.a0 == i2) {
            return;
        }
        this.b0 = true;
        this.a0 = i2;
        e();
    }

    public final boolean l(String str) {
        zzlw zzlwVar = this.a;
        return zzlwVar != null && zzlwVar.a(o(str));
    }

    public final zzln m(zzln zzlnVar) {
        if (this.p) {
            zzln zzlnVar2 = zzln.a;
            this.t = zzlnVar2;
            return zzlnVar2;
        }
        zzln zzlnVar3 = new zzln(this.f16458c.i(zzlnVar.f16431b), this.f16458c.j(zzlnVar.f16432c));
        zzln zzlnVar4 = this.s;
        if (zzlnVar4 == null) {
            zzlnVar4 = !this.f16464i.isEmpty() ? this.f16464i.getLast().a : this.t;
        }
        if (!zzlnVar3.equals(zzlnVar4)) {
            if (a()) {
                this.s = zzlnVar3;
            } else {
                this.t = zzlnVar3;
            }
        }
        return this.t;
    }

    public final boolean r() {
        if (a()) {
            return this.Y && !u();
        }
        return true;
    }

    public final void t() {
        if (this.M == 1) {
            this.M = 2;
        }
    }

    public final boolean u() {
        if (a()) {
            if (D() <= this.f16463h.e()) {
                if (E() && this.f16465j.getPlayState() == 2 && this.f16465j.getPlaybackHeadPosition() == 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final long w(boolean z) {
        long jC;
        long j2;
        long jC2;
        long j3;
        if (!(a() && this.M != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.f16465j.getPlayState() == 3) {
            long jC3 = this.f16463h.c();
            if (jC3 != 0) {
                long jNanoTime = System.nanoTime() / 1000;
                if (jNanoTime - this.B >= 30000) {
                    long[] jArr = this.f16462g;
                    int i2 = this.y;
                    jArr[i2] = jC3 - jNanoTime;
                    this.y = (i2 + 1) % 10;
                    int i3 = this.z;
                    if (i3 < 10) {
                        this.z = i3 + 1;
                    }
                    this.B = jNanoTime;
                    this.A = 0L;
                    int i4 = 0;
                    while (true) {
                        int i5 = this.z;
                        if (i4 >= i5) {
                            break;
                        }
                        this.A += this.f16462g[i4] / ((long) i5);
                        i4++;
                    }
                }
                if (!E() && jNanoTime - this.D >= 500000) {
                    boolean zF = this.f16463h.f();
                    this.C = zF;
                    if (zF) {
                        long jG = this.f16463h.g() / 1000;
                        long jH = this.f16463h.h();
                        if (jG < this.O) {
                            this.C = false;
                        } else if (Math.abs(jG - jNanoTime) > 5000000) {
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(jH);
                            sb.append(", ");
                            sb.append(jG);
                            sb.append(", ");
                            sb.append(jNanoTime);
                            sb.append(", ");
                            sb.append(jC3);
                            Log.w("AudioTrack", sb.toString());
                            this.C = false;
                        } else if (Math.abs(p(jH) - jC3) > 5000000) {
                            StringBuilder sb2 = new StringBuilder(138);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(jH);
                            sb2.append(", ");
                            sb2.append(jG);
                            sb2.append(", ");
                            sb2.append(jNanoTime);
                            sb2.append(", ");
                            sb2.append(jC3);
                            Log.w("AudioTrack", sb2.toString());
                            this.C = false;
                        }
                    }
                    Method method = this.E;
                    if (method != null && !this.p) {
                        try {
                            long jIntValue = (((long) ((Integer) method.invoke(this.f16465j, null)).intValue()) * 1000) - this.r;
                            this.P = jIntValue;
                            long jMax = Math.max(jIntValue, 0L);
                            this.P = jMax;
                            if (jMax > 5000000) {
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(jMax);
                                Log.w("AudioTrack", sb3.toString());
                                this.P = 0L;
                            }
                        } catch (Exception unused) {
                            this.E = null;
                        }
                    }
                    this.D = jNanoTime;
                }
            }
        }
        long jNanoTime2 = System.nanoTime() / 1000;
        if (this.C) {
            jC = p(this.f16463h.h() + q(jNanoTime2 - (this.f16463h.g() / 1000)));
        } else {
            jC = this.z == 0 ? this.f16463h.c() : jNanoTime2 + this.A;
            if (!z) {
                jC -= this.P;
            }
        }
        long j4 = this.N;
        while (!this.f16464i.isEmpty() && jC >= this.f16464i.getFirst().f12445c) {
            d10 d10VarRemove = this.f16464i.remove();
            this.t = d10VarRemove.a;
            this.v = d10VarRemove.f12445c;
            this.u = d10VarRemove.f12444b - this.N;
        }
        if (this.t.f16431b == 1.0f) {
            j3 = (jC + this.u) - this.v;
        } else {
            if (!this.f16464i.isEmpty() || this.f16458c.l() < RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
                j2 = this.u;
                double d2 = this.t.f16431b;
                double d3 = jC - this.v;
                Double.isNaN(d2);
                Double.isNaN(d3);
                jC2 = (long) (d2 * d3);
            } else {
                j2 = this.u;
                jC2 = zzsy.c(jC - this.v, this.f16458c.k(), this.f16458c.l());
            }
            j3 = jC2 + j2;
        }
        return j4 + j3;
    }

    public final void y() throws zzmp {
        if (!this.Y && a() && z()) {
            this.f16463h.d(D());
            this.x = 0;
            this.Y = true;
        }
    }
}
