package com.bumptech.glide.load.engine;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Jobs.java */
/* JADX INFO: loaded from: classes.dex */
final class r {
    private final Map<com.bumptech.glide.load.f, l<?>> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.f, l<?>> f9189b = new HashMap();

    r() {
    }

    private Map<com.bumptech.glide.load.f, l<?>> b(boolean z) {
        return z ? this.f9189b : this.a;
    }

    l<?> a(com.bumptech.glide.load.f fVar, boolean z) {
        return b(z).get(fVar);
    }

    void c(com.bumptech.glide.load.f fVar, l<?> lVar) {
        b(lVar.o()).put(fVar, lVar);
    }

    void d(com.bumptech.glide.load.f fVar, l<?> lVar) {
        Map<com.bumptech.glide.load.f, l<?>> mapB = b(lVar.o());
        if (lVar.equals(mapB.get(fVar))) {
            mapB.remove(fVar);
        }
    }
}
