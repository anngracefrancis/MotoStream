package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
final class b00 implements e00 {
    private final byte[] a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Stack<d00> f12282b = new Stack<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g00 f12283c = new g00();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f00 f12284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f12286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f12287g;

    b00() {
    }

    private final long d(zzie zzieVar, int i2) throws InterruptedException, IOException {
        zzieVar.readFully(this.a, 0, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | ((long) (this.a[i3] & 255));
        }
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.e00
    public final void a() {
        this.f12285e = 0;
        this.f12282b.clear();
        this.f12283c.a();
    }

    @Override // com.google.android.gms.internal.ads.e00
    public final void b(f00 f00Var) {
        this.f12284d = f00Var;
    }

    @Override // com.google.android.gms.internal.ads.e00
    public final boolean c(zzie zzieVar) throws InterruptedException, IOException {
        zzkh.d(this.f12284d != null);
        while (true) {
            if (!this.f12282b.isEmpty() && zzieVar.getPosition() >= this.f12282b.peek().f12443b) {
                this.f12284d.k(this.f12282b.pop().a);
                return true;
            }
            if (this.f12285e == 0) {
                long jB = this.f12283c.b(zzieVar, true, false);
                if (jB == -1) {
                    return false;
                }
                this.f12286f = (int) jB;
                this.f12285e = 1;
            }
            if (this.f12285e == 1) {
                this.f12287g = this.f12283c.b(zzieVar, false, true);
                this.f12285e = 2;
            }
            int iJ = this.f12284d.j(this.f12286f);
            if (iJ != 0) {
                if (iJ == 1) {
                    long position = zzieVar.getPosition();
                    this.f12282b.add(new d00(this.f12286f, this.f12287g + position));
                    this.f12284d.i(this.f12286f, position, this.f12287g);
                    this.f12285e = 0;
                    return true;
                }
                if (iJ == 2) {
                    long j2 = this.f12287g;
                    if (j2 <= 8) {
                        this.f12284d.c(this.f12286f, d(zzieVar, (int) j2));
                        this.f12285e = 0;
                        return true;
                    }
                    long j3 = this.f12287g;
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j3);
                    throw new IllegalStateException(sb.toString());
                }
                if (iJ == 3) {
                    long j4 = this.f12287g;
                    if (j4 > 2147483647L) {
                        long j5 = this.f12287g;
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append("String element size: ");
                        sb2.append(j5);
                        throw new IllegalStateException(sb2.toString());
                    }
                    f00 f00Var = this.f12284d;
                    int i2 = this.f12286f;
                    int i3 = (int) j4;
                    byte[] bArr = new byte[i3];
                    zzieVar.readFully(bArr, 0, i3);
                    f00Var.g(i2, new String(bArr, Charset.forName("UTF-8")));
                    this.f12285e = 0;
                    return true;
                }
                if (iJ == 4) {
                    this.f12284d.l(this.f12286f, (int) this.f12287g, zzieVar);
                    this.f12285e = 0;
                    return true;
                }
                if (iJ != 5) {
                    StringBuilder sb3 = new StringBuilder(32);
                    sb3.append("Invalid element type ");
                    sb3.append(iJ);
                    throw new IllegalStateException(sb3.toString());
                }
                long j6 = this.f12287g;
                if (j6 != 4 && j6 != 8) {
                    long j7 = this.f12287g;
                    StringBuilder sb4 = new StringBuilder(40);
                    sb4.append("Invalid float size: ");
                    sb4.append(j7);
                    throw new IllegalStateException(sb4.toString());
                }
                f00 f00Var2 = this.f12284d;
                int i4 = this.f12286f;
                int i5 = (int) j6;
                long jD = d(zzieVar, i5);
                f00Var2.h(i4, i5 == 4 ? Float.intBitsToFloat((int) jD) : Double.longBitsToDouble(jD));
                this.f12285e = 0;
                return true;
            }
            zzieVar.a((int) this.f12287g);
            this.f12285e = 0;
        }
    }
}
