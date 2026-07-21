package c.e;

/* JADX INFO: compiled from: SparseArrayCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class h<E> implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f2950f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f2952h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Object[] f2953i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2954j;

    public h() {
        this(10);
    }

    private void f() {
        int i2 = this.f2954j;
        int[] iArr = this.f2952h;
        Object[] objArr = this.f2953i;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f2950f) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f2951g = false;
        this.f2954j = i3;
    }

    public void b(int i2, E e2) {
        int i3 = this.f2954j;
        if (i3 != 0 && i2 <= this.f2952h[i3 - 1]) {
            k(i2, e2);
            return;
        }
        if (this.f2951g && i3 >= this.f2952h.length) {
            f();
        }
        int i4 = this.f2954j;
        if (i4 >= this.f2952h.length) {
            int iE = c.e(i4 + 1);
            int[] iArr = new int[iE];
            Object[] objArr = new Object[iE];
            int[] iArr2 = this.f2952h;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f2953i;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f2952h = iArr;
            this.f2953i = objArr;
        }
        this.f2952h[i4] = i2;
        this.f2953i[i4] = e2;
        this.f2954j = i4 + 1;
    }

    public void d() {
        int i2 = this.f2954j;
        Object[] objArr = this.f2953i;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f2954j = 0;
        this.f2951g = false;
    }

    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f2952h = (int[]) this.f2952h.clone();
            hVar.f2953i = (Object[]) this.f2953i.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E g(int i2) {
        return h(i2, null);
    }

    public E h(int i2, E e2) {
        int iA = c.a(this.f2952h, this.f2954j, i2);
        if (iA >= 0) {
            Object[] objArr = this.f2953i;
            if (objArr[iA] != f2950f) {
                return (E) objArr[iA];
            }
        }
        return e2;
    }

    public int i(E e2) {
        if (this.f2951g) {
            f();
        }
        for (int i2 = 0; i2 < this.f2954j; i2++) {
            if (this.f2953i[i2] == e2) {
                return i2;
            }
        }
        return -1;
    }

    public int j(int i2) {
        if (this.f2951g) {
            f();
        }
        return this.f2952h[i2];
    }

    public void k(int i2, E e2) {
        int iA = c.a(this.f2952h, this.f2954j, i2);
        if (iA >= 0) {
            this.f2953i[iA] = e2;
            return;
        }
        int iA2 = iA ^ (-1);
        int i3 = this.f2954j;
        if (iA2 < i3) {
            Object[] objArr = this.f2953i;
            if (objArr[iA2] == f2950f) {
                this.f2952h[iA2] = i2;
                objArr[iA2] = e2;
                return;
            }
        }
        if (this.f2951g && i3 >= this.f2952h.length) {
            f();
            iA2 = c.a(this.f2952h, this.f2954j, i2) ^ (-1);
        }
        int i4 = this.f2954j;
        if (i4 >= this.f2952h.length) {
            int iE = c.e(i4 + 1);
            int[] iArr = new int[iE];
            Object[] objArr2 = new Object[iE];
            int[] iArr2 = this.f2952h;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f2953i;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f2952h = iArr;
            this.f2953i = objArr2;
        }
        int i5 = this.f2954j;
        if (i5 - iA2 != 0) {
            int[] iArr3 = this.f2952h;
            int i6 = iA2 + 1;
            System.arraycopy(iArr3, iA2, iArr3, i6, i5 - iA2);
            Object[] objArr4 = this.f2953i;
            System.arraycopy(objArr4, iA2, objArr4, i6, this.f2954j - iA2);
        }
        this.f2952h[iA2] = i2;
        this.f2953i[iA2] = e2;
        this.f2954j++;
    }

    public int l() {
        if (this.f2951g) {
            f();
        }
        return this.f2954j;
    }

    public E m(int i2) {
        if (this.f2951g) {
            f();
        }
        return (E) this.f2953i[i2];
    }

    public String toString() {
        if (l() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2954j * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2954j; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(j(i2));
            sb.append('=');
            E eM = m(i2);
            if (eM != this) {
                sb.append(eM);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public h(int i2) {
        this.f2951g = false;
        if (i2 == 0) {
            this.f2952h = c.a;
            this.f2953i = c.f2917c;
        } else {
            int iE = c.e(i2);
            this.f2952h = new int[iE];
            this.f2953i = new Object[iE];
        }
    }
}
