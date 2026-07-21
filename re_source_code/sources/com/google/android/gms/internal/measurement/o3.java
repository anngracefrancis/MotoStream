package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class o3<E> extends i1<E> implements RandomAccess {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final o3<Object> f17238g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private E[] f17239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f17240i;

    static {
        o3<Object> o3Var = new o3<>(new Object[0], 0);
        f17238g = o3Var;
        o3Var.I();
    }

    private o3(E[] eArr, int i2) {
        this.f17239h = eArr;
        this.f17240i = i2;
    }

    private final void f(int i2) {
        if (i2 < 0 || i2 >= this.f17240i) {
            throw new IndexOutOfBoundsException(g(i2));
        }
    }

    private final String g(int i2) {
        int i3 = this.f17240i;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public static <E> o3<E> h() {
        return (o3<E>) f17238g;
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e2) {
        c();
        int i2 = this.f17240i;
        E[] eArr = this.f17239h;
        if (i2 == eArr.length) {
            this.f17239h = (E[]) Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f17239h;
        int i3 = this.f17240i;
        this.f17240i = i3 + 1;
        eArr2[i3] = e2;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzfl
    public final /* synthetic */ zzfl d(int i2) {
        if (i2 >= this.f17240i) {
            return new o3(Arrays.copyOf(this.f17239h, i2), this.f17240i);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i2) {
        f(i2);
        return this.f17239h[i2];
    }

    @Override // java.util.AbstractList, java.util.List
    public final E remove(int i2) {
        c();
        f(i2);
        E[] eArr = this.f17239h;
        E e2 = eArr[i2];
        int i3 = this.f17240i;
        if (i2 < i3 - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (i3 - i2) - 1);
        }
        this.f17240i--;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i2, E e2) {
        c();
        f(i2);
        E[] eArr = this.f17239h;
        E e3 = eArr[i2];
        eArr[i2] = e2;
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f17240i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, E e2) {
        int i3;
        c();
        if (i2 >= 0 && i2 <= (i3 = this.f17240i)) {
            E[] eArr = this.f17239h;
            if (i3 < eArr.length) {
                System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
            } else {
                E[] eArr2 = (E[]) new Object[((i3 * 3) / 2) + 1];
                System.arraycopy(eArr, 0, eArr2, 0, i2);
                System.arraycopy(this.f17239h, i2, eArr2, i2 + 1, this.f17240i - i2);
                this.f17239h = eArr2;
            }
            this.f17239h[i2] = e2;
            this.f17240i++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(g(i2));
    }
}
