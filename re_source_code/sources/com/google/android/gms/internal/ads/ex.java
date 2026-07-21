package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
final class ex implements ListIterator<String> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ListIterator<String> f12544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ int f12545g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzdqw f12546h;

    ex(zzdqw zzdqwVar, int i2) {
        this.f12546h = zzdqwVar;
        this.f12545g = i2;
        this.f12544f = zzdqwVar.f16057f.listIterator(i2);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f12544f.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f12544f.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f12544f.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f12544f.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f12544f.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f12544f.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
