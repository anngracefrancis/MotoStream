package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: BooleanArrayList.java */
/* JADX INFO: loaded from: classes.dex */
final class f extends c<Boolean> implements a0.a, RandomAccess, z0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final f f1293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean[] f1294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1295i;

    static {
        f fVar = new f(new boolean[0], 0);
        f1293g = fVar;
        fVar.B();
    }

    f() {
        this(new boolean[10], 0);
    }

    private void h(int i2, boolean z) {
        int i3;
        c();
        if (i2 < 0 || i2 > (i3 = this.f1295i)) {
            throw new IndexOutOfBoundsException(r(i2));
        }
        boolean[] zArr = this.f1294h;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[((i3 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.f1294h, i2, zArr2, i2 + 1, this.f1295i - i2);
            this.f1294h = zArr2;
        }
        this.f1294h[i2] = z;
        this.f1295i++;
        ((AbstractList) this).modCount++;
    }

    private void n(int i2) {
        if (i2 < 0 || i2 >= this.f1295i) {
            throw new IndexOutOfBoundsException(r(i2));
        }
    }

    private String r(int i2) {
        return "Index:" + i2 + ", Size:" + this.f1295i;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        c();
        a0.a(collection);
        if (!(collection instanceof f)) {
            return super.addAll(collection);
        }
        f fVar = (f) collection;
        int i2 = fVar.f1295i;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f1295i;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        boolean[] zArr = this.f1294h;
        if (i4 > zArr.length) {
            this.f1294h = Arrays.copyOf(zArr, i4);
        }
        System.arraycopy(fVar.f1294h, 0, this.f1294h, this.f1295i, fVar.f1295i);
        this.f1295i = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return super.equals(obj);
        }
        f fVar = (f) obj;
        if (this.f1295i != fVar.f1295i) {
            return false;
        }
        boolean[] zArr = fVar.f1294h;
        for (int i2 = 0; i2 < this.f1295i; i2++) {
            if (this.f1294h[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void add(int i2, Boolean bool) {
        h(i2, bool.booleanValue());
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean add(Boolean bool) {
        i(bool.booleanValue());
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iC = 1;
        for (int i2 = 0; i2 < this.f1295i; i2++) {
            iC = (iC * 31) + a0.c(this.f1294h[i2]);
        }
        return iC;
    }

    public void i(boolean z) {
        c();
        int i2 = this.f1295i;
        boolean[] zArr = this.f1294h;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.f1294h = zArr2;
        }
        boolean[] zArr3 = this.f1294h;
        int i3 = this.f1295i;
        this.f1295i = i3 + 1;
        zArr3[i3] = z;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Boolean get(int i2) {
        return Boolean.valueOf(q(i2));
    }

    public boolean q(int i2) {
        n(i2);
        return this.f1294h[i2];
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i2, int i3) {
        c();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f1294h;
        System.arraycopy(zArr, i3, zArr, i2, this.f1295i - i3);
        this.f1295i -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.a0.i
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public a0.a J(int i2) {
        if (i2 >= this.f1295i) {
            return new f(Arrays.copyOf(this.f1294h, i2), this.f1295i);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1295i;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Boolean remove(int i2) {
        c();
        n(i2);
        boolean[] zArr = this.f1294h;
        boolean z = zArr[i2];
        int i3 = this.f1295i;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.f1295i--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Boolean set(int i2, Boolean bool) {
        return Boolean.valueOf(v(i2, bool.booleanValue()));
    }

    public boolean v(int i2, boolean z) {
        c();
        n(i2);
        boolean[] zArr = this.f1294h;
        boolean z2 = zArr[i2];
        zArr[i2] = z;
        return z2;
    }

    private f(boolean[] zArr, int i2) {
        this.f1294h = zArr;
        this.f1295i = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f1295i; i2++) {
            if (obj.equals(Boolean.valueOf(this.f1294h[i2]))) {
                boolean[] zArr = this.f1294h;
                System.arraycopy(zArr, i2 + 1, zArr, i2, (this.f1295i - i2) - 1);
                this.f1295i--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
