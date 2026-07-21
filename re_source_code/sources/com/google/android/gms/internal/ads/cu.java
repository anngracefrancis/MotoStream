package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class cu extends yt<Boolean> implements zzdoj<Boolean>, fw, RandomAccess {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final cu f12435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean[] f12436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12437i;

    static {
        cu cuVar = new cu(new boolean[0], 0);
        f12435g = cuVar;
        cuVar.x0();
    }

    cu() {
        this(new boolean[10], 0);
    }

    private final void g(int i2) {
        if (i2 < 0 || i2 >= this.f12437i) {
            throw new IndexOutOfBoundsException(h(i2));
        }
    }

    private final String h(int i2) {
        int i3 = this.f12437i;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    private final void i(int i2, boolean z) {
        int i3;
        c();
        if (i2 < 0 || i2 > (i3 = this.f12437i)) {
            throw new IndexOutOfBoundsException(h(i2));
        }
        boolean[] zArr = this.f12436h;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[((i3 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.f12436h, i2, zArr2, i2 + 1, this.f12437i - i2);
            this.f12436h = zArr2;
        }
        this.f12436h[i2] = z;
        this.f12437i++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdoj
    public final /* synthetic */ zzdoj<Boolean> N(int i2) {
        if (i2 >= this.f12437i) {
            return new cu(Arrays.copyOf(this.f12436h, i2), this.f12437i);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        i(i2, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        c();
        zzdod.a(collection);
        if (!(collection instanceof cu)) {
            return super.addAll(collection);
        }
        cu cuVar = (cu) collection;
        int i2 = cuVar.f12437i;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f12437i;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        boolean[] zArr = this.f12436h;
        if (i4 > zArr.length) {
            this.f12436h = Arrays.copyOf(zArr, i4);
        }
        System.arraycopy(cuVar.f12436h, 0, this.f12436h, this.f12437i, cuVar.f12437i);
        this.f12437i = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cu)) {
            return super.equals(obj);
        }
        cu cuVar = (cu) obj;
        if (this.f12437i != cuVar.f12437i) {
            return false;
        }
        boolean[] zArr = cuVar.f12436h;
        for (int i2 = 0; i2 < this.f12437i; i2++) {
            if (this.f12436h[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(boolean z) {
        i(this.f12437i, z);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        g(i2);
        return Boolean.valueOf(this.f12436h[i2]);
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iH = 1;
        for (int i2 = 0; i2 < this.f12437i; i2++) {
            iH = (iH * 31) + zzdod.h(this.f12436h[i2]);
        }
        return iH;
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f12437i; i2++) {
            if (obj.equals(Boolean.valueOf(this.f12436h[i2]))) {
                boolean[] zArr = this.f12436h;
                System.arraycopy(zArr, i2 + 1, zArr, i2, (this.f12437i - i2) - 1);
                this.f12437i--;
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
        boolean[] zArr = this.f12436h;
        System.arraycopy(zArr, i3, zArr, i2, this.f12437i - i3);
        this.f12437i -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        c();
        g(i2);
        boolean[] zArr = this.f12436h;
        boolean z = zArr[i2];
        zArr[i2] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12437i;
    }

    private cu(boolean[] zArr, int i2) {
        this.f12436h = zArr;
        this.f12437i = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        c();
        g(i2);
        boolean[] zArr = this.f12436h;
        boolean z = zArr[i2];
        int i3 = this.f12437i;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.f12437i--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }
}
