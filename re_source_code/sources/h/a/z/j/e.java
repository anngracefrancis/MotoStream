package h.a.z.j;

/* JADX INFO: compiled from: OpenHashSet.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<T> {
    final float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f21739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f21740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f21741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    T[] f21742e;

    public e() {
        this(16, 0.75f);
    }

    static int c(int i2) {
        int i3 = i2 * (-1640531527);
        return i3 ^ (i3 >>> 16);
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.f21742e;
        int i2 = this.f21739b;
        int iC = c(t.hashCode()) & i2;
        T t3 = tArr[iC];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                iC = (iC + 1) & i2;
                t2 = tArr[iC];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[iC] = t;
        int i3 = this.f21740c + 1;
        this.f21740c = i3;
        if (i3 >= this.f21741d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f21742e;
    }

    void d() {
        T[] tArr = this.f21742e;
        int length = tArr.length;
        int i2 = length << 1;
        int i3 = i2 - 1;
        T[] tArr2 = (T[]) new Object[i2];
        int i4 = this.f21740c;
        while (true) {
            int i5 = i4 - 1;
            if (i4 == 0) {
                this.f21739b = i3;
                this.f21741d = (int) (i2 * this.a);
                this.f21742e = tArr2;
                return;
            }
            do {
                length--;
            } while (tArr[length] == null);
            int iC = c(tArr[length].hashCode()) & i3;
            if (tArr2[iC] != null) {
                do {
                    iC = (iC + 1) & i3;
                } while (tArr2[iC] != null);
            }
            tArr2[iC] = tArr[length];
            i4 = i5;
        }
    }

    public boolean e(T t) {
        T t2;
        T[] tArr = this.f21742e;
        int i2 = this.f21739b;
        int iC = c(t.hashCode()) & i2;
        T t3 = tArr[iC];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return f(iC, tArr, i2);
        }
        do {
            iC = (iC + 1) & i2;
            t2 = tArr[iC];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return f(iC, tArr, i2);
    }

    boolean f(int i2, T[] tArr, int i3) {
        int i4;
        T t;
        this.f21740c--;
        while (true) {
            int i5 = i2 + 1;
            while (true) {
                i4 = i5 & i3;
                t = tArr[i4];
                if (t != null) {
                    int iC = c(t.hashCode()) & i3;
                    if (i2 > i4) {
                        if (i2 >= iC && iC > i4) {
                            break;
                        }
                        i5 = i4 + 1;
                    } else {
                        if (i2 >= iC || iC > i4) {
                            break;
                        }
                        i5 = i4 + 1;
                    }
                } else {
                    tArr[i2] = null;
                    return true;
                }
            }
            tArr[i2] = t;
            i2 = i4;
        }
    }

    public e(int i2, float f2) {
        this.a = f2;
        int iA = f.a(i2);
        this.f21739b = iA - 1;
        this.f21741d = (int) (f2 * iA);
        this.f21742e = (T[]) new Object[iA];
    }
}
