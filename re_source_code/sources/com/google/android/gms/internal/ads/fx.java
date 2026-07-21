package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class fx implements Iterator<String> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Iterator<String> f12606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzdqw f12607g;

    fx(zzdqw zzdqwVar) {
        this.f12607g = zzdqwVar;
        this.f12606f = zzdqwVar.f16057f.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12606f.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f12606f.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
