package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class tu extends yt<Double> implements zzdoj<Double>, fw, RandomAccess {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final tu f13360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double[] f13361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f13362i;

    static {
        tu tuVar = new tu(new double[0], 0);
        f13360g = tuVar;
        tuVar.x0();
    }

    tu() {
        this(new double[10], 0);
    }

    private final void g(int i2, double d2) {
        int i3;
        c();
        if (i2 < 0 || i2 > (i3 = this.f13362i)) {
            throw new IndexOutOfBoundsException(i(i2));
        }
        double[] dArr = this.f13361h;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[((i3 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.f13361h, i2, dArr2, i2 + 1, this.f13362i - i2);
            this.f13361h = dArr2;
        }
        this.f13361h[i2] = d2;
        this.f13362i++;
        ((AbstractList) this).modCount++;
    }

    private final void h(int i2) {
        if (i2 < 0 || i2 >= this.f13362i) {
            throw new IndexOutOfBoundsException(i(i2));
        }
    }

    private final String i(int i2) {
        int i3 = this.f13362i;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdoj
    public final /* synthetic */ zzdoj<Double> N(int i2) {
        if (i2 >= this.f13362i) {
            return new tu(Arrays.copyOf(this.f13361h, i2), this.f13362i);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        g(i2, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        c();
        zzdod.a(collection);
        if (!(collection instanceof tu)) {
            return super.addAll(collection);
        }
        tu tuVar = (tu) collection;
        int i2 = tuVar.f13362i;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f13362i;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        double[] dArr = this.f13361h;
        if (i4 > dArr.length) {
            this.f13361h = Arrays.copyOf(dArr, i4);
        }
        System.arraycopy(tuVar.f13361h, 0, this.f13361h, this.f13362i, tuVar.f13362i);
        this.f13362i = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof tu)) {
            return super.equals(obj);
        }
        tu tuVar = (tu) obj;
        if (this.f13362i != tuVar.f13362i) {
            return false;
        }
        double[] dArr = tuVar.f13361h;
        for (int i2 = 0; i2 < this.f13362i; i2++) {
            if (Double.doubleToLongBits(this.f13361h[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final void f(double d2) {
        g(this.f13362i, d2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        h(i2);
        return Double.valueOf(this.f13361h[i2]);
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f13362i; i3++) {
            i2 = (i2 * 31) + zzdod.i(Double.doubleToLongBits(this.f13361h[i3]));
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f13362i; i2++) {
            if (obj.equals(Double.valueOf(this.f13361h[i2]))) {
                double[] dArr = this.f13361h;
                System.arraycopy(dArr, i2 + 1, dArr, i2, (this.f13362i - i2) - 1);
                this.f13362i--;
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
        double[] dArr = this.f13361h;
        System.arraycopy(dArr, i3, dArr, i2, this.f13362i - i3);
        this.f13362i -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        c();
        h(i2);
        double[] dArr = this.f13361h;
        double d2 = dArr[i2];
        dArr[i2] = dDoubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13362i;
    }

    private tu(double[] dArr, int i2) {
        this.f13361h = dArr;
        this.f13362i = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        c();
        h(i2);
        double[] dArr = this.f13361h;
        double d2 = dArr[i2];
        int i3 = this.f13362i;
        if (i2 < i3 - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.f13362i--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }
}
