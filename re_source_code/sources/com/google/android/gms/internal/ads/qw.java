package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes2.dex */
final class qw<K, V> implements Iterator<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f13243g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ ow f13244h;

    private qw(ow owVar) {
        this.f13244h = owVar;
        this.f13242f = owVar.f13121g.size();
    }

    private final Iterator<Map.Entry<K, V>> b() {
        if (this.f13243g == null) {
            this.f13243g = this.f13244h.f13125k.entrySet().iterator();
        }
        return this.f13243g;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.f13242f;
        return (i2 > 0 && i2 <= this.f13244h.f13121g.size()) || b().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (b().hasNext()) {
            return b().next();
        }
        List list = this.f13244h.f13121g;
        int i2 = this.f13242f - 1;
        this.f13242f = i2;
        return (Map.Entry) list.get(i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ qw(ow owVar, pw pwVar) {
        this(owVar);
    }
}
