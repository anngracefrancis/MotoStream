package j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SegmentedByteString.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends i {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final transient byte[][] f22826k;
    private final transient int[] l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(byte[][] bArr, int[] iArr) {
        super(i.f22841f.y());
        kotlin.jvm.internal.m.f(bArr, "segments");
        kotlin.jvm.internal.m.f(iArr, "directory");
        this.f22826k = bArr;
        this.l = iArr;
    }

    private final i X() {
        return new i(W());
    }

    private final Object writeReplace() {
        i iVarX = X();
        if (iVarX != null) {
            return iVarX;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
    }

    @Override // j.i
    public int D() {
        return U()[V().length - 1];
    }

    @Override // j.i
    public String F() {
        return X().F();
    }

    @Override // j.i
    public byte[] G() {
        return W();
    }

    @Override // j.i
    public byte H(int i2) {
        c.b(U()[V().length - 1], i2, 1L);
        int iB = j.g0.c.b(this, i2);
        return V()[iB][(i2 - (iB == 0 ? 0 : U()[iB - 1])) + U()[V().length + iB]];
    }

    @Override // j.i
    public boolean J(int i2, i iVar, int i3, int i4) {
        kotlin.jvm.internal.m.f(iVar, "other");
        if (i2 < 0 || i2 > P() - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int iB = j.g0.c.b(this, i2);
        while (i2 < i5) {
            int i6 = iB == 0 ? 0 : U()[iB - 1];
            int i7 = U()[iB] - i6;
            int i8 = U()[V().length + iB];
            int iMin = Math.min(i5, i7 + i6) - i2;
            if (!iVar.K(i3, V()[iB], i8 + (i2 - i6), iMin)) {
                return false;
            }
            i3 += iMin;
            i2 += iMin;
            iB++;
        }
        return true;
    }

    @Override // j.i
    public boolean K(int i2, byte[] bArr, int i3, int i4) {
        kotlin.jvm.internal.m.f(bArr, "other");
        if (i2 < 0 || i2 > P() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int iB = j.g0.c.b(this, i2);
        while (i2 < i5) {
            int i6 = iB == 0 ? 0 : U()[iB - 1];
            int i7 = U()[iB] - i6;
            int i8 = U()[V().length + iB];
            int iMin = Math.min(i5, i7 + i6) - i2;
            if (!c.a(V()[iB], i8 + (i2 - i6), bArr, i3, iMin)) {
                return false;
            }
            i3 += iMin;
            i2 += iMin;
            iB++;
        }
        return true;
    }

    @Override // j.i
    public i R() {
        return X().R();
    }

    @Override // j.i
    public void T(f fVar, int i2, int i3) {
        kotlin.jvm.internal.m.f(fVar, "buffer");
        int i4 = i2 + i3;
        int iB = j.g0.c.b(this, i2);
        while (i2 < i4) {
            int i5 = iB == 0 ? 0 : U()[iB - 1];
            int i6 = U()[iB] - i5;
            int i7 = U()[V().length + iB];
            int iMin = Math.min(i4, i6 + i5) - i2;
            int i8 = i7 + (i2 - i5);
            y yVar = new y(V()[iB], i8, i8 + iMin, true, false);
            y yVar2 = fVar.f22831f;
            if (yVar2 == null) {
                yVar.f22884h = yVar;
                yVar.f22883g = yVar;
                fVar.f22831f = yVar;
            } else {
                kotlin.jvm.internal.m.c(yVar2);
                y yVar3 = yVar2.f22884h;
                kotlin.jvm.internal.m.c(yVar3);
                yVar3.c(yVar);
            }
            i2 += iMin;
            iB++;
        }
        fVar.f0(fVar.size() + ((long) i3));
    }

    public final int[] U() {
        return this.l;
    }

    public final byte[][] V() {
        return this.f22826k;
    }

    public byte[] W() {
        byte[] bArr = new byte[P()];
        int length = V().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = U()[length + i2];
            int i6 = U()[i2];
            int i7 = i6 - i3;
            kotlin.collections.m.d(V()[i2], bArr, i4, i5, i5 + i7);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }

    @Override // j.i
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (iVar.P() == P() && J(0, iVar, 0, P())) {
                return true;
            }
        }
        return false;
    }

    @Override // j.i
    public String g() {
        return X().g();
    }

    @Override // j.i
    public int hashCode() {
        int iA = A();
        if (iA != 0) {
            return iA;
        }
        int length = V().length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int i5 = U()[length + i2];
            int i6 = U()[i2];
            byte[] bArr = V()[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        L(i3);
        return i3;
    }

    @Override // j.i
    public String toString() {
        return X().toString();
    }

    @Override // j.i
    public i u(String str) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.m.f(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        int length = V().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = U()[length + i2];
            int i5 = U()[i2];
            messageDigest.update(V()[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
        byte[] bArrDigest = messageDigest.digest();
        kotlin.jvm.internal.m.e(bArrDigest, "digestBytes");
        return new i(bArrDigest);
    }
}
