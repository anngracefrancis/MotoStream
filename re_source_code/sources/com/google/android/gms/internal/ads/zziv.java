package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
public final class zziv implements zzid, zzio {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f16326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f16327g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f16328h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f16329i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzkm f16330j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f16331k;
    private int l;
    private int m;
    private zzif n;
    private yz[] o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzkm f16323c = new zzkm(16);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Stack<zzir> f16324d = new Stack<>();
    private final zzkm a = new zzkm(zzkj.a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzkm f16322b = new zzkm(4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16325e = 0;

    @Override // com.google.android.gms.internal.ads.zzio
    public final long a(long j2) {
        int i2;
        long j3 = Long.MAX_VALUE;
        int i3 = 0;
        while (true) {
            yz[] yzVarArr = this.o;
            if (i3 >= yzVarArr.length) {
                return j3;
            }
            zz zzVar = yzVarArr[i3].f13664b;
            int iA = zzkq.a(zzVar.f13727d, j2, true, false);
            while (true) {
                i2 = -1;
                if (iA < 0) {
                    iA = -1;
                    break;
                }
                if (zzVar.f13727d[iA] <= j2 && (zzVar.f13728e[iA] & 1) != 0) {
                    break;
                }
                iA--;
            }
            if (iA == -1) {
                int iH = zzkq.h(zzVar.f13727d, j2, true, false);
                while (true) {
                    long[] jArr = zzVar.f13727d;
                    if (iH < jArr.length) {
                        if (jArr[iH] >= j2 && (zzVar.f13728e[iH] & 1) != 0) {
                            i2 = iH;
                            break;
                        }
                        iH++;
                    } else {
                        break;
                    }
                }
                iA = i2;
            }
            yz[] yzVarArr2 = this.o;
            yzVarArr2[i3].f13666d = iA;
            long j4 = zzVar.f13725b[yzVarArr2[i3].f13666d];
            if (j4 < j3) {
                j3 = j4;
            }
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzio
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final int c(zzie zzieVar, zzij zzijVar) throws InterruptedException, IOException {
        yz[] yzVarArr;
        zzir zzirVar;
        boolean z;
        zziv zzivVar;
        ArrayList arrayList;
        int i2;
        zzix zzixVarA;
        int i3;
        int i4;
        int iM;
        int iM2;
        int iM3;
        int iC;
        int iM4;
        int i5;
        zzkm zzkmVar;
        zzkm zzkmVar2;
        int i6;
        zzkm zzkmVar3;
        int i7;
        int iM5;
        int i8;
        boolean z2;
        zziv zzivVar2 = this;
        zzie zzieVar2 = zzieVar;
        zzijVar = zzijVar;
        while (true) {
            int i9 = zzivVar2.f16325e;
            if (i9 == 0) {
                zziv zzivVar3 = zzivVar2;
                if (zzieVar.b(zzivVar3.f16323c.a, 0, 8, true)) {
                    zzivVar3.f16323c.g(0);
                    zzivVar3.f16328h = zzivVar3.f16323c.k();
                    zzivVar3.f16327g = zzivVar3.f16323c.c();
                    if (zzivVar3.f16328h == 1) {
                        zzieVar.readFully(zzivVar3.f16323c.a, 8, 8);
                        zzivVar3.f16328h = zzivVar3.f16323c.d();
                        zzivVar3.f16326f += 16;
                        zzivVar3.f16329i = 16;
                    } else {
                        zzivVar3.f16326f += 8;
                        zzivVar3.f16329i = 8;
                    }
                    int i10 = zzivVar3.f16327g;
                    if (i10 == vz.p || i10 == vz.r || i10 == vz.s || i10 == vz.t || i10 == vz.u) {
                        if (zzivVar3.f16328h == 1) {
                            zzivVar3.f16324d.add(new zzir(zzivVar3.f16327g, (zzivVar3.f16326f + zzivVar3.f16328h) - ((long) zzivVar3.f16329i)));
                        } else {
                            zzivVar3.f16324d.add(new zzir(zzivVar3.f16327g, (zzivVar3.f16326f + zzivVar3.f16328h) - ((long) zzivVar3.f16329i)));
                        }
                        zzivVar3.f16325e = 0;
                    } else {
                        if (i10 == vz.A || i10 == vz.q || i10 == vz.B || i10 == vz.Q || i10 == vz.R || i10 == vz.C || i10 == vz.f13474b || i10 == vz.v || i10 == vz.f13478f || i10 == vz.f13476d || i10 == vz.T || i10 == vz.U || i10 == vz.V || i10 == vz.W || i10 == vz.X || i10 == vz.Y || i10 == vz.Z || i10 == vz.z) {
                            zzkh.d(zzivVar3.f16328h < 2147483647L);
                            zzkm zzkmVar4 = new zzkm((int) zzivVar3.f16328h);
                            zzivVar3.f16330j = zzkmVar4;
                            System.arraycopy(zzivVar3.f16323c.a, 0, zzkmVar4.a, 0, 8);
                            zzivVar3.f16325e = 1;
                        } else {
                            zzivVar3.f16330j = null;
                            zzivVar3.f16325e = 1;
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    return -1;
                }
                zzivVar2 = zzivVar3;
                zzieVar2 = zzieVar;
            } else {
                if (i9 != 1) {
                    long j2 = Long.MAX_VALUE;
                    int i11 = 0;
                    int i12 = -1;
                    while (true) {
                        yzVarArr = zzivVar2.o;
                        if (i11 >= yzVarArr.length) {
                            break;
                        }
                        yz yzVar = yzVarArr[i11];
                        int i13 = yzVar.f13666d;
                        zz zzVar = yzVar.f13664b;
                        if (i13 != zzVar.a) {
                            long j3 = zzVar.f13725b[i13];
                            if (j3 < j2) {
                                i12 = i11;
                                j2 = j3;
                            }
                        }
                        i11++;
                    }
                    if (i12 == -1) {
                        return -1;
                    }
                    yz yzVar2 = yzVarArr[i12];
                    int i14 = yzVar2.f13666d;
                    long j4 = yzVar2.f13664b.f13725b[i14];
                    long position = (j4 - zzieVar.getPosition()) + ((long) zzivVar2.l);
                    if (position < 0 || position >= 262144) {
                        int i15 = 1;
                        zzijVar.a = j4;
                        return i15;
                    }
                    zzieVar2.a((int) position);
                    zzivVar2.f16331k = yzVar2.f13664b.f13726c[i14];
                    int i16 = yzVar2.a.f16337g;
                    if (i16 == -1) {
                        while (true) {
                            int i17 = zzivVar2.l;
                            int i18 = zzivVar2.f16331k;
                            if (i17 >= i18) {
                                break;
                            }
                            int iA = yzVar2.f13665c.a(zzieVar2, i18 - i17);
                            zzivVar2.l += iA;
                            zzivVar2.m -= iA;
                        }
                    } else {
                        byte[] bArr = zzivVar2.f16322b.a;
                        bArr[0] = 0;
                        bArr[1] = 0;
                        bArr[2] = 0;
                        int i19 = 4 - i16;
                        while (zzivVar2.l < zzivVar2.f16331k) {
                            int i20 = zzivVar2.m;
                            if (i20 == 0) {
                                zzieVar2.readFully(zzivVar2.f16322b.a, i19, i16);
                                zzivVar2.f16322b.g(0);
                                zzivVar2.m = zzivVar2.f16322b.m();
                                zzivVar2.a.g(0);
                                yzVar2.f13665c.c(zzivVar2.a, 4);
                                zzivVar2.l += 4;
                                zzivVar2.f16331k += i19;
                            } else {
                                int iA2 = yzVar2.f13665c.a(zzieVar2, i20);
                                zzivVar2.l += iA2;
                                zzivVar2.m -= iA2;
                            }
                        }
                    }
                    zzip zzipVar = yzVar2.f13665c;
                    zz zzVar2 = yzVar2.f13664b;
                    zzipVar.d(zzVar2.f13727d[i14], zzVar2.f13728e[i14], zzivVar2.f16331k, 0, null);
                    yzVar2.f13666d++;
                    zzivVar2.l = 0;
                    zzivVar2.m = 0;
                    return 0;
                }
                zzivVar2.f16325e = 0;
                long j5 = zzivVar2.f16326f;
                long j6 = zzivVar2.f16328h;
                int i21 = zzivVar2.f16329i;
                long j7 = j5 + (j6 - ((long) i21));
                zzivVar2.f16326f = j7;
                long j8 = j6 - ((long) i21);
                zzkm zzkmVar5 = zzivVar2.f16330j;
                boolean z3 = zzkmVar5 == null && (j6 >= 262144 || j6 > 2147483647L);
                if (z3) {
                    zzijVar.a = j7;
                } else if (zzkmVar5 != null) {
                    zzieVar2.readFully(zzkmVar5.a, i21, (int) j8);
                    if (!zzivVar2.f16324d.isEmpty()) {
                        zzivVar2.f16324d.peek().c0.add(new zzis(zzivVar2.f16327g, zzivVar2.f16330j));
                    }
                } else {
                    zzieVar2.a((int) j8);
                }
                while (!zzivVar2.f16324d.isEmpty() && zzivVar2.f16324d.peek().b0 == zzivVar2.f16326f) {
                    zzir zzirVarPop = zzivVar2.f16324d.pop();
                    if (zzirVarPop.a0 == vz.p) {
                        ArrayList arrayList2 = new ArrayList();
                        int i22 = 0;
                        while (i22 < zzirVarPop.d0.size()) {
                            zzir zzirVar2 = zzirVarPop.d0.get(i22);
                            if (zzirVar2.a0 == vz.r && (zzixVarA = wz.a(zzirVar2, zzirVarPop.c(vz.q))) != null && ((i3 = zzixVarA.f16332b) == 1936684398 || i3 == 1986618469)) {
                                zzir zzirVarD = zzirVar2.d(vz.s).d(vz.t).d(vz.u);
                                zzkm zzkmVar6 = zzirVarD.c(vz.X).b0;
                                int i23 = vz.Y;
                                zzis zzisVarC = zzirVarD.c(i23);
                                if (zzisVarC == null) {
                                    zzisVarC = zzirVarD.c(vz.Z);
                                }
                                zzkm zzkmVar7 = zzisVarC.b0;
                                zzkm zzkmVar8 = zzirVarD.c(vz.W).b0;
                                zzkm zzkmVar9 = zzirVarD.c(vz.T).b0;
                                zzis zzisVarC2 = zzirVarD.c(vz.U);
                                zzkm zzkmVar10 = zzisVarC2 != null ? zzisVarC2.b0 : null;
                                zzis zzisVarC3 = zzirVarD.c(vz.V);
                                zzkm zzkmVar11 = zzisVarC3 != null ? zzisVarC3.b0 : null;
                                zzkmVar6.g(12);
                                int iM6 = zzkmVar6.m();
                                int iM7 = zzkmVar6.m();
                                int[] iArr = new int[iM7];
                                z = z3;
                                long[] jArr = new long[iM7];
                                zzirVar = zzirVarPop;
                                long[] jArr2 = new long[iM7];
                                ArrayList arrayList3 = arrayList2;
                                int[] iArr2 = new int[iM7];
                                int i24 = i22;
                                zzkmVar7.g(12);
                                int iM8 = zzkmVar7.m();
                                zzkmVar8.g(12);
                                int iM9 = zzkmVar8.m() - 1;
                                int i25 = iM8;
                                if (!(zzkmVar8.c() == 1)) {
                                    throw new IllegalStateException("stsc first chunk must be 1");
                                }
                                int iM10 = zzkmVar8.m();
                                zzkmVar8.h(4);
                                if (iM9 > 0) {
                                    iM = zzkmVar8.m() - 1;
                                    i4 = 12;
                                } else {
                                    i4 = 12;
                                    iM = -1;
                                }
                                zzkmVar9.g(i4);
                                int iM11 = zzkmVar9.m() - 1;
                                int iM12 = zzkmVar9.m();
                                int iM13 = zzkmVar9.m();
                                if (zzkmVar11 != null) {
                                    zzkmVar11.g(i4);
                                    iM2 = zzkmVar11.m() - 1;
                                    iM3 = zzkmVar11.m();
                                    iC = zzkmVar11.c();
                                } else {
                                    iM2 = 0;
                                    iM3 = 0;
                                    iC = 0;
                                }
                                if (zzkmVar10 != null) {
                                    zzkmVar10.g(i4);
                                    int iM14 = zzkmVar10.m();
                                    iM4 = zzkmVar10.m() - 1;
                                    i5 = iM14;
                                } else {
                                    iM4 = -1;
                                    i5 = 0;
                                }
                                int i26 = i5;
                                long jK = zzisVarC.a0 == i23 ? zzkmVar7.k() : zzkmVar7.n();
                                int i27 = 0;
                                long j9 = 0;
                                int i28 = iM;
                                int iM15 = iM4;
                                int i29 = 0;
                                int iM16 = iM3;
                                zzkm zzkmVar12 = zzkmVar8;
                                int iM17 = iM13;
                                int i30 = iM11;
                                int i31 = iM9;
                                int iC2 = iC;
                                int i32 = iM2;
                                int iM18 = iM12;
                                int iM19 = iM10;
                                while (i29 < iM7) {
                                    jArr2[i29] = jK;
                                    iArr[i29] = iM6 == 0 ? zzkmVar6.m() : iM6;
                                    zzkm zzkmVar13 = zzkmVar6;
                                    int i33 = i27;
                                    jArr[i29] = j9 + ((long) iC2);
                                    iArr2[i29] = zzkmVar10 == null ? 1 : 0;
                                    if (i29 == iM15) {
                                        iArr2[i29] = 1;
                                        i26--;
                                        if (i26 > 0) {
                                            iM15 = zzkmVar10.m() - 1;
                                        }
                                    }
                                    j9 += (long) iM17;
                                    iM18--;
                                    if (iM18 == 0 && i30 > 0) {
                                        i30--;
                                        iM18 = zzkmVar9.m();
                                        iM17 = zzkmVar9.m();
                                    }
                                    if (zzkmVar11 != null && (iM16 = iM16 - 1) == 0 && i32 > 0) {
                                        i32--;
                                        iM16 = zzkmVar11.m();
                                        iC2 = zzkmVar11.c();
                                    }
                                    iM10--;
                                    if (iM10 == 0) {
                                        i27 = i33 + 1;
                                        i6 = i25;
                                        i7 = i26;
                                        if (i27 < i6) {
                                            zzkmVar = zzkmVar11;
                                            jK = zzisVarC.a0 == vz.Y ? zzkmVar7.k() : zzkmVar7.n();
                                        } else {
                                            zzkmVar = zzkmVar11;
                                        }
                                        iM5 = i28;
                                        if (i27 == iM5) {
                                            iM19 = zzkmVar12.m();
                                            zzkmVar2 = zzkmVar10;
                                            zzkmVar3 = zzkmVar12;
                                            zzkmVar3.h(4);
                                            i31--;
                                            if (i31 > 0) {
                                                iM5 = zzkmVar3.m() - 1;
                                            }
                                        } else {
                                            zzkmVar2 = zzkmVar10;
                                            zzkmVar3 = zzkmVar12;
                                        }
                                        i8 = iM7;
                                        if (i27 < i6) {
                                            iM10 = iM19;
                                        }
                                    } else {
                                        zzkmVar = zzkmVar11;
                                        zzkmVar2 = zzkmVar10;
                                        i6 = i25;
                                        zzkmVar3 = zzkmVar12;
                                        i7 = i26;
                                        iM5 = i28;
                                        i8 = iM7;
                                        jK += (long) iArr[i29];
                                        i27 = i33;
                                    }
                                    i29++;
                                    i28 = iM5;
                                    zzkmVar10 = zzkmVar2;
                                    i26 = i7;
                                    iM7 = i8;
                                    zzkmVar12 = zzkmVar3;
                                    i25 = i6;
                                    zzkmVar6 = zzkmVar13;
                                    zzkmVar11 = zzkmVar;
                                }
                                zzkq.c(jArr, 1000000L, zzixVarA.f16333c);
                                zzkh.a(i26 == 0);
                                zzkh.a(iM18 == 0);
                                zzkh.a(iM10 == 0);
                                zzkh.a(i30 == 0);
                                zzkh.a(i32 == 0);
                                zz zzVar3 = new zz(jArr2, iArr, jArr, iArr2);
                                if (zzVar3.a != 0) {
                                    zzivVar = this;
                                    i2 = i24;
                                    yz yzVar3 = new yz(zzixVarA, zzVar3, zzivVar.n.f(i2));
                                    yzVar3.f13665c.b(zzixVarA.f16335e);
                                    arrayList = arrayList3;
                                    arrayList.add(yzVar3);
                                } else {
                                    zzivVar = this;
                                    arrayList = arrayList3;
                                    i2 = i24;
                                }
                            } else {
                                zzirVar = zzirVarPop;
                                z = z3;
                                zzivVar = zzivVar2;
                                arrayList = arrayList2;
                                i2 = i22;
                            }
                            i22 = i2 + 1;
                            arrayList2 = arrayList;
                            zzivVar2 = zzivVar;
                            z3 = z;
                            zzirVarPop = zzirVar;
                        }
                        zziv zzivVar4 = zzivVar2;
                        zzivVar4.o = (yz[]) arrayList2.toArray(new yz[0]);
                        zzivVar4.n.d();
                        zzivVar4.n.g(zzivVar4);
                        zzivVar4.f16325e = 2;
                        zzivVar2 = zzivVar4;
                    } else {
                        boolean z4 = z3;
                        zziv zzivVar5 = zzivVar2;
                        if (!zzivVar5.f16324d.isEmpty()) {
                            zzivVar5.f16324d.peek().d0.add(zzirVarPop);
                        }
                        zzivVar2 = zzivVar5;
                        z3 = z4;
                    }
                }
                zziv zzivVar6 = zzivVar2;
                if (z3) {
                    return 1;
                }
                zzieVar2 = zzieVar;
                zzivVar2 = zzivVar6;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final void d(zzif zzifVar) {
        this.n = zzifVar;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final void e() {
        this.f16326f = 0L;
        this.l = 0;
        this.m = 0;
    }
}
