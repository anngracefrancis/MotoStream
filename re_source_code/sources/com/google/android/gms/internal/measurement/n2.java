package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class n2 extends i1<Integer> implements zzfj, m3, RandomAccess {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final n2 f17224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f17225h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f17226i;

    static {
        n2 n2Var = new n2(new int[0], 0);
        f17224g = n2Var;
        n2Var.I();
    }

    n2() {
        this(new int[10], 0);
    }

    public static n2 g() {
        return f17224g;
    }

    private final void i(int i2) {
        if (i2 < 0 || i2 >= this.f17226i) {
            throw new IndexOutOfBoundsException(n(i2));
        }
    }

    private final String n(int i2) {
        int i3 = this.f17226i;
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
        int iIntValue = ((Integer) obj).intValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f17226i)) {
            throw new IndexOutOfBoundsException(n(i2));
        }
        int[] iArr = this.f17225h;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
        } else {
            int[] iArr2 = new int[((i3 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f17225h, i2, iArr2, i2 + 1, this.f17226i - i2);
            this.f17225h = iArr2;
        }
        this.f17225h[i2] = iIntValue;
        this.f17226i++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        c();
        zzff.d(collection);
        if (!(collection instanceof n2)) {
            return super.addAll(collection);
        }
        n2 n2Var = (n2) collection;
        int i2 = n2Var.f17226i;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f17226i;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        int[] iArr = this.f17225h;
        if (i4 > iArr.length) {
            this.f17225h = Arrays.copyOf(iArr, i4);
        }
        System.arraycopy(n2Var.f17225h, 0, this.f17225h, this.f17226i, n2Var.f17226i);
        this.f17226i = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzfl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final zzfj d(int i2) {
        if (i2 >= this.f17226i) {
            return new n2(Arrays.copyOf(this.f17225h, i2), this.f17226i);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n2)) {
            return super.equals(obj);
        }
        n2 n2Var = (n2) obj;
        if (this.f17226i != n2Var.f17226i) {
            return false;
        }
        int[] iArr = n2Var.f17225h;
        for (int i2 = 0; i2 < this.f17226i; i2++) {
            if (this.f17225h[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int f(int i2) {
        i(i2);
        return this.f17225h[i2];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return Integer.valueOf(f(i2));
    }

    public final void h(int i2) {
        c();
        int i3 = this.f17226i;
        int[] iArr = this.f17225h;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[((i3 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f17225h = iArr2;
        }
        int[] iArr3 = this.f17225h;
        int i4 = this.f17226i;
        this.f17226i = i4 + 1;
        iArr3[i4] = i2;
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f17226i; i3++) {
            i2 = (i2 * 31) + this.f17225h[i3];
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f17226i; i2++) {
            if (obj.equals(Integer.valueOf(this.f17225h[i2]))) {
                int[] iArr = this.f17225h;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.f17226i - i2) - 1);
                this.f17226i--;
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
        int[] iArr = this.f17225h;
        System.arraycopy(iArr, i3, iArr, i2, this.f17226i - i3);
        this.f17226i -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        c();
        i(i2);
        int[] iArr = this.f17225h;
        int i3 = iArr[i2];
        iArr[i2] = iIntValue;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f17226i;
    }

    private n2(int[] iArr, int i2) {
        this.f17225h = iArr;
        this.f17226i = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        c();
        i(i2);
        int[] iArr = this.f17225h;
        int i3 = iArr[i2];
        int i4 = this.f17226i;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i4 - i2) - 1);
        }
        this.f17226i--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        h(((Integer) obj).intValue());
        return true;
    }
}
