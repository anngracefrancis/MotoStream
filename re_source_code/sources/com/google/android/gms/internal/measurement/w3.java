package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class w3<K, V> implements Iterator<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f17278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f17279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ u3 f17280h;

    private w3(u3 u3Var) {
        this.f17280h = u3Var;
        this.f17278f = u3Var.f17264g.size();
    }

    private final Iterator<Map.Entry<K, V>> b() {
        if (this.f17279g == null) {
            this.f17279g = this.f17280h.f17268k.entrySet().iterator();
        }
        return this.f17279g;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.f17278f;
        return (i2 > 0 && i2 <= this.f17280h.f17264g.size()) || b().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (b().hasNext()) {
            return b().next();
        }
        List list = this.f17280h.f17264g;
        int i2 = this.f17278f - 1;
        this.f17278f = i2;
        return (Map.Entry) list.get(i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ w3(u3 u3Var, t3 t3Var) {
        this(u3Var);
    }
}
