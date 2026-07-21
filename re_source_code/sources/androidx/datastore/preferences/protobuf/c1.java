package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: ProtobufArrayList.java */
/* JADX INFO: loaded from: classes.dex */
final class c1<E> extends c<E> implements RandomAccess {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final c1<Object> f1273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private E[] f1274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1275i;

    static {
        c1<Object> c1Var = new c1<>(new Object[0], 0);
        f1273g = c1Var;
        c1Var.B();
    }

    private c1(E[] eArr, int i2) {
        this.f1274h = eArr;
        this.f1275i = i2;
    }

    private static <E> E[] f(int i2) {
        return (E[]) new Object[i2];
    }

    public static <E> c1<E> g() {
        return (c1<E>) f1273g;
    }

    private void h(int i2) {
        if (i2 < 0 || i2 >= this.f1275i) {
            throw new IndexOutOfBoundsException(i(i2));
        }
    }

    private String i(int i2) {
        return "Index:" + i2 + ", Size:" + this.f1275i;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        c();
        int i2 = this.f1275i;
        E[] eArr = this.f1274h;
        if (i2 == eArr.length) {
            this.f1274h = (E[]) Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f1274h;
        int i3 = this.f1275i;
        this.f1275i = i3 + 1;
        eArr2[i3] = e2;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        h(i2);
        return this.f1274h[i2];
    }

    @Override // androidx.datastore.preferences.protobuf.a0.i
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public c1<E> J(int i2) {
        if (i2 >= this.f1275i) {
            return new c1<>(Arrays.copyOf(this.f1274h, i2), this.f1275i);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i2) {
        c();
        h(i2);
        E[] eArr = this.f1274h;
        E e2 = eArr[i2];
        int i3 = this.f1275i;
        if (i2 < i3 - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (i3 - i2) - 1);
        }
        this.f1275i--;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        c();
        h(i2);
        E[] eArr = this.f1274h;
        E e3 = eArr[i2];
        eArr[i2] = e2;
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1275i;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        int i3;
        c();
        if (i2 >= 0 && i2 <= (i3 = this.f1275i)) {
            E[] eArr = this.f1274h;
            if (i3 < eArr.length) {
                System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
            } else {
                E[] eArr2 = (E[]) f(((i3 * 3) / 2) + 1);
                System.arraycopy(this.f1274h, 0, eArr2, 0, i2);
                System.arraycopy(this.f1274h, i2, eArr2, i2 + 1, this.f1275i - i2);
                this.f1274h = eArr2;
            }
            this.f1274h[i2] = e2;
            this.f1275i++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(i(i2));
    }
}
