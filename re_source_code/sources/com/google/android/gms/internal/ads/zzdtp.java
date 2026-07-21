package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdtp<T> {
    private final List<T> a = new ArrayList(11);

    private zzdtp(int i2) {
    }

    public static <T> zzdtp<T> d(int i2) {
        return new zzdtp<>(11);
    }

    public final zzdtp<T> a(T t) {
        this.a.add((T) zzdto.b(t, "Set contributions cannot be null"));
        return this;
    }

    public final zzdtp<T> b(Collection<? extends T> collection) {
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            zzdto.b(it.next(), "Set contributions cannot be null");
        }
        this.a.addAll(collection);
        return this;
    }

    public final Set<T> c() {
        int size = this.a.size();
        if (size != 0) {
            return size != 1 ? Collections.unmodifiableSet(new HashSet(this.a)) : Collections.singleton(this.a.get(0));
        }
        return Collections.emptySet();
    }
}
