package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.SystemClock;
import android.util.SparseArray;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzig implements zzhn, zzif, zzka {
    private IOException A;
    private boolean B;
    private int C;
    private long D;
    private boolean E;
    private int F;
    private int G;
    private final zzid a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzjr f16312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseArray<qz> f16314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f16315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f16316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Uri f16317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzjp f16318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f16319i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile zzio f16320j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile zzhw f16321k;
    private boolean l;
    private int m;
    private zzho[] n;
    private long o;
    private boolean[] p;
    private boolean[] q;
    private boolean[] r;
    private int s;
    private long t;
    private long u;
    private long v;
    private boolean w;
    private long x;
    private zzjz y;
    private pz z;

    public zzig(Uri uri, zzjp zzjpVar, zzid zzidVar, int i2, int i3) {
        this(uri, zzjpVar, zzidVar, 2, i3, -1);
    }

    static /* synthetic */ int i(zzig zzigVar) {
        int i2 = zzigVar.F;
        zzigVar.F = i2 + 1;
        return i2;
    }

    private final void j(long j2) {
        this.v = j2;
        this.E = false;
        if (this.y.a()) {
            this.y.f();
        } else {
            o();
            l();
        }
    }

    private final boolean k() throws IOException {
        boolean z;
        l();
        boolean z2 = false;
        if (p()) {
            return false;
        }
        if (this.l) {
            int i2 = 0;
            while (true) {
                boolean[] zArr = this.r;
                if (i2 >= zArr.length) {
                    z = false;
                    break;
                }
                if (zArr[i2] && !this.f16314d.valueAt(i2).f()) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (z) {
                z2 = true;
            }
        }
        if (!z2) {
            m();
        }
        return z2;
    }

    private final void l() {
        if (this.E || this.y.a()) {
            return;
        }
        if (this.A != null) {
            zzkh.d(this.z != null);
            if (SystemClock.elapsedRealtime() - this.D >= Math.min((((long) this.C) - 1) * 1000, 5000L)) {
                this.A = null;
                if (this.l) {
                    this.f16320j.b();
                } else {
                    for (int i2 = 0; i2 < this.f16314d.size(); i2++) {
                        this.f16314d.valueAt(i2).e();
                    }
                    this.z = n();
                }
                this.G = this.F;
                this.y.d(this.z, this);
                return;
            }
            return;
        }
        this.x = 0L;
        this.w = false;
        if (this.l) {
            zzkh.d(p());
            long j2 = this.o;
            if (j2 != -1 && this.v >= j2) {
                this.E = true;
                this.v = -1L;
                return;
            } else {
                this.z = new pz(this.f16317g, this.f16318h, this.a, this.f16312b, this.f16313c, this.f16320j.a(this.v));
                this.v = -1L;
            }
        } else {
            this.z = n();
        }
        this.G = this.F;
        this.y.d(this.z, this);
    }

    private final void m() throws IOException {
        if (this.A == null) {
            return;
        }
        int i2 = this.f16315e;
        if (i2 == -1) {
            if (this.f16320j != null) {
                this.f16320j.b();
            }
            i2 = 3;
        }
        if (this.C > i2) {
            throw this.A;
        }
    }

    private final pz n() {
        return new pz(this.f16317g, this.f16318h, this.a, this.f16312b, this.f16313c, 0L);
    }

    private final void o() {
        for (int i2 = 0; i2 < this.f16314d.size(); i2++) {
            this.f16314d.valueAt(i2).e();
        }
        this.z = null;
        this.A = null;
        this.C = 0;
        this.B = false;
    }

    private final boolean p() {
        return this.v != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void a(zzkc zzkcVar) {
        this.E = true;
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void b(zzkc zzkcVar, IOException iOException) {
        this.A = iOException;
        this.C = this.F <= this.G ? 1 + this.C : 1;
        this.D = SystemClock.elapsedRealtime();
        l();
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void c() {
        zzjz zzjzVar;
        zzkh.d(this.s > 0);
        int i2 = this.s - 1;
        this.s = i2;
        if (i2 != 0 || (zzjzVar = this.y) == null) {
            return;
        }
        zzjzVar.b();
        this.y = null;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void d() {
        this.f16319i = true;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void e(zzhw zzhwVar) {
        this.f16321k = zzhwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final zzip f(int i2) {
        qz qzVar = this.f16314d.get(i2);
        if (qzVar != null) {
            return qzVar;
        }
        qz qzVar2 = new qz(this, this.f16312b);
        this.f16314d.put(i2, qzVar2);
        return qzVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void g(zzio zzioVar) {
        this.f16320j = zzioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void h(zzkc zzkcVar) {
        if (this.m > 0) {
            j(this.v);
        } else {
            o();
            this.f16312b.f(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void q(int i2, long j2) {
        zzkh.d(this.l);
        zzkh.d(!this.r[i2]);
        int i3 = this.m + 1;
        this.m = i3;
        this.r[i2] = true;
        this.p[i2] = true;
        if (i3 == 1) {
            t(j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final long r() {
        if (this.E) {
            return -3L;
        }
        if (p()) {
            return this.v;
        }
        long jMax = Long.MIN_VALUE;
        for (int i2 = 0; i2 < this.f16314d.size(); i2++) {
            jMax = Math.max(jMax, this.f16314d.valueAt(i2).l());
        }
        return jMax == Long.MIN_VALUE ? this.t : jMax;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final int s() {
        return this.f16314d.size();
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void t(long j2) {
        zzkh.d(this.l);
        int i2 = 0;
        zzkh.d(this.m > 0);
        this.f16320j.b();
        this.u = j2;
        if ((p() ? this.v : this.t) == j2) {
            return;
        }
        this.t = j2;
        boolean zI = !p();
        for (int i3 = 0; zI && i3 < this.f16314d.size(); i3++) {
            zI &= this.f16314d.valueAt(i3).i(j2);
        }
        if (!zI) {
            j(j2);
        }
        while (true) {
            boolean[] zArr = this.q;
            if (i2 >= zArr.length) {
                return;
            }
            zArr[i2] = true;
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final boolean u(long j2) throws IOException {
        boolean z;
        if (this.l) {
            return true;
        }
        if (this.y == null) {
            this.y = new zzjz("Loader:ExtractorSampleSource");
        }
        k();
        if (this.f16320j != null && this.f16319i) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.f16314d.size()) {
                    z = true;
                    break;
                }
                if (!this.f16314d.valueAt(i2).j()) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                int size = this.f16314d.size();
                this.r = new boolean[size];
                this.q = new boolean[size];
                this.p = new boolean[size];
                this.n = new zzho[size];
                this.o = -1L;
                for (int i3 = 0; i3 < size; i3++) {
                    zzhj zzhjVarK = this.f16314d.valueAt(i3).k();
                    this.n[i3] = new zzho(zzhjVarK.a, zzhjVarK.f16269c);
                    long j3 = zzhjVarK.f16269c;
                    if (j3 != -1 && j3 > this.o) {
                        this.o = j3;
                    }
                }
                this.l = true;
                return true;
            }
        }
        m();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final zzho v(int i2) {
        zzkh.d(this.l);
        return this.n[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final int w(int i2, long j2, zzhk zzhkVar, zzhm zzhmVar, boolean z) throws IOException {
        this.t = j2;
        boolean[] zArr = this.q;
        if (zArr[i2]) {
            zArr[i2] = false;
            return -5;
        }
        if (z || p()) {
            m();
            return -2;
        }
        qz qzVarValueAt = this.f16314d.valueAt(i2);
        if (this.p[i2]) {
            zzhkVar.a = qzVarValueAt.k();
            zzhkVar.f16278b = this.f16321k;
            this.p[i2] = false;
            return -4;
        }
        if (qzVarValueAt.g(zzhmVar)) {
            zzhmVar.f16281d |= this.f16316f && (zzhmVar.f16282e > this.u ? 1 : (zzhmVar.f16282e == this.u ? 0 : -1)) < 0 ? 134217728 : 0;
            zzhmVar.f16282e += this.x;
            return -3;
        }
        if (this.E) {
            return -1;
        }
        m();
        return -2;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final boolean x(long j2) throws IOException {
        zzkh.d(this.l);
        zzkh.d(this.m > 0);
        this.t = j2;
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.r;
            if (i2 >= zArr.length) {
                break;
            }
            if (!zArr[i2]) {
                this.f16314d.valueAt(i2).h(j2);
            }
            i2++;
        }
        return this.E || k();
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void y(int i2) {
        zzkh.d(this.l);
        zzkh.d(this.r[i2]);
        int i3 = this.m - 1;
        this.m = i3;
        this.r[i2] = false;
        this.q[i2] = false;
        if (i3 == 0) {
            if (this.y.a()) {
                this.y.f();
            } else {
                o();
                this.f16312b.f(0);
            }
        }
    }

    private zzig(Uri uri, zzjp zzjpVar, zzid zzidVar, int i2, int i3, int i4) {
        this.f16317g = uri;
        this.f16318h = zzjpVar;
        this.a = zzidVar;
        this.s = 2;
        this.f16313c = i3;
        this.f16315e = -1;
        this.f16314d = new SparseArray<>();
        this.f16312b = new zzjr(262144);
        this.v = -1L;
        this.f16316f = true;
        zzidVar.d(this);
    }
}
