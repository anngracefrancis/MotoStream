package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class w2 extends i1<Long> implements zzfm, m3, RandomAccess {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final w2 f17275g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long[] f17276h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f17277i;

    static {
        w2 w2Var = new w2(new long[0], 0);
        f17275g = w2Var;
        w2Var.I();
    }

    w2() {
        this(new long[10], 0);
    }

    public static w2 f() {
        return f17275g;
    }

    private final void g(int i2) {
        if (i2 < 0 || i2 >= this.f17277i) {
            throw new IndexOutOfBoundsException(h(i2));
        }
    }

    private final String h(int i2) {
        int i3 = this.f17277i;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzfm
    public final void G0(long j2) {
        c();
        int i2 = this.f17277i;
        long[] jArr = this.f17276h;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.f17276h = jArr2;
        }
        long[] jArr3 = this.f17276h;
        int i3 = this.f17277i;
        this.f17277i = i3 + 1;
        jArr3[i3] = j2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        long jLongValue = ((Long) obj).longValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f17277i)) {
            throw new IndexOutOfBoundsException(h(i2));
        }
        long[] jArr = this.f17276h;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[((i3 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f17276h, i2, jArr2, i2 + 1, this.f17277i - i2);
            this.f17276h = jArr2;
        }
        this.f17276h[i2] = jLongValue;
        this.f17277i++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        c();
        zzff.d(collection);
        if (!(collection instanceof w2)) {
            return super.addAll(collection);
        }
        w2 w2Var = (w2) collection;
        int i2 = w2Var.f17277i;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f17277i;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        long[] jArr = this.f17276h;
        if (i4 > jArr.length) {
            this.f17276h = Arrays.copyOf(jArr, i4);
        }
        System.arraycopy(w2Var.f17276h, 0, this.f17276h, this.f17277i, w2Var.f17277i);
        this.f17277i = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzfm
    public final long e(int i2) {
        g(i2);
        return this.f17276h[i2];
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w2)) {
            return super.equals(obj);
        }
        w2 w2Var = (w2) obj;
        if (this.f17277i != w2Var.f17277i) {
            return false;
        }
        long[] jArr = w2Var.f17276h;
        for (int i2 = 0; i2 < this.f17277i; i2++) {
            if (this.f17276h[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return Long.valueOf(e(i2));
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iB = 1;
        for (int i2 = 0; i2 < this.f17277i; i2++) {
            iB = (iB * 31) + zzff.b(this.f17276h[i2]);
        }
        return iB;
    }

    @Override // com.google.android.gms.internal.measurement.zzfl
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public final zzfm d(int i2) {
        if (i2 >= this.f17277i) {
            return new w2(Arrays.copyOf(this.f17276h, i2), this.f17277i);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f17277i; i2++) {
            if (obj.equals(Long.valueOf(this.f17276h[i2]))) {
                long[] jArr = this.f17276h;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.f17277i - i2) - 1);
                this.f17277i--;
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
        long[] jArr = this.f17276h;
        System.arraycopy(jArr, i3, jArr, i2, this.f17277i - i3);
        this.f17277i -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        c();
        g(i2);
        long[] jArr = this.f17276h;
        long j2 = jArr[i2];
        jArr[i2] = jLongValue;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f17277i;
    }

    private w2(long[] jArr, int i2) {
        this.f17276h = jArr;
        this.f17277i = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        c();
        g(i2);
        long[] jArr = this.f17276h;
        long j2 = jArr[i2];
        int i3 = this.f17277i;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.f17277i--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        G0(((Long) obj).longValue());
        return true;
    }
}
