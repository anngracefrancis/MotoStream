package com.bumptech.glide.load.o;

import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.r.j;

/* JADX INFO: compiled from: SimpleResource.java */
/* JADX INFO: loaded from: classes.dex */
public class a<T> implements u<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final T f9348f;

    public a(T t) {
        this.f9348f = (T) j.d(t);
    }

    @Override // com.bumptech.glide.load.engine.u
    public void c() {
    }

    @Override // com.bumptech.glide.load.engine.u
    public final int d() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.u
    public Class<T> e() {
        return (Class<T>) this.f9348f.getClass();
    }

    @Override // com.bumptech.glide.load.engine.u
    public final T get() {
        return this.f9348f;
    }
}
