package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: UnknownFieldSetLite.java */
/* JADX INFO: loaded from: classes.dex */
public final class m1 {
    private static final m1 a = new m1(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f1368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f1369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1371f;

    private m1() {
        this(0, new int[8], new Object[8], true);
    }

    private void b() {
        int i2 = this.f1367b;
        int[] iArr = this.f1368c;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.f1368c = Arrays.copyOf(iArr, i3);
            this.f1369d = Arrays.copyOf(this.f1369d, i3);
        }
    }

    private static boolean c(int[] iArr, int[] iArr2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (iArr[i3] != iArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    private static boolean d(Object[] objArr, Object[] objArr2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (!objArr[i3].equals(objArr2[i3])) {
                return false;
            }
        }
        return true;
    }

    public static m1 e() {
        return a;
    }

    private static int h(int[] iArr, int i2) {
        int i3 = 17;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        return i3;
    }

    private static int i(Object[] objArr, int i2) {
        int iHashCode = 17;
        for (int i3 = 0; i3 < i2; i3++) {
            iHashCode = (iHashCode * 31) + objArr[i3].hashCode();
        }
        return iHashCode;
    }

    static m1 k(m1 m1Var, m1 m1Var2) {
        int i2 = m1Var.f1367b + m1Var2.f1367b;
        int[] iArrCopyOf = Arrays.copyOf(m1Var.f1368c, i2);
        System.arraycopy(m1Var2.f1368c, 0, iArrCopyOf, m1Var.f1367b, m1Var2.f1367b);
        Object[] objArrCopyOf = Arrays.copyOf(m1Var.f1369d, i2);
        System.arraycopy(m1Var2.f1369d, 0, objArrCopyOf, m1Var.f1367b, m1Var2.f1367b);
        return new m1(i2, iArrCopyOf, objArrCopyOf, true);
    }

    static m1 l() {
        return new m1();
    }

    private static void p(int i2, Object obj, s1 s1Var) throws IOException {
        int iA = r1.a(i2);
        int iB = r1.b(i2);
        if (iB == 0) {
            s1Var.p(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            s1Var.h(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            s1Var.w(iA, (h) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(InvalidProtocolBufferException.d());
            }
            s1Var.d(iA, ((Integer) obj).intValue());
        } else if (s1Var.i() == s1.a.ASCENDING) {
            s1Var.s(iA);
            ((m1) obj).q(s1Var);
            s1Var.F(iA);
        } else {
            s1Var.F(iA);
            ((m1) obj).q(s1Var);
            s1Var.s(iA);
        }
    }

    void a() {
        if (!this.f1371f) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        int i2 = this.f1367b;
        return i2 == m1Var.f1367b && c(this.f1368c, m1Var.f1368c, i2) && d(this.f1369d, m1Var.f1369d, this.f1367b);
    }

    public int f() {
        int iY;
        int i2 = this.f1370e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f1367b; i4++) {
            int i5 = this.f1368c[i4];
            int iA = r1.a(i5);
            int iB = r1.b(i5);
            if (iB == 0) {
                iY = CodedOutputStream.Y(iA, ((Long) this.f1369d[i4]).longValue());
            } else if (iB == 1) {
                iY = CodedOutputStream.o(iA, ((Long) this.f1369d[i4]).longValue());
            } else if (iB == 2) {
                iY = CodedOutputStream.g(iA, (h) this.f1369d[i4]);
            } else if (iB == 3) {
                iY = (CodedOutputStream.V(iA) * 2) + ((m1) this.f1369d[i4]).f();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(InvalidProtocolBufferException.d());
                }
                iY = CodedOutputStream.m(iA, ((Integer) this.f1369d[i4]).intValue());
            }
            i3 += iY;
        }
        this.f1370e = i3;
        return i3;
    }

    public int g() {
        int i2 = this.f1370e;
        if (i2 != -1) {
            return i2;
        }
        int iJ = 0;
        for (int i3 = 0; i3 < this.f1367b; i3++) {
            iJ += CodedOutputStream.J(r1.a(this.f1368c[i3]), (h) this.f1369d[i3]);
        }
        this.f1370e = iJ;
        return iJ;
    }

    public int hashCode() {
        int i2 = this.f1367b;
        return ((((527 + i2) * 31) + h(this.f1368c, i2)) * 31) + i(this.f1369d, this.f1367b);
    }

    public void j() {
        this.f1371f = false;
    }

    final void m(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f1367b; i3++) {
            s0.c(sb, i2, String.valueOf(r1.a(this.f1368c[i3])), this.f1369d[i3]);
        }
    }

    void n(int i2, Object obj) {
        a();
        b();
        int[] iArr = this.f1368c;
        int i3 = this.f1367b;
        iArr[i3] = i2;
        this.f1369d[i3] = obj;
        this.f1367b = i3 + 1;
    }

    void o(s1 s1Var) throws IOException {
        if (s1Var.i() == s1.a.DESCENDING) {
            for (int i2 = this.f1367b - 1; i2 >= 0; i2--) {
                s1Var.c(r1.a(this.f1368c[i2]), this.f1369d[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < this.f1367b; i3++) {
            s1Var.c(r1.a(this.f1368c[i3]), this.f1369d[i3]);
        }
    }

    public void q(s1 s1Var) throws IOException {
        if (this.f1367b == 0) {
            return;
        }
        if (s1Var.i() == s1.a.ASCENDING) {
            for (int i2 = 0; i2 < this.f1367b; i2++) {
                p(this.f1368c[i2], this.f1369d[i2], s1Var);
            }
            return;
        }
        for (int i3 = this.f1367b - 1; i3 >= 0; i3--) {
            p(this.f1368c[i3], this.f1369d[i3], s1Var);
        }
    }

    private m1(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f1370e = -1;
        this.f1367b = i2;
        this.f1368c = iArr;
        this.f1369d = objArr;
        this.f1371f = z;
    }
}
