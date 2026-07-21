package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class ov extends yt<Long> implements zzdoj<Long>, fw, RandomAccess {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ov f13117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long[] f13118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f13119i;

    static {
        ov ovVar = new ov(new long[0], 0);
        f13117g = ovVar;
        ovVar.x0();
    }

    ov() {
        this(new long[10], 0);
    }

    private final void g(int i2) {
        if (i2 < 0 || i2 >= this.f13119i) {
            throw new IndexOutOfBoundsException(h(i2));
        }
    }

    private final String h(int i2) {
        int i3 = this.f13119i;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    private final void n(int i2, long j2) {
        int i3;
        c();
        if (i2 < 0 || i2 > (i3 = this.f13119i)) {
            throw new IndexOutOfBoundsException(h(i2));
        }
        long[] jArr = this.f13118h;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[((i3 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f13118h, i2, jArr2, i2 + 1, this.f13119i - i2);
            this.f13118h = jArr2;
        }
        this.f13118h[i2] = j2;
        this.f13119i++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdoj
    public final /* synthetic */ zzdoj<Long> N(int i2) {
        if (i2 >= this.f13119i) {
            return new ov(Arrays.copyOf(this.f13118h, i2), this.f13119i);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        n(i2, ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        c();
        zzdod.a(collection);
        if (!(collection instanceof ov)) {
            return super.addAll(collection);
        }
        ov ovVar = (ov) collection;
        int i2 = ovVar.f13119i;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f13119i;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        long[] jArr = this.f13118h;
        if (i4 > jArr.length) {
            this.f13118h = Arrays.copyOf(jArr, i4);
        }
        System.arraycopy(ovVar.f13118h, 0, this.f13118h, this.f13119i, ovVar.f13119i);
        this.f13119i = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ov)) {
            return super.equals(obj);
        }
        ov ovVar = (ov) obj;
        if (this.f13119i != ovVar.f13119i) {
            return false;
        }
        long[] jArr = ovVar.f13118h;
        for (int i2 = 0; i2 < this.f13119i; i2++) {
            if (this.f13118h[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final long f(int i2) {
        g(i2);
        return this.f13118h[i2];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return Long.valueOf(f(i2));
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f13119i; i3++) {
            i2 = (i2 * 31) + zzdod.i(this.f13118h[i3]);
        }
        return i2;
    }

    public final void i(long j2) {
        n(this.f13119i, j2);
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f13119i; i2++) {
            if (obj.equals(Long.valueOf(this.f13118h[i2]))) {
                long[] jArr = this.f13118h;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.f13119i - i2) - 1);
                this.f13119i--;
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
        long[] jArr = this.f13118h;
        System.arraycopy(jArr, i3, jArr, i2, this.f13119i - i3);
        this.f13119i -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        c();
        g(i2);
        long[] jArr = this.f13118h;
        long j2 = jArr[i2];
        jArr[i2] = jLongValue;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13119i;
    }

    private ov(long[] jArr, int i2) {
        this.f13118h = jArr;
        this.f13119i = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        c();
        g(i2);
        long[] jArr = this.f13118h;
        long j2 = jArr[i2];
        int i3 = this.f13119i;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.f13119i--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }
}
