package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public class zzdta<E> extends AbstractList<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzdtc f16155f = zzdtc.b(zzdta.class);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    List<E> f16156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Iterator<E> f16157h;

    public zzdta(List<E> list, Iterator<E> it) {
        this.f16156g = list;
        this.f16157h = it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        if (this.f16156g.size() > i2) {
            return this.f16156g.get(i2);
        }
        if (!this.f16157h.hasNext()) {
            throw new NoSuchElementException();
        }
        this.f16156g.add(this.f16157h.next());
        return get(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new iy(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        zzdtc zzdtcVar = f16155f;
        zzdtcVar.a("potentially expensive size() call");
        zzdtcVar.a("blowup running");
        while (this.f16157h.hasNext()) {
            this.f16156g.add(this.f16157h.next());
        }
        return this.f16156g.size();
    }
}
