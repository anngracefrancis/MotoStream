package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class bw<T> implements lw<T> {
    private final zzdpk a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final cx<?, ?> f12369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f12370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final vu<?> f12371d;

    private bw(cx<?, ?> cxVar, vu<?> vuVar, zzdpk zzdpkVar) {
        this.f12369b = cxVar;
        this.f12370c = vuVar.h(zzdpkVar);
        this.f12371d = vuVar;
        this.a = zzdpkVar;
    }

    static <T> bw<T> k(cx<?, ?> cxVar, vu<?> vuVar, zzdpk zzdpkVar) {
        return new bw<>(cxVar, vuVar, zzdpkVar);
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final void a(T t, T t2) {
        nw.h(this.f12369b, t, t2);
        if (this.f12370c) {
            nw.f(this.f12371d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final boolean b(T t, T t2) {
        if (!this.f12369b.j(t).equals(this.f12369b.j(t2))) {
            return false;
        }
        if (this.f12370c) {
            return this.f12371d.i(t).equals(this.f12371d.i(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final T c() {
        return (T) this.a.d().a1();
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final int d(T t) {
        int iHashCode = this.f12369b.j(t).hashCode();
        return this.f12370c ? (iHashCode * 53) + this.f12371d.i(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final void e(T t, ux uxVar) throws IOException {
        Iterator itE = this.f12371d.i(t).e();
        while (itE.hasNext()) {
            Map.Entry entry = (Map.Entry) itE.next();
            zzdnu zzdnuVar = (zzdnu) entry.getKey();
            if (zzdnuVar.s() != zzdrn.MESSAGE || zzdnuVar.t() || zzdnuVar.w()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof iv) {
                uxVar.G(zzdnuVar.i(), ((iv) entry).a().a());
            } else {
                uxVar.G(zzdnuVar.i(), entry.getValue());
            }
        }
        cx<?, ?> cxVar = this.f12369b;
        cxVar.p(cxVar.j(t), uxVar);
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final void f(T t) {
        this.f12369b.g(t);
        this.f12371d.g(t);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8 A[EDGE_INSN: B:61:0x00a8->B:37:0x00a8 BREAK  A[LOOP:1: B:21:0x0062->B:65:0x0062], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.lw
    public final void g(T t, byte[] bArr, int i2, int i3, bu buVar) throws IOException {
        zzdob zzdobVar = (zzdob) t;
        zzdqu zzdquVarI = zzdobVar.zzhhd;
        if (zzdquVarI == zzdqu.f()) {
            zzdquVarI = zzdqu.i();
            zzdobVar.zzhhd = zzdquVarI;
        }
        zzdob.zzc zzcVar = (zzdob.zzc) t;
        if (zzcVar.zzhhj.c()) {
            zzcVar.zzhhj = (yu) zzcVar.zzhhj.clone();
        }
        zzdob.zzd zzdVar = null;
        while (i2 < i3) {
            int iH = au.h(bArr, i2, buVar);
            int i4 = buVar.a;
            if (i4 == 11) {
                int i5 = 0;
                zzdmr zzdmrVar = null;
                while (iH < i3) {
                    iH = au.h(bArr, iH, buVar);
                    int i6 = buVar.a;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 == 2) {
                        if (i8 != 0) {
                            if (i6 != 12) {
                                break;
                                break;
                            }
                            iH = au.a(i6, bArr, iH, i3, buVar);
                        } else {
                            iH = au.h(bArr, iH, buVar);
                            i5 = buVar.a;
                            zzdVar = (zzdob.zzd) this.f12371d.b(buVar.f12362d, this.a, i5);
                        }
                    } else {
                        if (i7 == 3) {
                            if (zzdVar != null) {
                                gw.b();
                                throw new NoSuchMethodError();
                            }
                            if (i8 == 2) {
                                iH = au.m(bArr, iH, buVar);
                                zzdmrVar = (zzdmr) buVar.f12361c;
                            }
                        }
                        if (i6 != 12) {
                            break;
                        } else {
                            iH = au.a(i6, bArr, iH, i3, buVar);
                        }
                    }
                }
                if (zzdmrVar != null) {
                    zzdquVarI.k((i5 << 3) | 2, zzdmrVar);
                }
                i2 = iH;
            } else if ((i4 & 7) == 2) {
                zzdVar = (zzdob.zzd) this.f12371d.b(buVar.f12362d, this.a, i4 >>> 3);
                if (zzdVar != null) {
                    gw.b();
                    throw new NoSuchMethodError();
                }
                i2 = au.c(i4, bArr, iH, i3, zzdquVarI, buVar);
            } else {
                i2 = au.a(i4, bArr, iH, i3, buVar);
            }
        }
        if (i2 != i3) {
            throw zzdok.g();
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:? A[LOOP:0: B:46:0x000c->B:54:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.lw
    public final void h(T t, kw kwVar, zzdno zzdnoVar) throws IOException {
        boolean zS;
        cx<?, ?> cxVar = this.f12369b;
        vu<?> vuVar = this.f12371d;
        Object objK = cxVar.k(t);
        yu<T> yuVarJ = vuVar.j(t);
        while (kwVar.N() != Integer.MAX_VALUE) {
            try {
                int tag = kwVar.getTag();
                if (tag != 11) {
                    if ((tag & 7) == 2) {
                        Object objB = vuVar.b(zzdnoVar, this.a, tag >>> 3);
                        if (objB != null) {
                            vuVar.e(kwVar, objB, zzdnoVar, yuVarJ);
                        } else {
                            zS = cxVar.f(objK, kwVar);
                        }
                    } else {
                        zS = kwVar.S();
                    }
                    if (!zS) {
                        cxVar.r(t, objK);
                        return;
                    }
                } else {
                    int iV = 0;
                    Object objB2 = null;
                    zzdmr zzdmrVarT = null;
                    while (kwVar.N() != Integer.MAX_VALUE) {
                        int tag2 = kwVar.getTag();
                        if (tag2 == 16) {
                            iV = kwVar.V();
                            objB2 = vuVar.b(zzdnoVar, this.a, iV);
                        } else if (tag2 == 26) {
                            if (objB2 != null) {
                                vuVar.e(kwVar, objB2, zzdnoVar, yuVarJ);
                            } else {
                                zzdmrVarT = kwVar.T();
                            }
                        } else if (!kwVar.S()) {
                            break;
                        }
                    }
                    if (kwVar.getTag() != 12) {
                        throw zzdok.e();
                    }
                    if (zzdmrVarT != null) {
                        if (objB2 != null) {
                            vuVar.d(zzdmrVarT, objB2, zzdnoVar, yuVarJ);
                        } else {
                            cxVar.b(objK, iV, zzdmrVarT);
                        }
                    }
                }
                zS = true;
                if (!zS) {
                    cxVar.r(t, objK);
                    return;
                }
            } catch (Throwable th) {
                cxVar.r(t, objK);
                throw th;
            }
        }
        cxVar.r(t, objK);
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final int i(T t) {
        cx<?, ?> cxVar = this.f12369b;
        int iL = cxVar.l(cxVar.j(t)) + 0;
        return this.f12370c ? iL + this.f12371d.i(t).o() : iL;
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final boolean j(T t) {
        return this.f12371d.i(t).d();
    }
}
