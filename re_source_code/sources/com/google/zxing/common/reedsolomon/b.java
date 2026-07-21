package com.google.zxing.common.reedsolomon;

/* JADX INFO: compiled from: GenericGFPoly.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {
    private final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f20319b;

    b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = aVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f20319b = iArr;
            return;
        }
        int i2 = 1;
        while (i2 < length && iArr[i2] == 0) {
            i2++;
        }
        if (i2 == length) {
            this.f20319b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i2];
        this.f20319b = iArr2;
        System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
    }

    b a(b bVar) {
        if (!this.a.equals(bVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (f()) {
            return bVar;
        }
        if (bVar.f()) {
            return this;
        }
        int[] iArr = this.f20319b;
        int[] iArr2 = bVar.f20319b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i2 = length; i2 < iArr.length; i2++) {
            iArr3[i2] = a.a(iArr2[i2 - length], iArr[i2]);
        }
        return new b(this.a, iArr3);
    }

    b[] b(b bVar) {
        if (!this.a.equals(bVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (bVar.f()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        b bVarE = this.a.e();
        int iF = this.a.f(bVar.c(bVar.e()));
        b bVarA = this;
        while (bVarA.e() >= bVar.e() && !bVarA.f()) {
            int iE = bVarA.e() - bVar.e();
            int iH = this.a.h(bVarA.c(bVarA.e()), iF);
            b bVarH = bVar.h(iE, iH);
            bVarE = bVarE.a(this.a.b(iE, iH));
            bVarA = bVarA.a(bVarH);
        }
        return new b[]{bVarE, bVarA};
    }

    int c(int i2) {
        int[] iArr = this.f20319b;
        return iArr[(iArr.length - 1) - i2];
    }

    int[] d() {
        return this.f20319b;
    }

    int e() {
        return this.f20319b.length - 1;
    }

    boolean f() {
        return this.f20319b[0] == 0;
    }

    b g(b bVar) {
        if (!this.a.equals(bVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (f() || bVar.f()) {
            return this.a.e();
        }
        int[] iArr = this.f20319b;
        int length = iArr.length;
        int[] iArr2 = bVar.f20319b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            for (int i4 = 0; i4 < length2; i4++) {
                int i5 = i2 + i4;
                iArr3[i5] = a.a(iArr3[i5], this.a.h(i3, iArr2[i4]));
            }
        }
        return new b(this.a, iArr3);
    }

    b h(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.a.e();
        }
        int length = this.f20319b.length;
        int[] iArr = new int[i2 + length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.a.h(this.f20319b[i4], i3);
        }
        return new b(this.a, iArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(e() * 8);
        for (int iE = e(); iE >= 0; iE--) {
            int iC = c(iE);
            if (iC != 0) {
                if (iC < 0) {
                    sb.append(" - ");
                    iC = -iC;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iE == 0 || iC != 1) {
                    int iG = this.a.g(iC);
                    if (iG == 0) {
                        sb.append('1');
                    } else if (iG == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(iG);
                    }
                }
                if (iE != 0) {
                    if (iE == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iE);
                    }
                }
            }
        }
        return sb.toString();
    }
}
