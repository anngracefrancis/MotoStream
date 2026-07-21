package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes2.dex */
final class iy<E> implements Iterator<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f12785f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzdta f12786g;

    iy(zzdta zzdtaVar) {
        this.f12786g = zzdtaVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12785f < this.f12786g.f16156g.size() || this.f12786g.f16157h.hasNext();
    }

    @Override // java.util.Iterator
    public final E next() {
        while (this.f12785f >= this.f12786g.f16156g.size()) {
            zzdta zzdtaVar = this.f12786g;
            zzdtaVar.f16156g.add(zzdtaVar.f16157h.next());
        }
        List<E> list = this.f12786g.f16156g;
        int i2 = this.f12785f;
        this.f12785f = i2 + 1;
        return list.get(i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
