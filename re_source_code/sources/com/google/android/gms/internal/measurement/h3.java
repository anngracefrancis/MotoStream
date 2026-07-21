package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class h3<T> implements p3<T> {
    private final zzgo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h4<?, ?> f17171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f17172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d2<?> f17173d;

    private h3(h4<?, ?> h4Var, d2<?> d2Var, zzgo zzgoVar) {
        this.f17171b = h4Var;
        this.f17172c = d2Var.h(zzgoVar);
        this.f17173d = d2Var;
        this.a = zzgoVar;
    }

    static <T> h3<T> k(h4<?, ?> h4Var, d2<?> d2Var, zzgo zzgoVar) {
        return new h3<>(h4Var, d2Var, zzgoVar);
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final T a() {
        return (T) this.a.f().x();
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final int b(T t) {
        h4<?, ?> h4Var = this.f17171b;
        int iR = h4Var.r(h4Var.k(t)) + 0;
        return this.f17172c ? iR + this.f17173d.b(t).r() : iR;
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final int c(T t) {
        int iHashCode = this.f17171b.k(t).hashCode();
        return this.f17172c ? (iHashCode * 53) + this.f17173d.b(t).hashCode() : iHashCode;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0094  */
    /* JADX WARN: Code duplicated, block: B:57:0x0099 A[EDGE_INSN: B:57:0x0099->B:34:0x0099 BREAK  A[LOOP:1: B:18:0x0053->B:62:0x0053], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.p3
    public final void d(T t, byte[] bArr, int i2, int i3, m1 m1Var) throws IOException {
        zzfd zzfdVar = (zzfd) t;
        zzhy zzhyVarG = zzfdVar.zzb;
        if (zzhyVarG == zzhy.a()) {
            zzhyVarG = zzhy.g();
            zzfdVar.zzb = zzhyVarG;
        }
        ((zzfd.zzd) t).B();
        zzfd.zzf zzfVar = null;
        while (i2 < i3) {
            int i4 = j1.i(bArr, i2, m1Var);
            int i5 = m1Var.a;
            if (i5 == 11) {
                int i6 = 0;
                zzdu zzduVar = null;
                while (i4 < i3) {
                    i4 = j1.i(bArr, i4, m1Var);
                    int i7 = m1Var.a;
                    int i8 = i7 >>> 3;
                    int i9 = i7 & 7;
                    if (i8 == 2) {
                        if (i9 != 0) {
                            if (i7 != 12) {
                                break;
                                break;
                            }
                            i4 = j1.a(i7, bArr, i4, i3, m1Var);
                        } else {
                            i4 = j1.i(bArr, i4, m1Var);
                            i6 = m1Var.a;
                            zzfVar = (zzfd.zzf) this.f17173d.c(m1Var.f17220d, this.a, i6);
                        }
                    } else {
                        if (i8 == 3) {
                            if (zzfVar != null) {
                                l3.a();
                                throw new NoSuchMethodError();
                            }
                            if (i9 == 2) {
                                i4 = j1.q(bArr, i4, m1Var);
                                zzduVar = (zzdu) m1Var.f17219c;
                            }
                        }
                        if (i7 != 12) {
                            break;
                        } else {
                            i4 = j1.a(i7, bArr, i4, i3, m1Var);
                        }
                    }
                }
                if (zzduVar != null) {
                    zzhyVarG.c((i6 << 3) | 2, zzduVar);
                }
                i2 = i4;
            } else if ((i5 & 7) == 2) {
                zzfVar = (zzfd.zzf) this.f17173d.c(m1Var.f17220d, this.a, i5 >>> 3);
                if (zzfVar != null) {
                    l3.a();
                    throw new NoSuchMethodError();
                }
                i2 = j1.c(i5, bArr, i4, i3, zzhyVarG, m1Var);
            } else {
                i2 = j1.a(i5, bArr, i4, i3, m1Var);
            }
        }
        if (i2 != i3) {
            throw zzfo.g();
        }
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final boolean e(T t) {
        return this.f17173d.b(t).q();
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final void f(T t) {
        this.f17171b.q(t);
        this.f17173d.j(t);
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final boolean g(T t, T t2) {
        if (!this.f17171b.k(t).equals(this.f17171b.k(t2))) {
            return false;
        }
        if (this.f17172c) {
            return this.f17173d.b(t).equals(this.f17173d.b(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final void h(T t, y4 y4Var) throws IOException {
        Iterator itO = this.f17173d.b(t).o();
        while (itO.hasNext()) {
            Map.Entry entry = (Map.Entry) itO.next();
            zzey zzeyVar = (zzey) entry.getKey();
            if (zzeyVar.c() != zzip.MESSAGE || zzeyVar.d() || zzeyVar.e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof o2) {
                y4Var.f(zzeyVar.a(), ((o2) entry).a().d());
            } else {
                y4Var.f(zzeyVar.a(), entry.getValue());
            }
        }
        h4<?, ?> h4Var = this.f17171b;
        h4Var.m(h4Var.k(t), y4Var);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:? A[LOOP:0: B:46:0x000c->B:54:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.p3
    public final void i(T t, q3 q3Var, zzeq zzeqVar) throws IOException {
        boolean zC;
        h4<?, ?> h4Var = this.f17171b;
        d2<?> d2Var = this.f17173d;
        Object objO = h4Var.o(t);
        h2<T> h2VarI = d2Var.i(t);
        while (q3Var.a() != Integer.MAX_VALUE) {
            try {
                int iB = q3Var.b();
                if (iB != 11) {
                    if ((iB & 7) == 2) {
                        Object objC = d2Var.c(zzeqVar, this.a, iB >>> 3);
                        if (objC != null) {
                            d2Var.f(q3Var, objC, zzeqVar, h2VarI);
                        } else {
                            zC = h4Var.j(objO, q3Var);
                        }
                    } else {
                        zC = q3Var.c();
                    }
                    if (!zC) {
                        h4Var.n(t, objO);
                        return;
                    }
                } else {
                    int iP = 0;
                    Object objC2 = null;
                    zzdu zzduVarF = null;
                    while (q3Var.a() != Integer.MAX_VALUE) {
                        int iB2 = q3Var.b();
                        if (iB2 == 16) {
                            iP = q3Var.p();
                            objC2 = d2Var.c(zzeqVar, this.a, iP);
                        } else if (iB2 == 26) {
                            if (objC2 != null) {
                                d2Var.f(q3Var, objC2, zzeqVar, h2VarI);
                            } else {
                                zzduVarF = q3Var.f();
                            }
                        } else if (!q3Var.c()) {
                            break;
                        }
                    }
                    if (q3Var.b() != 12) {
                        throw zzfo.e();
                    }
                    if (zzduVarF != null) {
                        if (objC2 != null) {
                            d2Var.e(zzduVarF, objC2, zzeqVar, h2VarI);
                        } else {
                            h4Var.e(objO, iP, zzduVarF);
                        }
                    }
                }
                zC = true;
                if (!zC) {
                    h4Var.n(t, objO);
                    return;
                }
            } catch (Throwable th) {
                h4Var.n(t, objO);
                throw th;
            }
        }
        h4Var.n(t, objO);
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final void j(T t, T t2) {
        r3.o(this.f17171b, t, t2);
        if (this.f17172c) {
            r3.m(this.f17173d, t, t2);
        }
    }
}
