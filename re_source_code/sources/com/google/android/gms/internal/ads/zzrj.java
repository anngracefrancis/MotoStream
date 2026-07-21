package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzrj extends zzrp {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray<Map<zzrb, zzrl>> f16665b = new SparseArray<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseBooleanArray f16666c = new SparseBooleanArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16667d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzrk f16668e;

    @Override // com.google.android.gms.internal.ads.zzrp
    public final zzrr b(zzlp[] zzlpVarArr, zzrb zzrbVar) throws zzku {
        int[] iArr;
        int[] iArr2 = new int[zzlpVarArr.length + 1];
        int length = zzlpVarArr.length + 1;
        zzra[][] zzraVarArr = new zzra[length][];
        int[][][] iArr3 = new int[zzlpVarArr.length + 1][][];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = zzrbVar.f16641b;
            zzraVarArr[i2] = new zzra[i3];
            iArr3[i2] = new int[i3][];
        }
        int length2 = zzlpVarArr.length;
        int[] iArr4 = new int[length2];
        for (int i4 = 0; i4 < length2; i4++) {
            iArr4[i4] = zzlpVarArr[i4].a();
        }
        for (int i5 = 0; i5 < zzrbVar.f16641b; i5++) {
            zzra zzraVarB = zzrbVar.b(i5);
            int length3 = zzlpVarArr.length;
            int i6 = 0;
            for (int i7 = 0; i7 < zzlpVarArr.length; i7++) {
                zzlp zzlpVar = zzlpVarArr[i7];
                for (int i8 = 0; i8 < zzraVarB.a; i8++) {
                    int iB = zzlpVar.b(zzraVarB.a(i8)) & 3;
                    if (iB > i6) {
                        length3 = i7;
                        if (iB == 3) {
                            break;
                        }
                        i6 = iB;
                    }
                }
            }
            if (length3 == zzlpVarArr.length) {
                iArr = new int[zzraVarB.a];
            } else {
                zzlp zzlpVar2 = zzlpVarArr[length3];
                int[] iArr5 = new int[zzraVarB.a];
                for (int i9 = 0; i9 < zzraVarB.a; i9++) {
                    iArr5[i9] = zzlpVar2.b(zzraVarB.a(i9));
                }
                iArr = iArr5;
            }
            int i10 = iArr2[length3];
            zzraVarArr[length3][i10] = zzraVarB;
            iArr3[length3][i10] = iArr;
            iArr2[length3] = iArr2[length3] + 1;
        }
        zzrb[] zzrbVarArr = new zzrb[zzlpVarArr.length];
        int[] iArr6 = new int[zzlpVarArr.length];
        for (int i11 = 0; i11 < zzlpVarArr.length; i11++) {
            int i12 = iArr2[i11];
            zzrbVarArr[i11] = new zzrb((zzra[]) Arrays.copyOf(zzraVarArr[i11], i12));
            iArr3[i11] = (int[][]) Arrays.copyOf(iArr3[i11], i12);
            iArr6[i11] = zzlpVarArr[i11].E();
        }
        zzrb zzrbVar2 = new zzrb((zzra[]) Arrays.copyOf(zzraVarArr[zzlpVarArr.length], iArr2[zzlpVarArr.length]));
        zzrm[] zzrmVarArrE = e(zzlpVarArr, zzrbVarArr, iArr3);
        int i13 = 0;
        while (true) {
            if (i13 >= zzlpVarArr.length) {
                zzrk zzrkVar = new zzrk(iArr6, zzrbVarArr, iArr4, iArr3, zzrbVar2);
                zzlq[] zzlqVarArr = new zzlq[zzlpVarArr.length];
                for (int i14 = 0; i14 < zzlpVarArr.length; i14++) {
                    zzlqVarArr[i14] = zzrmVarArrE[i14] != null ? zzlq.a : null;
                }
                return new zzrr(zzrbVar, new zzro(zzrmVarArrE), zzrkVar, zzlqVarArr);
            }
            if (this.f16666c.get(i13)) {
                zzrmVarArrE[i13] = null;
            } else {
                zzrb zzrbVar3 = zzrbVarArr[i13];
                Map<zzrb, zzrl> map = this.f16665b.get(i13);
                if ((map != null ? map.get(zzrbVar3) : null) != null) {
                    throw new NoSuchMethodError();
                }
            }
            i13++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final void d(Object obj) {
        this.f16668e = (zzrk) obj;
    }

    protected abstract zzrm[] e(zzlp[] zzlpVarArr, zzrb[] zzrbVarArr, int[][][] iArr) throws zzku;

    public final void f(int i2, boolean z) {
        if (this.f16666c.get(i2) == z) {
            return;
        }
        this.f16666c.put(i2, z);
        a();
    }
}
