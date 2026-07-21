package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: DoubleArrayList.java */
/* JADX INFO: loaded from: classes.dex */
final class m extends c<Double> implements a0.b, RandomAccess, z0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final m f1364g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double[] f1365h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1366i;

    static {
        m mVar = new m(new double[0], 0);
        f1364g = mVar;
        mVar.B();
    }

    m() {
        this(new double[10], 0);
    }

    private void i(int i2, double d2) {
        int i3;
        c();
        if (i2 < 0 || i2 > (i3 = this.f1366i)) {
            throw new IndexOutOfBoundsException(r(i2));
        }
        double[] dArr = this.f1365h;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[((i3 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.f1365h, i2, dArr2, i2 + 1, this.f1366i - i2);
            this.f1365h = dArr2;
        }
        this.f1365h[i2] = d2;
        this.f1366i++;
        ((AbstractList) this).modCount++;
    }

    private void n(int i2) {
        if (i2 < 0 || i2 >= this.f1366i) {
            throw new IndexOutOfBoundsException(r(i2));
        }
    }

    private String r(int i2) {
        return "Index:" + i2 + ", Size:" + this.f1366i;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        c();
        a0.a(collection);
        if (!(collection instanceof m)) {
            return super.addAll(collection);
        }
        m mVar = (m) collection;
        int i2 = mVar.f1366i;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f1366i;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        double[] dArr = this.f1365h;
        if (i4 > dArr.length) {
            this.f1365h = Arrays.copyOf(dArr, i4);
        }
        System.arraycopy(mVar.f1365h, 0, this.f1365h, this.f1366i, mVar.f1366i);
        this.f1366i = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return super.equals(obj);
        }
        m mVar = (m) obj;
        if (this.f1366i != mVar.f1366i) {
            return false;
        }
        double[] dArr = mVar.f1365h;
        for (int i2 = 0; i2 < this.f1366i; i2++) {
            if (Double.doubleToLongBits(this.f1365h[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void add(int i2, Double d2) {
        i(i2, d2.doubleValue());
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean add(Double d2) {
        h(d2.doubleValue());
        return true;
    }

    public void h(double d2) {
        c();
        int i2 = this.f1366i;
        double[] dArr = this.f1365h;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.f1365h = dArr2;
        }
        double[] dArr3 = this.f1365h;
        int i3 = this.f1366i;
        this.f1366i = i3 + 1;
        dArr3[i3] = d2;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i2 = 0; i2 < this.f1366i; i2++) {
            iF = (iF * 31) + a0.f(Double.doubleToLongBits(this.f1365h[i2]));
        }
        return iF;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Double get(int i2) {
        return Double.valueOf(q(i2));
    }

    public double q(int i2) {
        n(i2);
        return this.f1365h[i2];
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i2, int i3) {
        c();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f1365h;
        System.arraycopy(dArr, i3, dArr, i2, this.f1366i - i3);
        this.f1366i -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.a0.i
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public a0.b J(int i2) {
        if (i2 >= this.f1366i) {
            return new m(Arrays.copyOf(this.f1365h, i2), this.f1366i);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1366i;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Double remove(int i2) {
        c();
        n(i2);
        double[] dArr = this.f1365h;
        double d2 = dArr[i2];
        int i3 = this.f1366i;
        if (i2 < i3 - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.f1366i--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Double set(int i2, Double d2) {
        return Double.valueOf(v(i2, d2.doubleValue()));
    }

    public double v(int i2, double d2) {
        c();
        n(i2);
        double[] dArr = this.f1365h;
        double d3 = dArr[i2];
        dArr[i2] = d2;
        return d3;
    }

    private m(double[] dArr, int i2) {
        this.f1365h = dArr;
        this.f1366i = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f1366i; i2++) {
            if (obj.equals(Double.valueOf(this.f1365h[i2]))) {
                double[] dArr = this.f1365h;
                System.arraycopy(dArr, i2 + 1, dArr, i2, (this.f1366i - i2) - 1);
                this.f1366i--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
