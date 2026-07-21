package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes2.dex */
final class ww<K, V> implements Iterator<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f13524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f13525h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ ow f13526i;

    private ww(ow owVar) {
        this.f13526i = owVar;
        this.f13523f = -1;
    }

    private final Iterator<Map.Entry<K, V>> b() {
        if (this.f13525h == null) {
            this.f13525h = this.f13526i.f13122h.entrySet().iterator();
        }
        return this.f13525h;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13523f + 1 < this.f13526i.f13121g.size() || (!this.f13526i.f13122h.isEmpty() && b().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.f13524g = true;
        int i2 = this.f13523f + 1;
        this.f13523f = i2;
        return i2 < this.f13526i.f13121g.size() ? (Map.Entry) this.f13526i.f13121g.get(this.f13523f) : b().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f13524g) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f13524g = false;
        this.f13526i.k();
        if (this.f13523f >= this.f13526i.f13121g.size()) {
            b().remove();
            return;
        }
        ow owVar = this.f13526i;
        int i2 = this.f13523f;
        this.f13523f = i2 - 1;
        owVar.r(i2);
    }

    /* synthetic */ ww(ow owVar, pw pwVar) {
        this(owVar);
    }
}
