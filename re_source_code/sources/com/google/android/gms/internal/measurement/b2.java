package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class b2 extends i1<Double> implements zzfl<Double>, m3, RandomAccess {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final b2 f17130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double[] f17131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f17132i;

    static {
        b2 b2Var = new b2(new double[0], 0);
        f17130g = b2Var;
        b2Var.I();
    }

    b2() {
        this(new double[10], 0);
    }

    private final void g(int i2) {
        if (i2 < 0 || i2 >= this.f17132i) {
            throw new IndexOutOfBoundsException(h(i2));
        }
    }

    private final String h(int i2) {
        int i3 = this.f17132i;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        double dDoubleValue = ((Double) obj).doubleValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f17132i)) {
            throw new IndexOutOfBoundsException(h(i2));
        }
        double[] dArr = this.f17131h;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[((i3 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.f17131h, i2, dArr2, i2 + 1, this.f17132i - i2);
            this.f17131h = dArr2;
        }
        this.f17131h[i2] = dDoubleValue;
        this.f17132i++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        c();
        zzff.d(collection);
        if (!(collection instanceof b2)) {
            return super.addAll(collection);
        }
        b2 b2Var = (b2) collection;
        int i2 = b2Var.f17132i;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f17132i;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        double[] dArr = this.f17131h;
        if (i4 > dArr.length) {
            this.f17131h = Arrays.copyOf(dArr, i4);
        }
        System.arraycopy(b2Var.f17131h, 0, this.f17131h, this.f17132i, b2Var.f17132i);
        this.f17132i = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzfl
    public final /* synthetic */ zzfl<Double> d(int i2) {
        if (i2 >= this.f17132i) {
            return new b2(Arrays.copyOf(this.f17131h, i2), this.f17132i);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b2)) {
            return super.equals(obj);
        }
        b2 b2Var = (b2) obj;
        if (this.f17132i != b2Var.f17132i) {
            return false;
        }
        double[] dArr = b2Var.f17131h;
        for (int i2 = 0; i2 < this.f17132i; i2++) {
            if (Double.doubleToLongBits(this.f17131h[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final void f(double d2) {
        c();
        int i2 = this.f17132i;
        double[] dArr = this.f17131h;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.f17131h = dArr2;
        }
        double[] dArr3 = this.f17131h;
        int i3 = this.f17132i;
        this.f17132i = i3 + 1;
        dArr3[i3] = d2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        g(i2);
        return Double.valueOf(this.f17131h[i2]);
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iB = 1;
        for (int i2 = 0; i2 < this.f17132i; i2++) {
            iB = (iB * 31) + zzff.b(Double.doubleToLongBits(this.f17131h[i2]));
        }
        return iB;
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f17132i; i2++) {
            if (obj.equals(Double.valueOf(this.f17131h[i2]))) {
                double[] dArr = this.f17131h;
                System.arraycopy(dArr, i2 + 1, dArr, i2, (this.f17132i - i2) - 1);
                this.f17132i--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i2, int i3) {
        c();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f17131h;
        System.arraycopy(dArr, i3, dArr, i2, this.f17132i - i3);
        this.f17132i -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        c();
        g(i2);
        double[] dArr = this.f17131h;
        double d2 = dArr[i2];
        dArr[i2] = dDoubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f17132i;
    }

    private b2(double[] dArr, int i2) {
        this.f17131h = dArr;
        this.f17132i = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        c();
        g(i2);
        double[] dArr = this.f17131h;
        double d2 = dArr[i2];
        int i3 = this.f17132i;
        if (i2 < i3 - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.f17132i--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        f(((Double) obj).doubleValue());
        return true;
    }
}
