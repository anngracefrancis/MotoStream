package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: IntArrayList.java */
/* JADX INFO: loaded from: classes.dex */
final class z extends c<Integer> implements a0.g, RandomAccess, z0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final z f1463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f1464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1465i;

    static {
        z zVar = new z(new int[0], 0);
        f1463g = zVar;
        zVar.B();
    }

    z() {
        this(new int[10], 0);
    }

    private void i(int i2, int i3) {
        int i4;
        c();
        if (i2 < 0 || i2 > (i4 = this.f1465i)) {
            throw new IndexOutOfBoundsException(r(i2));
        }
        int[] iArr = this.f1464h;
        if (i4 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i4 - i2);
        } else {
            int[] iArr2 = new int[((i4 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f1464h, i2, iArr2, i2 + 1, this.f1465i - i2);
            this.f1464h = iArr2;
        }
        this.f1464h[i2] = i3;
        this.f1465i++;
        ((AbstractList) this).modCount++;
    }

    private void n(int i2) {
        if (i2 < 0 || i2 >= this.f1465i) {
            throw new IndexOutOfBoundsException(r(i2));
        }
    }

    private String r(int i2) {
        return "Index:" + i2 + ", Size:" + this.f1465i;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        c();
        a0.a(collection);
        if (!(collection instanceof z)) {
            return super.addAll(collection);
        }
        z zVar = (z) collection;
        int i2 = zVar.f1465i;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f1465i;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        int[] iArr = this.f1464h;
        if (i4 > iArr.length) {
            this.f1464h = Arrays.copyOf(iArr, i4);
        }
        System.arraycopy(zVar.f1464h, 0, this.f1464h, this.f1465i, zVar.f1465i);
        this.f1465i = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return super.equals(obj);
        }
        z zVar = (z) obj;
        if (this.f1465i != zVar.f1465i) {
            return false;
        }
        int[] iArr = zVar.f1464h;
        for (int i2 = 0; i2 < this.f1465i; i2++) {
            if (this.f1464h[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void add(int i2, Integer num) {
        i(i2, num.intValue());
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        h(num.intValue());
        return true;
    }

    public void h(int i2) {
        c();
        int i3 = this.f1465i;
        int[] iArr = this.f1464h;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[((i3 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f1464h = iArr2;
        }
        int[] iArr3 = this.f1464h;
        int i4 = this.f1465i;
        this.f1465i = i4 + 1;
        iArr3[i4] = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f1465i; i3++) {
            i2 = (i2 * 31) + this.f1464h[i3];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Integer get(int i2) {
        return Integer.valueOf(q(i2));
    }

    public int q(int i2) {
        n(i2);
        return this.f1464h[i2];
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i2, int i3) {
        c();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f1464h;
        System.arraycopy(iArr, i3, iArr, i2, this.f1465i - i3);
        this.f1465i -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.a0.i
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public a0.g J(int i2) {
        if (i2 >= this.f1465i) {
            return new z(Arrays.copyOf(this.f1464h, i2), this.f1465i);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1465i;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Integer remove(int i2) {
        c();
        n(i2);
        int[] iArr = this.f1464h;
        int i3 = iArr[i2];
        int i4 = this.f1465i;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i4 - i2) - 1);
        }
        this.f1465i--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Integer set(int i2, Integer num) {
        return Integer.valueOf(v(i2, num.intValue()));
    }

    public int v(int i2, int i3) {
        c();
        n(i2);
        int[] iArr = this.f1464h;
        int i4 = iArr[i2];
        iArr[i2] = i3;
        return i4;
    }

    private z(int[] iArr, int i2) {
        this.f1464h = iArr;
        this.f1465i = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f1465i; i2++) {
            if (obj.equals(Integer.valueOf(this.f1464h[i2]))) {
                int[] iArr = this.f1464h;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.f1465i - i2) - 1);
                this.f1465i--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
