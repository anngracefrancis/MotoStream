package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class j4 implements ListIterator<String> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ListIterator<String> f17186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ int f17187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzia f17188h;

    j4(zzia zziaVar, int i2) {
        this.f17188h = zziaVar;
        this.f17187g = i2;
        this.f17186f = zziaVar.f17434f.listIterator(i2);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f17186f.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f17186f.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f17186f.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f17186f.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f17186f.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f17186f.previousIndex();
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
