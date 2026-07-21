package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class l4 implements Iterator<String> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Iterator<String> f17214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzia f17215g;

    l4(zzia zziaVar) {
        this.f17215g = zziaVar;
        this.f17214f = zziaVar.f17434f.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f17214f.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f17214f.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
