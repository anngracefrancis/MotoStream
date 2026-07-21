package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class h30 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12692i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f12693j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f12694k;
    private int l;
    private zzlh q;
    private int a = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f12685b = new int[1000];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f12686c = new long[1000];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long[] f12689f = new long[1000];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f12688e = new int[1000];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f12687d = new int[1000];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zznx[] f12690g = new zznx[1000];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzlh[] f12691h = new zzlh[1000];
    private long m = Long.MIN_VALUE;
    private long n = Long.MIN_VALUE;
    private boolean p = true;
    private boolean o = true;

    public final synchronized int a(zzlj zzljVar, zznd zzndVar, boolean z, boolean z2, zzlh zzlhVar, zzqs zzqsVar) {
        if (!j()) {
            if (z2) {
                zzndVar.b(4);
                return -4;
            }
            zzlh zzlhVar2 = this.q;
            if (zzlhVar2 == null || (!z && zzlhVar2 == zzlhVar)) {
                return -3;
            }
            zzljVar.a = zzlhVar2;
            return -5;
        }
        if (!z) {
            zzlh[] zzlhVarArr = this.f12691h;
            int i2 = this.f12694k;
            if (zzlhVarArr[i2] == zzlhVar) {
                if (zzndVar.f16502c == null) {
                    return -3;
                }
                zzndVar.f16503d = this.f12689f[i2];
                zzndVar.b(this.f12688e[i2]);
                int[] iArr = this.f12687d;
                int i3 = this.f12694k;
                zzqsVar.a = iArr[i3];
                zzqsVar.f16613b = this.f12686c[i3];
                zzqsVar.f16615d = this.f12690g[i3];
                this.m = Math.max(this.m, zzndVar.f16503d);
                int i4 = this.f12692i - 1;
                this.f12692i = i4;
                int i5 = this.f12694k + 1;
                this.f12694k = i5;
                this.f12693j++;
                if (i5 == this.a) {
                    this.f12694k = 0;
                }
                zzqsVar.f16614c = i4 > 0 ? this.f12686c[this.f12694k] : zzqsVar.f16613b + ((long) zzqsVar.a);
                return -4;
            }
        }
        zzljVar.a = this.f12691h[this.f12694k];
        return -5;
    }

    public final synchronized void b(long j2, int i2, long j3, int i3, zznx zznxVar) {
        if (this.o) {
            if ((i2 & 1) == 0) {
                return;
            } else {
                this.o = false;
            }
        }
        zzsk.e(!this.p);
        c(j2);
        long[] jArr = this.f12689f;
        int i4 = this.l;
        jArr[i4] = j2;
        long[] jArr2 = this.f12686c;
        jArr2[i4] = j3;
        this.f12687d[i4] = i3;
        this.f12688e[i4] = i2;
        this.f12690g[i4] = zznxVar;
        this.f12691h[i4] = this.q;
        this.f12685b[i4] = 0;
        int i5 = this.f12692i + 1;
        this.f12692i = i5;
        int i6 = this.a;
        if (i5 != i6) {
            int i7 = i4 + 1;
            this.l = i7;
            if (i7 == i6) {
                this.l = 0;
            }
            return;
        }
        int i8 = i6 + 1000;
        int[] iArr = new int[i8];
        long[] jArr3 = new long[i8];
        long[] jArr4 = new long[i8];
        int[] iArr2 = new int[i8];
        int[] iArr3 = new int[i8];
        zznx[] zznxVarArr = new zznx[i8];
        zzlh[] zzlhVarArr = new zzlh[i8];
        int i9 = this.f12694k;
        int i10 = i6 - i9;
        System.arraycopy(jArr2, i9, jArr3, 0, i10);
        System.arraycopy(this.f12689f, this.f12694k, jArr4, 0, i10);
        System.arraycopy(this.f12688e, this.f12694k, iArr2, 0, i10);
        System.arraycopy(this.f12687d, this.f12694k, iArr3, 0, i10);
        System.arraycopy(this.f12690g, this.f12694k, zznxVarArr, 0, i10);
        System.arraycopy(this.f12691h, this.f12694k, zzlhVarArr, 0, i10);
        System.arraycopy(this.f12685b, this.f12694k, iArr, 0, i10);
        int i11 = this.f12694k;
        System.arraycopy(this.f12686c, 0, jArr3, i10, i11);
        System.arraycopy(this.f12689f, 0, jArr4, i10, i11);
        System.arraycopy(this.f12688e, 0, iArr2, i10, i11);
        System.arraycopy(this.f12687d, 0, iArr3, i10, i11);
        System.arraycopy(this.f12690g, 0, zznxVarArr, i10, i11);
        System.arraycopy(this.f12691h, 0, zzlhVarArr, i10, i11);
        System.arraycopy(this.f12685b, 0, iArr, i10, i11);
        this.f12686c = jArr3;
        this.f12689f = jArr4;
        this.f12688e = iArr2;
        this.f12687d = iArr3;
        this.f12690g = zznxVarArr;
        this.f12691h = zzlhVarArr;
        this.f12685b = iArr;
        this.f12694k = 0;
        int i12 = this.a;
        this.l = i12;
        this.f12692i = i12;
        this.a = i8;
    }

    public final synchronized void c(long j2) {
        this.n = Math.max(this.n, j2);
    }

    public final synchronized long d(long j2, boolean z) {
        if (j()) {
            long[] jArr = this.f12689f;
            int i2 = this.f12694k;
            if (j2 >= jArr[i2]) {
                if (j2 > this.n && !z) {
                    return -1L;
                }
                int i3 = 0;
                int i4 = -1;
                while (i2 != this.l && this.f12689f[i2] <= j2) {
                    if ((this.f12688e[i2] & 1) != 0) {
                        i4 = i3;
                    }
                    i2 = (i2 + 1) % this.a;
                    i3++;
                }
                if (i4 == -1) {
                    return -1L;
                }
                int i5 = (this.f12694k + i4) % this.a;
                this.f12694k = i5;
                this.f12693j += i4;
                this.f12692i -= i4;
                return this.f12686c[i5];
            }
        }
        return -1L;
    }

    public final synchronized boolean e(zzlh zzlhVar) {
        try {
            if (zzlhVar == null) {
                this.p = true;
                return false;
            }
            this.p = false;
            if (zzsy.g(zzlhVar, this.q)) {
                return false;
            }
            this.q = zzlhVar;
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long f() {
        return Math.max(this.m, this.n);
    }

    public final void g() {
        this.f12693j = 0;
        this.f12694k = 0;
        this.l = 0;
        this.f12692i = 0;
        this.o = true;
    }

    public final void h() {
        this.m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
    }

    public final int i() {
        return this.f12693j + this.f12692i;
    }

    public final synchronized boolean j() {
        return this.f12692i != 0;
    }

    public final synchronized zzlh k() {
        if (this.p) {
            return null;
        }
        return this.q;
    }

    public final synchronized long l() {
        if (!j()) {
            return -1L;
        }
        int i2 = this.f12694k;
        int i3 = this.f12692i;
        int i4 = this.a;
        int i5 = ((i2 + i3) - 1) % i4;
        this.f12694k = (i2 + i3) % i4;
        this.f12693j += i3;
        this.f12692i = 0;
        return this.f12686c[i5] + ((long) this.f12687d[i5]);
    }
}
