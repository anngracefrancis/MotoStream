package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

/* JADX INFO: loaded from: classes2.dex */
final class f30 implements zzqj, zzqk {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zzqj[] f12557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final IdentityHashMap<zzqw, Integer> f12558g = new IdentityHashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzqk f12559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzrb f12561j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzqj[] f12562k;
    private zzqx l;

    public f30(zzqj... zzqjVarArr) {
        this.f12557f = zzqjVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzqj, com.google.android.gms.internal.ads.zzqx
    public final long a() {
        return this.l.a();
    }

    @Override // com.google.android.gms.internal.ads.zzqj, com.google.android.gms.internal.ads.zzqx
    public final boolean b(long j2) {
        return this.l.b(j2);
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long c(zzrm[] zzrmVarArr, boolean[] zArr, zzqw[] zzqwVarArr, boolean[] zArr2, long j2) {
        zzqw[] zzqwVarArr2 = zzqwVarArr;
        int[] iArr = new int[zzrmVarArr.length];
        int[] iArr2 = new int[zzrmVarArr.length];
        for (int i2 = 0; i2 < zzrmVarArr.length; i2++) {
            iArr[i2] = zzqwVarArr2[i2] == null ? -1 : this.f12558g.get(zzqwVarArr2[i2]).intValue();
            iArr2[i2] = -1;
            if (zzrmVarArr[i2] != null) {
                zzra zzraVarA = zzrmVarArr[i2].a();
                int i3 = 0;
                while (true) {
                    zzqj[] zzqjVarArr = this.f12557f;
                    if (i3 >= zzqjVarArr.length) {
                        break;
                    }
                    if (zzqjVarArr[i3].l().a(zzraVarA) != -1) {
                        iArr2[i2] = i3;
                        break;
                    }
                    i3++;
                }
            }
        }
        this.f12558g.clear();
        int length = zzrmVarArr.length;
        zzqw[] zzqwVarArr3 = new zzqw[length];
        zzqw[] zzqwVarArr4 = new zzqw[zzrmVarArr.length];
        zzrm[] zzrmVarArr2 = new zzrm[zzrmVarArr.length];
        ArrayList arrayList = new ArrayList(this.f12557f.length);
        long j3 = j2;
        int i4 = 0;
        while (i4 < this.f12557f.length) {
            for (int i5 = 0; i5 < zzrmVarArr.length; i5++) {
                zzrm zzrmVar = null;
                zzqwVarArr4[i5] = iArr[i5] == i4 ? zzqwVarArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    zzrmVar = zzrmVarArr[i5];
                }
                zzrmVarArr2[i5] = zzrmVar;
            }
            int i6 = i4;
            zzrm[] zzrmVarArr3 = zzrmVarArr2;
            ArrayList arrayList2 = arrayList;
            long jC = this.f12557f[i4].c(zzrmVarArr2, zArr, zzqwVarArr4, zArr2, j3);
            if (i6 == 0) {
                j3 = jC;
            } else if (jC != j3) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i7 = 0; i7 < zzrmVarArr.length; i7++) {
                if (iArr2[i7] == i6) {
                    zzsk.e(zzqwVarArr4[i7] != null);
                    zzqwVarArr3[i7] = zzqwVarArr4[i7];
                    this.f12558g.put(zzqwVarArr4[i7], Integer.valueOf(i6));
                    z = true;
                } else if (iArr[i7] == i6) {
                    zzsk.e(zzqwVarArr4[i7] == null);
                }
            }
            if (z) {
                arrayList2.add(this.f12557f[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            zzrmVarArr2 = zzrmVarArr3;
            zzqwVarArr2 = zzqwVarArr;
        }
        zzqw[] zzqwVarArr5 = zzqwVarArr2;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzqwVarArr3, 0, zzqwVarArr5, 0, length);
        zzqj[] zzqjVarArr2 = new zzqj[arrayList3.size()];
        this.f12562k = zzqjVarArr2;
        arrayList3.toArray(zzqjVarArr2);
        this.l = new zzpy(this.f12562k);
        return j3;
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void d(zzqj zzqjVar) {
        int i2 = this.f12560i - 1;
        this.f12560i = i2;
        if (i2 > 0) {
            return;
        }
        int i3 = 0;
        for (zzqj zzqjVar2 : this.f12557f) {
            i3 += zzqjVar2.l().f16641b;
        }
        zzra[] zzraVarArr = new zzra[i3];
        int i4 = 0;
        for (zzqj zzqjVar3 : this.f12557f) {
            zzrb zzrbVarL = zzqjVar3.l();
            int i5 = zzrbVarL.f16641b;
            int i6 = 0;
            while (i6 < i5) {
                zzraVarArr[i4] = zzrbVarL.b(i6);
                i6++;
                i4++;
            }
        }
        this.f12561j = new zzrb(zzraVarArr);
        this.f12559h.d(this);
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long e() {
        long jE = this.f12557f[0].e();
        int i2 = 1;
        while (true) {
            zzqj[] zzqjVarArr = this.f12557f;
            if (i2 >= zzqjVarArr.length) {
                if (jE != -9223372036854775807L) {
                    for (zzqj zzqjVar : this.f12562k) {
                        if (zzqjVar != this.f12557f[0] && zzqjVar.h(jE) != jE) {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return jE;
            }
            if (zzqjVarArr[i2].e() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final void f() throws IOException {
        for (zzqj zzqjVar : this.f12557f) {
            zzqjVar.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqy
    public final /* synthetic */ void g(zzqx zzqxVar) {
        if (this.f12561j != null) {
            this.f12559h.g(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long h(long j2) {
        long jH = this.f12562k[0].h(j2);
        int i2 = 1;
        while (true) {
            zzqj[] zzqjVarArr = this.f12562k;
            if (i2 >= zzqjVarArr.length) {
                return jH;
            }
            if (zzqjVarArr[i2].h(jH) != jH) {
                throw new IllegalStateException("Children seeked to different positions");
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final void j(zzqk zzqkVar, long j2) {
        this.f12559h = zzqkVar;
        zzqj[] zzqjVarArr = this.f12557f;
        this.f12560i = zzqjVarArr.length;
        for (zzqj zzqjVar : zzqjVarArr) {
            zzqjVar.j(this, j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final void k(long j2) {
        for (zzqj zzqjVar : this.f12562k) {
            zzqjVar.k(j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final zzrb l() {
        return this.f12561j;
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long r() {
        long jMin = Long.MAX_VALUE;
        for (zzqj zzqjVar : this.f12562k) {
            long jR = zzqjVar.r();
            if (jR != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jR);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }
}
