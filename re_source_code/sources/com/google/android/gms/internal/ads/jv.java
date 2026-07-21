package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class jv<K> implements Iterator<Map.Entry<K, Object>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f12841f;

    public jv(Iterator<Map.Entry<K, Object>> it) {
        this.f12841f = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12841f.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f12841f.next();
        return next.getValue() instanceof zzdon ? new iv(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f12841f.remove();
    }
}
