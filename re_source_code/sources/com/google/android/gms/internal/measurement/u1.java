package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
class u1 extends v1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final byte[] f17261j;

    u1(byte[] bArr) {
        bArr.getClass();
        this.f17261j = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.v1
    final boolean A(zzdu zzduVar, int i2, int i3) {
        if (i3 > zzduVar.f()) {
            int iF = f();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i3);
            sb.append(iF);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i3 > zzduVar.f()) {
            int iF2 = zzduVar.f();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i3);
            sb2.append(", ");
            sb2.append(iF2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!(zzduVar instanceof u1)) {
            return zzduVar.i(0, i3).equals(i(0, i3));
        }
        u1 u1Var = (u1) zzduVar;
        byte[] bArr = this.f17261j;
        byte[] bArr2 = u1Var.f17261j;
        int iC = C() + i3;
        int iC2 = C();
        int iC3 = u1Var.C();
        while (iC2 < iC) {
            if (bArr[iC2] != bArr2[iC3]) {
                return false;
            }
            iC2++;
            iC3++;
        }
        return true;
    }

    protected int C() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public byte c(int i2) {
        return this.f17261j[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdu) || f() != ((zzdu) obj).f()) {
            return false;
        }
        if (f() == 0) {
            return true;
        }
        if (!(obj instanceof u1)) {
            return obj.equals(this);
        }
        u1 u1Var = (u1) obj;
        int iZ = z();
        int iZ2 = u1Var.z();
        if (iZ == 0 || iZ2 == 0 || iZ == iZ2) {
            return A(u1Var, 0, f());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public int f() {
        return this.f17261j.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    protected final int h(int i2, int i3, int i4) {
        return zzff.a(i2, this.f17261j, C(), i4);
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final zzdu i(int i2, int i3) {
        int iV = zzdu.v(0, i3, f());
        return iV == 0 ? zzdu.f17368f : new s1(this.f17261j, C(), iV);
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    protected final String r(Charset charset) {
        return new String(this.f17261j, C(), f(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    final void s(zzdv zzdvVar) throws IOException {
        zzdvVar.a(this.f17261j, C(), f());
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    byte t(int i2) {
        return this.f17261j[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final boolean y() {
        int iC = C();
        return n4.g(this.f17261j, iC, f() + iC);
    }
}
