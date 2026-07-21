package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class c4<K, V> implements Iterator<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f17140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f17141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f17142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ u3 f17143i;

    private c4(u3 u3Var) {
        this.f17143i = u3Var;
        this.f17140f = -1;
    }

    private final Iterator<Map.Entry<K, V>> b() {
        if (this.f17142h == null) {
            this.f17142h = this.f17143i.f17265h.entrySet().iterator();
        }
        return this.f17142h;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f17140f + 1 < this.f17143i.f17264g.size() || (!this.f17143i.f17265h.isEmpty() && b().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.f17141g = true;
        int i2 = this.f17140f + 1;
        this.f17140f = i2;
        return i2 < this.f17143i.f17264g.size() ? (Map.Entry) this.f17143i.f17264g.get(this.f17140f) : b().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f17141g) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f17141g = false;
        this.f17143i.q();
        if (this.f17140f >= this.f17143i.f17264g.size()) {
            b().remove();
            return;
        }
        u3 u3Var = this.f17143i;
        int i2 = this.f17140f;
        this.f17140f = i2 - 1;
        u3Var.l(i2);
    }

    /* synthetic */ c4(u3 u3Var, t3 t3Var) {
        this(u3Var);
    }
}
