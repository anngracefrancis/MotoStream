package c.g.b.k.m;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: ChainRun.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    ArrayList<p> f3095k;
    private int l;

    public c(c.g.b.k.e eVar, int i2) {
        super(eVar);
        this.f3095k = new ArrayList<>();
        this.f3146f = i2;
        q();
    }

    private void q() {
        c.g.b.k.e eVar;
        c.g.b.k.e eVar2 = this.f3142b;
        c.g.b.k.e eVarJ = eVar2.J(this.f3146f);
        while (true) {
            c.g.b.k.e eVar3 = eVarJ;
            eVar = eVar2;
            eVar2 = eVar3;
            if (eVar2 == null) {
                break;
            } else {
                eVarJ = eVar2.J(this.f3146f);
            }
        }
        this.f3142b = eVar;
        this.f3095k.add(eVar.L(this.f3146f));
        c.g.b.k.e eVarH = eVar.H(this.f3146f);
        while (eVarH != null) {
            this.f3095k.add(eVarH.L(this.f3146f));
            eVarH = eVarH.H(this.f3146f);
        }
        for (p pVar : this.f3095k) {
            int i2 = this.f3146f;
            if (i2 == 0) {
                pVar.f3142b.f3069d = this;
            } else if (i2 == 1) {
                pVar.f3142b.f3070e = this;
            }
        }
        if ((this.f3146f == 0 && ((c.g.b.k.f) this.f3142b.I()).x1()) && this.f3095k.size() > 1) {
            ArrayList<p> arrayList = this.f3095k;
            this.f3142b = arrayList.get(arrayList.size() - 1).f3142b;
        }
        this.l = this.f3146f == 0 ? this.f3142b.x() : this.f3142b.N();
    }

    private c.g.b.k.e r() {
        for (int i2 = 0; i2 < this.f3095k.size(); i2++) {
            p pVar = this.f3095k.get(i2);
            if (pVar.f3142b.Q() != 8) {
                return pVar.f3142b;
            }
        }
        return null;
    }

    private c.g.b.k.e s() {
        for (int size = this.f3095k.size() - 1; size >= 0; size--) {
            p pVar = this.f3095k.get(size);
            if (pVar.f3142b.Q() != 8) {
                return pVar.f3142b;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:120:0x01ce A[PHI: r1 r22 r23 r24
      0x01ce: PHI (r1v61 int) = (r1v59 int), (r1v67 int) binds: [B:119:0x01cc, B:110:0x01a6] A[DONT_GENERATE, DONT_INLINE]
      0x01ce: PHI (r22v3 float) = (r22v2 float), (r22v5 float) binds: [B:119:0x01cc, B:110:0x01a6] A[DONT_GENERATE, DONT_INLINE]
      0x01ce: PHI (r23v6 boolean) = (r23v5 boolean), (r23v8 boolean) binds: [B:119:0x01cc, B:110:0x01a6] A[DONT_GENERATE, DONT_INLINE]
      0x01ce: PHI (r24v6 int) = (r24v5 int), (r24v8 int) binds: [B:119:0x01cc, B:110:0x01a6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:122:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:303:0x00f6 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ee A[ADDED_TO_REGION] */
    @Override // c.g.b.k.m.p, c.g.b.k.m.d
    public void a(d dVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float f2;
        boolean z;
        int i7;
        int i8;
        int i9;
        boolean z2;
        int i10;
        float f3;
        int iMax;
        int i11;
        int i12;
        float f4;
        if (this.f3148h.f3112j && this.f3149i.f3112j) {
            c.g.b.k.e eVarI = this.f3142b.I();
            boolean zX1 = (eVarI == null || !(eVarI instanceof c.g.b.k.f)) ? false : ((c.g.b.k.f) eVarI).x1();
            int i13 = this.f3149i.f3109g - this.f3148h.f3109g;
            int size = this.f3095k.size();
            int i14 = 0;
            while (true) {
                i2 = -1;
                i3 = 8;
                if (i14 >= size) {
                    i14 = -1;
                    break;
                } else if (this.f3095k.get(i14).f3142b.Q() != 8) {
                    break;
                } else {
                    i14++;
                }
            }
            int i15 = size - 1;
            for (int i16 = i15; i16 >= 0; i16--) {
                if (this.f3095k.get(i16).f3142b.Q() != 8) {
                    i2 = i16;
                    break;
                }
            }
            int i17 = 0;
            while (true) {
                if (i17 >= 2) {
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                    f2 = 0.0f;
                    break;
                }
                int i18 = 0;
                i5 = 0;
                i6 = 0;
                int i19 = 0;
                f2 = 0.0f;
                while (i18 < size) {
                    p pVar = this.f3095k.get(i18);
                    if (pVar.f3142b.Q() != i3) {
                        i19++;
                        if (i18 > 0 && i18 >= i14) {
                            i5 += pVar.f3148h.f3108f;
                        }
                        g gVar = pVar.f3145e;
                        int i20 = gVar.f3109g;
                        boolean z3 = pVar.f3144d != c.g.b.k.e.b.MATCH_CONSTRAINT;
                        if (z3) {
                            int i21 = this.f3146f;
                            if (i21 == 0 && !pVar.f3142b.f3071f.f3145e.f3112j) {
                                return;
                            }
                            if (i21 == 1 && !pVar.f3142b.f3072g.f3145e.f3112j) {
                                return;
                            } else {
                                i11 = i20;
                            }
                        } else {
                            i11 = i20;
                            if (pVar.a == 1 && i17 == 0) {
                                i12 = gVar.m;
                                i6++;
                            } else {
                                if (gVar.f3112j) {
                                    i12 = i11;
                                }
                                if (z3) {
                                    i5 += i12;
                                } else {
                                    i6++;
                                    f4 = pVar.f3142b.w0[this.f3146f];
                                    if (f4 >= 0.0f) {
                                        f2 += f4;
                                    }
                                }
                                if (i18 >= i15 && i18 < i2) {
                                    i5 += -pVar.f3149i.f3108f;
                                }
                            }
                            z3 = true;
                            if (z3) {
                                i6++;
                                f4 = pVar.f3142b.w0[this.f3146f];
                                if (f4 >= 0.0f) {
                                    f2 += f4;
                                }
                            } else {
                                i5 += i12;
                            }
                            if (i18 >= i15) {
                            }
                        }
                        i12 = i11;
                        if (z3) {
                            i6++;
                            f4 = pVar.f3142b.w0[this.f3146f];
                            if (f4 >= 0.0f) {
                                f2 += f4;
                            }
                        } else {
                            i5 += i12;
                        }
                        if (i18 >= i15) {
                        }
                    }
                    i18++;
                    i3 = 8;
                }
                if (i5 < i13 || i6 == 0) {
                    i4 = i19;
                    break;
                } else {
                    i17++;
                    i3 = 8;
                }
            }
            int i22 = this.f3148h.f3109g;
            if (zX1) {
                i22 = this.f3149i.f3109g;
            }
            if (i5 > i13) {
                i22 = zX1 ? i22 + ((int) (((i5 - i13) / 2.0f) + 0.5f)) : i22 - ((int) (((i5 - i13) / 2.0f) + 0.5f));
            }
            if (i6 > 0) {
                float f5 = i13 - i5;
                int i23 = (int) ((f5 / i6) + 0.5f);
                int i24 = 0;
                int i25 = 0;
                while (i24 < size) {
                    p pVar2 = this.f3095k.get(i24);
                    int i26 = i23;
                    int i27 = i5;
                    if (pVar2.f3142b.Q() != 8 && pVar2.f3144d == c.g.b.k.e.b.MATCH_CONSTRAINT) {
                        g gVar2 = pVar2.f3145e;
                        if (gVar2.f3112j) {
                            z2 = zX1;
                            i10 = i4;
                            i22 = i22;
                            f3 = f5;
                        } else {
                            int i28 = f2 > 0.0f ? (int) (((pVar2.f3142b.w0[this.f3146f] * f5) / f2) + 0.5f) : i26;
                            if (this.f3146f == 0) {
                                c.g.b.k.e eVar = pVar2.f3142b;
                                f3 = f5;
                                int i29 = eVar.u;
                                z2 = zX1;
                                i10 = i4;
                                iMax = Math.max(eVar.t, pVar2.a == 1 ? Math.min(i28, gVar2.m) : i28);
                                if (i29 > 0) {
                                    iMax = Math.min(i29, iMax);
                                }
                                if (iMax != i28) {
                                    i25++;
                                    i28 = iMax;
                                }
                            } else {
                                z2 = zX1;
                                i10 = i4;
                                f3 = f5;
                                c.g.b.k.e eVar2 = pVar2.f3142b;
                                int i30 = eVar2.x;
                                iMax = Math.max(eVar2.w, pVar2.a == 1 ? Math.min(i28, gVar2.m) : i28);
                                if (i30 > 0) {
                                    iMax = Math.min(i30, iMax);
                                }
                                if (iMax != i28) {
                                    i25++;
                                    i28 = iMax;
                                }
                            }
                            pVar2.f3145e.d(i28);
                        }
                    } else {
                        z2 = zX1;
                        i10 = i4;
                        i22 = i22;
                        f3 = f5;
                    }
                    i24++;
                    i23 = i26;
                    i5 = i27;
                    i22 = i22;
                    f5 = f3;
                    zX1 = z2;
                    i4 = i10;
                }
                z = zX1;
                i7 = i4;
                i8 = i22;
                int i31 = i5;
                if (i25 > 0) {
                    i6 -= i25;
                    int i32 = 0;
                    for (int i33 = 0; i33 < size; i33++) {
                        p pVar3 = this.f3095k.get(i33);
                        if (pVar3.f3142b.Q() != 8) {
                            if (i33 > 0 && i33 >= i14) {
                                i32 += pVar3.f3148h.f3108f;
                            }
                            i32 += pVar3.f3145e.f3109g;
                            if (i33 < i15 && i33 < i2) {
                                i32 += -pVar3.f3149i.f3108f;
                            }
                        }
                    }
                    i5 = i32;
                } else {
                    i5 = i31;
                }
                i9 = 2;
                if (this.l == 2 && i25 == 0) {
                    this.l = 0;
                }
            } else {
                z = zX1;
                i7 = i4;
                i8 = i22;
                i9 = 2;
            }
            if (i5 > i13) {
                this.l = i9;
            }
            if (i7 > 0 && i6 == 0 && i14 == i2) {
                this.l = i9;
            }
            int i34 = this.l;
            if (i34 == 1) {
                int i35 = i7;
                int i36 = i35 > 1 ? (i13 - i5) / (i35 - 1) : i35 == 1 ? (i13 - i5) / 2 : 0;
                if (i6 > 0) {
                    i36 = 0;
                }
                int i37 = i8;
                for (int i38 = 0; i38 < size; i38++) {
                    p pVar4 = this.f3095k.get(z ? size - (i38 + 1) : i38);
                    if (pVar4.f3142b.Q() == 8) {
                        pVar4.f3148h.d(i37);
                        pVar4.f3149i.d(i37);
                    } else {
                        if (i38 > 0) {
                            i37 = z ? i37 - i36 : i37 + i36;
                        }
                        if (i38 > 0 && i38 >= i14) {
                            i37 = z ? i37 - pVar4.f3148h.f3108f : i37 + pVar4.f3148h.f3108f;
                        }
                        if (z) {
                            pVar4.f3149i.d(i37);
                        } else {
                            pVar4.f3148h.d(i37);
                        }
                        g gVar3 = pVar4.f3145e;
                        int i39 = gVar3.f3109g;
                        if (pVar4.f3144d == c.g.b.k.e.b.MATCH_CONSTRAINT && pVar4.a == 1) {
                            i39 = gVar3.m;
                        }
                        i37 = z ? i37 - i39 : i37 + i39;
                        if (z) {
                            pVar4.f3148h.d(i37);
                        } else {
                            pVar4.f3149i.d(i37);
                        }
                        pVar4.f3147g = true;
                        if (i38 < i15 && i38 < i2) {
                            i37 = z ? i37 - (-pVar4.f3149i.f3108f) : i37 + (-pVar4.f3149i.f3108f);
                        }
                    }
                }
                return;
            }
            int i40 = i7;
            if (i34 == 0) {
                int i41 = (i13 - i5) / (i40 + 1);
                if (i6 > 0) {
                    i41 = 0;
                }
                int i42 = i8;
                for (int i43 = 0; i43 < size; i43++) {
                    p pVar5 = this.f3095k.get(z ? size - (i43 + 1) : i43);
                    if (pVar5.f3142b.Q() == 8) {
                        pVar5.f3148h.d(i42);
                        pVar5.f3149i.d(i42);
                    } else {
                        int i44 = z ? i42 - i41 : i42 + i41;
                        if (i43 > 0 && i43 >= i14) {
                            i44 = z ? i44 - pVar5.f3148h.f3108f : i44 + pVar5.f3148h.f3108f;
                        }
                        if (z) {
                            pVar5.f3149i.d(i44);
                        } else {
                            pVar5.f3148h.d(i44);
                        }
                        g gVar4 = pVar5.f3145e;
                        int iMin = gVar4.f3109g;
                        if (pVar5.f3144d == c.g.b.k.e.b.MATCH_CONSTRAINT && pVar5.a == 1) {
                            iMin = Math.min(iMin, gVar4.m);
                        }
                        i42 = z ? i44 - iMin : i44 + iMin;
                        if (z) {
                            pVar5.f3148h.d(i42);
                        } else {
                            pVar5.f3149i.d(i42);
                        }
                        if (i43 < i15 && i43 < i2) {
                            i42 = z ? i42 - (-pVar5.f3149i.f3108f) : i42 + (-pVar5.f3149i.f3108f);
                        }
                    }
                }
                return;
            }
            if (i34 == 2) {
                float fW = this.f3146f == 0 ? this.f3142b.w() : this.f3142b.M();
                if (z) {
                    fW = 1.0f - fW;
                }
                int i45 = (int) (((i13 - i5) * fW) + 0.5f);
                if (i45 < 0 || i6 > 0) {
                    i45 = 0;
                }
                int i46 = z ? i8 - i45 : i8 + i45;
                for (int i47 = 0; i47 < size; i47++) {
                    p pVar6 = this.f3095k.get(z ? size - (i47 + 1) : i47);
                    if (pVar6.f3142b.Q() == 8) {
                        pVar6.f3148h.d(i46);
                        pVar6.f3149i.d(i46);
                    } else {
                        if (i47 > 0 && i47 >= i14) {
                            i46 = z ? i46 - pVar6.f3148h.f3108f : i46 + pVar6.f3148h.f3108f;
                        }
                        if (z) {
                            pVar6.f3149i.d(i46);
                        } else {
                            pVar6.f3148h.d(i46);
                        }
                        g gVar5 = pVar6.f3145e;
                        int i48 = gVar5.f3109g;
                        if (pVar6.f3144d == c.g.b.k.e.b.MATCH_CONSTRAINT && pVar6.a == 1) {
                            i48 = gVar5.m;
                        }
                        i46 = z ? i46 - i48 : i46 + i48;
                        if (z) {
                            pVar6.f3148h.d(i46);
                        } else {
                            pVar6.f3149i.d(i46);
                        }
                        if (i47 < i15 && i47 < i2) {
                            i46 = z ? i46 - (-pVar6.f3149i.f3108f) : i46 + (-pVar6.f3149i.f3108f);
                        }
                    }
                }
            }
        }
    }

    @Override // c.g.b.k.m.p
    void d() {
        Iterator<p> it = this.f3095k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f3095k.size();
        if (size < 1) {
            return;
        }
        c.g.b.k.e eVar = this.f3095k.get(0).f3142b;
        c.g.b.k.e eVar2 = this.f3095k.get(size - 1).f3142b;
        if (this.f3146f == 0) {
            c.g.b.k.d dVar = eVar.I;
            c.g.b.k.d dVar2 = eVar2.K;
            f fVarI = i(dVar, 0);
            int iE = dVar.e();
            c.g.b.k.e eVarR = r();
            if (eVarR != null) {
                iE = eVarR.I.e();
            }
            if (fVarI != null) {
                b(this.f3148h, fVarI, iE);
            }
            f fVarI2 = i(dVar2, 0);
            int iE2 = dVar2.e();
            c.g.b.k.e eVarS = s();
            if (eVarS != null) {
                iE2 = eVarS.K.e();
            }
            if (fVarI2 != null) {
                b(this.f3149i, fVarI2, -iE2);
            }
        } else {
            c.g.b.k.d dVar3 = eVar.J;
            c.g.b.k.d dVar4 = eVar2.L;
            f fVarI3 = i(dVar3, 1);
            int iE3 = dVar3.e();
            c.g.b.k.e eVarR2 = r();
            if (eVarR2 != null) {
                iE3 = eVarR2.J.e();
            }
            if (fVarI3 != null) {
                b(this.f3148h, fVarI3, iE3);
            }
            f fVarI4 = i(dVar4, 1);
            int iE4 = dVar4.e();
            c.g.b.k.e eVarS2 = s();
            if (eVarS2 != null) {
                iE4 = eVarS2.L.e();
            }
            if (fVarI4 != null) {
                b(this.f3149i, fVarI4, -iE4);
            }
        }
        this.f3148h.a = this;
        this.f3149i.a = this;
    }

    @Override // c.g.b.k.m.p
    public void e() {
        for (int i2 = 0; i2 < this.f3095k.size(); i2++) {
            this.f3095k.get(i2).e();
        }
    }

    @Override // c.g.b.k.m.p
    void f() {
        this.f3143c = null;
        Iterator<p> it = this.f3095k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // c.g.b.k.m.p
    public long j() {
        int size = this.f3095k.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            p pVar = this.f3095k.get(i2);
            j2 = j2 + ((long) pVar.f3148h.f3108f) + pVar.j() + ((long) pVar.f3149i.f3108f);
        }
        return j2;
    }

    @Override // c.g.b.k.m.p
    boolean m() {
        int size = this.f3095k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.f3095k.get(i2).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.f3146f == 0 ? "horizontal : " : "vertical : ");
        String string = sb.toString();
        Iterator<p> it = this.f3095k.iterator();
        while (it.hasNext()) {
            String str = string + "<";
            string = (str + it.next()) + "> ";
        }
        return string;
    }
}
