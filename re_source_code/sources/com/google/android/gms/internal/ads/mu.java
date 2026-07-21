package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
class mu extends lu {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final byte[] f12995j;

    mu(byte[] bArr) {
        bArr.getClass();
        this.f12995j = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public final zzdmr C(int i2, int i3) {
        int iY = zzdmr.y(0, i3, size());
        return iY == 0 ? zzdmr.f15982f : new hu(this.f12995j, F(), iY);
    }

    @Override // com.google.android.gms.internal.ads.lu
    final boolean E(zzdmr zzdmrVar, int i2, int i3) {
        if (i3 > zzdmrVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i3);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i3 > zzdmrVar.size()) {
            int size2 = zzdmrVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i3);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!(zzdmrVar instanceof mu)) {
            return zzdmrVar.C(0, i3).equals(C(0, i3));
        }
        mu muVar = (mu) zzdmrVar;
        byte[] bArr = this.f12995j;
        byte[] bArr2 = muVar.f12995j;
        int iF = F() + i3;
        int iF2 = F();
        int iF3 = muVar.F();
        while (iF2 < iF) {
            if (bArr[iF2] != bArr2[iF3]) {
                return false;
            }
            iF2++;
            iF3++;
        }
        return true;
    }

    protected int F() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdmr) || size() != ((zzdmr) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof mu)) {
            return obj.equals(this);
        }
        mu muVar = (mu) obj;
        int iR = r();
        int iR2 = muVar.r();
        if (iR == 0 || iR2 == 0 || iR == iR2) {
            return E(muVar, 0, size());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    protected final String f(Charset charset) {
        return new String(this.f12995j, F(), size(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    final void g(zzdmq zzdmqVar) throws IOException {
        zzdmqVar.a(this.f12995j, F(), size());
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    protected void h(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.f12995j, 0, bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public final boolean o() {
        int iF = F();
        return jx.k(this.f12995j, iF, size() + iF);
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public final zzdnd q() {
        return zzdnd.v(this.f12995j, F(), size(), true);
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public int size() {
        return this.f12995j.length;
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    protected final int u(int i2, int i3, int i4) {
        return zzdod.c(i2, this.f12995j, F(), i4);
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public byte v(int i2) {
        return this.f12995j[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    byte w(int i2) {
        return this.f12995j[i2];
    }
}
