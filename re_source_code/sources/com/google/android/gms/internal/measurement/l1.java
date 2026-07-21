package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class l1 extends i1<Boolean> implements zzfl<Boolean>, m3, RandomAccess {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final l1 f17206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean[] f17207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f17208i;

    static {
        l1 l1Var = new l1(new boolean[0], 0);
        f17206g = l1Var;
        l1Var.I();
    }

    l1() {
        this(new boolean[10], 0);
    }

    private final void g(int i2) {
        if (i2 < 0 || i2 >= this.f17208i) {
            throw new IndexOutOfBoundsException(h(i2));
        }
    }

    private final String h(int i2) {
        int i3 = this.f17208i;
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
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f17208i)) {
            throw new IndexOutOfBoundsException(h(i2));
        }
        boolean[] zArr = this.f17207h;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[((i3 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.f17207h, i2, zArr2, i2 + 1, this.f17208i - i2);
            this.f17207h = zArr2;
        }
        this.f17207h[i2] = zBooleanValue;
        this.f17208i++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        c();
        zzff.d(collection);
        if (!(collection instanceof l1)) {
            return super.addAll(collection);
        }
        l1 l1Var = (l1) collection;
        int i2 = l1Var.f17208i;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f17208i;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        boolean[] zArr = this.f17207h;
        if (i4 > zArr.length) {
            this.f17207h = Arrays.copyOf(zArr, i4);
        }
        System.arraycopy(l1Var.f17207h, 0, this.f17207h, this.f17208i, l1Var.f17208i);
        this.f17208i = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzfl
    public final /* synthetic */ zzfl<Boolean> d(int i2) {
        if (i2 >= this.f17208i) {
            return new l1(Arrays.copyOf(this.f17207h, i2), this.f17208i);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l1)) {
            return super.equals(obj);
        }
        l1 l1Var = (l1) obj;
        if (this.f17208i != l1Var.f17208i) {
            return false;
        }
        boolean[] zArr = l1Var.f17207h;
        for (int i2 = 0; i2 < this.f17208i; i2++) {
            if (this.f17207h[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(boolean z) {
        c();
        int i2 = this.f17208i;
        boolean[] zArr = this.f17207h;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.f17207h = zArr2;
        }
        boolean[] zArr3 = this.f17207h;
        int i3 = this.f17208i;
        this.f17208i = i3 + 1;
        zArr3[i3] = z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        g(i2);
        return Boolean.valueOf(this.f17207h[i2]);
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iC = 1;
        for (int i2 = 0; i2 < this.f17208i; i2++) {
            iC = (iC * 31) + zzff.c(this.f17207h[i2]);
        }
        return iC;
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f17208i; i2++) {
            if (obj.equals(Boolean.valueOf(this.f17207h[i2]))) {
                boolean[] zArr = this.f17207h;
                System.arraycopy(zArr, i2 + 1, zArr, i2, (this.f17208i - i2) - 1);
                this.f17208i--;
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
        boolean[] zArr = this.f17207h;
        System.arraycopy(zArr, i3, zArr, i2, this.f17208i - i3);
        this.f17208i -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        c();
        g(i2);
        boolean[] zArr = this.f17207h;
        boolean z = zArr[i2];
        zArr[i2] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f17208i;
    }

    private l1(boolean[] zArr, int i2) {
        this.f17207h = zArr;
        this.f17208i = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        c();
        g(i2);
        boolean[] zArr = this.f17207h;
        boolean z = zArr[i2];
        int i3 = this.f17208i;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.f17208i--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        f(((Boolean) obj).booleanValue());
        return true;
    }
}
