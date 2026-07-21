package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class hw<E> extends yt<E> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw<Object> f12724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<E> f12725h;

    static {
        hw<Object> hwVar = new hw<>(new ArrayList(0));
        f12724g = hwVar;
        hwVar.x0();
    }

    private hw(List<E> list) {
        this.f12725h = list;
    }

    public static <E> hw<E> f() {
        return (hw<E>) f12724g;
    }

    @Override // com.google.android.gms.internal.ads.zzdoj
    public final /* synthetic */ zzdoj N(int i2) {
        if (i2 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i2);
        arrayList.addAll(this.f12725h);
        return new hw(arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, E e2) {
        c();
        this.f12725h.add(i2, e2);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i2) {
        return this.f12725h.get(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final E remove(int i2) {
        c();
        E eRemove = this.f12725h.remove(i2);
        ((AbstractList) this).modCount++;
        return eRemove;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i2, E e2) {
        c();
        E e3 = this.f12725h.set(i2, e2);
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12725h.size();
    }
}
