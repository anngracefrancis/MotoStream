package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class gv extends yt<Integer> implements zzdoh, fw, RandomAccess {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final gv f12658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f12659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12660i;

    static {
        gv gvVar = new gv(new int[0], 0);
        f12658g = gvVar;
        gvVar.x0();
    }

    gv() {
        this(new int[10], 0);
    }

    private final void g(int i2, int i3) {
        int i4;
        c();
        if (i2 < 0 || i2 > (i4 = this.f12660i)) {
            throw new IndexOutOfBoundsException(n(i2));
        }
        int[] iArr = this.f12659h;
        if (i4 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i4 - i2);
        } else {
            int[] iArr2 = new int[((i4 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f12659h, i2, iArr2, i2 + 1, this.f12660i - i2);
            this.f12659h = iArr2;
        }
        this.f12659h[i2] = i3;
        this.f12660i++;
        ((AbstractList) this).modCount++;
    }

    public static gv h() {
        return f12658g;
    }

    private final void i(int i2) {
        if (i2 < 0 || i2 >= this.f12660i) {
            throw new IndexOutOfBoundsException(n(i2));
        }
    }

    private final String n(int i2) {
        int i3 = this.f12660i;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdoj
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final zzdoh N(int i2) {
        if (i2 >= this.f12660i) {
            return new gv(Arrays.copyOf(this.f12659h, i2), this.f12660i);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzdoh
    public final void Z0(int i2) {
        g(this.f12660i, i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        g(i2, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        c();
        zzdod.a(collection);
        if (!(collection instanceof gv)) {
            return super.addAll(collection);
        }
        gv gvVar = (gv) collection;
        int i2 = gvVar.f12660i;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f12660i;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        int[] iArr = this.f12659h;
        if (i4 > iArr.length) {
            this.f12659h = Arrays.copyOf(iArr, i4);
        }
        System.arraycopy(gvVar.f12659h, 0, this.f12659h, this.f12660i, gvVar.f12660i);
        this.f12660i = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gv)) {
            return super.equals(obj);
        }
        gv gvVar = (gv) obj;
        if (this.f12660i != gvVar.f12660i) {
            return false;
        }
        int[] iArr = gvVar.f12659h;
        for (int i2 = 0; i2 < this.f12660i; i2++) {
            if (this.f12659h[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int f(int i2) {
        i(i2);
        return this.f12659h[i2];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return Integer.valueOf(f(i2));
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f12660i; i3++) {
            i2 = (i2 * 31) + this.f12659h[i3];
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f12660i; i2++) {
            if (obj.equals(Integer.valueOf(this.f12659h[i2]))) {
                int[] iArr = this.f12659h;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.f12660i - i2) - 1);
                this.f12660i--;
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
        int[] iArr = this.f12659h;
        System.arraycopy(iArr, i3, iArr, i2, this.f12660i - i3);
        this.f12660i -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        c();
        i(i2);
        int[] iArr = this.f12659h;
        int i3 = iArr[i2];
        iArr[i2] = iIntValue;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12660i;
    }

    private gv(int[] iArr, int i2) {
        this.f12659h = iArr;
        this.f12660i = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        c();
        i(i2);
        int[] iArr = this.f12659h;
        int i3 = iArr[i2];
        int i4 = this.f12660i;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i4 - i2) - 1);
        }
        this.f12660i--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }
}
