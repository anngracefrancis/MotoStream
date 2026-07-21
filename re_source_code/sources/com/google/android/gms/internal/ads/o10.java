package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Stack;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class o10 implements r10 {
    private final byte[] a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Stack<q10> f13075b = new Stack<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x10 f13076c = new x10();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private s10 f13077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f13080g;

    o10() {
    }

    private final long d(zzno zznoVar, int i2) throws InterruptedException, IOException {
        zznoVar.readFully(this.a, 0, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | ((long) (this.a[i3] & 255));
        }
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.r10
    public final void a() {
        this.f13078e = 0;
        this.f13075b.clear();
        this.f13076c.a();
    }

    @Override // com.google.android.gms.internal.ads.r10
    public final void b(s10 s10Var) {
        this.f13077d = s10Var;
    }

    @Override // com.google.android.gms.internal.ads.r10
    public final boolean c(zzno zznoVar) throws InterruptedException, IOException {
        String str;
        int iD;
        int iC;
        zzsk.e(this.f13077d != null);
        while (true) {
            if (!this.f13075b.isEmpty() && zznoVar.getPosition() >= this.f13075b.peek().f13213b) {
                this.f13077d.k(this.f13075b.pop().a);
                return true;
            }
            if (this.f13078e == 0) {
                long jB = this.f13076c.b(zznoVar, true, false, 4);
                if (jB == -2) {
                    zznoVar.c();
                    while (true) {
                        zznoVar.d(this.a, 0, 4);
                        iD = x10.d(this.a[0]);
                        if (iD != -1 && iD <= 4) {
                            iC = (int) x10.c(this.a, iD, false);
                            if (this.f13077d.a(iC)) {
                                break;
                            }
                        }
                        zznoVar.a(1);
                    }
                    zznoVar.a(iD);
                    jB = iC;
                }
                if (jB == -1) {
                    return false;
                }
                this.f13079f = (int) jB;
                this.f13078e = 1;
            }
            if (this.f13078e == 1) {
                this.f13080g = this.f13076c.b(zznoVar, false, true, 8);
                this.f13078e = 2;
            }
            int iJ = this.f13077d.j(this.f13079f);
            if (iJ != 0) {
                if (iJ == 1) {
                    long position = zznoVar.getPosition();
                    this.f13075b.add(new q10(this.f13079f, this.f13080g + position));
                    this.f13077d.i(this.f13079f, position, this.f13080g);
                    this.f13078e = 0;
                    return true;
                }
                if (iJ == 2) {
                    long j2 = this.f13080g;
                    if (j2 <= 8) {
                        this.f13077d.c(this.f13079f, d(zznoVar, (int) j2));
                        this.f13078e = 0;
                        return true;
                    }
                    long j3 = this.f13080g;
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j3);
                    throw new zzlm(sb.toString());
                }
                if (iJ == 3) {
                    long j4 = this.f13080g;
                    if (j4 > 2147483647L) {
                        long j5 = this.f13080g;
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append("String element size: ");
                        sb2.append(j5);
                        throw new zzlm(sb2.toString());
                    }
                    s10 s10Var = this.f13077d;
                    int i2 = this.f13079f;
                    int i3 = (int) j4;
                    if (i3 == 0) {
                        str = HttpUrl.FRAGMENT_ENCODE_SET;
                    } else {
                        byte[] bArr = new byte[i3];
                        zznoVar.readFully(bArr, 0, i3);
                        str = new String(bArr);
                    }
                    s10Var.g(i2, str);
                    this.f13078e = 0;
                    return true;
                }
                if (iJ == 4) {
                    this.f13077d.b(this.f13079f, (int) this.f13080g, zznoVar);
                    this.f13078e = 0;
                    return true;
                }
                if (iJ != 5) {
                    StringBuilder sb3 = new StringBuilder(32);
                    sb3.append("Invalid element type ");
                    sb3.append(iJ);
                    throw new zzlm(sb3.toString());
                }
                long j6 = this.f13080g;
                if (j6 != 4 && j6 != 8) {
                    long j7 = this.f13080g;
                    StringBuilder sb4 = new StringBuilder(40);
                    sb4.append("Invalid float size: ");
                    sb4.append(j7);
                    throw new zzlm(sb4.toString());
                }
                s10 s10Var2 = this.f13077d;
                int i4 = this.f13079f;
                int i5 = (int) j6;
                long jD = d(zznoVar, i5);
                s10Var2.h(i4, i5 == 4 ? Float.intBitsToFloat((int) jD) : Double.longBitsToDouble(jD));
                this.f13078e = 0;
                return true;
            }
            zznoVar.a((int) this.f13080g);
            this.f13078e = 0;
        }
    }
}
