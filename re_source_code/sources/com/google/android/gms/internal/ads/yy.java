package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class yy implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f13658f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HandlerThread f13659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Handler f13660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zy f13661i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean[] f13662j;
    private final List<zzhp> m;
    private zzhp[] n;
    private zzhp o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private long v;
    private volatile long w;
    private volatile long x;
    private volatile long y;
    private int t = 0;
    private int u = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f13663k = 2500000;
    private final long l = 5000000;

    public yy(Handler handler, boolean z, boolean[] zArr, int i2, int i3) {
        this.f13660h = handler;
        this.q = z;
        this.f13662j = new boolean[zArr.length];
        for (int i4 = 0; i4 < zArr.length; i4++) {
            this.f13662j[i4] = zArr[i4];
        }
        this.s = 1;
        this.w = -1L;
        this.y = -1L;
        this.f13661i = new zy();
        this.m = new ArrayList(zArr.length);
        zzko zzkoVar = new zzko(yy.class.getSimpleName().concat(":Handler"), -16);
        this.f13659g = zzkoVar;
        zzkoVar.start();
        this.f13658f = new Handler(zzkoVar.getLooper(), this);
    }

    private final void e(int i2) {
        if (this.s != i2) {
            this.s = i2;
            this.f13660h.obtainMessage(1, i2, 0).sendToTarget();
        }
    }

    private final void g(int i2, long j2, long j3) {
        long jElapsedRealtime = (j2 + j3) - SystemClock.elapsedRealtime();
        if (jElapsedRealtime <= 0) {
            this.f13658f.sendEmptyMessage(i2);
        } else {
            this.f13658f.sendEmptyMessageDelayed(i2, jElapsedRealtime);
        }
    }

    private final boolean j(zzhp zzhpVar) {
        if (zzhpVar.s()) {
            return true;
        }
        if (!zzhpVar.d()) {
            return false;
        }
        if (this.s == 4) {
            return true;
        }
        long jB = zzhpVar.b();
        long jQ = zzhpVar.q();
        long j2 = this.r ? this.l : this.f13663k;
        return j2 <= 0 || jQ == -1 || jQ == -3 || jQ >= this.x + j2 || !(jB == -1 || jB == -2 || jQ < jB);
    }

    private static void l(zzhp zzhpVar) throws zzgd {
        if (zzhpVar.c() == 3) {
            zzhpVar.k();
        }
    }

    private final void p() throws zzgd {
        this.r = false;
        this.f13661i.a();
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            this.m.get(i2).j();
        }
    }

    private final void q() throws zzgd {
        this.f13661i.b();
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            l(this.m.get(i2));
        }
    }

    private final void r() {
        zzhp zzhpVar = this.o;
        if (zzhpVar == null || !this.m.contains(zzhpVar) || this.o.s()) {
            this.x = this.f13661i.e();
        } else {
            this.x = this.o.t();
            this.f13661i.c(this.x);
        }
        this.v = SystemClock.elapsedRealtime() * 1000;
    }

    private final void s() {
        t();
        e(1);
    }

    private final void t() {
        this.f13658f.removeMessages(7);
        this.f13658f.removeMessages(2);
        int i2 = 0;
        this.r = false;
        this.f13661i.b();
        if (this.n == null) {
            return;
        }
        while (true) {
            zzhp[] zzhpVarArr = this.n;
            if (i2 >= zzhpVarArr.length) {
                this.n = null;
                this.o = null;
                this.m.clear();
                return;
            }
            zzhp zzhpVar = zzhpVarArr[i2];
            try {
                l(zzhpVar);
                if (zzhpVar.c() == 2) {
                    zzhpVar.a();
                }
            } catch (zzgd e2) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e2);
            } catch (RuntimeException e3) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e3);
            }
            try {
                zzhpVar.h();
            } catch (zzgd e4) {
                Log.e("ExoPlayerImplInternal", "Release failed.", e4);
            } catch (RuntimeException e5) {
                Log.e("ExoPlayerImplInternal", "Release failed.", e5);
            }
            i2++;
        }
    }

    public final long a() {
        if (this.y == -1) {
            return -1L;
        }
        return this.y / 1000;
    }

    public final long b() {
        if (this.w == -1) {
            return -1L;
        }
        return this.w / 1000;
    }

    public final synchronized void c() {
        if (this.p) {
            return;
        }
        this.f13658f.sendEmptyMessage(5);
        while (!this.p) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.f13659g.quit();
    }

    public final void d(long j2) {
        this.f13658f.obtainMessage(6, Long.valueOf(j2)).sendToTarget();
    }

    public final void f() {
        this.f13658f.sendEmptyMessage(4);
    }

    public final void h(zzgf zzgfVar, int i2, Object obj) {
        this.t++;
        this.f13658f.obtainMessage(9, 1, 0, Pair.create(zzgfVar, obj)).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        zzhp zzhpVar;
        int iC;
        try {
            switch (message.what) {
                case 1:
                    zzhp[] zzhpVarArr = (zzhp[]) message.obj;
                    t();
                    this.n = zzhpVarArr;
                    for (int i2 = 0; i2 < zzhpVarArr.length; i2++) {
                        if (zzhpVarArr[i2].r()) {
                            zzkh.d(this.o == null);
                            this.o = zzhpVarArr[i2];
                        }
                    }
                    e(2);
                    this.f13658f.sendEmptyMessage(2);
                    return true;
                case 2:
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    int i3 = 0;
                    boolean z = true;
                    while (true) {
                        zzhp[] zzhpVarArr2 = this.n;
                        if (i3 >= zzhpVarArr2.length) {
                            if (z) {
                                long jMax = 0;
                                int i4 = 0;
                                boolean z2 = true;
                                boolean z3 = true;
                                while (true) {
                                    zzhp[] zzhpVarArr3 = this.n;
                                    if (i4 < zzhpVarArr3.length) {
                                        zzhp zzhpVar2 = zzhpVarArr3[i4];
                                        if (this.f13662j[i4] && zzhpVar2.c() == 1) {
                                            zzhpVar2.n(this.x, false);
                                            this.m.add(zzhpVar2);
                                            z2 = z2 && zzhpVar2.s();
                                            z3 = z3 && j(zzhpVar2);
                                            if (jMax != -1) {
                                                long jB = zzhpVar2.b();
                                                if (jB == -1) {
                                                    jMax = -1;
                                                } else if (jB != -2) {
                                                    jMax = Math.max(jMax, jB);
                                                }
                                            }
                                        }
                                        i4++;
                                    } else {
                                        this.w = jMax;
                                        if (z2) {
                                            e(5);
                                        } else {
                                            e(z3 ? 4 : 3);
                                            if (this.q && this.s == 4) {
                                                p();
                                            }
                                        }
                                        this.f13658f.sendEmptyMessage(7);
                                    }
                                }
                            } else {
                                g(2, jElapsedRealtime, 10L);
                            }
                            return true;
                        }
                        if (zzhpVarArr2[i3].c() == 0 && this.n[i3].p(this.x) == 0) {
                            z = false;
                        }
                        i3++;
                    }
                    break;
                case 3:
                    boolean z4 = message.arg1 != 0;
                    try {
                        this.r = false;
                        this.q = z4;
                        if (z4) {
                            int i5 = this.s;
                            if (i5 == 4) {
                                p();
                                this.f13658f.sendEmptyMessage(7);
                            } else if (i5 == 3) {
                                this.f13658f.sendEmptyMessage(7);
                            }
                        } else {
                            q();
                            r();
                        }
                        return true;
                    } finally {
                        this.f13660h.obtainMessage(2).sendToTarget();
                    }
                case 4:
                    s();
                    return true;
                case 5:
                    t();
                    e(1);
                    synchronized (this) {
                        this.p = true;
                        notifyAll();
                        break;
                    }
                    return true;
                case 6:
                    long jLongValue = ((Long) message.obj).longValue();
                    this.r = false;
                    this.x = jLongValue * 1000;
                    this.f13661i.b();
                    this.f13661i.c(this.x);
                    int i6 = this.s;
                    if (i6 != 1 && i6 != 2) {
                        for (int i7 = 0; i7 < this.m.size(); i7++) {
                            zzhp zzhpVar3 = this.m.get(i7);
                            l(zzhpVar3);
                            zzhpVar3.i(this.x);
                        }
                        e(3);
                        this.f13658f.sendEmptyMessage(7);
                        return true;
                    }
                    return true;
                case 7:
                    zzkp.a("doSomeWork");
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    long jMin = this.w != -1 ? this.w : Long.MAX_VALUE;
                    r();
                    boolean z5 = true;
                    boolean z6 = true;
                    for (int i8 = 0; i8 < this.m.size(); i8++) {
                        zzhp zzhpVar4 = this.m.get(i8);
                        zzhpVar4.l(this.x, this.v);
                        z5 = z5 && zzhpVar4.s();
                        z6 = z6 && j(zzhpVar4);
                        if (jMin != -1) {
                            long jB2 = zzhpVar4.b();
                            long jQ = zzhpVar4.q();
                            if (jQ == -1) {
                                jMin = -1;
                            } else if (jQ != -3 && (jB2 == -1 || jB2 == -2 || jQ < jB2)) {
                                jMin = Math.min(jMin, jQ);
                            }
                        }
                    }
                    this.y = jMin;
                    if (z5) {
                        e(5);
                        q();
                    } else {
                        int i9 = this.s;
                        if (i9 == 3 && z6) {
                            e(4);
                            if (this.q) {
                                p();
                            }
                        } else if (i9 == 4 && !z6) {
                            this.r = this.q;
                            e(3);
                            q();
                        }
                    }
                    this.f13658f.removeMessages(7);
                    if ((this.q && this.s == 4) || this.s == 3) {
                        g(7, jElapsedRealtime2, 10L);
                    } else if (!this.m.isEmpty()) {
                        g(7, jElapsedRealtime2, 1000L);
                    }
                    zzkp.b();
                    return true;
                case 8:
                    int i10 = message.arg1;
                    boolean z7 = message.arg2 != 0;
                    boolean[] zArr = this.f13662j;
                    if (zArr[i10] != z7) {
                        zArr[i10] = z7;
                        int i11 = this.s;
                        if (i11 != 1 && i11 != 2 && ((iC = (zzhpVar = this.n[i10]).c()) == 1 || iC == 2 || iC == 3)) {
                            if (z7) {
                                boolean z8 = this.q && this.s == 4;
                                zzhpVar.n(this.x, z8);
                                this.m.add(zzhpVar);
                                if (z8) {
                                    zzhpVar.j();
                                }
                                this.f13658f.sendEmptyMessage(7);
                            } else {
                                if (zzhpVar == this.o) {
                                    this.f13661i.c(zzhpVar.t());
                                }
                                l(zzhpVar);
                                this.m.remove(zzhpVar);
                                zzhpVar.a();
                            }
                        }
                    }
                    return true;
                case 9:
                    int i12 = message.arg1;
                    try {
                        Pair pair = (Pair) message.obj;
                        ((zzgf) pair.first).f(i12, pair.second);
                        synchronized (this) {
                            this.u++;
                            notifyAll();
                            break;
                        }
                        int i13 = this.s;
                        if (i13 != 1 && i13 != 2) {
                            this.f13658f.sendEmptyMessage(7);
                        }
                        return true;
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.u++;
                            notifyAll();
                            throw th;
                        }
                    }
                default:
                    return false;
            }
        } catch (zzgd e2) {
            Log.e("ExoPlayerImplInternal", "Internal track renderer error.", e2);
            this.f13660h.obtainMessage(3, e2).sendToTarget();
            s();
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.f13660h.obtainMessage(3, new zzgd(e3, true)).sendToTarget();
            s();
            return true;
        }
    }

    public final void i(zzhp... zzhpVarArr) {
        this.f13658f.obtainMessage(1, zzhpVarArr).sendToTarget();
    }

    public final synchronized void k(zzgf zzgfVar, int i2, Object obj) {
        if (this.p) {
            StringBuilder sb = new StringBuilder(57);
            sb.append("Sent message(1");
            sb.append(") after release. Message ignored.");
            Log.w("ExoPlayerImplInternal", sb.toString());
            return;
        }
        int i3 = this.t;
        this.t = i3 + 1;
        this.f13658f.obtainMessage(9, 1, 0, Pair.create(zzgfVar, obj)).sendToTarget();
        while (this.u <= i3) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final void m(int i2, boolean z) {
        this.f13658f.obtainMessage(8, 0, z ? 1 : 0).sendToTarget();
    }

    public final void n(boolean z) {
        this.f13658f.obtainMessage(3, z ? 1 : 0, 0).sendToTarget();
    }

    public final long o() {
        return this.x / 1000;
    }
}
