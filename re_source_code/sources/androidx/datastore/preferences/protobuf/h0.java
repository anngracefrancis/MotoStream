package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: LongArrayList.java */
/* JADX INFO: loaded from: classes.dex */
final class h0 extends c<Long> implements a0.h, RandomAccess, z0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final h0 f1308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long[] f1309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1310i;

    static {
        h0 h0Var = new h0(new long[0], 0);
        f1308g = h0Var;
        h0Var.B();
    }

    h0() {
        this(new long[10], 0);
    }

    private void h(int i2, long j2) {
        int i3;
        c();
        if (i2 < 0 || i2 > (i3 = this.f1310i)) {
            throw new IndexOutOfBoundsException(r(i2));
        }
        long[] jArr = this.f1309h;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[((i3 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f1309h, i2, jArr2, i2 + 1, this.f1310i - i2);
            this.f1309h = jArr2;
        }
        this.f1309h[i2] = j2;
        this.f1310i++;
        ((AbstractList) this).modCount++;
    }

    private void n(int i2) {
        if (i2 < 0 || i2 >= this.f1310i) {
            throw new IndexOutOfBoundsException(r(i2));
        }
    }

    private String r(int i2) {
        return "Index:" + i2 + ", Size:" + this.f1310i;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        c();
        a0.a(collection);
        if (!(collection instanceof h0)) {
            return super.addAll(collection);
        }
        h0 h0Var = (h0) collection;
        int i2 = h0Var.f1310i;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f1310i;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        long[] jArr = this.f1309h;
        if (i4 > jArr.length) {
            this.f1309h = Arrays.copyOf(jArr, i4);
        }
        System.arraycopy(h0Var.f1309h, 0, this.f1309h, this.f1310i, h0Var.f1310i);
        this.f1310i = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return super.equals(obj);
        }
        h0 h0Var = (h0) obj;
        if (this.f1310i != h0Var.f1310i) {
            return false;
        }
        long[] jArr = h0Var.f1309h;
        for (int i2 = 0; i2 < this.f1310i; i2++) {
            if (this.f1309h[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void add(int i2, Long l) {
        h(i2, l.longValue());
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean add(Long l) {
        i(l.longValue());
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i2 = 0; i2 < this.f1310i; i2++) {
            iF = (iF * 31) + a0.f(this.f1309h[i2]);
        }
        return iF;
    }

    public void i(long j2) {
        c();
        int i2 = this.f1310i;
        long[] jArr = this.f1309h;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.f1309h = jArr2;
        }
        long[] jArr3 = this.f1309h;
        int i3 = this.f1310i;
        this.f1310i = i3 + 1;
        jArr3[i3] = j2;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Long get(int i2) {
        return Long.valueOf(q(i2));
    }

    public long q(int i2) {
        n(i2);
        return this.f1309h[i2];
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i2, int i3) {
        c();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f1309h;
        System.arraycopy(jArr, i3, jArr, i2, this.f1310i - i3);
        this.f1310i -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.a0.i
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public a0.h J(int i2) {
        if (i2 >= this.f1310i) {
            return new h0(Arrays.copyOf(this.f1309h, i2), this.f1310i);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1310i;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Long remove(int i2) {
        c();
        n(i2);
        long[] jArr = this.f1309h;
        long j2 = jArr[i2];
        int i3 = this.f1310i;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.f1310i--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Long set(int i2, Long l) {
        return Long.valueOf(v(i2, l.longValue()));
    }

    public long v(int i2, long j2) {
        c();
        n(i2);
        long[] jArr = this.f1309h;
        long j3 = jArr[i2];
        jArr[i2] = j2;
        return j3;
    }

    private h0(long[] jArr, int i2) {
        this.f1309h = jArr;
        this.f1310i = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f1310i; i2++) {
            if (obj.equals(Long.valueOf(this.f1309h[i2]))) {
                long[] jArr = this.f1309h;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.f1310i - i2) - 1);
                this.f1310i--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
